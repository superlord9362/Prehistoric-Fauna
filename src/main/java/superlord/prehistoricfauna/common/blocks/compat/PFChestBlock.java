package superlord.prehistoricfauna.common.blocks.compat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.entity.block.compat.PFChestBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PFChestBlock extends ChestBlock implements IChestBlock {
	public final String type;

	public PFChestBlock(String type, Properties props) {
		super(props, PFBlockEntities.CHEST::get);
		this.type = type;
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return false;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new PFChestBlockEntity(pos, state);
	}

	@Override
	public String getChestType() {
		return type;
	}

	@Override
	public RenderShape getRenderShape(BlockState p_51567_) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}
}
