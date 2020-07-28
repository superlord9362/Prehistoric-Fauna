package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.ThescelosaurusEntity;
import superlord.prehistoricfauna.entity.model.ThescelosaurusModel;

public class ThescelosaurusRenderer extends MobRenderer<ThescelosaurusEntity, ThescelosaurusModel> {

    private static final ResourceLocation THESCELOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/thescelosaurus.png");
    private static final ResourceLocation BABY = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/thescelosaurus_baby.png");

    public ThescelosaurusRenderer(EntityRendererManager rm) {
        super(rm, new ThescelosaurusModel(), 0.4f);
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