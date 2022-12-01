package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.chinle.PlaceriasModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.PlaceriasSleepingModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;

public class PlaceriasRenderer extends MobRenderer<PlaceriasEntity, EntityModel<PlaceriasEntity>> {

	private static final ResourceLocation PLACERIAS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/placerias.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/melanistic.png");
	private static final ResourceLocation PLACERIAS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/placerias_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/melanistic_sleeping.png");
	private static final PlaceriasModel PLACERIAS_MODEL = new PlaceriasModel();
	private static final PlaceriasSleepingModel PLACERIAS_SLEEPING_MODEL = new PlaceriasSleepingModel();

	public PlaceriasRenderer() {
		super(Minecraft.getInstance().getRenderManager(), PLACERIAS_MODEL, 1F);
	}

	public void render(PlaceriasEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = PLACERIAS_SLEEPING_MODEL;
		} else {
			entityModel = PLACERIAS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(PlaceriasEntity placerias, MatrixStack matrixStackIn, float partialTickTime) {
		if (placerias.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(PlaceriasEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return PLACERIAS_SLEEPING;
			} else return PLACERIAS;
		}
	}

}
