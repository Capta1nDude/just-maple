package net.captaindude.justmaple.blocks.custom;

import com.mojang.serialization.MapCodec;

import net.captaindude.justmaple.particle.ModParticles;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MapleLeavesBlock extends LeavesBlock {
    public static final MapCodec<MapleLeavesBlock> CODEC = createCodec(MapleLeavesBlock::new);
    private static final float LEAF_PARTICLE_CHANCE = 0.1F;

    public MapleLeavesBlock(AbstractBlock.Settings settings) {
        this(LEAF_PARTICLE_CHANCE, settings);
    }

    public MapleLeavesBlock(float leafParticleChance, AbstractBlock.Settings settings) {
        super(leafParticleChance, settings);
    }

    @Override
    public MapCodec<MapleLeavesBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void spawnLeafParticle(World world, BlockPos pos, Random random) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
            ParticleUtil.spawnParticle(world, pos, random, ModParticles.MAPLE_LEAVES);
        }
    }
}
