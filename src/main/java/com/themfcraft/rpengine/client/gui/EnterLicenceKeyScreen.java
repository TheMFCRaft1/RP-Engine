package com.themfcraft.rpengine.client.gui;

public class EnterLicenceKeyScreen extends ContainerScreen<EnterLicenceKeyMenu> {

	private final static HashMap<String, Object> guistate = EnterLicenceKeyMenu.guistate;

	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;

	TextFieldWidget licencekeyinput;

	Button button_submit;

	public EnterLicenceKeyScreen(EnterLicenceKeyMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 268;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/enter_licence_key.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);

		licencekeyinput.render(ms, mouseX, mouseY, partialTicks);

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

		if (licencekeyinput.isFocused())
			return licencekeyinput.keyPressed(key, b, c);

		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		licencekeyinput.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String licencekeyinputValue = licencekeyinput.getText();
		super.resize(minecraft, width, height);
		licencekeyinput.setText(licencekeyinputValue);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack poseStack, int mouseX, int mouseY) {
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.enter_licence_key.label_please_enter_your_licence_key").getString(), 65, 11, -12829636);
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.enter_licence_key.label_dont_have_one_yet_go_to_cylone").getString(), 20, 147, -16776961);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);

		licencekeyinput = new TextFieldWidget(this.font, this.guiLeft + 81, this.guiTop + 80, 118, 18, new TranslationTextComponent("gui.rp_engine.enter_licence_key.licencekeyinput"));
		licencekeyinput.setMaxStringLength(32767);

		guistate.put("text:licencekeyinput", licencekeyinput);
		this.children.add(this.licencekeyinput);

		button_submit = new Button(this.guiLeft + 110, this.guiTop + 113, 56, 20, new TranslationTextComponent("gui.rp_engine.enter_licence_key.button_submit"), e -> {
		});

		guistate.put("button:button_submit", button_submit);
		this.addButton(button_submit);

	}
}
