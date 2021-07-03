package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class AlgaeBlock extends Block {

	protected static final VoxelShape BLOCK = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.2D, 16.0D);
	
	public AlgaeBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return BLOCK;
	}

	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return BLOCK;
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.isSolidSide(worldIn, pos, Direction.UP) && state.getBlock() != Blocks.MAGMA_BLOCK && state.getBlock() != this;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8 ? super.getStateForPlacement(context) : null;
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		if (!blockstate.isAir()) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		return blockstate;
	}
	
	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getStillFluidState(false);
	}
	
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}

	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return false;
		}
	
}
