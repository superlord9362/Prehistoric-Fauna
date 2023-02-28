package superlord.prehistoricfauna.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.container.PaleontologyTableContainer;

@OnlyIn(Dist.CLIENT)
public class GuiPaleontologyTable extends AbstractContainerScreen<PaleontologyTableContainer>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/gui/container/paleotable.png");

	public GuiPaleontologyTable(PaleontologyTableContainer screenContainer, Inventory inv, Component titleIn)
	{
		super(screenContainer, inv, titleIn);

		this.leftPos = 0;
		this.topPos = 0;
		this.width = 176;
		this.height = 166;
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        this.renderBg(matrixStack, partialTicks, mouseX, mouseY);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY)
	{
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().getTexture(TEXTURE);
		this.blit(matrixStack, this.leftPos, this.topPos, 0, 0, this.width, this.height);
		this.blit(matrixStack, this.leftPos + 60, this.topPos + 44, 178, 2, this.menu.getWorkProgressionScaled(26), 16);
	}
}
