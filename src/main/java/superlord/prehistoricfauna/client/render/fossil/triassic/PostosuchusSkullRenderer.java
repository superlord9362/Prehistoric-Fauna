package superlord.prehistoricfauna.client.render.fossil.triassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.PostosuchusSkull;

public class PostosuchusSkullRenderer extends MobRenderer<PostosuchusSkull, PostosuchusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/postosuchus_skeleton.png");

	public PostosuchusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PostosuchusSkullModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(PostosuchusSkull entity) {
			return SKULL;
	}

}
