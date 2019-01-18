package com.superlord.prehistoricfauna.proxy;

import com.superlord.prehistoricfauna.entity.EntityCamarasaurus;
import com.superlord.prehistoricfauna.entity.EntityDryosaurus;
import com.superlord.prehistoricfauna.entity.EntityGallimimus;
import com.superlord.prehistoricfauna.entity.EntityStegosaurus;
import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.EntityTyrannosaurus;
import com.superlord.prehistoricfauna.entity.EntityVelociraptor;
import com.superlord.prehistoricfauna.entity.renderers.CamarasaurusRenderer;
import com.superlord.prehistoricfauna.entity.renderers.DryosaurusRenderer;
import com.superlord.prehistoricfauna.entity.renderers.GallimimusRenderer;
import com.superlord.prehistoricfauna.entity.renderers.RenderStegosaurus;
import com.superlord.prehistoricfauna.entity.renderers.TriceratopsRenderer;
import com.superlord.prehistoricfauna.entity.renderers.TyrannosaurusRenderer;
import com.superlord.prehistoricfauna.entity.renderers.VelociraptorRenderer;
import com.superlord.prehistoricfauna.world.gen.ModWorldGen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, TriceratopsRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, VelociraptorRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGallimimus.class, GallimimusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, TyrannosaurusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCamarasaurus.class, CamarasaurusRenderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, RenderStegosaurus.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDryosaurus.class, DryosaurusRenderer.FACTORY);
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
