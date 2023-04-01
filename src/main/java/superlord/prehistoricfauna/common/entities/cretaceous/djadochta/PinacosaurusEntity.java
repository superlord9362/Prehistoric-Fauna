package superlord.prehistoricfauna.common.entities.cretaceous.djadochta;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class PinacosaurusEntity extends DinosaurEntity {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(PinacosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(PinacosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(PinacosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(PinacosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(PinacosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(PinacosaurusEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 100;
	private int lastInLove = 0;
	private int currentHunger;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	int loveTick = 0;

	public PinacosaurusEntity(EntityType<? extends PinacosaurusEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public AgeableEntity createChild(AgeableEntity ageable) {
		PinacosaurusEntity entity = new PinacosaurusEntity(PFEntities.PINACOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}

	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}

	public boolean isAlbino() {
		return this.dataManager.get(ALBINO);
	}

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
	}

	private void setAlbino(boolean isAlbino) {
		this.dataManager.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.dataManager.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.dataManager.set(MELANISTIC, isMelanistic);
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
		return this.dataManager.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.dataManager.set(EATING, isEating);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.asItem();
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber == 4) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.1F;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new PinacosaurusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PinacosaurusEntity.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new PinacosaurusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(3, new PinacosaurusEntity.ProtectBabyGoal());
		this.goalSelector.addGoal(0, new PinacosaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new PinacosaurusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new PinacosaurusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new PinacosaurusEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(10, new PinacosaurusEntity.RidePinacosaurusGoal(this));
	}

	public void livingTick() {
		super.livingTick();

		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		}
		if (!this.isAIDisabled()) {
			List<PinacosaurusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isChild() || hungerTick == 300 && this.isChild()) {
					hungerTick = 0;
					if (currentHunger != 0 || !this.isAsleep()) {
						this.setHunger(currentHunger - 1);
					}
					if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && this.getHealth() > (this.getMaxHealth() / 2)) {
						this.damageEntity(DamageSource.STARVE, 1);
					}
					if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && world.getDifficulty() == Difficulty.HARD) {
						this.damageEntity(DamageSource.STARVE, 1);
					}
				}if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getAttackTarget() == null && this.getRevengeTarget() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 6) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLove(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				int naturalBreedingChance = rand.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 6) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLove(600);
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

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 40.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D).createMutableAttribute(Attributes.ARMOR, 10D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.PINACOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.PINACOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.PINACOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.PINACOSAURUS_WARNING, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(EATING, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
		if (!this.isBeingRidden() && !player.isSecondaryUseActive() && !this.isChild() && !this.isSleeping()) {
			boolean flag = this.isBreedingItem(player.getHeldItem(hand));
			if (!flag && !this.isBeingRidden() && !player.isSecondaryUseActive()) {
				if (!this.world.isRemote) {
					player.startRiding(this);
				}
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}
		} else if (!this.getPassengers().isEmpty()) {
			this.removePassengers();
		}
		return super.func_230254_b_(player, hand);
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
			for (Entity e : world.getEntitiesWithinAABBExcludingEntity(this, getBoundingBox().grow(0.5))) {
				if (e instanceof MobEntity && e.getWidth() <= 0.75F && e.getHeight() <= 0.75F && !this.isChild() && ((MobEntity)e).getCreatureAttribute() != CreatureAttribute.WATER && !this.isInWater()) {
					e.startRiding(this);
				}
			}
		} else if (!getPassengers().isEmpty() && this.isInWater()) {
			this.removePassengers();
		}
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	@Override
	public boolean canBeSteered() {
		return false;
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}	

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(PinacosaurusEntity.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			super.startExecuting();
			if (PinacosaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof PinacosaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(PinacosaurusEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.func_234040_h_()) {
					this.func_234039_g_();
				}

				if (this.func_234041_j_() <= 10) {
					PinacosaurusEntity.this.playWarningSound();
				}
			} else {
				this.func_234039_g_();
			}

		}

		public boolean shouldContinueExecuting() {
			float f = this.attacker.getBrightness();
			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((LivingEntity)null);
				return false;
			} else {
				return super.shouldContinueExecuting();
			}
		}

		public void resetTask() {
			super.resetTask();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(8.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(PinacosaurusEntity.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !PinacosaurusEntity.this.isChild() && !PinacosaurusEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	class ProtectBabyGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public ProtectBabyGoal() {
			super(PinacosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			if (PinacosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(PinacosaurusEntity pinacosaurus : PinacosaurusEntity.this.world.getEntitiesWithinAABB(PinacosaurusEntity.class, PinacosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (pinacosaurus.isChild()) {
							return true;
						}
					}
				}

				return false;
			}
		}

		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final PinacosaurusEntity pinacosaurus;

		LayEggGoal(PinacosaurusEntity pinacosaurus, double speedIn) {
			super(pinacosaurus, speedIn, 16);
			this.pinacosaurus = pinacosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return this.pinacosaurus.hasEgg() ? super.shouldExecute() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.pinacosaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.pinacosaurus.getPositionVec());
			if (!this.pinacosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.pinacosaurus.isDigging < 1) {
					this.pinacosaurus.setDigging(true);
				} else if (this.pinacosaurus.isDigging > 200) {
					World world = this.pinacosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.PINACOSAURUS_EGG.getDefaultState().with(DinosaurEggBlock.EGGS, Integer.valueOf(this.pinacosaurus.rand.nextInt(4) + 1)), 3);
					this.pinacosaurus.setHasEgg(false);
					this.pinacosaurus.setDigging(false);
					this.pinacosaurus.setInLove(600);
				}

				if (this.pinacosaurus.isDigging()) {
					this.pinacosaurus.isDigging++;
				}
			}

		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.MOSS_BLOCK || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.SILT || block == PFBlocks.PACKED_LOAM || block == BlockTags.LEAVES;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final PinacosaurusEntity pinacosaurus;

		MateGoal(PinacosaurusEntity pinacosaurus, double speedIn) {
			super(pinacosaurus, speedIn);
			this.pinacosaurus = pinacosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.pinacosaurus.hasEgg() && !this.pinacosaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}

			this.pinacosaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final PinacosaurusEntity pinacosaurus;

		NaturalMateGoal(PinacosaurusEntity pinacosaurus, double speed) {
			super(pinacosaurus, speed);
			this.pinacosaurus = pinacosaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.pinacosaurus.hasEgg() && this.pinacosaurus.getCurrentHunger() >= this.pinacosaurus.getThreeQuartersHunger() && this.pinacosaurus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.pinacosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.pinacosaurus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.pinacosaurus.rand.nextFloat() - this.pinacosaurus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.pinacosaurus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
					this.pinacosaurus.entityDropItem(PFBlocks.PINACOSAURUS_EGG.asItem());
				}
			} else {
				this.pinacosaurus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		PinacosaurusEntity entity = new PinacosaurusEntity(PFEntities.PINACOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(PinacosaurusEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.timeoutCounter % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.DICROIDIUM) || blockstate.isIn(PFBlocks.JOHNSTONIA) || blockstate.isIn(PFBlocks.CLADOPHLEBIS) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.OTOZAMITES) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.VINE) || blockstate.isIn(BlockTags.FLOWERS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(Blocks.LARGE_FERN);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.getIsAboveDestination()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					PinacosaurusEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					PinacosaurusEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = PinacosaurusEntity.this.world.getBlockState(this.destinationBlock);
			int hunger = PinacosaurusEntity.this.getCurrentHunger();

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				if (hunger + 2 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 2);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				if (hunger + 4 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 4);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				if (hunger + 6 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 6);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				if (hunger + 8 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 8);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				if (hunger + 10 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 10);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				if (hunger + 12 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 12);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				if (hunger + 15 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 15);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				if (hunger + 20 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 20);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				if (hunger + 25 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 25);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				if (hunger + 30 >= PinacosaurusEntity.this.maxHunger) {
					PinacosaurusEntity.this.setHunger(PinacosaurusEntity.this.maxHunger);
				} else {
					PinacosaurusEntity.this.setHunger(hunger + 30);
				}
			}
			PinacosaurusEntity.this.setEating(false);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !PinacosaurusEntity.this.isAsleep() && super.shouldExecute() && PinacosaurusEntity.this.getCurrentHunger() < PinacosaurusEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (PinacosaurusEntity.this.getCurrentHunger() >= PinacosaurusEntity.this.maxHunger || PinacosaurusEntity.this.isAsleep()) {
				return false;
			} else return super.shouldContinueExecuting();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_220731_g = 0;
			super.startExecuting();
		}
	}

	public class RidePinacosaurusGoal extends Goal {
		private final MobEntity entity;

		public RidePinacosaurusGoal(MobEntity entity) {
			this.entity = entity;
		}

		@Override
		public boolean shouldExecute() {
			return entity.ticksExisted % 60 == 0 && entity.getPassengers().isEmpty();
		}

		@Override
		public boolean shouldContinueExecuting() {
			return entity.ticksExisted % 80 != 0;
		}

		@Override
		public void startExecuting() {
			super.startExecuting();
			for (MobEntity mobEntity : entity.world.getEntitiesWithinAABB(MobEntity.class, entity.getBoundingBox().grow(5), e -> e != entity && e.getRidingEntity() == null)) {
				if (mobEntity.getWidth() <= 0.75F && mobEntity.getHeight() <= 0.75F) {
					mobEntity.getNavigator().tryMoveToEntityLiving(entity, mobEntity.getAIMoveSpeed() + 0.4);
				}
			}
		}
	}

}