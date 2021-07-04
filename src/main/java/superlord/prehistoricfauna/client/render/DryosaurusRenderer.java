package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Dryosaurus;
import superlord.prehistoricfauna.common.entities.DryosaurusEntity;

public class DryosaurusRenderer extends MobRenderer<DryosaurusEntity, Dryosaurus> {

    private static final ResourceLocation DRYOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus.png");
    private static final ResourceLocation DRYOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus_baby.png");

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
    	if(entity.isChild()) {
    		return DRYOSAURUS_BABY;
    	} else {
    		return DRYOSAURUS;
    	}
    }
}