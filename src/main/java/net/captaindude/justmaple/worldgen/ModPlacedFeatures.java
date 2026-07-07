package net.captaindude.justmaple.worldgen;

import java.util.List;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

public final class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple_placed");

    public static final ResourceKey<PlacedFeature> FALLEN_MAPLE_LEAVES_PLACED_KEY = registerKey(
            "fallen_maple_leaves_placed");

    private ModPlacedFeatures() {
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Maple trees
        context.register(
                MAPLE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(
                                ModConfiguredFeatures.MAPLE_KEY),
                        VegetationPlacements.treePlacement(
                                PlacementUtils.countExtra(
                                        10,
                                        0.1F,
                                        1),
                                ModBlocks.MAPLE_SAPLING)));

        // Fallen maple leaves
        context.register(
            FALLEN_MAPLE_LEAVES_PLACED_KEY,
            new PlacedFeature(
                configuredFeatures.getOrThrow(
                    ModConfiguredFeatures.FALLEN_MAPLE_LEAVES_PATCH_KEY),
                        List.of(
                                CountPlacement.of(20),

                                InSquarePlacement.spread(),

                                HeightmapPlacement.onHeightmap(
                                        Heightmap.Types.WORLD_SURFACE_WG),

                                CountPlacement.of(32),

                                RandomOffsetPlacement.ofTriangle(7, 3),

                                BlockPredicateFilter.forPredicate(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE),

                                BlockPredicateFilter.forPredicate(
                                        BlockPredicate.wouldSurvive(
                                                ModBlocks.FALLEN_MAPLE_LEAVES
                                                        .defaultBlockState()
                                                        .setValue(
                                                                BlockStateProperties.FLOWER_AMOUNT,
                                                                1),
                                                BlockPos.ZERO)),

                                BiomeFilter.biome())
            )
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(
                Registries.PLACED_FEATURE,
                Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, name));
    }
}