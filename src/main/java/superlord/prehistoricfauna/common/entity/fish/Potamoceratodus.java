package superlord.prehistoricfauna.common.entity.fish;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Potamoceratodus extends AbstractFish {

	public Potamoceratodus(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D);
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(PFItems.POTAMOCERATODUS_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() {
		return PFSounds.FISH_FLOP.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_28306_) {
		return PFSounds.POTAMOCERATODUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.POTAMOCERATODUS_DEATH.get();
	}
	
	public void aiStep() {
		super.aiStep();
		if (this.getHealth() == 1 && this.getAirSupply() == -15) {
			PotamoceratodusCocoon potamoceratodus = new PotamoceratodusCocoon(PFEntities.POTAMOCERATODUS_COCOON.get(), this.level());
			potamoceratodus.setPos(this.getX(), this.getY(), this.getZ());
			this.level().addFreshEntity(potamoceratodus);
			if (this.hasCustomName()) {
				potamoceratodus.setCustomName(getCustomName());
			}
			this.level().playSound((Player)null, new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ()), SoundEvents.FROG_TONGUE, SoundSource.NEUTRAL);
			this.remove(RemovalReason.DISCARDED);
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean checkAncientFishSpawnRules(EntityType<? extends AbstractFish> type, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		int i = worldIn.getSeaLevel();
		int j = i - 13;
		return pos.getY() >= j && worldIn.getBlockState(pos).is(Blocks.WATER) && randomIn.nextFloat() > 0.99F;
	}		
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.POTAMOCERATODUS_SPAWN_EGG.get());
	}
}
