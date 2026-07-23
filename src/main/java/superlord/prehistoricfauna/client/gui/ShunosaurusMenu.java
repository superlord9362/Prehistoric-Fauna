package superlord.prehistoricfauna.client.gui;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Shunosaurus;
import superlord.prehistoricfauna.init.PFContainers;
public class ShunosaurusMenu extends AbstractContainerMenu {
    public static final int VISIBLE_ROWS = 3;
    private final Container shunosaurusContainer;
    private final Shunosaurus shunosaurus;
    private final java.util.List<ChestSlotWrapper> chestSlotWrappers = new java.util.ArrayList<>();
    private final int chestColumns;
    private int totalChestRows;
    private int scrollRows;
    
    public Shunosaurus getShunosaurus() {
        return this.shunosaurus;
    }
    
    public int getScrollRows() {
        return this.scrollRows;
    }
    
    public int getTotalChestRows() {
        return this.totalChestRows;
    }
    
    public int getChestColumns() {
        return this.chestColumns;
    }
    
    public ShunosaurusMenu(int p_39656_, Inventory p_39657_, Container p_39658_, final Shunosaurus p_39659_) {
        super(PFContainers.SHUNOSAURUS.get(), p_39656_);
        this.shunosaurusContainer = p_39658_;
        this.shunosaurus = p_39659_;
        p_39658_.startOpen(p_39657_.player);
        this.addSlot(new Slot(p_39658_, 0, 8, 18) {
            public boolean mayPlace(ItemStack p_39690_) {
                return p_39690_.getItem() == Items.SADDLE;
            }
            public boolean isActive() {
                return true;
            }
            public int getMaxStackSize() {
                return 1;
            }
        });
        this.chestColumns = p_39659_.getInventoryColumns();
        int containerSize = p_39658_.getContainerSize();
        int chestSlotCount = Math.max(0, containerSize - 1);
        this.totalChestRows = this.chestColumns > 0 ? (chestSlotCount + this.chestColumns - 1) / this.chestColumns : 0;
        int visibleRowCount = Math.min(VISIBLE_ROWS, this.totalChestRows);
        for (int row = 0; row < visibleRowCount; ++row) {
            for (int col = 0; col < this.chestColumns; ++col) {
                int dataIndex = 1 + col + row * this.chestColumns;
                ChestSlotWrapper wrapper = new ChestSlotWrapper(p_39658_, dataIndex, 80 + col * 18, 18 + row * 18, containerSize);
                this.chestSlotWrappers.add(wrapper);
                this.addSlot(wrapper);
            }
        }
        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(p_39657_, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18 + -18));
            }
        }
        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(p_39657_, j1, 8 + j1 * 18, 142));
        }
    }
    
    public void setScrollRows(int rows) {
        int maxScroll = Math.max(0, this.totalChestRows - VISIBLE_ROWS);
        int clamped = Math.max(0, Math.min(rows, maxScroll));
        if (clamped != this.scrollRows) {
            this.scrollRows = clamped;
            this.updateChestSlots();
        }
    }
    
    private void updateChestSlots() {
        for (int i = 0; i < this.chestSlotWrappers.size(); ++i) {
            ChestSlotWrapper wrapper = this.chestSlotWrappers.get(i);
            int row = i / this.chestColumns;
            int col = i % this.chestColumns;
            int dataRow = row + this.scrollRows;
            int dataIndex = 1 + col + dataRow * this.chestColumns;
            wrapper.setTargetIndex(dataIndex);
        }
        this.broadcastChanges();
    }
    
    public boolean stillValid(Player p_39661_) {
        return !this.shunosaurus.hasInventoryChanged(this.shunosaurusContainer) && this.shunosaurusContainer.stillValid(p_39661_) && this.shunosaurus.isAlive() && this.shunosaurus.distanceTo(p_39661_) < 8.0F;
    }
    
    public ItemStack quickMoveStack(Player p_39665_, int p_39666_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_39666_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int chestWindowStart = 1;
            int chestWindowEnd = 1 + this.chestSlotWrappers.size();
            if (p_39666_ >= chestWindowStart && p_39666_ < chestWindowEnd) {
                if (!this.moveItemStackTo(itemstack1, chestWindowEnd, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(0).mayPlace(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.chestSlotWrappers.isEmpty() || !this.moveItemStackTo(itemstack1, chestWindowStart, chestWindowEnd, false)) {
                int j = chestWindowEnd + 27;
                int k = j + 9;
                if (p_39666_ >= j && p_39666_ < k) {
                    if (!this.moveItemStackTo(itemstack1, chestWindowEnd, j, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_39666_ >= chestWindowEnd && p_39666_ < j) {
                    if (!this.moveItemStackTo(itemstack1, j, k, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(itemstack1, j, k, false)) {
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
        this.shunosaurusContainer.stopOpen(p_39663_);
    }
    
    private static class ChestSlotWrapper extends Slot {
        private final Container backing;
        private final int containerSize;
        private int targetIndex;
        
        ChestSlotWrapper(Container backing, int initialIndex, int x, int y, int containerSize) {
            super(backing, initialIndex, x, y);
            this.backing = backing;
            this.targetIndex = initialIndex;
            this.containerSize = containerSize;
        }
        
        void setTargetIndex(int index) {
            this.targetIndex = index;
        }
        
        private boolean isValidTarget() {
            return this.targetIndex >= 1 && this.targetIndex < this.containerSize;
        }
        
        public ItemStack getItem() {
            return this.isValidTarget() ? this.backing.getItem(this.targetIndex) : ItemStack.EMPTY;
        }
        
        public boolean hasItem() {
            return this.isValidTarget() && !this.backing.getItem(this.targetIndex).isEmpty();
        }
        
        public void set(ItemStack stack) {
            if (this.isValidTarget()) {
                this.backing.setItem(this.targetIndex, stack);
                this.setChanged();
            }
        }
        
        public void setByPlayer(ItemStack stack) {
            this.set(stack);
        }
        
        public void setChanged() {
            if (this.isValidTarget()) {
                this.backing.setChanged();
            }
        }
        
        public int getMaxStackSize() {
            return this.isValidTarget() ? this.backing.getMaxStackSize() : 64;
        }
        
        public int getMaxStackSize(ItemStack stack) {
            return Math.min(this.getMaxStackSize(), stack.getMaxStackSize());
        }
        
        public boolean mayPlace(ItemStack stack) {
            return this.isValidTarget() && this.backing.canPlaceItem(this.targetIndex, stack);
        }
        
        public boolean mayPickup(Player player) {
            return this.isValidTarget();
        }
        
        public boolean isActive() {
            return this.isValidTarget();
        }
        
        public ItemStack remove(int amount) {
            if (!this.isValidTarget()) {
                return ItemStack.EMPTY;
            }
            return this.backing.removeItem(this.targetIndex, amount);
        }
    }
    
    public boolean clickMenuButton(Player player, int id) {
    	this.setScrollRows(id);
    	return true;
    }
}