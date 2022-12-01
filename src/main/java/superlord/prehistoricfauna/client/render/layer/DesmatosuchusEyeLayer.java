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
import superlord.prehistoricfauna.client.model.triassic.chinle.DesmatosuchusModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;

public class DesmatosuchusEyeLayer extends LayerRenderer<DesmatosuchusEntity, EntityModel<DesmatosuchusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/desmatosuchus_eyeglow.png"));
	private final IEntityRenderer<DesmatosuchusEntity, EntityModel<DesmatosuchusEntity>> desmatosuchusRenderer;
	
	public DesmatosuchusEyeLayer(IEntityRenderer<DesmatosuchusEntity, EntityModel<DesmatosuchusEntity>> desmatosuchusRenderer) {
		super(desmatosuchusRenderer);
		this.desmatosuchusRenderer = desmatosuchusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, DesmatosuchusEntity desmatosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(desmatosuchusRenderer.getEntityModel() instanceof DesmatosuchusModel)) {
			return;
		}
		long roundTime = desmatosuchus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos desmatosuchusPos = desmatosuchus.getPosition();
		int i = desmatosuchus.world.getLightFor(LightType.SKY, desmatosuchusPos);
		int j = desmatosuchus.world.getLightFor(LightType.BLOCK, desmatosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (desmatosuchus.isAsleep() || desmatosuchus.ticksExisted % 50 >= 0 && desmatosuchus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
