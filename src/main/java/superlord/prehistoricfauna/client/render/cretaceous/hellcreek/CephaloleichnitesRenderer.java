package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.CephaloleichnitesModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Cephaloleichnites;

public class CephaloleichnitesRenderer extends MobRenderer<Cephaloleichnites, CephaloleichnitesModel> {
	private static final ResourceLocation CEPHALOLEICHNITES_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bugs/cephaloleichnites.png");

	public CephaloleichnitesRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CephaloleichnitesModel(renderManagerIn.bakeLayer(ClientEvents.CEPHALOLEICHNITES)), 0F);
	}

	protected void scale(Cephaloleichnites thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(1, 1, 1);
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	protected void setupRotations(Cephaloleichnites entityLiving, PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		float progresso = 1F - (entityLiving.prevAttachChangeProgress + (entityLiving.attachChangeProgress - entityLiving.prevAttachChangeProgress) * partialTicks);

		float trans = entityLiving.isBaby() ? 0.25F : 0.1F;
		if(entityLiving.getAttachmentFacing() == Direction.DOWN){
			matrixStackIn.mulPose(Axis.YP.rotationDegrees (180.0F - rotationYaw));
			matrixStackIn.translate(0.0D, trans, 0.0D);
			if(entityLiving.yo < entityLiving.getY()){
				matrixStackIn.mulPose(Axis.XP.rotationDegrees(90 * (1 - progresso)));
			}else{
				matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90 * (1 - progresso)));
			}
			matrixStackIn.translate(0.0D, -trans, 0.0D);
		}else if(entityLiving.getAttachmentFacing() == Direction.UP){
			matrixStackIn.mulPose(Axis.YP.rotationDegrees (180.0F - rotationYaw));
			matrixStackIn.mulPose(Axis.XP.rotationDegrees(180));
			matrixStackIn.mulPose(Axis.YP.rotationDegrees(180));
			matrixStackIn.translate(0.0D, -trans * 2.5, 0.0D);

		}else{
			matrixStackIn.translate(0.0D, trans, 0.0D);
			switch (entityLiving.getAttachmentFacing()){
			case NORTH:
				matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F * progresso));
				matrixStackIn.mulPose(Axis.ZP.rotationDegrees(0));
				break;
			case SOUTH:
				matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0F));
				matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F * progresso ));
				break;
			case WEST:
				matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
				matrixStackIn.mulPose(Axis.YP.rotationDegrees(90F - 90.0F * progresso));
				matrixStackIn.mulPose(Axis.ZP.rotationDegrees(-90.0F));
				break;
			case EAST:
				matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F ));
				matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F * progresso - 90F));
				matrixStackIn.mulPose(Axis.ZP.rotationDegrees(90.0F));
				break;
			}
			if(entityLiving.getDeltaMovement().y <= -0.001F){
				matrixStackIn.mulPose(Axis.YP.rotationDegrees(-180.0F));
			}
			matrixStackIn.translate(0.0D, -trans, 0.0D);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Cephaloleichnites entity) {
		return CEPHALOLEICHNITES_TEXTURE;

	}
}
