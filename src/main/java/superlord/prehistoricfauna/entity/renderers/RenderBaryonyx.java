package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityBaryonyx;
import superlord.prehistoricfauna.entity.models.Baryonyxv2;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBaryonyx extends RenderLiving<EntityBaryonyx> {
	public static final Factory FACTORY = new Factory();

	public RenderBaryonyx(RenderManager manager) {
		super(manager, new Baryonyxv2(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBaryonyx entity) {
		switch(entity.getBaryonyxSkin()) {
    	case 0:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 1:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 2:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 3:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 4:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 5:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 6:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 7:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 8:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 9:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_1.png");
    	case 10:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 11:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 12:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 13:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 14:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 15:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 16:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 17:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 18:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 19:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_2.png");
    	case 20:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 21:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 22:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 23:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 24:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 25:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 26:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 27:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 28:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 29:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_3.png");
    	case 40:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_albino.png");
    	case 41:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_melanistic.png");
    	case 42:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx_melanistic.png");
    	default:
    		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx/baryonyx.png");
		}
	}

	public static class Factory implements IRenderFactory<EntityBaryonyx> {

        @Override
        public Render<? super EntityBaryonyx> createRenderFor(RenderManager manager) {
            return new RenderBaryonyx(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityBaryonyx entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}