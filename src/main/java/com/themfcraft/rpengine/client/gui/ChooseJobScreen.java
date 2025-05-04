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

import com.themfcraft.rpengine.world.inventory.ChooseJobMenu;
import com.themfcraft.rpengine.network.ChooseJobButtonMessage;
import com.themfcraft.rpengine.RpEngineMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class ChooseJobScreen extends ContainerScreen<ChooseJobMenu> {
	private final static HashMap<String, Object> guistate = ChooseJobMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	Button button_police;
	Button button_fire_fighter;
	Button button_bus_driver;
	Button button_doctor;
	Button button_municipal_utilities;
	Button button_construction_worker;

	public ChooseJobScreen(ChooseJobMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/choose_job.png");

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
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.choose_job.label_please_choose_a_job").getString(), 41, 12, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_police = new Button(this.guiLeft + 14, this.guiTop + 27, 56, 20, new TranslationTextComponent("gui.rp_engine.choose_job.button_police"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new ChooseJobButtonMessage(0, x, y, z));
				ChooseJobButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_police", button_police);
		this.addButton(button_police);
		button_fire_fighter = new Button(this.guiLeft + 76, this.guiTop + 27, 87, 20, new TranslationTextComponent("gui.rp_engine.choose_job.button_fire_fighter"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new ChooseJobButtonMessage(1, x, y, z));
				ChooseJobButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fire_fighter", button_fire_fighter);
		this.addButton(button_fire_fighter);
		button_bus_driver = new Button(this.guiLeft + 14, this.guiTop + 55, 77, 20, new TranslationTextComponent("gui.rp_engine.choose_job.button_bus_driver"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new ChooseJobButtonMessage(2, x, y, z));
				ChooseJobButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_bus_driver", button_bus_driver);
		this.addButton(button_bus_driver);
		button_doctor = new Button(this.guiLeft + 107, this.guiTop + 55, 56, 20, new TranslationTextComponent("gui.rp_engine.choose_job.button_doctor"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new ChooseJobButtonMessage(3, x, y, z));
				ChooseJobButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_doctor", button_doctor);
		this.addButton(button_doctor);
		button_municipal_utilities = new Button(this.guiLeft + 14, this.guiTop + 83, 124, 20, new TranslationTextComponent("gui.rp_engine.choose_job.button_municipal_utilities"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new ChooseJobButtonMessage(4, x, y, z));
				ChooseJobButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_municipal_utilities", button_municipal_utilities);
		this.addButton(button_municipal_utilities);
		button_construction_worker = new Button(this.guiLeft + 14, this.guiTop + 112, 124, 20, new TranslationTextComponent("gui.rp_engine.choose_job.button_construction_worker"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new ChooseJobButtonMessage(5, x, y, z));
				ChooseJobButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_construction_worker", button_construction_worker);
		this.addButton(button_construction_worker);
	}
}
