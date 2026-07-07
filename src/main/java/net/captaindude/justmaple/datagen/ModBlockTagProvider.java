package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    private static final TagKey<Block> SAPLINGS = TagKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath("minecraft", "saplings"));

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(Provider wrapperLookup) {
        
        builder(BlockTags.MINEABLE_WITH_AXE)
            .add(key(ModBlocks.MAPLE_LOG))
            .add(key(ModBlocks.STRIPPED_MAPLE_LOG))
            .add(key(ModBlocks.MAPLE_WOOD))
            .add(key(ModBlocks.STRIPPED_MAPLE_WOOD))
            .add(key(ModBlocks.MAPLE_PLANKS));

        builder(BlockTags.OVERWORLD_NATURAL_LOGS)
            .add(key(ModBlocks.MAPLE_LOG))
            .add(key(ModBlocks.STRIPPED_MAPLE_LOG))
            .add(key(ModBlocks.MAPLE_WOOD))
            .add(key(ModBlocks.STRIPPED_MAPLE_WOOD));

        // Adds some tags for block functionality
        builder(BlockTags.WOODEN_FENCES).add(key(ModBlocks.MAPLE_FENCE));
        builder(BlockTags.FENCE_GATES).add(key(ModBlocks.MAPLE_FENCE_GATE));
        builder(BlockTags.WOODEN_DOORS).add(key(ModBlocks.MAPLE_DOOR));
        builder(BlockTags.WOODEN_TRAPDOORS).add(key(ModBlocks.MAPLE_TRAPDOOR));
        builder(BlockTags.WOODEN_BUTTONS).add(key(ModBlocks.MAPLE_BUTTON));
        builder(BlockTags.WOODEN_PRESSURE_PLATES).add(key(ModBlocks.MAPLE_PRESSURE_PLATE));
        builder(BlockTags.PLANKS).add(key(ModBlocks.MAPLE_PLANKS));
        builder(SAPLINGS).add(key(ModBlocks.MAPLE_SAPLING));
    }

    private static ResourceKey<Block> key(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }
    
}   
