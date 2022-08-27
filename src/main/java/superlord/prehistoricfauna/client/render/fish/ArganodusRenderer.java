package superlord.prehistoricfauna.client.render.fish;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fish.ArganodusModel;
import superlord.prehistoricfauna.common.entities.fish.ArganodusEntity;

public class ArganodusRenderer extends MobRenderer<ArganodusEntity, EntityModel<ArganodusEntity>> {

	private static final ResourceLocation ARGANODUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/arganodus.png");
	private static final ArganodusModel ARGANODUS_MODEL = new ArganodusModel();

	public ArganodusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), ARGANODUS_MODEL, 0.425F);
	}

	public void render(ArganodusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = ARGANODUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(ArganodusEntity entity) {
		return ARGANODUS;
	}

}
