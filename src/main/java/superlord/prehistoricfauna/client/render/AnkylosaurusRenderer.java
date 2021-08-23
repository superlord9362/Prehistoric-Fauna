package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.AnkylosaurusModel;
import superlord.prehistoricfauna.common.entities.AnkylosaurusEntity;

public class AnkylosaurusRenderer extends MobRenderer<AnkylosaurusEntity, AnkylosaurusModel> {

	private static final ResourceLocation ANKYLOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic.png");

	public AnkylosaurusRenderer(EntityRendererManager rm) {
		super(rm, new AnkylosaurusModel(), 2F);
	}

	protected void preRenderCallback(AnkylosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(AnkylosaurusEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return ANKYLOSAURUS;
		}
	}

}
