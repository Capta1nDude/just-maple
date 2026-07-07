package net.captaindude.justmaple.blocks;

import net.captaindude.justmaple.JustMaple;
import net.captaindude.justmaple.blocks.custom.MapleFlowerbedBlock;
import net.captaindude.justmaple.blocks.custom.MapleLeavesBlock;
import net.captaindude.justmaple.worldgen.tree.ModSaplingGenerators;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.resources.Identifier;

public class ModBlocks {
    public static final Block MAPLE_LOG = registerBlock("maple_log",
        new RotatedPillarBlock(blockSettings("maple_log", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
        new RotatedPillarBlock(blockSettings("maple_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD))));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
        new RotatedPillarBlock(blockSettings("stripped_maple_log", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
        new RotatedPillarBlock(blockSettings("stripped_maple_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
        new Block(blockSettings("maple_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
        new MapleLeavesBlock(blockSettings("maple_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES))));
    
    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
        new SaplingBlock(ModSaplingGenerators.MAPLE, blockSettings("maple_sapling",
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noOcclusion())));

    public static final Block FALLEN_MAPLE_LEAVES = registerBlock("fallen_maple_leaves", 
        new MapleFlowerbedBlock(blockSettings("fallen_maple_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS))));

    // Maple stairs
    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
        new StairBlock(ModBlocks.MAPLE_PLANKS.defaultBlockState(), 
            blockSettings("maple_stairs", BlockBehaviour.Properties.of().strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.WOOD))));
    // Maple slab
    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
        new SlabBlock(blockSettings("maple_slab", BlockBehaviour.Properties.of().strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.WOOD))));

    // Maple button
    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
        new ButtonBlock(BlockSetType.OAK, 10, blockSettings("maple_button", BlockBehaviour.Properties.of().strength(4f)
            .requiresCorrectToolForDrops().sound(SoundType.WOOD))));
    // Maple pressure plate
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
        new PressurePlateBlock(BlockSetType.OAK, blockSettings("maple_pressure_plate", BlockBehaviour.Properties.of().strength(4f)
            .requiresCorrectToolForDrops().sound(SoundType.WOOD))));
    
    // Maple fence
    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
        new FenceBlock(blockSettings("maple_fence", BlockBehaviour.Properties.of().strength(4f)
            .requiresCorrectToolForDrops().sound(SoundType.WOOD))));
    // Maple fence gate
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
        new FenceGateBlock(WoodType.OAK, blockSettings("maple_fence_gate", BlockBehaviour.Properties.of().strength(4f)
            .requiresCorrectToolForDrops().sound(SoundType.WOOD))));

    // Maple door
    public static final Block MAPLE_DOOR = registerBlock("maple_door",
        new DoorBlock(BlockSetType.OAK, blockSettings("maple_door", BlockBehaviour.Properties.of().strength(4f)
            .requiresCorrectToolForDrops().noOcclusion().sound(SoundType.WOOD))));
    // Maple trapdoor
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
        new TrapDoorBlock(BlockSetType.OAK, blockSettings("maple_trapdoor", BlockBehaviour.Properties.of().strength(4f)
            .requiresCorrectToolForDrops().noOcclusion().sound(SoundType.WOOD))));



    private static BlockBehaviour.Properties blockSettings(String name, BlockBehaviour.Properties settings) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, name));
        return settings.setId(key);
    }

    private static Item.Properties itemSettings(String name, Item.Properties settings) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, name));
        return settings.setId(key).useBlockDescriptionPrefix();
    }

    // Register block to registry (creates the block in the game)
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, name), block);
    }

    // Register block item to registry (creates the block as an item in the game)
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(JustMaple.MOD_ID, name), 
            new BlockItem(block, itemSettings(name, new Item.Properties())));
    }


    // Initializer method
    public static void registerModBlocks() {
        JustMaple.LOGGER.info("Registering Mod Blocks for " + JustMaple.MOD_ID);
    }
}
