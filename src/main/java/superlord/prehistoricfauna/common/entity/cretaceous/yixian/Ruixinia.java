package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.AgedHerdDinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AgedFollowHerdLeaderGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Ruixinia extends AgedHerdDinosaurEntity {
	private static final EntityDataAccessor<Boolean> IS_JUVENILE = SynchedEntityData.defineId(Ruixinia.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 150;
	private int warningSoundTicks;
	private int crushTicks = 0;

	public Ruixinia(EntityType<? extends AgedHerdDinosaurEntity> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.0F);
		super.maxHunger = maxHunger;
	}

	public boolean isJuvenile() {
		return this.entityData.get(IS_JUVENILE);
	}

	private void setJuvenile(boolean isJuvenile) {
		this.entityData.set(IS_JUVENILE, isJuvenile);
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.CALLIANTHUS.get();
	}
	
	@Override
	public double moveToRange() {
		return 10;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Ruixinia.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new AgedFollowHerdLeaderGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new Ruixinia.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Ruixinia.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.RUIXINIA_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.RUIXINIA.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.RUIXINIA.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.ruixinia_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.RUIXINIA_SNORES.get() : PFSounds.RUIXINIA_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.RUIXINIA_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.RUIXINIA_DEATH.get();
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.RUIXINIA_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_JUVENILE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() < -24000) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15.0D);
		} else if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.setJuvenile(true);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0D);
		} else if(this.getAge() >= 0) {
			this.setJuvenile(false);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60.0D);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.getDeltaMovement().x == 0 && this.getDeltaMovement().y == 0 && this.getDeltaMovement().z == 0) {
		} else {
			if (!this.isBaby()) {
				if (crushTicks <= 600) {
					crushTicks++;
				} else {
					crushTicks = 0;
				}
				for (ItemEntity entity : this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(1, 0, 1))) {
					Item item = entity.getItem().getItem();
					if (crushTicks == 1200) {
						if (item == PFItems.HENOSTONE.get()) {
							if (this.random.nextInt(100) < 5) {
								ItemEntity newItem = new ItemEntity(this.level(), entity.getX(), entity.getY(), entity.getZ(), new ItemStack(PFItems.TIME_GEM_SHARD.get()));
								newItem.setPos(entity.getX(), entity.getY(), entity.getZ());
								this.level().addFreshEntity(newItem);
							}
							entity.remove(RemovalReason.DISCARDED);
						}
					}
				}
			}
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Ruixinia.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Ruixinia.this.playWarningSound();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(15.0F + attackTarget.getBbWidth());
		}
	}

	static class MateGoal extends BreedGoal {
		private final Ruixinia ruixinia;
		private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
		private int breedDelay;
		private final double moveSpeed;

		MateGoal(Ruixinia ruixinia, double speed) {
			super(ruixinia, speed);
			this.ruixinia = ruixinia;
			this.moveSpeed = speed;
		}

		@Nullable
		private Animal getNearbyMate() {
			List<Ruixinia> list = this.level.getNearbyEntities(Ruixinia.class, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(24.0D));
			double d0 = Double.MAX_VALUE;
			Animal animalentity = null;

			for(Animal animalentity1 : list) {
				if (this.animal.canMate(animalentity1) && this.animal.distanceToSqr(animalentity1) < d0) {
					animalentity = animalentity1;
					d0 = this.animal.distanceToSqr(animalentity1);
				}
			}

			return animalentity;
		}

		public boolean canUse() {
			return super.canUse() && !this.ruixinia.hasBaby() && !this.ruixinia.isInLoveNaturally();
		}

		public void stop() {
			this.partner = null;
			this.breedDelay = 0;
		}

		public void tick() {
			super.tick();
			this.animal.getLookControl().setLookAt(this.partner, 10.0F, (float)this.animal.getMaxHeadXRot());
			this.animal.getNavigation().moveTo(this.partner, this.moveSpeed);
			++this.breedDelay;
			if (this.breedDelay >= 60 && this.animal.distanceToSqr(this.partner) < 20.0D) {
				this.breed();
			}
		}

		protected void breed() {
			ServerPlayer serverPlayer = this.animal.getLoveCause();
			if (serverPlayer == null && this.partner.getLoveCause() != null) {
				serverPlayer = this.partner.getLoveCause();
			}
			if (serverPlayer != null) {
				serverPlayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayer, this.animal, this.partner, (AgeableMob)null);
			}
			this.ruixinia.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			RandomSource random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Ruixinia ruixinia;

		NaturalMateGoal(Ruixinia ruixinia, double speed) {
			super(ruixinia, speed);
			this.ruixinia = ruixinia;
		}

		public boolean canUse() {
			return super.canUse() && !this.ruixinia.hasBaby() && this.ruixinia.getCurrentHunger() >= this.ruixinia.getThreeQuartersHunger() && this.ruixinia.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.ruixinia.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.ruixinia.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.ruixinia.random.nextFloat() - this.ruixinia.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.ruixinia.random.nextInt(4);
				for (int i = 0; i <= eggAmount; i++) {
					this.ruixinia.spawnAtLocation(PFBlocks.RUIXINIA_EGG.get().asItem());
				}
			} else {
				this.ruixinia.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Ruixinia entity = new Ruixinia(PFEntities.RUIXINIA.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		entity.setAge(-72000);
		return entity;
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	class RuixiniaFollowParentGoal extends Goal {
		private final Ruixinia babyRuixinia;
		private Ruixinia parentRuixinia;
		private final double moveSpeed;
		private int delayCounter;

		public RuixiniaFollowParentGoal(Ruixinia ruixinia, double speed) {
			this.babyRuixinia = ruixinia;
			this.moveSpeed = speed;
		}

		public boolean canUse() {
			if (this.babyRuixinia.isBaby() && !this.babyRuixinia.isJuvenile()) {
				List<? extends Ruixinia> list = this.babyRuixinia.level().getEntitiesOfClass(this.babyRuixinia.getClass(), this.babyRuixinia.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
				Ruixinia ruixinia = null;
				double d0 = Double.MAX_VALUE;
				for (Ruixinia tyrannosaurus1 : list) {
					if (!tyrannosaurus1.isBaby()) {
						double d1 = this.babyRuixinia.distanceToSqr(tyrannosaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							ruixinia = tyrannosaurus1;
						}
					}
				}
				if (ruixinia == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentRuixinia = ruixinia;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (!this.babyRuixinia.isJuvenile() || !this.babyRuixinia.isBaby()) {
				return false;
			} else if (!this.parentRuixinia.isAlive()) {
				return false;
			} else  if(this.babyRuixinia.isBaby() && !this.babyRuixinia.isJuvenile()){
				double d0 = this.babyRuixinia.distanceToSqr(this.parentRuixinia);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void start() {
			this.delayCounter = 0;
		}

		public void stop() {
			this.parentRuixinia = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyRuixinia.getNavigation().moveTo(this.parentRuixinia, this.moveSpeed);
			}
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.RUIXINIA_SPAWN_EGG.get());
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.RUIXINIA_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

}
