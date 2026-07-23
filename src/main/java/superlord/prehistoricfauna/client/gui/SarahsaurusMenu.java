package superlord.prehistoricfauna.client.gui;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.init.PFContainers;

public class SarahsaurusMenu extends AbstractContainerMenu {
	private final Container sarahsaurusContainer;
	private final Sarahsaurus sarahsaurus;

	public Sarahsaurus getSarahsaurus() {
		return this.sarahsaurus;
	}

	public SarahsaurusMenu(int p_39656_, Inventory p_39657_, Container p_39658_, final Sarahsaurus p_39659_) {
		super(PFContainers.SARAHSAURUS.get(), p_39656_);
		this.sarahsaurusContainer = p_39658_;
		this.sarahsaurus = p_39659_;
		p_39658_.startOpen(p_39657_.player);
		this.addSlot(new Slot(p_39658_, 0, 8, 18) {
			public boolean mayPlace(ItemStack p_39690_) {
				return p_39659_.isCarpet(p_39690_);
			}

			public boolean isActive() {
				return true;
			}

			public int getMaxStackSize() {
				return 1;
			}
		});
		if (this.hasChest(p_39659_)) {
			for(int k = 0; k < 3; ++k) {
				for(int l = 0; l < ((Sarahsaurus)p_39659_).getInventoryColumns(); ++l) {
					this.addSlot(new Slot(p_39658_, 2 + l + k * ((Sarahsaurus)p_39659_).getInventoryColumns(), 80 + l * 18, 18 + k * 18));
				}
			}
		}

		for(int i1 = 0; i1 < 3; ++i1) {
			for(int k1 = 0; k1 < 9; ++k1) {
				this.addSlot(new Slot(p_39657_, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18 + -18));
			}
		}

		for(int j1 = 0; j1 < 9; ++j1) {
			this.addSlot(new Slot(p_39657_, j1, 8 + j1 * 18, 142));
		}

	}

	public boolean stillValid(Player p_39661_) {
		return !this.sarahsaurus.hasInventoryChanged(this.sarahsaurusContainer) && this.sarahsaurusContainer.stillValid(p_39661_) && this.sarahsaurus.isAlive() && this.sarahsaurus.distanceTo(p_39661_) < 8.0F;
	}

	private boolean hasChest(Sarahsaurus p_150578_) {
		return p_150578_ instanceof Sarahsaurus && ((Sarahsaurus)p_150578_).hasChest();
	}

	public ItemStack quickMoveStack(Player p_39665_, int p_39666_) {
	    ItemStack itemstack = ItemStack.EMPTY;
	    Slot slot = this.slots.get(p_39666_);
	    if (slot != null && slot.hasItem()) {
	        ItemStack itemstack1 = slot.getItem();
	        itemstack = itemstack1.copy();
	        int i = this.sarahsaurusContainer.getContainerSize();
	        if (p_39666_ < i) {
	            if (!this.moveItemStackTo(itemstack1, i, this.slots.size(), true)) {
	                return ItemStack.EMPTY;
	            }
	        } else if (this.getSlot(0).mayPlace(itemstack1)) {
	            if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
	                return ItemStack.EMPTY;
	            }
	        } else if (i <= 2 || !this.moveItemStackTo(itemstack1, 2, i, false)) {
	            int j = i + 27;
	            int k = j + 9;
	            if (p_39666_ >= j && p_39666_ < k) {
	                if (!this.moveItemStackTo(itemstack1, i, j, false)) {
	                    return ItemStack.EMPTY;
	                }
	            } else if (p_39666_ >= i && p_39666_ < j) {
	                if (!this.moveItemStackTo(itemstack1, j, k, false)) {
	                    return ItemStack.EMPTY;
	                }
	            } else if (!this.moveItemStackTo(itemstack1, j, j, false)) {
	                return ItemStack.EMPTY;
	            }
	            return ItemStack.EMPTY;
	        }
	        if (itemstack1.isEmpty()) {
	            slot.setByPlayer(ItemStack.EMPTY);
	        } else {
	            slot.setChanged();
	        }
	    }
	    return itemstack;
	}

	public void removed(Player p_39663_) {
		super.removed(p_39663_);
		this.sarahsaurusContainer.stopOpen(p_39663_);
	}
}