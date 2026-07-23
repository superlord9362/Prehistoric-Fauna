package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.KayentavenatorSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.KayentavenatorSkull;

public class KayentavenatorSkullRenderer extends MobRenderer<KayentavenatorSkull, KayentavenatorSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/kayentavenator_skeleton.png");

	public KayentavenatorSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KayentavenatorSkullModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(KayentavenatorSkull entity) {
			return SKULL;
	}

}
