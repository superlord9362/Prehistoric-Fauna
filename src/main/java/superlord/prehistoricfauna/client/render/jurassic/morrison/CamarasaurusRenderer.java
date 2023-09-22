package superlord.prehistoricfauna.client.render.jurassic.morrison;

import java.util.Calendar;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusHatchlingModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;

public class CamarasaurusRenderer extends MobRenderer<Camarasaurus, EntityModel<Camarasaurus>> {
	private static final ResourceLocation CAMARASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus.png");
	private static final ResourceLocation CAMARASAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_juvenile.png");
	private static final ResourceLocation CAMARASAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic.png");
	private static final ResourceLocation FROSTY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_snowy.png");
	private static final ResourceLocation CAMARASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_sleeping.png");
	private static final ResourceLocation FROSTY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_snowy_sleeping.png");
	private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_baby.png");
	private static final ResourceLocation BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_baby_sleeping.png");
	private static final ResourceLocation HATCHLING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_hatchling.png");
	private static final ResourceLocation HATCHLING_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_hatchling_sleeping.png");
	private static final ResourceLocation MELANISTIC_HATCHLING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_hatchling.png");
	private static final ResourceLocation MELANISTIC_HATCHLING_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_hatchling_sleeping.png");
	private static final ResourceLocation ALBINO_HATCHLING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_hatchling.png");
	private static final ResourceLocation ALBINO_HATCHLING_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_hatchling_sleeping.png");
	private boolean isChristmas;

	private static CamarasaurusModel CAMARASAURUS_MODEL;
	private static CamarasaurusJuvenileModel JUVENILE_CAMARASAURUS_MODEL;
	private static CamarasaurusBabyModel BABY_CAMARASAURUS_MODEL;
	private static CamarasaurusHatchlingModel HATCHLING_CAMARASAURUS_MODEL;


	public CamarasaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CamarasaurusModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS)), 3.125F);
		CAMARASAURUS_MODEL = new CamarasaurusModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS));
		JUVENILE_CAMARASAURUS_MODEL = new CamarasaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS_JUVENILE));
		BABY_CAMARASAURUS_MODEL = new CamarasaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS_BABY));
		HATCHLING_CAMARASAURUS_MODEL = new CamarasaurusHatchlingModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS_HATCHLING));
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
			this.isChristmas = true;
		}
	}

	protected void scale(Camarasaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			if (!thescelosaurus.isJuvenile() && !thescelosaurus.isHatchling()) {
				model = BABY_CAMARASAURUS_MODEL;
			} else if (thescelosaurus.isHatchling()) {
				model = HATCHLING_CAMARASAURUS_MODEL;
			} else {
				model = JUVENILE_CAMARASAURUS_MODEL;
			}
		} else {
			model = CAMARASAURUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Camarasaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if (s != null && ("Frosty".equals(s) || "frosty".equals(s)) || this.isChristmas) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return FROSTY_SLEEPING;
			} else return FROSTY;
		} else if (entity.isHatchling() && !entity.isAsleep()) {
			if (entity.isAlbino()) {
				return ALBINO_HATCHLING;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_HATCHLING;
			} else {
				return HATCHLING;
			}
		}  else if (entity.isHatchling() && (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5)) {
			if (entity.isAlbino()) {
				return ALBINO_HATCHLING_SLEEPING;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_HATCHLING_SLEEPING;
			} else {
				return HATCHLING_SLEEPING;
			}
		} else if (entity.isJuvenile() && !entity.isAsleep()) {
			if (entity.isAlbino()) {
				return ALBINO_JUVENILE;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_JUVENILE;
			} else {
				return CAMARASAURUS_JUVENILE;
			}
		} else if (entity.isJuvenile() && (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5)) {
			if (entity.isAlbino()) {
				return ALBINO_JUVENILE_SLEEPING;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_JUVENILE_SLEEPING;
			} else {
				return CAMARASAURUS_JUVENILE_SLEEPING;
			}
		} else if (entity.isBaby() && !entity.isHatchling() && !entity.isJuvenile() && !entity.isAsleep()) {
			if (entity.isAlbino()) {
				return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_BABY;
			} else {
				return BABY;
			}
		} else if (entity.isBaby() && !entity.isHatchling() && !entity.isJuvenile() && (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5)) {
			if (entity.isAlbino()) {
				return ALBINO_BABY_SLEEPING;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_BABY_SLEEPING;
			} else {
				return BABY_SLEEPING;
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return CAMARASAURUS_SLEEPING;
				} else return CAMARASAURUS;
			}
		}
	}
}
