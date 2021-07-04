package superlord.prehistoricfauna.common.entities.tile;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import superlord.prehistoricfauna.init.PFTileEntities;

public class PFSignTileEntity extends SignTileEntity
{

	@Override
	public TileEntityType<?> getType()
	{
		return PFTileEntities.PF_SIGNS.get();
	}
}
