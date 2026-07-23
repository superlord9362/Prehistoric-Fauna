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
import superlord.prehistoricfauna.client.model.jurassic.morrison.TanycolagreusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Tanycolagreus;

public class TanycolagreusArmorLayer extends RenderLayer<Tanycolagreus, TanycolagreusModel> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tanycolagreus/tanycolagreus_armor.png"));
	private final RenderLayerParent<Tanycolagreus, TanycolagreusModel> tanycolagreusRenderer;
	
	public TanycolagreusArmorLayer(RenderLayerParent<Tanycolagreus, TanycolagreusModel> tanycolagreusRenderer) {
		super(tanycolagreusRenderer);
		this.tanycolagreusRenderer = tanycolagreusRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Tanycolagreus tanycolagreus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(tanycolagreusRenderer.getModel() instanceof TanycolagreusModel)) {
			return;
		}
		if (tanycolagreus.isArmored()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
