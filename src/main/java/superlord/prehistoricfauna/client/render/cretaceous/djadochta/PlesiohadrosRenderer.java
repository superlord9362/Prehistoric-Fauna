package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosModel;
import superlord.prehistoricfauna.client.render.layer.PlesiohadrosSaddleLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;

public class PlesiohadrosRenderer extends MobRenderer<Plesiohadros, EntityModel<Plesiohadros>> {
	private static final ResourceLocation PLESIOHADROS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic.png");
	private static final ResourceLocation DEOXIDATED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated.png");
	private static final ResourceLocation PLESIOHADROS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_sleeping.png");
	private static final ResourceLocation DEOXIDATED_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated_sleeping.png");
	private static final ResourceLocation PLESIOHADROS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_hatchling.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_hatchling.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_hatchling.png");
	private static final ResourceLocation PLESIOHADROS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_hatchling_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_hatchling_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_hatchling_sleeping.png");

	private static PlesiohadrosModel PLESIOHADROS_MODEL;
	private static PlesiohadrosBabyModel PLESIOHADROS_BABY_MODEL;

	public PlesiohadrosRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PlesiohadrosModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS)), 2F);
		PLESIOHADROS_MODEL = new PlesiohadrosModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS));
		PLESIOHADROS_BABY_MODEL = new PlesiohadrosBabyModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_BABY));
		this.addLayer(new PlesiohadrosSaddleLayer(this));
	}

	protected void scale(Plesiohadros thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = PLESIOHADROS_BABY_MODEL;
		} else {
			model = PLESIOHADROS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Plesiohadros entity) {
		if (!entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return ALBINO_SLEEPING;
				} 
				else return ALBINO;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return MELANISTIC_SLEEPING;
				}
				else return MELANISTIC;
			} else if (!entity.isMelanistic() && !entity.isAlbino() && entity.isDeoxidated()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return DEOXIDATED_SLEEPING;
				} else return DEOXIDATED;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return PLESIOHADROS_SLEEPING;
				} else return PLESIOHADROS;
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return ALBINO_BABY_SLEEPING;
				} 
				else return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return MELANISTIC_BABY_SLEEPING;
				}
				else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
					return PLESIOHADROS_BABY_SLEEPING;
				} else return PLESIOHADROS_BABY;
			}
		}
	}
}
