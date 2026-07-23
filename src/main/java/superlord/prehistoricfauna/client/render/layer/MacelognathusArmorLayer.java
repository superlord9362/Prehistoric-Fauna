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
import superlord.prehistoricfauna.client.model.jurassic.morrison.MacelognathusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Macelognathus;

public class MacelognathusArmorLayer extends RenderLayer<Macelognathus, MacelognathusModel> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/macelognathus/macelognathus_armor.png"));
	private final RenderLayerParent<Macelognathus, MacelognathusModel> macelognathusRenderer;
	
	public MacelognathusArmorLayer(RenderLayerParent<Macelognathus, MacelognathusModel> macelognathusRenderer) {
		super(macelognathusRenderer);
		this.macelognathusRenderer = macelognathusRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Macelognathus macelognathus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(macelognathusRenderer.getModel() instanceof MacelognathusModel)) {
			return;
		}
		if (macelognathus.isArmored()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
