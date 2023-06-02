package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DidelphodonModel;
import superlord.prehistoricfauna.client.render.layer.DidelphodonEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DidelphodonRenderer extends MobRenderer<Didelphodon, DidelphodonModel> {
	private static final ResourceLocation DIDELPHODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/didelphodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/melanistic.png");
	private static final ResourceLocation DIDELPHODON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/didelphodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/melanistic_sleeping.png");

	public DidelphodonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DidelphodonModel(renderManagerIn.bakeLayer(ClientEvents.DIDELPHODON)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DidelphodonEyeLayer(this));
		}
	}

	protected void scale(Didelphodon thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Didelphodon entity) {
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
				return DIDELPHODON_SLEEPING;
			} else return DIDELPHODON;
		}
	}
}
