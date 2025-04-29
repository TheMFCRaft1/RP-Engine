package com.themfcraft.rpengine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import javax.annotation.Nullable;

import com.themfcraft.rpengine.RpEngineMod;

@Mod.EventBusSubscriber
public class AvocadotreesaplingOnTickUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.world, event.player.getPosX(), event.player.getPosY(), event.player.getPosZ());
		}
	}

	public static void execute(IWorld world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, IWorld world, double x, double y, double z) {
		RpEngineMod.queueServerWork(30, () -> {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager().getTemplateDefaulted(new ResourceLocation("rp_engine", "avocadotree1"));
				if (template != null) {
					template.func_237146_a_((ServerWorld) world, new BlockPos(x, y, z), new BlockPos(x, y, z), new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), ((ServerWorld) world).rand, 3);
				}
			}
		});
	}
}
