package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

@OnlyIn(Dist.CLIENT)
public class SarahsaurusRenderer extends MobRenderer<SarahsaurusEntity, EntityModel<SarahsaurusEntity>> {

    private static final SarahsaurusModel SARAHSAURUS_MODEL = new SarahsaurusModel();
    private static final SarahsaurusSleepingModel SARAHSAURUS_SLEEPING_MODEL = new SarahsaurusSleepingModel();
    private static final ResourceLocation SARAHSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/albino.png");
    private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/melanistic.png");
    private static final ResourceLocation SARAHSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_sleeping.png");
    private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/albino_sleeping.png");
    private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/melanistic_sleeping.png");

    public SarahsaurusRenderer() {
        super(Minecraft.getInstance().getRenderManager(), SARAHSAURUS_MODEL, 1F);
    }

    protected void preRenderCallback(SarahsaurusEntity sarahsaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(sarahsaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }
    
    public void render(SarahsaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = SARAHSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = SARAHSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

    public ResourceLocation getEntityTexture(SarahsaurusEntity entity) {
    	if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep()) {
				return SARAHSAURUS_SLEEPING_TEXTURE;
			} else {
				return SARAHSAURUS_TEXTURE;
			}
		}
    }
}