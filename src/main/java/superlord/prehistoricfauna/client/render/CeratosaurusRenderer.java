package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.CeratosaurusModel;
import superlord.prehistoricfauna.common.entities.CeratosaurusEntity;

public class CeratosaurusRenderer extends MobRenderer<CeratosaurusEntity,  EntityModel<CeratosaurusEntity>> {

	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic.png");
	private static final CeratosaurusModel CERATOSAURUS_MODEL = new CeratosaurusModel();

	public CeratosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CERATOSAURUS_MODEL, 0.75F);
	}

	public void render(CeratosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CERATOSAURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(CeratosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(CeratosaurusEntity entity) {
		if (entity.isMelanistic()) {
			return MELANISTIC;
		} else if (entity.isAlbino()) {
			return ALBINO;
		} else {
			return CERATOSAURUS;
		}
	}

}
