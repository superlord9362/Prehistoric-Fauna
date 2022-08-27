package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ExaeretodonModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ExaeretodonSleepingModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;

public class ExaeretodonRenderer extends MobRenderer<ExaeretodonEntity, EntityModel<ExaeretodonEntity>>{
	
	private static final ResourceLocation EXAERETODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/exaeretodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/melanistic.png");
	private static final ResourceLocation EXAERETODON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/exaeretodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/melanistic_sleeping.png");

	private final static ExaeretodonModel EXAERETODON_MODEL = new ExaeretodonModel();
	private final static ExaeretodonSleepingModel EXAERETODON_SLEEPING_MODEL = new ExaeretodonSleepingModel();
	
	public ExaeretodonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), EXAERETODON_MODEL, 0.75F);
	}
	
	public void render(ExaeretodonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = EXAERETODON_SLEEPING_MODEL;
		} else {
			entityModel = EXAERETODON_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(ExaeretodonEntity exaeretodon, MatrixStack matrixStackIn, float partialTickTime) {
		if(exaeretodon.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(ExaeretodonEntity entity) {
		if(entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep()) {
				return EXAERETODON_SLEEPING;
			} else return EXAERETODON;
		}
	}

}
