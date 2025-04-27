
package com.themfcraft.rpengine.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import com.themfcraft.rpengine.procedures.FireDeparmentPortableAlarmItemInInventoryTickProcedure;
import com.themfcraft.rpengine.init.RpEngineModTabs;

public class FireDeparmentPortableAlarmItem extends Item {
	public FireDeparmentPortableAlarmItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE).maxStackSize(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new StringTextComponent("Danger it makes loud noises..."));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		FireDeparmentPortableAlarmItemInInventoryTickProcedure.execute(world, entity.getPosX(), entity.getPosY(), entity.getPosZ());
	}
}
