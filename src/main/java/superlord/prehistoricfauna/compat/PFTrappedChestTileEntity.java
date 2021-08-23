package superlord.prehistoricfauna.compat;

import superlord.prehistoricfauna.init.PFTileEntities;

public class PFTrappedChestTileEntity extends PFChestTileEntity {
	public PFTrappedChestTileEntity() {
		super(PFTileEntities.TRAPPED_CHEST.get());
	}

	protected void onOpenOrClose() {
		super.onOpenOrClose();
		this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockState().getBlock());
	}
}