package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.SinosauropteryxModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Sinosauropteryx;

public class SinosauropteryxArmorLayer extends RenderLayer<Sinosauropteryx, SinosauropteryxModel> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sinosauropteryx/sinosauropteryx_armor.png"));
	private final RenderLayerParent<Sinosauropteryx, SinosauropteryxModel> sinosauropteryxRenderer;
	
	public SinosauropteryxArmorLayer(RenderLayerParent<Sinosauropteryx, SinosauropteryxModel> sinosauropteryxRenderer) {
		super(sinosauropteryxRenderer);
		this.sinosauropteryxRenderer = sinosauropteryxRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sinosauropteryx sinosauropteryx, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sinosauropteryxRenderer.getModel() instanceof SinosauropteryxModel)) {
			return;
		}
		if (sinosauropteryx.isArmored()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
