package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DryosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;

public class DryosaurusRenderer extends MobRenderer<DryosaurusEntity, EntityModel<DryosaurusEntity>> {

    private static final ResourceLocation DRYOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/dryosaurus.png");
    private static final ResourceLocation DRYOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/dryosaurus_baby.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/albino.png");
    private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/albino_baby.png");
    private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/melanistic.png");
    private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/melanistic_baby.png");
    private static final ResourceLocation DRYOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/dryosaurus_sleeping.png");
    private static final ResourceLocation DRYOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/dryosaurus_baby_sleeping.png");
    private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/albino_sleeping.png");
    private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/albino_baby_sleeping.png");
    private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/melanistic_sleeping.png");
    private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dryosaurus/melanistic_baby_sleeping.png");
    private static final DryosaurusModel DRYOSAURUS_MODEL = new DryosaurusModel();
    
    public DryosaurusRenderer(EntityRendererManager rm) {
        super(rm, DRYOSAURUS_MODEL, 0.375F);
    }
    
    protected void preRenderCallback(DryosaurusEntity dryosaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(dryosaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    @Override
	public ResourceLocation getEntityTexture(DryosaurusEntity entity) {
    	if (entity.isAlbino() && !entity.isChild()) {
    		if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
    			return ALBINO_SLEEPING;
    		} else return ALBINO;
    	} else if (entity.isAlbino() && entity.isChild()) {
    		if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
    			return ALBINO_BABY_SLEEPING;
    		} else return ALBINO_BABY;
    	} else if (entity.isMelanistic() && !entity.isChild()) {
    		if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
    			return MELANISTIC_SLEEPING;
    		} else return MELANISTIC;
    	} else if (entity.isMelanistic() && entity.isChild()) {
    		if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
    			return MELANISTIC_BABY_SLEEPING;
    		} else return MELANISTIC_BABY;
    	} else if(entity.isChild()) {
    		if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
    			return DRYOSAURUS_BABY_SLEEPING;
    		} else return DRYOSAURUS_BABY;
    	} else {
    		if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
    			return DRYOSAURUS_SLEEPING;
    		} else return DRYOSAURUS;
    	}
    }
}