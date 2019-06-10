package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityAnkylosaurus;
import superlord.prehistoricfauna.entity.models.Ankylosaurus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAnkylosaurus extends RenderLiving<EntityAnkylosaurus> {
	public static final Factory FACTORY = new Factory();

	public RenderAnkylosaurus(RenderManager manager) {
		super(manager, new Ankylosaurus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityAnkylosaurus entity) {
		 if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_baby.png");
		} else {
			switch(entity.getAnkylosaurusSkin()) {
        	case 0:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 1:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 2:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 3:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 4:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 5:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 6:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 7:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 8:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_1.png");
        	case 9:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 10:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 11:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 12:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 13:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 14:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 15:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 16:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 17:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 18:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_2.png");
        	case 19:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 20:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 21:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 22:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 23:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 24:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 25:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 26:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 27:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 28:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_3.png");
        	case 29:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 30:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 31:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 32:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 33:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 34:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 35:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 36:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 37:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 38:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_4.png");
        	case 39:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 40:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 41:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 42:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 43:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 44:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 45:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 46:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 47:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 48:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_5.png");
        	case 49:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_albino.png");
        	case 50:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_melanistic.png");
        	case 51:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_melanistic.png");
        	default:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus.png");
			}
		}
	}

	public static class Factory implements IRenderFactory<EntityAnkylosaurus> {

        @Override
        public Render<? super EntityAnkylosaurus> createRenderFor(RenderManager manager) {
            return new RenderAnkylosaurus(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityAnkylosaurus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}