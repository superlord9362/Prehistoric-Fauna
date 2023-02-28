package superlord.prehistoricfauna.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class IndexPageButton extends Button {

    public IndexPageButton(int x, int y, Component buttonText, net.minecraft.client.gui.components.Button.OnPress butn) {
        super(x, y, 160, 32, buttonText, butn);
        this.width = 160;
        this.height = 32;
    }

    @SuppressWarnings("resource")
	@Override
    public void renderButton(@NotNull PoseStack matrixStack, int mouseX, int mouseY, float partial) {
        if (this.active) {
            Font font = Minecraft.getInstance().font;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/widgets.png"));
            boolean flag = isHoveredOrFocused();
            this.blit(matrixStack, this.x, this.y, 0, flag ? 32 : 0, this.width, this.height);
            int j = flag ? 0XFAE67D : 0X303030;
            font.draw(matrixStack, this.getMessage().getVisualOrderText(), (this.x + this.width / 2 - font.width(this.getMessage().getString()) / 2), this.y + (this.height - 8) / 2, j | Mth.ceil(this.alpha * 255.0F) << 24);
        }
    }
}
