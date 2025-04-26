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

import com.themfcraft.rpengine.world.inventory.SetupGUIMenu;
import com.themfcraft.rpengine.network.SetupGUIButtonMessage;
import com.themfcraft.rpengine.RpEngineMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class SetupGUIScreen extends ContainerScreen<SetupGUIMenu> {
	private final static HashMap<String, Object> guistate = SetupGUIMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	Button button_start_setup;

	public SetupGUIScreen(SetupGUIMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 242;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/setup_gui.png");

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
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.setup_gui.label_welcome_to_rp_engine").getString(), 70, 12, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.setup_gui.label_to_make_sure_every_rank_and_job").getString(), 20, 35, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.setup_gui.label_please_click_the_start_setup_but").getString(), 20, 49, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.setup_gui.label_that_in_the_chat_stands_setup").getString(), 51, 64, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_start_setup = new Button(this.guiLeft + 79, this.guiTop + 131, 82, 20, new TranslationTextComponent("gui.rp_engine.setup_gui.button_start_setup"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new SetupGUIButtonMessage(0, x, y, z));
				SetupGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_start_setup", button_start_setup);
		this.addButton(button_start_setup);
	}
}
