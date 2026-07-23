package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.henos.CorruptedTheropodModel;
import superlord.prehistoricfauna.common.entity.henos.CorruptedTheropod;

public class CorruptedTheropodHeadFiveLayer extends RenderLayer<CorruptedTheropod, CorruptedTheropodModel> {

	public CorruptedTheropodHeadFiveLayer(RenderLayerParent<CorruptedTheropod,CorruptedTheropodModel> p_117346_) {
		super(p_117346_);
	}

	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/corrupted_theropod/head_five_overlay.png"));

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, CorruptedTheropod corruptedTheropod, float p_116670_, float p_116671_, float p_116672_, float p_116673_, float p_116674_, float p_116675_) {
		RenderType tex = null;
		if (!corruptedTheropod.isHeadFiveDead()) {
			if (corruptedTheropod.isInvisible()) {

			} else {
				tex = TEXTURE;
				if(tex != null){
					VertexConsumer ivertexbuilder = bufferIn.getBuffer(TEXTURE);
					this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords(corruptedTheropod, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
				}
			}
		}
	}

}
