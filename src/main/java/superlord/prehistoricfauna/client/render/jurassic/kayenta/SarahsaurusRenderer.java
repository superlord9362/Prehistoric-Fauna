package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.client.render.layer.SarahsaurusEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@OnlyIn(Dist.CLIENT)
public class SarahsaurusRenderer extends MobRenderer<SarahsaurusEntity, EntityModel<SarahsaurusEntity>> {

	private static final SarahsaurusModel SARAHSAURUS_MODEL = new SarahsaurusModel();
	private static final ResourceLocation SARAHSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus.png");
	private static final ResourceLocation FLINSTONES_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_flintstones.png");
	private static final ResourceLocation FLINSTONES_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_flintstones_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/melanistic.png");
	private static final ResourceLocation SARAHSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/melanistic_sleeping.png");

	public SarahsaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SARAHSAURUS_MODEL, 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SarahsaurusEyeLayer(this));
		}
	}

	protected void preRenderCallback(SarahsaurusEntity sarahsaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(sarahsaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public ResourceLocation getEntityTexture(SarahsaurusEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
		if ( s != null && ("Dino".equals(s) || "Flintstones".equals(s))) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return FLINSTONES_SLEEPING_TEXTURE;
			} else {
				return FLINSTONES_TEXTURE;
			}
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return SARAHSAURUS_SLEEPING_TEXTURE;
			} else {
				return SARAHSAURUS_TEXTURE;
			}
		}
	}
}