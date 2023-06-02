package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Pinacosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Pinacosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Pinacosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Pinacosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Pinacosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(Pinacosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Pinacosaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 100;
	private int lastInLove = 0;
	private int currentHunger = 100;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	int loveTick = 0;

	@SuppressWarnings("deprecation")
	public Pinacosaurus(EntityType<? extends Pinacosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Pinacosaurus entity = new Pinacosaurus(PFEntities.PINACOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public boolean isDigging() {
		return this.entityData.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.entityData.set(IS_DIGGING, isDigging);
	}

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.entityData.set(HAS_EGG, hasEgg);
	}

	public boolean isAlbino() {
		return this.entityData.get(ALBINO);
	}

	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
	}

	private void setAlbino(boolean isAlbino) {
		this.entityData.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.entityData.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.entityData.set(MELANISTIC, isMelanistic);
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}

	private void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

	public boolean isEating() {
		return this.entityData.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Random random = new Random();
		int birthNumber = random.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber == 4) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.425F;
		else return 1.1F;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Pinacosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Pinacosaurus.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Pinacosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(3, new Pinacosaurus.ProtectBabyGoal());
		this.goalSelector.addGoal(0, new Pinacosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Pinacosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Pinacosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new Pinacosaurus.HerbivoreEatGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(10, new Pinacosaurus.RidePinacosaurusGoal(this));
	}

	public void aiStep() {
		super.aiStep();

		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		}
		if (!this.isNoAi()) {
			List<? extends Pinacosaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isBaby() || hungerTick == 300 && this.isBaby()) {
					if (!this.isAsleep()) {
						if (currentHunger != 0) {
							this.setHunger(currentHunger - 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && this.getHealth() > (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && level.getDifficulty() == Difficulty.HARD && this.getHealth() <= (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
					}
					hungerTick = 0;
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 6) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLoveTime(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				int naturalBreedingChance = random.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 6) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLoveTime(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveNaturally(false);
				}
			}
			if (lastInLove != 0) {
				lastInLove--;
			}
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ARMOR, 10D).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.PINACOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.PINACOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.PINACOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.PINACOSAURUS_WARNING, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(EATING, false);
		this.entityData.define(NATURAL_LOVE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.isVehicle() && !player.isSecondaryUseActive() && !this.isBaby() && !this.isSleeping()) {
			boolean flag = this.isFood(player.getItemInHand(hand));
			if (!flag && !this.isVehicle() && !player.isSecondaryUseActive()) {
				if (!this.level.isClientSide) {
					player.startRiding(this);
				}
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}
		} else if (!this.getPassengers().isEmpty()) {
			this.ejectPassengers();
		}
		return super.mobInteract(player, hand);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		if (this.getPassengers().isEmpty()) {
			for (Entity e : level.getEntities(this, getBoundingBox().inflate(0.5))) {
				if (e instanceof Mob && e.getBbWidth() <= 0.75F && e.getBbHeight() <= 0.75F && !this.isBaby() && ((Mob)e).getMobType() != MobType.WATER && !this.isInWater()) {
					e.startRiding(this);
				}
			}
		} else if (!getPassengers().isEmpty() && this.isInWater()) {
			this.ejectPassengers();
		}
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	@Override
	public boolean canBeControlledByRider() {
		return false;
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}	

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Pinacosaurus.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			super.start();
			if (Pinacosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Pinacosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Pinacosaurus.this, 1.25D, true);
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
					Pinacosaurus.this.playWarningSound();
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
			return (double)(8.0F + attackTarget.getBbWidth());
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Pinacosaurus.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Pinacosaurus.this.isBaby() && !Pinacosaurus.this.isOnFire() ? false : super.canUse();
		}
	}

	class ProtectBabyGoal extends NearestAttackableTargetGoal<Player> {
		public ProtectBabyGoal() {
			super(Pinacosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Pinacosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Pinacosaurus pinacosaurus : Pinacosaurus.this.level.getEntitiesOfClass(Pinacosaurus.class, Pinacosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (pinacosaurus.isBaby()) {
							return true;
						}
					}
				}

				return false;
			}
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Pinacosaurus pinacosaurus;

		LayEggGoal(Pinacosaurus pinacosaurus, double speedIn) {
			super(pinacosaurus, speedIn, 16);
			this.pinacosaurus = pinacosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.pinacosaurus.hasEgg() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.pinacosaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.pinacosaurus.blockPosition());
			if (!this.pinacosaurus.isInWater() && this.isReachedTarget()) {
				if (this.pinacosaurus.isDigging < 1) {
					this.pinacosaurus.setDigging(true);
				} else if (this.pinacosaurus.isDigging > 200) {
					Level world = this.pinacosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.PINACOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.pinacosaurus.random.nextInt(4) + 1)), 3);
					this.pinacosaurus.setHasEgg(false);
					this.pinacosaurus.setDigging(false);
					this.pinacosaurus.setInLoveTime(600);
				}

				if (this.pinacosaurus.isDigging()) {
					this.pinacosaurus.isDigging++;
				}
			}

		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			if (!worldIn.isEmptyBlock(pos.above())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				BlockState state = worldIn.getBlockState(pos);
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT.get() || block == PFBlocks.MOSS_BLOCK.get() || block == PFBlocks.LOAM.get() || block == PFBlocks.PACKED_LOAM.get() || block == PFBlocks.SILT.get() || block == PFBlocks.PACKED_LOAM.get() || state.is(BlockTags.LEAVES);
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final Pinacosaurus pinacosaurus;

		MateGoal(Pinacosaurus pinacosaurus, double speedIn) {
			super(pinacosaurus, speedIn);
			this.pinacosaurus = pinacosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return super.canUse() && !this.pinacosaurus.hasEgg() && !this.pinacosaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void spawnBaby() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}

			this.pinacosaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random randomom = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), randomom.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Pinacosaurus pinacosaurus;

		NaturalMateGoal(Pinacosaurus pinacosaurus, double speed) {
			super(pinacosaurus, speed);
			this.pinacosaurus = pinacosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.pinacosaurus.hasEgg() && this.pinacosaurus.getCurrentHunger() >= this.pinacosaurus.getThreeQuartersHunger() && this.pinacosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.pinacosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.pinacosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.pinacosaurus.random.nextFloat() - this.pinacosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.pinacosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
					this.pinacosaurus.spawnAtLocation(PFBlocks.PINACOSAURUS_EGG.get().asItem());
				}
			} else {
				this.pinacosaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Pinacosaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.tryTicks % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return blockstate.is(PFBlocks.HORSETAIL.get()) || blockstate.is(PFBlocks.TALL_HORSETAIL.get()) || blockstate.is(PFBlocks.OSMUNDA.get()) || blockstate.is(PFBlocks.TALL_OSMUNDA.get()) || blockstate.is(PFBlocks.CLUBMOSS.get()) || blockstate.is(PFBlocks.MARCHANTIA.get()) || blockstate.is(PFBlocks.CONIOPTERIS.get()) || blockstate.is(PFBlocks.OSMUNDACAULIS.get()) || blockstate.is(PFBlocks.TALL_OSMUNDACAULIS.get()) || blockstate.is(PFBlocks.DICROIDIUM.get()) || blockstate.is(PFBlocks.JOHNSTONIA.get()) || blockstate.is(PFBlocks.CLADOPHLEBIS.get()) || blockstate.is(PFBlocks.SCYTOPHYLLUM.get()) || blockstate.is(PFBlocks.MICHELILLOA.get()) || blockstate.is(PFBlocks.DEAD_OSMUNDACAULIS.get()) || blockstate.is(PFBlocks.COBBANIA.get()) || blockstate.is(PFBlocks.OTOZAMITES.get()) || blockstate.is(PFBlocks.TALL_OTOZAMITES.get()) || blockstate.is(PFBlocks.LAUROZAMITES.get()) || blockstate.is(Blocks.GRASS) || blockstate.is(Blocks.VINE) || blockstate.is(BlockTags.FLOWERS) || blockstate.is(Blocks.TALL_GRASS) || blockstate.is(Blocks.FERN) || blockstate.is(Blocks.LARGE_FERN);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					Pinacosaurus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Pinacosaurus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = Pinacosaurus.this.level.getBlockState(this.blockPos);
			int hunger = Pinacosaurus.this.getCurrentHunger();
			if (blockstate.is(PFBlocks.DEAD_OSMUNDACAULIS.get())) {
				if (hunger + 2 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 2);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(Blocks.GRASS) || blockstate.is(Blocks.TALL_GRASS) || blockstate.is(BlockTags.FLOWERS)) {
				if (hunger + 4 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 4);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(Blocks.VINE)) {
				if (hunger + 6 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 6);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.MARCHANTIA.get()) || blockstate.is(PFBlocks.OSMUNDACAULIS.get()) || blockstate.is(PFBlocks.OTOZAMITES.get())) {
				if (hunger + 8 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 8);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.HORSETAIL.get()) || blockstate.is(PFBlocks.CLUBMOSS.get()) || blockstate.is(PFBlocks.MICHELILLOA.get()) || blockstate.is(PFBlocks.COBBANIA.get()) || blockstate.is(PFBlocks.LAUROZAMITES.get()) || blockstate.is(PFBlocks.CLATHOPTERIS.get())) {
				if (hunger + 10 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 10);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.TALL_OSMUNDACAULIS.get()) || blockstate.is(PFBlocks.TALL_OTOZAMITES.get())) {
				if (hunger + 12 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 12);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.OSMUNDA.get()) || blockstate.is(Blocks.FERN) || blockstate.is(PFBlocks.CONIOPTERIS.get()) || blockstate.is(PFBlocks.CLADOPHLEBIS.get())) {
				if (hunger + 15 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 15);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.TALL_HORSETAIL.get()) || blockstate.is(PFBlocks.SCYTOPHYLLUM.get())) {
				if (hunger + 20 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 20);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.TALL_OSMUNDA.get()) || blockstate.is(Blocks.LARGE_FERN) || blockstate.is(PFBlocks.JOHNSTONIA.get())) {
				if (hunger + 25 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 25);
					Pinacosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFBlocks.DICROIDIUM.get())) {
				if (hunger + 30 >= Pinacosaurus.this.maxHunger) {
					Pinacosaurus.this.setHunger(Pinacosaurus.this.maxHunger);
					Pinacosaurus.this.setEating(false);
				} else {
					Pinacosaurus.this.setHunger(hunger + 30);
					Pinacosaurus.this.setEating(false);
				}
			}
			Pinacosaurus.this.setEating(false);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Pinacosaurus.this.isAsleep() && super.canUse() && Pinacosaurus.this.getCurrentHunger() < Pinacosaurus.this.getHalfHunger();
		}

		public boolean canContinueToUse() {
			if (Pinacosaurus.this.getCurrentHunger() >= Pinacosaurus.this.maxHunger || Pinacosaurus.this.isAsleep()) {
				return false;
			} else return super.canContinueToUse();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}
	}

	public class RidePinacosaurusGoal extends Goal {
		private final Mob entity;

		public RidePinacosaurusGoal(Mob entity) {
			this.entity = entity;
		}

		@Override
		public boolean canUse() {
			return entity.tickCount % 60 == 0 && entity.getPassengers().isEmpty();
		}

		@Override
		public boolean canContinueToUse() {
			return entity.tickCount % 80 != 0;
		}

		@Override
		public void start() {
			super.start();
			for (Mob mob : entity.level.getEntitiesOfClass(Mob.class, entity.getBoundingBox().inflate(5), e -> e != entity && e.getVehicle() == null)) {
				if (mob.getBbWidth() <= 0.75F && mob.getBbHeight() <= 0.75F) {
					mob.getNavigation().moveTo(entity, mob.getSpeed() + 0.4);
				}
			}
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.PINACOSAURUS_SPAWN_EGG.get());
	}

}