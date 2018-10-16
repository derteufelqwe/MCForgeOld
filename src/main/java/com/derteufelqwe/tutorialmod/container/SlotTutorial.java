package com.derteufelqwe.tutorialmod.container;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotTutorial extends SlotItemHandler {

	public SlotTutorial(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		
		if (stack.getItem() == Items.IRON_SHOVEL) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
