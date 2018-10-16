package com.derteufelqwe.tutorialmod.events;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.datafix.fixes.SpawnerEntityTypes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.swing.TextComponent;

public class testEvent {
	
	@SubscribeEvent
	public void entityJoin(EntityJoinWorldEvent event) {
		
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			player.setFire(5);
		}
		
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onPlayerPickupXP(PlayerPickupXpEvent event) {
		
		event.getOrb().xpValue *= 10000;
		
	}
	
	
	@SubscribeEvent
	public void livingDrops(LivingDropsEvent event) {
		
		if (event.getEntity() instanceof EntityMob) {
			event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(Items.DIAMOND)));
		}
		
	}
	
	
}
