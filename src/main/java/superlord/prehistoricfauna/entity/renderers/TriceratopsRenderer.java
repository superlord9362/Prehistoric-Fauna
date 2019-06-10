package superlord.prehistoricfauna.entity.renderers;

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
            switch(entity.getTriceratopsSkin()) {
        	case 0:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratopschild.png");
        	case 1:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratopschild.png");
        	case 2:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratopschild_albino.png");
        	case 3:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratopschild_melanistic.png");
        	default:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratopschild.png");
            }
        } else {
        	switch(entity.getTriceratopsSkin()) {
        	case 0:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 1:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 2:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_albino.png");
        	case 3:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_melanistic.png");
        	case 4:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 5:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 6:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 7:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 8:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 9:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 10:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 11:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_1.png");
        	case 12:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 13:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 14:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 15:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 16:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 17:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 18:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 19:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 20:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 21:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_2.png");
        	case 22:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 23:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 24:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 25:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 26:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 27:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 28:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 29:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 30:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 31:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_3.png");
        	case 32:
            	return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 33:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 34:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 35:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 36:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 37:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 38:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 39:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 40:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 41:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_4.png");
            case 42:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 43:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 44:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 45:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 46:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 47:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 48:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 49:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 50:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
            case 51:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_5.png");
        	case 52:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_melanistic.png");
            case 53:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 54:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 55:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 56:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 57:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 58:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 59:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 60:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 61:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 62:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_6.png");
            case 63:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 64:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 65:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 66:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 67:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 68:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 69:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 70:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 71:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 72:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_7.png");
            case 73:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 74:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 75:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 76:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 77:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 78:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 79:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 80:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 81:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
            case 82:
                return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops_8.png");
        	default:
        		return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops/triceratops.png");
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