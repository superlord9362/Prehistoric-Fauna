package superlord.prehistoricfauna.common.entity.block;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.recipe.RecipePaleontologyTable;
import superlord.prehistoricfauna.common.items.FossilItem;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PaleontologyTableBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {

	public static final float RECIPE_DEFAULT_XP = 0.7F;
	public static final int WORK_TIME_MAX = 40;

	public static final int SLOT_FOSSIL = 0;
	public static final int[] SLOT_RESULTS = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private final LazyOptional<TileRecipeInventory> inventoryCapabilityExternal;
	private final LazyOptional<RangedWrapper> inventoryCapabilityExternalUp;
	private final LazyOptional<RangedWrapper> inventoryCapabilityExternalDown;
	private final LazyOptional<RangedWrapper> inventoryCapabilityExternalSides;
	private final TileRecipeInventory inventory;

	private int workTime = 0;
	private RecipePaleontologyTable recipe;
	private Component customName;

	private final ContainerData syncVariables = new ContainerData()
	{

		@Override
		public int get(int index)
		{
			return PaleontologyTableBlockEntity.this.workTime;
		}

		@Override
		public void set(int index, int value)
		{
			PaleontologyTableBlockEntity.this.workTime = value;
		}

		@Override
		public int getCount()
		{
			return 1;
		}
	};

    public PaleontologyTableBlockEntity(BlockPos pos, BlockState state) {
	{
        super(PFBlockEntities.PALEONTOLOGY_TABLE.get(), pos, state);

		this.inventory = new TileRecipeInventory(10);
		this.inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);
		this.inventoryCapabilityExternalUp = LazyOptional.of(() -> new RangedWrapper(this.inventory.itemStackHandler, 0, 1));
		this.inventoryCapabilityExternalSides = LazyOptional.of(() -> new RangedWrapper(this.inventory.itemStackHandler, 0, 1));
		this.inventoryCapabilityExternalDown = LazyOptional.of(() -> new RangedWrapper(this.inventory.itemStackHandler, 1, 10));
	}

	public int getWorkTime()
	{
		return this.workTime;
	}

	public void setWorkTime(int time)
	{
		this.workTime = time;
	}

	public boolean isWorking()
	{
		return this.workTime > 0;
	}

	public IIntArray getIntArray()
	{
		return this.syncVariables;
	}

	@OnlyIn(Dist.CLIENT)
	public int getWorkProgressionScaled(int size)
	{
		return size * this.syncVariables.get(0) / PaleontologyTableBlockEntity.WORK_TIME_MAX;
	}

	public ItemStack getFossilStack()
	{
		return this.inventory.getStackInSlot(PaleontologyTableBlockEntity.SLOT_FOSSIL);
	}

	public boolean isFossilStack(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof FossilItem;
	}

	public void updateRecipe()
	{
		if (!this.hasRecipe() || !this.hasInput())
		{
			Optional<Recipe<Container>> recipe = this.getCurrentRecipe();
			if (recipe.isPresent() && recipe.get() instanceof RecipePaleontologyTable)
				this.recipe = (RecipePaleontologyTable) recipe.get();
			else
				this.recipe = null;
		}
	}

	public boolean hasRecipe()
	{
		return this.recipe != null;
	}

	public boolean hasInput()
	{
		return this.recipe.matches(this.inventory, this.level);
	}

	@Override
	public void tick()
	{
		if (this.level != null && !this.level.isClientSide)
		{
			boolean hasWorkTimeLeft = false;

			if (!this.inventory.getStackInSlot(PaleontologyTableBlockEntity.SLOT_FOSSIL).isEmpty())
			{
				this.updateRecipe();

				if (this.hasRecipe() && this.hasInput() && this.hasFreeSlot(PaleontologyTableBlockEntity.SLOT_RESULTS))
				{
					hasWorkTimeLeft = true;
					if (this.workTime++ >= PaleontologyTableBlockEntity.WORK_TIME_MAX)
					{
						ItemStack resultStack = this.recipe.getCraftingResult(this.inventory);

						boolean foundSameResult = false;
						for (int index : PaleontologyTableBlockEntity.SLOT_RESULTS)
						{
							ItemStack nextResultStack = this.inventory.getStackInSlot(index);
							if (!nextResultStack.isEmpty() && ItemStack.areItemsEqual(resultStack, nextResultStack) && nextResultStack.getCount() + resultStack.getCount() < this.inventory.getSlotLimit(index))
							{
								nextResultStack.grow(resultStack.getCount());
								this.getFossilStack().shrink(1);
								foundSameResult = true;
								break;
							}
						}

						if (!foundSameResult)
						{
							this.inventory.setInventorySlotContents(this.getNextFreeSlot(PaleontologyTableBlockEntity.SLOT_RESULTS), resultStack);
							this.getFossilStack().shrink(1);
						}

						this.workTime = 0;
					}
				}
			}

			if (!hasWorkTimeLeft)
				this.workTime = 0;
		}
	}

	public void givePlayerXP(Player player, int totalOrbCount)
	{
		float experience = totalOrbCount * PaleontologyTableBlockEntity.RECIPE_DEFAULT_XP;
		if (experience < 1.0F)
		{
			int i = Mth.floor((float) totalOrbCount * experience);
			if (i < Mth.ceil((float) totalOrbCount * experience) && Math.random() < (double) ((float) totalOrbCount * experience - (float) i))
				++i;
			totalOrbCount = i;
		}

		while (totalOrbCount > 0)
		{
			int orbCount = ExperienceOrb.getExperienceValue(totalOrbCount);
			totalOrbCount -= orbCount;
			player.level.addFreshEntity(new ExperienceOrb(player.level, player.getX(), player.getY() + 0.5D, player.getZ() + 0.5D, orbCount));
		}
	}

	public Optional<Recipe<Container>> getCurrentRecipe()
	{
		return this.level.getRecipeManager().getRecipe(RecipePaleontologyTable.RECIPE_TYPE_PALEONTOLOGY_TABLE, this.inventory, this.level);
	}

	public TileRecipeInventory getInventory()
	{
		return this.inventory;
	}

	public ItemStackHandler getItemStackHandler()
	{
		return this.inventory.itemStackHandler;
	}

	public int getInventorySize()
	{
		return this.inventory.getSizeInventory();
	}

	public int getNextFreeSlot(int[] indexes)
	{
		for (int index : indexes)
			if (this.inventory.getStackInSlot(index).isEmpty())
				return index;

		return -1;
	}

	public int getNextFreeSlot()
	{
		for (int index = 0; index < this.inventory.getSizeInventory(); index++)
			if (this.inventory.getStackInSlot(index).isEmpty())
				return index;

		return -1;
	}

	public boolean hasFreeSlot(int[] indexes)
	{
		for (int index : indexes)
			if (this.inventory.getStackInSlot(index).isEmpty())
				return true;

		return false;
	}

	public boolean hasFreeSlot()
	{
		for (int index = 0; index < this.inventory.getSizeInventory(); index++)
			if (this.inventory.getStackInSlot(index).isEmpty())
				return true;

		return false;
	}

	public boolean isSlotFull(int index)
	{
		ItemStack itemStack = this.inventory.getStackInSlot(index);
		return itemStack.getCount() >= itemStack.getMaxStackSize() && itemStack.getCount() >= this.inventory.getSlotLimit(index);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> capability, @Nullable final Direction side)
	{
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			if (side == null)
				return this.inventoryCapabilityExternal.cast();
			switch (side)
			{
				case DOWN:
					return this.inventoryCapabilityExternalDown.cast();
				case UP:
					return this.inventoryCapabilityExternalUp.cast();
				case NORTH:
				case SOUTH:
				case WEST:
				case EAST:
					return this.inventoryCapabilityExternalSides.cast();
			}
		}
		return super.getCapability(capability, side);
	}

	public void setCustomName(Component name)
	{
		this.customName = name;
	}

	@Override
	@Nullable
	public Component getCustomName()
	{
		return this.customName;
	}

	@Override
	public Component getName()
	{
		return this.customName != null ? this.customName : this.getDefaultName();
	}

	@Override
	public Component getDisplayName()
	{
		return this.getName();
	}

	public Component getDefaultName()
	{
		return new TranslatableComponent("container." + PrehistoricFauna.MOD_ID + ".paleontology_table");
	}

	@Override
	public AbstractContainerMenu createMenu(int windowID, Inventory playerInventory, Player playerEntity)
	{
		return new PaleontologyTableContainer(windowID, playerInventory, this);
	}

	@Override
	public void read(BlockState state, CompoundTag compound)
	{
		super.read(state, compound);

		this.inventory.read(compound);
		this.workTime = compound.getShort("WorkTime");
		if (compound.contains("CustomName", Constants.NBT.TAG_STRING))
			this.customName = Component.Serializer.getComponentFromJson(compound.getString("CustomName"));
	}

	@Override
	public CompoundTag write(CompoundTag compound)
	{
		super.write(compound);

		this.inventory.write(compound);
		compound.putShort("WorkTime", (short) this.workTime);
		if (this.customName != null)
			compound.putString("CustomName", Component.Serializer.toJson(this.customName));

		return compound;
	}

	@Override
	public void remove()
	{
		super.remove();
		this.inventoryCapabilityExternal.invalidate();
		this.inventoryCapabilityExternalUp.invalidate();
		this.inventoryCapabilityExternalSides.invalidate();
		this.inventoryCapabilityExternalDown.invalidate();
	}

	public class TileRecipeInventory implements Container
	{
		protected final ItemStackHandler itemStackHandler;

		public TileRecipeInventory(int size)
		{
			this.itemStackHandler = new ItemStackHandler(size)
			{

				@Override
				protected void onContentsChanged(int slot)
				{
					super.onContentsChanged(slot);
					PaleontologyTableBlockEntity.this.markDirty();
				}
			};
		}

		public ItemStackHandler getItemStackHandler()
		{
			return this.itemStackHandler;
		}

		@Override
		public int getSizeInventory()
		{
			return this.itemStackHandler.getSlots();
		}

		@Override
		public ItemStack getStackInSlot(int slot)
		{
			return this.itemStackHandler.getStackInSlot(slot);
		}

		@Override
		public ItemStack decrStackSize(int slot, int count)
		{
			ItemStack stack = this.itemStackHandler.getStackInSlot(slot);
			return stack.isEmpty() ? ItemStack.EMPTY : stack.split(count);
		}

		@Override
		public void setInventorySlotContents(int slot, ItemStack stack)
		{
			this.itemStackHandler.setStackInSlot(slot, stack);
		}

		@Override
		public ItemStack removeStackFromSlot(int index)
		{
			ItemStack itemStack = getStackInSlot(index);
			if (itemStack.isEmpty())
				return ItemStack.EMPTY;
			setInventorySlotContents(index, ItemStack.EMPTY);
			return itemStack;
		}

		@Override
		public boolean isEmpty()
		{
			for (int i = 0; i < this.itemStackHandler.getSlots(); i++)
			{
				if (!this.itemStackHandler.getStackInSlot(i).isEmpty())
					return false;
			}
			return true;
		}

		@Override
		public boolean isItemValidForSlot(int slot, ItemStack stack)
		{
			return this.itemStackHandler.isItemValid(slot, stack);
		}

		@Override
		public void clear()
		{
			for (int i = 0; i < this.itemStackHandler.getSlots(); i++)
				this.itemStackHandler.setStackInSlot(i, ItemStack.EMPTY);
		}

		@Override
		public int getInventoryStackLimit()
		{
			return this.itemStackHandler.getSlots();
		}

		public int getSlotLimit(int index)
		{
			return this.itemStackHandler.getSlotLimit(index);
		}

		@Override
		public void markDirty()
		{
			PaleontologyTableBlockEntity.this.markDirty();
		}

		@Override
		public boolean isUsableByPlayer(Player player)
		{
			BlockPos pos = PaleontologyTableBlockEntity.this.getBlockPos();
			return player.distanceToSqr((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D;
		}

		public void read(CompoundTag tag)
		{
			this.itemStackHandler.deserializeNBT(tag.getCompound("IInventory"));
		}

		public CompoundTag write(CompoundTag tag)
		{
			tag.put("IInventory", this.itemStackHandler.serializeNBT());
			return tag;
		}
	}
}
