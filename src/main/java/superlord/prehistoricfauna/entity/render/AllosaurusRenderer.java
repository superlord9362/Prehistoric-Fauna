package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AllosaurusEntity;
import superlord.prehistoricfauna.entity.model.Allosaurus;

@OnlyIn(Dist.CLIENT)
public class AllosaurusRenderer extends MobRenderer<AllosaurusEntity, EntityModel<AllosaurusEntity>> {

    private static final Allosaurus ALLOSAURUS_MODEL = new Allosaurus();
    private static final ResourceLocation ALLOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/allosaurus.png");

    public AllosaurusRenderer() {
        super(Minecraft.getInstance().getRenderManager(), ALLOSAURUS_MODEL, 1.25F);
    }

    protected void preRenderCallback(AllosaurusEntity allosaurus, MatrixStack matrixStackIn, float partialTickTime) {
    	if(allosaurus.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    public ResourceLocation getEntityTexture(AllosaurusEntity entity) {
    	return ALLOSAURUS_TEXTURE;
    }
}