package superlord.prehistoricfauna.common.entity.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;

public class PaleoscribeBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsSides = new int[]{1};
    private static final int[] slotsBottom = new int[]{0};
    private static final Random RANDOM = new Random();
    private static final ArrayList<EnumPaleoPages> EMPTY_LIST = new ArrayList<>();
    public final ContainerData furnaceData = new ContainerData() {
        @Override
        public int get(int index) {
            return 0;
        }

        @Override
        public void set(int index, int value) {

        }

        @Override
        public int getCount() {
            return 0;
        }
    };
    public float pageFlip;
    public float pageFlipPrev;
    public float pageHelp1;
    public float pageHelp2;
    public EnumPaleoPages[] selectedPages = new EnumPaleoPages[3];
    net.minecraftforge.items.IItemHandler handlerUp = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.UP);
    net.minecraftforge.items.IItemHandler handlerDown = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.DOWN);
    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN);
    private Random localRand = new Random();
    private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);

    public PaleoscribeBlockEntity() {
        super(PFTileEntities.PALEOSCRIBE.get());
    }

    @Override
    public void tick() {
        float f1 = this.pageHelp1;
        do {
            this.pageHelp1 += RANDOM.nextInt(4) - RANDOM.nextInt(4);
        } while (f1 == this.pageHelp1);
        this.pageFlipPrev = this.pageFlip;
        float f = (this.pageHelp1 - this.pageFlip) * 0.04F;
        float f3 = 0.02F;
        f = Mth.clamp(f, -f3, f3);
        this.pageHelp2 += (f - this.pageHelp2) * 0.9F;
        this.pageFlip += this.pageHelp2;
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.stacks.get(index);
    }

    @SuppressWarnings({ "rawtypes", "unused" })
	private boolean canAddPage() {
        if (this.stacks.get(0).isEmpty()) {
            return false;
        } else {
            ItemStack itemstack = this.stacks.get(0).copy();

            if (itemstack.isEmpty()) {
                return false;
            }
            if (itemstack.getItem() != PFItems.PALEOPEDIA.get()) {
                return false;
            }

            if (itemstack.getItem() == PFItems.PALEOPEDIA.get()) {
                List list = EnumPaleoPages.possiblePages(itemstack);
                if (list == null || list.isEmpty()) {
                    return false;
                }
            }
            if (this.stacks.get(2).isEmpty())
                return true;
            int result = stacks.get(2).getCount() + itemstack.getCount();
            return result <= getInventoryStackLimit() && result <= this.stacks.get(2).getMaxStackSize();
        }
    }
    
    public boolean hasPaleopedia() {
        if (this.getStackInSlot(0).getItem() == PFItems.PALEOPEDIA.get()) {
        	System.out.println("Paleopedia");
        	return true;
        } else {
        	return false;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<EnumPaleoPages> getPossiblePages() {
        List list = EnumPaleoPages.possiblePages(this.stacks.get(0));
        if (list != null && !list.isEmpty()) {
            return (ArrayList<EnumPaleoPages>) list;
        }
        return EMPTY_LIST;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (!this.stacks.get(index).isEmpty()) {
            ItemStack itemstack;

            if (this.stacks.get(index).getCount() <= count) {
                itemstack = this.stacks.get(index);
                this.stacks.set(index, ItemStack.EMPTY);
                return itemstack;
            } else {
                itemstack = this.stacks.get(index).split(count);

                if (this.stacks.get(index).getCount() == 0) {
                    this.stacks.set(index, ItemStack.EMPTY);
                }

                return itemstack;
            }
        } else {
            return ItemStack.EMPTY;
        }
    }

    public ItemStack getStackInSlotOnClosing(int index) {
        if (!this.stacks.get(index).isEmpty()) {
            ItemStack itemstack = this.stacks.get(index);
            this.stacks.set(index, ItemStack.EMPTY);
            return itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        boolean flag = !stack.isEmpty() && stack.isItemEqual(this.stacks.get(index)) && ItemStack.areItemStackTagsEqual(stack, this.stacks.get(index));
        this.stacks.set(index, stack);

        if (!stack.isEmpty() && stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
        if (index == 0 && !flag) {
            this.markDirty();
            selectedPages = randomizePages(getStackInSlot(0), getStackInSlot(1));
        }
    }

    public EnumPaleoPages[] randomizePages(ItemStack paleopedia, ItemStack paleopage) {
        if (!world.isRemote) {
            if (paleopedia.getItem() == PFItems.PALEOPEDIA.get()) {
                List<EnumPaleoPages> possibleList = getPossiblePages();
                localRand.setSeed(this.world.getGameTime());
                Collections.shuffle(possibleList, localRand);
                if (possibleList.size() > 0) {
                    selectedPages[0] = possibleList.get(0);
                } else {
                    selectedPages[0] = null;
                }
                if (possibleList.size() > 1) {
                    selectedPages[1] = possibleList.get(1);
                } else {
                    selectedPages[1] = null;
                }
                if (possibleList.size() > 2) {
                    selectedPages[2] = possibleList.get(2);
                } else {
                    selectedPages[2] = null;
                }
            }
            int page1 = selectedPages[0] == null ? -1 : selectedPages[0].ordinal();
            int page2 = selectedPages[1] == null ? -1 : selectedPages[1].ordinal();
            int page3 = selectedPages[2] == null ? -1 : selectedPages[2].ordinal();
            PrehistoricFauna.sendMSGToAll(new MessageUpdatePaleoscribe(pos.toLong(), page1, page2, page3, false, 0));
        }
        return selectedPages;
    }

    @Override
    public void read(BlockState state, CompoundTag compound) {
        super.read(state, compound);
        this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.stacks);

    }
    
    public void read2(BlockState blockstate, CompoundTag compound) {
        super.read(blockstate, compound);
        this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.stacks);

    }

    @Override
    public CompoundTag write(CompoundTag compound) {
        super.write(compound);
        ItemStackHelper.saveAllItems(compound, this.stacks);
        return compound;
    }

    @Override
    public void openInventory(Player player) {
    }

    @Override
    public void closeInventory(Player player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(Player player) {
        return true;
    }

    @Override
    public void clear() {
        this.stacks.clear();
    }

    public ITextComponent getName() {
        return new TranslationTextComponent("block.prehistoricfauna.paleoscribe");
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return side == Direction.DOWN ? slotsBottom : (side == Direction.UP ? slotsTop : slotsSides);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public String getGuiID() {
        return "prehistoricfauna:paleoscribe";
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        read2(this.getBlockState(), packet.getNbtCompound());
    }

    public CompoundTag getUpdateTag() {
        return this.write(new CompoundTag());
    }

    @Override
    protected ITextComponent getDefaultName() {
        return getName();
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.stacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[0].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, Player player) {
        return new PaleoscribeContainer(id, this, playerInventory, furnaceData, IWorldPosCallable.DUMMY);
    }


}