
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.item.Item;

import com.themfcraft.rpengine.item.SmartphoneItem;
import com.themfcraft.rpengine.RpEngineMod;

public class RpEngineModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RpEngineMod.MODID);
	public static final RegistryObject<Item> SMARTPHONE = REGISTRY.register("smartphone", () -> new SmartphoneItem());
	// Start of user code block custom items
	// End of user code block custom items
}
