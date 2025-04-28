/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import com.themfcraft.rpengine.client.gui.SmartphoneUIScreen;
import com.themfcraft.rpengine.client.gui.SmartphoneUIEmergencyScreen;
import com.themfcraft.rpengine.client.gui.SetupGUIScreen;
import com.themfcraft.rpengine.client.gui.JobListScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RpEngineModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ScreenManager.registerFactory(RpEngineModMenus.SETUP_GUI.get(), SetupGUIScreen::new);
			ScreenManager.registerFactory(RpEngineModMenus.SMARTPHONE_UI.get(), SmartphoneUIScreen::new);
			ScreenManager.registerFactory(RpEngineModMenus.SMARTPHONE_UI_EMERGENCY.get(), SmartphoneUIEmergencyScreen::new);
			ScreenManager.registerFactory(RpEngineModMenus.JOB_LIST.get(), JobListScreen::new);
		});
	}
}
