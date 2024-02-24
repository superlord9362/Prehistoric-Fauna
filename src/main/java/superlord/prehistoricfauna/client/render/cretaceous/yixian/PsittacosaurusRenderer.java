package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.PsittacosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Psittacosaurus;

public class PsittacosaurusRenderer extends MobRenderer<Psittacosaurus, PsittacosaurusModel> {
	private static final ResourceLocation PSITTACOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/psittacosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/melanistic.png");
	private static final ResourceLocation PSITTACOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/psittacosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/melanistic_sleeping.png");
	private static final ResourceLocation PSITTACOSAURUS_PSYCHO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/psycho.png");
	private static final ResourceLocation ALBINO_PSYCHO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/albino_psycho.png");
	private static final ResourceLocation MELANISTIC_PSYCHO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/melanistic_psycho.png");
	private static final ResourceLocation PSITTACOSAURUS_PSYCHO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/psycho_sleeping.png");
	private static final ResourceLocation ALBINO_PSYCHO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/albino_psycho_sleeping.png");
	private static final ResourceLocation MELANISTIC_PSYCHO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/melanistic_psycho_sleeping.png");

	public PsittacosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PsittacosaurusModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS)), 0.25F);
	}

	protected void scale(Psittacosaurus psittacosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(psittacosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(psittacosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Psittacosaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if (s != null && "Psycho".equals(s)) {
			if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_PSYCHO_SLEEPING;
				} else return MELANISTIC_PSYCHO;
			} else if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_PSYCHO_SLEEPING;
				} else return ALBINO_PSYCHO;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return PSITTACOSAURUS_PSYCHO_SLEEPING;
				} else return PSITTACOSAURUS_PSYCHO;
			}		} else {
			if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			} else if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return PSITTACOSAURUS_SLEEPING;
				} else return PSITTACOSAURUS;
			}
		}
	}
}
