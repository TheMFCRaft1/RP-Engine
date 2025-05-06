
package com.themfcraft.rpengine.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

public class TestItem extends MusicDiscItem {
	public TestItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.basalt_deltas.mood")), new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
	}
}
