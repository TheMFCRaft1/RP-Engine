package com.themfcraft.rpengine.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ChooseJobProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayerEntity) {
			BlockPos _bpos = new BlockPos(x, y, z);
			NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent("JobList");
				}

				@Override
				public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
					return new JobListMenu(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}