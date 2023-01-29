package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkullEntity;

public class PostosuchusSkullRenderer extends MobRenderer<PostosuchusSkullEntity, PostosuchusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/postosuchus_skeleton.png");

    public PostosuchusSkullRenderer(EntityRendererManager rm) {
        super(rm, new PostosuchusSkullModel(), 0F);
    }
    
    @Override
	public ResourceLocation getEntityTexture(PostosuchusSkullEntity entity) {
    	return SKULL;
    }
}