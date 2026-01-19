package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ModBlocks.MAPLE_LOG)
            .add(ModBlocks.STRIPPED_MAPLE_LOG)
            .add(ModBlocks.MAPLE_WOOD)
            .add(ModBlocks.STRIPPED_MAPLE_WOOD)
            .add(ModBlocks.MAPLE_PLANKS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .add(ModBlocks.MAPLE_LOG)
            .add(ModBlocks.STRIPPED_MAPLE_LOG)
            .add(ModBlocks.MAPLE_WOOD)
            .add(ModBlocks.STRIPPED_MAPLE_WOOD);
    }
    
}   
