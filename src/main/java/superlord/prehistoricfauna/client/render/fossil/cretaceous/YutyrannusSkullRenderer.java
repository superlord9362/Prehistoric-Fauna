package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.YutyrannusSkull;

public class YutyrannusSkullRenderer extends MobRenderer<YutyrannusSkull, YutyrannusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/yutyrannus_skeleton.png");

	public YutyrannusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YutyrannusSkullModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(YutyrannusSkull entity) {
			return SKULL;
	}

}
