package net.captaindude.justmaple.datagen;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TexturedModel;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        BlockModelGenerators.BlockFamilyProvider mapleFamily = blockModelGenerators.family(ModBlocks.MAPLE_PLANKS);

        blockModelGenerators.woodProvider(ModBlocks.MAPLE_LOG)
                .log(ModBlocks.MAPLE_LOG)
                .wood(ModBlocks.MAPLE_WOOD);

        blockModelGenerators.woodProvider(ModBlocks.STRIPPED_MAPLE_LOG)
                .log(ModBlocks.STRIPPED_MAPLE_LOG)
                .wood(ModBlocks.STRIPPED_MAPLE_WOOD);

        blockModelGenerators.createCrossBlockWithDefaultItem(
                ModBlocks.MAPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED);

        blockModelGenerators.createTrivialBlock(
                ModBlocks.MAPLE_LEAVES,
                TexturedModel.LEAVES);

        blockModelGenerators.createFlowerBed(ModBlocks.FALLEN_MAPLE_LEAVES);

        mapleFamily.stairs(ModBlocks.MAPLE_STAIRS);
        mapleFamily.slab(ModBlocks.MAPLE_SLAB);
        mapleFamily.fence(ModBlocks.MAPLE_FENCE);
        mapleFamily.fenceGate(ModBlocks.MAPLE_FENCE_GATE);
        mapleFamily.button(ModBlocks.MAPLE_BUTTON);
        mapleFamily.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);

        blockModelGenerators.createDoor(ModBlocks.MAPLE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.MAPLE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    }
}