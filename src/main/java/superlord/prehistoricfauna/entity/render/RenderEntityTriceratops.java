package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.EntityTriceratops;
import superlord.prehistoricfauna.entity.model.Triceratops;

public class RenderEntityTriceratops extends MobRenderer<EntityTriceratops, Triceratops> {
	
	private static final ResourceLocation TRICERATOPS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/triceratops.png");
	
	public RenderEntityTriceratops(EntityRendererManager rm) {
		super(rm, new Triceratops(), 0.5F);
	}
	
	@SuppressWarnings("deprecation")
	protected void preRenderCallback(EntityTriceratops entitylivingbaseIn, float partialTickTime) {
		GlStateManager.translated(0.0, 0, 0);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityTriceratops entity) {
		return TRICERATOPS;
	}

}
