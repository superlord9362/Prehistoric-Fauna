package superlord.prehistoricfauna.common.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.vehicle.MinecartTNT;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import superlord.prehistoricfauna.common.entity.block.EopolisMoundBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class EopolisMoundBlock extends BaseEntityBlock {

	public EopolisMoundBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@SuppressWarnings("deprecation")
	public void playerDestroy(Level p_49584_, Player p_49585_, BlockPos p_49586_, BlockState p_49587_, @Nullable BlockEntity p_49588_, ItemStack p_49589_) {
		super.playerDestroy(p_49584_, p_49585_, p_49586_, p_49587_, p_49588_, p_49589_);
		if (!p_49584_.isClientSide && p_49588_ instanceof EopolisMoundBlockEntity moundBlockEntity) {
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, p_49589_) == 0) {
				moundBlockEntity.emptyAllLivingFromMound(p_49585_, p_49587_, EopolisMoundBlockEntity.EopolisReleaseStatus.EMERGENCY);
				p_49584_.updateNeighbourForOutputSignal(p_49586_, this);
			}
		}
	}

	public void releaseEopolis(Level p_49595_, BlockState p_49596_, BlockPos p_49597_, @Nullable Player p_49598_, EopolisMoundBlockEntity.EopolisReleaseStatus p_49599_) {
		BlockEntity blockentity = p_49595_.getBlockEntity(p_49597_);
		if (blockentity instanceof EopolisMoundBlockEntity moundBlockEntity) {
			moundBlockEntity.emptyAllLivingFromMound(p_49598_, p_49596_, p_49599_);
		}

	}

	public RenderShape getRenderShape(BlockState p_49653_) {
		return RenderShape.MODEL;
	}

	@Nullable
	public BlockEntity newBlockEntity(BlockPos p_152184_, BlockState p_152185_) {
		return new EopolisMoundBlockEntity(p_152184_, p_152185_);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
		return p_152180_.isClientSide ? null : createTickerHelper(p_152182_, PFBlockEntities.EOPOLIS_MOUND.get(), EopolisMoundBlockEntity::serverTick);
	}

	public void playerWillDestroy(Level p_49608_, BlockPos p_49609_, BlockState p_49610_, Player p_49611_) {
		if (!p_49608_.isClientSide && p_49611_.isCreative() && p_49608_.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
			BlockEntity blockentity = p_49608_.getBlockEntity(p_49609_);
			if (blockentity instanceof EopolisMoundBlockEntity) {
				EopolisMoundBlockEntity moundBlockEntity = (EopolisMoundBlockEntity)blockentity;
				ItemStack itemstack = new ItemStack(this);
				boolean flag = !moundBlockEntity.isEmpty();
				if (flag) {
					if (flag) {
						CompoundTag compoundtag = new CompoundTag();
						compoundtag.put("Eopolis", moundBlockEntity.writeEopolis());
						BlockItem.setBlockEntityData(itemstack, PFBlockEntities.EOPOLIS_MOUND.get(), compoundtag);
					}
					ItemEntity itementity = new ItemEntity(p_49608_, (double)p_49609_.getX(), (double)p_49609_.getY(), (double)p_49609_.getZ(), itemstack);
					itementity.setDefaultPickUpDelay();
					p_49608_.addFreshEntity(itementity);
				}
			}
		}

		super.playerWillDestroy(p_49608_, p_49609_, p_49610_, p_49611_);
	}

	@SuppressWarnings("deprecation")
	public List<ItemStack> getDrops(BlockState p_49636_, LootParams.Builder p_287581_) {
		Entity entity = p_287581_.getOptionalParameter(LootContextParams.THIS_ENTITY);
		if (entity instanceof PrimedTnt || entity instanceof Creeper || entity instanceof WitherSkull || entity instanceof WitherBoss || entity instanceof MinecartTNT) {
			BlockEntity blockentity = p_287581_.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
			if (blockentity instanceof EopolisMoundBlockEntity) {
				EopolisMoundBlockEntity moundBlockEntity = (EopolisMoundBlockEntity)blockentity;
				moundBlockEntity.emptyAllLivingFromMound((Player)null, p_49636_, EopolisMoundBlockEntity.EopolisReleaseStatus.EMERGENCY);
			}
		}

		return super.getDrops(p_49636_, p_287581_);
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState p_49639_, Direction p_49640_, BlockState p_49641_, LevelAccessor p_49642_, BlockPos p_49643_, BlockPos p_49644_) {
		if (p_49642_.getBlockState(p_49644_).getBlock() instanceof FireBlock) {
			BlockEntity blockentity = p_49642_.getBlockEntity(p_49643_);
			if (blockentity instanceof EopolisMoundBlockEntity) {
				EopolisMoundBlockEntity moundBlockEntity = (EopolisMoundBlockEntity)blockentity;
				moundBlockEntity.emptyAllLivingFromMound((Player)null, p_49639_, EopolisMoundBlockEntity.EopolisReleaseStatus.EMERGENCY);
			}
		}

		return super.updateShape(p_49639_, p_49640_, p_49641_, p_49642_, p_49643_, p_49644_);
	}

}
