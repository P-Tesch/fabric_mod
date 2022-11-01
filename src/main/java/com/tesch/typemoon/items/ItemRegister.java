package com.tesch.typemoon.items;

import com.tesch.typemoon.TypeMoonMod;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegister {

    public static final Item FRAGARACH = registerItem("fragarach_item", new FragarachItem());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TypeMoonMod.MOD_ID, name), item);
    }
    
    public static void registerItems() {
        TypeMoonMod.LOGGER.info("Registering items for " + TypeMoonMod.MOD_ID);
    }
}
