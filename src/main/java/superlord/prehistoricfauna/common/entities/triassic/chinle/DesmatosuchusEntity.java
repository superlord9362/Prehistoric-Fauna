package superlord.prehistoricfauna.common.entities.triassic.chinle;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
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
import superlord.prehistoricfauna.common.blocks.DesmatosuchusEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class DesmatosuchusEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(DesmatosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(DesmatosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(DesmatosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(DesmatosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(DesmatosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(DesmatosuchusEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 50;
	private int currentHunger;
	int hungerTick = 0;
	private int lastInLove = 0;
	private int isDigging;
	private int warningSoundTicks;
	int loveTick = 0;

	public DesmatosuchusEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}

	public boolean isAlbino() {
		return this.dataManager.get(ALBINO);
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

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.NEOCALAMITES.asItem();
	}

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
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

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.DESMATOSUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.DESMATOSUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.DESMATOSUCHUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.DESMATOSUCHUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new DesmatosuchusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new DesmatosuchusEntity.PanicGoal());
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(3, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DesmatosuchusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(3, new DesmatosuchusEntity.ProtectBabyGoal());
		this.goalSelector.addGoal(0, new DesmatosuchusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DesmatosuchusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DesmatosuchusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new DesmatosuchusEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
		if (!this.isAIDisabled()) {
			List<DesmatosuchusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
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
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D).createMutableAttribute(Attributes.ARMOR, 4.0D).createMutableAttribute(Attributes.ARMOR_TOUGHNESS, 4.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3).createMutableAttribute(Attributes.FOLLOW_RANGE, 15);
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.applyEnchantments(this, entityIn);
			((LivingEntity)entityIn).addPotionEffect(new EffectInstance(PFEffects.BLEEDING.get(), 300, 0, false, false));
		}

		return flag;
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(DesmatosuchusEntity.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			super.startExecuting();
			if (DesmatosuchusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof DesmatosuchusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(DesmatosuchusEntity.this, 1.25D, true);
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
					DesmatosuchusEntity.this.playWarningSound();
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
			return (double)(9.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(DesmatosuchusEntity.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !DesmatosuchusEntity.this.isChild() && !DesmatosuchusEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	class ProtectBabyGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public ProtectBabyGoal() {
			super(DesmatosuchusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			if (DesmatosuchusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(DesmatosuchusEntity desmatosuchus : DesmatosuchusEntity.this.world.getEntitiesWithinAABB(DesmatosuchusEntity.class, DesmatosuchusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (desmatosuchus.isChild()) {
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
		private final DesmatosuchusEntity desmatosuchus;

		LayEggGoal(DesmatosuchusEntity desmatosuchus, double speedIn) {
			super(desmatosuchus, speedIn, 16);
			this.desmatosuchus = desmatosuchus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return this.desmatosuchus.hasEgg() ? super.shouldExecute() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.desmatosuchus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.desmatosuchus.getPositionVec());
			if (!this.desmatosuchus.isInWater() && this.getIsAboveDestination()) {
				if (this.desmatosuchus.isDigging < 1) {
					this.desmatosuchus.setDigging(true);
				} else if (this.desmatosuchus.isDigging > 200) {
					World world = this.desmatosuchus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.DESMATOSUCHUS_EGG.getDefaultState().with(DesmatosuchusEggBlock.EGGS, Integer.valueOf(this.desmatosuchus.rand.nextInt(4) + 1)), 3);
					this.desmatosuchus.setHasEgg(false);
					this.desmatosuchus.setDigging(false);
					this.desmatosuchus.setInLove(600);
				}

				if (this.desmatosuchus.isDigging()) {
					this.desmatosuchus.isDigging++;
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
		private final DesmatosuchusEntity desmatosuchus;

		MateGoal(DesmatosuchusEntity desmatosuchus, double speedIn) {
			super(desmatosuchus, speedIn);
			this.desmatosuchus = desmatosuchus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.desmatosuchus.hasEgg() && !this.desmatosuchus.isInLoveNaturally();
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

			this.desmatosuchus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final DesmatosuchusEntity desmatosuchus;

		NaturalMateGoal(DesmatosuchusEntity desmatosuchus, double speed) {
			super(desmatosuchus, speed);
			this.desmatosuchus = desmatosuchus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.desmatosuchus.hasEgg() && this.desmatosuchus.getCurrentHunger() >= this.desmatosuchus.getThreeQuartersHunger() && this.desmatosuchus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.desmatosuchus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.desmatosuchus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.desmatosuchus.rand.nextFloat() - this.desmatosuchus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.desmatosuchus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
					this.desmatosuchus.entityDropItem(PFBlocks.DESMATOSUCHUS_EGG.asItem());
				}
			} else {
				this.desmatosuchus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		DesmatosuchusEntity entity = new DesmatosuchusEntity(PFEntities.DESMATOSUCHUS_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(DesmatosuchusEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
					DesmatosuchusEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					DesmatosuchusEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = DesmatosuchusEntity.this.world.getBlockState(this.destinationBlock);

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 2 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 2);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 4 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 4);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 6 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 6);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 8 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 8);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 10 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 10);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 12 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 12);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 15 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 15);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 20 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 20);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 25 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 25);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				int hunger = DesmatosuchusEntity.this.getCurrentHunger();
				if (hunger + 30 >= DesmatosuchusEntity.this.maxHunger) {
					DesmatosuchusEntity.this.setHunger(DesmatosuchusEntity.this.maxHunger);
					DesmatosuchusEntity.this.setEating(false);
				} else {
					DesmatosuchusEntity.this.setHunger(hunger + 30);
					DesmatosuchusEntity.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !DesmatosuchusEntity.this.isAsleep() && super.shouldExecute() && DesmatosuchusEntity.this.getCurrentHunger() < DesmatosuchusEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (DesmatosuchusEntity.this.getCurrentHunger() >= DesmatosuchusEntity.this.maxHunger || DesmatosuchusEntity.this.isAsleep()) {
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

}
