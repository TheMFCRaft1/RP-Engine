
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import com.themfcraft.rpengine.init.RpEngineModTabs;

public class IronCoinItem extends Item {
	public IronCoinItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
