package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.VelociraptorModel;
import superlord.prehistoricfauna.client.render.layer.VelociraptorEyeLayer;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class VelociraptorRenderer extends MobRenderer<VelociraptorEntity, EntityModel<VelociraptorEntity>> {

	private static final ResourceLocation VELOCIRAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/melanistic.png");
	private static final ResourceLocation VELOCIRAPTOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/melanistic_sleeping.png");
	private static final ResourceLocation CROWBER = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/crowber.png");

	private static final VelociraptorModel VELOCIRAPTOR_MODEL = new VelociraptorModel();

	public VelociraptorRenderer() {
		super(Minecraft.getInstance().getRenderManager(), VELOCIRAPTOR_MODEL, 0.3125F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new VelociraptorEyeLayer(this));
		}
	}

	protected void preRenderCallback(VelociraptorEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(VelociraptorEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = VELOCIRAPTOR_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(VelociraptorEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
		if ( s != null && "Crowber".equals(s)) {
			return CROWBER;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return VELOCIRAPTOR_SLEEPING;
			} else {
				return VELOCIRAPTOR;
			}
		}
	}


}
