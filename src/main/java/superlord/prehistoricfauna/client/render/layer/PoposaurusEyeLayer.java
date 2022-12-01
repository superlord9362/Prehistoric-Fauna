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
import superlord.prehistoricfauna.client.model.triassic.chinle.PoposaurusModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;

public class PoposaurusEyeLayer extends LayerRenderer<PoposaurusEntity, EntityModel<PoposaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/poposaurus_eyeglow.png"));
	private final IEntityRenderer<PoposaurusEntity, EntityModel<PoposaurusEntity>> poposaurusRenderer;
	
	public PoposaurusEyeLayer(IEntityRenderer<PoposaurusEntity, EntityModel<PoposaurusEntity>> poposaurusRenderer) {
		super(poposaurusRenderer);
		this.poposaurusRenderer = poposaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, PoposaurusEntity poposaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(poposaurusRenderer.getEntityModel() instanceof PoposaurusModel)) {
			return;
		}
		long roundTime = poposaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos poposaurusPos = poposaurus.getPosition();
		int i = poposaurus.world.getLightFor(LightType.SKY, poposaurusPos);
		int j = poposaurus.world.getLightFor(LightType.BLOCK, poposaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (poposaurus.isAsleep() || poposaurus.ticksExisted % 50 >= 0 && poposaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
