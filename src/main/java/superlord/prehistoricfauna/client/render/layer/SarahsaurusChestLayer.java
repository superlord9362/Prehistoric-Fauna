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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;

public class SarahsaurusChestLayer extends RenderLayer<Sarahsaurus, SarahsaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/sarahsaurus_chest_layer.png"));
	private final RenderLayerParent<Sarahsaurus, SarahsaurusModel> sarahsaurusRenderer;
	
	public SarahsaurusChestLayer(RenderLayerParent<Sarahsaurus, SarahsaurusModel> sarahsaurusRenderer) {
		super(sarahsaurusRenderer);
		this.sarahsaurusRenderer = sarahsaurusRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sarahsaurus sarahsaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sarahsaurusRenderer.getModel() instanceof SarahsaurusModel)) {
			return;
		}
		if (sarahsaurus.hasChest()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
