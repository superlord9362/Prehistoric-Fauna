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
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonBaskingModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;

public class EilenodonBaskingEyeLayer extends LayerRenderer<EilenodonEntity, EntityModel<EilenodonEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/eilenodon_eyeglow.png"));
	private final IEntityRenderer<EilenodonEntity, EntityModel<EilenodonEntity>> eilenodonRenderer;
	
	public EilenodonBaskingEyeLayer(IEntityRenderer<EilenodonEntity, EntityModel<EilenodonEntity>> eilenodonRenderer) {
		super(eilenodonRenderer);
		this.eilenodonRenderer = eilenodonRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EilenodonEntity eilenodon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(eilenodonRenderer.getEntityModel() instanceof EilenodonBaskingModel)) {
			return;
		}
		long roundTime = eilenodon.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos eilenodonPos = eilenodon.getPosition();
		int i = eilenodon.world.getLightFor(LightType.SKY, eilenodonPos);
		int j = eilenodon.world.getLightFor(LightType.BLOCK, eilenodonPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (eilenodon.isAsleep() || eilenodon.ticksExisted % 50 >= 0 && eilenodon.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
