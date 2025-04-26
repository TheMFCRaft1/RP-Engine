
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class SmartphoneItem extends Item {
	public SmartphoneItem() {
		super(new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
