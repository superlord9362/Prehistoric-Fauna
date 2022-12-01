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
import superlord.prehistoricfauna.client.model.jurassic.morrison.StegosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;

public class StegosaurusEyeLayer extends LayerRenderer<StegosaurusEntity, EntityModel<StegosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/stegosaurus_eyeglow.png"));
	private final IEntityRenderer<StegosaurusEntity, EntityModel<StegosaurusEntity>> stegosaurusRenderer;
	
	public StegosaurusEyeLayer(IEntityRenderer<StegosaurusEntity, EntityModel<StegosaurusEntity>> stegosaurusRenderer) {
		super(stegosaurusRenderer);
		this.stegosaurusRenderer = stegosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, StegosaurusEntity stegosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(stegosaurusRenderer.getEntityModel() instanceof StegosaurusModel)) {
			return;
		}
		long roundTime = stegosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos stegosaurusPos = stegosaurus.getPosition();
		int i = stegosaurus.world.getLightFor(LightType.SKY, stegosaurusPos);
		int j = stegosaurus.world.getLightFor(LightType.BLOCK, stegosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (stegosaurus.isAsleep() || stegosaurus.ticksExisted % 50 >= 0 && stegosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
