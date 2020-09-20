package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.HyperodapedonEntity;
import superlord.prehistoricfauna.entity.model.Hyperodapedon;

public class HyperodapedonRenderer extends MobRenderer<HyperodapedonEntity, EntityModel<HyperodapedonEntity>> {
	
	private static final ResourceLocation HYPERODAPEDON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/hyperodapedon.png");
	private static final Hyperodapedon HYPERODAPEDON_MODEL = new Hyperodapedon();

	public HyperodapedonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), HYPERODAPEDON_MODEL, 0.325F);
	}
	
	public void render(HyperodapedonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = HYPERODAPEDON_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(HyperodapedonEntity hyperodapedon, MatrixStack matrixStackIn, float partialTickTime) {
		if (hyperodapedon.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(HyperodapedonEntity entity) {
		return HYPERODAPEDON;
	}
	
}
