package superlord.prehistoricfauna.common.entity.block.compat;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A {@link Block} extension that has the same enchantment power bonus as the vanilla bookshelf.
 */
public class PFBookshelfBlock extends Block {
	public PFBookshelfBlock(Properties properties) {
		super(properties);
	}

	@Override
	public float getEnchantPowerBonus(BlockState state, LevelReader level, BlockPos pos) {
		return 1.0F;
	}

}