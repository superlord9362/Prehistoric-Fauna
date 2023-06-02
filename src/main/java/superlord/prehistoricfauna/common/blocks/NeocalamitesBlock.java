package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.PFBlocks;

public class NeocalamitesBlock extends Block implements IPlantable, LiquidBlockContainer {
	protected static final VoxelShape SHAPE_NORMAL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	protected static final VoxelShape SHAPE_COLLISION = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	public static final IntegerProperty PROPERTY_AGE = BlockStateProperties.AGE_1;
	public static final IntegerProperty PROPERTY_NEOCALAMITES_LEAVES = IntegerProperty.create("leaves", 0, 2);
	public static final IntegerProperty PROPERTY_STAGE = IntegerProperty.create("stage", 0, 2);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");

	public NeocalamitesBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(PROPERTY_AGE, 0).setValue(PROPERTY_NEOCALAMITES_LEAVES, 0).setValue(PROPERTY_STAGE, Integer.valueOf(0)).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(PLAYER_PLACED, Boolean.valueOf(true)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(PROPERTY_AGE, PROPERTY_NEOCALAMITES_LEAVES, PROPERTY_STAGE, WATERLOGGED, PLAYER_PLACED);
	}

	public BlockBehaviour.OffsetType getValueOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}

	@SuppressWarnings("deprecation")
	public FluidState getValueFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public boolean canPlaceLiquid(BlockGetter p_154505_, BlockPos p_154506_, BlockState p_154507_, Fluid p_154508_) {
		return false;
	}

	@Override
	public boolean placeLiquid(LevelAccessor p_154520_, BlockPos p_154521_, BlockState p_154522_, FluidState p_154523_) {
		return false;
	}

	public VoxelShape getValueShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape voxelShape = SHAPE_NORMAL;
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}

	public VoxelShape getValueCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(world, pos);
		return SHAPE_COLLISION.move(vector3d.x, vector3d.y, vector3d.z);
	}

	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
		if (!state.canSurvive(world, pos)) {
			world.destroyBlock(pos, true);
		}
	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if ((world.isEmptyBlock(pos.above()) || world.getBlockState(pos.above()).getBlock() == PFBlocks.NEOCALAMITES_TOP.get() && world.isEmptyBlock(pos.above(2))) && state.getValue(PLAYER_PLACED) == true) {
			int i;
			for (i = 1; world.getBlockState(pos.below(i)).is(this); ++i) {
			}
			if (i < 3) {
				int j = state.getValue(PROPERTY_AGE);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
					if (state.getValue(PROPERTY_STAGE) == 0) {
						if (j == 1) {
							world.setBlockAndUpdate(pos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 1).setValue(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockAndUpdate(pos, this.defaultBlockState().setValue(PROPERTY_STAGE, 1));
						} else {
							world.setBlock(pos, state.setValue(PROPERTY_AGE, Integer.valueOf(j + 1)), 4);
						}
					} else if (state.getValue(PROPERTY_STAGE) == 1) {
						if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 0) {
							world.setBlockAndUpdate(pos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 1).setValue(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockAndUpdate(pos, this.defaultBlockState().setValue(PROPERTY_STAGE, 1));
						} else if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 1) {
							world.setBlockAndUpdate(pos.above(2), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 2).setValue(PROPERTY_NEOCALAMITES_LEAVES, 2));
							world.setBlockAndUpdate(pos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 2).setValue(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockAndUpdate(pos, this.defaultBlockState().setValue(PROPERTY_STAGE, 2));
						} else {
							world.setBlock(pos, state.setValue(PROPERTY_AGE, Integer.valueOf(j + 1)), 4);
						}
					} else if (state.getValue(PROPERTY_STAGE) == 2) {
						if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 0) {
							world.setBlockAndUpdate(pos, this.defaultBlockState().setValue(PROPERTY_STAGE, 2).setValue(PROPERTY_NEOCALAMITES_LEAVES, 0));
							world.setBlockAndUpdate(pos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 2).setValue(PROPERTY_NEOCALAMITES_LEAVES, 1));
						} else if (j == 1 && this.getNumNeocalamitesBlocksAbove(world, pos) == 1) {
							world.setBlockAndUpdate(pos.above(2), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 2).setValue(PROPERTY_NEOCALAMITES_LEAVES, 2));
							world.setBlockAndUpdate(pos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(PROPERTY_STAGE, 2).setValue(PROPERTY_NEOCALAMITES_LEAVES, 1));
							world.setBlockAndUpdate(pos, this.defaultBlockState().setValue(PROPERTY_STAGE, 2));
						} else {
							world.setBlock(pos, state.setValue(PROPERTY_AGE, Integer.valueOf(j + 1)), 4);
						}
					}
				}
			}
		}
	}

	protected int getNumNeocalamitesBlocksAbove(BlockGetter worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 3 && worldIn.getBlockState(pos.above(i + 1)).is(PFBlocks.NEOCALAMITES_TOP.get()); ++i) {
		}
		return i;
	}

	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState soil = world.getBlockState(pos.below());
		BlockState waterState = world.getBlockState(pos);
		BlockState aboveWaterState = world.getBlockState(pos.above());
		if (soil.canSustainPlant(world, pos.below(), Direction.UP, this) || soil.getBlock() == Blocks.RED_SAND || soil.getBlock() == Blocks.SAND || waterState.getBlock() == Blocks.WATER && (aboveWaterState.getBlock() == Blocks.AIR || aboveWaterState.getBlock() == this)) return true;
		else return false;
	}

	@Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		return defaultBlockState();
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.canSurvive(worldIn, currentPos)) {
			worldIn.scheduleTick(currentPos, this, 1);
		}

		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

}
