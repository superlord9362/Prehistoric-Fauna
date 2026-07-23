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
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusSubadultModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;

public class CamarasaurusRenderer extends MobRenderer<Camarasaurus, EntityModel<Camarasaurus>> {
	private static final ResourceLocation CAMARASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus.png");
	private static final ResourceLocation CAMARASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_sleeping.png");
	private static final ResourceLocation CAMARASAURUS_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_subadult.png");
	private static final ResourceLocation CAMARASAURUS_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_subadult_sleeping.png");
	private static final ResourceLocation ALBINO_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_subadult.png");
	private static final ResourceLocation ALBINO_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_subadult_sleeping.png");
	private static final ResourceLocation MELANISTIC_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_subadult.png");
	private static final ResourceLocation MELANISTIC_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_subadult_sleeping.png");
	private static final ResourceLocation CAMARASAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_juvenile.png");
	private static final ResourceLocation CAMARASAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation CAMARASAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_baby.png");
	private static final ResourceLocation CAMARASAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation FROSTY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_snowy.png");
	private static final ResourceLocation FROSTY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camarasaurus/camarasaurus_snowy_sleeping.png");
	private boolean isChristmas;

	private static CamarasaurusModel CAMARASAURUS_MODEL;
	private static CamarasaurusSubadultModel CAMARASAURUS_SUBADULT_MODEL;
	private static CamarasaurusJuvenileModel JUVENILE_CAMARASAURUS_MODEL;
	private static CamarasaurusBabyModel BABY_CAMARASAURUS_MODEL;


	public CamarasaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CamarasaurusModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS)), 3.125F);
		CAMARASAURUS_MODEL = new CamarasaurusModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS));
		JUVENILE_CAMARASAURUS_MODEL = new CamarasaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS_JUVENILE));
		BABY_CAMARASAURUS_MODEL = new CamarasaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS_BABY));
		CAMARASAURUS_SUBADULT_MODEL = new CamarasaurusSubadultModel(renderManagerIn.bakeLayer(ClientEvents.CAMARASAURUS_SUBADULT));
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
			this.isChristmas = true;
		}
	}

	protected void scale(Camarasaurus camarasaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(camarasaurus.isBaby()) {
			if (camarasaurus.isJuvenile() && !camarasaurus.isSubadult()) {
				model = JUVENILE_CAMARASAURUS_MODEL;
			} else if (camarasaurus.isSubadult() && !camarasaurus.isJuvenile()) {
				model = CAMARASAURUS_SUBADULT_MODEL;
			} else {
				model = BABY_CAMARASAURUS_MODEL;
			}
		} else {
			model = CAMARASAURUS_MODEL;
		}
		super.scale(camarasaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Camarasaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ((s != null && ("Frosty".equals(s) || "frosty".equals(s)) || this.isChristmas) && !entity.isBaby()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return FROSTY_SLEEPING;
			} else return FROSTY;
		} else {
			if (entity.isBaby() && !entity.isJuvenile() && !entity.isSubadult()) {
				if (entity.isAlbino()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_BABY_SLEEPING;
					} else return ALBINO_BABY;
				} else if (entity.isMelanistic()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_BABY_SLEEPING;
					} else return MELANISTIC_BABY;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return CAMARASAURUS_BABY_SLEEPING;
					} else return CAMARASAURUS_BABY;
				}
			} else if (entity.isJuvenile()) {
				if (entity.isAlbino()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_JUVENILE_SLEEPING;
					} else return ALBINO_JUVENILE;
				} else if (entity.isMelanistic()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_JUVENILE_SLEEPING;
					} else return MELANISTIC_JUVENILE;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return CAMARASAURUS_JUVENILE_SLEEPING;
					} else return CAMARASAURUS_JUVENILE;
				}
			} else if (entity.isSubadult()) {
				if (entity.isAlbino()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_SUBADULT_SLEEPING;
					} else return ALBINO_SUBADULT;
				} else if (entity.isMelanistic()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_SUBADULT_SLEEPING;
					} else return MELANISTIC_SUBADULT;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return CAMARASAURUS_SUBADULT_SLEEPING;
					} else return CAMARASAURUS_SUBADULT;
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
}
