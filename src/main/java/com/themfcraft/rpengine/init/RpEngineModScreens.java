/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.ScreenManager;

import com.themfcraft.rpengine.client.gui.SmartphoneUIScreen;
import com.themfcraft.rpengine.client.gui.SetupGUIScreen;
import com.themfcraft.rpengine.client.gui.ChooseJobScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RpEngineModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ScreenManager.registerFactory(RpEngineModMenus.SETUP_GUI.get(), SetupGUIScreen::new);
			ScreenManager.registerFactory(RpEngineModMenus.SMARTPHONE_UI.get(), SmartphoneUIScreen::new);
			ScreenManager.registerFactory(RpEngineModMenus.CHOOSE_JOB.get(), ChooseJobScreen::new);
		});
	}
}
