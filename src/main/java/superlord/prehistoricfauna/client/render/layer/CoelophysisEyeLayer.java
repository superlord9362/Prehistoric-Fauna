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
import superlord.prehistoricfauna.client.model.triassic.chinle.CoelophysisModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;

public class CoelophysisEyeLayer extends LayerRenderer<CoelophysisEntity, EntityModel<CoelophysisEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/coelophysis_eyeglow.png"));
	private final IEntityRenderer<CoelophysisEntity, EntityModel<CoelophysisEntity>> coelophysisRenderer;
	
	public CoelophysisEyeLayer(IEntityRenderer<CoelophysisEntity, EntityModel<CoelophysisEntity>> coelophysisRenderer) {
		super(coelophysisRenderer);
		this.coelophysisRenderer = coelophysisRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, CoelophysisEntity coelophysis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(coelophysisRenderer.getEntityModel() instanceof CoelophysisModel)) {
			return;
		}
		long roundTime = coelophysis.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos coelophysisPos = coelophysis.getPosition();
		int i = coelophysis.world.getLightFor(LightType.SKY, coelophysisPos);
		int j = coelophysis.world.getLightFor(LightType.BLOCK, coelophysisPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (coelophysis.isAsleep() || coelophysis.ticksExisted % 50 >= 0 && coelophysis.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
