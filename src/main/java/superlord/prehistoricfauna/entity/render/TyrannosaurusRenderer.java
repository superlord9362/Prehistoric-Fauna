package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TyrannosaurusEntity;
import superlord.prehistoricfauna.entity.model.Tyrannosaurusrex;
import superlord.prehistoricfauna.entity.model.Tyrannosaurusrexjuvenile;

@OnlyIn(Dist.CLIENT)
public class TyrannosaurusRenderer extends MobRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> {

    private static final Tyrannosaurusrex REX_MODEL = new Tyrannosaurusrex();
	private static final Tyrannosaurusrexjuvenile CHILD_MODEL = new Tyrannosaurusrexjuvenile();
    private static final ResourceLocation BABY_TEXTURE = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/tyrannosaurusrexjuv.png");
    private static final ResourceLocation REX_TEXTURE = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/tyrannosaurusrex.png");

    public TyrannosaurusRenderer() {
        super(Minecraft.getInstance().getRenderManager(), REX_MODEL, 0.15F);
    }

    public void render(TyrannosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
    	if (entityIn.isChild()) {
            entityModel = CHILD_MODEL;
        } else {
            entityModel = REX_MODEL;
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    protected void preRenderCallback(TyrannosaurusEntity rex, MatrixStack matrixStackIn, float partialTickTime) {
    	if(rex.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    public ResourceLocation getEntityTexture(TyrannosaurusEntity entity) {
        if (entity.isChild()) {
            return BABY_TEXTURE;
        } else {
        	return REX_TEXTURE;
        }
    }

}