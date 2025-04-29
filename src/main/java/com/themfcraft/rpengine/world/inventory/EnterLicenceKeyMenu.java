package com.themfcraft.rpengine.world.inventory;

import com.themfcraft.rpengine.RpEngineMod;

public class EnterLicenceKeyMenu extends Container implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final World world;
	public final PlayerEntity entity;
	public int x, y, z;
	private IWorldPosCallable access = IWorldPosCallable.DUMMY;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private TileEntity boundBlockEntity = null;

	public EnterLicenceKeyMenu(int id, PlayerInventory inv, PacketBuffer extraData) {
		super(RpEngineModMenus.ENTER_LICENCE_KEY.get(), id);
		this.entity = inv.player;
		this.world = inv.player.world;
		this.internal = new ItemStackHandler(0);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = IWorldPosCallable.of(world, pos);
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return Container.isWithinUsableDistance(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		return ItemStack.EMPTY;
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}