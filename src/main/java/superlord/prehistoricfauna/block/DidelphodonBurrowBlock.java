package superlord.prehistoricfauna.block;

import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.item.minecart.TNTMinecartEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import superlord.prehistoricfauna.entity.tile.DidelphodonBurrowTileEntity;

import javax.annotation.Nullable;
import java.util.List;

public class DidelphodonBurrowBlock { /**extends ContainerBlock {
	
	public DidelphodonBurrowBlock(Block.Properties builder) {
		super(builder);
	}
	
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, te, stack);
		if (!worldIn.isRemote && te instanceof DidelphodonBurrowTileEntity) {
			DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)te;
			if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
				didelphodonburrowtileentity.angerDidelphodon(player, state, DidelphodonBurrowTileEntity.State.EMERGENCY);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}
	}
	
	@SuppressWarnings("unused")
	private boolean hasDidelphodons(World world, BlockPos pos) {
		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof DidelphodonBurrowTileEntity) {
			DidelphodonBurrowTileEntity didelphodonburrowileentity = (DidelphodonBurrowTileEntity)tileentity;
			return !didelphodonburrowileentity.hasNoDidelphodons();
		} else {
			return false;
		}
	}
	
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote && player.isCreative() && worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof DidelphodonBurrowTileEntity) {
				DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)tileentity;
	            ItemStack itemstack = new ItemStack(this);
	            boolean flag = !didelphodonburrowtileentity.hasNoDidelphodons();
	            if (!flag) {
	            	return;
	            }
	            if (flag) {
	            	CompoundNBT compoundnbt = new CompoundNBT();
	            	compoundnbt.put("Bees", didelphodonburrowtileentity.getDidelphodon());
	            	itemstack.setTagInfo("BlockEntityTag", compoundnbt);
	            }
	            CompoundNBT compoundnbt1 = new CompoundNBT();
	            itemstack.setTagInfo("BlockStateTag", compoundnbt1);
	            ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), itemstack);
	            itementity.setDefaultPickupDelay();
	            worldIn.addEntity(itementity);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@SuppressWarnings("deprecation")
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		Entity entity = builder.get(LootParameters.THIS_ENTITY);
		if (entity instanceof TNTEntity || entity instanceof CreeperEntity || entity instanceof WitherSkullEntity || entity instanceof WitherEntity || entity instanceof TNTMinecartEntity) {
			TileEntity tileentity = builder.get(LootParameters.BLOCK_ENTITY);
			if (tileentity instanceof DidelphodonBurrowTileEntity) {
				DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)tileentity;
				didelphodonburrowtileentity.angerDidelphodon((PlayerEntity)null, state, DidelphodonBurrowTileEntity.State.EMERGENCY);
			}
		}
		return super.getDrops(state, builder);
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (worldIn.getBlockState(facingPos).getBlock() instanceof FireBlock) {
			TileEntity tileentity = worldIn.getTileEntity(currentPos);
			if (tileentity instanceof DidelphodonBurrowTileEntity) {
				DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)tileentity;
				didelphodonburrowtileentity.angerDidelphodon((PlayerEntity)null, stateIn, DidelphodonBurrowTileEntity.State.EMERGENCY);
			}
		}
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new DidelphodonBurrowTileEntity();
	}
*/
}
