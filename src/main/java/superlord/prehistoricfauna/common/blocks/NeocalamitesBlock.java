package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class NeocalamitesBlock extends Block implements IPlantable, SimpleWaterloggedBlock, BonemealableBlock {
	protected static final VoxelShape SHAPE_NORMAL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	protected static final VoxelShape SHAPE_COLLISION = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	public static final IntegerProperty PROPERTY_AGE = BlockStateProperties.AGE_1;
	public static final IntegerProperty PROPERTY_NEOCALAMITES_LEAVES = IntegerProperty.create("leaves", 0, 2);
	public static final IntegerProperty PROPERTY_STAGE = IntegerProperty.create("stage", 0, 2);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");
	protected static final int MAX_HEIGHT = 3;

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
	public FluidState getFluidState(BlockState p_56131_) {
		return p_56131_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56131_);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape voxelShape = SHAPE_NORMAL;
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(world, pos);
		return SHAPE_COLLISION.move(vector3d.x, vector3d.y, vector3d.z);
	}

	public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
		if (!this.canSurvive(state, world, pos)) {
			world.destroyBlock(pos, true);
		}
	}

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		if (state.getValue(PLAYER_PLACED) != true) return;
		if (world.getBlockState(pos.above()).is(this)) return;
		if (!world.isEmptyBlock(pos.above())) return;
		if (this.getStackHeight(world, pos) >= MAX_HEIGHT) return;

		int age = state.getValue(PROPERTY_AGE);
		if (age < 1) {
			world.setBlock(pos, state.setValue(PROPERTY_AGE, Integer.valueOf(age + 1)), 4);
			return;
		}
		if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
			this.growStack(world, pos);
			world.setBlock(pos, world.getBlockState(pos).setValue(PROPERTY_AGE, Integer.valueOf(0)), 4);
		}
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
		if (state.getValue(PLAYER_PLACED) != true) return false;
		if (!level.isEmptyBlock(pos.above())) return false;
		return this.getStackHeight(level, pos) < MAX_HEIGHT;
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource rand, BlockPos pos, BlockState state) {
		if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
			this.growStack(world, pos);
		}
	}

	/**
	 * Counts how tall the contiguous stack of NeocalamitesBlock is, starting
	 * from tipPos and walking down until a non-matching block is found.
	 */
	protected int getStackHeight(BlockGetter world, BlockPos tipPos) {
		int height = 1;
		BlockPos p = tipPos;
		while (world.getBlockState(p.below()).is(this)) {
			p = p.below();
			height++;
		}
		return height;
	}

	protected void growStack(ServerLevel world, BlockPos tipPos) {
		int height = this.getStackHeight(world, tipPos);
		if (height >= MAX_HEIGHT) return;
		BlockPos newPos = tipPos.above();
		if (!world.isEmptyBlock(newPos)) return;

		world.setBlockAndUpdate(newPos, this.defaultBlockState());
		this.refreshLeaves(world, newPos);
	}
	
	protected void refreshLeaves(LevelAccessor world, BlockPos topPos) {
		int height = this.getStackHeight(world, topPos);
		int stage = height >= 3 ? 2 : (height == 2 ? 1 : 0);
		BlockPos cursor = topPos;
		for (int depthFromTop = 0; depthFromTop < height; depthFromTop++) {
			int depthFromBottom = height - 1 - depthFromTop;
			int leavesFromBottom = Math.min(depthFromBottom, 2);
			int leavesFromTop = Math.max(0, 2 - depthFromTop);
			int leaves = Math.min(leavesFromBottom, leavesFromTop);
			BlockState cur = world.getBlockState(cursor);
			if (cur.is(this)) {
				world.setBlock(cursor, cur.setValue(PROPERTY_STAGE, Integer.valueOf(stage)).setValue(PROPERTY_NEOCALAMITES_LEAVES, Integer.valueOf(leaves)), 3);
			}
			cursor = cursor.below();
		}
	}

	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState below = world.getBlockState(pos.below());
		if (below.getBlock() == this) return true;
		BlockState waterState = world.getBlockState(pos);
		BlockState aboveWaterState = world.getBlockState(pos.above());
		if (below.canSustainPlant(world, pos.below(), Direction.UP, this) || below.getBlock() == Blocks.RED_SAND || below.getBlock() == Blocks.PACKED_MUD || below.getBlock() == Blocks.SAND || (waterState.getBlock() == Blocks.WATER && (aboveWaterState.getBlock() == Blocks.AIR || aboveWaterState.getBlock() == this))) return true;
		return false;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_56089_) {
		FluidState fluidstate = p_56089_.getLevel().getFluidState(p_56089_.getClickedPos());
		boolean flag = fluidstate.getType() == Fluids.WATER;
		return super.getStateForPlacement(p_56089_).setValue(WATERLOGGED, Boolean.valueOf(flag)).setValue(PLAYER_PLACED, true);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(world, pos, state, placer, stack);
		if (world.getBlockState(pos.below()).is(this)) {
			this.refreshLeaves(world, pos);
		}
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