/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import com.themfcraft.rpengine.world.inventory.SmartphoneUIMenu;
import com.themfcraft.rpengine.world.inventory.SmartphoneUIEmergencyMenu;
import com.themfcraft.rpengine.world.inventory.SetupGUIMenu;
import com.themfcraft.rpengine.world.inventory.JobListMenu;
import com.themfcraft.rpengine.RpEngineMod;

public class RpEngineModMenus {
	public static final DeferredRegister<ContainerType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, RpEngineMod.MODID);
	public static final RegistryObject<ContainerType<SetupGUIMenu>> SETUP_GUI = REGISTRY.register("setup_gui", () -> IForgeContainerType.create(SetupGUIMenu::new));
	public static final RegistryObject<ContainerType<SmartphoneUIMenu>> SMARTPHONE_UI = REGISTRY.register("smartphone_ui", () -> IForgeContainerType.create(SmartphoneUIMenu::new));
	public static final RegistryObject<ContainerType<SmartphoneUIEmergencyMenu>> SMARTPHONE_UI_EMERGENCY = REGISTRY.register("smartphone_ui_emergency", () -> IForgeContainerType.create(SmartphoneUIEmergencyMenu::new));
	public static final RegistryObject<ContainerType<JobListMenu>> JOB_LIST = REGISTRY.register("job_list", () -> IForgeContainerType.create(JobListMenu::new));
}
