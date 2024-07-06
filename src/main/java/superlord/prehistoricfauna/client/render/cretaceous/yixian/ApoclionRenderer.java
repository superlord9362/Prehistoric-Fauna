package superlord.prehistoricfauna.client.render.cretaceous.yixian;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.ApoclionModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Apoclion;

public class ApoclionRenderer extends MobRenderer<Apoclion, ApoclionModel> {
	private static final ResourceLocation APOCLION_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bugs/apoclion.png");

	public ApoclionRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ApoclionModel(renderManagerIn.bakeLayer(ClientEvents.APOCLION)), 0F);
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	protected void setupRotations(Apoclion entityLiving, PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		float progresso = 1F - (entityLiving.prevAttachChangeProgress + (entityLiving.attachChangeProgress - entityLiving.prevAttachChangeProgress) * partialTicks);

        float trans = entityLiving.isBaby() ? 0.25F : 0.1F;
		if(entityLiving.getAttachmentFacing() == Direction.DOWN){
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees (180.0F - rotationYaw));
			matrixStackIn.translate(0.0D, trans, 0.0D);
			if(entityLiving.yo < entityLiving.getY()){
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90 * (1 - progresso)));
			}else{
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(-90 * (1 - progresso)));
			}
			matrixStackIn.translate(0.0D, -trans, 0.0D);

		}else if(entityLiving.getAttachmentFacing() == Direction.UP){
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees (180.0F - rotationYaw));
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180));
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180));
			matrixStackIn.translate(0.0D, -trans * 2.5, 0.0D);

		}else{
			matrixStackIn.translate(0.0D, trans, 0.0D);
			switch (entityLiving.getAttachmentFacing()){
			case NORTH:
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F * progresso));
				matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(0));
				break;
			case SOUTH:
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F));
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F * progresso ));
				break;
			case WEST:
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F - 90.0F * progresso));
				matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
				break;
			case EAST:
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F ));
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F * progresso - 90F));
				matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
				break;
			}
			if(entityLiving.getDeltaMovement().y <= -0.001F){
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-180.0F));
			}
			matrixStackIn.translate(0.0D, -trans, 0.0D);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Apoclion entity) {
		return APOCLION_TEXTURE;

	}
}
