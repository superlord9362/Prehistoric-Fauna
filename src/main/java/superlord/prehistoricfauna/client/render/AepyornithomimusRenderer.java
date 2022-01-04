package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.AepyornithomimusModel;
import superlord.prehistoricfauna.common.entities.AepyornithomimusEntity;

@OnlyIn(Dist.CLIENT)
public class AepyornithomimusRenderer extends MobRenderer<AepyornithomimusEntity, EntityModel<AepyornithomimusEntity>> {

    private static final AepyornithomimusModel AEPYORNITHOMIMUS_MODEL = new AepyornithomimusModel();
    private static final ResourceLocation AEPYORNITHOMIMUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/albino.png");
    private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/melanistic.png");

    public AepyornithomimusRenderer() {
        super(Minecraft.getInstance().getRenderManager(), AEPYORNITHOMIMUS_MODEL, 0.5F);
    }

    protected void preRenderCallback(AepyornithomimusEntity aepyornithomimus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(aepyornithomimus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    public ResourceLocation getEntityTexture(AepyornithomimusEntity entity) {
    	if (entity.isAlbino()) {
    		return ALBINO;
    	} else if(entity.isMelanistic()) {
    		return MELANISTIC;
    	} else {
    		return AEPYORNITHOMIMUS_TEXTURE;
    	}
    }
}