package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import superlord.prehistoricfauna.common.entity.block.HenostoneFireSpitterBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class HenostoneFireSpitterBlock extends BaseEntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

	public HenostoneFireSpitterBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
	}	

	public Direction getDirection(BlockState state) {
		Direction direction = state.getValue(FACING);
		return direction;
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction direction = context.getHorizontalDirection().getOpposite();
		return this.defaultBlockState().setValue(FACING, direction);
	}
	
	public boolean getPowered(BlockState state) {
		return state.getValue(POWERED);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, POWERED);
	}
	
	@SuppressWarnings("deprecation")
	public void onRemove(BlockState p_49319_, Level p_49320_, BlockPos p_49321_, BlockState p_49322_, boolean p_49323_) {
	      if (!p_49323_ && !p_49319_.is(p_49322_.getBlock())) {
	         if (this.getSignalForState(p_49319_) > 0) {
	            this.updateNeighbours(p_49320_, p_49321_);
	         }

	         super.onRemove(p_49319_, p_49320_, p_49321_, p_49322_, p_49323_);
	      }
	   }

	   protected void updateNeighbours(Level p_49292_, BlockPos p_49293_) {
	      p_49292_.updateNeighborsAt(p_49293_, this);
	      p_49292_.updateNeighborsAt(p_49293_.below(), this);
	   }

	   public int getSignal(BlockState p_49309_, BlockGetter p_49310_, BlockPos p_49311_, Direction p_49312_) {
	      return this.getSignalForState(p_49309_);
	   }

	   public int getDirectSignal(BlockState p_49346_, BlockGetter p_49347_, BlockPos p_49348_, Direction p_49349_) {
	      return p_49349_ == Direction.UP ? this.getSignalForState(p_49346_) : 0;
	   }

	   public boolean isSignalSource(BlockState p_49351_) {
	      return true;
	   }

	protected int getSignalForState(BlockState p_55270_) {
		return p_55270_.getValue(POWERED) ? 15 : 0;
	}

	protected BlockState setSignalForState(BlockState p_55259_, int p_55260_) {
		return p_55259_.setValue(POWERED, Boolean.valueOf(p_55260_ > 0));
	}

	public BlockEntity newBlockEntity(BlockPos p_152164_, BlockState p_152165_) {
		return new HenostoneFireSpitterBlockEntity(p_152164_, p_152165_);
	}
	
	public static boolean isPowered(BlockState state) {
		return state.getValue(POWERED);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> p_152162_) {
		return createTickerHelper(p_152162_, PFBlockEntities.HENOSTONE_FIRE_SPITTER.get(), HenostoneFireSpitterBlockEntity::tick);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
	    return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
	    return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}
	
	public RenderShape getRenderShape(BlockState p_49439_) {
		return RenderShape.MODEL;
	}

}
