package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.OviraptorModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Oviraptor;

public class OviraptorRenderer extends MobRenderer<Oviraptor, OviraptorModel> {

	private static final ResourceLocation OVIRAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/oviraptor.png");
	private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/oviraptor_baby.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/melanistic.png");
	private static final ResourceLocation OVIRAPTOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/oviraptor_sleeping.png");
	private static final ResourceLocation BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/oviraptor_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/oviraptor/melanistic_sleeping.png");
	
	public OviraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OviraptorModel(renderManagerIn.bakeLayer(ClientEvents.OVIRAPTOR)), 0.5F);
	}
	
	protected void scale(Oviraptor oviraptor, PoseStack stack, float partialTick) {
		if (oviraptor.isBaby()) {
			stack.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(oviraptor, stack, partialTick);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Oviraptor entity) {
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
					return OVIRAPTOR_SLEEPING;
				} else return OVIRAPTOR;
			}
		}
	}
	
}
