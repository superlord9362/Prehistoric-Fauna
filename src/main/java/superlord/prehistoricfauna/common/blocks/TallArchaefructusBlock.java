package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import superlord.prehistoricfauna.init.PFBlocks;

public class TallArchaefructusBlock  extends DoublePlantBlock implements LiquidBlockContainer {
	public static final EnumProperty<DoubleBlockHalf> HALF = DoublePlantBlock.HALF;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public TallArchaefructusBlock(BlockBehaviour.Properties p_154745_) {
		super(p_154745_);
	}

	protected boolean mayPlaceOn(BlockState p_154774_, BlockGetter p_154775_, BlockPos p_154776_) {
		return p_154774_.isFaceSturdy(p_154775_, p_154776_, Direction.UP) && !p_154774_.is(Blocks.MAGMA_BLOCK);
	}

	public ItemStack getCloneItemStack(BlockGetter p_154749_, BlockPos p_154750_, BlockState p_154751_) {
		return new ItemStack(PFBlocks.TALL_ARCHAEFRUCTUS.get());
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_154747_) {
		BlockState blockstate = super.getStateForPlacement(p_154747_);
		if (blockstate != null) {
			FluidState fluidstate = p_154747_.getLevel().getFluidState(p_154747_.getClickedPos().above());
			if (fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8) {
				return blockstate;
			}
		}

		return null;
	}

	public boolean canSurvive(BlockState p_154768_, LevelReader p_154769_, BlockPos p_154770_) {
		if (p_154768_.getValue(HALF) == DoubleBlockHalf.UPPER) {
			BlockState blockstate = p_154769_.getBlockState(p_154770_.below());
			BlockState uBlockstate = p_154769_.getBlockState(p_154770_.above());
			return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER && uBlockstate.isAir();
		} else {
			FluidState fluidstate = p_154769_.getFluidState(p_154770_);
			return super.canSurvive(p_154768_, p_154769_, p_154770_) && fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8;
		}
	}

	public FluidState getFluidState(BlockState p_154772_) {
		return Fluids.WATER.getSource(false);
	}

	public boolean canPlaceLiquid(BlockGetter p_154753_, BlockPos p_154754_, BlockState p_154755_, Fluid p_154756_) {
		return false;
	}

	public boolean placeLiquid(LevelAccessor p_154758_, BlockPos p_154759_, BlockState p_154760_, FluidState p_154761_) {
		return false;
	}

	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF, WATERLOGGED);
	}
}
