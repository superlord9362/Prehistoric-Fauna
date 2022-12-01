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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HyperodapedonModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;

public class HyperodapedonEyeLayer extends LayerRenderer<HyperodapedonEntity, EntityModel<HyperodapedonEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/hyperodapedon_eyeglow.png"));
	private final IEntityRenderer<HyperodapedonEntity, EntityModel<HyperodapedonEntity>> hyperodapedonRenderer;
	
	public HyperodapedonEyeLayer(IEntityRenderer<HyperodapedonEntity, EntityModel<HyperodapedonEntity>> hyperodapedonRenderer) {
		super(hyperodapedonRenderer);
		this.hyperodapedonRenderer = hyperodapedonRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, HyperodapedonEntity hyperodapedon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(hyperodapedonRenderer.getEntityModel() instanceof HyperodapedonModel)) {
			return;
		}
		long roundTime = hyperodapedon.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos hyperodapedonPos = hyperodapedon.getPosition();
		int i = hyperodapedon.world.getLightFor(LightType.SKY, hyperodapedonPos);
		int j = hyperodapedon.world.getLightFor(LightType.BLOCK, hyperodapedonPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (hyperodapedon.isAsleep() || hyperodapedon.ticksExisted % 50 >= 0 && hyperodapedon.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
