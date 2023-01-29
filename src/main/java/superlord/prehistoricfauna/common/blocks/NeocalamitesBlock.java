package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.PFBlocks;

public class NeocalamitesBlock extends Block implements IPlantable, IWaterLoggable {

	protected static final VoxelShape SHAPE_NORMAL = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	protected static final VoxelShape SHAPE_COLLISION = Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	public static final IntegerProperty PROPERTY_AGE = BlockStateProperties.AGE_0_1;
	public static final IntegerProperty PROPERTY_NEOCALAMITES_LEAVES = IntegerProperty.create("leaves", 0, 2);
	public static final IntegerProperty PROPERTY_STAGE = IntegerProperty.create("stage", 0, 2);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");

	public NeocalamitesBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_AGE, 0).with(PROPERTY_NEOCALAMITES_LEAVES, 0).with(PROPERTY_STAGE, Integer.valueOf(0)).with(WATERLOGGED, Boolean.valueOf(false)).with(PLAYER_PLACED, Boolean.valueOf(true)));
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PROPERTY_AGE, PROPERTY_NEOCALAMITES_LEAVES, PROPERTY_STAGE, WATERLOGGED, PLAYER_PLACED);
	}

	public AbstractBlock.OffsetType getOffsetType() {
		return AbstractBlock.OffsetType.XZ;
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		VoxelShape voxelShape = SHAPE_NORMAL;
		Vector3d vector3d = state.getOffset(worldIn, pos);
		return voxelShape.withOffset(vector3d.x, vector3d.y, vector3d.z);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vector3d vector3d = state.getOffset(worldIn, pos);
		return SHAPE_COLLISION.withOffset(vector3d.x, vector3d.y, vector3d.z);
	}

	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		if (!state.isValidPosition(world, pos)) {
			world.destroyBlock(pos, true);
		}
	}
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if ((world.isAirBlock(pos.up()) || world.getBlockState(pos.up()).getBlock() == PFBlocks.NEOCALAMITES_TOP && world.isAirBlock(pos.up(2))) && state.get(PLAYER_PLACED) == true) {
			int i;
			for (i = 1; world.getBlockState(pos.down(i)).isIn(this); ++i) {
			}
			if (i < 3) {
				int j = state.get(PROPERTY_AGE);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
					if (state.get(PROPERTY_STAGE) == 0) {
						if (j == 1) {
							world.setBlockState(pos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 1).with(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockState(pos, this.getDefaultState().with(PROPERTY_STAGE, 1));
						} else {
							world.setBlockState(pos, state.with(PROPERTY_AGE, Integer.valueOf(j + 1)), 4);
						}
					} else if (state.get(PROPERTY_STAGE) == 1) {
						if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 0) {
							world.setBlockState(pos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 1).with(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockState(pos, this.getDefaultState().with(PROPERTY_STAGE, 1));
						} else if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 1) {
							world.setBlockState(pos.up(2), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 2).with(PROPERTY_NEOCALAMITES_LEAVES, 2));
							world.setBlockState(pos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 2).with(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockState(pos, this.getDefaultState().with(PROPERTY_STAGE, 2));
						} else {
							world.setBlockState(pos, state.with(PROPERTY_AGE, Integer.valueOf(j + 1)), 4);
						}
					} else if (state.get(PROPERTY_STAGE) == 2) {
						if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 0) {
							world.setBlockState(pos, this.getDefaultState().with(PROPERTY_STAGE, 2).with(PROPERTY_NEOCALAMITES_LEAVES, 0));
							world.setBlockState(pos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 2).with(PROPERTY_NEOCALAMITES_LEAVES, 1));
						} else if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 1) {
							world.setBlockState(pos.up(2), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 2).with(PROPERTY_NEOCALAMITES_LEAVES, 2));
							world.setBlockState(pos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(PROPERTY_STAGE, 2).with(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockState(pos, this.getDefaultState().with(PROPERTY_STAGE, 2));
						} else {
							world.setBlockState(pos, state.with(PROPERTY_AGE, Integer.valueOf(j + 1)), 4);
						}
					}
				}
			}
		}
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState soil = worldIn.getBlockState(pos.down());
		BlockState waterState = worldIn.getBlockState(pos);
		BlockState aboveWaterState = worldIn.getBlockState(pos.up());
		if (soil.canSustainPlant(worldIn, pos.down(), Direction.UP, this) || soil.getBlock() == Blocks.RED_SAND || soil.getBlock() == Blocks.SAND || waterState.getBlock() == Blocks.WATER && (aboveWaterState.getBlock() == Blocks.AIR || aboveWaterState.getBlock() == this)) return true;
		else return false;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.isValidPosition(worldIn, currentPos)) {
			worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
		}

		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	protected int getNumNeocalamitesBlocksAbove(IBlockReader worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 3 && worldIn.getBlockState(pos.up(i + 1)).isIn(PFBlocks.NEOCALAMITES_TOP); ++i) {
		}
		return i;
	}

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		return getDefaultState();
	}


}
