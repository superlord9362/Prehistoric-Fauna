package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnkylosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnkylosaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;

public class AnkylosaurusRenderer extends MobRenderer<AnkylosaurusEntity, EntityModel<AnkylosaurusEntity>> {

	private static final ResourceLocation ANKYLOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic.png");
	private static final ResourceLocation ANKYLOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic_sleeping.png");
	private static final AnkylosaurusModel ANKYLOSAURUS_MODEL = new AnkylosaurusModel();
	private static final AnkylosaurusSleepingModel ANKYLOSAURUS_SLEEPING_MODEL = new AnkylosaurusSleepingModel();

	public AnkylosaurusRenderer(EntityRendererManager rm) {
		super(rm, ANKYLOSAURUS_MODEL, 2F);
	}

	protected void preRenderCallback(AnkylosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(AnkylosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = ANKYLOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = ANKYLOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(AnkylosaurusEntity entity) {
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
				return ANKYLOSAURUS_SLEEPING;
			} else return ANKYLOSAURUS;
		}
	}

}
