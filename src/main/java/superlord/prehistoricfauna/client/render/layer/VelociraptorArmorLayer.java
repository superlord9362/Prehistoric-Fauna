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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.VelociraptorModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;

public class VelociraptorArmorLayer extends RenderLayer<Velociraptor, VelociraptorModel> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/velociraptor/velociraptor_armor.png"));
	private final RenderLayerParent<Velociraptor, VelociraptorModel> velociraptorRenderer;
	
	public VelociraptorArmorLayer(RenderLayerParent<Velociraptor, VelociraptorModel> velociraptorRenderer) {
		super(velociraptorRenderer);
		this.velociraptorRenderer = velociraptorRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Velociraptor velociraptor, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(velociraptorRenderer.getModel() instanceof VelociraptorModel)) {
			return;
		}
		if (velociraptor.isArmored()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
