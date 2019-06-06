package superlord.prehistoricfauna.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import superlord.prehistoricfauna.blocks.DecoderContainer;
import superlord.prehistoricfauna.blocks.TileEntityDNAExtractor;
import superlord.prehistoricfauna.client.gui.GUIDecoder;
import superlord.prehistoricfauna.util.Reference;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_DNA_EXTRACTOR) return new DecoderContainer(player.inventory, (TileEntityDNAExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_DNA_EXTRACTOR) return new GUIDecoder(player.inventory, (TileEntityDNAExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

}
