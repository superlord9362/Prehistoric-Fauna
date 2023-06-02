package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.CitipatiModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;

public class CitipatiRenderer extends MobRenderer<Citipati, CitipatiModel> {
	private static final ResourceLocation CITIPATI = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic.png");
	private static final ResourceLocation PALEOCRAFT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/paleocraft.png");
	private static final ResourceLocation CITIPATI_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic_sleeping.png");
	private static final ResourceLocation PALEOCRAFT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/paleocraft_sleeping.png");

	public CitipatiRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CitipatiModel(renderManagerIn.bakeLayer(ClientEvents.CITIPATI)), 0.5625F);
	}

	protected void scale(Citipati thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Citipati entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && "Paleocraft".equals(s)) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return PALEOCRAFT_SLEEPING;
			} else return PALEOCRAFT;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return CITIPATI_SLEEPING;
			} else return CITIPATI;
		}
	}
}
