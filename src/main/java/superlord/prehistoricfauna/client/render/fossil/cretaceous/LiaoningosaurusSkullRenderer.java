package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.LiaoningosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.LiaoningosaurusSkull;

public class LiaoningosaurusSkullRenderer extends MobRenderer<LiaoningosaurusSkull, LiaoningosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/liaoningosaurus_skeleton.png");

	public LiaoningosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LiaoningosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(LiaoningosaurusSkull entity) {
			return SKULL;
	}

}
