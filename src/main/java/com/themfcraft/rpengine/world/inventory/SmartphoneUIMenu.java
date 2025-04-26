package com.themfcraft.rpengine.world.inventory;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import com.themfcraft.rpengine.procedures.SetPhoneTimeProcedure;
import com.themfcraft.rpengine.init.RpEngineModMenus;

@Mod.EventBusSubscriber
public class SmartphoneUIMenu extends Container implements Supplier<Map<Integer, Slot>> {
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

	public SmartphoneUIMenu(int id, PlayerInventory inv, PacketBuffer extraData) {
		super(RpEngineModMenus.SMARTPHONE_UI.get(), id);
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

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		PlayerEntity entity = event.player;
		if (event.phase == TickEvent.Phase.END && entity.openContainer instanceof SmartphoneUIMenu) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			SetPhoneTimeProcedure.execute(guistate);
		}
	}
}
