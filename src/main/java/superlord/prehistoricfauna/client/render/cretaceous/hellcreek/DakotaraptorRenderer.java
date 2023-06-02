package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorModel;
import superlord.prehistoricfauna.client.render.layer.DakotaraptorEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DakotaraptorRenderer extends MobRenderer<Dakotaraptor, DakotaraptorModel> {
	private static final ResourceLocation DAKOTARAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_sleeping.png");
	private static final ResourceLocation CHILD_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_child_sleeping.png");
	private static final ResourceLocation CHILD = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_child.png");
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

	public DakotaraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DakotaraptorModel(renderManagerIn.bakeLayer(ClientEvents.DAKOTARAPTOR)), 0.875F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DakotaraptorEyeLayer(this));
		}
	}

	protected void scale(Dakotaraptor thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dakotaraptor entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if (s != null && "A MAN".equals(s)) {
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
		} else if(entity.isSleeping() || entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
			if (entity.isBaby()) {
				return CHILD_SLEEPING;
			} else {
				if (entity.isAlbino()) {
					return ALBINO_SLEEPING;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_SLEEPING;
				} else {
					return SLEEPING;
				}
			}
		} else if (entity.isBaby()) {
			return CHILD;
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
