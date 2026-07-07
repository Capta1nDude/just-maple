package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.captaindude.justmaple.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(
            FabricPackOutput output,
            CompletableFuture<Provider> registriesFuture) {

        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "Just Maple Recipes";
    }

    @Override
    protected RecipeProvider createRecipeProvider(
            Provider registryLookup,
            RecipeOutput exporter) {

        return new RecipeProvider(registryLookup, exporter) {

            @Override
            public void buildRecipes() {

                // Maple door
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_DOOR, 3)
                        .pattern("##")
                        .pattern("##")
                        .pattern("##")
                        .define('#', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple trapdoor
                shaped(RecipeCategory.REDSTONE, ModBlocks.MAPLE_TRAPDOOR, 2)
                        .pattern("###")
                        .pattern("###")
                        .define('#', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple fence
                shaped(RecipeCategory.DECORATIONS, ModBlocks.MAPLE_FENCE, 3)
                        .pattern("W#W")
                        .pattern("W#W")
                        .define('W', ModBlocks.MAPLE_PLANKS)
                        .define('#', Items.STICK)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple fence gate
                shaped(RecipeCategory.REDSTONE, ModBlocks.MAPLE_FENCE_GATE)
                        .pattern("#W#")
                        .pattern("#W#")
                        .define('W', ModBlocks.MAPLE_PLANKS)
                        .define('#', Items.STICK)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple stairs
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_STAIRS, 4)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .define('#', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple slab
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB, 6)
                        .pattern("###")
                        .define('#', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple pressure plate
                shaped(RecipeCategory.REDSTONE, ModBlocks.MAPLE_PRESSURE_PLATE)
                        .pattern("##")
                        .define('#', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple planks
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_PLANKS, 4)
                        .requires(ModItemTags.MAPLE_LOGS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_LOG),
                                has(ModBlocks.MAPLE_LOG))
                        .save(output);

                // Maple button
                shapeless(RecipeCategory.REDSTONE, ModBlocks.MAPLE_BUTTON)
                        .requires(ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_PLANKS),
                                has(ModBlocks.MAPLE_PLANKS))
                        .save(output);

                // Maple wood
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_WOOD)
                        .pattern("##")
                        .pattern("##")
                        .define('#', ModBlocks.MAPLE_LOG)
                        .unlockedBy(
                                getHasName(ModBlocks.MAPLE_LOG),
                                has(ModBlocks.MAPLE_LOG))
                        .save(output);

                // Stripped maple wood
                shaped(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.STRIPPED_MAPLE_WOOD)
                        .pattern("##")
                        .pattern("##")
                        .define('#', ModBlocks.STRIPPED_MAPLE_LOG)
                        .unlockedBy(
                                getHasName(ModBlocks.STRIPPED_MAPLE_LOG),
                                has(ModBlocks.STRIPPED_MAPLE_LOG))
                        .save(output);
            }
        };
    }
}