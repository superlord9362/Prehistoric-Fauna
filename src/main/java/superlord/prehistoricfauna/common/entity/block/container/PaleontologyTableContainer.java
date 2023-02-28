package superlord.prehistoricfauna.common.entity.block.container;

import java.util.Objects;

import javax.annotation.Nonnull;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.SlotItemHandler;
import superlord.prehistoricfauna.common.blocks.PaleontologyTableBlock;
import superlord.prehistoricfauna.common.entity.block.PaleontologyTableBlockEntity;
import superlord.prehistoricfauna.init.PFContainers;

public class PaleontologyTableContainer extends AbstractContainerMenu
{
	private final IWorldPosCallable canInteractWithCallable;
	private final PaleontologyTableBlockEntity tileEntity;

	public PaleontologyTableContainer(final int windowID, final Inventory playerInventory, final PaleontologyTableBlockEntity tileEntity)
	{
		super(PFContainers.PALEONTOLOGY_TABLE.get(), windowID);

		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getLevel(), tileEntity.getBlockPos());
		this.tileEntity = tileEntity;

		int playerX = 8;
		int playerY = 84;
		for (int i = 0; i < 9; i++)
			this.addSlot(new Slot(playerInventory, i, playerX + i * 18, playerY + 58));
		for (int i = 0; i < 3; i++)
			for (int k = 0; k < 9; k++)
				this.addSlot(new Slot(playerInventory, k + i * 9 + 9, playerX + k * 18, playerY + i * 18));
		
		this.addSlot(new SlotItemHandler(this.tileEntity.getItemStackHandler(), PaleontologyTableBlockEntity.SLOT_FOSSIL, 36, 42) {

		    @Override
		    public boolean isItemValid(@Nonnull ItemStack stack)
		    {
		        return super.isItemValid(stack) && tileEntity.isFossilStack(stack);
		    }
		});

		int resultX = 92;
		int resultY = 23;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				this.addSlot(new PaleontologyTaleResultSlot(playerInventory.player, this.tileEntity.getInventory(), PaleontologyTableBlockEntity.SLOT_RESULTS[0] + j * 3 + i, resultX + i * 18, resultY + j * 18));

		this.trackIntArray(this.tileEntity.getIntArray());
	}

	public PaleontologyTableContainer(final int windowID, final Inventory playerInventory, final FriendlyByteBuf data)
	{
		this(windowID, playerInventory, PaleontologyTableContainer.getTileEntity(playerInventory, data));
	}

	private static PaleontologyTableBlockEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data)
	{
		Objects.requireNonNull(playerInventory, "Error: " + PaleontologyTableContainer.class.getSimpleName() + " - Player Inventory cannot be null!");
		Objects.requireNonNull(data, "Error: " + PaleontologyTableContainer.class.getSimpleName() + " - Packer Buffer Data cannot be null!");

		final BlockEntity tileEntityAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
		if (tileEntityAtPos instanceof PaleontologyTableBlockEntity)
			return (PaleontologyTableBlockEntity) tileEntityAtPos;

		throw new IllegalStateException("Error: " + PaleontologyTableContainer.class.getSimpleName() + " - TileEntity is not corrent! " + tileEntityAtPos);
	}

	@Override
	public boolean canInteractWith(Player playerIn)
	{
		return this.canInteractWithCallable.applyOrElse((level, blockPos) ->
		{
			return level.getBlockState(blockPos).getBlock() instanceof PaleontologyTableBlock ? playerIn.getDistanceSq((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D : false;
		}, true);
	}

	@Override
	public ItemStack transferStackInSlot(Player playerIn, int index)
	{
		int playerInvSize = this.inventorySlots.size() - this.tileEntity.getInventorySize();

		Slot sourceSlot = (Slot) this.inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index >= playerInvSize)
		{
			if (!this.mergeItemStack(sourceStack, 0, playerInvSize, false))
				return ItemStack.EMPTY;
		}
		else
		{
			if (this.tileEntity.isFossilStack(sourceStack))
			{
				int slotIndex = PaleontologyTableBlockEntity.SLOT_FOSSIL;
				if (!this.mergeItemStack(sourceStack, playerInvSize + slotIndex, playerInvSize + slotIndex + 1, false))
					return ItemStack.EMPTY;
			}
			else
				return ItemStack.EMPTY;
		}

		if (sourceStack.isEmpty())
			sourceSlot.putStack(ItemStack.EMPTY);
		else
			sourceSlot.onSlotChanged();

		if (sourceStack.getCount() == copyOfSourceStack.getCount())
			return ItemStack.EMPTY;

		sourceSlot.onTake(playerIn, sourceStack);
		return copyOfSourceStack;
	}

	@OnlyIn(Dist.CLIENT)
	public int getWorkProgressionScaled(int size)
	{
		return this.tileEntity.getWorkProgressionScaled(size);
	}

	public class PaleontologyTaleResultSlot extends Slot
	{
		private final Player player;
		private int removeCount;

		public PaleontologyTaleResultSlot(Player player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
		{
			super(inventoryIn, slotIndex, xPosition, yPosition);
			this.player = player;
		}

		@Override
		public boolean isItemValid(ItemStack stack)
		{
			return false;
		}

		@Override
		public ItemStack decrStackSize(int amount)
		{
			if (this.getHasStack())
			{
				this.removeCount += Math.min(amount, this.getStack().getCount());
			}

			return super.decrStackSize(amount);
		}

		@Override
		public ItemStack onTake(Player thePlayer, ItemStack stack)
		{
			this.onCrafting(stack);
			super.onTake(thePlayer, stack);
			return stack;
		}

		@Override
		protected void onCrafting(ItemStack stack, int amount)
		{
			this.removeCount += amount;
			this.onCrafting(stack);
		}

		@Override
		protected void onCrafting(ItemStack stack)
		{
			stack.onCrafting(this.player.level, this.player, this.removeCount);
			if (!this.player.level.isClientSide && this.inventory instanceof PaleontologyTableBlockEntity)
				((PaleontologyTableBlockEntity) this.inventory).givePlayerXP(player, this.removeCount);

			this.removeCount = 0;
		}
	}
}
