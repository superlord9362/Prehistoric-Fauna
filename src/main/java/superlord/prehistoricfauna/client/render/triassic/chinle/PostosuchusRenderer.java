package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.chinle.PostosuchusModel;
import superlord.prehistoricfauna.client.render.layer.PostosuchusEyeLayer;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@OnlyIn(Dist.CLIENT)
public class PostosuchusRenderer extends MobRenderer<PostosuchusEntity, EntityModel<PostosuchusEntity>> {

	private static final PostosuchusModel POSTOSUCHUS_MODEL = new PostosuchusModel();
	private static final ResourceLocation POSTOSUCHUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/postosuchus.png");
	private static final ResourceLocation POSTOSUCHUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/postosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/melanistic_sleeping.png");

	public PostosuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), POSTOSUCHUS_MODEL, 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new PostosuchusEyeLayer(this));
		}
	}

	protected void preRenderCallback(PostosuchusEntity postosuchus, MatrixStack matrixStackIn, float partialTickTime) {
		if(postosuchus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public ResourceLocation getEntityTexture(PostosuchusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return POSTOSUCHUS_TEXTURE_SLEEPING;
			} else {
				return POSTOSUCHUS_TEXTURE;
			}
		}
	}
}