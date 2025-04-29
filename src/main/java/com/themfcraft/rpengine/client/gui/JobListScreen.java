package com.themfcraft.rpengine.client.gui;

public class JobListScreen extends ContainerScreen<JobListMenu> {

	private final static HashMap<String, Object> guistate = JobListMenu.guistate;

	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;

	public JobListScreen(JobListMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 318;
		this.ySize = 185;
	}

	private static final ResourceLocation texture = new ResourceLocation("rp_engine:textures/screens/job_list.png");

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
		this.font.drawString(poseStack, new TranslationTextComponent("gui.rp_engine.job_list.label_please_choose_a_job").getString(), 109, 12, -12829636);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);

	}
}
