package superlord.prehistoricfauna.entity.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ContainerRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;

public class PaleontologyTableContainer extends Container {

	public PaleontologyTableTileEntity tileEntity;
	private IWorldPosCallable canInteractWithCallable;
	private final IIntArray tableData;
    
	public PaleontologyTableContainer(final int windowID, final PlayerInventory playerInv, final PaleontologyTableTileEntity tile) {
		super(ContainerRegistry.PALEONTOLOGY_TABLE.get(), windowID);
        int var3;
        int var4;
		this.tileEntity = tile;
		this.tableData = tile.tableData;
		this.canInteractWithCallable = IWorldPosCallable.of(tile.getWorld(), tile.getPos());
		this.addSlot(new Slot(tile, 0, 35, 41));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 1, 92, 23));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 2, 110, 23));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 3, 128, 23));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 4, 92, 41));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 5, 110, 41));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 6, 128, 41));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 7, 92, 59));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 8, 110, 59));
        this.addSlot(new FurnaceResultSlot(playerInv.player, tile, 9, 128, 59));
        //Player Inventory
        for (var3 = 0; var3 < 3; ++var3) {
            for (var4 = 0; var4 < 9; ++var4) {
                this.addSlot(new Slot(playerInv, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        // player hotbar
        for (var3 = 0; var3 < 9; ++var3) {
            this.addSlot(new Slot(playerInv, var3, 8 + var3 * 18, 142));
        }
	}

	// Client Constructor
	public PaleontologyTableContainer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowID, playerInv, getTileEntity(playerInv, data));
	}
	
	private static PaleontologyTableTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof PaleontologyTableTileEntity) {
			return (PaleontologyTableTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.PALEONTOLOGY_TABLE);
	}
	
	@Nonnull
	@Override
	public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
		ItemStack transferred = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        int otherSlots = this.inventorySlots.size() - 36;
        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            transferred = current.copy();
            if (index < otherSlots) {
                if (!this.mergeItemStack(current, otherSlots, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(current, 0, otherSlots, false)) {
                return ItemStack.EMPTY;
            }
            if (current.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return transferred;
	}

	@OnlyIn(Dist.CLIENT)
	public int getCookProgressionScaled() {
		int i = this.tableData.get(2);
		int j = this.tableData.get(3);
		return j != 0 && i != 0 ? i * 24 / j : 0;
	}
	
}

