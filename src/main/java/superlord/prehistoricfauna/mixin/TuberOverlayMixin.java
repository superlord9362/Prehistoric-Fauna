package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.ForgeIngameGui;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFItems;

@Mixin(ForgeIngameGui.class)
public abstract class TuberOverlayMixin {

	private static final ResourceLocation TUBER_LOCATION = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/misc/tuber_head.png");

	@SuppressWarnings({ "resource" })
	@Inject(method = "Lnet/minecraftforge/client/gui/ForgeIngameGui;renderHelmet(FLcom/mojang/blaze3d/vertex/PoseStack;)V", at = @At("HEAD"), remap = false)
	void renderHelmet(float f, PoseStack guiGraphics, CallbackInfo ci) {
		ItemStack itemstack = Minecraft.getInstance().player.getInventory().getArmor(3);
		if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && !itemstack.isEmpty()) {
			Item item = itemstack.getItem();
			if (item == PFItems.CARVED_TUBER.get())
			{
				renderTextureOverlay(TUBER_LOCATION, 1.0F);
			}
		}

	}

	 @SuppressWarnings("resource")
	protected void renderTextureOverlay(ResourceLocation p_168709_, float p_168710_) {
	      RenderSystem.disableDepthTest();
	      RenderSystem.depthMask(false);
	      RenderSystem.defaultBlendFunc();
	      RenderSystem.setShader(GameRenderer::getPositionTexShader);
	      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, p_168710_);
	      RenderSystem.setShaderTexture(0, p_168709_);
	      Tesselator tesselator = Tesselator.getInstance();
	      BufferBuilder bufferbuilder = tesselator.getBuilder();
	      bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
	      bufferbuilder.vertex(0.0D, Minecraft.getInstance().gui.screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
	      bufferbuilder.vertex(Minecraft.getInstance().gui.screenWidth, Minecraft.getInstance().gui.screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
	      bufferbuilder.vertex(Minecraft.getInstance().gui.screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
	      bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
	      tesselator.end();
	      RenderSystem.depthMask(true);
	      RenderSystem.enableDepthTest();
	      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	   }
}
