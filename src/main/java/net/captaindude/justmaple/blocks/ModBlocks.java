package net.captaindude.justmaple.blocks;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.custom.MapleLeavesBlock;
import net.captaindude.justmaple.worldgen.tree.ModSaplingGenerators;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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

    // Maple stairs
    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
        new StairsBlock(ModBlocks.MAPLE_PLANKS.getDefaultState(), 
            AbstractBlock.Settings.create().strength(4f)
                .requiresTool().sounds(BlockSoundGroup.WOOD)));
    // Maple slab
    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
        new SlabBlock(AbstractBlock.Settings.create().strength(4f)
                .requiresTool().sounds(BlockSoundGroup.WOOD)));

    // Maple button
    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
        new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    // Maple pressure plate
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
        new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    
    // Maple fence
    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
        new FenceBlock(AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    // Maple fence gate
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
        new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    // Maple wall
    public static final Block MAPLE_WALL = registerBlock("maple_wall",
        new WallBlock(AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    // Maple door
    public static final Block MAPLE_DOOR = registerBlock("maple_door",
        new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f)
            .requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)));
    // Maple trapdoor
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
        new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f)
            .requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)));



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
