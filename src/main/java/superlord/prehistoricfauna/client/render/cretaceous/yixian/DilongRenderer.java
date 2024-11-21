package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.DilongModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dilong;

public class DilongRenderer extends MobRenderer<Dilong, DilongModel> {
	private static final ResourceLocation DILONG = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilong/dilong.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilong/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilong/melanistic.png");
	private static final ResourceLocation DILONG_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilong/dilong_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilong/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilong/melanistic_sleeping.png");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DilongRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DilongModel(renderManagerIn.bakeLayer(ClientEvents.DILONG)), 0.375F);
		this.addLayer(new ItemInHandLayer(this, renderManagerIn.getItemInHandRenderer()));
	}

	protected void scale(Dilong dilong, PoseStack matrixStackIn, float partialTickTime) {
		if(dilong.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(dilong, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dilong entity) {
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
				return DILONG_SLEEPING;
			} else return DILONG;
		}
	}
}