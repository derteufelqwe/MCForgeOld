package com.derteufelqwe.tutorialmod.objects.items;

import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String name, CreativeTabs tab, int maxStackSize) {
		
		setUnlocalizedName(name);
		setCreativeTab(tab);
		setRegistryName(name);
		setMaxStackSize(maxStackSize);
		
		ItemsInit.ITEMS.add(this);
	}
}
