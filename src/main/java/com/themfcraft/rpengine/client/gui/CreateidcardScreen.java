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

import com.themfcraft.rpengine.world.inventory.CreateidcardMenu;
import com.themfcraft.rpengine.network.CreateidcardButtonMessage;
import com.themfcraft.rpengine.RpEngineMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class CreateidcardScreen extends ContainerScreen<CreateidcardMenu> {
	private final static HashMap<String, Object> guistate = CreateidcardMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	Button button_click_here_for_id_card;

	public CreateidcardScreen(CreateidcardMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/createidcard.png");

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
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.createidcard.label_welcome_to_the_registrator").getString(), 23, 11, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		button_click_here_for_id_card = new Button(this.guiLeft + 17, this.guiTop + 131, 139, 20, new TranslationTextComponent("gui.rp_engine.createidcard.button_click_here_for_id_card"), e -> {
			if (true) {
				RpEngineMod.PACKET_HANDLER.sendToServer(new CreateidcardButtonMessage(0, x, y, z));
				CreateidcardButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_click_here_for_id_card", button_click_here_for_id_card);
		this.addButton(button_click_here_for_id_card);
	}
}
