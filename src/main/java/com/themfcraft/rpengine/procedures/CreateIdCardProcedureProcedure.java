package com.themfcraft.rpengine.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import com.themfcraft.rpengine.init.RpEngineModItems;

public class CreateIdCardProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(RpEngineModItems.IDCARD.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
