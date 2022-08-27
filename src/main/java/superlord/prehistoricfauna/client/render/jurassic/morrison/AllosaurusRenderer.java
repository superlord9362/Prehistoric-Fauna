package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;

@OnlyIn(Dist.CLIENT)
public class AllosaurusRenderer extends MobRenderer<AllosaurusEntity, EntityModel<AllosaurusEntity>> {

    private static final AllosaurusModel ALLOSAURUS_MODEL = new AllosaurusModel();
    private static final AllosaurusSleepingModel ALLOSAURUS_SLEEPING_MODEL = new AllosaurusSleepingModel();
    private static final ResourceLocation ALLOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino.png");
    private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic.png");
    private static final ResourceLocation ALLOSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus_sleeping.png");
    private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino_sleeping.png");
    private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic_sleeping.png");

    public AllosaurusRenderer() {
        super(Minecraft.getInstance().getRenderManager(), ALLOSAURUS_MODEL, 1.25F);
    }

    protected void preRenderCallback(AllosaurusEntity allosaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(allosaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }
    
    public void render(AllosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = ALLOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = ALLOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

    public ResourceLocation getEntityTexture(AllosaurusEntity entity) {
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
				return ALLOSAURUS_SLEEPING_TEXTURE;
			} else {
				return ALLOSAURUS_TEXTURE;
			}
		}
    }
}