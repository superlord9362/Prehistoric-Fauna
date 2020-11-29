package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.DryosaurusEntity;
import superlord.prehistoricfauna.entity.model.Dryosaurus;

public class DryosaurusRenderer extends MobRenderer<DryosaurusEntity, Dryosaurus> {

    private static final ResourceLocation DRYOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/dryosaurus.png");

    public DryosaurusRenderer(EntityRendererManager rm) {
        super(rm, new Dryosaurus(), 0.375F);
    }
    
    protected void preRenderCallback(DryosaurusEntity dryosaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(dryosaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    @Override
	public ResourceLocation getEntityTexture(DryosaurusEntity entity) {
    	return DRYOSAURUS;
    }
}