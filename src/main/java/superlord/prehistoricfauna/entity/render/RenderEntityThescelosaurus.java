package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.EntityThescelosaurus;
import superlord.prehistoricfauna.entity.model.ThescelosaurusModel;

@OnlyIn(Dist.CLIENT)
public class RenderEntityThescelosaurus extends MobRenderer<EntityThescelosaurus, ThescelosaurusModel> {

    private static final ResourceLocation THESCELOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/thescelosaurus.png");

    public RenderEntityThescelosaurus(EntityRendererManager rm) {
        super(rm, new ThescelosaurusModel(), 0.4f);
    }
    
    @SuppressWarnings("deprecation")
	protected void preRenderCallback(EntityThescelosaurus entitylivingbaseIn, float partialTickTime) {
        GlStateManager.translated(0.0, 0, 0);
    }

    @Override
	public ResourceLocation getEntityTexture(EntityThescelosaurus entity) {
        return THESCELOSAURUS;
    }
}