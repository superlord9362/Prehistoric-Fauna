package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.chinle.CoelophysisModel;
import superlord.prehistoricfauna.client.render.layer.CoelophysisEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CoelophysisRenderer extends MobRenderer<Coelophysis, CoelophysisModel> {
	private static final ResourceLocation COELOPHYSIS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/coelophysis.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/melanistic.png");
	private static final ResourceLocation JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/juvenile.png");
	private static final ResourceLocation COELOPHYSIS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/coelophysis_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/melanistic_sleeping.png");
	private static final ResourceLocation JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/coelophysis/juvenile_sleeping.png");

	public CoelophysisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoelophysisModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new CoelophysisEyeLayer(this));
		}
	}

	protected void scale(Coelophysis thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Coelophysis entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			}else return MELANISTIC;
		} else {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return JUVENILE_SLEEPING;
				} else return JUVENILE;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return COELOPHYSIS_SLEEPING;
				} else return COELOPHYSIS;
			}
		}
	}
}
