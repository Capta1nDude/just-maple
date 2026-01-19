package net.captaindude.justmaple.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MapleLeavesBlock extends LeavesBlock {

    public MapleLeavesBlock(Settings settings) {
        super(settings);
    }

    // Drops maple leaf particles
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) { 
        // Carries over any vanilla leaf logic e.g. rain drops
        super.randomDisplayTick(state, world, pos, random);
        // if (random.nextInt(10) == 0) {
        //     BlockPos blockPos = pos.down();
        //     BlockState blockState = world.getBlockState(blockPos);
        //     if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
        //         ParticleUtil.spawnParticle(world, pos, random, ModParticles.MAPLE_LEAVES);
        //     }
        // }
    }

}
