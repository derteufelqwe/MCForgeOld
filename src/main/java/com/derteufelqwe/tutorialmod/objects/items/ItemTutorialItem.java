package com.derteufelqwe.tutorialmod.objects.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class ItemTutorialItem extends ItemBase {

	public ItemTutorialItem(String name, CreativeTabs tab, int maxStackSize) {
		super(name, tab, maxStackSize);
		
	}

	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if (world.getBlockState(pos).getBlock() == Blocks.GRASS) {
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
			return EnumActionResult.SUCCESS;
		}
		
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}


	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Tooltip:");
		tooltip.add("Such Tooltip, very wow");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		
		return EnumRarity.EPIC;
	}
	
	
}
