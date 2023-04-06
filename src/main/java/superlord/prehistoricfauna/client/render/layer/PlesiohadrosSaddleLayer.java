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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;

public class PlesiohadrosSaddleLayer extends LayerRenderer<PlesiohadrosEntity, EntityModel<PlesiohadrosEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEntityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_saddle_layer.png"));
	private final IEntityRenderer<PlesiohadrosEntity, EntityModel<PlesiohadrosEntity>> plesiohadrosRenderer;
	
	public PlesiohadrosSaddleLayer(IEntityRenderer<PlesiohadrosEntity, EntityModel<PlesiohadrosEntity>> plesiohadrosRenderer) {
		super(plesiohadrosRenderer);
		this.plesiohadrosRenderer = plesiohadrosRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, PlesiohadrosEntity plesiohadros, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(plesiohadrosRenderer.getEntityModel() instanceof PlesiohadrosModel)) {
			return;
		}
		if (plesiohadros.isSaddled()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
