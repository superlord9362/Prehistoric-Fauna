package superlord.prehistoricfauna.common.entity.block;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.container.PaleontologyTableMenu;
import superlord.prehistoricfauna.common.entity.block.recipe.RecipePaleontologyTable;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFTags;

public class PaleontologyTableBlockEntity extends BlockEntity implements MenuProvider {

	public PaleontologyTableBlockEntity(BlockPos pos, BlockState state) {
		super(PFBlockEntities.PALEONTOLOGY_TABLE.get(), pos, state);
		this.data = new ContainerData() {
			public int get(int index) {
				switch (index) {
				case 0: return PaleontologyTableBlockEntity.this.progress;
				case 1: return PaleontologyTableBlockEntity.this.maxProgress;
				default: return 0;
				}
			}
			public void set(int index, int value) {
				switch (index) {
				case 0: PaleontologyTableBlockEntity.this.progress = value; break;
				case 1: PaleontologyTableBlockEntity.this.maxProgress = value; break;
				}
			}
			public int getCount() {
				return 10;
			}
		};
	}
	
	private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		}
		
		@Override
		public int getSlotLimit(int slot) {
			return 64;
		}
	};
	
	private IItemHandler hopperHandler = new IItemHandler() {
		@Override
		public int getSlots() {
			return itemHandler.getSlots();
		}
		
		@Nonnull
		@Override
		public ItemStack getStackInSlot(int slot) {
			return itemHandler.getStackInSlot(slot);
		}
		
		@Nonnull
		@Override
		public ItemStack extractItem(int slot, int amount, boolean simulate) {
			if (slot != 0) {
				return itemHandler.extractItem(slot, amount, simulate);
			}
			return ItemStack.EMPTY;
		}
		
		@Nonnull
		@Override
		public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
			if (stack.isEmpty()) {
				return stack;
			}
			if (slot == 0 && stack.is(PFTags.FOSSILS)) {
				return itemHandler.insertItem(slot, stack, simulate);
			}
			return stack;
		}
		
		@Override
		public int getSlotLimit(int slot) {
			return itemHandler.getSlotLimit(slot);
		}
		
		@Override
		public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
			return itemHandler.isItemValid(slot, stack);
		}
	};
	
	private LazyOptional<IItemHandler> lazyItemHandlerOptional = LazyOptional.of(() -> itemHandler);
	private LazyOptional<IItemHandler> hopperHandlerOptional = LazyOptional.of(() -> hopperHandler);
	
	protected final ContainerData data;
	private int progress = 0;
	private int maxProgress = 40;
	
	@Override
	public Component getDisplayName() {
		return new TranslatableComponent("container." + PrehistoricFauna.MOD_ID + ".paleontology_table");
	}
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (side == null) {
				return lazyItemHandlerOptional.cast();
			} else {
				return hopperHandlerOptional.cast();
			}
		}
		return super.getCapability(cap, side);
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		lazyItemHandlerOptional = LazyOptional.of(() -> itemHandler);
		hopperHandlerOptional = LazyOptional.of(() -> hopperHandler);
	}
	
	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandlerOptional.invalidate();
		hopperHandlerOptional.invalidate();
	}
	
	@Override
	protected void saveAdditional(@Nonnull CompoundTag tag) {
		tag.put("inventory", itemHandler.serializeNBT());
		tag.putInt("progress", progress);
		super.saveAdditional(tag);
	}
	
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		itemHandler.deserializeNBT(tag.getCompound("inventory"));
		progress = tag.getInt("progress");
	}
	
	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		}
		Containers.dropContents(level, worldPosition, inventory);
	}
	
	public static void tick(Level world, BlockPos pos, BlockState state, PaleontologyTableBlockEntity blockEntity) {
		if (hasRecipe(blockEntity)) {
			blockEntity.progress = Math.min(blockEntity.progress + 1, blockEntity.maxProgress);
			setChanged(world, pos, state);
			if (blockEntity.progress >= blockEntity.maxProgress && !world.isClientSide()) {
				craftItem(blockEntity);
			}
		} else {
			blockEntity.resetProgress();
			setChanged(world, pos, state);
		}
	}
	
	private static boolean hasRecipe(PaleontologyTableBlockEntity entity) {
		Level world = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}
		Optional<RecipePaleontologyTable> match = world.getRecipeManager().getRecipeFor(RecipePaleontologyTable.Type.INSTANCE, inventory, world);
		return match.isPresent() && canInsertAmountIntoOutputSlot(inventory);
	}
	
	@SuppressWarnings("unused")
	private static void craftItem(PaleontologyTableBlockEntity entity) {
		Level world = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}
		Optional<RecipePaleontologyTable> match = world.getRecipeManager().getRecipeFor(RecipePaleontologyTable.Type.INSTANCE, inventory, world);
		if (match.isPresent()) {
			ItemStack result = match.get().assemble(inventory);
			entity.itemHandler.extractItem(0, 1, false);
			boolean success = false;
			for (int i = 1, n = entity.itemHandler.getSlots(); i < n; i++) {
				if (entity.itemHandler.insertItem(i, result, false).isEmpty()) {
					System.out.println("Hello!");
					success = true;
					break;
				}
			}
			entity.resetProgress();
		}
	}
	
	private void resetProgress() {
		this.progress = 0;
	}
	
	private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
		for (int slot = 1, n = inventory.getContainerSize(); slot < n; slot++) {
			if (inventory.getItem(slot).isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
		return new PaleontologyTableMenu(containerId, inventory, this, this.data);
	}
	
}
