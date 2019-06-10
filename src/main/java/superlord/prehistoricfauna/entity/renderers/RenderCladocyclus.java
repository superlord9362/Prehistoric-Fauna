package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityCladocyclus;
import superlord.prehistoricfauna.entity.models.Cladocyclus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCladocyclus extends RenderLiving<EntityCladocyclus> {
	public static final Factory FACTORY = new Factory();

	public RenderCladocyclus(RenderManager manager) {
		super(manager, new Cladocyclus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCladocyclus entity) {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/cladocyclus/cladocyclus.png");
	}

	public static class Factory implements IRenderFactory<EntityCladocyclus> {

        @Override
        public Render<? super EntityCladocyclus> createRenderFor(RenderManager manager) {
            return new RenderCladocyclus(manager);
        }
    }
	
	@Override

    protected void preRenderCallback(EntityCladocyclus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}