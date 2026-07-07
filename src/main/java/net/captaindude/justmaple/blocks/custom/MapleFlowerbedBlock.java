package net.captaindude.justmaple.blocks.custom;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MapleFlowerbedBlock extends PlantBlock {
    public static final MapCodec<MapleFlowerbedBlock> CODEC = createCodec(MapleFlowerbedBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty FLOWER_AMOUNT = Properties.FLOWER_AMOUNT;
    private static final VoxelShape[] SHAPES = new VoxelShape[] {
        Block.createCuboidShape(1.0D, 0.0D, 1.0D, 8.0D, 3.0D, 8.0D),
        Block.createCuboidShape(1.0D, 0.0D, 1.0D, 12.0D, 3.0D, 12.0D),
        Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)
    };

    public MapleFlowerbedBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
            .with(HORIZONTAL_FACING, Direction.NORTH)
            .with(FLOWER_AMOUNT, 1));
    }

    @Override
    protected MapCodec<MapleFlowerbedBlock> getCodec() {
        return CODEC;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(HORIZONTAL_FACING, rotation.rotate(state.get(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(HORIZONTAL_FACING)));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction()
            && context.getStack().isOf(this.asItem())
            && state.get(FLOWER_AMOUNT) < 4
            || super.canReplace(state, context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, net.minecraft.block.ShapeContext context) {
        return SHAPES[state.get(FLOWER_AMOUNT) - 1];
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.with(FLOWER_AMOUNT, Math.min(4, blockState.get(FLOWER_AMOUNT) + 1));
        }

        return this.getDefaultState().with(HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, FLOWER_AMOUNT);
    }
}
