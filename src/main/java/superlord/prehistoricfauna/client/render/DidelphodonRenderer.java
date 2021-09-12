package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.DidelphodonModel;
import superlord.prehistoricfauna.client.render.layer.DidelphodonHeldItemLayer;
import superlord.prehistoricfauna.common.entities.DidelphodonEntity;

public class DidelphodonRenderer extends MobRenderer<DidelphodonEntity, DidelphodonModel> {

	private static final ResourceLocation DIDELPHODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/didelphodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/melanistic.png");

	public DidelphodonRenderer(EntityRendererManager rm) {
		super(rm, new DidelphodonModel(), 0.25F);
		this.addLayer(new DidelphodonHeldItemLayer(this));
	}

	protected void preRenderCallback(DidelphodonEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(DidelphodonEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return DIDELPHODON;
		}
	}

}
