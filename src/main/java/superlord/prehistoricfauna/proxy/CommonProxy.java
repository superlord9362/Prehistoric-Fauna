package superlord.prehistoricfauna.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.blocks.DecoderContainer;
import superlord.prehistoricfauna.blocks.TileEntityDNAExtractor;

public class CommonProxy implements IProxy, IGuiHandler {
	
    public static final int GUI_ANALYZER = 0;
    
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, this);
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
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);

        TileEntity entity = world.getTileEntity(pos);

        if (ID == GUI_ANALYZER && entity instanceof TileEntityDNAExtractor) {

            return new DecoderContainer(player.inventory, (TileEntityDNAExtractor) entity);

        }
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
