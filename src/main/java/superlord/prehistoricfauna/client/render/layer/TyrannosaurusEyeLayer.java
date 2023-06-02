package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LightLayer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;

public class TyrannosaurusEyeLayer extends RenderLayer<Tyrannosaurus, EntityModel<Tyrannosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_eyeglow.png"));
	private final RenderLayerParent<Tyrannosaurus, EntityModel<Tyrannosaurus>> tyrannosaurusRenderer;
	
	public TyrannosaurusEyeLayer(RenderLayerParent<Tyrannosaurus, EntityModel<Tyrannosaurus>> rendererIn) {
		super(rendererIn);
		this.tyrannosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Tyrannosaurus tyrannosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(tyrannosaurusRenderer.getModel() instanceof TyrannosaurusModel)) {
			return;
		}
		long roundTime = tyrannosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos tyrannosaurusPos = tyrannosaurus.blockPosition();
		int i = tyrannosaurus.level.getBrightness(LightLayer.SKY, tyrannosaurusPos);
		int j = tyrannosaurus.level.getBrightness(LightLayer.BLOCK, tyrannosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (tyrannosaurus.isAsleep() || tyrannosaurus.tickCount % 50 >= 0 && tyrannosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
