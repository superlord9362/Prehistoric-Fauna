package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;

@OnlyIn(Dist.CLIENT)
public class HenosGemGlowLayer extends AbstractHenosGlowLayer<TimeGuardianEntity, EntityModel<TimeGuardianEntity>> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/henos_gem_layer.png"));

	public HenosGemGlowLayer(IEntityRenderer<TimeGuardianEntity, EntityModel<TimeGuardianEntity>> rendererIn) {
		super(rendererIn);
	}

	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, TimeGuardianEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.getRenderType());
		this.getEntityModel().render(matrixStackIn, ivertexbuilder, 0, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

}
