package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Allosaurus;
import superlord.prehistoricfauna.common.entities.AllosaurusEntity;

@OnlyIn(Dist.CLIENT)
public class AllosaurusRenderer extends MobRenderer<AllosaurusEntity, EntityModel<AllosaurusEntity>> {

    private static final Allosaurus ALLOSAURUS_MODEL = new Allosaurus();
    private static final ResourceLocation ALLOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus.png");
    private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino.png");
    private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic.png");

    public AllosaurusRenderer() {
        super(Minecraft.getInstance().getRenderManager(), ALLOSAURUS_MODEL, 1.25F);
    }

    protected void preRenderCallback(AllosaurusEntity allosaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(allosaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    public ResourceLocation getEntityTexture(AllosaurusEntity entity) {
    	if (entity.isAlbino()) {
    		return ALBINO;
    	} else if(entity.isMelanistic()) {
    		return MELANISTIC;
    	} else {
    		return ALLOSAURUS_TEXTURE;
    	}
    }
}