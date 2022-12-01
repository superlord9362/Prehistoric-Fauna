package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.ThescelosaurusModel;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;

public class ThescelosaurusRenderer extends MobRenderer<ThescelosaurusEntity, EntityModel<ThescelosaurusEntity>> {

	private static final ResourceLocation THESCELOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/thescelosaurus.png");
	private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/thescelosaurus_baby.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/melanistic_baby.png");
	private static final ResourceLocation THESCELOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/thescelosaurus_sleeping.png");
	private static final ResourceLocation BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/thescelosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/melanistic_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/melanistic_baby_sleeping.png");
	private static final ThescelosaurusModel THESCELOSAURUS_MODEL = new ThescelosaurusModel();

	public ThescelosaurusRenderer(EntityRendererManager rm) {
		super(rm, THESCELOSAURUS_MODEL, 0.55f);
	}

	protected void preRenderCallback(ThescelosaurusEntity thescelosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(ThescelosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = THESCELOSAURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(ThescelosaurusEntity entity) {
		if(entity.isChild() && !entity.isAlbino() && !entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return BABY_SLEEPING;
			} else return BABY;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return THESCELOSAURUS_SLEEPING;
			} else return THESCELOSAURUS;
		}
	}
}