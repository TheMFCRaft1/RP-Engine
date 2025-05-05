package com.themfcraft.rpengine.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

public class SetupProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add police {\"text\":\"[Police] \",\"color\":\"dark_blue\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team modify police prefix {\"text\":\"[Police] | \",\"color\":\"dark_blue\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add fire_department {\"text\":\"[fire_department] \",\"color\":\"dark_red\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team modify fire_department prefix {\"text\":\"[Fire Department] | \",\"color\":\"dark_red\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add municipal_utilities {\"text\":\"municipal_utilities\",\"color\":\"#FFFFFF\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team modify municipal_utilities prefix {\"text\":\"[Municipal Utilities] | \",\"color\":\"#FFFFFF\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add public_transport {\"text\":\"public_transport\",\"color\":\"#FFA245\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add public_transport {\"text\":\"public_transport\",\"color\":\"#FFA245\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add construction_worker {\"text\":\"construction_worker\",\"color\":\"yellow\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team modify construction_worker prefix {\"text\":\"[Construction Worker]\",\"color\":\"yellow\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team add paramedic {\"text\":\"paramedic\",\"color\":\"light_purple\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"team modify paramedic prefix {\"text\":\"[Paramedic] | \",\"color\":\"light_purple\",\"bold\":true}");
		if (world instanceof ServerWorld)
			((ServerWorld) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, ((ServerWorld) world), 4, "", new StringTextComponent(""), ((ServerWorld) world).getServer(), null).withFeedbackDisabled(),
					"scoreboars objectives add stars dummy");
		if (entity instanceof PlayerEntity && !((PlayerEntity) entity).world.isRemote())
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Setup Complete"), false);
		if (entity instanceof PlayerEntity && !((PlayerEntity) entity).world.isRemote())
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Setup Complete"), true);
	}
}
