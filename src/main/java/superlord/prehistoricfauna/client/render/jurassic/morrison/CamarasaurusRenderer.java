package superlord.prehistoricfauna.client.render.jurassic.morrison;

import java.util.Calendar;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;

public class CamarasaurusRenderer extends MobRenderer<CamarasaurusEntity, EntityModel<CamarasaurusEntity>> {

	private static final ResourceLocation CAMARASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus.png");
	private static final ResourceLocation CAMARASAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_baby.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic.png");
	private static final ResourceLocation FROSTY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_snowy.png");
	private static final ResourceLocation CAMARASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/melanistic_sleeping.png");
	private static final ResourceLocation FROSTY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus/camarasaurus_snowy_sleeping.png");
	private static final CamarasaurusModel CAMARASAURUS_MODEL = new CamarasaurusModel();
	private static final CamarasaurusBabyModel CAMARASAURUS_BABY_MODEL = new CamarasaurusBabyModel();
	private static final CamarasaurusSleepingModel CAMARASAURUS_SLEEPING_MODEL = new CamarasaurusSleepingModel();
	private boolean isChristmas;

	public CamarasaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CAMARASAURUS_MODEL, 3.125F);
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
			this.isChristmas = true;
		}
	}

	public void render(CamarasaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			if (entityIn.isAsleep()) {
				entityModel = CAMARASAURUS_SLEEPING_MODEL;
			}
			entityModel = CAMARASAURUS_BABY_MODEL;
		} else if (entityIn.isAsleep()) {
			entityModel = CAMARASAURUS_SLEEPING_MODEL;
		} else {
			entityModel = CAMARASAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(CamarasaurusEntity camarasaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(camarasaurus.isChild() && !camarasaurus.isJuvenile()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	} 
	
	@Override
	public ResourceLocation getEntityTexture(CamarasaurusEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());

		if (s != null && ("Frosty".equals(s) || "frosty".equals(s)) || this.isChristmas) {
			if (entity.isAsleep()) {
				return FROSTY_SLEEPING;
			} else return FROSTY;
		} else if (entity.isChild() && !entity.isAsleep()) {
			if (entity.isAlbino()) {
				return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_BABY;
			} else {
				return CAMARASAURUS_BABY;
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isAsleep()) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep()) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			} else {
				if (entity.isAsleep()) {
					return CAMARASAURUS_SLEEPING;
				} else return CAMARASAURUS;
			}
		}
	}

}
