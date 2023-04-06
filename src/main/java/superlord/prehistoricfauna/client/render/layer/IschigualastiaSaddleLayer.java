package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;

public class IschigualastiaSaddleLayer extends LayerRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEntityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_saddle_layer.png"));
	private final IEntityRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> ischigualastiaRenderer;
	
	public IschigualastiaSaddleLayer(IEntityRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> ischigualasiaRenderer) {
		super(ischigualasiaRenderer);
		this.ischigualastiaRenderer = ischigualasiaRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, IschigualastiaEntity ischigualasia, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ischigualastiaRenderer.getEntityModel() instanceof IschigualastiaModel)) {
			return;
		}
		if (ischigualasia.getSaddled()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
