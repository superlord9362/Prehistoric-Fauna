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
import superlord.prehistoricfauna.client.model.triassic.chinle.PostosuchusModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;

public class PostosuchusEyeLayer extends LayerRenderer<PostosuchusEntity, EntityModel<PostosuchusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/postosuchus_eyeglow.png"));
	private final IEntityRenderer<PostosuchusEntity, EntityModel<PostosuchusEntity>> postosuchusRenderer;
	
	public PostosuchusEyeLayer(IEntityRenderer<PostosuchusEntity, EntityModel<PostosuchusEntity>> postosuchusRenderer) {
		super(postosuchusRenderer);
		this.postosuchusRenderer = postosuchusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, PostosuchusEntity postosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(postosuchusRenderer.getEntityModel() instanceof PostosuchusModel)) {
			return;
		}
		long roundTime = postosuchus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos postosuchusPos = postosuchus.getPosition();
		int i = postosuchus.world.getLightFor(LightType.SKY, postosuchusPos);
		int j = postosuchus.world.getLightFor(LightType.BLOCK, postosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (postosuchus.isAsleep() || postosuchus.ticksExisted % 50 >= 0 && postosuchus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
