package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.PachycephalosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Pachycephalosaurus;

public class PachycephalosaurusRenderer extends MobRenderer<Pachycephalosaurus, PachycephalosaurusModel> {

	private static final ResourceLocation PACHYCEPHALOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/pachycephalosaurus.png");
	private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/pachycephalosaurus_baby.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/melanistic_baby.png");
	private static final ResourceLocation PACHYCEPHALOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/pachycephalosaurus_sleeping.png");
	private static final ResourceLocation BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/pachycephalosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/melanistic_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pachycephalosaurus/melanistic_baby_sleeping.png");

	public PachycephalosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PachycephalosaurusModel(renderManagerIn.bakeLayer(ClientEvents.PACHYCEPHALOSAURUS)), 0.55F);
	}

	protected void scale(Pachycephalosaurus pachycephalosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(pachycephalosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(pachycephalosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Pachycephalosaurus entity) {
		if(entity.isBaby() && !entity.isAlbino() && !entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return BABY_SLEEPING;
			} else return BABY;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return PACHYCEPHALOSAURUS_SLEEPING;
			} else return PACHYCEPHALOSAURUS;
		}	}

}
