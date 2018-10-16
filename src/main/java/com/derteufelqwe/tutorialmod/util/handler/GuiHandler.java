package com.derteufelqwe.tutorialmod.util.handler;

import com.derteufelqwe.tutorialmod.client.gui.GuiTutorialContainer;
import com.derteufelqwe.tutorialmod.container.ContainerTutorial;
import com.derteufelqwe.tutorialmod.tile.TileEntityTutorial;
import com.mojang.realmsclient.dto.PlayerInfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int GUI_TUTORIAL_CONTAINER_ID = 0;
	
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID) {
			case GUI_TUTORIAL_CONTAINER_ID:
				return new ContainerTutorial(player.inventory, (TileEntityTutorial) te);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID) {
			case GUI_TUTORIAL_CONTAINER_ID:
				return new GuiTutorialContainer(player.inventory, (TileEntityTutorial) te);
			default:
				return null;
		}
	}

}
