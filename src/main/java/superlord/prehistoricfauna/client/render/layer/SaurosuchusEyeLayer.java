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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;

public class SaurosuchusEyeLayer extends LayerRenderer<SaurosuchusEntity, EntityModel<SaurosuchusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_eyeglow.png"));
	private final IEntityRenderer<SaurosuchusEntity, EntityModel<SaurosuchusEntity>> saurosuchusRenderer;
	
	public SaurosuchusEyeLayer(IEntityRenderer<SaurosuchusEntity, EntityModel<SaurosuchusEntity>> saurosuchusRenderer) {
		super(saurosuchusRenderer);
		this.saurosuchusRenderer = saurosuchusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, SaurosuchusEntity saurosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(saurosuchusRenderer.getEntityModel() instanceof SaurosuchusModel)) {
			return;
		}
		long roundTime = saurosuchus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos saurosuchusPos = saurosuchus.getPosition();
		int i = saurosuchus.world.getLightFor(LightType.SKY, saurosuchusPos);
		int j = saurosuchus.world.getLightFor(LightType.BLOCK, saurosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (saurosuchus.isAsleep() || saurosuchus.ticksExisted % 50 >= 0 && saurosuchus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
