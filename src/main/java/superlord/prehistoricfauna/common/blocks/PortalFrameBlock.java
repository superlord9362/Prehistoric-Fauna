package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import superlord.prehistoricfauna.init.PFBlocks;

public class PortalFrameBlock extends Block {

	public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");

	public PortalFrameBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVATED, Boolean.valueOf(false)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ACTIVATED);
	}
	
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean hasPortal = false;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				for (int z = -1; z <= 1; z++) {
					BlockPos checkPos = context.getClickedPos().offset(x, y, z);
					BlockState checkState = context.getLevel().getBlockState(checkPos);
					if (checkState.is(PFBlocks.CRETACEOUS_PORTAL.get()) || checkState.is(PFBlocks.JURASSIC_PORTAL.get()) || checkState.is(PFBlocks.TRIASSIC_PORTAL.get())) {
						hasPortal = true;
						break;
					}
					if (hasPortal) break;
				}
				if (hasPortal) break;
			}
			if (hasPortal) break;
		}
		return this.defaultBlockState().setValue(ACTIVATED, hasPortal);
	}

	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos1, boolean b_1) {
		boolean hasPortal = false;
		if (!level.isClientSide()) {
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					for (int z = -1; z <= 1; z++) {
						BlockPos checkPos = pos.offset(x, y, z);
						BlockState checkState = level.getBlockState(checkPos);
						if (checkState.is(PFBlocks.CRETACEOUS_PORTAL.get()) || checkState.is(PFBlocks.JURASSIC_PORTAL.get()) || checkState.is(PFBlocks.TRIASSIC_PORTAL.get())) {
							hasPortal = true;
							break;
						}
						if (hasPortal) break;
					}
					if (hasPortal) break;
				}
				if (hasPortal) break;
			}
			if (!hasPortal) {
	            level.setBlockAndUpdate(pos, state.setValue(ACTIVATED, false));
	        } else {
	            level.setBlockAndUpdate(pos, state.setValue(ACTIVATED, true));
	        }
		}
	}

}
