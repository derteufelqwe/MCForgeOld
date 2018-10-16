package com.derteufelqwe.tutorialmod.objects.items;

import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemKey extends Item {
	
	public ItemKey(String name) {
		
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabHandler.tabItems);
		setMaxStackSize(1);
		
		ItemsInit.ITEMS.add(this);
	}


	
	
	
	
}
