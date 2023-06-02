package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsModel;
import superlord.prehistoricfauna.client.render.layer.ProtoceratopsEyeLayer;
import superlord.prehistoricfauna.client.render.layer.ProtoceratopsJuvenileEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ProtoceratopsRenderer extends MobRenderer<Protoceratops, EntityModel<Protoceratops>> {

	private static final ResourceLocation PROTOCERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic.png");
	private static final ResourceLocation PALEOCRAFT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/paleocraft.png");
	private static final ResourceLocation PROTOCERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic_sleeping.png");
	private static final ResourceLocation PALEOCRAFT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/paleocraft_sleeping.png");
	private static final ResourceLocation JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic_juvenile.png");
	private static final ResourceLocation PALEOCRAFT_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/paleocraft_juvenile.png");
	private static final ResourceLocation JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation PALEOCRAFT_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/paleocraft_juvenile_sleeping.png");

	private static ProtoceratopsModel PROTOCERATOPS_MODEL;
	private static ProtoceratopsJuvenileModel BABY_PROTOCERATOPS_MODEL;

	public ProtoceratopsRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ProtoceratopsModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS)), 0.25F);
		PROTOCERATOPS_MODEL = new ProtoceratopsModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS));
		BABY_PROTOCERATOPS_MODEL = new ProtoceratopsJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_JUVENILE));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ProtoceratopsEyeLayer(this));
			this.addLayer(new ProtoceratopsJuvenileEyeLayer(this));
		}
	}

	protected void scale(Protoceratops triceratops, PoseStack matrixStackIn, float partialTickTime) {
		if(triceratops.isBaby()) {
				matrixStackIn.scale(0.5F, 0.5F, 0.5F);
			model = BABY_PROTOCERATOPS_MODEL;
		} else {
			model = PROTOCERATOPS_MODEL;
		}
		super.scale(triceratops, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Protoceratops entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && "Paleocraft".equals(s)) {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return PALEOCRAFT_JUVENILE_SLEEPING;
				} else return PALEOCRAFT_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return PALEOCRAFT_SLEEPING;
				} else return PALEOCRAFT;
			}
		} else if (entity.isAlbino()) {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_JUVENILE_SLEEPING;
				} else return ALBINO_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_JUVENILE_SLEEPING;
				} else return MELANISTIC_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			}
		} else {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return JUVENILE_SLEEPING;
				} else return JUVENILE;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return PROTOCERATOPS_SLEEPING;
				} else return PROTOCERATOPS;
			}
		}
	}

}
