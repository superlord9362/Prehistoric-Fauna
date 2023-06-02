package superlord.prehistoricfauna.client.render.fossil.triassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.DesmatosuchusSkull;

public class DesmatosuchusSkullRenderer extends MobRenderer<DesmatosuchusSkull, DesmatosuchusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/desmatosuchus_skeleton.png");

	public DesmatosuchusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DesmatosuchusSkullModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(DesmatosuchusSkull entity) {
			return SKULL;
	}

}
