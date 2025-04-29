package com.themfcraft.rpengine.command;

@Mod.EventBusSubscriber
public class RpJobCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("rp-job")

		);
	}

}
