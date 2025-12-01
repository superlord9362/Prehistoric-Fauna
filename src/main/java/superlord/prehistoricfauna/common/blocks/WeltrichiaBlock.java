package superlord.prehistoricfauna.common.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WeltrichiaBlock extends Block implements BonemealableBlock  {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(0D, 0D, 0D, 16D, 16D, 1.0D), Direction.SOUTH, Block.box(0D, 0D, 15.0D, 16D, 16.0D, 16.0D), Direction.WEST, Block.box(0.0D, 0.0D, 0D, 1.0D, 16.0D, 16D), Direction.EAST, Block.box(15.0D, 0.0D, 0D, 16.0D, 16.0D, 16D)));
	public static final BooleanProperty TWO_FLOWERS = BooleanProperty.create("two_flowers");

	public WeltrichiaBlock(BlockBehaviour.Properties p_58123_) {
		super(p_58123_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TWO_FLOWERS, false));
	}

	public VoxelShape getShape(BlockState p_58152_, BlockGetter p_58153_, BlockPos p_58154_, CollisionContext p_58155_) {
		return getShape(p_58152_);
	}

	public static VoxelShape getShape(BlockState p_58157_) {
		return AABBS.get(p_58157_.getValue(FACING));
	}

	public boolean canSurvive(BlockState p_58133_, LevelReader p_58134_, BlockPos p_58135_) {
		Direction direction = p_58133_.getValue(FACING);
		BlockPos blockpos = p_58135_.relative(direction);
		BlockState blockstate = p_58134_.getBlockState(blockpos);
		return blockstate.isFaceSturdy(p_58134_, blockpos, direction);
	}

	public boolean canBeReplaced(BlockState p_56101_, BlockPlaceContext p_56102_) {
		return !p_56102_.isSecondaryUseActive() && p_56102_.getItemInHand().is(this.asItem()) && !isTwo(p_56101_);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_58104_) {
		BlockState blockstate = this.defaultBlockState();
		BlockGetter blockgetter = p_58104_.getLevel();
		BlockPos blockpos = p_58104_.getClickedPos();
		Direction[] adirection = p_58104_.getNearestLookingDirections();
		if (blockgetter.getBlockState(blockpos).getBlock() == this) {
			for(Direction direction : adirection) {
				if (direction.getAxis().isHorizontal()) {
					blockstate = blockstate.setValue(FACING, direction).setValue(TWO_FLOWERS, true);
					if (!blockgetter.getBlockState(blockpos.relative(direction)).canBeReplaced(p_58104_)) {
						return blockstate;
					}
				}
			}
		} else {
			for(Direction direction : adirection) {
				if (direction.getAxis().isHorizontal()) {
					blockstate = blockstate.setValue(FACING, direction);
					if (!blockgetter.getBlockState(blockpos.relative(direction)).canBeReplaced(p_58104_)) {
						return blockstate;
					}
				}
			}	
		}

		return null;
	}

	public BlockState rotate(BlockState p_58109_, Rotation p_58110_) {
		return p_58109_.setValue(FACING, p_58110_.rotate(p_58109_.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_58106_, Mirror p_58107_) {
		return p_58106_.rotate(p_58107_.getRotation(p_58106_.getValue(FACING)));
	}

	public BlockState updateShape(BlockState p_58143_, Direction p_58144_, BlockState p_58145_, LevelAccessor p_58146_, BlockPos p_58147_, BlockPos p_58148_) {
		return p_58144_.getOpposite() == p_58143_.getValue(FACING) && !p_58143_.canSurvive(p_58146_, p_58147_) ? Blocks.AIR.defaultBlockState() : p_58143_;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_58150_) {
		p_58150_.add(FACING, TWO_FLOWERS);
	}

	public static boolean isTwo(BlockState p_56133_) {
		return p_56133_.getValue(TWO_FLOWERS);
	}

	public boolean isValidBonemealTarget(LevelReader p_255984_, BlockPos p_56092_, BlockState p_56093_, boolean p_56094_) {
		return true;
	}

	public boolean isBonemealSuccess(Level p_222418_, RandomSource p_222419_, BlockPos p_222420_, BlockState p_222421_) {
		return true;
	}

	public void performBonemeal(ServerLevel p_222413_, RandomSource p_222414_, BlockPos p_222415_, BlockState p_222416_) {
		if (!isTwo(p_222416_)) {
			p_222413_.setBlock(p_222415_, p_222416_.setValue(TWO_FLOWERS, true), 2);
		} else {
			popResource(p_222413_, p_222415_, new ItemStack(this));
		}
	}

}
