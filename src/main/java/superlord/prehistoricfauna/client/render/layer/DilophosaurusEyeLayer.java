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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;

public class DilophosaurusEyeLayer extends LayerRenderer<DilophosaurusEntity, EntityModel<DilophosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_eyeglow.png"));
	private final IEntityRenderer<DilophosaurusEntity, EntityModel<DilophosaurusEntity>> dilophosaurusRenderer;
	
	public DilophosaurusEyeLayer(IEntityRenderer<DilophosaurusEntity, EntityModel<DilophosaurusEntity>> dilophosaurusRenderer) {
		super(dilophosaurusRenderer);
		this.dilophosaurusRenderer = dilophosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, DilophosaurusEntity dilophosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(dilophosaurusRenderer.getEntityModel() instanceof DilophosaurusModel)) {
			return;
		}
		long roundTime = dilophosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos dilophosaurusPos = dilophosaurus.getPosition();
		int i = dilophosaurus.world.getLightFor(LightType.SKY, dilophosaurusPos);
		int j = dilophosaurus.world.getLightFor(LightType.BLOCK, dilophosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (dilophosaurus.isAsleep() || dilophosaurus.ticksExisted % 50 >= 0 && dilophosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
