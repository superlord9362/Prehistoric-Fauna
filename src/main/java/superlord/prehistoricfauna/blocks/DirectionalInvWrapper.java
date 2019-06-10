package superlord.prehistoricfauna.blocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class DirectionalInvWrapper implements IItemHandler, IItemHandlerModifiable {
    private final IItemHandlerModifiable internal;
    private final Mode mode;

    public DirectionalInvWrapper(IItemHandlerModifiable internal, Mode mode) {
        this.internal = internal;
        this.mode = mode;
    }

    @Override
    public int getSlots() {
        return this.internal.getSlots();
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.internal.getStackInSlot(slot);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        return this.mode == Mode.INPUT ? this.internal.insertItem(slot, stack, simulate) : stack;
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return this.mode == Mode.OUTPUT ? this.internal.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
    }

    @Override
    public int getSlotLimit(int slot) {
        return this.internal.getSlotLimit(slot);
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
        if (this.mode == Mode.INPUT) {
            this.internal.setStackInSlot(slot, stack);
        }
    }

    public enum Mode {
        INPUT,
        OUTPUT
    }
}
