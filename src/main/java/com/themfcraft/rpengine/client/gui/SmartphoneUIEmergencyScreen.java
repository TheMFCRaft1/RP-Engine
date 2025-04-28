package com.themfcraft.rpengine.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.themfcraft.rpengine.world.inventory.SmartphoneUIEmergencyMenu;
import com.themfcraft.rpengine.network.SmartphoneUIEmergencyButtonMessage;
import com.themfcraft.rpengine.RpEngineMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class SmartphoneUIEmergencyScreen extends ContainerScreen<SmartphoneUIEmergencyMenu> {
	private final static HashMap<String, Object> guistate = SmartphoneUIEmergencyMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	Button button_call_police;
	Button button_call_amulance;
	Button button_call_fire_department;
	Button button_back;

	public SmartphoneUIEmergencyScreen(SmartphoneUIEmergencyMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 151;
		this.ySize = 218;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/smartphone_ui_emergency.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		this.blit(ms, this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack poseStack, int mouseX, int mouseY) {
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.smartphone_ui_emergency.label_emergency").getString(), 52, 8, -256);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_call_police = new Button(this.guiLeft + 33, this.guiTop + 46, 82, 20, new TranslationTextComponent("gui.rp_engine.smartphone_ui_emergency.button_call_police"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new SmartphoneUIEmergencyButtonMessage(0, x, y, z));
				SmartphoneUIEmergencyButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_call_police", button_call_police);
		this.addButton(button_call_police);
		button_call_amulance = new Button(this.guiLeft + 28, this.guiTop + 75, 93, 20, new TranslationTextComponent("gui.rp_engine.smartphone_ui_emergency.button_call_amulance"), e -> {
		});
		guistate.put("button:button_call_amulance", button_call_amulance);
		this.addButton(button_call_amulance);
		button_call_fire_department = new Button(this.guiLeft + 11, this.guiTop + 101, 129, 20, new TranslationTextComponent("gui.rp_engine.smartphone_ui_emergency.button_call_fire_department"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new SmartphoneUIEmergencyButtonMessage(2, x, y, z));
				SmartphoneUIEmergencyButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_call_fire_department", button_call_fire_department);
		this.addButton(button_call_fire_department);
		button_back = new Button(this.guiLeft + 51, this.guiTop + 186, 46, 20, new TranslationTextComponent("gui.rp_engine.smartphone_ui_emergency.button_back"), e -> {
		});
		guistate.put("button:button_back", button_back);
		this.addButton(button_back);
	}
}
