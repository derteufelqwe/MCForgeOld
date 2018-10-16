package com.derteufelqwe.tutorialmod.util.handler;


import com.derteufelqwe.tutorialmod.objects.blocks.BlocksInit;
import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {
	
	
	public static CreativeTabs tabMeins = new CreativeTabs("tab_meins") {
		
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(BlocksInit.keyBlock));
		}
	};
	
	
	public static CreativeTabs tabItems = new CreativeTabs("tab_items") {
		
		public ItemStack getTabIconItem() {
			return new ItemStack((ItemsInit.tutorialSword));
		}
	};
}
