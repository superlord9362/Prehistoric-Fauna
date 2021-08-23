package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.TyrannosaurusrexModel;
import superlord.prehistoricfauna.client.model.TyrannosaurusrexjuvenileModel;
import superlord.prehistoricfauna.common.entities.TyrannosaurusEntity;

public class TyrannosaurusRenderer extends MobRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> {
	
	private static final ResourceLocation TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrex.png");
	private static final ResourceLocation BABY_TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrexjuv.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino.png");
	private static final ResourceLocation BABY_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/albino_juv.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic.png");
	private static final ResourceLocation BABY_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/melanistic_juv.png");
	private static final TyrannosaurusrexModel TYRANNOSAURUS_MODEL = new TyrannosaurusrexModel();
	private static final TyrannosaurusrexjuvenileModel BABY_TYRANNOSAURUS_MODEL = new TyrannosaurusrexjuvenileModel();
	
	public TyrannosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TYRANNOSAURUS_MODEL, 2F);
	}
	
	public void render(TyrannosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			entityModel = BABY_TYRANNOSAURUS_MODEL;
		} else {
			entityModel = TYRANNOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(TyrannosaurusEntity triceratops, MatrixStack matrixStackIn, float partialTickTime) {
		if(triceratops.isChild() && !triceratops.isJuvenile()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(TyrannosaurusEntity entity) {
		if (entity.isAlbino() && !entity.isChild()) {
			return ALBINO;
		} else if (entity.isAlbino() && entity.isChild()) {
			return BABY_ALBINO;
		} else if (entity.isMelanistic() && !entity.isChild()) {
			return MELANISTIC;
		} else if (entity.isMelanistic() && entity.isChild()) {
			return BABY_MELANISTIC;
		} else if(entity.isChild()) {
			return BABY_TYRANNOSAURUS;
		} else {
	        return TYRANNOSAURUS;
		}
	}

}
