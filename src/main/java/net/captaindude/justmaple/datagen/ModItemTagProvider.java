package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.captaindude.justmaple.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    // Generates item tags
    @Override
    protected void addTags(Provider wrapperLookup) {
        // Items that can be transformed via the Magic Block into diamonds
        builder(ItemTags.LOGS_THAT_BURN)
            .addTag(ModItemTags.MAPLE_LOGS);

        builder(ItemTags.PLANKS)
            .add(key(ModBlocks.MAPLE_PLANKS.asItem()));

        builder(ModItemTags.MAPLE_LOGS)
            .add(key(ModBlocks.MAPLE_LOG.asItem()))
            .add(key(ModBlocks.STRIPPED_MAPLE_LOG.asItem()))
            .add(key(ModBlocks.MAPLE_WOOD.asItem()))
            .add(key(ModBlocks.STRIPPED_MAPLE_WOOD.asItem()));
    }

    private static ResourceKey<Item> key(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }
    

}
