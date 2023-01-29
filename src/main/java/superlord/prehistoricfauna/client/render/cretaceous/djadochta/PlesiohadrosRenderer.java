package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;

public class PlesiohadrosRenderer extends MobRenderer<PlesiohadrosEntity, EntityModel<PlesiohadrosEntity>> {

	private static final PlesiohadrosModel PLESIOHADROS_MODEL = new PlesiohadrosModel();
	private static final ResourceLocation PLESIOHADROS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic.png");
	private static final ResourceLocation DEOXIDATED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated.png");
	private static final ResourceLocation PLESIOHADROS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_sleeping.png");
	private static final ResourceLocation DEOXIDATED_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated_sleeping.png");
	private static final ResourceLocation PLESIOHADROS_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_saddle.png");
	private static final ResourceLocation ALBINO_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_saddled.png");
	private static final ResourceLocation MELANISTIC_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_saddled.png");
	private static final ResourceLocation DEOXIDATED_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated_saddled.png");
	private static final ResourceLocation PLESIOHADROS_SADDLED_BLINKING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_saddled_blinking.png");
	private static final ResourceLocation ALBINO_SADDLED_BLINKING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_saddled_blinking.png");
	private static final ResourceLocation MELANISTIC_SADDLED_BLINKING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_saddled_blinking.png");
	private static final ResourceLocation DEOXIDATED_SADDLED_BLINKING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated_saddled_blinking.png");

	public PlesiohadrosRenderer(EntityRendererManager rm) {
		super(rm, PLESIOHADROS_MODEL, 2F);
	}

	protected void preRenderCallback(PlesiohadrosEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(PlesiohadrosEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = PLESIOHADROS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(PlesiohadrosEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5 && !entity.isSaddled()) {
				return ALBINO_SLEEPING;
			} else if (entity.isSaddled()) {
				if (entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) return ALBINO_SADDLED_BLINKING;
				else return ALBINO_SADDLED;
			}
			else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5 && !entity.isSaddled()) {
				return MELANISTIC_SLEEPING;
			} else if (entity.isSaddled()) {
				if (entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) return MELANISTIC_SADDLED_BLINKING;
				else return MELANISTIC_SADDLED;
			}
			 else return MELANISTIC;
		} else if (!entity.isMelanistic() && !entity.isAlbino() && entity.isDeoxidated()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5 && !entity.isSaddled()) {
				return DEOXIDATED_SLEEPING;
			} else if (entity.isSaddled()) {
				if (entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) return DEOXIDATED_SADDLED_BLINKING;
				else return DEOXIDATED_SADDLED;
			}
			 else return DEOXIDATED;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5 && !entity.isSaddled()) {
				return PLESIOHADROS_SLEEPING;
			} else if (entity.isSaddled()) {
				if (entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) return PLESIOHADROS_SADDLED_BLINKING;
				else return PLESIOHADROS_SADDLED;
			}
			 else return PLESIOHADROS;
		}
	}

}

