package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.PFBlocks;

public class PtilophyllumBaseBlock extends Block {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_5;
	private final PtilophyllumBlock plantBlock;
	private static final VoxelShape BASE_SHAPE = Block.makeCuboidShape(5D, 0D, 5D, 11D, 16D, 11D);

	public PtilophyllumBaseBlock(PtilophyllumBlock plantBlockIn, Block.Properties builder) {
		super(builder);
		this.plantBlock = plantBlockIn;
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.isValidPosition(worldIn, pos)) {
			worldIn.destroyBlock(pos, true);
		} else {
			BlockPos blockpos = pos.up();
			if (worldIn.isAirBlock(blockpos) && blockpos.getY() < worldIn.getDimensionType().getLogicalHeight()) {
				int i = state.get(AGE);
				if (i < 5 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
					boolean flag = false;
					boolean flag1 = false;
					BlockState blockstate = worldIn.getBlockState(pos.down());
					Block block = blockstate.getBlock();
					if (block == PFBlocks.SILT || block == PFBlocks.HARDENED_SILT || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == Blocks.DIRT || block == Blocks.GRASS_BLOCK || block == Blocks.PODZOL || block == Blocks.COARSE_DIRT || block == Blocks.MYCELIUM) {
						flag = true;
					} else if (block == this.plantBlock) {
						int j = 1;

						for(int k = 0; k < 4; ++k) {
							Block block1 = worldIn.getBlockState(pos.down(j + 1)).getBlock();
							if (block1 != this.plantBlock) {
								if (block1 == PFBlocks.SILT || block1 == PFBlocks.HARDENED_SILT || block1 == PFBlocks.MOSSY_DIRT || block1 == PFBlocks.LOAM || block1 == PFBlocks.PACKED_LOAM || block1 == Blocks.DIRT || block1 == Blocks.GRASS_BLOCK || block1 == Blocks.PODZOL || block1 == Blocks.COARSE_DIRT || block1 == Blocks.MYCELIUM) {
									flag1 = true;
								}
								break;
							}

							++j;
						}

						if (j < 2 || j <= rand.nextInt(flag1 ? 5 : 4)) {
							flag = true;
						}
					} else if (blockstate.isAir(worldIn, pos.down())) {
						flag = true;
					}

					if (flag && areAllNeighborsEmpty(worldIn, blockpos, (Direction)null) && worldIn.isAirBlock(pos.up(2))) {
						worldIn.setBlockState(pos, this.plantBlock.makeConnections(worldIn, pos), 2);
						this.placeGrownFlower(worldIn, blockpos, i);
					} else if (i < 4) {
						int l = rand.nextInt(4);
						if (flag1) {
							++l;
						}

						boolean flag2 = false;

						for(int i1 = 0; i1 < l; ++i1) {
							Direction direction = Direction.Plane.HORIZONTAL.random(rand);
							BlockPos blockpos1 = pos.offset(direction);
							if (worldIn.isAirBlock(blockpos1) && worldIn.isAirBlock(blockpos1.down()) && areAllNeighborsEmpty(worldIn, blockpos1, direction.getOpposite())) {
								this.placeGrownFlower(worldIn, blockpos1, i + 1);
								flag2 = true;
							}
						}

						if (flag2) {
							worldIn.setBlockState(pos, this.plantBlock.makeConnections(worldIn, pos), 2);
						} else {
							this.placeDeadFlower(worldIn, pos);
						}
					} else {
						this.placeDeadFlower(worldIn, pos);
					}
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
				}
			}
		}
	}

	private void placeGrownFlower(World worldIn, BlockPos pos, int age) {
		worldIn.setBlockState(pos, this.getDefaultState().with(AGE, Integer.valueOf(age)), 2);
	}

	private void placeDeadFlower(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, this.getDefaultState().with(AGE, Integer.valueOf(5)), 2);
	}

	private static boolean areAllNeighborsEmpty(IWorldReader worldIn, BlockPos pos, @Nullable Direction excludingSide) {
		for(Direction direction : Direction.Plane.HORIZONTAL) {
			if (direction != excludingSide && !worldIn.isAirBlock(pos.offset(direction))) {
				return false;
			}
		}

		return true;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (facing != Direction.UP && !stateIn.isValidPosition(worldIn, currentPos)) {
			worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
		}

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@SuppressWarnings("deprecation")
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.down());
		Block block = blockstate.getBlock();
		if (block != this.plantBlock && block != PFBlocks.SILT && block != PFBlocks.HARDENED_SILT && block != PFBlocks.LOAM && block != PFBlocks.PACKED_LOAM && block != PFBlocks.MOSSY_DIRT && block != Blocks.DIRT && block != Blocks.COARSE_DIRT && block != Blocks.GRASS_BLOCK && block != Blocks.MYCELIUM && block != Blocks.PODZOL) {
			if (!blockstate.isAir(worldIn, pos.down())) {
				return false;
			} else {
				boolean flag = false;

				for(Direction direction : Direction.Plane.HORIZONTAL) {
					BlockState blockstate1 = worldIn.getBlockState(pos.offset(direction));
					if (blockstate1.getBlock() == this.plantBlock) {
						if (flag) {
							return false;
						}

						flag = true;
					} else if (!blockstate1.isAir(worldIn, pos.offset(direction))) {
						return false;
					}
				}

				return flag;
			}
		} else {
			return true;
		}
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	public static void generatePlant(IWorld worldIn, BlockPos pos, Random rand, int p_185603_3_) {
		worldIn.setBlockState(pos, ((PtilophyllumBlock)PFBlocks.PTILOPHYLLUM_WOOD).makeConnections(worldIn, pos), 2);
		growTreeRecursive(worldIn, pos, rand, pos, p_185603_3_, 0);
	}

	private static void growTreeRecursive(IWorld worldIn, BlockPos p_185601_1_, Random rand, BlockPos p_185601_3_, int p_185601_4_, int p_185601_5_) {
		PtilophyllumBlock ptilophullumwoodblock = (PtilophyllumBlock)PFBlocks.PTILOPHYLLUM_WOOD;
		int i = rand.nextInt(4) + 1;
		if (p_185601_5_ == 0) {
			++i;
		}

		for(int j = 0; j < i; ++j) {
			BlockPos blockpos = p_185601_1_.up(j + 1);
			if (!areAllNeighborsEmpty(worldIn, blockpos, (Direction)null)) {
				return;
			}

			worldIn.setBlockState(blockpos, ptilophullumwoodblock.makeConnections(worldIn, blockpos), 2);
			worldIn.setBlockState(blockpos.down(), ptilophullumwoodblock.makeConnections(worldIn, blockpos.down()), 2);
		}

		boolean flag = false;
		if (p_185601_5_ < 4) {
			int l = rand.nextInt(4);
			if (p_185601_5_ == 0) {
				++l;
			}

			for(int k = 0; k < l; ++k) {
				Direction direction = Direction.Plane.HORIZONTAL.random(rand);
				BlockPos blockpos1 = p_185601_1_.up(i).offset(direction);
				if (Math.abs(blockpos1.getX() - p_185601_3_.getX()) < p_185601_4_ && Math.abs(blockpos1.getZ() - p_185601_3_.getZ()) < p_185601_4_ && worldIn.isAirBlock(blockpos1) && worldIn.isAirBlock(blockpos1.down()) && areAllNeighborsEmpty(worldIn, blockpos1, direction.getOpposite())) {
					flag = true;
					worldIn.setBlockState(blockpos1, ptilophullumwoodblock.makeConnections(worldIn, blockpos1), 2);
					worldIn.setBlockState(blockpos1.offset(direction.getOpposite()), ptilophullumwoodblock.makeConnections(worldIn, blockpos1.offset(direction.getOpposite())), 2);
					growTreeRecursive(worldIn, blockpos1, rand, p_185601_3_, p_185601_4_, p_185601_5_ + 1);
				}
			}
		}

		if (!flag) {
			worldIn.setBlockState(p_185601_1_.up(i), PFBlocks.PTILOPHYLLUM_BASE.getDefaultState().with(AGE, Integer.valueOf(5)), 2);
		}

	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return BASE_SHAPE;
	}

	public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, Entity projectile) {
		BlockPos blockpos = hit.getPos();
		worldIn.destroyBlock(blockpos, true, projectile);
	}
}