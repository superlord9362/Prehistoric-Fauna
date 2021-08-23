package superlord.prehistoricfauna.compat;

import javax.annotation.Nonnull;

import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntityType;
import superlord.prehistoricfauna.init.PFTileEntities;

public class PFBeehiveTileEntity extends BeehiveTileEntity {
	
	public PFBeehiveTileEntity() {
		super();
	}

	@Nonnull
	@Override
	public TileEntityType<?> getType() {
		return PFTileEntities.BEEHIVE.get();
	}
}
