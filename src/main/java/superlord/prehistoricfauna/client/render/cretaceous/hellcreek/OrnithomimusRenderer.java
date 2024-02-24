package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.OrnithomimusModel;
import superlord.prehistoricfauna.client.render.layer.OrnithomimusEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ornithomimus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class OrnithomimusRenderer extends MobRenderer<Ornithomimus, OrnithomimusModel> {
	private static final ResourceLocation ORNITHOMIMUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/ornithomimus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/melanistic.png");
	private static final ResourceLocation ORNITHOMIMUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/ornithomimus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/melanistic_sleeping.png");

	public OrnithomimusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OrnithomimusModel(renderManagerIn.bakeLayer(ClientEvents.ORNITHOMIMUS)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new OrnithomimusEyeLayer(this));
		}
	}

	protected void scale(Ornithomimus ornithomimus, PoseStack matrixStackIn, float partialTickTime) {
		if(ornithomimus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(ornithomimus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ornithomimus entity) {
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
				return ORNITHOMIMUS_SLEEPING;
			} else return ORNITHOMIMUS;
		}
	}
}
