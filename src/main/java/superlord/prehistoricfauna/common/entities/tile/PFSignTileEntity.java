package superlord.prehistoricfauna.common.entities.tile;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import superlord.prehistoricfauna.init.TileEntityRegistry;

public class PFSignTileEntity extends SignTileEntity
{

	@Override
	public TileEntityType<?> getType()
	{
		return TileEntityRegistry.PF_SIGNS.get();
	}
}
