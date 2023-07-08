package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DryosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;

public class DryosaurusRenderer extends MobRenderer<Dryosaurus, DryosaurusModel> {
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

	public DryosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DryosaurusModel(renderManagerIn.bakeLayer(ClientEvents.DRYOSAURUS)), 0.375F);
	}

	protected void scale(Dryosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dryosaurus entity) {
		if (entity.isAlbino() && !entity.isBaby()) {
    		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
    			return ALBINO_SLEEPING;
    		} else return ALBINO;
    	} else if (entity.isAlbino() && entity.isBaby()) {
    		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
    			return ALBINO_BABY_SLEEPING;
    		} else return ALBINO_BABY;
    	} else if (entity.isMelanistic() && !entity.isBaby()) {
    		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
    			return MELANISTIC_SLEEPING;
    		} else return MELANISTIC;
    	} else if (entity.isMelanistic() && entity.isBaby()) {
    		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
    			return MELANISTIC_BABY_SLEEPING;
    		} else return MELANISTIC_BABY;
    	} else if(entity.isBaby()) {
    		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
    			return DRYOSAURUS_BABY_SLEEPING;
    		} else return DRYOSAURUS_BABY;
    	} else {
    		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
    			return DRYOSAURUS_SLEEPING;
    		} else return DRYOSAURUS;
    	}
    }
}
