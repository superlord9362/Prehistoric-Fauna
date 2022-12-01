package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexjuvenileModel;
import superlord.prehistoricfauna.client.render.layer.TyrannosaurusEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TyrannosaurusJuvEyeLayer;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

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
	private static final ResourceLocation SUB_TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_sub.png");
	private static final ResourceLocation SUB_TYRANNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_sub_sleeping.png");
	private static final ResourceLocation SUB_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_sub.png");
	private static final ResourceLocation SUB_ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_sub_sleeping.png");
	private static final TyrannosaurusrexModel TYRANNOSAURUS_MODEL = new TyrannosaurusrexModel();
	private static final TyrannosaurusrexjuvenileModel BABY_TYRANNOSAURUS_MODEL = new TyrannosaurusrexjuvenileModel();

	public TyrannosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TYRANNOSAURUS_MODEL, 2F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TyrannosaurusEyeLayer(this));
			this.addLayer(new TyrannosaurusJuvEyeLayer(this));
		}
	}

	public void render(TyrannosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			entityModel = BABY_TYRANNOSAURUS_MODEL;
		} else {
			entityModel = TYRANNOSAURUS_MODEL;
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
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isAlbino() && entity.isChild() && !entity.isJuvenile()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return BABY_ALBINO_SLEEPING;
			} else return BABY_ALBINO;
		} else if (entity.isAlbino() && entity.isJuvenile()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return SUB_ALBINO_SLEEPING;
			} else return SUB_ALBINO;
		} else if (entity.isMelanistic() && !entity.isChild()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isMelanistic() && entity.isChild() && !entity.isJuvenile()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return BABY_MELANISTIC_SLEEPING;
			} else return BABY_MELANISTIC;
		} else if(entity.isChild() && !entity.isJuvenile()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return BABY_TYRANNOSAURUS_SLEEPING;
			} else return BABY_TYRANNOSAURUS;
		} else if (entity.isJuvenile()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return SUB_TYRANNOSAURUS_SLEEPING;
			} else return SUB_TYRANNOSAURUS;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return TYRANNOSAURUS_SLEEPING;
			} else return TYRANNOSAURUS;
		}
	}

}
