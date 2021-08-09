package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Saurosuchus;
import superlord.prehistoricfauna.client.model.SaurosuchusSleeping;
import superlord.prehistoricfauna.common.entities.SaurosuchusEntity;

public class SaurosuchusRenderer extends MobRenderer<SaurosuchusEntity, EntityModel<SaurosuchusEntity>> {

	private static final ResourceLocation SAUROSUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic_sleeping.png");
	private static final Saurosuchus SAUROSUCHUS_MODEL = new Saurosuchus();
	private static final SaurosuchusSleeping SAUROSUCHUS_SLEEPING_MODEL = new SaurosuchusSleeping();
	
	public SaurosuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SAUROSUCHUS_MODEL, 0.75F);
	}
	
	 protected void preRenderCallback(SaurosuchusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	public void render(SaurosuchusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
    	if (entityIn.isSleeping()) {
    		entityModel = SAUROSUCHUS_SLEEPING_MODEL;
    	} else {
            entityModel = SAUROSUCHUS_MODEL;
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(SaurosuchusEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isAlbino() && entity.isSleeping()) {
			return ALBINO_SLEEPING;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else if (entity.isMelanistic() && entity.isSleeping()) {
			return MELANISTIC_SLEEPING;
		} else if(entity.isSleeping() && !entity.isMelanistic() && !entity.isAlbino()) {
			return SLEEPING;
		} else {
			return SAUROSUCHUS;
		}
	}

	
}
