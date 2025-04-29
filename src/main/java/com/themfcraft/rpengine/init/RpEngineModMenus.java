/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.extensions.IForgeContainerType;

import net.minecraft.inventory.container.ContainerType;

import com.themfcraft.rpengine.world.inventory.SmartphoneUIMenu;
import com.themfcraft.rpengine.world.inventory.SetupGUIMenu;
import com.themfcraft.rpengine.RpEngineMod;

public class RpEngineModMenus {
	public static final DeferredRegister<ContainerType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, RpEngineMod.MODID);
	public static final RegistryObject<ContainerType<SetupGUIMenu>> SETUP_GUI = REGISTRY.register("setup_gui", () -> IForgeContainerType.create(SetupGUIMenu::new));
	public static final RegistryObject<ContainerType<SmartphoneUIMenu>> SMARTPHONE_UI = REGISTRY.register("smartphone_ui", () -> IForgeContainerType.create(SmartphoneUIMenu::new));
}
