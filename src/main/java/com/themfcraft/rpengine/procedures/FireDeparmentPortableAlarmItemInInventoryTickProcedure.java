package com.themfcraft.rpengine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;

import com.themfcraft.rpengine.network.RpEngineModVariables;

public class FireDeparmentPortableAlarmItemInInventoryTickProcedure {
	public static void execute(IWorld world, double x, double y, double z) {
		if (RpEngineModVariables.MapVariables.get(world).ALARMON.matches("true")) {
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bell.use")), SoundCategory.MASTER, 1, 1);
				} else {
					((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bell.use")), SoundCategory.MASTER, 1, 1, false);
				}
			}
		}
	}
}
