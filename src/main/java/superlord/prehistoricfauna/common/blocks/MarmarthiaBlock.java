package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

public class MarmarthiaBlock extends BushBlock implements BonemealableBlock {

	public static final IntegerProperty LAYER = IntegerProperty.create("layer", 0, 3);
	public static final IntegerProperty BERRIES = IntegerProperty.create("berry", 0, 2);
	public static final IntegerProperty GROWTH = IntegerProperty.create("growth", 0, 2);

	public MarmarthiaBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LAYER, 0).setValue(BERRIES, 0).setValue(GROWTH, 0));
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		if (state.getBlock() == this && state.getValue(LAYER) == 0) {
			BlockState soil = worldIn.getBlockState(pos.below());
			return soil.getBlock().canSustainPlant(soil, worldIn, pos.below(), Direction.UP, this);
		} else {
			if (state.getBlock() == this && state.getValue(LAYER) != 0) {
				BlockState below = worldIn.getBlockState(pos.below());
				return below.getBlock() == this;
			}
		}
		BlockState blockstate = worldIn.getBlockState(pos.below());
		if (state.getBlock() != this) return super.canSurvive(state, worldIn, pos); 
		return blockstate.getBlock() == this && blockstate.getValue(LAYER) == 0;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		return blockpos.getY() < context.getLevel().dimensionType().logicalHeight() - 1 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context) && context.getLevel().getBlockState(blockpos.above(2)).canBeReplaced(context) && context.getLevel().getBlockState(blockpos.above(3)).canBeReplaced(context) && context.getLevel().getBlockState(blockpos.above(4)).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
	}

	@Override
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		worldIn.setBlock(pos, this.defaultBlockState().setValue(LAYER, 0), 2);
	}

	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
		if (state.getValue(LAYER) == 0) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos, true);
				worldIn.destroyBlock(pos.above(), false);
				worldIn.destroyBlock(pos.above(2), false);
				worldIn.destroyBlock(pos.above(3), false);
				worldIn.destroyBlock(pos.above(4), false);
			} else {
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
				worldIn.destroyBlock(pos.above(2), false);
				worldIn.destroyBlock(pos.above(3), false);
				worldIn.destroyBlock(pos.above(4), false);
			}
		} else if (state.getValue(LAYER) == 1) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.below(), true);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
				worldIn.destroyBlock(pos.above(2), false);
				worldIn.destroyBlock(pos.above(3), false);
			} else {
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
				worldIn.destroyBlock(pos.above(2), false);
				worldIn.destroyBlock(pos.above(3), false);
			}
		} else if (state.getValue(LAYER) == 2) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.below(2), true);
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
				worldIn.destroyBlock(pos.above(2), false);
			} else {
				worldIn.destroyBlock(pos.below(2), false);
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
				worldIn.destroyBlock(pos.above(2), false);
			}
		} else if (state.getValue(LAYER) == 3) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.below(3), true);
				worldIn.destroyBlock(pos.below(2), false);
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
			} else {
				worldIn.destroyBlock(pos.below(3), false);
				worldIn.destroyBlock(pos.below(2), false);
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
				worldIn.destroyBlock(pos.above(), false);
			}
		} else if (state.getValue(LAYER) == 4) {
			if(!player.isCreative()) {
				worldIn.destroyBlock(pos.below(4), true);
				worldIn.destroyBlock(pos.below(3), false);
				worldIn.destroyBlock(pos.below(2), false);
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
			} else {
				worldIn.destroyBlock(pos.below(4), false);
				worldIn.destroyBlock(pos.below(3), false);
				worldIn.destroyBlock(pos.below(2), false);
				worldIn.destroyBlock(pos.below(), false);
				worldIn.destroyBlock(pos, false);
			}
		}
		super.playerWillDestroy(worldIn, pos, state, player);
	}

	public BlockState getStateFromMeta(int meta) {
		return this.defaultBlockState().setValue(LAYER, meta);
	}

	public int getMetaFromState(BlockState state) {
		return state.getValue(LAYER);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LAYER, BERRIES, GROWTH);
	}

	public boolean isValidBonemealTarget(BlockGetter p_52258_, BlockPos p_52259_, BlockState state, boolean p_52261_) {
		return state.getValue(GROWTH) < 2;
	}

	public boolean isBonemealSuccess(Level p_52268_, Random p_52269_, BlockPos p_52270_, BlockState p_52271_) {
		return true;
	}

	public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(2, state.getValue(GROWTH) + 1);
		worldIn.setBlock(pos, state.setValue(GROWTH, Integer.valueOf(i)), 2);
	}

	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		int i = state.getValue(GROWTH);
		int j = state.getValue(BERRIES);
		int k = state.getValue(LAYER);
		if (getNumMarmarthiaBlocksBelow(worldIn, pos) == 0) {
			if (i == 0 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,random.nextInt(5) == 0)) {
				worldIn.setBlock(pos, state.setValue(GROWTH, Integer.valueOf(1)), 2);
				worldIn.setBlock(pos.above(), state.setValue(GROWTH, Integer.valueOf(1)).setValue(LAYER, 1), 2);
			}
			if (i == 1 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,random.nextInt(5) == 0)) {
				worldIn.setBlock(pos, state.setValue(GROWTH, Integer.valueOf(2)), 2);
				worldIn.setBlock(pos.above(), state.setValue(GROWTH, Integer.valueOf(2)).setValue(LAYER, 1), 2);
				worldIn.setBlock(pos.above(2), state.setValue(GROWTH, Integer.valueOf(2)).setValue(LAYER, 2), 2);
				worldIn.setBlock(pos.above(3), state.setValue(GROWTH, Integer.valueOf(2)).setValue(LAYER, 3), 2);
			}
		}
		if(i == 2 && j == 0 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlock(pos, state.setValue(GROWTH, Integer.valueOf(2)).setValue(BERRIES, Integer.valueOf(1)).setValue(LAYER, Integer.valueOf(k)), 2);
		}
		if(i == 2 && j == 1 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
			worldIn.setBlock(pos, state.setValue(GROWTH, Integer.valueOf(2)).setValue(BERRIES, Integer.valueOf(2)).setValue(LAYER, Integer.valueOf(k)), 2);
		}
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		int i = state.getValue(BERRIES);
		boolean flag = i == 2;
		if (i > 0) {
			int j = 1 + worldIn.random.nextInt(2);
			popResource(worldIn, pos, new ItemStack(PFItems.MARMARTHIA_BERRIES.get(), j + (flag ? 1 : 0)));
			worldIn.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
			worldIn.setBlock(pos, state.setValue(BERRIES, Integer.valueOf(0)), 2);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		} else {
			return super.use(state, worldIn, pos, player, handIn, hit);
		}
	}

	protected int getNumMarmarthiaBlocksBelow(LevelReader worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 3 && worldIn.getBlockState(pos.below(i + 1)).is(PFBlocks.MARMARTHIA.get()); ++i) {
		}
		return i;
	}

}
