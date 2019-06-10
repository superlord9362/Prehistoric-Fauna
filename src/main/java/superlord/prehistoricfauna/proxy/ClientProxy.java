package superlord.prehistoricfauna.proxy;

import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.entity.EntityAllosaurus;
import superlord.prehistoricfauna.entity.EntityAnkylosaurus;
import superlord.prehistoricfauna.entity.EntityBaryonyx;
import superlord.prehistoricfauna.entity.EntityCamarasaurus;
import superlord.prehistoricfauna.entity.EntityCladocyclus;
import superlord.prehistoricfauna.entity.EntityDinosaurEgg;
import superlord.prehistoricfauna.entity.EntityDryosaurus;
import superlord.prehistoricfauna.entity.EntityEusthenopteron;
import superlord.prehistoricfauna.entity.EntityGallimimus;
import superlord.prehistoricfauna.entity.EntityParadoxides;
import superlord.prehistoricfauna.entity.EntityParasaurolophus;
import superlord.prehistoricfauna.entity.EntityPrenocephale;
import superlord.prehistoricfauna.entity.EntityStegosaurus;
import superlord.prehistoricfauna.entity.EntityTriceratops;
import superlord.prehistoricfauna.entity.EntityTyrannosaurus;
import superlord.prehistoricfauna.entity.EntityVelociraptor;
import superlord.prehistoricfauna.entity.renderers.AllosaurusRenderer;
import superlord.prehistoricfauna.entity.renderers.CamarasaurusRenderer;
import superlord.prehistoricfauna.entity.renderers.GallimimusRenderer;
import superlord.prehistoricfauna.entity.renderers.RenderAnkylosaurus;
import superlord.prehistoricfauna.entity.renderers.RenderBaryonyx;
import superlord.prehistoricfauna.entity.renderers.RenderCladocyclus;
import superlord.prehistoricfauna.entity.renderers.RenderDinoEgg;
import superlord.prehistoricfauna.entity.renderers.RenderEusthenopteron;
import superlord.prehistoricfauna.entity.renderers.RenderExtinct;
import superlord.prehistoricfauna.entity.renderers.RenderParadoxides;
import superlord.prehistoricfauna.entity.renderers.RenderParasaurolophus;
import superlord.prehistoricfauna.entity.renderers.RenderPrenocephale;
import superlord.prehistoricfauna.entity.renderers.RenderStegosaurus;
import superlord.prehistoricfauna.entity.renderers.TriceratopsRenderer;
import superlord.prehistoricfauna.entity.renderers.TyrannosaurusRenderer;
import superlord.prehistoricfauna.entity.renderers.VelociraptorRenderer;
import superlord.prehistoricfauna.util.handlers.GUIHandler;
import superlord.prehistoricfauna.world.gen.ModWorldGen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, TriceratopsRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, VelociraptorRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGallimimus.class, GallimimusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, TyrannosaurusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCamarasaurus.class, CamarasaurusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, RenderStegosaurus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityAllosaurus.class, AllosaurusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDryosaurus.class, RenderExtinct.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityAnkylosaurus.class, RenderAnkylosaurus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityPrenocephale.class, RenderPrenocephale.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityParasaurolophus.class, RenderParasaurolophus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBaryonyx.class, RenderBaryonyx.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDinosaurEgg.class, RenderDinoEgg::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityParadoxides.class, RenderParadoxides.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityEusthenopteron.class, RenderEusthenopteron.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCladocyclus.class, RenderCladocyclus.FACTORY);
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    }

    @Override
    public void init(FMLInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GUIHandler());
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

}
