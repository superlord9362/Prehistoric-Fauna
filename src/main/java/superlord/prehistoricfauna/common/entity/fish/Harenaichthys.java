package superlord.prehistoricfauna.common.entity.fish;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Harenaichthys extends AbstractSchoolingFish {
	public Harenaichthys(EntityType<? extends Harenaichthys> p_28276_, Level p_28277_) {
		super(p_28276_, p_28277_);
	}

	public ItemStack getBucketItemStack() {
		return new ItemStack(PFItems.HARENAICHTHYS_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() {
		return PFSounds.FISH_FLOP.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_28306_) {
		return PFSounds.HARENAICHTHYS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HARENAICHTHYS_DEATH.get();
	}
	
	@SuppressWarnings("deprecation")
	public static boolean checkAncientFishSpawnRules(EntityType<? extends AbstractFish> type, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		int i = worldIn.getSeaLevel();
		int j = i - 13;
		return pos.getY() >= j && worldIn.getBlockState(pos).is(Blocks.WATER) && randomIn.nextFloat() > 0.99F;
	}		
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.HARENAICHTHYS_SPAWN_EGG.get());
	}
}
