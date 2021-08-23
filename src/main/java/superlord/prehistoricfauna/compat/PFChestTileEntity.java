package superlord.prehistoricfauna.compat;

import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import superlord.prehistoricfauna.init.PFTileEntities;

public class PFChestTileEntity extends ChestTileEntity {

	protected PFChestTileEntity(TileEntityType<?> type) {
		super(type);
	}
	
	public PFChestTileEntity() {
		super(PFTileEntities.CHEST.get());
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
	}
	
}
