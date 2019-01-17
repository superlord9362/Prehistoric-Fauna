package com.superlord.prehistoricfauna;

import com.superlord.prehistoricfauna.init.ModItems;
import com.superlord.prehistoricfauna.proxy.IProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.superlord.prehistoricfauna.util.Reference.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION, acceptedMinecraftVersions = MC_ACCEPT, dependencies = DEPENDENCY)
public class Main {

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static IProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }

    public static CreativeTabs tabPrehistoric = new CreativeTabs("tab_prehistoric") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.VELOCIRAPTOR_CLAW);
        }
    };
}
