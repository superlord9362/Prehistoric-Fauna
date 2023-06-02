package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.TelmasaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;

public class TelmasaurusRenderer extends MobRenderer<Telmasaurus, TelmasaurusModel> {
	private static final ResourceLocation TELMASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/telmasaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/melanistic.png");
	private static final ResourceLocation TELMASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/telmasaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/melanistic_sleeping.png");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelmasaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TelmasaurusModel(renderManagerIn.bakeLayer(ClientEvents.TELMASAURUS)), 0.25F);
		this.addLayer(new ItemInHandLayer(this));
	}

	protected void scale(Telmasaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Telmasaurus entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return TELMASAURUS_SLEEPING;
			} else return TELMASAURUS;
		}
	}
}
