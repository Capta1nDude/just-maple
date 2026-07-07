package net.captaindude.justmaple.worldgen.biome;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class ModBiomes {

    public static final ResourceKey<Biome> MAPLE_GROVE = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, "maple_grove"));

    private static final int DEFAULT_WATER_COLOR = 4159204;
    private static final int DEFAULT_WATER_FOG_COLOR = 329011;

    private ModBiomes() {
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(
                MAPLE_GROVE,
                mapleGrove(placedFeatureGetter, carverGetter));
    }

    private static Biome mapleGrove(
            HolderGetter<PlacedFeature> placedFeatureGetter,
            HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(
                placedFeatureGetter,
                carverGetter);

        addBasicFeatures(biomeBuilder);

        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.MAPLE_PLACED_KEY);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.FALLEN_MAPLE_LEAVES_PLACED_KEY);

        float temperature = 0.5F;

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(0.8F)
                .setAttribute(
                        EnvironmentAttributes.SKY_COLOR,
                        calculateSkyColor(temperature))
                .setAttribute(
                        EnvironmentAttributes.WATER_FOG_COLOR,
                        DEFAULT_WATER_FOG_COLOR)
                .setAttribute(
                        EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(
                                SoundEvents.MUSIC_BIOME_CHERRY_GROVE))
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(DEFAULT_WATER_COLOR)
                                .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static void addBasicFeatures(
            BiomeGenerationSettings.Builder generationSettings) {

        BiomeDefaultFeatures.addDefaultCarversAndLakes(
                generationSettings);

        BiomeDefaultFeatures.addDefaultCrystalFormations(
                generationSettings);

        BiomeDefaultFeatures.addDefaultMonsterRoom(
                generationSettings);

        BiomeDefaultFeatures.addDefaultSprings(
                generationSettings);

        BiomeDefaultFeatures.addSurfaceFreezing(
                generationSettings);

        BiomeDefaultFeatures.addDefaultOres(
                generationSettings);
    }

    private static int calculateSkyColor(float temperature) {
        float value = temperature / 3.0F;
        value = Mth.clamp(value, -1.0F, 1.0F);

        return Mth.hsvToRgb(
                0.62222224F - value * 0.05F,
                0.5F + value * 0.1F,
                1.0F);
    }
}