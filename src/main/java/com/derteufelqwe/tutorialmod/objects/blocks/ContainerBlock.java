package com.derteufelqwe.tutorialmod.objects.blocks;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import com.derteufelqwe.tutorialmod.Main;
import com.derteufelqwe.tutorialmod.objects.items.ItemsInit;
import com.derteufelqwe.tutorialmod.tile.TileEntityTutorial;
import com.derteufelqwe.tutorialmod.util.handler.CreativeTabHandler;
import com.derteufelqwe.tutorialmod.util.handler.GuiHandler;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerBlock extends Block implements ITileEntityProvider {

	public ContainerBlock(Material materialIn, String name) {
		super(materialIn);
		
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabHandler.tabMeins);
		setHardness(10);
		setResistance(1000F);
		
		BlocksInit.BLOCKS.add(this);
		ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityTutorial te = (TileEntityTutorial) worldIn.getTileEntity(pos);
		System.out.println(te);
		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
			System.out.println("da");
			playerIn.openGui(Main.instance, GuiHandler.GUI_TUTORIAL_CONTAINER_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityTutorial te = (TileEntityTutorial) worldIn.getTileEntity(pos);
		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
			IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
			if (inventory != null) {
				for (int i = 0; i < inventory.getSlots(); i++) {
					if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
						EntityItem item = new EntityItem(worldIn,pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, inventory.getStackInSlot(i));
						
						float multiplier = 0.1F;
						float motionX = worldIn.rand.nextFloat() - 0.5F;
						float motionY = worldIn.rand.nextFloat() - 0.5F;
						float motionZ = worldIn.rand.nextFloat() - 0.5F;
						
						item.motionX = motionX * multiplier;
						item.motionY = motionY * multiplier;
						item.motionZ = motionZ * multiplier;
						
						worldIn.spawnEntity(item);
					}
				}
			}
		}
		
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityTutorial();
	}
	
	
	
	
}
