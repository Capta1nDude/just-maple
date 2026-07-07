package net.captaindude.justmaple.worldgen;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;

public final class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_MAPLE_LEAVES_PATCH_KEY = registerKey(
            "fallen_maple_leaves_patch");

    private ModConfiguredFeatures() {
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(
                context,
                MAPLE_KEY,
                Feature.TREE,
                maple(context.lookup(Registries.BIOME)).build());

        register(
                context,
                FALLEN_MAPLE_LEAVES_PATCH_KEY,
                Feature.SIMPLE_BLOCK,
                createFlowerbedSimpleBlockConfiguration(
                        ModBlocks.FALLEN_MAPLE_LEAVES));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC config) {

        context.register(
                key,
                new ConfiguredFeature<>(feature, config));
    }

    private static TreeConfiguration.TreeConfigurationBuilder maple(HolderGetter<Biome> biomes) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG),

                new CherryTrunkPlacer(
                        7,
                        1,
                        0,

                        new WeightedListInt(
                                WeightedList.<IntProvider>builder()
                                        .add(ConstantInt.of(1), 1)
                                        .add(ConstantInt.of(2), 1)
                                        .add(ConstantInt.of(3), 1)
                                        .build()),

                        UniformInt.of(2, 4),
                        UniformInt.of(-4, -3),
                        UniformInt.of(-1, 0)),

                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES),

                new CherryFoliagePlacer(
                        ConstantInt.of(4),
                        ConstantInt.of(0),
                        ConstantInt.of(5),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F),

                new TwoLayersFeatureSize(1, 0, 2),

                TreeConfiguration.defaultPlaceBelowTreeTrunkProvider(biomes)).ignoreVines();
    }

    private static SimpleBlockConfiguration createFlowerbedSimpleBlockConfiguration(
        Block block) {

    WeightedList<BlockState> states =
            WeightedList.<BlockState>builder()
                    .add(
                            block.defaultBlockState().setValue(
                                    BlockStateProperties.FLOWER_AMOUNT,
                                    1
                            ),
                            4
                    )
                    .add(
                            block.defaultBlockState().setValue(
                                    BlockStateProperties.FLOWER_AMOUNT,
                                    2
                            ),
                            3
                    )
                    .add(
                            block.defaultBlockState().setValue(
                                    BlockStateProperties.FLOWER_AMOUNT,
                                    3
                            ),
                            2
                    )
                    .add(
                            block.defaultBlockState().setValue(
                                    BlockStateProperties.FLOWER_AMOUNT,
                                    4
                            ),
                            1
                    )
                    .build();

    return new SimpleBlockConfiguration(
            new WeightedStateProvider(states)
    );
}
}
