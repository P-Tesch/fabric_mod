package com.tesch.typemoon.items;

import com.tesch.typemoon.TypeMoonMod;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TypeMoonItemGroups {

    public static final ItemGroup TYPE_MOON_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(TypeMoonMod.MOD_ID), () -> new ItemStack(ItemRegister.FRAGARACH));
    
}
