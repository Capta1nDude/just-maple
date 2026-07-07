package net.captaindude.justmaple.particle.custom;

import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

public class MapleLeavesParticle extends LeavesParticle {
    public MapleLeavesParticle(
            ClientWorld world,
            double x, double y, double z,
            SpriteProvider spriteProvider
    ) {
        super(world, x, y, z, spriteProvider, 0.25F, 2.0F, false, true, 1.0F, 0.0F);
    }
}
