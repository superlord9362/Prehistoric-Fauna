package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.DakotaraptorEntity;
import superlord.prehistoricfauna.entity.model.Dakotaraptor;
import superlord.prehistoricfauna.entity.model.DakotaraptorCrouching;
import superlord.prehistoricfauna.entity.model.DakotaraptorSitting;
import superlord.prehistoricfauna.entity.model.DakotaraptorSleeping;

public class DakotaraptorRenderer extends MobRenderer<DakotaraptorEntity, EntityModel<DakotaraptorEntity>> {

	private static final ResourceLocation DAKOTARAPTOR = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/dakotaraptor.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/dakotaraptor_sleeping.png");
	private static final ResourceLocation CHILD_SLEEPING = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/dakotaraptor_child_sleeping.png");
	private static final ResourceLocation CHILD = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/dakotaraptor_child.png");
	private static final Dakotaraptor DAKOTARAPTOR_MODEL = new Dakotaraptor();
	private static final DakotaraptorSitting DAKOTARAPTOR_SITTING_MODEL = new DakotaraptorSitting();
	private static final DakotaraptorSleeping DAKOTARAPTOR_SLEEPING_MODEL = new DakotaraptorSleeping();
	private static final DakotaraptorCrouching DAKOTARAPTOR_CROUCHING_MODEL = new DakotaraptorCrouching();
	
	public DakotaraptorRenderer() {
		super(Minecraft.getInstance().getRenderManager(), DAKOTARAPTOR_MODEL, 0.875F);
	}
	
	 protected void preRenderCallback(DakotaraptorEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	public void render(DakotaraptorEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
    	if (entityIn.isSleeping()) {
    		entityModel = DAKOTARAPTOR_SLEEPING_MODEL;
    	} else if (entityIn.isCrouching() && !entityIn.isDakotaraptorPouncing()) {
    		entityModel = DAKOTARAPTOR_CROUCHING_MODEL;
    	} else if (entityIn.isSitting()) {
            entityModel = DAKOTARAPTOR_SITTING_MODEL;
        } else {
            entityModel = DAKOTARAPTOR_MODEL;
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(DakotaraptorEntity entity) {
		if(entity.isSleeping()) {
			return SLEEPING;
		} else if(entity.isChild() && entity.isSleeping()) {
			return CHILD_SLEEPING;
		} else if (entity.isChild()) {
			return CHILD;
		}else {
			return DAKOTARAPTOR;
		}
	}

	
}
