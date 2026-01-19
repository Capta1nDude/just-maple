package net.captaindude.justmaple.item;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroups {
    public static void registerItemGroups() {
        JustMaple.LOGGER.info("Registering Item Groups for " + JustMaple.MOD_ID);

        // Adds pedestal to building block group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register(entries -> {
                entries.add(ModBlocks.MAPLE_LOG);
                entries.add(ModBlocks.MAPLE_LEAVES);
                entries.add(ModBlocks.MAPLE_SAPLING);
                entries.add(ModBlocks.MAPLE_PLANKS);
                entries.add(ModBlocks.MAPLE_WOOD);
                entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
                entries.add(ModBlocks.FALLEN_MAPLE_LEAVES);
            });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
            .register(entries -> {
                entries.add(ModBlocks.MAPLE_LEAVES);
                entries.add(ModBlocks.FALLEN_MAPLE_LEAVES);
            });
    }
}
