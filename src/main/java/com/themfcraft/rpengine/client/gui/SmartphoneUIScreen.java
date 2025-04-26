package com.themfcraft.rpengine.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.themfcraft.rpengine.world.inventory.SmartphoneUIMenu;
import com.themfcraft.rpengine.network.SmartphoneUIButtonMessage;
import com.themfcraft.rpengine.RpEngineMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class SmartphoneUIScreen extends ContainerScreen<SmartphoneUIMenu> {
	private final static HashMap<String, Object> guistate = SmartphoneUIMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	ImageButton imagebutton_9ee37f666991c7d_1_removebgpre;
	ImageButton imagebutton_warningsign_2;

	public SmartphoneUIScreen(SmartphoneUIMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 151;
		this.ySize = 218;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/smartphone_ui.png");

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
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.smartphone_ui.label_settings").getString(), 16, 198, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.smartphone_ui.label_rp_os_1").getString(), 61, 9, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.smartphone_ui.label_emergency").getString(), 12, 61, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.smartphone_ui.label_call").getString(), 24, 75, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		imagebutton_9ee37f666991c7d_1_removebgpre = new ImageButton(this.guiLeft + 11, this.guiTop + 147, 50, 48, 0, 0, 48, new ResourceLocation("rp_engine:textures/screens/atlas/imagebutton_9ee37f666991c7d_1_removebgpre.png"), 50, 96, e -> {
		});
		guistate.put("button:imagebutton_9ee37f666991c7d_1_removebgpre", imagebutton_9ee37f666991c7d_1_removebgpre);
		this.addButton(imagebutton_9ee37f666991c7d_1_removebgpre);
		imagebutton_warningsign_2 = new ImageButton(this.guiLeft + 11, this.guiTop + 26, 50, 32, 0, 0, 32, new ResourceLocation("rp_engine:textures/screens/atlas/imagebutton_warningsign_2.png"), 50, 64, e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new SmartphoneUIButtonMessage(1, x, y, z));
				SmartphoneUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_warningsign_2", imagebutton_warningsign_2);
		this.addButton(imagebutton_warningsign_2);
	}
}
