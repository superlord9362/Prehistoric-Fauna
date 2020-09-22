package superlord.prehistoricfauna.block;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class DidelphodonBurrowBlock extends ContainerBlock {
	
	public DidelphodonBurrowBlock(Block.Properties builder) {
		super(builder);
	}

	private boolean hasDidelphodon(World world, BlockPos pos) {
		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof DidelphodonBurrowTileEntity) {
			DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)tileentity;
			return !didelphodonburrowtileentity.hasNoDidelphodons();
		} else {
			return false;
		}
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new DidelphodonBurrowTileEntity();
	}

}
