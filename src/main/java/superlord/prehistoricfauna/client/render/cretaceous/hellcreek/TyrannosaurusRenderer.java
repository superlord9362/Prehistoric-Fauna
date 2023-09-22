package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusModel;
import superlord.prehistoricfauna.client.render.layer.TyrannosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TyrannosaurusEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TyrannosaurusJuvenileEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TyrannosaurusRenderer extends MobRenderer<Tyrannosaurus, EntityModel<Tyrannosaurus>> {

	private static final ResourceLocation TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex.png");
	private static final ResourceLocation BABY_TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurus_baby.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino.png");
	private static final ResourceLocation BABY_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic.png");
	private static final ResourceLocation BABY_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_baby.png");
	private static final ResourceLocation TYRANNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_sleeping.png");
	private static final ResourceLocation BABY_TYRANNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_sleeping.png");
	private static final ResourceLocation BABY_ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_sleeping.png");
	private static final ResourceLocation BABY_MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation SUB_TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_sub.png");
	private static final ResourceLocation SUB_TYRANNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex_sub_sleeping.png");
	private static final ResourceLocation SUB_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_sub.png");
	private static final ResourceLocation SUB_ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_sub_sleeping.png");
	private static final ResourceLocation RETRO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/retro.png");
	private static final ResourceLocation RETRO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/retro_sleeping.png");

	private static TyrannosaurusModel TYRANNOSAURUS_MODEL;
	private static TyrannosaurusJuvenileModel JUVENILE_TYRANNOSAURUS_MODEL;
	private static TyrannosaurusBabyModel BABY_TYRANNOSAURUS_MODEL;

	public TyrannosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TyrannosaurusModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS)), 2F);
		TYRANNOSAURUS_MODEL = new TyrannosaurusModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS));
		JUVENILE_TYRANNOSAURUS_MODEL = new TyrannosaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_JUVENILE));
		BABY_TYRANNOSAURUS_MODEL = new TyrannosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TyrannosaurusEyeLayer(this));
			this.addLayer(new TyrannosaurusJuvenileEyeLayer(this));
			this.addLayer(new TyrannosaurusBabyEyeLayer(this));
		}
	}

	protected void scale(Tyrannosaurus triceratops, PoseStack matrixStackIn, float partialTickTime) {
		if(triceratops.isBaby()) {
			if (!triceratops.isJuvenile()) {
				model = BABY_TYRANNOSAURUS_MODEL;
			} else {
				model = JUVENILE_TYRANNOSAURUS_MODEL;
			}
		} else {
			model = TYRANNOSAURUS_MODEL;
		}
		super.scale(triceratops, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Tyrannosaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && "Retro".equals(s) && !entity.isBaby()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return RETRO_SLEEPING;
			} else return RETRO;
		}
		if (entity.isAlbino() && !entity.isBaby()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isAlbino() && entity.isBaby() && !entity.isJuvenile()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return BABY_ALBINO_SLEEPING;
			} else return BABY_ALBINO;
		} else if (entity.isAlbino() && entity.isJuvenile()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return SUB_ALBINO_SLEEPING;
			} else return SUB_ALBINO;
		} else if (entity.isMelanistic() && !entity.isBaby()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isMelanistic() && entity.isBaby() && !entity.isJuvenile()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return BABY_MELANISTIC_SLEEPING;
			} else return BABY_MELANISTIC;
		} else if(entity.isBaby() && !entity.isJuvenile()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return BABY_TYRANNOSAURUS_SLEEPING;
			} else return BABY_TYRANNOSAURUS;
		} else if (entity.isJuvenile()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return SUB_TYRANNOSAURUS_SLEEPING;
			} else return SUB_TYRANNOSAURUS;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return TYRANNOSAURUS_SLEEPING;
			} else return TYRANNOSAURUS;
		}
	}

}
