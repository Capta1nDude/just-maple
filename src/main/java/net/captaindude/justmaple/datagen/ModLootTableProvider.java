package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class ModLootTableProvider extends FabricBlockLootTableProvider{

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    
    // Generates loot tables for blocks
    @Override
    public void generate() {
        addDrop(ModBlocks.MAPLE_LOG);
        addDrop(ModBlocks.MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_MAPLE_WOOD);
        addDrop(ModBlocks.MAPLE_PLANKS);
        addDrop(ModBlocks.MAPLE_SAPLING);

        addDrop(ModBlocks.MAPLE_STAIRS);
        addDrop(ModBlocks.MAPLE_SLAB, slabDrops(ModBlocks.MAPLE_SLAB));
        addDrop(ModBlocks.MAPLE_FENCE);
        addDrop(ModBlocks.MAPLE_FENCE_GATE);
        addDrop(ModBlocks.MAPLE_WALL);
        addDrop(ModBlocks.MAPLE_DOOR, doorDrops(ModBlocks.MAPLE_DOOR));
        addDrop(ModBlocks.MAPLE_TRAPDOOR);
        addDrop(ModBlocks.MAPLE_BUTTON);
        addDrop(ModBlocks.MAPLE_PRESSURE_PLATE);

        addDrop(ModBlocks.MAPLE_LEAVES, leavesDrops(ModBlocks.MAPLE_LEAVES, ModBlocks.MAPLE_SAPLING, SAPLING_DROP_CHANCE));
    }
}
