package com.derteufelqwe.tutorialmod.objects.items;

import java.util.List;

import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.functions.SetMetadata;

public class laserSword extends ItemSword {

	public int damageToDeal = 1;
	DamageSource laserDamage = new DamageSource("laser");
	
	public laserSword(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabHandler.tabItems);
		setRegistryName(name);
		setMaxStackSize(1);
		
		ItemsInit.ITEMS.add(this);
		
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Consumes Energy on Every Hit");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		if (stack.getTagCompound().getBoolean("isEnabled") == true && stack.getItemDamage() <= stack.getMaxDamage()-100) {
			target.attackEntityFrom(laserDamage, damageToDeal);
			stack.damageItem(100, attacker);	
		} else {
			damageToDeal = 1;
			target.attackEntityFrom(laserDamage, damageToDeal);
			//stack.damageItem(0, attacker);	
		}
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		NBTTagCompound nbt;
		//set NBT Tag
		if (item.hasTagCompound() == true) {
			nbt = item.getTagCompound();
		} else {
			nbt = new NBTTagCompound();
		}
		//Set Damage value according to nbt tag
		if (nbt.hasKey("isEnabled") == true) {
			if (nbt.getBoolean("isEnabled") == false && item.getItemDamage() <= item.getMaxDamage()-100) {
				damageToDeal = 20;
				nbt.setBoolean("isEnabled", true);
			} else {
				damageToDeal = 1;
				nbt.setBoolean("isEnabled", false);
			}
		} else {
			nbt.setBoolean("isEnabled", true);
		}
		item.setTagCompound(nbt);
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		if (damageToDeal == 20) {
			return true;
		} else {
			return false;
		}
	}

	

	

	
	
	

	
	
	
	
	
	
	
}
