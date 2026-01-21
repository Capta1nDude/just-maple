package net.captaindude.justmaple.worldgen.gen;

import net.captaindude.justmaple.JustMaple;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        JustMaple.LOGGER.info("Registering World Generation for " + JustMaple.MOD_ID);
    }

    public static void bootstrap() {
        // // Add maple trees to selected biomes (temporary: everywhere overworld)
        // BiomeModifications.addFeature(
        //         BiomeSelectors.foundInOverworld(),
        //         GenerationStep.Feature.VEGETAL_DECORATION,
        //         ModPlacedFeatures.MAPLE_PLACED_KEY
        // );

        // Add fallen maple leaves patches
        // BiomeModifications.addFeature(
        //         BiomeSelectors.foundInOverworld(),
        //         GenerationStep.Feature.VEGETAL_DECORATION,
        //         ModPlacedFeatures.FALLEN_MAPLE_LEAVES_PLACED_KEY
        // );
        
    }
}
