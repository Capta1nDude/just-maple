package net.captaindude.justmaple.worldgen.tree;

import java.util.Optional;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.worldgen.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

public class ModSaplingGenerators {
    // Adds maple sapling generator so that maple sapling can grow into maple trees
    public static final SaplingGenerator MAPLE = new SaplingGenerator(JustMaple.MOD_ID + ":maple",
        Optional.empty(), Optional.of(ModConfiguredFeatures.MAPLE_KEY), Optional.empty());
}
