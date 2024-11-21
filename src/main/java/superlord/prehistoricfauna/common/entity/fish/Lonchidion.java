package superlord.prehistoricfauna.common.entity.fish;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
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
import superlord.prehistoricfauna.init.PFTags;

public class Lonchidion extends AbstractFish {
	private static final EntityDataAccessor<Boolean> CHINLE = SynchedEntityData.defineId(Lonchidion.class, EntityDataSerializers.BOOLEAN);

	public Lonchidion(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D);
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(PFItems.LONCHIDION_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() {
		return PFSounds.FISH_FLOP.get();
	}

	protected SoundEvent getHurtSound(DamageSource p_28306_) {
		return PFSounds.LONCHIDION_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.LONCHIDION_DEATH.get();
	}

	public boolean isFromChinle() {
		return this.entityData.get(CHINLE);
	}

	public void setFromChinle(boolean isChinle) {
		this.entityData.set(CHINLE, isChinle);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CHINLE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsFromChinle", this.isFromChinle());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setFromChinle(compound.getBoolean("IsFromChinle"));
	}

	@SuppressWarnings("deprecation")
	public static boolean checkAncientFishSpawnRules(EntityType<? extends AbstractFish> type, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		int i = worldIn.getSeaLevel();
		int j = i - 13;
		return pos.getY() >= j && worldIn.getBlockState(pos).is(Blocks.WATER) && randomIn.nextFloat() > 0.99F;
	}		

	@SuppressWarnings({ "deprecation", "static-access" })
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		if (reason == reason.SPAWN_EGG) {
			this.setFromChinle(this.random.nextBoolean());
		} else {
			if (worldIn.getBiome(this.getOnPos()).is(PFTags.HAS_CHINLE_HUT)) {
				this.setFromChinle(true);
			} else {
				this.setFromChinle(false);
			}
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void saveToBucketTag(ItemStack p_30049_) {
		super.saveToBucketTag(p_30049_);
		CompoundTag compoundtag = p_30049_.getOrCreateTag();
		if (this.isFromChinle()) {
			compoundtag.putInt("chinle_variant", 1);
		} else {
			compoundtag.putInt("chinle_variant", 0);
		}
//		compoundtag.putBoolean("chinle_variant", this.isFromChinle());
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.LONCHIDION_SPAWN_EGG.get());
	}
}
