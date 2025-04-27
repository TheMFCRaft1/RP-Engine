
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class OneDollarBillItem extends Item {
	public OneDollarBillItem() {
		super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
