package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.UdanoceratopsBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.UdanoceratopsModel;
import superlord.prehistoricfauna.client.render.layer.UdanoceratopsBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.UdanoceratopsEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Udanoceratops;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class UdanoceratopsRenderer extends MobRenderer<Udanoceratops, EntityModel<Udanoceratops>> {
	private static final ResourceLocation UDANOCERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/melanistic.png");
	private static final ResourceLocation UDANOCERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/melanistic_sleeping.png");
	private static final ResourceLocation UDANOCERATOPS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/melanistic_baby.png");
	private static final ResourceLocation UDANOCERATOPS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/melanistic_baby_sleeping.png");

	private static final ResourceLocation SNIFFER = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/sniffer.png");
	private static final ResourceLocation SNIFFER_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/sniffer_sleeping.png");

	private static UdanoceratopsModel UDANOCERATOPS_MODEL;
	private static UdanoceratopsBabyModel BABY_MODEL;
	
	public UdanoceratopsRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new UdanoceratopsModel(renderManagerIn.bakeLayer(ClientEvents.UDANOCERATOPS)), 1F);
		UDANOCERATOPS_MODEL = new UdanoceratopsModel(renderManagerIn.bakeLayer(ClientEvents.UDANOCERATOPS));
		BABY_MODEL = new UdanoceratopsBabyModel(renderManagerIn.bakeLayer(ClientEvents.UDANOCERATOPS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new UdanoceratopsEyeLayer(this));
			this.addLayer(new UdanoceratopsBabyEyeLayer(this));
		}
	}

	protected void scale(Udanoceratops udanoceratops, PoseStack matrixStackIn, float partialTickTime) {
		if(udanoceratops.isBaby()) {
			model = BABY_MODEL;
		} else model = UDANOCERATOPS_MODEL;
		super.scale(udanoceratops, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Udanoceratops entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && "Sniffer".equals(s)) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return SNIFFER_SLEEPING;
			} else return SNIFFER;
		} else {
			if (entity.isBaby()) {
				if (entity.isAlbino()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_BABY_SLEEPING;
					} else return ALBINO_BABY;
				} else if (entity.isMelanistic()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_BABY_SLEEPING;
					} else return MELANISTIC_BABY;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return UDANOCERATOPS_BABY_SLEEPING;
					} else return UDANOCERATOPS_BABY;
				}
			} else {
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
	}
}
