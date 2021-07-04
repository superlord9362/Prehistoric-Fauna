package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Chromogisaurus;
import superlord.prehistoricfauna.common.entities.ChromogisaurusEntity;

public class ChromogisaurusRenderer extends MobRenderer<ChromogisaurusEntity, EntityModel<ChromogisaurusEntity>> {

	private static final ResourceLocation CHROMOGISAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus.png");
	private static final Chromogisaurus CHROMOGISAURUS_MODEL = new Chromogisaurus();
	
	public ChromogisaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CHROMOGISAURUS_MODEL, 0.375F);
	}
	
	public void render(ChromogisaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CHROMOGISAURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(ChromogisaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	@Override
	public ResourceLocation getEntityTexture(ChromogisaurusEntity entity) {
		return CHROMOGISAURUS;
	}

}
