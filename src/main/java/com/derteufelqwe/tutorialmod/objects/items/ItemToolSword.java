package com.derteufelqwe.tutorialmod.objects.items;

import java.util.List;

import com.derteufelqwe.tutorialmod.client.gui.GuiTutorial;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemToolSword extends ItemSword {

	public ItemToolSword(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabHandler.tabItems);
		setRegistryName(name);
		setMaxStackSize(1);
		
		ItemsInit.ITEMS.add(this);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Gloryous Sword");
		tooltip.add("Broken AF lol");
		tooltip.add("GIT GUD");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumRarity.EPIC;
	}

//Makes it unbreakable
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		
		
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		if (worldIn.isRemote) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial());
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	
	
	

}
