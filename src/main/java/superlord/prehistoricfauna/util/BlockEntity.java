package superlord.prehistoricfauna.util;

import net.minecraft.tileentity.TileEntity;

public interface BlockEntity {
		Class<? extends TileEntity> getEntity();
	
}
