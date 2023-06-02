package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entity.henos.Henos;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractHenosGlowLayer<T extends Entity, M extends EntityModel<T>> extends RenderLayer<T, M> {
   public AbstractHenosGlowLayer(RenderLayerParent<T, M> p_i226039_1_) {
      super(p_i226039_1_);
   }

	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Henos entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      VertexConsumer ivertexbuilder = bufferIn.getBuffer(this.getRenderType());
      this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
   }

   public abstract RenderType getRenderType();
}
