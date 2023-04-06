package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsModel;
import superlord.prehistoricfauna.client.render.layer.ProtoceratopsBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.ProtoceratopsEyeLayer;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ProtoceratopsRenderer extends MobRenderer<ProtoceratopsEntity, EntityModel<ProtoceratopsEntity>> {

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
	private static final ProtoceratopsModel PROTOCERATOPS_MODEL = new ProtoceratopsModel();
	private static final ProtoceratopsBabyModel BABY_MODEL = new ProtoceratopsBabyModel();

	public ProtoceratopsRenderer(EntityRendererManager rm) {
		super(rm, PROTOCERATOPS_MODEL, 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ProtoceratopsEyeLayer(this));
			this.addLayer(new ProtoceratopsBabyEyeLayer(this));
		}
	}

	protected void preRenderCallback(ProtoceratopsEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(ProtoceratopsEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			entityModel = BABY_MODEL;
		} else entityModel = PROTOCERATOPS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(ProtoceratopsEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
		if ( s != null && "Paleocraft".equals(s)) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return PALEOCRAFT_JUVENILE_SLEEPING;
				} else return PALEOCRAFT_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return PALEOCRAFT_SLEEPING;
				} else return PALEOCRAFT;
			}
		} else if (entity.isAlbino()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_JUVENILE_SLEEPING;
				} else return ALBINO_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_JUVENILE_SLEEPING;
				} else return MELANISTIC_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			}
		} else {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return JUVENILE_SLEEPING;
				} else return JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return PROTOCERATOPS_SLEEPING;
				} else return PROTOCERATOPS;
			}
		}
	}

}
