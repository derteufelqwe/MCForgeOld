package com.derteufelqwe.tutorialmod.util.handler;

import com.derteufelqwe.tutorialmod.objects.blocks.BlocksInit;
import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RegistryHandler {
	
	
	public static void registerItems() {
		
		for (Item item : ItemsInit.ITEMS) {
			ForgeRegistries.ITEMS.register(item);
		}
	}
	
	public static void registerBlocks() {
		
		for (Block block : BlocksInit.BLOCKS) {
			ForgeRegistries.BLOCKS.register(block);
		}
	}
	
	
	public static void registerItemRenders() {
		
		for (Item item : ItemsInit.ITEMS) {
			registerItemRender(item);
		}
	}
	
	public static void registerBlockRenders() {
		
		for (Block block : BlocksInit.BLOCKS) {
			registerBlockRender(block);
		}
	}
	
	
	public static void registerItemRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerBlockRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	
}
