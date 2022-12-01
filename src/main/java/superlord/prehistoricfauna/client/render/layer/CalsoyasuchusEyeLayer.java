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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.CalsoyasuchusModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.CalsoyasuchusEntity;

public class CalsoyasuchusEyeLayer extends LayerRenderer<CalsoyasuchusEntity, EntityModel<CalsoyasuchusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/calsoyasuchus_eyeglow.png"));
	private final IEntityRenderer<CalsoyasuchusEntity, EntityModel<CalsoyasuchusEntity>> calsoyasuchusRenderer;
	
	public CalsoyasuchusEyeLayer(IEntityRenderer<CalsoyasuchusEntity, EntityModel<CalsoyasuchusEntity>> calsoyasuchusRenderer) {
		super(calsoyasuchusRenderer);
		this.calsoyasuchusRenderer = calsoyasuchusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, CalsoyasuchusEntity calsoyasuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(calsoyasuchusRenderer.getEntityModel() instanceof CalsoyasuchusModel)) {
			return;
		}
		long roundTime = calsoyasuchus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos calsoyasuchusPos = calsoyasuchus.getPosition();
		int i = calsoyasuchus.world.getLightFor(LightType.SKY, calsoyasuchusPos);
		int j = calsoyasuchus.world.getLightFor(LightType.BLOCK, calsoyasuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (calsoyasuchus.isAsleep() || calsoyasuchus.ticksExisted % 50 >= 0 && calsoyasuchus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
