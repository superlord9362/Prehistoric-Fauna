package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.YangchuanosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.YangchuanosaurusSkull;

public class YangchuanosaurusSkullRenderer extends MobRenderer<YangchuanosaurusSkull, YangchuanosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/yangchuanosaurus_skeleton.png");

	public YangchuanosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YangchuanosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(YangchuanosaurusSkull entity) {
			return SKULL;
	}

}
