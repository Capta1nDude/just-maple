package net.captaindude.justmaple.datagen;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider{

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool maplePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);

        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG).log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG).log(ModBlocks.STRIPPED_MAPLE_LOG).wood(ModBlocks.STRIPPED_MAPLE_WOOD);
        blockStateModelGenerator.registerTintableCross(ModBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSingleton(ModBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerFlowerbed(ModBlocks.FALLEN_MAPLE_LEAVES);

        maplePool.stairs(ModBlocks.MAPLE_STAIRS);
        maplePool.slab(ModBlocks.MAPLE_SLAB);
        maplePool.fence(ModBlocks.MAPLE_FENCE);
        maplePool.fenceGate(ModBlocks.MAPLE_FENCE_GATE);
        maplePool.wall(ModBlocks.MAPLE_WALL);
        maplePool.button(ModBlocks.MAPLE_BUTTON);
        maplePool.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAPLE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // itemModelGenerator.register(ModBlocks.FALLEN_MAPLE_LEAVES.asItem(), Models.GENERATED);
    }

}
