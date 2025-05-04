
package com.themfcraft.rpengine.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import com.themfcraft.rpengine.init.RpEngineModTabs;
import com.themfcraft.rpengine.init.RpEngineModBlocks;

public class AvocadoItem extends Item {
	public AvocadoItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_FOOD).maxStackSize(64).rarity(Rarity.COMMON).food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
	}

	@Override
	public UseAction getUseAction(ItemStack itemstack) {
		return UseAction.NONE;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new StringTextComponent(""));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = new ItemStack(RpEngineModBlocks.AVOCADOTREESAPLING.get());
		super.onItemUseFinish(itemstack, world, entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof PlayerEntity && !((PlayerEntity) entity).abilities.isCreativeMode) {
				if (!((PlayerEntity) entity).inventory.addItemStackToInventory(retval))
					((PlayerEntity) entity).dropItem(retval, false);
			}
			return itemstack;
		}
	}
}
