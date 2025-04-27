
package com.themfcraft.rpengine.item;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import com.themfcraft.rpengine.procedures.MedKitRightclickedProcedure;
import com.themfcraft.rpengine.init.RpEngineModTabs;

public class MedKitItem extends Item {
	public MedKitItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE).maxDamage(1).rarity(Rarity.COMMON));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		MedKitRightclickedProcedure.execute(entity);
		return ar;
	}
}
