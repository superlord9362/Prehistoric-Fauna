package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.CyclurusModel;
import superlord.prehistoricfauna.common.entity.fish.Cyclurus;

public class CyclurusRenderer extends MobRenderer<Cyclurus, CyclurusModel> {

	private static final ResourceLocation CYCLURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/cyclurus.png");

	public CyclurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CyclurusModel(renderManagerIn.bakeLayer(ClientEvents.CYCLURUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Cyclurus entity) {
			return CYCLURUS;
	}

}
