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
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;

public class CeratosaurusEyeLayer extends LayerRenderer<CeratosaurusEntity, EntityModel<CeratosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_eyeglow.png"));
	private final IEntityRenderer<CeratosaurusEntity, EntityModel<CeratosaurusEntity>> ceratosaurusRenderer;
	
	public CeratosaurusEyeLayer(IEntityRenderer<CeratosaurusEntity, EntityModel<CeratosaurusEntity>> ceratosaurusRenderer) {
		super(ceratosaurusRenderer);
		this.ceratosaurusRenderer = ceratosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, CeratosaurusEntity ceratosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ceratosaurusRenderer.getEntityModel() instanceof CeratosaurusModel)) {
			return;
		}
		long roundTime = ceratosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos ceratosaurusPos = ceratosaurus.getPosition();
		int i = ceratosaurus.world.getLightFor(LightType.SKY, ceratosaurusPos);
		int j = ceratosaurus.world.getLightFor(LightType.BLOCK, ceratosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (ceratosaurus.isAsleep() || ceratosaurus.ticksExisted % 50 >= 0 && ceratosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
