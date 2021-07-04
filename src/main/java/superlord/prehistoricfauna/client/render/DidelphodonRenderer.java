package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Didelphodon;
import superlord.prehistoricfauna.common.entities.DidelphodonEntity;

public class DidelphodonRenderer extends MobRenderer<DidelphodonEntity, EntityModel<DidelphodonEntity>> {
	
	private static final ResourceLocation DIDELPHODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon.png");
	private static final Didelphodon DIDELPHODON_MODEL = new Didelphodon();
	
	public DidelphodonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), DIDELPHODON_MODEL, 0.25F);
	}
	
	public void render(DidelphodonEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
		entityModel = DIDELPHODON_MODEL;
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}
	
	protected void preRenderCallback(DidelphodonEntity didelphodon, MatrixStack matrixStack, float partialTickTime) {
		if(didelphodon.isChild()) {
			matrixStack.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(DidelphodonEntity entity) {
		return DIDELPHODON;
	}

}
