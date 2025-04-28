
package com.themfcraft.rpengine.item;

public class KiwiItem extends Item {
	public KiwiItem() {
		super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON).food((new Food.Builder()).hunger(0).saturation(0.3f).build()));
	}
}