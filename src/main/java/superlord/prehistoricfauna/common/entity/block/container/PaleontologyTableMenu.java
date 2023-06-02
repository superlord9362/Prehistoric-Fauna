package superlord.prehistoricfauna.common.entity.block.container;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import superlord.prehistoricfauna.common.entity.block.PaleontologyTableBlockEntity;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFContainers;

public class PaleontologyTableMenu extends AbstractContainerMenu {
	
	private final PaleontologyTableBlockEntity blockEntity;
	private final Level world;
	private final ContainerData data;
	
	public PaleontologyTableMenu(int containerId, Inventory inventory, FriendlyByteBuf extraData) {
		this(containerId, inventory, inventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(10));
	}
	
	public PaleontologyTableMenu(int containerId, Inventory inventory, BlockEntity entity, ContainerData data) {
		super(PFContainers.PALEONTOLOGY_TABLE.get(), containerId);
		checkContainerSize(inventory, 10);
		blockEntity = ((PaleontologyTableBlockEntity)entity);
		this.world = inventory.player.level;
		this.data = data;
		
		addPlayerInventory(inventory);
		addPlayerHotbar(inventory);
		
		this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
			this.addSlot(new SlotItemHandler(handler, 0, 36, 42));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 1, 92, 23));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 2, 92, 41));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 3, 92, 59));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 4, 110, 23));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 5, 110, 41));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 6, 110, 59));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 7, 128, 23));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 8, 128, 41));
			this.addSlot(new PaleontologyTaleResultSlot(handler, 9, 128, 59));
		});
		addDataSlots(data);
	}
	
	public boolean isCrafting() {
        return data.get(0) > 0;
    }
	
	public int getScaledProgress(int scale) {
		int progress = this.data.get(0);
		int maxProgress = this.data.get(1);
		if (progress == 0 || maxProgress == 0) {
			return 0;
		}
		return Mth.ceil((float)scale * (float)progress / (float)maxProgress);
	}
	
	private static final int HOTBAR_SLOT_COUNT = 9;

    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    
    private static final int TE_INVENTORY_SLOT_COUNT = 10;
    
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
    	Slot sourceSlot = slots.get(index);
    	if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
    	ItemStack sourceStack = sourceSlot.getItem();
    	ItemStack copyOfSourceStack = sourceStack.copy();
    	if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
    		if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
    			return ItemStack.EMPTY;
    		}
     	} else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
     		if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
     			return ItemStack.EMPTY;
     		}
     	} else {
     		return ItemStack.EMPTY;
     	}
    	if (sourceStack.getCount() == 0) {
    		sourceSlot.set(ItemStack.EMPTY);
    	} else {
    		sourceSlot.setChanged();
    	}
    	sourceSlot.onTake(player, sourceStack);
    	return copyOfSourceStack;
    }
    
    @Override
    public boolean stillValid(Player player) {
    	return stillValid(ContainerLevelAccess.create(world, blockEntity.getBlockPos()), player, PFBlocks.PALEONTOLOGY_TABLE.get());
    }
    
    private void addPlayerInventory(Inventory playerInventory) {
    	for(int i = 0; i < 3; ++i) {
    		for (int l = 0; l < 9; ++l) {
    			this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
    		}
    	}
    }
    
    private void addPlayerHotbar(Inventory playerInventory) {
    	for (int i = 0; i < 9; ++i) {
    		this.addSlot(new Slot(playerInventory, i, 8 + i * 19, 142));
    	}
    }
    
    private class PaleontologyTaleResultSlot extends SlotItemHandler {
    	public PaleontologyTaleResultSlot(IItemHandler itemHandler, int index, int x, int y) {
    		super(itemHandler, index, x, y);
    	}
    	
    	@Override
    	public boolean mayPlace(ItemStack stack) {
    		return false;
    	}
    }
    
}
