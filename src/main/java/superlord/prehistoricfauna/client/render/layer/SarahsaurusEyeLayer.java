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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

public class SarahsaurusEyeLayer extends LayerRenderer<SarahsaurusEntity, EntityModel<SarahsaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_eyeglow.png"));
	private final IEntityRenderer<SarahsaurusEntity, EntityModel<SarahsaurusEntity>> sarahsaurusRenderer;
	
	public SarahsaurusEyeLayer(IEntityRenderer<SarahsaurusEntity, EntityModel<SarahsaurusEntity>> sarahsaurusRenderer) {
		super(sarahsaurusRenderer);
		this.sarahsaurusRenderer = sarahsaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, SarahsaurusEntity sarahsaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sarahsaurusRenderer.getEntityModel() instanceof SarahsaurusModel)) {
			return;
		}
		long roundTime = sarahsaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos sarahsaurusPos = sarahsaurus.getPosition();
		int i = sarahsaurus.world.getLightFor(LightType.SKY, sarahsaurusPos);
		int j = sarahsaurus.world.getLightFor(LightType.BLOCK, sarahsaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (sarahsaurus.isAsleep() || sarahsaurus.ticksExisted % 50 >= 0 && sarahsaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
