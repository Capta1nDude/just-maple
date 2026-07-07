package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.captaindude.justmaple.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.ItemTags;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    // Generates item tags
    @Override
    protected void addTags(Provider wrapperLookup) {
        // Items that can be transformed via the Magic Block into diamonds
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
            .addTag(ModItemTags.MAPLE_LOGS);

        valueLookupBuilder(ItemTags.PLANKS)
            .add(ModBlocks.MAPLE_PLANKS.asItem());

        valueLookupBuilder(ModItemTags.MAPLE_LOGS)
            .add(ModBlocks.MAPLE_LOG.asItem())
            .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
            .add(ModBlocks.MAPLE_WOOD.asItem())
            .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());
    }
    

}
