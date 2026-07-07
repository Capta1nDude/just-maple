package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.BlockTags;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(Provider wrapperLookup) {
        
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
            .add(ModBlocks.MAPLE_LOG)
            .add(ModBlocks.STRIPPED_MAPLE_LOG)
            .add(ModBlocks.MAPLE_WOOD)
            .add(ModBlocks.STRIPPED_MAPLE_WOOD)
            .add(ModBlocks.MAPLE_PLANKS);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
            .add(ModBlocks.MAPLE_LOG)
            .add(ModBlocks.STRIPPED_MAPLE_LOG)
            .add(ModBlocks.MAPLE_WOOD)
            .add(ModBlocks.STRIPPED_MAPLE_WOOD);

        // Adds some tags for block functionality
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE);
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR);
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON);
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE);
        valueLookupBuilder(BlockTags.PLANKS).add(ModBlocks.MAPLE_PLANKS);
        valueLookupBuilder(BlockTags.SAPLINGS).add(ModBlocks.MAPLE_SAPLING);
    }
    
}   
