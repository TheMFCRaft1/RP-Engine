package com.themfcraft.rpengine.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public class SyringeLivingEntityIsHitWithItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !((LivingEntity) entity).world.isRemote())
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, 60, 1));
		if (entity instanceof LivingEntity && !((LivingEntity) entity).world.isRemote())
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 600, 1));
	}
}
