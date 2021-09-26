package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.CeratodusModel;
import superlord.prehistoricfauna.common.entities.CeratodusEntity;

public class CeratodusRenderer extends MobRenderer<CeratodusEntity, EntityModel<CeratodusEntity>> {

	private static final ResourceLocation CERATODUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/ceratodus.png");
	private static final CeratodusModel CERATODUS_MODEL = new CeratodusModel();

	public CeratodusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CERATODUS_MODEL, 0.625F);
	}

	public void render(CeratodusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CERATODUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(CeratodusEntity entity) {
		return CERATODUS;
	}

}
