
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import com.themfcraft.rpengine.init.RpEngineModTabs;

public class IdcardItem extends Item {
	public IdcardItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE).maxStackSize(1).rarity(Rarity.EPIC));
	}
}
