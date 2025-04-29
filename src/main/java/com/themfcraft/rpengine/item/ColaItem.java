
package com.themfcraft.rpengine.item;

public class ColaItem extends Item {
	public ColaItem() {
		super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.EPIC).food((new Food.Builder()).hunger(0).saturation(10f).build()));
	}

	@Override
	public UseAction getUseAction(ItemStack itemstack) {
		return UseAction.DRINK;
	}

	@Override
	public net.minecraft.util.SoundEvent getEatSound() {
		return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
	}
}