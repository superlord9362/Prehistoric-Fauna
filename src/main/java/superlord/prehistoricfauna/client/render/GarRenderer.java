package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.GarSmallModel;
import superlord.prehistoricfauna.common.entities.GarEntity;

public class GarRenderer extends MobRenderer<GarEntity, EntityModel<GarEntity>> {

	private static final ResourceLocation GAR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/gar.png");
	private static final GarSmallModel SMALL_GAR_MODEL = new GarSmallModel();

	public GarRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SMALL_GAR_MODEL, 0.625F);
	}

	public void render(GarEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = SMALL_GAR_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(GarEntity entity) {
		return GAR;
	}

}
