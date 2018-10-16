package com.derteufelqwe.tutorialmod.objects.blocks;

import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KeyBlock extends Block {

	public KeyBlock(Material materialIn, String name) {
		super(materialIn);
		setCreativeTab(CreativeTabHandler.tabMeins);
		setRegistryName(name);
		setUnlocalizedName(name);
		setResistance(2000);
		setHardness(10F);
		setLightLevel(4F);
		
		BlocksInit.BLOCKS.add(this);
		ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}

	
	public static final PropertyInteger ISACTIVATED = PropertyInteger.create("isactivated", 0, 1);


	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {ISACTIVATED});
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(ISACTIVATED);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ISACTIVATED, meta);
	}
	
	
	public Boolean checkMulti(World world, BlockPos pos) {
		
		if (world.getBlockState(pos.add(1, 0, 0)) == Blocks.DAYLIGHT_DETECTOR.getDefaultState()) {
			if (world.getBlockState(pos.add(0, 0, 1)) == Blocks.DAYLIGHT_DETECTOR.getDefaultState()) {
				if (world.getBlockState(pos.add(-1, 0, 0)) == Blocks.DAYLIGHT_DETECTOR.getDefaultState()) {
					if (world.getBlockState(pos.add(0, 0, -1)) == Blocks.DAYLIGHT_DETECTOR.getDefaultState()) {
						EntityLightningBolt thor = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
						world.spawnEntity(thor);
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack item = playerIn.getHeldItemMainhand();
		ItemStack itemToUse = new ItemStack(Items.DIAMOND);
		Integer status = worldIn.getBlockState(pos).getValue(ISACTIVATED);
		if (item.getItem() == itemToUse.getItem() && status == 0) {
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(ISACTIVATED, 1));
			playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.DIAMOND, item.getCount()-1));
		}
		
		return true;
	}


	
	
	
	
	
	
}
