package com.derteufelqwe.tutorialmod.proxy;

import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.util.Reference;
import com.derteufelqwe.tutorialmod.util.handler.RegistryHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event ) {
		
		OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);		
		RegistryHandler.registerItemRenders();
		RegistryHandler.registerBlockRenders();
	}
	
	@Override
	public void init(FMLInitializationEvent event) {	
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	
	
	
}
