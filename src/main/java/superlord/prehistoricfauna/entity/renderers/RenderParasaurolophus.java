package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityParasaurolophus;
import superlord.prehistoricfauna.entity.models.Parasaurolophus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderParasaurolophus extends RenderLiving<EntityParasaurolophus> {
	public static final Factory FACTORY = new Factory();

	public RenderParasaurolophus(RenderManager manager) {
		super(manager, new Parasaurolophus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityParasaurolophus entity) {
		if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/parasaurolophus_baby.png");
		} else {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/parasaurolophus.png");
		}
	}

	public static class Factory implements IRenderFactory<EntityParasaurolophus> {

        @Override
        public Render<? super EntityParasaurolophus> createRenderFor(RenderManager manager) {
            return new RenderParasaurolophus(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityParasaurolophus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}