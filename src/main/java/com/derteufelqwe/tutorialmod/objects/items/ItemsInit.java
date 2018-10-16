package com.derteufelqwe.tutorialmod.objects.items;

import java.util.ArrayList;
import java.util.List;

import com.derteufelqwe.tutorialmod.util.Reference;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;
import com.derteufelqwe.tutorialmod.util.handler.RegistryHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static Item tutorialItem;
	public static Item tutorialSword;
	public static Item laserSword;
	public static Item keyItem;
	
	public static void initItems() {
		
		ToolMaterial tutorialMateriel = EnumHelper.addToolMaterial("tutorialMaterial", 3, 1, 20.0F, 16.0F, 100);
		ToolMaterial laserSwordOn = EnumHelper.addToolMaterial("laserSwordOn", 3, 400, 10.0F, -3.0F, 15);
		
		tutorialItem = new ItemTutorialItem("tutorial_item", CreativeTabHandler.tabMeins, 64);
		tutorialSword = new ItemToolSword(tutorialMateriel, "tutorial_sword");
		laserSword = new laserSword(laserSwordOn, "laser_sword");
		keyItem = new ItemKey("key_item");

		
		RegistryHandler.registerItems();
	}
	

}
