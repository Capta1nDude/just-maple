package net.captaindude.justmaple;


import net.captaindude.justmaple.particle.ModParticles;
import net.captaindude.justmaple.particle.custom.MapleLeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;

public class JustMapleClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		// BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_SAPLING, ChunkSectionLayer.CUTOUT);
		// BlockRenderLayerMap.putBlock(ModBlocks.FALLEN_MAPLE_LEAVES, ChunkSectionLayer.CUTOUT);
		// BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_DOOR, ChunkSectionLayer.CUTOUT);
		// BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_TRAPDOOR, ChunkSectionLayer.CUTOUT);
		// RENDER LAYER REGISTRATION NO LONGER NEEDED

		// Registers maple leaves particle
		ParticleProviderRegistry.getInstance().register(
			ModParticles.MAPLE_LEAVES,
			sprites -> (type, world, x, y, z, vx, vy, vz, random) -> new MapleLeavesParticle(world, x, y, z, sprites, random)
		);
	}
}
