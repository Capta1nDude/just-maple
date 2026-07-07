package net.captaindude.justmaple.particle.custom;

import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.RandomSource;

public class MapleLeavesParticle extends FallingLeavesParticle {
    public MapleLeavesParticle(
            ClientLevel world,
            double x, double y, double z,
            SpriteSet spriteProvider,
            RandomSource random
    ) {
        super(world, x, y, z, spriteProvider.get(random), 0.25F, 2.0F, false, true, 1.0F, 0.0F);
    }
}
