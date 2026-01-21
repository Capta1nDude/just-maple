package net.captaindude.justmaple.worldgen;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;

public class ModConfiguredFeatures {
    // Configured Feature -> Placed Feature -> Worldgen / Biome modification
    // A feature is something spawned in the world
    // This class creates configured features e.g. 12 ores in a vein
    // ModPlacedFeatures is where the actual worldgen happens e.g. What Y level is the ore veins placed at
    // Biome modifications says which biomes the ores spawn in

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_MAPLE_LEAVES_PATCH_KEY = registerKey("fallen_maple_leaves_patch");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        // Registers maple configured feature
        register(context, MAPLE_KEY, Feature.TREE, maple().build());
        register(context, FALLEN_MAPLE_LEAVES_PATCH_KEY, Feature.RANDOM_PATCH, createFlowerbedRandomPatchFeatureConfig(ModBlocks.FALLEN_MAPLE_LEAVES,32));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(JustMaple.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
		Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config
	) {
		registerable.register(key, new ConfiguredFeature(feature, config));
	}

    // Defines the maple tree - copied from cherry tree
    private static TreeFeatureConfig.Builder maple() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.MAPLE_LOG),
            new CherryTrunkPlacer(7, 1, 0, new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1)
            .add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()), UniformIntProvider.create(2, 4),
            UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0),
            ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }

    private static RandomPatchFeatureConfig createFlowerbedRandomPatchFeatureConfig(Block block,int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(
            tries,
            PlacedFeatures.createEntry(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(
                    new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                            .add(block.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, 1), 4)
                            .add(block.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, 2), 3)
                            .add(block.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, 3), 2)
                            .add(block.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, 4), 1)
                            .build()
                    )
                )
            )
        );
    }

}
