package net.captaindude.justmaple.worldgen.biome;

import org.jetbrains.annotations.Nullable;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.worldgen.ModPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {
    // Creates registry key to be used later
    public static final RegistryKey<Biome> MAPLE_GROVE = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(JustMaple.MOD_ID, "maple_grove"));

    protected static final int DEFAULT_WATER_COLOR = 4159204;
    protected static final int DEFAULT_WATER_FOG_COLOR = 329011;
    private static final int DEFAULT_FOG_COLOR = 12638463;

    // Bootstrap method used when initializing registries
    public static void bootstrap(Registerable<Biome> context) {
        context.register(MAPLE_GROVE, mapleGrove(context));
    }

    public static Biome mapleGrove(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        // spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.PORCUPINE, 2, 3, 5)); // Example of custom entity spawn

        // Adds default entity spawns
        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        // Vanilla biome features
        addBasicFeatures(biomeBuilder);
        DefaultBiomeFeatures.addForestGrass(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);
      

        // Custom biome features
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MAPLE_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FALLEN_MAPLE_LEAVES_PLACED_KEY);

        // Creates biome with given settings
        return createBiome(true, 0.5f, 0.8f, spawnBuilder, biomeBuilder, MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_CHERRY_GROVE));
    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        // DefaultBiomeFeatures.addMineables(generationSettings); // CRASHES WITH FOREST GRASS
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        // DefaultBiomeFeatures.addDefaultVegetation(generationSettings); // CRASHES WITH FOREST GRASS
   }

   private static Biome createBiome(boolean precipitation, float temperature, float downfall, SpawnSettings.Builder spawnSettings, GenerationSettings.LookupBackedBuilder generationSettings, @Nullable MusicSound music) {
      return createBiome(precipitation, temperature, downfall, 4159204, 329011, (Integer)null, (Integer)null, spawnSettings, generationSettings, music);
   }

   private static Biome createBiome(boolean precipitation, float temperature, float downfall, int waterColor, int waterFogColor, @Nullable Integer grassColor, @Nullable Integer foliageColor, SpawnSettings.Builder spawnSettings, GenerationSettings.LookupBackedBuilder generationSettings, @Nullable MusicSound music) {
      BiomeEffects.Builder builder = (new BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(OverworldBiomeCreator.getSkyColor(temperature)).moodSound(BiomeMoodSound.CAVE).music(music);
      if (grassColor != null) {
         builder.grassColor(grassColor);
      }

      if (foliageColor != null) {
         builder.foliageColor(foliageColor);
      }

      return (new Biome.Builder()).precipitation(precipitation).temperature(temperature).downfall(downfall).effects(builder.build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
   }
}
