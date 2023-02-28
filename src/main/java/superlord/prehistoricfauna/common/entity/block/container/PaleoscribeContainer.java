package superlord.prehistoricfauna.common.entity.block.container;

import org.jetbrains.annotations.NotNull;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;
import superlord.prehistoricfauna.common.entity.block.inventory.PaleoscribeSlot;
import superlord.prehistoricfauna.common.entity.block.messages.MessageUpdatePaleoscribe;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFContainers;
import superlord.prehistoricfauna.init.PFItems;

public class PaleoscribeContainer extends AbstractContainerMenu {
	private final Container tileFurnace;
    private final int[] possiblePagesInt = new int[3];

    public PaleoscribeContainer(int i, Inventory playerInventory) {
        this(i, new SimpleContainer(2), playerInventory, new SimpleContainerData(0));
    }


    public PaleoscribeContainer(int id, Container furnaceInventory, Inventory playerInventory, ContainerData vars) {
        super(PFContainers.PALEOSCRIBE.get(), id);
        this.tileFurnace = furnaceInventory;
        this.addSlot(new PaleoscribeSlot(furnaceInventory, 0, 15, 47) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return super.mayPlace(stack) && !stack.isEmpty() && stack.getItem() instanceof PaleopediaItem;
            }
        });
        this.addSlot(new Slot(furnaceInventory, 1, 35, 47) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return super.mayPlace(stack) && !stack.isEmpty() && stack.getItem() == PFItems.PALEOPAGE.get();
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

    private static int getPageField(int i) {
        if (PrehistoricFauna.PROXY.getReferencedBE() instanceof PaleoscribeBlockEntity) {
        	PaleoscribeBlockEntity paleoscribe = (PaleoscribeBlockEntity) PrehistoricFauna.PROXY.getReferencedBE();
            return paleoscribe.selectedPages[i] == null ? -1 : paleoscribe.selectedPages[i].ordinal();
        }
        return -1;
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
    }

    public void onUpdate() {
        possiblePagesInt[0] = getPageField(0);
        possiblePagesInt[1] = getPageField(1);
        possiblePagesInt[2] = getPageField(2);
    }

    @Override
    public boolean stillValid(@NotNull Player playerIn) {
        return this.tileFurnace.stillValid(playerIn);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.tileFurnace.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.tileFurnace.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(0).mayPlace(itemstack1) && !this.getSlot(0).hasItem()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }

            } else if (this.getSlot(1).mayPlace(itemstack1) && !this.getSlot(1).hasItem()) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.tileFurnace.getContainerSize() <= 5 || !this.moveItemStackTo(itemstack1, 5, this.tileFurnace.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemstack;
    }

    public int getManuscriptAmount() {
        ItemStack itemstack = this.tileFurnace.getItem(1);
        return itemstack.isEmpty() || itemstack.getItem() != PFItems.PALEOPAGE.get() ? 0 : itemstack.getCount();
    }

    public EnumPaleoPages[] getPossiblePages() {
        possiblePagesInt[0] = getPageField(0);
        possiblePagesInt[1] = getPageField(1);
        possiblePagesInt[2] = getPageField(2);
        EnumPaleoPages[] pages = new EnumPaleoPages[3];
        if (this.tileFurnace.getItem(0).getItem() == PFItems.PALEOPEDIA.get()) {
            if (possiblePagesInt[0] < 0) {
                pages[0] = null;
            } else {
                pages[0] = EnumPaleoPages.values()[Math.min(EnumPaleoPages.values().length, possiblePagesInt[0])];
            }
            if (possiblePagesInt[1] < 0) {
                pages[1] = null;
            } else {
                pages[1] = EnumPaleoPages.values()[Math.min(EnumPaleoPages.values().length, possiblePagesInt[1])];
            }
            if (possiblePagesInt[2] < 0) {
                pages[2] = null;
            } else {
                pages[2] = EnumPaleoPages.values()[Math.min(EnumPaleoPages.values().length, possiblePagesInt[2])];
            }
        }
        return pages;
    }

    @Override
    public boolean clickMenuButton(Player playerIn, int id) {
        possiblePagesInt[0] = getPageField(0);
        possiblePagesInt[1] = getPageField(1);
        possiblePagesInt[2] = getPageField(2);
        ItemStack itemstack = this.tileFurnace.getItem(0);
        ItemStack itemstack1 = this.tileFurnace.getItem(1);
        int i = 3;

        if (!playerIn.level.isClientSide && !playerIn.isCreative()) {
            itemstack1.shrink(i);
            if (itemstack1.isEmpty()) {
                this.tileFurnace.setItem(1, ItemStack.EMPTY);
            }
            return false;
        }

        if ((itemstack1.isEmpty() ||
            itemstack1.getCount() < i ||
            itemstack1.getItem() != PFItems.PALEOPAGE.get())
            && !playerIn.isCreative()) {
            return false;
        } else if (this.possiblePagesInt[id] > 0 && !itemstack.isEmpty()) {
            EnumPaleoPages page = getPossiblePages()[Mth.clamp(id, 0, 2)];
            if (page != null) {
                if (itemstack.getItem() == PFItems.PALEOPEDIA.get()) {
                    this.tileFurnace.setItem(0, itemstack);
                    if (PrehistoricFauna.PROXY.getReferencedBE() instanceof PaleoscribeBlockEntity) {
                        if (playerIn.level.isClientSide) {
                        	PrehistoricFauna.sendMSGToServer(new MessageUpdatePaleoscribe(PrehistoricFauna.PROXY.getReferencedBE().getBlockPos().asLong(), 0, 0, 0, true, page.ordinal()));
                        }
                        ((PaleoscribeBlockEntity) PrehistoricFauna.PROXY.getReferencedBE()).randomizePages(itemstack, itemstack1);
                    }
                }

                this.tileFurnace.setChanged();
                //this.xpSeed = playerIn.getXPSeed();
                this.slotsChanged(this.tileFurnace);
                playerIn.level.playSound(null, playerIn.blockPosition(), SoundEvents.BOOK_PAGE_TURN, SoundSource.BLOCKS, 1.0F, playerIn.level.random.nextFloat() * 0.1F + 0.9F);
            }
            onUpdate();
            return true;
        } else {
            return false;
        }
    }
    
}