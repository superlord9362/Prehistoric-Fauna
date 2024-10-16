package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.PlantType;

public class CallianthusBlock extends BushBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

	public CallianthusBlock(Properties p_52861_) {
		super(p_52861_);
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF,  DoubleBlockHalf.UPPER).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.WATER;
	}

	public static void placeAt(LevelAccessor p_153174_, BlockState p_153175_, BlockPos p_153176_, int p_153177_) {
		BlockPos blockpos = p_153176_.below();
		p_153174_.setBlock(p_153176_, p_153175_.setValue(HALF, DoubleBlockHalf.UPPER), p_153177_);
		p_153174_.setBlock(blockpos, p_153175_.setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), p_153177_);
	}

	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockPos blockpos = pos.below();
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return true;
		} else return this.mayPlaceOn(world.getBlockState(blockpos), world, blockpos);
	}

	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		if (world.isClientSide()) {
			if (state.getValue(WATERLOGGED)) {
				world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
			}
		}
	}

	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}

	public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		world.setBlock(pos.below(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, true), 3);
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public void playerWillDestroy(Level p_52878_, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
		if (!p_52878_.isClientSide) {
			if (p_52881_.isCreative()) {
				preventCreativeDropFromBottomOrTopPart(p_52878_, p_52879_, p_52880_, p_52881_);
			} else {
				dropResources(p_52880_, p_52878_, p_52879_, (BlockEntity)null, p_52881_, p_52881_.getMainHandItem());
			}
		}
		if (p_52878_.getBlockState(p_52879_.above()).getBlock() == this) p_52878_.destroyBlock(p_52879_.above(), true);
		super.playerWillDestroy(p_52878_, p_52879_, p_52880_, p_52881_);
	}

	public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
		if (p_52868_.getValue(HALF) == DoubleBlockHalf.LOWER) {
			super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
			super.playerDestroy(p_52865_, p_52866_, p_52867_.above(), Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
		}
		super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
	}

	public static void preventCreativeDropFromBottomOrTopPart(Level world, BlockPos pos, BlockState state, Player player) {
		DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = pos.below();
			BlockState blockstate = world.getBlockState(blockpos);
			if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				BlockState blockstate1 = blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && blockstate.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				world.setBlock(blockpos, blockstate1, 35);
				world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			}
		}
		if (doubleblockhalf == DoubleBlockHalf.LOWER) {
			BlockPos blockpos = pos.above();
			BlockState blockstate = world.getBlockState(blockpos);
			if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.UPPER) {
				BlockState blockstate1 = blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && blockstate.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				world.setBlock(blockpos, blockstate1, 35);
				world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}

	protected boolean mayPlaceOn(BlockState p_58174_, BlockGetter p_58175_, BlockPos p_58176_) {
		FluidState fluidstate = p_58175_.getFluidState(p_58176_);
		FluidState fluidstate1 = p_58175_.getFluidState(p_58176_.above());
		return (fluidstate.getType() == Fluids.WATER || p_58174_.getBlock() instanceof IceBlock) && fluidstate1.getType() == Fluids.EMPTY;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF, WATERLOGGED);
	}
}
