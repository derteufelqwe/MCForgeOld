package com.derteufelqwe.tutorialmod.objects.blocks;

import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBase extends Block {

	public BlockBase(Material materialIn, String name) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.tabMeins);
		setHardness(5F);
		setResistance(100F);
		setSoundType(SoundType.ANVIL);
		setLightLevel(5F);
		
		BlocksInit.BLOCKS.add(this);
		ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		
		worldIn.setBlockState(pos, Blocks.TNT.getDefaultState());
		
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		if (worldIn.isRemote) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(playerIn));
		}
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	
	
	
	
	
}
