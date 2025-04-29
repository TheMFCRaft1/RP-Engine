
package com.themfcraft.rpengine.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import com.themfcraft.rpengine.init.RpEngineModTabs;

public class AvocadoSeedItem extends Item {
	public AvocadoSeedItem() {
		super(new Item.Properties().group(RpEngineModTabs.TAB_RP_FOOD).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
