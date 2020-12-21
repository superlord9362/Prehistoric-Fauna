package superlord.prehistoricfauna.inventory;

import org.spongepowered.asm.mixin.SoftOverride;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotPaleoscribe extends Slot {
	
	@SuppressWarnings("unused")
	private PlayerEntity thePlayer;
	@SuppressWarnings("unused")
	private int removeCount;
	
	public SlotPaleoscribe(PlayerEntity player, IInventory inv, int slotIndex, int xPosition, int yPosition) {
		super(inv, slotIndex, xPosition, yPosition);
		this.thePlayer = player;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) {
		if (this.getHasStack()) {
			this.removeCount += Math.min(amount, this.getStack().getCount());
		}
		return super.decrStackSize(amount);
	}
	
	@Override
	public ItemStack onTake(PlayerEntity player, ItemStack stack) {
		this.onCrafting(stack);
		return super.onTake(player, stack);
	}
	
	@Override
	protected void onCrafting(ItemStack stack, int amount) {
		this.removeCount += amount;
		this.onCrafting(stack);
	}
	
	@Override
	protected void onCrafting(ItemStack stack) {
		this.removeCount = 0;
	}

}
