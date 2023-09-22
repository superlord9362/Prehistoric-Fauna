package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorModel;
import superlord.prehistoricfauna.client.render.layer.DakotaraptorBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.DakotaraptorEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DakotaraptorRenderer extends MobRenderer<Dakotaraptor, EntityModel<Dakotaraptor>> {
	private static final ResourceLocation DAKOTARAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_sleeping.png");
	private static final ResourceLocation SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_baby_sleeping.png");
	private static final ResourceLocation DAKOTARAPTOR_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_baby.png");
	private static final ResourceLocation ALBINO_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_sleeping_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_sleeping_baby.png");
	private static final ResourceLocation MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_man.png");
	private static final ResourceLocation SLEEPING_MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_man_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_sleeping.png");
	private static final ResourceLocation ALBINO_MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_man.png");
	private static final ResourceLocation ALBINO_MAN_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_man_sleeping.png");
	private static final ResourceLocation MELANISTIC_MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_man.png");
	private static final ResourceLocation MELANISTIC_MAN_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_man_sleeping.png");

	private static DakotaraptorModel DAKOTARAPTOR_MODEL;
	private static DakotaraptorBabyModel BABY_DAKOTARAPTOR_MODEL;

	public DakotaraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DakotaraptorModel(renderManagerIn.bakeLayer(ClientEvents.DAKOTARAPTOR)), 0.875F);
		DAKOTARAPTOR_MODEL = new DakotaraptorModel(renderManagerIn.bakeLayer(ClientEvents.DAKOTARAPTOR));
		BABY_DAKOTARAPTOR_MODEL = new DakotaraptorBabyModel(renderManagerIn.bakeLayer(ClientEvents.DAKOTARAPTOR_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DakotaraptorEyeLayer(this));
			this.addLayer(new DakotaraptorBabyEyeLayer(this));
		}
	}

	protected void scale(Dakotaraptor thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_DAKOTARAPTOR_MODEL;
		} else {
			model = DAKOTARAPTOR_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dakotaraptor entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if (s != null && "A MAN".equals(s) && !entity.isBaby()) {
			if (entity.isSleeping() || entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				if (entity.isAlbino()) {
					return ALBINO_MAN_SLEEPING;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_MAN_SLEEPING;
				} else {
					return SLEEPING_MAN;
				}
			} else {
				if (entity.isAlbino()) {
					return ALBINO_MAN;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_MAN;
				} else {
					return MAN;
				}
			}
		} else if (entity.isBaby()) {
			if (entity.isSleeping() || entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				if (entity.isAlbino()) {
					return ALBINO_SLEEPING_BABY;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_SLEEPING_BABY;
				} else {
					return SLEEPING_BABY;
				}
			} else {
				if (entity.isAlbino()) {
					return ALBINO_BABY;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_BABY;
				} else {
					return DAKOTARAPTOR_BABY;
				}
			}
		} else if(entity.isSleeping() || entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
			if (entity.isAlbino()) {
				return ALBINO_SLEEPING;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_SLEEPING;
			} else {
				return SLEEPING;
			}
		} else {
			if (entity.isAlbino()) {
				return ALBINO;
			} else if (entity.isMelanistic()) {
				return MELANISTIC;
			} else {
				return DAKOTARAPTOR;
			}
		}
	}
}
