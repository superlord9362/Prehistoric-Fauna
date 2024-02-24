package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.UdanoceratopsModel;
import superlord.prehistoricfauna.client.render.layer.UdanoceratopsEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Udanoceratops;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class UdanoceratopsRenderer extends MobRenderer<Udanoceratops, UdanoceratopsModel> {
	private static final ResourceLocation UDANOCERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/melanistic.png");
	private static final ResourceLocation UDANOCERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/melanistic_sleeping.png");

	public UdanoceratopsRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new UdanoceratopsModel(renderManagerIn.bakeLayer(ClientEvents.UDANOCERATOPS)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new UdanoceratopsEyeLayer(this));
		}
	}

	protected void scale(Udanoceratops udanoceratops, PoseStack matrixStackIn, float partialTickTime) {
		if(udanoceratops.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(udanoceratops, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Udanoceratops entity) {
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
				return UDANOCERATOPS_SLEEPING;
			} else return UDANOCERATOPS;
		}
	}
}
