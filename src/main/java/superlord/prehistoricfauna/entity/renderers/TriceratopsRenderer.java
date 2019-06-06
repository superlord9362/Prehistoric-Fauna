package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityDryosaurus;
import superlord.prehistoricfauna.entity.EntityTriceratops;
import superlord.prehistoricfauna.entity.models.Triceratops;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TriceratopsRenderer extends RenderLiving<EntityTriceratops> {
    public static final Factory FACTORY = new Factory();

    public TriceratopsRenderer(RenderManager manager) {
        super(manager, new Triceratops(), 0.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTriceratops entity) {
        // TODO you can now select your texture based on the modelType
        if (entity.isChild()) {
        	if (entity.isAlbino) {
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild_albino.png");
        	} else if (entity.isMelanistic) {
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild_melanistic.png");
        	} else {
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild.png");
        	}
        } else {
        	if (entity.isAlbino) {
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops_albino.png");
        	} else if (entity.isMelanistic) {
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops_melanistic.png");
        	} else {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops.png");
        	}
        }
    }

    public static class Factory implements IRenderFactory<EntityTriceratops> {
        @Override
        public Render<? super EntityTriceratops> createRenderFor(RenderManager manager) {
            return new TriceratopsRenderer(manager);
        }
    }
    
    @Override
    protected void preRenderCallback(EntityTriceratops entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}