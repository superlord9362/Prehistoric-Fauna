package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Sillosuchus;
import superlord.prehistoricfauna.common.entities.SillosuchusEntity;

@OnlyIn(Dist.CLIENT)
public class SillosuchusRenderer extends MobRenderer<SillosuchusEntity, EntityModel<SillosuchusEntity>>{
	
	private static final Sillosuchus SILLOSUCHUS_MODEL = new Sillosuchus();
	private static final ResourceLocation SILLOSUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus.png");
	
	public SillosuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SILLOSUCHUS_MODEL, 1.0F);
	}
	
	protected void preRenderCallback(SillosuchusEntity sillosuchus, MatrixStack matrixStackIn, float partialTickTime) {
		if (sillosuchus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	public ResourceLocation getEntityTexture(SillosuchusEntity entity) {
		return SILLOSUCHUS;
	}

}
