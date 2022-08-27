package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonBaskingModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;

public class EilenodonRenderer extends MobRenderer<EilenodonEntity, EntityModel<EilenodonEntity>> {

	private static final ResourceLocation EILENODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/eilenodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/melanistic.png");
	private static final ResourceLocation EILENODON_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/eilenodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/melanistic_sleeping.png");
	private final static EilenodonModel EILENODON_MODEL = new EilenodonModel();
	private final static EilenodonBaskingModel EILENODON_BASKING = new EilenodonBaskingModel();
	private final static EilenodonSleepingModel EILENODON_SLEEPING = new EilenodonSleepingModel();

	public EilenodonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), EILENODON_MODEL, 0.25F);
	}

	public void render(EilenodonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = EILENODON_SLEEPING;
		} else if (entityIn.isSitting() && !entityIn.isAsleep()) {
			entityModel = EILENODON_BASKING;
		} else {
			entityModel = EILENODON_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(EilenodonEntity eilenodon, MatrixStack matrixStackIn, float partialTickTime) {
		if(eilenodon.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(EilenodonEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep()) {
				return EILENODON_SLEEPING_TEXTURE;
			} else {
				return EILENODON;
			}
		}
	}
}