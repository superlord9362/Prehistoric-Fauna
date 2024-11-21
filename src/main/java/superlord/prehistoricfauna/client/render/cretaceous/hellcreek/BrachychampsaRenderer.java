package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.BrachychampsaModel;
import superlord.prehistoricfauna.client.render.layer.BrachychampsaEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Brachychampsa;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class BrachychampsaRenderer extends MobRenderer<Brachychampsa, BrachychampsaModel> {
	private static final ResourceLocation BRACHYCHAMPSA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/brachychampsa.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/melanistic.png");
	private static final ResourceLocation BRACHYCHAMPSA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/brachychampsa_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/melanistic_sleeping.png");

	public BrachychampsaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BrachychampsaModel(renderManagerIn.bakeLayer(ClientEvents.BRACHYCHAMPSA)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new BrachychampsaEyeLayer(this));
		}
	}

	protected void scale(Brachychampsa brachychampsa, PoseStack matrixStackIn, float partialTickTime) {
		if(brachychampsa.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(brachychampsa, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Brachychampsa entity) {
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
				return BRACHYCHAMPSA_SLEEPING;
			} else return BRACHYCHAMPSA;
		}
	}
}
