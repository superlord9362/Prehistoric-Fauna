package superlord.prehistoricfauna.client.render.fish;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fish.ChinleaModel;
import superlord.prehistoricfauna.common.entities.fish.ChinleaEntity;

public class ChinleaRenderer extends MobRenderer<ChinleaEntity, EntityModel<ChinleaEntity>> {

	private static final ResourceLocation CHINLEA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/chinlea.png");
	private static final ChinleaModel CHINLEA_MODEL = new ChinleaModel();

	public ChinleaRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CHINLEA_MODEL, 0.425F);
	}

	public void render(ChinleaEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CHINLEA_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(ChinleaEntity entity) {
		return CHINLEA;
	}

}
