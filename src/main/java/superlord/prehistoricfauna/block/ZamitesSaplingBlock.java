package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

public class ZamitesSaplingBlock extends Block implements IPlantable, IGrowable {

	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	
	public ZamitesSaplingBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1)) {
			return;
		}
		if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
			this.grow(worldIn, pos, state, rand);
		}
	}
	
	public void grow(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
		if (state.get(STAGE) == 0) {
			serverWorld.setBlockState(pos, state.cycle(STAGE), 4);
		} else {
			if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos)) return;
			this.grow(serverWorld, pos);
		}
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		 Block block = state.getBlock();
		 return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		if (state.getBlock() == this) return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
		return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
	   }
	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}
	
	public void grow(IWorld world, BlockPos pos) {
		BlockState log = BlockInit.ZAMITES_LOG.getDefaultState();
		BlockState leaves = BlockInit.ZAMITES_LEAVES.getDefaultState();
		world.setBlockState(pos, log, 2);
		world.setBlockState(pos.up(), log, 2);
		world.setBlockState(pos.up(2), log, 2);
		world.setBlockState(pos.up(3), leaves, 2);
	}


	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() != this) return getDefaultState();
		return state;
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		this.grow(worldIn, pos, state, rand);
	}
	
	

}
