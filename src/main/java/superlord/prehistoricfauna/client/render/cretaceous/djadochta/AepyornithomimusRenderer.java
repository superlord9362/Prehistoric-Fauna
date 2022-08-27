package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.AepyornithomimusModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.AepyornithomimusSleepingModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;

@OnlyIn(Dist.CLIENT)
public class AepyornithomimusRenderer extends MobRenderer<AepyornithomimusEntity, EntityModel<AepyornithomimusEntity>> {

	private static final AepyornithomimusModel AEPYORNITHOMIMUS_MODEL = new AepyornithomimusModel();
	private static final AepyornithomimusSleepingModel AEPYORNITHOMIMUS_SLEEPING_MODEL = new AepyornithomimusSleepingModel();
	private static final ResourceLocation AEPYORNITHOMIMUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus.png");
	private static final ResourceLocation AEPYORNITHOMIMUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/melanistic_sleeping.png");

	public AepyornithomimusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), AEPYORNITHOMIMUS_MODEL, 0.5F);
	}

	protected void preRenderCallback(AepyornithomimusEntity aepyornithomimus, MatrixStack matrixStackIn, float partialTickTime) {
		if(aepyornithomimus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(AepyornithomimusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = AEPYORNITHOMIMUS_SLEEPING_MODEL;
		} else {
			entityModel = AEPYORNITHOMIMUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public ResourceLocation getEntityTexture(AepyornithomimusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep()) {
				return AEPYORNITHOMIMUS_TEXTURE_SLEEPING;
			} else {
				return AEPYORNITHOMIMUS_TEXTURE;
			}
		}
	}
}