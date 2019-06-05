package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityDryosaurus;
import superlord.prehistoricfauna.entity.EntityTyrannosaurus;
import superlord.prehistoricfauna.entity.models.Tyrannosaurus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TyrannosaurusRenderer extends RenderLiving<EntityTyrannosaurus> {
    public static final Factory FACTORY = new Factory();

    public TyrannosaurusRenderer(RenderManager manager) {
        super(manager, new Tyrannosaurus(), 0.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTyrannosaurus entity) {
        if (entity.isChild()) {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/tyrannosaurusj.png");
        } else {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/tyrannosaurusa.png");
        }
    }

    public static class Factory implements IRenderFactory<EntityTyrannosaurus> {
        @Override
        public Render<? super EntityTyrannosaurus> createRenderFor(RenderManager manager) {
            return new TyrannosaurusRenderer(manager);
        }
    }
    
    @Override
    protected void preRenderCallback(EntityTyrannosaurus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}