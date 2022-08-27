package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class MarmarthiaBlock extends BushBlock implements IGrowable  {

	public static final IntegerProperty LAYER = IntegerProperty.create("layer", 0, 3);
	public static final IntegerProperty BERRIES = IntegerProperty.create("berry", 0, 2);
	public static final IntegerProperty GROWTH = IntegerProperty.create("growth", 0, 2);

	public MarmarthiaBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(LAYER, 0).with(BERRIES, 0).with(GROWTH, 0));
	}

//	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
//		return new ItemStack(PFItems.MARMARTHIA_BERRIES.get());
//	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		if (state.getBlock() == this && state.get(LAYER) == 0) {
			BlockState soil = worldIn.getBlockState(pos.down());
			return soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.Direction.UP, this);
		} else {
			if (state.getBlock() == this && state.get(LAYER) != 0) {
				BlockState below = worldIn.getBlockState(pos.down());
				return below.getBlock() == this;
			}
		}
		BlockState blockstate = worldIn.getBlockState(pos.down());
		if (state.getBlock() != this) return super.isValidPosition(state, worldIn, pos); 
		return blockstate.getBlock() == this && blockstate.get(LAYER) == 0;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		return blockpos.getY() < context.getWorld().getDimensionType().getLogicalHeight() - 1 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context) && context.getWorld().getBlockState(blockpos.up(2)).isReplaceable(context) && context.getWorld().getBlockState(blockpos.up(3)).isReplaceable(context) && context.getWorld().getBlockState(blockpos.up(4)).isReplaceable(context) ? super.getStateForPlacement(context) : null;
	}

	public void placeAt(IWorld worldIn, BlockPos pos, int flags) {
		worldIn.setBlockState(pos, this.getDefaultState().with(LAYER, 0), flags);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos, this.getDefaultState().with(LAYER, 0), 2);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (state.get(LAYER) == 0) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos, true);
				worldIn.destroyBlock(pos.up(), false);
				worldIn.destroyBlock(pos.up(2), false);
				worldIn.destroyBlock(pos.up(3), false);
				worldIn.destroyBlock(pos.up(4), false);
			} else {
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
				worldIn.destroyBlock(pos.up(2), false);
				worldIn.destroyBlock(pos.up(3), false);
				worldIn.destroyBlock(pos.up(4), false);
			}
		} else if (state.get(LAYER) == 1) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.down(), true);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
				worldIn.destroyBlock(pos.up(2), false);
				worldIn.destroyBlock(pos.up(3), false);
			} else {
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
				worldIn.destroyBlock(pos.up(2), false);
				worldIn.destroyBlock(pos.up(3), false);
			}
		} else if (state.get(LAYER) == 2) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.down(2), true);
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
				worldIn.destroyBlock(pos.up(2), false);
			} else {
				worldIn.destroyBlock(pos.down(2), false);
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
				worldIn.destroyBlock(pos.up(2), false);
			}
		} else if (state.get(LAYER) == 3) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.down(3), true);
				worldIn.destroyBlock(pos.down(2), false);
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
			} else {
				worldIn.destroyBlock(pos.down(3), false);
				worldIn.destroyBlock(pos.down(2), false);
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.up(), false);
			}
		} else if (state.get(LAYER) == 4) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.down(4), true);
				worldIn.destroyBlock(pos.down(3), false);
				worldIn.destroyBlock(pos.down(2), false);
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
			} else {
				worldIn.destroyBlock(pos.down(4), false);
				worldIn.destroyBlock(pos.down(3), false);
				worldIn.destroyBlock(pos.down(2), false);
				worldIn.destroyBlock(pos.down(), false);
				worldIn.destroyBlock(pos, false);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	public BlockState getStateFromMeta(int meta) {
		return this.getDefaultState().with(LAYER, meta);
	}

	public int getMetaFromState(BlockState state) {
		return state.get(LAYER);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LAYER, BERRIES, GROWTH);
	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(GROWTH) < 2;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(2, state.get(GROWTH) + 1);
		worldIn.setBlockState(pos, state.with(GROWTH, Integer.valueOf(i)), 2);
	}

	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		int i = state.get(GROWTH);
		int j = state.get(BERRIES);
		int k = state.get(LAYER);
//		if (getNumMarmarthiaBlocksBelow(worldIn, pos) == 0) {
//			if (i == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,random.nextInt(5) == 0)) {
//				worldIn.setBlockState(pos, state.with(GROWTH, Integer.valueOf(1)), 2);
//				worldIn.setBlockState(pos.up(), state.with(GROWTH, Integer.valueOf(1)).with(LAYER, 1), 2);
//			}
//			if (i == 1 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,random.nextInt(5) == 0)) {
//				worldIn.setBlockState(pos, state.with(GROWTH, Integer.valueOf(2)), 2);
//				worldIn.setBlockState(pos.up(), state.with(GROWTH, Integer.valueOf(2)).with(LAYER, 1), 2);
//				worldIn.setBlockState(pos.up(2), state.with(GROWTH, Integer.valueOf(2)).with(LAYER, 2), 2);
//				worldIn.setBlockState(pos.up(3), state.with(GROWTH, Integer.valueOf(2)).with(LAYER, 3), 2);
//			}
//		}
		if(i == 2 && j == 0 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlockState(pos, state.with(GROWTH, Integer.valueOf(2)).with(BERRIES, Integer.valueOf(1)).with(LAYER, Integer.valueOf(k)), 2);
		}
		if(i == 2 && j == 1 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlockState(pos, state.with(GROWTH, Integer.valueOf(2)).with(BERRIES, Integer.valueOf(2)).with(LAYER, Integer.valueOf(k)), 2);
		}
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		int i = state.get(BERRIES);
		boolean flag = i == 2;
		if (i > 0) {
			int j = 1 + worldIn.rand.nextInt(2);
			//spawnAsEntity(worldIn, pos, new ItemStack(PFItems.MARMARTHIA_BERRIES.get(), j + (flag ? 1 : 0)));
			worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
			worldIn.setBlockState(pos, state.with(BERRIES, Integer.valueOf(0)), 2);
			return ActionResultType.func_233537_a_(worldIn.isRemote);
		} else {
			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
		}
	}

//	protected int getNumMarmarthiaBlocksBelow(IBlockReader worldIn, BlockPos pos) {
//		int i;
////		for(i = 0; i < 3 && worldIn.getBlockState(pos.down(i + 1)).isIn(PFBlocks.MARMARTHIA); ++i) {
////		}
//		return i;
//	}

}
