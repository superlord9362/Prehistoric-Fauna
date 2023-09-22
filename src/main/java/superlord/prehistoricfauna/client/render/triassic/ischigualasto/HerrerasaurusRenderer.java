package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HerrerasaurusModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;

public class HerrerasaurusRenderer extends MobRenderer<Herrerasaurus, HerrerasaurusModel> {
	private static final ResourceLocation HERRERASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/herrerasaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/melanistic.png");
	private static final ResourceLocation HERRERASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/herrerasaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/melanistic_sleeping.png");
	private static final ResourceLocation ZOO_TYCOON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/herrerasaurus_ztc.png");
	private static final ResourceLocation ZOO_TYCOON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/herrerasaurus/herrerasaurus_ztc_sleeping.png");

	public HerrerasaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HerrerasaurusModel(renderManagerIn.bakeLayer(ClientEvents.HERRERASAURUS)), 0.625F);
	}

	protected void scale(Herrerasaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Herrerasaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && ("Zoo Tycoon".equals(s) || "Zoo tycoon".equals(s) || "zoo tycoon".equals(s))) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ZOO_TYCOON_SLEEPING;
			} else return ZOO_TYCOON;
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
				return HERRERASAURUS_SLEEPING;
			} else return HERRERASAURUS;
		}
	}
}
