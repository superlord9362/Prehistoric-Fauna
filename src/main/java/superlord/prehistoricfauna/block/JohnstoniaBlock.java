package superlord.prehistoricfauna.block;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class JohnstoniaBlock extends BushBlock {

	public static final IntegerProperty LAYER = IntegerProperty.create("layer", 0, 2);

	public JohnstoniaBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		if (state.get(LAYER) == 0) {
			return super.isValidPosition(state, worldIn, pos);
		} else {
			BlockState blockstate = worldIn.getBlockState(pos.down());
			if (state.getBlock() != this) return super.isValidPosition(state, worldIn, pos);
			return blockstate.getBlock() == this;
		}

	}

	public void placeAt(IWorld worldIn, BlockPos pos, int flags) {
		worldIn.setBlockState(pos, this.getDefaultState().with(LAYER, 0), flags);
		worldIn.setBlockState(pos.up(), this.getDefaultState().with(LAYER, 1), flags);
		worldIn.setBlockState(pos.up(2), this.getDefaultState().with(LAYER, 2), flags);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos, this.getDefaultState().with(LAYER, 0), 2);
		worldIn.setBlockState(pos.up(), this.getDefaultState().with(LAYER, 1), 2);
		worldIn.setBlockState(pos.up(2), this.getDefaultState().with(LAYER, 2), 2);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (state.get(LAYER) == 0) {
			worldIn.destroyBlock(pos, true);
			for (int i = 1; i < 3; i++) {
				if (worldIn.getBlockState(pos.up(i)).getBlock() == this) {
					worldIn.destroyBlock(pos.up(i), false);
				}
			}
		} else {
			worldIn.destroyBlock(pos, false);
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
		builder.add(LAYER);
	}

}
