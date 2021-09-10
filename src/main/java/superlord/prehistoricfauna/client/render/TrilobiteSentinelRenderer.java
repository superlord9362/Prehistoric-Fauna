package superlord.prehistoricfauna.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.SentinelTrilobiteModel;
import superlord.prehistoricfauna.common.entities.TrilobiteSentinelEntity;

@OnlyIn(Dist.CLIENT)
public class TrilobiteSentinelRenderer extends MobRenderer<TrilobiteSentinelEntity, EntityModel<TrilobiteSentinelEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/sentinel_trilobite.png");

	public TrilobiteSentinelRenderer() {
		super(Minecraft.getInstance().getRenderManager(), new SentinelTrilobiteModel(), 1.25F);
		this.addLayer(new TrilobiteSentinelGlowLayer(this));
	}

	public ResourceLocation getEntityTexture(TrilobiteSentinelEntity entity) {
		return TEXTURE;
	}
}