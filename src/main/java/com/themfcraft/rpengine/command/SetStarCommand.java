package com.themfcraft.rpengine.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.Commands;

import com.themfcraft.rpengine.procedures.AddStarProcedure;

@Mod.EventBusSubscriber
public class SetStarCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("setstar").requires(s -> s.hasPermissionLevel(3)).then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			World world = arguments.getSource().getWorld();
			double x = arguments.getSource().getPos().getX();
			double y = arguments.getSource().getPos().getY();
			double z = arguments.getSource().getPos().getZ();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerWorld)
				entity = FakePlayerFactory.getMinecraft((ServerWorld) world);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getHorizontalFacing();

			AddStarProcedure.execute(arguments);
			return 0;
		})));
	}
}
