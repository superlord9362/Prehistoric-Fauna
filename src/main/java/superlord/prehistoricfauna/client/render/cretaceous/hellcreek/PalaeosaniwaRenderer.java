package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.PalaeosaniwaModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Palaeosaniwa;

public class PalaeosaniwaRenderer extends MobRenderer<Palaeosaniwa, PalaeosaniwaModel> {
	private static final ResourceLocation PALAEOSANIWA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/palaeosaniwa/palaeosaniwa.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/palaeosaniwa/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/palaeosaniwa/melanistic.png");
	private static final ResourceLocation PALAEOSANIWA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/palaeosaniwa/palaeosaniwa_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/palaeosaniwa/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/palaeosaniwa/melanistic_sleeping.png");

	public PalaeosaniwaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PalaeosaniwaModel(renderManagerIn.bakeLayer(ClientEvents.PALAEOSANIWA)), 0.25F);
	}

	protected void scale(Palaeosaniwa thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Palaeosaniwa entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return PALAEOSANIWA_SLEEPING;
			} else return PALAEOSANIWA;
		}
	}
}
