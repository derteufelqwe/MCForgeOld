package com.derteufelqwe.tutorialmod.client.gui;

import com.derteufelqwe.tutorialmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiButtonTutorial extends GuiButton {
	
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/book.png");
	
	static int buttonWidth  = 16;
	static int buttonHeight = 14;
	int u = 175;
	int v = 1;
	
	public GuiButtonTutorial(int buttonId, int x, int y) {
		super(buttonId, x, y, buttonWidth, buttonHeight, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		if (visible) {
			mc.renderEngine.bindTexture(texture);
			if (mouseX  >= x && mouseX <= x + width && mouseY >= y && mouseY <=y + height) {
				hovered = true;
			} else {
				hovered = false;
			}
			if (hovered) {
				v = 18;
			} else {
				v = 1;
			}
			drawTexturedModalRect(x, y, u, v, width, height);

		}
		
	}

	

}
