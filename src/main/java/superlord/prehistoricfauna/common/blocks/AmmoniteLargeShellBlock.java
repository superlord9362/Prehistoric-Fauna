package superlord.prehistoricfauna.common.blocks;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.common.entity.henos.Henos;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;

public class AmmoniteLargeShellBlock extends Block implements LiquidBlockContainer {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SHAPE_FRONT_LARGE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_SIDE_LARGE = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);
	@Nullable
	private BlockPattern henosBase;
	@Nullable
	private BlockPattern henosFull;
	private static final Predicate<BlockState> SHELL_PREDICATE = (tuber) -> {
		return tuber != null && (tuber.is(PFBlocks.LARGE_AMMONITE_FOSSIL.get()));
	};
	public AmmoniteLargeShellBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch(getDirection(state)) {
		case NORTH:
		default:
			return SHAPE_FRONT_LARGE;
		case WEST:
			return SHAPE_SIDE_LARGE;
		case SOUTH:
			return SHAPE_FRONT_LARGE;
		case EAST:
			return SHAPE_SIDE_LARGE;
		}
	}

	public static Direction getDirection(BlockState state) {
		Direction direction = state.getValue(FACING);
		return direction;
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction direction = context.getHorizontalDirection().getOpposite();
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.is(Fluids.WATER)));
	}

	public void onPlace(BlockState state, Level world, BlockPos pos, BlockState placeState, boolean p_51391_) {
		if (!placeState.is(state.getBlock())) {
			this.trySpawnHenos(world, pos);
		}
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return !state.getValue(WATERLOGGED);
	}

	@Override
	public boolean canPlaceLiquid(BlockGetter p_54766_, BlockPos p_54767_, BlockState p_54768_, Fluid p_54769_) {
		return false;
	}

	@Override
	public boolean placeLiquid(LevelAccessor p_54770_, BlockPos p_54771_, BlockState p_54772_, FluidState p_54773_) {
		return false;
	}

	public boolean canSpawnHenos(LevelReader world, BlockPos pos) {
		return this.getOrCreateHenosBase().find(world, pos) != null;
	}

	private void trySpawnHenos(Level world, BlockPos pos) {
		BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateHenosFull().find(world, pos);
		if (blockpattern$blockpatternmatch != null) {
			if (blockpattern$blockpatternmatch != null) {
				for(int j = 0; j < this.getOrCreateHenosFull().getWidth(); ++j) {
					for(int k = 0; k < this.getOrCreateHenosFull().getHeight(); ++k) {
						BlockInWorld blockinworld2 = blockpattern$blockpatternmatch.getBlock(j, k, 0);
						world.setBlock(blockinworld2.getPos(), Blocks.AIR.defaultBlockState(), 2);
						world.levelEvent(2001, blockinworld2.getPos(), Block.getId(blockinworld2.getState()));
					}
				}

				BlockPos blockpos = blockpattern$blockpatternmatch.getBlock(1, 2, 0).getPos();
				Henos henos = PFEntities.HENOS.get().create(world);
				henos.setSummoned(true);
				henos.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
				world.addFreshEntity(henos);

				for(ServerPlayer serverplayer1 : world.getEntitiesOfClass(ServerPlayer.class, henos.getBoundingBox().inflate(5.0D))) {
					CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer1, henos);
				}

				for(int i1 = 0; i1 < this.getOrCreateHenosFull().getWidth(); ++i1) {
					for(int j1 = 0; j1 < this.getOrCreateHenosFull().getHeight(); ++j1) {
						BlockInWorld blockinworld1 = blockpattern$blockpatternmatch.getBlock(i1, j1, 0);
						world.blockUpdated(blockinworld1.getPos(), Blocks.AIR);
					}
				}
			}
		}

	}

	private BlockPattern getOrCreateHenosBase() {
		if (this.henosBase == null) {
			this.henosBase = BlockPatternBuilder.start().aisle("~ ~", "#X#", "~#~").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(PFBlocks.HENOSTONE.get()))).where('~', (p_284869_) -> {
				return p_284869_.getState().isAir();
			}).where('X', BlockInWorld.hasState(BlockStatePredicate.forBlock(PFBlocks.TIME_FRAGMENT_BLOCK.get()))).build();
		}

		return this.henosBase;
	}

	private BlockPattern getOrCreateHenosFull() {
		if (this.henosFull == null) {
			this.henosFull = BlockPatternBuilder.start().aisle("~^~", "#X#", "~#~").where('^', BlockInWorld.hasState(SHELL_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(PFBlocks.HENOSTONE.get()))).where('X', BlockInWorld.hasState(BlockStatePredicate.forBlock(PFBlocks.TIME_FRAGMENT_BLOCK.get()))).where('~', (p_284868_) -> {
				return p_284868_.getState().isAir();
			}).build();
		}

		return this.henosFull;
	}

}
