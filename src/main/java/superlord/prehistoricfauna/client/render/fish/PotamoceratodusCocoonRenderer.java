package superlord.prehistoricfauna.client.render.fish;

import javax.annotation.Nullable;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.LungfishCocoonModel;
import superlord.prehistoricfauna.common.entity.fish.PotamoceratodusCocoon;

public class PotamoceratodusCocoonRenderer extends MobRenderer<PotamoceratodusCocoon, EntityModel<PotamoceratodusCocoon>> {
	private static final ResourceLocation LUNGFISH = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/fish/lungfish.png");
	
	public PotamoceratodusCocoonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LungfishCocoonModel<PotamoceratodusCocoon>(renderManagerIn.bakeLayer(ClientEvents.LUNGFISH_COCOON)), 0F);
	}

	@Override
	public ResourceLocation getTextureLocation(PotamoceratodusCocoon entity) {
		return LUNGFISH;
	}
	
	@Nullable
	protected RenderType getRenderType(PotamoceratodusCocoon p_113806_, boolean p_113807_, boolean p_113808_, boolean p_113809_) {
		ResourceLocation resourcelocation = this.getTextureLocation(p_113806_);
		return RenderType.entityTranslucent(resourcelocation, false);
	}
	
}
