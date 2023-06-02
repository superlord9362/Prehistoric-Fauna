package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosModel;
import superlord.prehistoricfauna.client.render.layer.PlesiohadrosSaddleLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;

public class PlesiohadrosRenderer extends MobRenderer<Plesiohadros, PlesiohadrosModel> {
	private static final ResourceLocation PLESIOHADROS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic.png");
	private static final ResourceLocation DEOXIDATED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated.png");
	private static final ResourceLocation PLESIOHADROS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/melanistic_sleeping.png");
	private static final ResourceLocation DEOXIDATED_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/deoxidated_sleeping.png");

	public PlesiohadrosRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PlesiohadrosModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS)), 2F);
		this.addLayer(new PlesiohadrosSaddleLayer(this));
}

	protected void scale(Plesiohadros thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Plesiohadros entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
				return ALBINO_SLEEPING;
			} 
			else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
				return MELANISTIC_SLEEPING;
			}
			 else return MELANISTIC;
		} else if (!entity.isMelanistic() && !entity.isAlbino() && entity.isDeoxidated()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
				return DEOXIDATED_SLEEPING;
			} else return DEOXIDATED;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5 && !entity.isSaddled()) {
				return PLESIOHADROS_SLEEPING;
			} else return PLESIOHADROS;
		}
	}
}
