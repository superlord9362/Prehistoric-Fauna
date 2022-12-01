package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorModel;
import superlord.prehistoricfauna.client.render.layer.DakotaraptorEyeLayer;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DakotaraptorRenderer extends MobRenderer<DakotaraptorEntity, EntityModel<DakotaraptorEntity>> {

	private static final ResourceLocation DAKOTARAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_sleeping.png");
	private static final ResourceLocation CHILD_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_child_sleeping.png");
	private static final ResourceLocation CHILD = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_child.png");
	private static final ResourceLocation MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_man.png");
	private static final ResourceLocation SLEEPING_MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_man_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_sleeping.png");
	private static final ResourceLocation ALBINO_MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_man.png");
	private static final ResourceLocation ALBINO_MAN_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/albino_man_sleeping.png");
	private static final ResourceLocation MELANISTIC_MAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_man.png");
	private static final ResourceLocation MELANISTIC_MAN_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/melanistic_man_sleeping.png");

	private static final DakotaraptorModel DAKOTARAPTOR_MODEL = new DakotaraptorModel();

	public DakotaraptorRenderer() {
		super(Minecraft.getInstance().getRenderManager(), DAKOTARAPTOR_MODEL, 0.875F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DakotaraptorEyeLayer(this));
		}
	}

	protected void preRenderCallback(DakotaraptorEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(DakotaraptorEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = DAKOTARAPTOR_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(DakotaraptorEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
		if (s != null && "A MAN".equals(s)) {
			if (entity.isSleeping() || entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				if (entity.isAlbino()) {
					return ALBINO_MAN_SLEEPING;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_MAN_SLEEPING;
				} else {
					return SLEEPING_MAN;
				}
			} else {
				if (entity.isAlbino()) {
					return ALBINO_MAN;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_MAN;
				} else {
					return MAN;
				}
			}
		} else if(entity.isSleeping() || entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
			if (entity.isChild()) {
				return CHILD_SLEEPING;
			} else {
				if (entity.isAlbino()) {
					return ALBINO_SLEEPING;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_SLEEPING;
				} else {
					return SLEEPING;
				}
			}
		} else if (entity.isChild()) {
			return CHILD;
		} else {
			if (entity.isAlbino()) {
				return ALBINO;
			} else if (entity.isMelanistic()) {
				return MELANISTIC;
			} else {
				return DAKOTARAPTOR;
			}
		}
	}

}
