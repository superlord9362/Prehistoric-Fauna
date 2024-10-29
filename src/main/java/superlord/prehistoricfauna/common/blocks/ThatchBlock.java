package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ThatchBlock extends HayBlock {

	public ThatchBlock(Properties p_53976_) {
		super(p_53976_);
	}

	public float getShadeBrightness(BlockState p_48731_, BlockGetter p_48732_, BlockPos p_48733_) {
		return 1.0F;
	}

}
