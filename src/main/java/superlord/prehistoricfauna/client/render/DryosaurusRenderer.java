package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.DryosaurusModel;
import superlord.prehistoricfauna.common.entities.DryosaurusEntity;

public class DryosaurusRenderer extends MobRenderer<DryosaurusEntity, DryosaurusModel> {

    private static final ResourceLocation DRYOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/dryosaurus.png");
    private static final ResourceLocation DRYOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/dryosaurus_baby.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/albino.png");
    private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/albino_baby.png");
    private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/melanistic.png");
    private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/melanistic_baby.png");

    public DryosaurusRenderer(EntityRendererManager rm) {
        super(rm, new DryosaurusModel(), 0.375F);
    }
    
    protected void preRenderCallback(DryosaurusEntity dryosaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(dryosaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    @Override
	public ResourceLocation getEntityTexture(DryosaurusEntity entity) {
    	if (entity.isAlbino() && !entity.isChild()) {
    		return ALBINO;
    	} else if (entity.isAlbino() && entity.isChild()) {
    		return ALBINO_BABY;
    	} else if (entity.isMelanistic() && !entity.isChild()) {
    		return MELANISTIC;
    	} else if (entity.isMelanistic() && entity.isChild()) {
    		return MELANISTIC_BABY;
    	} else if(entity.isChild()) {
    		return DRYOSAURUS_BABY;
    	} else {
    		return DRYOSAURUS;
    	}
    }
}