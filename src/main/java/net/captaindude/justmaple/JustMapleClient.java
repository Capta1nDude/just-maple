package net.captaindude.justmaple;


import net.captaindude.justmaple.blocks.ModBlocks;
import net.captaindude.justmaple.particle.ModParticles;
import net.captaindude.justmaple.particle.custom.MapleLeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;

public class JustMapleClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FALLEN_MAPLE_LEAVES, RenderLayer.getCutout());
		
		// Registers maple leaves particle
		ParticleFactoryRegistry.getInstance().register(
			ModParticles.MAPLE_LEAVES,
			sprites -> (type, world, x, y, z, vx, vy, vz) -> new MapleLeavesParticle(world, x, y, z, sprites)
		);
	}
}