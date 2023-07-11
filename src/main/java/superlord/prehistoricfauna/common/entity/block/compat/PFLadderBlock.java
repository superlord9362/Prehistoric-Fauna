package superlord.prehistoricfauna.common.entity.block.compat;

import net.minecraft.world.level.block.LadderBlock;

/**
 * A {@link LadderBlock} extension that fills its item after the vanilla ladder item.
 */
public class PFLadderBlock extends LadderBlock {

	public PFLadderBlock(Properties builder) {
		super(builder);
	}
}