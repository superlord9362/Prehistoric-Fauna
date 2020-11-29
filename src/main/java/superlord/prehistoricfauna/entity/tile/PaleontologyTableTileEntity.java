package superlord.prehistoricfauna.entity.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Constants;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.TileEntityRegistry;
import superlord.prehistoricfauna.util.TableRecipes;

import javax.annotation.Nullable;
import java.util.Random;

public class PaleontologyTableTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider, IInventory, ISidedInventory {

	private static final int[] SLOTS_BOTTOM = new int[]{9, 10, 11, 12};
	private static final int[] SLOTS_SIDES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    public int cleaningFuelTime = 0;
    public int currentFuelTime = 100;
    public int cleaningTime = 0;
    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlerTop = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP);
    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlerBottom = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.DOWN);
	 private NonNullList<ItemStack> stacks = NonNullList.withSize(13, ItemStack.EMPTY);
    private int rawIndex = -1;
    protected final IIntArray tableData = new IIntArray() {
        public int get(int index) {
           switch(index) {
           case 0:
              return PaleontologyTableTileEntity.this.cleaningFuelTime;
           case 1:
              return PaleontologyTableTileEntity.this.currentFuelTime;
           case 2:
              return PaleontologyTableTileEntity.this.cleaningTime;
           default:
              return 0;
           }
        }

        public void set(int index, int value) {
           switch(index) {
           case 0:
        	   PaleontologyTableTileEntity.this.cleaningFuelTime = value;
              break;
           case 1:
        	   PaleontologyTableTileEntity.this.currentFuelTime = value;
              break;
           case 2:
        	   PaleontologyTableTileEntity.this.cleaningTime = value;
           }

        }

        public int size() {
           return 4;
        }
     };
	private ITextComponent customName;

    public PaleontologyTableTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public PaleontologyTableTileEntity() {
		this(TileEntityRegistry.PALEONTOLOGY_TABLE.get());
	}
	
	private static int getFuelTime(ItemStack stack) {
        return 100;
    }

    public static boolean isFuel(ItemStack stack) {
        return getFuelTime(stack) > 0;
    }

    public static boolean isCleanable(ItemStack stack) {
        return TableRecipes.getCleaningRecipeForItem(stack) != null;
    }
    
    @Override
    public int getSizeInventory() {
        return this.stacks.size();
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
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new PaleontologyTableContainer(windowID, playerInv, this);
	}
	
    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.stacks);
        this.cleaningFuelTime = compound.getShort("FuelTime");
        this.cleaningTime = compound.getShort("CleanTime");
        this.currentFuelTime = 100;
        if (compound.contains("CustomName", Constants.NBT.TAG_STRING)) {
			this.customName = ITextComponent.Serializer.fromJson(compound.getString("CustomName"));
		}
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound = super.write(compound);
        compound.putShort("FuelTime", (short) this.cleaningFuelTime);
        compound.putShort("CleanTime", (short) this.cleaningTime);
        ItemStackHelper.saveAllItems(compound, this.stacks);
        if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}
        return compound;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getCleaningProgressScaled(int scale) {
        return this.cleaningTime * scale / 200;
    }

    public boolean isCleaning() {
        return this.cleaningFuelTime > 0;
    }
    
    @Override
    public void tick() {
    	boolean fueled = this.cleaningFuelTime > 0;
        boolean dirty = false;
        if (this.cleaningFuelTime > 0) {
            --this.cleaningFuelTime;
        }
        if (!this.world.isRemote) {
            if (this.cleaningFuelTime == 0 && this.canClean()) {
                this.currentFuelTime = this.cleaningFuelTime = 100;
                dirty = true;
            }
            if (this.isCleaning() && this.canClean()) {
                ++this.cleaningTime;
                if (this.cleaningTime == 200) {
                    this.cleaningTime = 0;
                    this.cleanItem();
                    dirty = true;
                }
            } else {
                this.cleaningTime = 0;
            }
            if (fueled != this.cleaningFuelTime > 0) {
                dirty = true;
            }
        }
        if (dirty) {
            this.markDirty();
        }
    }
    
    private boolean canClean() {
        int spaceIndex = -1;
        this.rawIndex = -1;
        boolean hasPower = true;
        boolean flag = false;
        for (int slot = 0; slot < 9; ++slot) {
            if (!this.stacks.get(slot).isEmpty()) {
                if (isCleanable(this.stacks.get(slot))) {
                    this.rawIndex = slot;
                    flag = true;
                    break;
                }
            }
        }
        if (this.rawIndex == -1 || !flag) {
            return false;
        } else {
            for (int slot = 12; slot > 8; --slot) {
                if (this.stacks.get(slot).isEmpty()) {
                    spaceIndex = slot;
                    break;
                }
            }
            return spaceIndex != -1 && this.rawIndex != -1 && hasPower;
        }
    }

    public void cleanItem() {
        if (this.canClean()) {
            ItemStack output = ItemStack.EMPTY;
            Random random = this.world.rand;
            ItemStack input = this.stacks.get(rawIndex);
            output = TableRecipes.getCleaningRecipeForItem(input).generateOutput(new Random());
            if (output.getCount() > 1) {
                int maxCount = output.getCount() - 1;
                output.setCount(1 + random.nextInt(maxCount));
            }
            if (!output.isEmpty()) {
                for (int slot = 9; slot < 13; slot++) {
                    ItemStack stack = this.stacks.get(slot);
                    if (stack.isEmpty()) {
                        this.stacks.set(slot, output);
                        break;
                    } else {
                        if (stack.isItemEqual(output) && stack.getCount() + output.getCount() < 64) {
                            stack.setCount(stack.getCount() + output.getCount());
                            break;
                        }
                    }
                }
            }
            input.shrink(1);
        }
    }
    
    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return this.world.getTileEntity(this.pos) == this && player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
    }
    
    @Override
    public void clear() {
        this.stacks.clear();
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return side == Direction.DOWN ? SLOTS_BOTTOM : SLOTS_SIDES;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, Direction direction) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return direction != Direction.DOWN || index != 1;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return (slot != 1 || isFuel(stack));
    }
    
    public void setCustomName(ITextComponent name) {
		this.customName = name;
	}

	public ITextComponent getName() {
		return this.customName != null ? this.customName : this.getDefaultName();
	}

	private ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + PrehistoricFauna.MODID + ".paleontology_table");
	}

	@Override
	public ITextComponent getDisplayName() {
		return this.getName();
	}

	@Nullable
	public ITextComponent getCustomName() {
		return this.customName;
	}

    @Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return new SUpdateTileEntityPacket(this.pos, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundNBT nbt) {
		this.read(nbt);
	}

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
		if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (facing == Direction.UP)
				return handlerTop[0].cast();
			else
				return handlerBottom[1].cast();
		}
	      return super.getCapability(capability, facing);
	}
	
	@Override
    public ItemStack getStackInSlot(int slot) {
        return this.stacks.get(slot);
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        return ItemStackHelper.getAndSplit(this.stacks, slot, amount);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.stacks, index);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.stacks.set(slot, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }

}
