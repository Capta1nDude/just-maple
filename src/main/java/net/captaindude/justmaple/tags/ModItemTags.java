package net.captaindude.justmaple.tags;

import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;

public class ModItemTags {
    public static final TagKey<Item> MAPLE_LOGS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("justmaple", "maple_logs"));
}
