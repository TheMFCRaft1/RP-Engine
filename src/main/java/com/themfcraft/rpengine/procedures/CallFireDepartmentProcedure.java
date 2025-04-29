package com.themfcraft.rpengine.procedures;

import net.minecraftforge.eventbus.api.Event;

public class CallFireDepartmentProcedure {
	public static void execute(IWorld world) {
		RpEngineModVariables.MapVariables.get(world).ALARMON = "true";
		RpEngineModVariables.MapVariables.get(world).syncData(world);
		RpEngineMod.queueServerWork(20, () -> {
			RpEngineModVariables.MapVariables.get(world).ALARMON = "false";
			RpEngineModVariables.MapVariables.get(world).syncData(world);
		});
	}
}