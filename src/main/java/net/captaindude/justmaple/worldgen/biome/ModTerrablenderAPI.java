package net.captaindude.justmaple.worldgen.biome;

import net.captaindude.justmaple.JustMaple;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi{

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(JustMaple.MOD_ID, "overworld"), 4));
    }

}
