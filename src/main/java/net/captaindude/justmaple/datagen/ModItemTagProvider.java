package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.captaindude.justmaple.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    // Generates item tags
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Items that can be transformed via the Magic Block into diamonds
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
            .addTag(ModItemTags.MAPLE_LOGS);

        getOrCreateTagBuilder(ItemTags.PLANKS)
            .add(ModBlocks.MAPLE_PLANKS.asItem());

        getOrCreateTagBuilder(ModItemTags.MAPLE_LOGS)
            .add(ModBlocks.MAPLE_LOG.asItem())
            .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
            .add(ModBlocks.MAPLE_WOOD.asItem())
            .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());
    }
    

}
