package com.themfcraft.rpengine.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public class MedKitRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHealth() : -1) + 10));
	}
}
