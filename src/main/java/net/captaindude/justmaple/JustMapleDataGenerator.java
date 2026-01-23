package net.captaindude.justmaple;

import net.captaindude.justmaple.datagen.ModBlockTagProvider;
import net.captaindude.justmaple.datagen.ModItemTagProvider;
import net.captaindude.justmaple.datagen.ModLootTableProvider;
import net.captaindude.justmaple.datagen.ModModelProvider;
import net.captaindude.justmaple.datagen.ModRecipeProvider;
import net.captaindude.justmaple.datagen.ModRegistryDataGenerator;
import net.captaindude.justmaple.datagen.ModWorldGenerator;
import net.captaindude.justmaple.worldgen.ModConfiguredFeatures;
import net.captaindude.justmaple.worldgen.ModPlacedFeatures;
import net.captaindude.justmaple.worldgen.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JustMapleDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		// Adds providers for each provider class
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
	}
}
