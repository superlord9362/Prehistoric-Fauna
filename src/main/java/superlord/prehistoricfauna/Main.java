package superlord.prehistoricfauna;

import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.proxy.CommonProxy;
import superlord.prehistoricfauna.proxy.IProxy;
import superlord.prehistoricfauna.util.ReleaseType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static superlord.prehistoricfauna.util.Reference.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION)
public class Main {

    @Instance
    public static Main instance;
    
    public static SimpleNetworkWrapper NETWORK_WRAPPER;
    public static CommonProxy PROXY;
	public static final ReleaseType RELEASE_TYPE = ReleaseType.parseVersion(VERSION);
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static IProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
    	proxy.init(event);
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }

    
}
