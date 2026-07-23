package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.MorrolepisModel;
import superlord.prehistoricfauna.common.entity.fish.Morrolepis;

public class MorrolepisRenderer extends MobRenderer<Morrolepis, MorrolepisModel> {

	private static final ResourceLocation MORROLEPIS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/fish/morrolepis.png");

	public MorrolepisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MorrolepisModel(renderManagerIn.bakeLayer(ClientEvents.MORROLEPIS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Morrolepis entity) {
			return MORROLEPIS;
	}

}
