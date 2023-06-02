package superlord.prehistoricfauna.common.blocks.compat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.entity.block.compat.PFTrappedChestBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PFTrappedChestBlock  extends ChestBlock implements IChestBlock {
	public final String type;

	public PFTrappedChestBlock(String type, Properties props) {
		super(props, PFBlockEntities.TRAPPED_CHEST::get);
		this.type = type;
	}

	@Override
	public String getChestType() {
		return this.type;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new PFTrappedChestBlockEntity(pos, state);
	}

	@Override
	protected Stat<ResourceLocation> getOpenChestStat() {
		return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
		return Mth.clamp(ChestBlockEntity.getOpenCount(getter, pos), 0, 15);
	}

	@Override
	public int getDirectSignal(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
		return face == Direction.UP ? state.getSignal(getter, pos, face) : 0;
	}
}
