package superlord.prehistoricfauna.common.entity.henos;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class CaveSentinel extends Monster {
	private static final EntityDataAccessor<Integer> DIMENSION = SynchedEntityData.defineId(CaveSentinel.class, EntityDataSerializers.INT);

	public static final Predicate<LivingEntity> NON_TRIASSIC = (p_289448_) -> {
		return !p_289448_.getType().is(PFTags.TRIASSIC_ENTITIES) && !p_289448_.getType().is(PFTags.SENTINEL_IGNORES);
	};
	public static final Predicate<LivingEntity> NON_JURASSIC = (p_289448_) -> {
		return !p_289448_.getType().is(PFTags.JURASSIC_ENTITIES) && !p_289448_.getType().is(PFTags.SENTINEL_IGNORES);
	};
	public static final Predicate<LivingEntity> NON_CRETACEOUS = (p_289448_) -> {
		return !p_289448_.getType().is(PFTags.CRETACEOUS_ENTITIES) && !p_289448_.getType().is(PFTags.SENTINEL_IGNORES);
	};
	private Goal cretaceousTargetGoal;
	private Goal jurassicTargetGoal;
	private Goal triassicTargetGoal;
	
	public CaveSentinel(EntityType<? extends Monster> type, Level world) {
		super(type, world);
		this.setMaxUpStep(1.375F);
	}

	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.FALL) || source.is(DamageTypes.DROWN) || source.is(DamageTypes.FIREBALL) || source.is(DamageTypes.UNATTRIBUTED_FIREBALL) || source.is(DamageTypes.SWEET_BERRY_BUSH) || source.is(DamageTypes.CACTUS) || source.is(DamageTypes.FALLING_ANVIL) || source.is(DamageTypes.FALLING_BLOCK) || source.is(DamageTypes.FALLING_STALACTITE) || source.is(DamageTypes.FREEZE) || source.is(DamageTypes.HOT_FLOOR) || source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.LAVA) || source.is(DamageTypes.LIGHTNING_BOLT) || source.is(DamageTypes.MAGIC) || source.is(DamageTypes.STALAGMITE)) {
			return false;
		} else return super.hurt(source, amount);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DIMENSION, 0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dimension", this.getDimensionInt());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setDimensionInt(compound.getInt("Dimension"));
		if (this.level() instanceof ServerLevel) {
			this.setTargetGoals();
		}
	}

	public int getDimensionInt() {
		return this.entityData.get(DIMENSION);
	}

	private void setDimensionInt(int dimensionInt) {
		this.entityData.set(DIMENSION, dimensionInt);
	}

	@Override
	protected void registerGoals() {
		this.cretaceousTargetGoal = new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, false, NON_CRETACEOUS);
		this.jurassicTargetGoal = new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, false, NON_JURASSIC);
		this.triassicTargetGoal = new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, false, NON_TRIASSIC);
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CaveSentinel.MeleeAttackGoal());
	}
	
	@SuppressWarnings("deprecation")
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		if (worldIn.getBiome(this.getOnPos()).is(PFTags.IS_CRETACEOUS)) {
			this.setDimensionInt(0);
		} else if (worldIn.getBiome(this.getOnPos()).is(PFTags.IS_JURASSIC)) {
			this.setDimensionInt(1);
		} else this.setDimensionInt(2);
		if (worldIn instanceof ServerLevel) {
			this.setTargetGoals();
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	private void setTargetGoals() {
		if (this.getDimensionInt() == 0) {
			this.targetSelector.addGoal(0, this.cretaceousTargetGoal);
		}
		if (this.getDimensionInt() == 1) {
			this.targetSelector.addGoal(0, this.jurassicTargetGoal);
		}
		if (this.getDimensionInt() == 2) {
			this.targetSelector.addGoal(0, this.triassicTargetGoal);
		}
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
	}

	@SuppressWarnings("deprecation")
	public static boolean canSpawn(EntityType<CaveSentinel> batIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		if (pos.getY() >= worldIn.getSeaLevel()) {
			return false;
		} else {
			return worldIn.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(worldIn, pos, randomIn) && checkMobSpawnRules(batIn, worldIn, reason, pos, randomIn) && worldIn.getLevel().isNight() && randomIn.nextFloat() > 0.9F;
		}
	}

	public static boolean isValidLightLevel(ServerLevelAccessor worldIn, BlockPos pos, RandomSource randomIn) {
		if (worldIn.getBrightness(LightLayer.SKY, pos) > randomIn.nextInt(32)) {
			return false;
		} else {
			int i = worldIn.getLevel().isThundering() ? worldIn.getMaxLocalRawBrightness(pos, 10) : worldIn.getMaxLocalRawBrightness(pos);
			return i <= randomIn.nextInt(8);
		}
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.STONE_STEP, 0.15F, 1.0F);
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(CaveSentinel.this, 1.25D, true);
		}

		@SuppressWarnings("deprecation")
		public boolean canContinueToUse() {
			float f = this.mob.getLightLevelDependentMagicValue();
			if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
				this.mob.setTarget((LivingEntity)null);
				return false;
			} else {
				return super.canContinueToUse();
			}
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(6F + attackTarget.getBbWidth());
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CAVE_SENTINEL_SPAWN_EGG.get());
	}

}
