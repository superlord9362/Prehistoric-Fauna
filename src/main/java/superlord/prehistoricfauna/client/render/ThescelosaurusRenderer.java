package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Thescelosaurus;
import superlord.prehistoricfauna.common.entities.ThescelosaurusEntity;

public class ThescelosaurusRenderer extends MobRenderer<ThescelosaurusEntity, Thescelosaurus> {

    private static final ResourceLocation THESCELOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus.png");
    private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus_baby.png");

    public ThescelosaurusRenderer(EntityRendererManager rm) {
        super(rm, new Thescelosaurus(), 0.55f);
    }
    
    protected void preRenderCallback(ThescelosaurusEntity thescelosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

    @Override
	public ResourceLocation getEntityTexture(ThescelosaurusEntity entity) {
    	if(entity.isChild()) {
    		return BABY;
    	} else {
    		return THESCELOSAURUS;
    	}
    }
}