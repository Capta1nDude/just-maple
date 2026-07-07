package net.captaindude.justmaple.particle;

import net.captaindude.justmaple.JustMaple;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

public class ModParticles {

    public static final SimpleParticleType MAPLE_LEAVES =
            Registry.register(
                    BuiltInRegistries.PARTICLE_TYPE,
                    Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, "maple_leaves"),
                    FabricParticleTypes.simple()
            );

    public static void registerParticles() {
        // Optional, but keeps init order explicit
        JustMaple.LOGGER.info("Registering particles for " + JustMaple.MOD_ID);
    }
}


