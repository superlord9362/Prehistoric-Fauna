package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.VelociraptorModel;
import superlord.prehistoricfauna.client.model.VelociraptorSittingModel;
import superlord.prehistoricfauna.common.entities.VelociraptorEntity;

public class VelociraptorRenderer extends MobRenderer<VelociraptorEntity, EntityModel<VelociraptorEntity>> {

	private static final ResourceLocation VELOCIRAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/melanistic.png");

	private static final VelociraptorModel VELOCIRAPTOR_MODEL = new VelociraptorModel();
	private static final VelociraptorSittingModel VELOCIRAPTOR_SITTING_MODEL = new VelociraptorSittingModel();

	public VelociraptorRenderer() {
		super(Minecraft.getInstance().getRenderManager(), VELOCIRAPTOR_MODEL, 0.3125F);
	}

	protected void preRenderCallback(VelociraptorEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(VelociraptorEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isSitting()) {
			entityModel = VELOCIRAPTOR_SITTING_MODEL;
		} else {
			entityModel = VELOCIRAPTOR_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(VelociraptorEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return VELOCIRAPTOR;
		}
	}


}
