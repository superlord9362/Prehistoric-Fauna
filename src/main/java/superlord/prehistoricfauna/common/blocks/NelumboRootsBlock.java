package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

public class NelumboRootsBlock extends BushBlock {
	
	public NelumboRootsBlock(Properties p_49795_) {
		super(p_49795_);
	}
	
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		if (world.getBlockState(pos.above()).getBlock() == Blocks.WATER) {
			world.setBlockAndUpdate(pos.above(), PFBlocks.NELUMBO_STEM.get().defaultBlockState());
		}
	}
	
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		return (worldIn.getBlockState(blockpos).is(Blocks.SAND) || worldIn.getBlockState(blockpos).is(Blocks.RED_SAND) || worldIn.getBlockState(blockpos).is(Blocks.GRAVEL) || worldIn.getBlockState(blockpos).is(Blocks.DIRT) || worldIn.getBlockState(blockpos).is(Blocks.COARSE_DIRT) || worldIn.getBlockState(blockpos).is(Blocks.ROOTED_DIRT) || worldIn.getBlockState(blockpos).is(Blocks.GRASS_BLOCK) || worldIn.getBlockState(blockpos).is(Blocks.MYCELIUM) || worldIn.getBlockState(blockpos).is(Blocks.PODZOL) || worldIn.getBlockState(blockpos).is(Blocks.CLAY) || worldIn.getBlockState(blockpos).is(Blocks.MUD) || worldIn.getBlockState(blockpos).is(Blocks.PACKED_MUD) || worldIn.getBlockState(blockpos).is(PFBlocks.SILT.get()) || worldIn.getBlockState(blockpos).is(PFBlocks.HARDENED_SILT.get()) || worldIn.getBlockState(blockpos).is(PFBlocks.LOAM.get()) || worldIn.getBlockState(blockpos).is(PFBlocks.PACKED_LOAM.get()) || worldIn.getBlockState(blockpos).is(PFBlocks.MOSSY_DIRT.get()));
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.isFaceSturdy(worldIn, pos, Direction.UP) && state.getBlock() != Blocks.MAGMA_BLOCK && state.getBlock() != this;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return ifluidstate.is(FluidTags.WATER) && ifluidstate.getAmount() == 8 ? super.getStateForPlacement(context) : null;
	}

	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		BlockState blockstate = super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		if (!blockstate.isAir()) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
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
	
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(PFItems.NELUMBO.get().asItem());
	}

}
