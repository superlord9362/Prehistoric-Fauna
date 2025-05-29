package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.ChungkingichthysModel;
import superlord.prehistoricfauna.common.entity.fish.Chungkingichthys;

public class ChungkingichthysRenderer extends MobRenderer<Chungkingichthys, ChungkingichthysModel> {

	private static final ResourceLocation CHUNGKINGICHTHYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/chungkingichthys.png");

	public ChungkingichthysRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChungkingichthysModel(renderManagerIn.bakeLayer(ClientEvents.CHUNGKINGICHTHYS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Chungkingichthys entity) {
			return CHUNGKINGICHTHYS;
	}

}
