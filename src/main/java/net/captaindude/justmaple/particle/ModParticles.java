package net.captaindude.justmaple.particle;

import net.captaindude.justmaple.JustMaple;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType MAPLE_LEAVES =
            Registry.register(
                    Registries.PARTICLE_TYPE,
                    Identifier.of(JustMaple.MOD_ID, "maple_leaves"),
                    FabricParticleTypes.simple()
            );

    public static void registerParticles() {
        // Optional, but keeps init order explicit
        JustMaple.LOGGER.info("Registering particles for " + JustMaple.MOD_ID);
    }
}


