package superlord.prehistoricfauna.client.render.fish;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fish.SaurichthysModel;
import superlord.prehistoricfauna.common.entities.fish.SaurichthysEntity;

public class SaurichthysRenderer extends MobRenderer<SaurichthysEntity, EntityModel<SaurichthysEntity>> {

	private static final ResourceLocation SAURICHTHYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/saurichthys.png");
	private static final SaurichthysModel SAURICHTHYS_MODEL = new SaurichthysModel();

	public SaurichthysRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SAURICHTHYS_MODEL, 0.425F);
	}

	public void render(SaurichthysEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = SAURICHTHYS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(SaurichthysEntity entity) {
		return SAURICHTHYS;
	}

}
