package superlord.prehistoricfauna.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.TileEntityPaleoscribe;
import superlord.prehistoricfauna.init.ContainerRegistry;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.item.PaleopediaItem;
import superlord.prehistoricfauna.util.EnumPaleoPages;

public class ContainerPaleoscribe extends Container {
	
	private IInventory tileFurnace;
	private int[] possiblePagesInt = new int[3];
	
	public ContainerPaleoscribe(int i, PlayerInventory playerInventory) {
		this(i, new Inventory(2), playerInventory, new IntArray(0));
	}
	
	public ContainerPaleoscribe(int id, IInventory furnaceInventory, PlayerInventory playerInventory, IIntArray vars) {
		super(ContainerRegistry.PALEOSCRIBE_CONTAINER, id);
		this.tileFurnace = furnaceInventory;
		this.addSlot(new SlotPaleoscribe(playerInventory.player, furnaceInventory, 0, 15, 47) {
			@Override
			public boolean isItemValid(ItemStack stack) {
                return super.isItemValid(stack) && !stack.isEmpty() && stack.getItem() instanceof PaleopediaItem;
			}
		});
		this.addSlot(new Slot(furnaceInventory, 1, 35, 47) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return super.isItemValid(stack) && !stack.isEmpty() && stack.getItem() == ItemInit.PALEOPAGE.get();
			}
		});
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
	}
	
	public void onUpdate() {
		possiblePagesInt[0] = getPageField(0);
		possiblePagesInt[1] = getPageField(1);
		possiblePagesInt[2] = getPageField(2);
	} 
	
	@Override
	public boolean canInteractWith(PlayerEntity player) {
		return this.tileFurnace.isUsableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < this.tileFurnace.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.tileFurnace.getSizeInventory(), this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (this.getSlot(0).isItemValid(itemstack1) && !this.getSlot(0).getHasStack()) {
				if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
					return ItemStack.EMPTY;
				}
			} else if (this.getSlot(1).isItemValid(itemstack1) && !this.getSlot(1).getHasStack()) {
				if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
					return ItemStack.EMPTY;
				}
			}else if (this.tileFurnace.getSizeInventory() <= 5 || !this.mergeItemStack(itemstack1, 5, this.tileFurnace.getSizeInventory(), false)) {
				return ItemStack.EMPTY;
			}
			if(itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
	
	public int getPaleopageAmount() {
		ItemStack itemstack = this.tileFurnace.getStackInSlot(1);
		return itemstack.isEmpty() || itemstack.getItem() != ItemInit.PALEOPAGE.get() ? 0 : itemstack.getCount();
	}
	
	public EnumPaleoPages[] getPossiblePages() {
		possiblePagesInt[0] = getPageField(0);
		possiblePagesInt[1] = getPageField(1);
		possiblePagesInt[2] = getPageField(2);
		EnumPaleoPages[] pages = new EnumPaleoPages[3];
		if (this.tileFurnace.getStackInSlot(0).getItem() == ItemInit.PALEOPEDIA.get()) {
			if (possiblePagesInt[0] < 0) {
				pages[0] = null;
			} else {
				pages[0] = EnumPaleoPages.values()[Math.min(EnumPaleoPages.values().length, possiblePagesInt[0])];
			}
			if(possiblePagesInt[1] < 0) {
				pages[1] = null;
			} else {
				pages[1] = EnumPaleoPages.values()[Math.min(EnumPaleoPages.values().length, possiblePagesInt[1])];
			}
			if(possiblePagesInt[2] < 0) {
				pages[2] = null;
			} else {
				pages[2] = EnumPaleoPages.values()[Math.min(EnumPaleoPages.values().length, possiblePagesInt[2])];
			}
		}
		return pages;
	}
	
	private int getPageField(int i) {
		if (PrehistoricFauna.PROXY.getReferencedTE() instanceof TileEntityPaleoscribe) {
			TileEntityPaleoscribe paleoscribe = (TileEntityPaleoscribe) PrehistoricFauna.PROXY.getReferencedTE();
			return paleoscribe.selectedPages[i] == null ? -1 : paleoscribe.selectedPages[i].ordinal();
		}
		return -1;
	}
	
	public boolean enchantItem(PlayerEntity player, int id) {
		possiblePagesInt[0] = getPageField(0);
		possiblePagesInt[1] = getPageField(1);
		possiblePagesInt[2] = getPageField(2);
		ItemStack itemstack = this.tileFurnace.getStackInSlot(0);
		ItemStack itemstack1 = this.tileFurnace.getStackInSlot(1);
		int i = 3;
		boolean didEnchant = false;
		if((itemstack1.isEmpty() || itemstack1.getCount() < i) && !player.isCreative()) {
			return false;
		} else if (this.possiblePagesInt[id] > 0 && !itemstack.isEmpty()) {
			EnumPaleoPages page = getPossiblePages()[MathHelper.clamp(id, 0, 2)];
			if (page != null) {
				if (itemstack.getItem() == ItemInit.PALEOPEDIA.get()) {
					didEnchant = EnumPaleoPages.addPage(page, itemstack);
					this.tileFurnace.setInventorySlotContents(0, itemstack);
					if(this.tileFurnace instanceof TileEntityPaleoscribe) {
						((TileEntityPaleoscribe) this.tileFurnace).randomizePages(itemstack, itemstack1);
					}
				}
				if (!player.isCreative() && didEnchant) {
					itemstack1.shrink(1);
					if (itemstack1.isEmpty()) {
						this.tileFurnace.setInventorySlotContents(1, ItemStack.EMPTY);
					}
				}
				this.tileFurnace.markDirty();
				this.onCraftMatrixChanged(this.tileFurnace);
				player.world.playSound(null, player.getPosition(), SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, player.world.rand.nextFloat() * 0.1F + 0.9F);
			}
			onUpdate();
			return true;
		} else {
			return false;
		}
	}
	

}
