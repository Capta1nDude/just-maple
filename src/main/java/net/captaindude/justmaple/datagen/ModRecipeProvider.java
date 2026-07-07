package net.captaindude.justmaple.datagen;

import java.util.concurrent.CompletableFuture;

import net.captaindude.justmaple.blocks.ModBlocks;
import net.captaindude.justmaple.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "Just Maple Recipes";
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                createDoorRecipe(ModBlocks.MAPLE_DOOR, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                createTrapdoorRecipe(ModBlocks.MAPLE_TRAPDOOR, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                createFenceRecipe(ModBlocks.MAPLE_FENCE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                createFenceGateRecipe(ModBlocks.MAPLE_FENCE_GATE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                createStairsRecipe(ModBlocks.MAPLE_STAIRS, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB, ModBlocks.MAPLE_PLANKS);

                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.MAPLE_PRESSURE_PLATE,
                        Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                offerPlanksRecipe(ModBlocks.MAPLE_PLANKS, ModItemTags.MAPLE_LOGS, 4);

                createShapeless(RecipeCategory.REDSTONE, ModBlocks.MAPLE_BUTTON)
                    .input(ModBlocks.MAPLE_PLANKS)
                    .criterion(hasItem(ModBlocks.MAPLE_PLANKS), conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_WOOD)
                    .pattern("##")
                    .pattern("##")
                    .input('#', ModBlocks.MAPLE_LOG)
                    .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAPLE_WOOD)
                    .pattern("##")
                    .pattern("##")
                    .input('#', ModBlocks.STRIPPED_MAPLE_LOG)
                    .criterion(hasItem(ModBlocks.STRIPPED_MAPLE_LOG), conditionsFromItem(ModBlocks.STRIPPED_MAPLE_LOG))
                    .offerTo(exporter);
            }
        };
    }

}
