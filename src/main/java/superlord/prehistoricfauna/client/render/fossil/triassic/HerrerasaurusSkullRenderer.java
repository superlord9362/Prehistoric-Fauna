package superlord.prehistoricfauna.client.render.fossil.triassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.HerrerasaurusSkull;

public class HerrerasaurusSkullRenderer extends MobRenderer<HerrerasaurusSkull, HerrerasaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/herrerasaurus_skeleton.png");

	public HerrerasaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HerrerasaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.HERRERASAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(HerrerasaurusSkull entity) {
			return SKULL;
	}

}
