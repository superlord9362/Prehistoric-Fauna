package superlord.prehistoricfauna.machines.combiner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import superlord.prehistoricfauna.blocks.SyncedFieldContainer;

public class Container_DNACombiner extends SyncedFieldContainer {
	private final TileEntity_DNACombiner analyzer;

	public Container_DNACombiner(InventoryPlayer playerInventory, TileEntity_DNACombiner tile) {
		super(tile);
		this.analyzer = tile;

		int slotIndex = -1;
		
		for (int row = 1; row < 3; row++) {
			this.addSlotToContainer(new Slot_DNACombiner(this.analyzer, ++slotIndex, 36, (row<2) ? row*15 : row*27));
			this.addSlotToContainer(new Slot_DNACombiner(this.analyzer, ++slotIndex, 64, (row<2) ? row*15 : row*27));
		}

		this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, this.analyzer, ++slotIndex, 122, 34));
		
		for (int column = 0; column < 3; ++column) {
			for (int row = 0; row < 9; ++row) {
				this.addSlotToContainer(
						new Slot(playerInventory,  row + column * 9 + 9,
								8 + row * 18,
								84 + column * 18
							));
			}
		}
		
		for (int row = 0; row < 9; ++row) {
			this.addSlotToContainer(new Slot(playerInventory, row,
					8 + row * 18,
					142));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.analyzer.isUsableByPlayer(player);
	}
}
