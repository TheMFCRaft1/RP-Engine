
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class FiveDollarBillItem extends Item {
	public FiveDollarBillItem() {
		super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(64).rarity(Rarity.UNCOMMON));
	}
}
