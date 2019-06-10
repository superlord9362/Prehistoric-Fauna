package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityVelociraptor;
import superlord.prehistoricfauna.entity.models.Velociraptor;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class VelociraptorRenderer extends RenderLiving<EntityVelociraptor> {
    public static final Factory FACTORY = new Factory();

    public VelociraptorRenderer(RenderManager manager) {
        super(manager, new Velociraptor(), 0.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVelociraptor entity) {
        if (entity.isChild()) {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/velociraptor/velociraptorchild.png");
        } else {
        	switch(entity.getVelociraptorSkin()) {
			case 0:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/velociraptor/velociraptormale_albino.png");
			case 1:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/velociraptor/velociraptormale_melanistic.png");
			case 2:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/velociraptor/velociraptormale_melanistic.png");
			default:
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/velociraptor/velociraptormale.png");
			} 
        }
    }

    public static class Factory implements IRenderFactory<EntityVelociraptor> {
        @Override
        public Render<? super EntityVelociraptor> createRenderFor(RenderManager manager) {
            return new VelociraptorRenderer(manager);
        }
    }
    
    @Override
    protected void preRenderCallback(EntityVelociraptor entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}