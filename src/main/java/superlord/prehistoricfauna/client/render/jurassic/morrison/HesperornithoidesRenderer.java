package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.HesperornithoidesModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;

public class HesperornithoidesRenderer extends MobRenderer<Hesperornithoides, HesperornithoidesModel> {
	private static final ResourceLocation HESPERORNITHOIDES = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hesperornithoides/hesperornithoides.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hesperornithoides/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hesperornithoides/melanistic.png");
	private static final ResourceLocation HESPERORNITHOIDES_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hesperornithoides/hesperornithoides_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hesperornithoides/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hesperornithoides/melanistic_sleeping.png");

	public HesperornithoidesRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HesperornithoidesModel(renderManagerIn.bakeLayer(ClientEvents.HESPERORNITHOIDES)), 0.375F);
	}

	protected void scale(Hesperornithoides thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Hesperornithoides entity) {
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
				return HESPERORNITHOIDES_SLEEPING;
			} else return HESPERORNITHOIDES;
		}
	}
}
