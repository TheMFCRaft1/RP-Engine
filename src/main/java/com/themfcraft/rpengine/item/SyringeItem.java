
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;

import com.themfcraft.rpengine.procedures.SyringeLivingEntityIsHitWithItemProcedure;
import com.themfcraft.rpengine.init.RpEngineModTabs;

public class SyringeItem extends Item {
	public SyringeItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE).maxStackSize(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hitEntity(itemstack, entity, sourceentity);
		SyringeLivingEntityIsHitWithItemProcedure.execute(entity);
		return retval;
	}
}
