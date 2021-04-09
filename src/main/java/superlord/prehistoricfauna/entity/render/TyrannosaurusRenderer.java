package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TyrannosaurusEntity;
import superlord.prehistoricfauna.entity.model.Tyrannosaurusrex;
import superlord.prehistoricfauna.entity.model.Tyrannosaurusrexjuvenile;

public class TyrannosaurusRenderer extends MobRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> {
	
	private static final ResourceLocation TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/tyrannosaurusrex.png");
	private static final ResourceLocation BABY_TYRANNOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/tyrannosaurusrexjuv.png");
	private static final Tyrannosaurusrex TYRANNOSAURUS_MODEL = new Tyrannosaurusrex();
	private static final Tyrannosaurusrexjuvenile BABY_TYRANNOSAURUS_MODEL = new Tyrannosaurusrexjuvenile();
	
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
	
	protected void preRenderCallback(TyrannosaurusEntity tyrannosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(tyrannosaurus.getGrowingAge() < -12000) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(TyrannosaurusEntity entity) {
		if(entity.isChild()) {
			return BABY_TYRANNOSAURUS;
		} else {
	        return TYRANNOSAURUS;
		}
	}

}
