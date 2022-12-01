package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

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
import superlord.prehistoricfauna.init.PFBlocks;

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
			serverWorld.setBlockState(pos, state.func_235896_a_(STAGE), 4);
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
		Random rand = new Random();
		int height = rand.nextInt(3) + 1;
		int frondsChance = rand.nextInt(2);
		int secondFrondsChance = rand.nextInt(2);
		int secondFrondsHeight = rand.nextInt(2) + 1;
		int secondFrondsDirection = rand.nextInt(4);
		int frondsHeight = rand.nextInt(2) + 1;
		int frondsDirection = rand.nextInt(4);
		int x = pos.getX();
		int z = pos.getZ();
		if (pos.getY() >= 1 && pos.getY() + height + 2 <= 256)
		{
			for (int j = pos.getY(); j <= pos.getY() + height; j++)
			{
				world.setBlockState(new BlockPos(x, j, z), PFBlocks.ZAMITES_LOG.getDefaultState(), 2);
				if (frondsChance == 0) {
					if (frondsDirection == 0) {
						if (isAir(world, new BlockPos(x + 1, pos.getY() + frondsHeight, z))) world.setBlockState(new BlockPos(x + 1, pos.getY() + frondsHeight, z), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.WEST), 2);
					}
					if (frondsDirection == 1) {
						if (isAir(world, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1))) world.setBlockState(new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.NORTH), 2);
					}
					if (frondsDirection == 2) {
						if (isAir(world, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1))) world.setBlockState(new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.SOUTH), 2);
					}
					if (frondsDirection == 3) {
						if (isAir(world, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0))) world.setBlockState(new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.EAST), 2);
					}
				}
				if (secondFrondsChance == 2) {
					if (secondFrondsDirection == 0) {
						if (isAir(world, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z))) world.setBlockState(new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.WEST), 2);
					}
					if (secondFrondsDirection == 1) {
						if (isAir(world, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1))) world.setBlockState(new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.NORTH), 2);
					}
					if (secondFrondsDirection == 2) {
						if (isAir(world, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1))) world.setBlockState(new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.SOUTH), 2);
					}
					if (secondFrondsDirection == 3) {
						if (isAir(world, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0))) world.setBlockState(new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.EAST), 2);
					}
				}
			}
			if (isAir(world, new BlockPos(x, pos.getY() + height + 1, z))) world.setBlockState(new BlockPos(x, pos.getY() + height + 1, z), PFBlocks.ZAMITES_LEAVES.getDefaultState(), 2);
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean isAir(IWorld worldIn, BlockPos pos) {
		if (worldIn instanceof net.minecraft.world.IBlockReader) // FORGE: Redirect to state method when possible
			return worldIn.hasBlockState(pos, state -> state.isAir((net.minecraft.world.IBlockReader)worldIn, pos));
		return worldIn.hasBlockState(pos, BlockState::isAir);
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
