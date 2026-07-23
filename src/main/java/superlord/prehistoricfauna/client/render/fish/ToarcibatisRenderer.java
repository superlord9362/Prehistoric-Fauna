package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.ToarcibatisModel;
import superlord.prehistoricfauna.common.entity.fish.Toarcibatis;

public class ToarcibatisRenderer extends MobRenderer<Toarcibatis, ToarcibatisModel> {

	private static final ResourceLocation TOARCIBATIS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/fish/toarcibatis.png");

	public ToarcibatisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ToarcibatisModel(renderManagerIn.bakeLayer(ClientEvents.TOARCIBATIS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Toarcibatis entity) {
			return TOARCIBATIS;
	}

}
