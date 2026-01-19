package net.captaindude.justmaple.blocks;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.custom.MapleLeavesBlock;
import net.captaindude.justmaple.worldgen.tree.ModSaplingGenerators;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MAPLE_LOG = registerBlock("maple_log",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
        new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
        new MapleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    
    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
        new SaplingBlock(ModSaplingGenerators.MAPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).nonOpaque()));

    public static final Block FALLEN_MAPLE_LEAVES = registerBlock("fallen_maple_leaves", 
        new FlowerbedBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)));


    // Register block to registry (creates the block in the game)
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(JustMaple.MOD_ID, name), block);
    }

    // Register block item to registry (creates the block as an item in the game)
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(JustMaple.MOD_ID, name), 
            new BlockItem(block, new Item.Settings()));
    }


    // Initializer method
    public static void registerModBlocks() {
        JustMaple.LOGGER.info("Registering Mod Blocks for " + JustMaple.MOD_ID);
    }
}
