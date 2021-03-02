package superlord.prehistoricfauna.entity.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.ContainerRegistry;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.item.PaleopediaItem;
import superlord.prehistoricfauna.util.EnumPaleoPages;

public class PaleoscribeContainer extends Container {
    private IInventory tileFurnace;
    private int[] possiblePagesInt = new int[3];
    private final IWorldPosCallable worldPosCallable;
    
    public PaleoscribeContainer(int i, PlayerInventory playerInventory) {
        this(i, new Inventory(2), playerInventory, new IntArray(0), IWorldPosCallable.DUMMY);
    }


    public PaleoscribeContainer(int id, IInventory furnaceInventory, PlayerInventory playerInventory, IIntArray vars, IWorldPosCallable worldPosCallable) {
        super(ContainerRegistry.PALEOSCRIBE_CONTAINER, id);
        this.tileFurnace = furnaceInventory;
        this.worldPosCallable = worldPosCallable;
        this.addSlot(new PaleoscribeSlot(playerInventory.player, furnaceInventory, 0, 15, 47) {
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
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.tileFurnace.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
           ItemStack itemstack1 = slot.getStack();
           itemstack = itemstack1.copy();
           if (index == 0) {
              if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
                 return ItemStack.EMPTY;
              }
           } else if (index == 1) {
              if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
                 return ItemStack.EMPTY;
              }
           } else if (itemstack1.getItem() == ItemInit.PALEOPAGE.get()) {
              if (!this.mergeItemStack(itemstack1, 1, 2, true)) {
                 return ItemStack.EMPTY;
              }
           } else {
              if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(itemstack1)) {
                 return ItemStack.EMPTY;
              }

              if (itemstack1.hasTag()) { // Forge: Fix MC-17431
                 ((Slot)this.inventorySlots.get(0)).putStack(itemstack1.split(1));
              } else if (!itemstack1.isEmpty()) {
                 this.inventorySlots.get(0).putStack(new ItemStack(itemstack1.getItem()));
                 itemstack1.shrink(1);
              }
           }

           if (itemstack1.isEmpty()) {
              slot.putStack(ItemStack.EMPTY);
           } else {
              slot.onSlotChanged();
           }

           if (itemstack1.getCount() == itemstack.getCount()) {
              return ItemStack.EMPTY;
           }

           slot.onTake(playerIn, itemstack1);
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

    private int getPageField(int i) {
        if(PrehistoricFauna.PROXY.getReferencedTE() instanceof PaleoscribeTileEntity){
            PaleoscribeTileEntity paleoscribe = (PaleoscribeTileEntity) PrehistoricFauna.PROXY.getReferencedTE();
            return paleoscribe.selectedPages[i] == null ? -1 : paleoscribe.selectedPages[i].ordinal();
        }
        return -1;
    }

    public boolean enchantItem(PlayerEntity playerIn, int id) {
        possiblePagesInt[0] = getPageField(0);
        possiblePagesInt[1] = getPageField(1);
        possiblePagesInt[2] = getPageField(2);
        ItemStack itemstack = this.tileFurnace.getStackInSlot(0);
        ItemStack itemstack1 = this.tileFurnace.getStackInSlot(1);
        int i = 3;
        boolean didEnchant = false;
        if ((itemstack1.isEmpty() || itemstack1.getCount() < i) && !playerIn.isCreative()) {
            return false;
        } else if (this.possiblePagesInt[id] > 0 && !itemstack.isEmpty()) {
            EnumPaleoPages page = getPossiblePages()[MathHelper.clamp(id, 0, 2)];
            if (page != null) {
                if (itemstack.getItem() == ItemInit.PALEOPEDIA.get()) {
                    didEnchant = EnumPaleoPages.addPage(page, itemstack);
                    this.tileFurnace.setInventorySlotContents(0, itemstack);
                    if (PrehistoricFauna.PROXY.getReferencedTE() instanceof PaleoscribeTileEntity) {
                        if(playerIn.world.isRemote){
                            PrehistoricFauna.sendMSGToServer(new MessageUpdatePaleoscribe(((PaleoscribeTileEntity)PrehistoricFauna.PROXY.getReferencedTE()).getPos().toLong(), 0, 0, 0, true, page.ordinal()));
                        }
                        ((PaleoscribeTileEntity) PrehistoricFauna.PROXY.getReferencedTE()).randomizePages(itemstack, itemstack1);
                    }
                }
                if (!playerIn.isCreative() && didEnchant) {
                    itemstack1.shrink(i);
                    if (itemstack1.isEmpty()) {
                        this.tileFurnace.setInventorySlotContents(1, ItemStack.EMPTY);
                    }
                }
                this.tileFurnace.markDirty();
                //this.xpSeed = playerIn.getXPSeed();
                this.onCraftMatrixChanged(this.tileFurnace);
                playerIn.world.playSound(null, playerIn.getPosition(), SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1.0F, playerIn.world.rand.nextFloat() * 0.1F + 0.9F);
            }
            onUpdate();
            return true;
        } else {
            return false;
        }
    }
 
    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.worldPosCallable.consume((p_217004_2_, p_217004_3_) -> {
           this.clearContainer(playerIn, playerIn.world, this.tileFurnace);
        });
     }
    
}