package superlord.prehistoricfauna.common.entity.block.compat;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LadderBlock;
import superlord.prehistoricfauna.common.util.TargetedItemCategoryFiller;

/**
 * A {@link LadderBlock} extension that fills its item after the vanilla ladder item.
 */
public class PFLadderBlock extends LadderBlock {
	private static final TargetedItemCategoryFiller FILLER = new TargetedItemCategoryFiller(() -> Items.LADDER);

	public PFLadderBlock(Properties builder) {
		super(builder);
	}

	@Override
	public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
		FILLER.fillItem(this.asItem(), tab, list);
	}
}