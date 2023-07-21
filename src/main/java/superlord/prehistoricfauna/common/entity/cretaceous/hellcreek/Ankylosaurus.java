package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Ankylosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> TUBER_DIGGING = SynchedEntityData.defineId(Ankylosaurus.class, EntityDataSerializers.BOOLEAN);
	private int warningSoundTicks = 200;
	private int maxHunger = 200;

	@SuppressWarnings("deprecation")
	public Ankylosaurus(EntityType<? extends Ankylosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Ankylosaurus entity = new Ankylosaurus(PFEntities.ANKYLOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public int getMaxAir() {
		return 0;
	}
	
	public boolean isTuberDigging() {
		return this.entityData.get(TUBER_DIGGING);
	}

	private void setTuberDigging(boolean isTuberDigging) {
		this.entityData.set(TUBER_DIGGING, isTuberDigging);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLUBMOSS.get().asItem();
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.76F;
		else return 1.5F;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		}
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Ankylosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Ankylosaurus.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(6, new BirthingGoal(this));
		this.targetSelector.addGoal(1, new Ankylosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Ankylosaurus.AttackPlayerGoal());
		this.targetSelector.addGoal(3, new Ankylosaurus.ProtectBabyGoal());
		this.goalSelector.addGoal(0, new Ankylosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Ankylosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Ankylosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 80.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ARMOR, 10D).add(Attributes.ATTACK_DAMAGE, 14.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.ANKYLOSAURUS_SNORES : PFSounds.ANKYLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.ANKYLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ANKYLOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.ANKYLOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TUBER_DIGGING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("TuberDigging", this.isTuberDigging());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTuberDigging(compound.getBoolean("TuberDigging"));
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
		}

		return flag;
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Ankylosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Ankylosaurus.this.isBaby() || Ankylosaurus.this.isAsleep()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Ankylosaurus ankylosaurus : Ankylosaurus.this.level.getEntitiesOfClass(Ankylosaurus.class, Ankylosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Ankylosaurus.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			super.start();
			if (Ankylosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Ankylosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}
	
	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Ankylosaurus.this, 1.25D, true);
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
					Ankylosaurus.this.playWarningSound();
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

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Ankylosaurus.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Ankylosaurus.this.isBaby() && !Ankylosaurus.this.isOnFire() ? false : super.canUse();
		}
	}

	class ProtectBabyGoal extends NearestAttackableTargetGoal<Player> {
		public ProtectBabyGoal() {
			super(Ankylosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Ankylosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Ankylosaurus ankylosaurus : Ankylosaurus.this.level.getEntitiesOfClass(Ankylosaurus.class, Ankylosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (ankylosaurus.isBaby()) {
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
		private final Ankylosaurus ankylosaurus;

		LayEggGoal(Ankylosaurus ankylosaurus, double speedIn) {
			super(ankylosaurus, speedIn, 16);
			this.ankylosaurus = ankylosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.ankylosaurus.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.ankylosaurus.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.ankylosaurus.blockPosition());
			if (!this.ankylosaurus.isInWater() && this.isReachedTarget()) {
				if (this.ankylosaurus.isBirthing < 1) {
					this.ankylosaurus.setBirthing(true);
				} else if (this.ankylosaurus.isBirthing > 200) {
					Level level = this.ankylosaurus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.ANKYLOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.ankylosaurus.random.nextInt(4) + 1)), 3);
					this.ankylosaurus.setHasBaby(false);
					this.ankylosaurus.setBirthing(false);
					this.ankylosaurus.setInLoveTime(600);
				}

				if (this.ankylosaurus.isBirthing()) {
					this.ankylosaurus.isBirthing++;
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
		private final Ankylosaurus ankylosaurus;

		MateGoal(Ankylosaurus ankylosaurus, double speedIn) {
			super(ankylosaurus, speedIn);
			this.ankylosaurus = ankylosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return super.canUse() && !this.ankylosaurus.hasBaby() && !this.ankylosaurus.isInLoveNaturally();
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

			this.ankylosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Ankylosaurus ankylosaurus;

		NaturalMateGoal(Ankylosaurus ankylosaurus, double speed) {
			super(ankylosaurus, speed);
			this.ankylosaurus = ankylosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.ankylosaurus.hasBaby() && this.ankylosaurus.getCurrentHunger() >= this.ankylosaurus.getThreeQuartersHunger() && this.ankylosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.ankylosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.ankylosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.ankylosaurus.random.nextFloat() - this.ankylosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.ankylosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
					this.ankylosaurus.spawnAtLocation(PFBlocks.ANKYLOSAURUS_EGG.get().asItem());
				}
			} else {
				this.ankylosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	static class BirthingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/ankylosaurus_digging");

		private final Ankylosaurus ankylosaurus;
		private int diggingTimer;
		private int digTimer2;

		public BirthingGoal(Ankylosaurus entity) {
			this.ankylosaurus = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			if (ankylosaurus.getRandom().nextInt(ankylosaurus.isBaby() ? 100 : 1000) != 0) {
				return false;
			} else {
				BlockPos blockpos = ankylosaurus.blockPosition();
				BlockState state = ankylosaurus.level.getBlockState(blockpos);
				if (state.is(BlockTags.DIRT)) {
					return true;
				} else {
					return ankylosaurus.level.getBlockState(blockpos.below()).is(BlockTags.DIRT);
				}
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			ankylosaurus.level.broadcastEntityEvent(ankylosaurus, (byte) 10);
			ankylosaurus.setTuberDigging(true);
			ankylosaurus.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
			ankylosaurus.setTuberDigging(false);
		}

		@Override
		public boolean canContinueToUse() {
			return diggingTimer > 0;
		}

		@Override
		public void tick() {
			if (digTimer2 > 0) {
				--digTimer2;
			}
			if (diggingTimer > 0) {
				--diggingTimer;
			}
			if (diggingTimer == 25) {
				BlockPos blockpos = ankylosaurus.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (ankylosaurus.level.getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = ankylosaurus.level.getBlockState(blockpos1);
					ankylosaurus.level.levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = ankylosaurus.level.getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootTables().get(DIGGING_LOOT).getRandomItems(new LootContext.Builder((ServerLevel) ankylosaurus.level).withRandom(ankylosaurus.getRandom()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(ankylosaurus.level, blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}

	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Ankylosaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			if (!Ankylosaurus.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Ankylosaurus.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Ankylosaurus.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Ankylosaurus.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Ankylosaurus.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Ankylosaurus.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Ankylosaurus.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Ankylosaurus.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
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
					Ankylosaurus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Ankylosaurus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Ankylosaurus.this.getCurrentHunger() >= 13) {
				Ankylosaurus.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Ankylosaurus.this.maxHunger - Ankylosaurus.this.getCurrentHunger();
			int hunger = Ankylosaurus.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Ankylosaurus.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Ankylosaurus.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Ankylosaurus.this.setHunger(Ankylosaurus.this.maxHunger);
				Ankylosaurus.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Ankylosaurus.this.setHunger(hunger + foodContained);
				Ankylosaurus.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Ankylosaurus.this.isAsleep() && super.canUse() && Ankylosaurus.this.getCurrentHunger() < Ankylosaurus.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Ankylosaurus.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Ankylosaurus.this.getCurrentHunger() >= Ankylosaurus.this.maxHunger || Ankylosaurus.this.isAsleep()) {
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
		return new ItemStack(PFItems.ANKYLOSAURUS_SPAWN_EGG.get());
	}
}