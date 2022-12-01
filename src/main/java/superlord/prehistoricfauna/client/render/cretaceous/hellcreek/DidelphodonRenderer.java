package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DidelphodonModel;
import superlord.prehistoricfauna.client.render.layer.DidelphodonEyeLayer;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DidelphodonRenderer extends MobRenderer<DidelphodonEntity, EntityModel<DidelphodonEntity>> {

	private static final ResourceLocation DIDELPHODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/didelphodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/melanistic.png");
	private static final ResourceLocation DIDELPHODON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/didelphodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/didelphodon/melanistic_sleeping.png");
	private static final DidelphodonModel DIDELPHODON_MODEL = new DidelphodonModel();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DidelphodonRenderer(EntityRendererManager rm) {
		super(rm, DIDELPHODON_MODEL, 0.25F);
		this.addLayer(new HeldItemLayer(this));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DidelphodonEyeLayer(this));
		}
	}

	protected void preRenderCallback(DidelphodonEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(DidelphodonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = DIDELPHODON_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(DidelphodonEntity entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return DIDELPHODON_SLEEPING;
			} else return DIDELPHODON;
		}
	}

}
