package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ChromogisaurusModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ChromogisaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;

public class ChromogisaurusRenderer extends MobRenderer<ChromogisaurusEntity, EntityModel<ChromogisaurusEntity>> {

	private static final ResourceLocation CHROMOGISAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/chromogisaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/melanistic.png");
	private static final ResourceLocation CHROMOGISAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/chromogisaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/melanistic_sleeping.png");
	private static final ChromogisaurusModel CHROMOGISAURUS_MODEL = new ChromogisaurusModel();
	private static final ChromogisaurusSleepingModel CHROMOGISAURUS_SLEEPING_MODEL = new ChromogisaurusSleepingModel();
	
	public ChromogisaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CHROMOGISAURUS_MODEL, 0.375F);
	}
	
	public void render(ChromogisaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = CHROMOGISAURUS_SLEEPING_MODEL;
		} else {
			entityModel = CHROMOGISAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(ChromogisaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	@Override
	public ResourceLocation getEntityTexture(ChromogisaurusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep()) {
				return CHROMOGISAURUS_SLEEPING;
			} else return CHROMOGISAURUS;
		}
	}

}
