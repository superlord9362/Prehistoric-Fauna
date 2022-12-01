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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;

public class IschigualastiaEyeLayer extends LayerRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_eyeglow.png"));
	private final IEntityRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> ischigualastiaRenderer;
	
	public IschigualastiaEyeLayer(IEntityRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> ischigualastiaRenderer) {
		super(ischigualastiaRenderer);
		this.ischigualastiaRenderer = ischigualastiaRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, IschigualastiaEntity ischigualastia, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ischigualastiaRenderer.getEntityModel() instanceof IschigualastiaModel)) {
			return;
		}
		long roundTime = ischigualastia.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos ischigualastiaPos = ischigualastia.getPosition();
		int i = ischigualastia.world.getLightFor(LightType.SKY, ischigualastiaPos);
		int j = ischigualastia.world.getLightFor(LightType.BLOCK, ischigualastiaPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (ischigualastia.isAsleep() || ischigualastia.ticksExisted % 50 >= 0 && ischigualastia.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
