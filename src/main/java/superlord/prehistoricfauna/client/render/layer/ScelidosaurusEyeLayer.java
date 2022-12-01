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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScelidosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;

public class ScelidosaurusEyeLayer extends LayerRenderer<ScelidosaurusEntity, EntityModel<ScelidosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/scelidosaurus_eyeglow.png"));
	private final IEntityRenderer<ScelidosaurusEntity, EntityModel<ScelidosaurusEntity>> scelidosaurusRenderer;
	
	public ScelidosaurusEyeLayer(IEntityRenderer<ScelidosaurusEntity, EntityModel<ScelidosaurusEntity>> scelidosaurusRenderer) {
		super(scelidosaurusRenderer);
		this.scelidosaurusRenderer = scelidosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, ScelidosaurusEntity scelidosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(scelidosaurusRenderer.getEntityModel() instanceof ScelidosaurusModel)) {
			return;
		}
		long roundTime = scelidosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos scelidosaurusPos = scelidosaurus.getPosition();
		int i = scelidosaurus.world.getLightFor(LightType.SKY, scelidosaurusPos);
		int j = scelidosaurus.world.getLightFor(LightType.BLOCK, scelidosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (scelidosaurus.isAsleep() || scelidosaurus.ticksExisted % 50 >= 0 && scelidosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
