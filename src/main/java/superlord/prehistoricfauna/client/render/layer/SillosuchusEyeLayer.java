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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;

public class SillosuchusEyeLayer extends LayerRenderer<SillosuchusEntity, EntityModel<SillosuchusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus_eyeglow.png"));
	private final IEntityRenderer<SillosuchusEntity, EntityModel<SillosuchusEntity>> sillosuchusRenderer;
	
	public SillosuchusEyeLayer(IEntityRenderer<SillosuchusEntity, EntityModel<SillosuchusEntity>> sillosuchusRenderer) {
		super(sillosuchusRenderer);
		this.sillosuchusRenderer = sillosuchusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, SillosuchusEntity sillosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sillosuchusRenderer.getEntityModel() instanceof SillosuchusModel)) {
			return;
		}
		long roundTime = sillosuchus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos sillosuchusPos = sillosuchus.getPosition();
		int i = sillosuchus.world.getLightFor(LightType.SKY, sillosuchusPos);
		int j = sillosuchus.world.getLightFor(LightType.BLOCK, sillosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (sillosuchus.isAsleep() || sillosuchus.ticksExisted % 50 >= 0 && sillosuchus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
