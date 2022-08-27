package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.PFBlocks;

public class NeocalamitesTopBlock extends Block {

	protected static final VoxelShape SHAPE_NORMAL = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	protected static final VoxelShape SHAPE_COLLISION = Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	public static final IntegerProperty PROPERTY_NEOCALAMITES_LEAVES = IntegerProperty.create("leaves", 0, 2);
	public static final IntegerProperty PROPERTY_STAGE = IntegerProperty.create("stage", 0, 2);

	public NeocalamitesTopBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_NEOCALAMITES_LEAVES, 0).with(PROPERTY_STAGE, Integer.valueOf(0)));
	}

	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(PFBlocks.NEOCALAMITES.asItem());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PROPERTY_NEOCALAMITES_LEAVES, PROPERTY_STAGE);
	}

	public AbstractBlock.OffsetType getOffsetType() {
		return AbstractBlock.OffsetType.XZ;
	}

	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		if (!state.isValidPosition(world, pos)) {
			world.destroyBlock(pos, true);
		}
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

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.isValidPosition(worldIn, currentPos)) {
			worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
		}
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.down());
		if (blockstate.getBlock() == this || blockstate.getBlock() == PFBlocks.NEOCALAMITES) {
			return true;
		} else return false;
	}

}
