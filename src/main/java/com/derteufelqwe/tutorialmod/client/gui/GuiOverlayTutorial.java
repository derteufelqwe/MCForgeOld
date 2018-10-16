package com.derteufelqwe.tutorialmod.client.gui;

import com.derteufelqwe.tutorialmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiOverlayTutorial extends Gui {
	
	private final ResourceLocation bar = new ResourceLocation(Reference.MOD_ID, "textures/gui/hpbar.png");
	public final int tex_width = 102, tex_height = 8, bar_width = 100, bar_height = 6;
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.renderEngine.bindTexture(bar);
			float oneHPUnit = (float) bar_width / mc.player.getMaxHealth();
			int currentWidth = (int) (oneHPUnit * mc.player.getHealth());
			drawTexturedModalRect(0, 0, 0, 0, tex_width, tex_height);
			drawTexturedModalRect(1, 0, 1, tex_height, currentWidth, tex_height);
		}
	}
	
	
	
	
}
