package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
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
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDamageSources;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Camarasaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> IS_JUVENILE = SynchedEntityData.defineId(Camarasaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 500;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Camarasaurus(EntityType<? extends Camarasaurus> type, Level level) {
		super(type, level);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby() && !this.isJuvenile()) {
			return 2.75F;
		} else if (this.isJuvenile() && this.isBaby()) {
			return 5.5F;
		}
		else return 8.5F;
	}

	public boolean isJuvenile() {
		return this.entityData.get(IS_JUVENILE);
	}

	private void setJuvenile(boolean isJuvenile) {
		this.entityData.set(IS_JUVENILE, isJuvenile);
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.PTILOPHYLLUM_FRONDS.get();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Camarasaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Camarasaurus.PanicGoal());
		this.goalSelector.addGoal(4, new Camarasaurus.CamarasaurusFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Camarasaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Camarasaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Camarasaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Camarasaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Camarasaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -12000 && this.getAge() < 0) {
			this.setJuvenile(true);
		} else if(this.getAge() >= 0) {
			this.setJuvenile(false);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ATTACK_DAMAGE, 12.0D).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.CAMARASAURUS_SNORES : PFSounds.CAMARASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CAMARASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CAMARASAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CAMARASAURUS_WARN, 1.0F, this.getVoicePitch());
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
	public void aiStep() {
		if (this.isBaby() && !this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50.0D);
		} else if (this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100.0D);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(200.0D);
		}
		super.aiStep();
		if (this.getDeltaMovement().x == 0 && this.getDeltaMovement().y == 0 && this.getDeltaMovement().z == 0) {
			
		} else {
			if (!this.isBaby()) {
				for (LivingEntity entity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1, 0, 1))) {
					if (!(entity instanceof Camarasaurus) && entity.getMaxHealth() < 60) {
						entity.hurt(PFDamageSources.SAUROPOD_TRAMPLING, (float) 5.0D);
					}
				}
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
	}
	
	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		if (PrehistoricFaunaConfig.advancedHunger) {
			int hunger = this.getCurrentHunger();
			if (hunger < this.maxHunger) {
				if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
					this.setInLove(p_230254_1_);
					itemstack.shrink(1);
				} else {
					if (itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
						if (hunger + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 15);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
						if (hunger + 20 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 20);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
						if (hunger + 25 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 25);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
						if (hunger + 30 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 30);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}


	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Camarasaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Camarasaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Camarasaurus camarasaurus : Camarasaurus.this.level.getEntitiesOfClass(Camarasaurus.class, Camarasaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (camarasaurus.isBaby()) {
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

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Camarasaurus.this);
		}

		public void start() {
			super.start();
			if (Camarasaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Camarasaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Camarasaurus.this, 1.25D, true);
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
					Camarasaurus.this.playWarningSound();
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

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Camarasaurus.this, 2.0D);
		}

		public boolean canUse() {
			return !Camarasaurus.this.isBaby() && !Camarasaurus.this.isOnFire() ? false : super.canUse();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Camarasaurus camarasaurus;

		LayEggGoal(Camarasaurus camarasaurus, double speedIn) {
			super(camarasaurus, speedIn, 16);
			this.camarasaurus = camarasaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.camarasaurus.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.camarasaurus.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.camarasaurus.position());
			if (!this.camarasaurus.isInWater() && this.isReachedTarget()) {
				if (this.camarasaurus.isBirthing < 1) {
					this.camarasaurus.setBirthing(true);
				} else if (this.camarasaurus.isBirthing > 200) {
					Level level = this.camarasaurus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.CAMARASAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.camarasaurus.random.nextInt(4) + 1)), 3);
					this.camarasaurus.setHasBaby(false);
					this.camarasaurus.setBirthing(false);
					this.camarasaurus.setInLoveTime(600);
				}

				if (this.camarasaurus.isBirthing()) {
					this.camarasaurus.isBirthing++;
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
		private final Camarasaurus camarasaurus;
		private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
		private int breedDelay;
		private final double moveSpeed;

		MateGoal(Camarasaurus camarasaurus, double speed) {
			super(camarasaurus, speed);
			this.camarasaurus = camarasaurus;
			this.moveSpeed = speed;
		}

		@Nullable
		private Animal getNearbyMate() {
			List<Camarasaurus> list = this.level.getNearbyEntities(Camarasaurus.class, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(24.0D));
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
			return super.canUse() && !this.camarasaurus.hasBaby() && !this.camarasaurus.isInLoveNaturally();
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
			this.camarasaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Camarasaurus camarasaurus;

		NaturalMateGoal(Camarasaurus camarasaurus, double speed) {
			super(camarasaurus, speed);
			this.camarasaurus = camarasaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.camarasaurus.hasBaby() && this.camarasaurus.getCurrentHunger() >= this.camarasaurus.getThreeQuartersHunger() && this.camarasaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.camarasaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.camarasaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.camarasaurus.random.nextFloat() - this.camarasaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.camarasaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
					this.camarasaurus.spawnAtLocation(PFBlocks.CAMARASAURUS_EGG.get().asItem());
				}
			} else {
				this.camarasaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Camarasaurus entity = new Camarasaurus(PFEntities.CAMARASAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class CamarasaurusFollowParentGoal extends Goal {
		private final Camarasaurus babyCamarasaurus;
		private Camarasaurus parentCamarasaurus;
		private final double moveSpeed;
		private int delayCounter;

		public CamarasaurusFollowParentGoal(Camarasaurus camarasaurus, double speed) {
			this.babyCamarasaurus = camarasaurus;
			this.moveSpeed = speed;
		}

		public boolean canUse() {
			if (this.babyCamarasaurus.isBaby() && !this.babyCamarasaurus.isJuvenile()) {
				List<? extends Camarasaurus> list = this.babyCamarasaurus.level.getEntitiesOfClass(this.babyCamarasaurus.getClass(), this.babyCamarasaurus.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
				Camarasaurus camarasaurus = null;
				double d0 = Double.MAX_VALUE;
				for (Camarasaurus tyrannosaurus1 : list) {
					if (!tyrannosaurus1.isBaby()) {
						double d1 = this.babyCamarasaurus.distanceToSqr(tyrannosaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							camarasaurus = tyrannosaurus1;
						}
					}
				}
				if (camarasaurus == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentCamarasaurus = camarasaurus;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (!this.babyCamarasaurus.isJuvenile() || !this.babyCamarasaurus.isBaby()) {
				return false;
			} else if (!this.parentCamarasaurus.isAlive()) {
				return false;
			} else  if(this.babyCamarasaurus.isBaby() && !this.babyCamarasaurus.isJuvenile()){
				double d0 = this.babyCamarasaurus.distanceToSqr(this.parentCamarasaurus);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void start() {
			this.delayCounter = 0;
		}

		public void stop() {
			this.parentCamarasaurus = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyCamarasaurus.getNavigation().moveTo(this.parentCamarasaurus, this.moveSpeed);
			}
		}
	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Camarasaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			return blockstate.getBlock() instanceof FeederBlock && blockstate.getValue(FeederBlock.PLANT) == true;
		}

		protected BlockPos getMoveToTarget() {
			if (!Camarasaurus.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Camarasaurus.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Camarasaurus.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Camarasaurus.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Camarasaurus.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Camarasaurus.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Camarasaurus.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Camarasaurus.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
											return this.blockPos.south().west();
										} else return blockPos.above();
									}
								}
							}
						}
					}
				}
			} 
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
					Camarasaurus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Camarasaurus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Camarasaurus.this.getCurrentHunger() >= 13) {
				Camarasaurus.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Camarasaurus.this.maxHunger - Camarasaurus.this.getCurrentHunger();
			int hunger = Camarasaurus.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Camarasaurus.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Camarasaurus.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Camarasaurus.this.setHunger(Camarasaurus.this.maxHunger);
				Camarasaurus.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Camarasaurus.this.setHunger(hunger + foodContained);
				Camarasaurus.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Camarasaurus.this.isAsleep() && super.canUse() && Camarasaurus.this.getCurrentHunger() < Camarasaurus.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Camarasaurus.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Camarasaurus.this.getCurrentHunger() >= Camarasaurus.this.maxHunger || Camarasaurus.this.isAsleep()) {
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
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CAMARASAURUS_SPAWN_EGG.get());
	}

}
