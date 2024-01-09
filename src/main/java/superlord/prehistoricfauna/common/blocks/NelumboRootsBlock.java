package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import superlord.prehistoricfauna.init.PFBlocks;

public class NelumboRootsBlock extends Block {
	
	public NelumboRootsBlock(Properties p_49795_) {
		super(p_49795_);
	}
	
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if (world.getBlockState(pos.above()).getBlock() == Blocks.WATER) {
			world.setBlockAndUpdate(pos.above(), PFBlocks.NELUMBO_STEM.get().defaultBlockState());
		}
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.isFaceSturdy(worldIn, pos, Direction.UP) && state.getBlock() != Blocks.MAGMA_BLOCK && state.getBlock() != this;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return ifluidstate.is(FluidTags.WATER) && ifluidstate.getAmount() == 8 ? super.getStateForPlacement(context) : null;
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		BlockState blockstate = super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		if (!blockstate.isAir()) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return blockstate;
	}

	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getSource(false);
	}

	public boolean canPlaceLiquid(BlockGetter p_154505_, BlockPos p_154506_, BlockState p_154507_, Fluid p_154508_) {
		return false;
	}

	public boolean placeLiquid(LevelAccessor p_154520_, BlockPos p_154521_, BlockState p_154522_, FluidState p_154523_) {
		return false;
	}

}
