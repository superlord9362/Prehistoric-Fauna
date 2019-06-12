package superlord.prehistoricfauna.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import superlord.prehistoricfauna.blocks.SyncedFieldContainer;
import superlord.prehistoricfauna.blocks.TileEntityDNACombiner;

public class Container_DNACombiner extends SyncedFieldContainer {
	private final TileEntityDNACombiner analyzer;

	public Container_DNACombiner(InventoryPlayer playerInventory, TileEntityDNACombiner tile) {
		super(tile);
		this.analyzer = tile;

		int slotIndex = -1;
		
		for (int column = 0; column < 3; ++column) {
			for (int row = 0; row < 3; ++row) {
				this.addSlotToContainer(new Slot(this.analyzer, ++slotIndex,
						20 + row * 18,
						17 + column * 18));
			}
		}

		for (int column = 0; column < 3; ++column) {
			for (int row = 0; row < 3; ++row) {
				this.addSlotToContainer(
						new SlotFurnaceOutput(playerInventory.player, this.analyzer, ++slotIndex,
								111 + row * 18,
								17 + column * 18));
			}
		}
		
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
