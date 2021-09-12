package superlord.prehistoricfauna.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.LandSentinelModel;
import superlord.prehistoricfauna.client.render.layer.LandSentinelGlowLayer;
import superlord.prehistoricfauna.common.entities.LandSentinelEntity;

@OnlyIn(Dist.CLIENT)
public class LandSentinelRenderer extends MobRenderer<LandSentinelEntity, EntityModel<LandSentinelEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/land_sentinel.png");

	public LandSentinelRenderer() {
		super(Minecraft.getInstance().getRenderManager(), new LandSentinelModel(), 1.25F);
		this.addLayer(new LandSentinelGlowLayer(this));
	}

	public ResourceLocation getEntityTexture(LandSentinelEntity entity) {
		return TEXTURE;
	}
}