package superlord.prehistoricfauna.common.entity.block.compat;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PFTrappedChestBlockEntity extends PFChestBlockEntity {

	public PFTrappedChestBlockEntity(BlockPos pos, BlockState state) {
		super(PFBlockEntities.TRAPPED_CHEST.get(), pos, state);
	}

	@Override
	protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int oldOpenCount, int openCount) {
		super.signalOpenCount(level, pos, state, oldOpenCount, openCount);
		if (oldOpenCount != openCount) {
			Block block = state.getBlock();
			level.updateNeighborsAt(pos, block);
			level.updateNeighborsAt(pos.below(), block);
		}
	}
}
