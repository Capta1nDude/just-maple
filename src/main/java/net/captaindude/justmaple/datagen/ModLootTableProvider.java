package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup.Provider;

public class ModLootTableProvider extends FabricBlockLootSubProvider {

    public ModLootTableProvider(
            FabricPackOutput dataOutput,
            CompletableFuture<Provider> registryLookup) {

        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.MAPLE_LOG);
        dropSelf(ModBlocks.MAPLE_WOOD);
        dropSelf(ModBlocks.STRIPPED_MAPLE_LOG);
        dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD);
        dropSelf(ModBlocks.MAPLE_PLANKS);
        dropSelf(ModBlocks.MAPLE_SAPLING);
        dropSelf(ModBlocks.FALLEN_MAPLE_LEAVES);

        dropSelf(ModBlocks.MAPLE_STAIRS);

        add(
                ModBlocks.MAPLE_SLAB,
                createSlabItemTable(ModBlocks.MAPLE_SLAB));

        dropSelf(ModBlocks.MAPLE_FENCE);
        dropSelf(ModBlocks.MAPLE_FENCE_GATE);

        add(
                ModBlocks.MAPLE_DOOR,
                createDoorTable(ModBlocks.MAPLE_DOOR));

        dropSelf(ModBlocks.MAPLE_TRAPDOOR);
        dropSelf(ModBlocks.MAPLE_BUTTON);
        dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE);

        add(
                ModBlocks.MAPLE_LEAVES,
                createLeavesDrops(
                        ModBlocks.MAPLE_LEAVES,
                        ModBlocks.MAPLE_SAPLING,
                        NORMAL_LEAVES_SAPLING_CHANCES));
    }
}