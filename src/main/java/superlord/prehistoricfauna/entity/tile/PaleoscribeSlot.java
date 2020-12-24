package superlord.prehistoricfauna.entity.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class PaleoscribeSlot extends Slot {
    @SuppressWarnings("unused")
	private PlayerEntity thePlayer;
    @SuppressWarnings("unused")
	private int field_75228_b;

    public PaleoscribeSlot(PlayerEntity player, IInventory inv, int slotIndex, int xPosition, int yPosition) {
        super(inv, slotIndex, xPosition, yPosition);
        this.thePlayer = player;
    }

    @Override
    public void onSlotChanged() {
        this.inventory.markDirty();
    }


    @Override
    public ItemStack decrStackSize(int amount) {
        if (this.getHasStack()) {
            this.field_75228_b += Math.min(amount, this.getStack().getCount());
        }

        return super.decrStackSize(amount);
    }

    @Override
    public ItemStack onTake(PlayerEntity playerIn, ItemStack stack) {
        this.onCrafting(stack);
        return super.onTake(playerIn, stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes,
     * not ore and wood. Typically increases an internal count then calls
     * onCrafting(item).
     */
    @Override
    protected void onCrafting(ItemStack stack, int amount) {
        this.field_75228_b += amount;
        this.onCrafting(stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes,
     * not ore and wood.
     */
    @Override
    protected void onCrafting(ItemStack stack) {
        // thePlayer.addStat(StatList.objectCraftStats[Item.getIdFromItem(stack.getItem())],
        // stack.stackSize);
        this.field_75228_b = 0;

    }
}