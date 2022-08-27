package superlord.prehistoricfauna.client.render.fish;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fish.CyclurusModel;
import superlord.prehistoricfauna.common.entities.fish.CyclurusEntity;

public class CyclurusRenderer extends MobRenderer<CyclurusEntity, EntityModel<CyclurusEntity>> {

	private static final ResourceLocation CYCLURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/cyclurus.png");
	private static final CyclurusModel CYCLURUS_MODEL = new CyclurusModel();

	public CyclurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CYCLURUS_MODEL, 0.225F);
	}

	public void render(CyclurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CYCLURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(CyclurusEntity entity) {
		return CYCLURUS;
	}

}
