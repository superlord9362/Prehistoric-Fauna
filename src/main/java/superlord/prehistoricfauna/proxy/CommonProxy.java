package superlord.prehistoricfauna.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {
	
    public static final int GUI_ANALYZER = 0;
    
    @Override
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
    }
    
    public void spawnPacketBlockParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ, Block block) {
    }
    
    public void spawnPacketItemParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ, Item item) {

    }
    
    public void spawnPacketHeartParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ) {

    }

	@Override
	public void init(FMLInitializationEvent event) {
		
	}
	
	 

}
