package net.captaindude.justmaple.blocks.custom;

import com.mojang.serialization.MapCodec;

import net.captaindude.justmaple.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MapleLeavesBlock extends LeavesBlock {
    public static final MapCodec<MapleLeavesBlock> CODEC = simpleCodec(MapleLeavesBlock::new);
    private static final float LEAF_PARTICLE_CHANCE = 0.1F;

    public MapleLeavesBlock(BlockBehaviour.Properties settings) {
        this(LEAF_PARTICLE_CHANCE, settings);
    }

    public MapleLeavesBlock(float leafParticleChance, BlockBehaviour.Properties settings) {
        super(leafParticleChance, settings);
    }

    @Override
    public MapCodec<MapleLeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level world, BlockPos pos, RandomSource random) {
        BlockPos blockPos = pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        if (!Block.isFaceFull(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
            ParticleUtils.spawnParticleBelow(world, pos, random, ModParticles.MAPLE_LEAVES);
        }
    }
}
