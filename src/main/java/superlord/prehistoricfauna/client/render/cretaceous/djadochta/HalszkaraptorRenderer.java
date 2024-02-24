package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.HalszkaraptorModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Halszkaraptor;

public class HalszkaraptorRenderer extends MobRenderer<Halszkaraptor, HalszkaraptorModel> {
	private static final ResourceLocation HALSZKARAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/halszkaraptor/halszkaraptor.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/halszkaraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/halszkaraptor/melanistic.png");
	private static final ResourceLocation HALSZKARAPTOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/halszkaraptor/halszkaraptor_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/halszkaraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/halszkaraptor/melanistic_sleeping.png");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HalszkaraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HalszkaraptorModel(renderManagerIn.bakeLayer(ClientEvents.HALSZKARAPTOR)), 0.35F);
		this.addLayer(new ItemInHandLayer(this));
	}

	protected void scale(Halszkaraptor halszkaraptor, PoseStack matrixStackIn, float partialTickTime) {
		if(halszkaraptor.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(halszkaraptor, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Halszkaraptor entity) {
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
				return HALSZKARAPTOR_SLEEPING;
			} else return HALSZKARAPTOR;
		}
	}
}
