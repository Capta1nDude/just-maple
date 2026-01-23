package net.captaindude.justmaple.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> MAPLE_LOGS =
        TagKey.of(RegistryKeys.ITEM, Identifier.of("justmaple", "maple_logs"));
}
