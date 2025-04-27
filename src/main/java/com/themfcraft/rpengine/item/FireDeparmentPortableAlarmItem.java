
package com.themfcraft.rpengine.item;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;

import com.themfcraft.rpengine.procedures.FireDeparmentPortableAlarmItemInInventoryTickProcedure;

public class FireDeparmentPortableAlarmItem extends Item {
	public FireDeparmentPortableAlarmItem() {
		super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		FireDeparmentPortableAlarmItemInInventoryTickProcedure.execute(world, entity.getPosX(), entity.getPosY(), entity.getPosZ());
	}
}
