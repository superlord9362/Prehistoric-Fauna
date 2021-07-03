package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import javax.annotation.Nullable;

public class DicroidiumBlock extends BushBlock {

    public static final IntegerProperty LAYER = IntegerProperty.create("layer", 0, 4);

    public DicroidiumBlock(Block.Properties properties) {
        super(properties);
    }

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
		worldIn.setBlockState(pos.up(), this.getDefaultState().with(LAYER, 1), flags);
		worldIn.setBlockState(pos.up(2), this.getDefaultState().with(LAYER, 2), flags);
		worldIn.setBlockState(pos.up(3), this.getDefaultState().with(LAYER, 3), flags);
		worldIn.setBlockState(pos.up(4), this.getDefaultState().with(LAYER, 4), flags);
	}

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.setBlockState(pos, this.getDefaultState().with(LAYER, 0), 2);
        worldIn.setBlockState(pos.up(), this.getDefaultState().with(LAYER, 1), 2);
        worldIn.setBlockState(pos.up(2), this.getDefaultState().with(LAYER, 2), 2);
        worldIn.setBlockState(pos.up(3), this.getDefaultState().with(LAYER, 3), 2);
        worldIn.setBlockState(pos.up(4), this.getDefaultState().with(LAYER, 4), 5);
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
        builder.add(LAYER);
    }

}
