package com.derteufelqwe.tutorialmod.client.gui;

import java.awt.Color;

import com.derteufelqwe.tutorialmod.container.ContainerTutorial;
import com.derteufelqwe.tutorialmod.tile.TileEntityTutorial;
import com.derteufelqwe.tutorialmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class GuiTutorialContainer extends GuiContainer {

	
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/container.png");
	
	public GuiTutorialContainer(InventoryPlayer player, TileEntityTutorial tileEntityTutorial) {
		super(new ContainerTutorial(player, tileEntityTutorial));
		xSize = 176;
		ySize = 166;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		fontRenderer.drawString(new TextComponentTranslation("tile.tutorial_container.name").getFormattedText(), 5, 5, Color.DARK_GRAY.getRGB());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

	
}
