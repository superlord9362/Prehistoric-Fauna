package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityAllosaurus;
import superlord.prehistoricfauna.entity.models.ModelAllosaurus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class AllosaurusRenderer extends RenderLiving<EntityAllosaurus> {
	public static final Factory FACTORY = new Factory();

	public AllosaurusRenderer(RenderManager manager) {
		super(manager, new ModelAllosaurus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityAllosaurus entity) {
		if (entity.isChild()) {
            switch(entity.getAllosaurusSkin()) {
        	case 0:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosauruschild.png");
        	case 1:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosauruschild_melanistic.png");
        	case 2:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosauruschild_albino.png");
        	case 3:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosauruschild_melanistic.png");
        	default:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosauruschild.png");
            }
            } else {
            	switch(entity.getAllosaurusSkin()) {
            	case 0:
            		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosaurus.png");
            	case 1: 
            		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosaurus_melanistic.png");
            	case 2:
            		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosaurus_albino.png");
            	case 3:
            		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosaurus_melanistic.png");
            	default:
            		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus/allosaurus.png");
            	}
		}
	}

	public static class Factory implements IRenderFactory<EntityAllosaurus> {

        @Override
        public Render<? super EntityAllosaurus> createRenderFor(RenderManager manager) {
            return new AllosaurusRenderer(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityAllosaurus entity, float f) {
		this.shadowSize = entity.width * 0.45F;
    }
}