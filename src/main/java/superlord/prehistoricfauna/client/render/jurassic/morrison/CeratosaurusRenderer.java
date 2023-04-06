package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.client.render.layer.CeratosaurusEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CeratosaurusRenderer extends MobRenderer<CeratosaurusEntity,  EntityModel<CeratosaurusEntity>> {

	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic.png");
	private static final ResourceLocation CERATOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic_sleeping.png");
	private static final CeratosaurusModel CERATOSAURUS_MODEL = new CeratosaurusModel();

	public CeratosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CERATOSAURUS_MODEL, 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new CeratosaurusEyeLayer(this));
		}
	}

	protected void preRenderCallback(CeratosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(CeratosaurusEntity entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return CERATOSAURUS_SLEEPING;
			} else return CERATOSAURUS;
		}
	}

}
