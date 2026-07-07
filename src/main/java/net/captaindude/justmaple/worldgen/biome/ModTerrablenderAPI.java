package net.captaindude.justmaple.worldgen.biome;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.worldgen.biome.surface.ModMaterialRules;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(
                new ModOverworldRegion(
                        Identifier.fromNamespaceAndPath(
                                JustMaple.MOD_ID,
                                "overworld"),
                        10));

        SurfaceRuleManager.addSurfaceRules(
                SurfaceRuleManager.RuleCategory.OVERWORLD,
                JustMaple.MOD_ID,
                biomes -> ModMaterialRules.makeRules());
    }
}
