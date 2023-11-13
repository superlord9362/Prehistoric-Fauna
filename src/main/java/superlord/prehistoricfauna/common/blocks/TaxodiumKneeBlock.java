package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.PFBlocks;

public class TaxodiumKneeBlock extends Block implements BonemealableBlock, SimpleWaterloggedBlock, IPlantable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final EnumProperty<KneeThickness> THICKNESS = EnumProperty.create("thickness", KneeThickness.class);
	private static final VoxelShape TOP_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

	public TaxodiumKneeBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(THICKNESS, KneeThickness.TOP));
	}

	public BlockBehaviour.OffsetType getValueOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, THICKNESS);
	}
	
	public boolean isSoilBlock(LevelReader world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT);
	}

	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		return (reader.getBlockState(pos.below()).getBlock() == this || isSoilBlock(reader, pos.below()));
	}

	public boolean isPathfindable(BlockState p_154112_, BlockGetter p_154113_, BlockPos p_154114_, PathComputationType p_154115_) {
		return false;
	}

	public VoxelShape getOcclusionShape(BlockState p_154170_, BlockGetter p_154171_, BlockPos p_154172_) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		KneeThickness kneeThickness = state.getValue(THICKNESS);
		VoxelShape voxelShape;
		if (kneeThickness == KneeThickness.BASE) {
			voxelShape = BASE_SHAPE;
		} else if (kneeThickness == KneeThickness.MIDDLE) {
			voxelShape = MIDDLE_SHAPE;
		} else {
			voxelShape = TOP_SHAPE;
		}
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		KneeThickness kneeThickness = state.getValue(THICKNESS);
		VoxelShape voxelShape;
		if (kneeThickness == KneeThickness.BASE) {
			voxelShape = BASE_SHAPE;
		} else if (kneeThickness == KneeThickness.MIDDLE) {
			voxelShape = MIDDLE_SHAPE;
		} else {
			voxelShape = TOP_SHAPE;
		}
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}

	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
		if (!this.canSurvive(state, world, pos)) {
			world.destroyBlock(pos, true);
		}
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.canSurvive(worldIn, currentPos)) {
			worldIn.scheduleTick(currentPos, this, 1);
		}
		
		BlockState currentState = worldIn.getBlockState(currentPos);
		
		if (getNumKneeBlocksAbove(worldIn, currentPos) == 0) {
			worldIn.setBlock(currentPos, currentState.setValue(THICKNESS, KneeThickness.TOP), 0);
		} else if (getNumKneeBlocksAbove(worldIn, currentPos) == 1) {
			worldIn.setBlock(currentPos, currentState.setValue(THICKNESS, KneeThickness.MIDDLE), 0);
		} else if (getNumKneeBlocksAbove(worldIn, currentPos) > 1) {
			worldIn.setBlock(currentPos, currentState.setValue(THICKNESS, KneeThickness.BASE), 0);
		}

		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_56089_) {
		FluidState fluidstate = p_56089_.getLevel().getFluidState(p_56089_.getClickedPos());
		boolean flag = fluidstate.getType() == Fluids.WATER;
		return super.getStateForPlacement(p_56089_).setValue(WATERLOGGED, Boolean.valueOf(flag));
	}

	@Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		return defaultBlockState();
	}


	protected int getNumKneeBlocksAbove(BlockGetter worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 3 && worldIn.getBlockState(pos.above(i + 1)).is(PFBlocks.TAXODIUM_KNEE.get()); ++i) {
		}
		return i;
	}

	public enum KneeThickness implements StringRepresentable {
		TOP("top"),
		MIDDLE("middle"),
		BASE("base");

		private final String name;

		private KneeThickness(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}

		public String getSerializedName() {
			return this.name;
		}
	}

	protected int getBlocksToGrowWhenBonemealed(Random p_54314_) {
		return 1;
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter p_50897_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level p_50901_, Random p_50902_, BlockPos p_50903_, BlockState p_50904_) {
		return true;
	}
	
	public boolean isAirBlock(ServerLevel world, BlockPos pos) {
		return (world.getBlockState(pos) == Blocks.AIR.defaultBlockState() || world.getBlockState(pos) == Blocks.CAVE_AIR.defaultBlockState() || world.getBlockState(pos) == Blocks.VOID_AIR.defaultBlockState());
	}

	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		if (isAirBlock(world, pos.above())) {
			world.setBlockAndUpdate(pos.above(), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState());
		}

	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState p_56131_) {
		return p_56131_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56131_);
	}

}
