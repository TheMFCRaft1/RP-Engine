
package com.themfcraft.rpengine.item;

public class CreeperSodaItem extends Item {
	public CreeperSodaItem() {
		super(new Item.Properties().group(null).maxStackSize(16).rarity(Rarity.EPIC).food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
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