package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import superlord.prehistoricfauna.init.PFBlocks;

public class CrateBlock extends Block {

	public CrateBlock(Properties properties) {
		super(properties);
	}
	
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(PFBlocks.FOSSIL_CRATE.asItem());
	}

}
