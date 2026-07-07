package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;

public class ModWorldGenerator extends FabricDynamicRegistryProvider {

    public ModWorldGenerator(
            FabricPackOutput output,
            CompletableFuture<Provider> registriesFuture) {

        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "Just Maple World Generation";
    }

    @Override
    protected void configure(Provider registries, Entries entries) {
        entries.addAll(
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));

        entries.addAll(
                registries.lookupOrThrow(Registries.PLACED_FEATURE));

        entries.addAll(
                registries.lookupOrThrow(Registries.BIOME));
    }
}