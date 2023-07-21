package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
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
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Allosaurus extends DinosaurEntity {
	private int maxHunger = 150;
	int hungerTick = 0;
	private int warningSoundTicks;
	int loveTick = 0;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Allosaurus(EntityType<? extends Allosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 1.5F;
		else return 3.0F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_LARGE_THYREOPHORAN_MEAT.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_20_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_30_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_40_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_60_HUNGER);
		});
		this.goalSelector.addGoal(1, new Allosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Allosaurus.PanicGoal());
		this.targetSelector.addGoal(2, new Allosaurus.TerritoryAttackGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Allosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Allosaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Allosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new Allosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new Allosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_20_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_30_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_40_HUNGER);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_20_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_30_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_40_HUNGER) || p_213487_0_.getType().is(PFTags.ANIMALS_60_HUNGER);
		}));

	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F).add(Attributes.ATTACK_DAMAGE, 12.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.6D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.ALLOSAURUS_SNORES : PFSounds.ALLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.ALLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ALLOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.ALLOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
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
					if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.25F);
		}
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setAttackGoals();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
			((LivingEntity)entityIn).addEffect(new MobEffectInstance(PFEffects.BLEEDING.get(), 300, 0, true, false));
		}

		return flag;
	}	



	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Allosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Allosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Allosaurus allosaurus : Allosaurus.this.level.getEntitiesOfClass(Allosaurus.class, Allosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (allosaurus.isBaby()) {
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
			super(Allosaurus.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			super.start();
			if (Allosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Allosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Allosaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Allosaurus.this.playSound(PFSounds.ALLOSAURUS_BITE, 1.0F, Allosaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Allosaurus.this.playWarningSound();
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
			super(Allosaurus.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Allosaurus.this.isBaby() && !Allosaurus.this.isOnFire() ? false : super.canUse();
		}
	}

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<Player> {
		public TerritoryAttackGoal() {
			super(Allosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Allosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Allosaurus allosaurus : Allosaurus.this.level.getEntitiesOfClass(Allosaurus.class, Allosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						return true;
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
		private final Allosaurus allosaurus;

		LayEggGoal(Allosaurus allosaurus, double speedIn) {
			super(allosaurus, speedIn, 16);
			this.allosaurus = allosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.allosaurus.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.allosaurus.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.allosaurus.position());
			if (!this.allosaurus.isInWater() && this.isReachedTarget()) {
				if (this.allosaurus.isBirthing < 1) {
					this.allosaurus.setBirthing(true);
				} else if (this.allosaurus.isBirthing > 200) {
					Level world = this.allosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.ALLOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.allosaurus.random.nextInt(4) + 1)), 3);
					this.allosaurus.setHasBaby(false);
					this.allosaurus.setBirthing(false);
					this.allosaurus.setInLoveTime(600);
				}

				if (this.allosaurus.isBirthing()) {
					this.allosaurus.isBirthing++;
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
		private final Allosaurus allosaurus;

		MateGoal(Allosaurus allosaurus, double speedIn) {
			super(allosaurus, speedIn);
			this.allosaurus = allosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return super.canUse() && !this.allosaurus.hasBaby() && !this.allosaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void breed() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}

			this.allosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Allosaurus allosaurus;

		NaturalMateGoal(Allosaurus allosaurus, double speed) {
			super(allosaurus, speed);
			this.allosaurus = allosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.allosaurus.hasBaby() && this.allosaurus.getCurrentHunger() >= this.allosaurus.getThreeQuartersHunger() && this.allosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.allosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.allosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.allosaurus.random.nextFloat() - this.allosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.allosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
			} else {
				this.allosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Allosaurus entity = new Allosaurus(PFEntities.ALLOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		Predicate<LivingEntity> targetPredicate;
		double huntSpeed;
		
		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Allosaurus.this.getCurrentHunger() <= Allosaurus.this.getHalfHunger() && !Allosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Allosaurus.this);
		}

		public boolean canContinueToUse() {
			return Allosaurus.this.getCurrentHunger() > Allosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Allosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Allosaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 10 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 15 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 20 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_30_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 30 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 30);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_40_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 40 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 40);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_60_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 60 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 60);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class BabyCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		Predicate<LivingEntity> targetPredicate;
		double huntSpeed;
		
		@SuppressWarnings("unchecked")
		public BabyCarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Allosaurus.this.getCurrentHunger() <= Allosaurus.this.getHalfHunger() && Allosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Allosaurus.this);
		}

		public boolean canContinueToUse() {
			return Allosaurus.this.getCurrentHunger() > Allosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Allosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Allosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Allosaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 3 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 4 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 6 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ALLOSAURUS_SPAWN_EGG.get());
	}

}