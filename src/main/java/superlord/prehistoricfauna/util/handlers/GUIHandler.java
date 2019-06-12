package superlord.prehistoricfauna.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import superlord.prehistoricfauna.blocks.ContainerCultureVat;
import superlord.prehistoricfauna.blocks.Container_DNAExtractor;
import superlord.prehistoricfauna.blocks.TileEntityCultureVat;
import superlord.prehistoricfauna.blocks.TileEntityDNAExtractor;
import superlord.prehistoricfauna.client.gui.GUICultivate;
import superlord.prehistoricfauna.client.gui.GUI_DNAExtractor;
import superlord.prehistoricfauna.util.Reference;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_DNA_EXTRACTOR) return new Container_DNAExtractor(player.inventory, (TileEntityDNAExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		if (ID == Reference.GUI_CULTIVATE) return new ContainerCultureVat(player.inventory, (TileEntityCultureVat)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
        if (ID == Reference.GUI_DNA_EXTRACTOR) return new GUI_DNAExtractor(player.inventory, (TileEntityDNAExtractor)world.getTileEntity(new BlockPos(x,y,z)));
        if (ID == Reference.GUI_CULTIVATE)	return new GUICultivate((TileEntityCultureVat) entity, new ContainerCultureVat(player.inventory, (TileEntityCultureVat) entity));

		return null;
	}

}
