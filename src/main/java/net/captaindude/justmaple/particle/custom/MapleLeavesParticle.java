package net.captaindude.justmaple.particle.custom;

import net.minecraft.client.particle.CherryLeavesParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

public class MapleLeavesParticle extends CherryLeavesParticle {
    public MapleLeavesParticle(
            ClientWorld world,
            double x, double y, double z,
            SpriteProvider spriteProvider
    ) {
        super(world, x, y, z, spriteProvider);
    }
}
