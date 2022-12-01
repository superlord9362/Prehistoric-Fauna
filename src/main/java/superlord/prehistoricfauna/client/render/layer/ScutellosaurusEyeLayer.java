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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScutellosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;

public class ScutellosaurusEyeLayer extends LayerRenderer<ScutellosaurusEntity, EntityModel<ScutellosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/scutellosaurus_eyeglow.png"));
	private final IEntityRenderer<ScutellosaurusEntity, EntityModel<ScutellosaurusEntity>> scutellosaurusRenderer;
	
	public ScutellosaurusEyeLayer(IEntityRenderer<ScutellosaurusEntity, EntityModel<ScutellosaurusEntity>> scutellosaurusRenderer) {
		super(scutellosaurusRenderer);
		this.scutellosaurusRenderer = scutellosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, ScutellosaurusEntity scutellosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(scutellosaurusRenderer.getEntityModel() instanceof ScutellosaurusModel)) {
			return;
		}
		long roundTime = scutellosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos scutellosaurusPos = scutellosaurus.getPosition();
		int i = scutellosaurus.world.getLightFor(LightType.SKY, scutellosaurusPos);
		int j = scutellosaurus.world.getLightFor(LightType.BLOCK, scutellosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (scutellosaurus.isAsleep() || scutellosaurus.ticksExisted % 50 >= 0 && scutellosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
