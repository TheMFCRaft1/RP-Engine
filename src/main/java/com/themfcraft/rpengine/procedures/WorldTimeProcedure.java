package com.themfcraft.rpengine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

import java.util.Calendar;

import com.themfcraft.rpengine.network.RpEngineModVariables;

@Mod.EventBusSubscriber
public class WorldTimeProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(IWorld world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, IWorld world) {
		String time = "";
		RpEngineModVariables.MapVariables.get(world).time = new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		RpEngineModVariables.MapVariables.get(world).syncData(world);
	}
}
