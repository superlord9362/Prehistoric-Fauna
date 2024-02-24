package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.GoyocephaleModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Goyocephale;

public class GoyocephaleRenderer extends MobRenderer<Goyocephale, GoyocephaleModel> {

	private static final ResourceLocation GOYOCEPHALE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/goyocephale.png");
	private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/goyocephale_baby.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/melanistic.png");
	private static final ResourceLocation GOYOCEPHALE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/goyocephale_sleeping.png");
	private static final ResourceLocation BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/goyocephale_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/goyocephale/melanistic_sleeping.png");
	
	public GoyocephaleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GoyocephaleModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE)), 0.5F);
	}
	
	protected void scale(Goyocephale goyocephale, PoseStack stack, float partialTick) {
		if (goyocephale.isBaby()) {
			stack.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(goyocephale, stack, partialTick);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Goyocephale entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0  && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0  && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0  && entity.tickCount % 50 <= 5) {
					return BABY_SLEEPING;
				} else return BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0  && entity.tickCount % 50 <= 5) {
					return GOYOCEPHALE_SLEEPING;
				} else return GOYOCEPHALE;
			}
		}
	}
	
}
