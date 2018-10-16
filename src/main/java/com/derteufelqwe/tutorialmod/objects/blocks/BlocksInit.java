package com.derteufelqwe.tutorialmod.objects.blocks;

import java.util.ArrayList;
import java.util.List;

import com.derteufelqwe.tutorialmod.util.Reference;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;
import com.derteufelqwe.tutorialmod.util.handler.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static Block tutorialBlock;
	public static Block keyBlock;
	public static Block containerBlock;
	
	public static void initBlocks() {
		
		tutorialBlock = new BlockBase(Material.ROCK, "tutorial_block");
		keyBlock = new KeyBlock(Material.IRON, "key_block");
		containerBlock = new ContainerBlock(Material.CLAY, "container_block");

		
		RegistryHandler.registerBlocks();
	}
	

}
