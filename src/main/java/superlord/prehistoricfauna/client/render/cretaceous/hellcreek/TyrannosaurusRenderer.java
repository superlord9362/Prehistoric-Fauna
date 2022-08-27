package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexSleepingModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexjuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexjuvenileSleepingModel;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;

public class TyrannosaurusRenderer extends MobRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> {

	private static final ResourceLocation TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex.png");
	private static final ResourceLocation BABY_TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrexjuv.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino.png");
	private static final ResourceLocation BABY_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_juv.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic.png");
	private static final ResourceLocation BABY_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_juv.png");
	private static final ResourceLocation TYRANNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_sleeping.png");
	private static final ResourceLocation BABY_TYRANNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrexjuv_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_sleeping.png");
	private static final ResourceLocation BABY_ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_juv_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_sleeping.png");
	private static final ResourceLocation BABY_MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_juv_sleeping.png");
	private static final TyrannosaurusrexModel TYRANNOSAURUS_MODEL = new TyrannosaurusrexModel();
	private static final TyrannosaurusrexSleepingModel TYRANNOSAURUS_SLEEPING_MODEL = new TyrannosaurusrexSleepingModel();
	private static final TyrannosaurusrexjuvenileModel BABY_TYRANNOSAURUS_MODEL = new TyrannosaurusrexjuvenileModel();
	private static final TyrannosaurusrexjuvenileSleepingModel BABY_TYRANNOSAURUS_SLEEPING_MODEL = new TyrannosaurusrexjuvenileSleepingModel();

	public TyrannosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TYRANNOSAURUS_MODEL, 2F);
	}

	public void render(TyrannosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			if (entityIn.isAsleep()) {
				entityModel = BABY_TYRANNOSAURUS_SLEEPING_MODEL;
			} else {
				entityModel = BABY_TYRANNOSAURUS_MODEL;
			}
		} else {
			if (entityIn.isAsleep()) {
				entityModel = TYRANNOSAURUS_SLEEPING_MODEL;
			} else {
				entityModel = TYRANNOSAURUS_MODEL;
			}
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(TyrannosaurusEntity triceratops, MatrixStack matrixStackIn, float partialTickTime) {
		if(triceratops.isChild() && !triceratops.isJuvenile()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(TyrannosaurusEntity entity) {
		if (entity.isAlbino() && !entity.isChild()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isAlbino() && entity.isChild()) {
			if (entity.isAsleep()) {
				return BABY_ALBINO_SLEEPING;
			} else return BABY_ALBINO;
		} else if (entity.isMelanistic() && !entity.isChild()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isMelanistic() && entity.isChild()) {
			if (entity.isAsleep()) {
				return BABY_MELANISTIC_SLEEPING;
			} else return BABY_MELANISTIC;
		} else if(entity.isChild()) {
			if (entity.isAsleep()) {
				return BABY_TYRANNOSAURUS_SLEEPING;
			} else return BABY_TYRANNOSAURUS;
		} else {
			if (entity.isAsleep()) {
				return TYRANNOSAURUS_SLEEPING;
			} else return TYRANNOSAURUS;
		}
	}

}
