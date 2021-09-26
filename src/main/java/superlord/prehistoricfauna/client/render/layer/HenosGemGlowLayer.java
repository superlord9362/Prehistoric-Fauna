package superlord.prehistoricfauna.client.render.layer;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;

@OnlyIn(Dist.CLIENT)
public class HenosGemGlowLayer extends AbstractHenosGlowLayer<TimeGuardianEntity, EntityModel<TimeGuardianEntity>> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos_gem_layer.png"));

	public HenosGemGlowLayer(IEntityRenderer<TimeGuardianEntity, EntityModel<TimeGuardianEntity>> rendererIn) {
		super(rendererIn);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

}
