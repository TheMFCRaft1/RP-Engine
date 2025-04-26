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
		if (entity instanceof PlayerEntity && !((PlayerEntity) entity).world.isRemote())
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Setup Complete"), false);
		if (entity instanceof PlayerEntity && !((PlayerEntity) entity).world.isRemote())
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Setup Complete"), true);
	}
}
