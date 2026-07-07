package net.captaindude.justmaple.particle.custom;

import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.random.Random;

public class MapleLeavesParticle extends LeavesParticle {
    public MapleLeavesParticle(
            ClientWorld world,
            double x, double y, double z,
            SpriteProvider spriteProvider,
            Random random
    ) {
        super(world, x, y, z, spriteProvider.getSprite(random), 0.25F, 2.0F, false, true, 1.0F, 0.0F);
    }
}
