package net.captaindude.justmaple.item;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class ModItemGroups {
    public static void registerItemGroups() {
        JustMaple.LOGGER.info("Registering Item Groups for " + JustMaple.MOD_ID);

        // Adds pedestal to building block group
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register(entries -> {
                entries.accept(ModBlocks.MAPLE_LOG);
                entries.accept(ModBlocks.MAPLE_SAPLING);
                entries.accept(ModBlocks.MAPLE_PLANKS);
                entries.accept(ModBlocks.MAPLE_WOOD);
                entries.accept(ModBlocks.STRIPPED_MAPLE_LOG);
                entries.accept(ModBlocks.STRIPPED_MAPLE_WOOD);

                entries.accept(ModBlocks.MAPLE_STAIRS);
                entries.accept(ModBlocks.MAPLE_SLAB);
                entries.accept(ModBlocks.MAPLE_FENCE);
                entries.accept(ModBlocks.MAPLE_FENCE_GATE);
                entries.accept(ModBlocks.MAPLE_DOOR);
                entries.accept(ModBlocks.MAPLE_TRAPDOOR);
                entries.accept(ModBlocks.MAPLE_BUTTON);
                entries.accept(ModBlocks.MAPLE_PRESSURE_PLATE);
            });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
            .register(entries -> {
                entries.accept(ModBlocks.MAPLE_LEAVES);
                entries.accept(ModBlocks.FALLEN_MAPLE_LEAVES);
                entries.accept(ModBlocks.MAPLE_LOG);
            });
    }
}
