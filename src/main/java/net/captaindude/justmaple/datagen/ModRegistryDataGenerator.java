package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup.Provider;

// Generates dynamic registries
public class ModRegistryDataGenerator extends FabricDynamicRegistryProvider{

    public ModRegistryDataGenerator(FabricPackOutput output, CompletableFuture<Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "";
    }

    // Adds trim materials and trim patterns to dynamic registries
    @Override
    protected void configure(Provider registries, Entries entries) {
        
        
    }
       
}
