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

import com.themfcraft.rpengine.world.inventory.ChooseJobMenu;
import com.themfcraft.rpengine.procedures.PublicTransportJoinProcedure;
import com.themfcraft.rpengine.procedures.PoliceJoinProcedure;
import com.themfcraft.rpengine.procedures.MunicipalUtilitiesJoinProcedure;
import com.themfcraft.rpengine.procedures.MedJoinProcedure;
import com.themfcraft.rpengine.procedures.FiredepartmentJoinProcedure;
import com.themfcraft.rpengine.procedures.ConstructionWorkerJoinProcedure;
import com.themfcraft.rpengine.RpEngineMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChooseJobButtonMessage {
	private final int buttonID, x, y, z;

	public ChooseJobButtonMessage(PacketBuffer buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ChooseJobButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ChooseJobButtonMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ChooseJobButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ChooseJobMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PoliceJoinProcedure.execute(entity);
		}
		if (buttonID == 1) {

			FiredepartmentJoinProcedure.execute(entity);
		}
		if (buttonID == 2) {

			PublicTransportJoinProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MedJoinProcedure.execute(entity);
		}
		if (buttonID == 4) {

			MunicipalUtilitiesJoinProcedure.execute(entity);
		}
		if (buttonID == 5) {

			ConstructionWorkerJoinProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		RpEngineMod.addNetworkMessage(ChooseJobButtonMessage.class, ChooseJobButtonMessage::buffer, ChooseJobButtonMessage::new, ChooseJobButtonMessage::handler);
	}
}
