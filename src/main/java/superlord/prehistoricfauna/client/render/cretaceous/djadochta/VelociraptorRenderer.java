package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.VelociraptorModel;
import superlord.prehistoricfauna.client.render.layer.VelociraptorEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class VelociraptorRenderer extends MobRenderer<Velociraptor, VelociraptorModel> {
	private static final ResourceLocation VELOCIRAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/melanistic.png");
	private static final ResourceLocation VELOCIRAPTOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/melanistic_sleeping.png");
	private static final ResourceLocation CROWBER = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/crowber.png");
	private static final ResourceLocation CROWBER_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/crowber_sleeping.png");
	private static final ResourceLocation RETRO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/retro.png");
	private static final ResourceLocation RETRO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/retro_sleeping.png");

	public VelociraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new VelociraptorModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR)), 0.3125F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new VelociraptorEyeLayer(this));
		}
	}

	protected void scale(Velociraptor thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Velociraptor entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && "Crowber".equals(s)) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return CROWBER_SLEEPING;
			} else return CROWBER;
		} else if ( s != null && "Retro".equals(s)) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return RETRO_SLEEPING;
			} else return RETRO;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return VELOCIRAPTOR_SLEEPING;
			} else {
				return VELOCIRAPTOR;
			}
		}
	}
}
