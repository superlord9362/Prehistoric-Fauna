package superlord.prehistoricfauna.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superlord.prehistoricfauna.util.PacketToClientSign;

import javax.annotation.Nullable;

public class PFSignItem extends SignItem
{
	public PFSignItem(Item.Properties propertiesIn, Block floorBlockIn, Block wallBlockIn)
	{
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state)
	{
		boolean flag = super.onBlockPlaced(pos, worldIn, player, stack, state);
		if (!worldIn.isRemote && !flag && player != null)
			PacketToClientSign.sendMessage((ServerPlayerEntity) player, pos);

		return flag;
	}
}
