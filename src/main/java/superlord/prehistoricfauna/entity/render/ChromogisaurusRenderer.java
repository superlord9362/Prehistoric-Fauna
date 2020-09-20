package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.ChromogisaurusEntity;
import superlord.prehistoricfauna.entity.model.Chromogisaurus;

public class ChromogisaurusRenderer extends MobRenderer<ChromogisaurusEntity, EntityModel<ChromogisaurusEntity>> {

	private static final ResourceLocation CHROMOGISAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/chromogisaurus.png");
	private static final Chromogisaurus CHROMOGISAURUS_MODEL = new Chromogisaurus();
	
	public ChromogisaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CHROMOGISAURUS_MODEL, 0.375F);
	}
	
	public void render(ChromogisaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CHROMOGISAURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallBack(ChromogisaurusEntity chromogisaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if (chromogisaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(ChromogisaurusEntity entity) {
		return CHROMOGISAURUS;
	}

}
