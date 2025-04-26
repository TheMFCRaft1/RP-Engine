
package com.themfcraft.rpengine.item;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

import com.themfcraft.rpengine.world.inventory.SmartphoneUIMenu;
import com.themfcraft.rpengine.item.inventory.SmartphoneInventoryCapability;

public class SmartphoneItem extends Item {
	public SmartphoneItem() {
		super(new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1).rarity(Rarity.COMMON));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		if (entity instanceof ServerPlayerEntity) {
			NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent("Smartphone");
				}

				@Override
				public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
					PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
					packetBuffer.writeBlockPos(entity.getPosition());
					packetBuffer.writeByte(hand == Hand.MAIN_HAND ? 0 : 1);
					return new SmartphoneUIMenu(id, inventory, packetBuffer);
				}
			}, buf -> {
				buf.writeBlockPos(entity.getPosition());
				buf.writeByte(hand == Hand.MAIN_HAND ? 0 : 1);
			});
		}
		return ar;
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT compound) {
		return new SmartphoneInventoryCapability();
	}

	@Override
	public CompoundNBT getShareTag(ItemStack stack) {
		CompoundNBT nbt = stack.getOrCreateTag();
		stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> nbt.put("Inventory", ((ItemStackHandler) capability).serializeNBT()));
		return nbt;
	}

	@Override
	public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
		super.readShareTag(stack, nbt);
		if (nbt != null)
			stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> ((ItemStackHandler) capability).deserializeNBT((CompoundNBT) nbt.get("Inventory")));
	}
}
