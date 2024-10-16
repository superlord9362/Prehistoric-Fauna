package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import superlord.prehistoricfauna.init.PFBlocks;

public class ArchaefructusBlock extends BushBlock implements BonemealableBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public ArchaefructusBlock(Properties p_51021_) {
		super(p_51021_);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(true)));
	}

	protected boolean mayPlaceOn(BlockState p_154539_, BlockGetter p_154540_, BlockPos p_154541_) {
		return p_154539_.isFaceSturdy(p_154540_, p_154541_, Direction.UP) && !p_154539_.is(Blocks.MAGMA_BLOCK) && (p_154540_.getBlockState(p_154541_.above()).isAir() || p_154540_.getBlockState(p_154541_.above(2)).isAir() && p_154540_.getBlockState(p_154541_.above()).is(Blocks.WATER));
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_154503_) {
		FluidState fluidstate = p_154503_.getLevel().getFluidState(p_154503_.getClickedPos());
		return fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8 ? super.getStateForPlacement(p_154503_) : null;
	}

	public FluidState getFluidState(BlockState p_154537_) {
		return Fluids.WATER.getSource(false);
	}

	public boolean canSurvive(BlockState p_56109_, LevelReader p_56110_, BlockPos p_56111_) {
		BlockPos blockpos = p_56111_.below();
		return this.mayPlaceOn(p_56110_.getBlockState(blockpos), p_56110_, blockpos);
	}

	public boolean isValidBonemealTarget(LevelReader p_154510_, BlockPos p_154511_, BlockState p_154512_, boolean p_154513_) {
		return true;
	}

	public boolean isBonemealSuccess(Level p_154515_, RandomSource p_154516_, BlockPos p_154517_, BlockState p_154518_) {
		return true;
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}

	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}
	
	public void performBonemeal(ServerLevel p_154498_, RandomSource p_154499_, BlockPos p_154500_, BlockState p_154501_) {
		BlockState blockstate = PFBlocks.TALL_ARCHAEFRUCTUS.get().defaultBlockState();
		BlockState blockstate1 = blockstate.setValue(TallArchaefructusBlock.HALF, DoubleBlockHalf.UPPER);
		BlockPos blockpos = p_154500_.above();
		if (p_154498_.getBlockState(blockpos).is(Blocks.WATER)) {
			p_154498_.setBlock(p_154500_, blockstate, 2);
			p_154498_.setBlock(blockpos, blockstate1, 2);
		}

	}

}
