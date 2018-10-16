package com.derteufelqwe.tutorialmod;

import com.derteufelqwe.tutorialmod.client.gui.GuiOverlayTutorial;
import com.derteufelqwe.tutorialmod.events.testEvent;
import com.derteufelqwe.tutorialmod.objects.blocks.BlocksInit;
import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.proxy.CommonProxy;
import com.derteufelqwe.tutorialmod.util.Reference;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;
import com.derteufelqwe.tutorialmod.util.handler.GuiHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	
	
//Proxys-------------------------------
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		BlocksInit.initBlocks();
		ItemsInit.initItems();
		proxy.preInit(event);
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {	//ggf init
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.init(event);
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new testEvent());
		MinecraftForge.EVENT_BUS.register(new GuiOverlayTutorial());
		proxy.postInit(event);
	}
	
}
