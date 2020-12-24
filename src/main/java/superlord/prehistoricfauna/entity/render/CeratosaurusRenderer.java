package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.CeratosaurusEntity;
import superlord.prehistoricfauna.entity.model.Ceratosaurus;
import superlord.prehistoricfauna.entity.model.CeratosaurusBaby;

public class CeratosaurusRenderer extends MobRenderer<CeratosaurusEntity,  EntityModel<CeratosaurusEntity>> {

	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/ceratosaurus.png");
	private static final ResourceLocation CERATOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/ceratosaurus_baby.png");
	private static final Ceratosaurus CERATOSAURUS_MODEL = new Ceratosaurus();
	private static final CeratosaurusBaby CERATOSAUURS_BABY_MODEL = new CeratosaurusBaby();
	
	public CeratosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CERATOSAURUS_MODEL, 0.75F);
	}
	
	public void render(CeratosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
    	if (entityIn.isChild()) {
    		entityModel = CERATOSAUURS_BABY_MODEL;
    	} else {
            entityModel = CERATOSAURUS_MODEL;
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	 protected void preRenderCallback(CeratosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	@Override
	public ResourceLocation getEntityTexture(CeratosaurusEntity entity) {
		if (entity.isChild()) {
			return CERATOSAURUS_BABY;
		} else {
			return CERATOSAURUS;
		}
	}
	
}
