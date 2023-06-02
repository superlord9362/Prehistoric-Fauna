package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.PotamoceratodusModel;
import superlord.prehistoricfauna.common.entity.fish.Potamoceratodus;

public class PotamoceratodusRenderer extends MobRenderer<Potamoceratodus, PotamoceratodusModel> {

	private static final ResourceLocation POTAMOCERATODUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/potamoceratodus.png");

	public PotamoceratodusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PotamoceratodusModel(renderManagerIn.bakeLayer(ClientEvents.POTAMOCERATODUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Potamoceratodus entity) {
			return POTAMOCERATODUS;
	}

}
