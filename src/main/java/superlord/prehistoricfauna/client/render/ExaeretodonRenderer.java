package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Exaeretodon;
import superlord.prehistoricfauna.common.entities.ExaeretodonEntity;

public class ExaeretodonRenderer extends MobRenderer<ExaeretodonEntity, EntityModel<ExaeretodonEntity>>{
	
	private static final ResourceLocation EXAERETODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/exaeretodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/melanistic.png");

	private final static Exaeretodon EXAERETODON_MODEL = new Exaeretodon();
	
	public ExaeretodonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), EXAERETODON_MODEL, 0.75F);
	}
	
	public void render(ExaeretodonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = EXAERETODON_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(ExaeretodonEntity exaeretodon, MatrixStack matrixStackIn, float partialTickTime) {
		if(exaeretodon.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(ExaeretodonEntity entity) {
		if(entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return EXAERETODON;
		}
	}

}
