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
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;

public class AllosaurusEyeLayer extends LayerRenderer<AllosaurusEntity, EntityModel<AllosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus_eyeglow.png"));
	private final IEntityRenderer<AllosaurusEntity, EntityModel<AllosaurusEntity>> allosaurusRenderer;
	
	public AllosaurusEyeLayer(IEntityRenderer<AllosaurusEntity, EntityModel<AllosaurusEntity>> allosaurusRenderer) {
		super(allosaurusRenderer);
		this.allosaurusRenderer = allosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AllosaurusEntity allosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(allosaurusRenderer.getEntityModel() instanceof AllosaurusModel)) {
			return;
		}
		long roundTime = allosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos allosaurusPos = allosaurus.getPosition();
		int i = allosaurus.world.getLightFor(LightType.SKY, allosaurusPos);
		int j = allosaurus.world.getLightFor(LightType.BLOCK, allosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (allosaurus.isAsleep() || allosaurus.ticksExisted % 50 >= 0 && allosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
