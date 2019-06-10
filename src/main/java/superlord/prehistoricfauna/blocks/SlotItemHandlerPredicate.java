package superlord.prehistoricfauna.blocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public class SlotItemHandlerPredicate extends SlotItemHandler {
    private final Predicate<ItemStack> predicate;

    public SlotItemHandlerPredicate(IItemHandler itemHandler, int index, int xPosition, int yPosition, Predicate<ItemStack> predicate) {
        super(itemHandler, index, xPosition, yPosition);
        this.predicate = predicate;
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        return super.isItemValid(stack) && this.predicate.test(stack);
    }
}
