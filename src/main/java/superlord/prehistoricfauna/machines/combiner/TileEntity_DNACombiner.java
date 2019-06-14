package superlord.prehistoricfauna.machines.combiner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class TileEntity_DNACombiner extends TileEntityLockable implements IInventory, ISidedInventory, ITickable {
	@SuppressWarnings("unused")
	private static final int[] SLOTS_TOP = new int[]{};
	private static final int[] SLOTS_BOTTOM = new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17};
	private static final int[] SLOTS_SIDES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
	private static final List<Integer> SLOTS_OUT = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17);

	public int analyzeFuelTime = 0;
	public int currentFuelTime = 100;
	public int analyzeTime = 0;
	private String customName;
	private NonNullList<ItemStack> stacks = NonNullList.withSize(5 + 27, ItemStack.EMPTY);
	private int rawIndex = -1;
	
	private static int getFuelTime(ItemStack stack) {
		return 100;
	}

	public static boolean isFuel(ItemStack stack) {
		return getFuelTime(stack) > 0;
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

	public void setCustomName(String name) {
		this.customName = name;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.stacks);
		this.analyzeFuelTime = compound.getShort("FuelTime");
		this.analyzeTime = compound.getShort("AnalyzeTime");
		this.currentFuelTime = 100;
		if (compound.hasKey("CustomName")) {
			this.customName = compound.getString("CustomName");
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);
		compound.setShort("FuelTime", (short) this.analyzeFuelTime);
		compound.setShort("AnalyzeTime", (short) this.analyzeTime);
		ItemStackHelper.saveAllItems(compound, this.stacks);
		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}
		return compound;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	public int getAnalyzeProgressScaled(int scale) {
		return this.analyzeTime * scale / 200;
	}

	public boolean isAnalyzing() {
		return this.analyzeFuelTime > 0;
	}

	@Override
	public void update() {
		boolean fueled = this.analyzeFuelTime > 0;
		boolean dirty = false;
		if (this.analyzeFuelTime > 0) {
			--this.analyzeFuelTime;
		}
		if (!this.world.isRemote) {
			if (this.analyzeFuelTime == 0 && canCombine()) {
				this.currentFuelTime = this.analyzeFuelTime = 100;
				dirty = true;
			}
			if (this.isAnalyzing() && canCombine()) {
				++this.analyzeTime;
				if (this.analyzeTime == 200) {
					this.analyzeTime = 0;
					this.combineDisks();
					dirty = true;
				}
			} else {
				this.analyzeTime = 0;
			}
			if (fueled != this.analyzeFuelTime > 0) {
				dirty = true;
				Block_DNACombiner.setState(this.analyzeFuelTime > 0, this.world, this.pos);
			}
		}
		if (dirty) {
			this.markDirty();
		}
	}
	
	private boolean canCombine() {
		ItemStack[] disks = {
				this.stacks.get(0),
				this.stacks.get(1),
				this.stacks.get(2),
				this.stacks.get(3) 
			};
		
		this.rawIndex = -1;
		
		if (this.stacks.get(4) != null && !this.stacks.get(4).isEmpty()) {
			return false;
		}
		
		return canCombine(disks);
	}

	public boolean canCombine(ItemStack[] stacks){
		return RecipeInstance_DNACombiner.instance().getDefinedRecipeResult(stacks) != null;
	}

	public TileEntity_DNACombiner combineDisks() {
		ItemStack[] disks = {
					this.stacks.get(0),
					this.stacks.get(1),
					this.stacks.get(2),
					this.stacks.get(3) 
				};
		
		if (this.canCombine(disks)) {
			ItemStack output = RecipeInstance_DNACombiner.instance().getRecipeResult(disks);
			
			if (output != null && !output.isEmpty()) {
				
				if (this.stacks.get(4) == null || this.stacks.get(4) == ItemStack.EMPTY) {
					this.stacks.set(4, output);
	
					this.stacks.get(0).shrink(1);
					this.stacks.get(1).shrink(1);
					this.stacks.get(2).shrink(1);
					this.stacks.get(3).shrink(1);
					return this;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) == this && player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return (slot != 1 || isFuel(stack));
	}

	@Override
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.analyzeFuelTime;
		case 1:
			return this.currentFuelTime;
		case 2:
			return this.analyzeTime;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.analyzeFuelTime = value;
			break;
		case 1:
			this.currentFuelTime = value;
			break;
		case 2:
			this.analyzeTime = value;
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 3;
	}

	@Override
	public void clear() {
		this.stacks.clear();
	}

	@Override
	public void openInventory(EntityPlayer player) {
		for (int slots = 12; slots > 8; --slots) {
			if (!this.stacks.get(slots).isEmpty()) {

			}
		}
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? SLOTS_BOTTOM : SLOTS_SIDES;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
		return this.isItemValidForSlot(index, stack);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return direction != EnumFacing.DOWN || index != 1;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : I18n.translateToLocal("tile.dna_combiner.name");
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new SPacketUpdateTileEntity(pos, 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager netManager, net.minecraft.network.play.server.SPacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);

	@SuppressWarnings("unchecked")
	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing)
	{
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else
				return (T) handlerTop;
		return super.getCapability(capability, facing);
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGuiID() {
		// TODO Auto-generated method stub
		return null;
	}
}
