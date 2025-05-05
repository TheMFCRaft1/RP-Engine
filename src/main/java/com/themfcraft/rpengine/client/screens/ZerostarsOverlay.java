package com.themfcraft.rpengine.client.screens;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.themfcraft.rpengine.procedures.ZerostarsDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ZerostarsOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			World world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.world;
				x = entity.getPosX();
				y = entity.getPosY();
				z = entity.getPosZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.disableAlphaTest();
			if (ZerostarsDisplayOverlayIngameProcedure.execute(entity)) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rp_engine:textures/screens/staroff.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), w / 2 + 186, h / 2 + -113, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rp_engine:textures/screens/staroff.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), w / 2 + 167, h / 2 + -113, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rp_engine:textures/screens/staroff.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), w / 2 + 148, h / 2 + -113, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rp_engine:textures/screens/staroff.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), w / 2 + 129, h / 2 + -113, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("rp_engine:textures/screens/staroff.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), w / 2 + 110, h / 2 + -113, 0, 0, 16, 16, 16, 16);

			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1, 1, 1, 1);
		}
	}
}
