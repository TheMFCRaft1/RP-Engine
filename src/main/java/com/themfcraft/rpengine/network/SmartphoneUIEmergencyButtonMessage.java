package com.themfcraft.rpengine.network;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.PlayerEntity;

import java.util.function.Supplier;
import java.util.HashMap;

import com.themfcraft.rpengine.world.inventory.SmartphoneUIEmergencyMenu;
import com.themfcraft.rpengine.procedures.CallPoliceProcedure;
import com.themfcraft.rpengine.procedures.CallFireDepartmentProcedure;
import com.themfcraft.rpengine.RpEngineMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SmartphoneUIEmergencyButtonMessage {
	private final int buttonID, x, y, z;

	public SmartphoneUIEmergencyButtonMessage(PacketBuffer buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SmartphoneUIEmergencyButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SmartphoneUIEmergencyButtonMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SmartphoneUIEmergencyButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			PlayerEntity entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		HashMap guistate = SmartphoneUIEmergencyMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CallPoliceProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			CallFireDepartmentProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		RpEngineMod.addNetworkMessage(SmartphoneUIEmergencyButtonMessage.class, SmartphoneUIEmergencyButtonMessage::buffer, SmartphoneUIEmergencyButtonMessage::new, SmartphoneUIEmergencyButtonMessage::handler);
	}
}
