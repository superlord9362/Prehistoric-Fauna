package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.PotamoceratodusModel;
import superlord.prehistoricfauna.common.entities.PotamoceratodusEntity;

public class PotamoceratodusRenderer extends MobRenderer<PotamoceratodusEntity, EntityModel<PotamoceratodusEntity>> {

	private static final ResourceLocation POTAMOCERATODUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/potamoceratodus.png");
	private static final PotamoceratodusModel POTAMOCERATODUS_MODEL = new PotamoceratodusModel();

	public PotamoceratodusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), POTAMOCERATODUS_MODEL, 0.625F);
	}

	public void render(PotamoceratodusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = POTAMOCERATODUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(PotamoceratodusEntity entity) {
		return POTAMOCERATODUS;
	}

}
