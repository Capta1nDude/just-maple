package net.captaindude.justmaple.worldgen.biome;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.worldgen.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi{

    // Just creates an overworld 'region' to add custom biomes to overworld generation
    // Actual biome adding is done in ModOverworldRegion
    // DOES NOT RECREATE THE VANILLA OVERWORLD
    // Sometimes this region will be loaded in which case below applies
    // Other times not - weight arg changes the chance of loading
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(JustMaple.MOD_ID, "overworld"), 10));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, JustMaple.MOD_ID, ModMaterialRules.makeRules());
    }

}
