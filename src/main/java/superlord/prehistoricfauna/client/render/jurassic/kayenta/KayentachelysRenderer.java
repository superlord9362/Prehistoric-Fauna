package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentachelysModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentachelys;

public class KayentachelysRenderer extends MobRenderer<Kayentachelys, KayentachelysModel> {
	private static final ResourceLocation KAYENTACHELYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentachelys/kayentachelys.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentachelys/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentachelys/melanistic.png");
	private static final ResourceLocation KAYENTACHELYS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentachelys/kayentachelys_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentachelys/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentachelys/melanistic_sleeping.png");

	public KayentachelysRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KayentachelysModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTACHELYS)), 0.5F);
	}

	protected void scale(Kayentachelys thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Kayentachelys entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return KAYENTACHELYS_SLEEPING;
			} else {
				return KAYENTACHELYS;
			}
		}
	}
}
