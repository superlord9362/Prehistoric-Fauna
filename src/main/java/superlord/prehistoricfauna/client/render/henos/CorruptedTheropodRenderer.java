package superlord.prehistoricfauna.client.render.henos;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.henos.CorruptedTheropodModel;
import superlord.prehistoricfauna.client.render.layer.CorruptedTheropodHeadFiveLayer;
import superlord.prehistoricfauna.client.render.layer.CorruptedTheropodHeadFourLayer;
import superlord.prehistoricfauna.client.render.layer.CorruptedTheropodHeadOneLayer;
import superlord.prehistoricfauna.client.render.layer.CorruptedTheropodHeadSixLayer;
import superlord.prehistoricfauna.client.render.layer.CorruptedTheropodHeadThreeLayer;
import superlord.prehistoricfauna.client.render.layer.CorruptedTheropodHeadTwoLayer;
import superlord.prehistoricfauna.common.entity.henos.CorruptedTheropod;

public class CorruptedTheropodRenderer extends MobRenderer<CorruptedTheropod, CorruptedTheropodModel> {
	private static final ResourceLocation CORRUPTED_THEROPOD = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/corrupted_theropod/corrupted_theropod.png");

	public CorruptedTheropodRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CorruptedTheropodModel(renderManagerIn.bakeLayer(ClientEvents.CORRUPTED_THEROPOD)), 2F);
		this.addLayer(new CorruptedTheropodHeadOneLayer(this));
		this.addLayer(new CorruptedTheropodHeadTwoLayer(this));
		this.addLayer(new CorruptedTheropodHeadThreeLayer(this));
		this.addLayer(new CorruptedTheropodHeadFourLayer(this));
		this.addLayer(new CorruptedTheropodHeadFiveLayer(this));
		this.addLayer(new CorruptedTheropodHeadSixLayer(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(CorruptedTheropod entity) {
		return CORRUPTED_THEROPOD;
	}
	
}
