package com.themfcraft.rpengine.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import java.util.Random;

public class AvocadotreesaplingOnTickUpdateProcedure {
	public static void execute(IWorld world, double x, double y, double z) {
		if (MathHelper.nextDouble(new Random(), 1, 100) == 8) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager().getTemplateDefaulted(new ResourceLocation("rp_engine", "avocadotree1"));
				if (template != null) {
					template.func_237146_a_((ServerWorld) world, new BlockPos(x, y, z), new BlockPos(x, y, z), new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), ((ServerWorld) world).rand, 3);
				}
			}
		}
	}
}
