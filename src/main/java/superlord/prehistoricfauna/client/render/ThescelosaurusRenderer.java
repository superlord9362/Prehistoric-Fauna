package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.ThescelosaurusModel;
import superlord.prehistoricfauna.common.entities.ThescelosaurusEntity;

public class ThescelosaurusRenderer extends MobRenderer<ThescelosaurusEntity, ThescelosaurusModel> {

    private static final ResourceLocation THESCELOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/thescelosaurus.png");
    private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/thescelosaurus_baby.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thescelosaurus/melanistic.png");

    public ThescelosaurusRenderer(EntityRendererManager rm) {
        super(rm, new ThescelosaurusModel(), 0.55f);
    }
    
    protected void preRenderCallback(ThescelosaurusEntity thescelosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

    @Override
	public ResourceLocation getEntityTexture(ThescelosaurusEntity entity) {
    	if(entity.isChild() && !entity.isAlbino() && !entity.isMelanistic()) {
    		return BABY;
    	} else if (entity.isAlbino()) {
    		return ALBINO;
    	} else if (entity.isMelanistic()) {
    		return MELANISTIC;
    	} else {
    		return THESCELOSAURUS;
    	}
    }
}