package superlord.prehistoricfauna.client.render.fish;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fish.MooreodontusModel;
import superlord.prehistoricfauna.common.entities.fish.MooreodontusEntity;

public class MooreodontusRenderer extends MobRenderer<MooreodontusEntity, EntityModel<MooreodontusEntity>> {

	private static final ResourceLocation MOOREODONTUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/mooreodontus.png");
	private static final MooreodontusModel MOOREODONTUS_MODEL = new MooreodontusModel();

	public MooreodontusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), MOOREODONTUS_MODEL, 0.425F);
	}

	public void render(MooreodontusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = MOOREODONTUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(MooreodontusEntity entity) {
		return MOOREODONTUS;
	}

}
