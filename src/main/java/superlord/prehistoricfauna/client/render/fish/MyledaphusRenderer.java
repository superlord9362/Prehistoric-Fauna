package superlord.prehistoricfauna.client.render.fish;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fish.MyledaphusModel;
import superlord.prehistoricfauna.common.entities.fish.MyledaphusEntity;

public class MyledaphusRenderer  extends MobRenderer<MyledaphusEntity, MyledaphusModel> {

	private static final ResourceLocation MYLEDAPHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/myledaphus.png");
	public MyledaphusRenderer(EntityRendererManager rm) {
		super(rm, new MyledaphusModel(), 0.6875F);
	}

	protected void preRenderCallback(MyledaphusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(MyledaphusEntity entity) {
		return MYLEDAPHUS;
	}

}
