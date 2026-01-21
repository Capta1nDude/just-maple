package net.captaindude.justmaple.worldgen;

import java.util.List;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.ModBlocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MAPLE_PLACED_KEY =
            registerKey("maple_placed");

    public static final RegistryKey<PlacedFeature> FALLEN_MAPLE_LEAVES_PLACED_KEY =
            registerKey("fallen_maple_leaves_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

         // Maple trees (cherry-like density)
        context.register(
                MAPLE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_KEY),
                        VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                                PlacedFeatures.createCountExtraModifier(10, 0.1F, 1),
                                ModBlocks.MAPLE_SAPLING
                        )
                )
        );

        // Fallen maple leaves patches
        context.register(
    FALLEN_MAPLE_LEAVES_PLACED_KEY,
    new PlacedFeature(
        configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_MAPLE_LEAVES_PATCH_KEY),
        List.of(
            CountPlacementModifier.of(20),
            SquarePlacementModifier.of(),
            HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG),
            BiomePlacementModifier.of(),
            BlockFilterPlacementModifier.of(
                BlockPredicate.wouldSurvive(
                    ModBlocks.FALLEN_MAPLE_LEAVES.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, 1),
                    BlockPos.ORIGIN
                )
            )
        )
    )
);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(
                RegistryKeys.PLACED_FEATURE,
                Identifier.of(JustMaple.MOD_ID, name)
        );
    }
}
