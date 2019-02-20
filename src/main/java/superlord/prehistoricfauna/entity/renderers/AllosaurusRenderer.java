package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityAllosaurus;
import superlord.prehistoricfauna.entity.EntityCamarasaurus;
import superlord.prehistoricfauna.entity.EntityGallimimus;
import superlord.prehistoricfauna.entity.EntityTriceratops;
import superlord.prehistoricfauna.entity.models.Gallimimus;
import superlord.prehistoricfauna.entity.models.ModelAllosaurus;
import superlord.prehistoricfauna.entity.models.Triceratops;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.Minecraft;
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
		if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosauruschild.png");
		} else {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/allosaurus.png");
		}
	}

	public static class Factory implements IRenderFactory<EntityAllosaurus> {

        @Override
        public Render<? super EntityAllosaurus> createRenderFor(RenderManager manager) {
            return new AllosaurusRenderer(manager);
        }
    }
}