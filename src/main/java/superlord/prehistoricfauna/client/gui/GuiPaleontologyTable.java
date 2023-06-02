package superlord.prehistoricfauna.client.gui;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.container.PaleontologyTableMenu;

@OnlyIn(Dist.CLIENT)
public class GuiPaleontologyTable extends AbstractContainerScreen<PaleontologyTableMenu>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/gui/container/paleotable.png");

	private static final int SCREEN_WIDTH = 176;
    private static final int SCREEN_HEIGHT = 166;
	
	public GuiPaleontologyTable(PaleontologyTableMenu screenContainer, Inventory inv, Component titleIn)
	{
		super(screenContainer, inv, titleIn);
		this.width = SCREEN_WIDTH;
		this.height = SCREEN_HEIGHT;
	}
	
	@Override
	protected void init() {
		super.init();
	}

	@Override
	protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY)
	{
		Lighting.setupForFlatItems();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		this.blit(matrixStack, leftPos, topPos, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		if (menu.isCrafting()) {
			this.blit(matrixStack, this.leftPos, this.topPos, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
			this.blit(matrixStack, this.leftPos + 60, this.topPos + 44, 178, 2, this.menu.getScaledProgress(26), 16);
		}
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}
}
