package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityStegosaurus;
import superlord.prehistoricfauna.entity.models.Stegosaurus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStegosaurus extends RenderLiving<EntityStegosaurus> {
	public static final Factory FACTORY = new Factory();

	public RenderStegosaurus(RenderManager manager) {
		super(manager, new Stegosaurus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityStegosaurus entity) {
		if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/stegosaurus/stegosauruschild.png");
		} else {
			switch(entity.getStegosaurusSkin()) {
			case 0:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/stegosaurus/stegosaurus_albino.png");
			case 1:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/stegosaurus/stegosaurus_melanistic.png");
			case 2:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/stegosaurus/stegosaurus_melanistic.png");
			default:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/stegosaurus/stegosaurus.png");
			}
		}
	}

	public static class Factory implements IRenderFactory<EntityStegosaurus> {

        @Override
        public Render<? super EntityStegosaurus> createRenderFor(RenderManager manager) {
            return new RenderStegosaurus(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityStegosaurus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}