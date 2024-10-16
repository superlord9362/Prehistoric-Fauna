package superlord.prehistoricfauna.common.entity.fish;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Acipenser extends AbstractFish {

	public Acipenser(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D);
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(PFItems.ACIPENSER_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() {
		return PFSounds.FISH_FLOP.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_28306_) {
		return PFSounds.ACIPENSER_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ACIPENSER_DEATH.get();
	}

	@SuppressWarnings("deprecation")
	public static boolean checkAncientFishSpawnRules(EntityType<? extends AbstractFish> type, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		int i = worldIn.getSeaLevel();
		int j = i - 13;
		return pos.getY() >= j && worldIn.getBlockState(pos).is(Blocks.WATER) && randomIn.nextFloat() > 0.99F;
	}		
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ACIPENSER_SPAWN_EGG.get());
	}
}
