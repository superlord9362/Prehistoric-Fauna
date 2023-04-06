package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.client.render.layer.TriceratopsChestLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsJuvEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsSaddleLayer;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> {

	private static final ResourceLocation TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops.png");
	private static final ResourceLocation BABY_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_baby.png");
	private static final ResourceLocation JUVENILE_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_juvenile.png");
	private static final ResourceLocation TRICERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_sleeping.png");
	private static final ResourceLocation BABY_TRICERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_baby_sleeping.png");
	private static final ResourceLocation JUVENILE_TRICERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_juvenile_sleeping.png");
	
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino.png");
	private static final ResourceLocation BABY_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_juv.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_sleeping.png");
	private static final ResourceLocation BABY_ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_juv_sleeping.png");

	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic.png");
	private static final ResourceLocation BABY_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_juv.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_sleeping.png");
	private static final ResourceLocation BABY_MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_juv_sleeping.png");
	
	private static final TriceratopsModel TRICERATOPS_MODEL = new TriceratopsModel();
	private static final TriceratopsJuvenileModel BABY_TRICERATOPS_MODEL = new TriceratopsJuvenileModel();

	public TriceratopsRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TRICERATOPS_MODEL, 2F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TriceratopsEyeLayer(this));
			this.addLayer(new TriceratopsJuvEyeLayer(this));
		}
		this.addLayer(new TriceratopsSaddleLayer(this));
		this.addLayer(new TriceratopsChestLayer(this));
	}

	public void render(TriceratopsEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			entityModel = BABY_TRICERATOPS_MODEL;
		} else {
			entityModel = TRICERATOPS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(TriceratopsEntity triceratops, MatrixStack matrixStackIn, float partialTickTime) {
		if(triceratops.isChild() && !triceratops.isJuvenile()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(TriceratopsEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isChild()) {
				if (entity.isSleeping() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return BABY_ALBINO_SLEEPING;
				} else return BABY_ALBINO;
			} else {
				if (entity.isSleeping() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isChild()) {
				if (entity.isSleeping() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return BABY_MELANISTIC_SLEEPING;
				} else return BABY_MELANISTIC;
			} else {
				if (entity.isSleeping() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			}
		}
		if(entity.isChild() && !entity.isJuvenile()) {
			if (entity.isSleeping()) {
				return BABY_TRICERATOPS_SLEEPING;
			} else return BABY_TRICERATOPS;
		} else if (entity.isJuvenile()) {
			if (entity.isSleeping() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return JUVENILE_TRICERATOPS_SLEEPING;
			} else return JUVENILE_TRICERATOPS;
		} else {
			if (entity.isSleeping() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return TRICERATOPS_SLEEPING;
			} else return TRICERATOPS;
		}
	}

}
