package com.derteufelqwe.tutorialmod.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiTutorial extends GuiScreen {
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/book.png");
	int guiWidth  = 175;
	int guiHeight = 228;
	int screenMidX = width / 2;
	int screenMidY = (height / 2) - (guiHeight / 2);
	
	GuiButton button1;
	GuiButtonTutorial arrow;
	GuiTextField textBox1;
	
	final int BUTTON1 = 0, ARROW = 1;
	
	String title = "Tutorial";
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		int centerX = (width / 2) - (guiWidth / 2);
		int centerY = (height / 2) - (guiHeight / 2);
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		//drawString(mc.fontRenderer, "Tutorial", centerX, centerY, 0xFFA214);
		fontRenderer.drawString(title, width / 2 - fontRenderer.getStringWidth(title) / 2, centerY + 10, 0xFFA214);
		GlStateManager.pushMatrix();
		{
			GlStateManager.color(1, 1, 1, 1);
		}
		GlStateManager.popMatrix();
		mc.renderEngine.bindTexture(texture);
		
		button1.drawButton(mc, mouseX, mouseY, partialTicks);
		arrow.drawButton(mc, mouseX, mouseY, partialTicks);
		
		ItemStack icon = new ItemStack(Blocks.BEDROCK);
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(width / 2, height / 2, 0);
			GlStateManager.scale(2, 2, 2);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon, 0, 0);
		}
		GlStateManager.popMatrix();
		
		List<String> text = new ArrayList<String>();
		text.add(I18n.format("gui.tooltip"));
		text.add(icon.getDisplayName());
		drawTooltip(text, mouseX, mouseY, width / 2, height / 2, 32, 32, icon);	
		
		textBox1.drawTextBox();
		
		
		//super.drawScreen(mouseX, mouseY, partialTicks);
	}
	//																							size of object
	public void drawTooltip(List<String> lines, int mouseX, int mouseY, int posX, int posY, int width, int height, ItemStack icon) {
		
		if (mouseX  >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <=posY + height) {
			drawHoveringText(lines, mouseX, mouseY);
		}
		
	}
	
	@Override
	public void initGui() {
		buttonList.clear();
		int buttonW = 100;
		int buttonH = 20;
		buttonList.add(button1 = new GuiButton(BUTTON1, width / 2 - buttonW / 2, height - 50, buttonW, buttonH, "Button"));
		buttonList.add(arrow = new GuiButtonTutorial(ARROW, 300, 20));
		textBox1 = new GuiTextField(0, fontRenderer, button1.x, button1.y - buttonH, 100, 15);
		
		
		super.initGui();
	}
	
	public void updateButton() {
		
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		switch(button.id) {
			case BUTTON1: 
				if (!textBox1.getText().equals("")) {
					title = textBox1.getText();
				} break;
			case ARROW:
				mc.displayGuiScreen(null);
		}
		
		super.actionPerformed(button);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (typedChar == 'e' && !textBox1.isFocused()) {
			mc.displayGuiScreen(null);
		}
		
		textBox1.textboxKeyTyped(typedChar, keyCode);
		
		super.keyTyped(typedChar, keyCode);
	}
	
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		textBox1.mouseClicked(mouseX, mouseY, mouseButton);
		
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	
	
	
}
