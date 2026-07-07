package net.captaindude.justmaple.blocks.custom;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MapleFlowerbedBlock extends VegetationBlock {
    public static final MapCodec<MapleFlowerbedBlock> CODEC = simpleCodec(MapleFlowerbedBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty FLOWER_AMOUNT = BlockStateProperties.FLOWER_AMOUNT;
    private static final VoxelShape[] SHAPES = new VoxelShape[] {
        Block.box(1.0D, 0.0D, 1.0D, 8.0D, 3.0D, 8.0D),
        Block.box(1.0D, 0.0D, 1.0D, 12.0D, 3.0D, 12.0D),
        Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)
    };

    public MapleFlowerbedBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(HORIZONTAL_FACING, Direction.NORTH)
            .setValue(FLOWER_AMOUNT, 1));
    }

    @Override
    protected MapCodec<MapleFlowerbedBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(HORIZONTAL_FACING, rotation.rotate(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive()
            && context.getItemInHand().is(this.asItem())
            && state.getValue(FLOWER_AMOUNT) < 4
            || super.canBeReplaced(state, context);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(FLOWER_AMOUNT) - 1];
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(FLOWER_AMOUNT, Math.min(4, blockState.getValue(FLOWER_AMOUNT) + 1));
        }

        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, FLOWER_AMOUNT);
    }
}
