package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.TelmasaurusModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;

@OnlyIn(Dist.CLIENT)
public class TelmasaurusRenderer extends MobRenderer<TelmasaurusEntity, EntityModel<TelmasaurusEntity>> {

	private static final TelmasaurusModel TELMSAURUS_MODEL = new TelmasaurusModel();
	private static final ResourceLocation TELMASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/telmasaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/melanistic.png");
	private static final ResourceLocation TELMASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/telmasaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/telmasaurus/melanistic_sleeping.png");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelmasaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TELMSAURUS_MODEL, 0.25F);
		this.addLayer(new HeldItemLayer(this));
	}

	protected void preRenderCallback(TelmasaurusEntity telmasaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(telmasaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(TelmasaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = TELMSAURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public ResourceLocation getEntityTexture(TelmasaurusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return TELMASAURUS_SLEEPING;
			} else return TELMASAURUS;
		}
	}
}