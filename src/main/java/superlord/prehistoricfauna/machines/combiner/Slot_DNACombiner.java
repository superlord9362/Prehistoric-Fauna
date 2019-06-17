package superlord.prehistoricfauna.machines.combiner;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import superlord.prehistoricfauna.items.ItemDNADisk;

public class Slot_DNACombiner extends Slot {

	public Slot_DNACombiner(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
    public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem() instanceof ItemDNADisk;
    }
    
	@Override
    public int getSlotStackLimit()
    {
        return 1;
    }

}
