package superlord.prehistoricfauna.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.block.TyrannosaurusEggBlock;
import superlord.prehistoricfauna.entity.goal.PrehistoricBreedGoal;
import superlord.prehistoricfauna.entity.goal.PrehistoricFollowParentGoal;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.PrehistoricCriteriaTriggers;
import superlord.prehistoricfauna.util.SoundHandler;

public class EntityTyrannosaurus extends PrehistoricStagedEntity {
	
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(EntityTyrannosaurus.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(EntityTyrannosaurus.class, DataSerializers.BOOLEAN);
	private int isDigging;
	private int warningSoundTicks;
	
	public EntityTyrannosaurus(EntityType<? extends EntityTyrannosaurus> type, World world) {
		super(type, world);
	}
	
	public ThreeStageAgeEntity createChild(ThreeStageAgeEntity ageable) {
		EntityTyrannosaurus entity = new EntityTyrannosaurus(ModEntityTypes.ENTITY_TYRANNOSAURUS, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
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
	
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ItemInit.RAW_TRICERATOPS_MEAT.get();
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(5, new EntityTyrannosaurus.PanicGoal());
		this.goalSelector.addGoal(5, new EntityTyrannosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(6, new PrehistoricFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(7, new EntityTyrannosaurus.HuntThescelosaurusGoal(this));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(15, new EntityTyrannosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(11, new EntityTyrannosaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(12, new EntityTyrannosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(13, new EntityTyrannosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new EntityTyrannosaurus.AttackTyrannosaurusGoal(this));
	}
	
	public void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	    this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	    this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundHandler.TYRANNOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.TYRANNOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundHandler.TYRANNOSAURUS_HURT;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundHandler.TYRANNOSAURUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}
	
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	public void livingTick() {

		super.livingTick();
	}
	
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	public EntitySize getSize(Pose poseIn) {
		if(this.isBaby()) {
			return super.getSize(poseIn).scale(0.255F);
		} else if(this.isChild()) {
			return super.getSize(poseIn).scale(0.5F);
		} else {
			return super.getSize(poseIn).scale(1.0F);
		}
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
	}
	   
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
	}
	   
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
	}
	
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
	    return flag;
	}
	
	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(EntityTyrannosaurus.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}
		public boolean shouldExecute() {
			if (EntityTyrannosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(EntityTyrannosaurus tyrannosaurus : EntityTyrannosaurus.this.world.getEntitiesWithinAABB(EntityTyrannosaurus.class, EntityTyrannosaurus.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (tyrannosaurus.isChild()) {
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
	
	class JuvenileAttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public JuvenileAttackPlayerGoal() {
			super(EntityTyrannosaurus.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}
		public boolean shouldExecute() {
			if (EntityTyrannosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(@SuppressWarnings("unused") EntityTyrannosaurus tyrannosaurus : EntityTyrannosaurus.this.world.getEntitiesWithinAABB(EntityTyrannosaurus.class, EntityTyrannosaurus.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						return true;
					}
				}
				return false;
			}
		}
		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
	}
	
	class AttackTyrannosaurusGoal extends NearestAttackableTargetGoal<EntityThescelosaurus> {
		private final EntityTyrannosaurus tyrannosaurus;
		public AttackTyrannosaurusGoal(EntityTyrannosaurus tyrannosaurus) {
			super(EntityTyrannosaurus.this, EntityThescelosaurus.class, 20, true, true, (Predicate<LivingEntity>)null);
			this.tyrannosaurus = tyrannosaurus;
		}
		public boolean shouldExecute() {
			if (EntityTyrannosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.shouldExecute() && tyrannosaurus.world.getGameTime() >= 0 && tyrannosaurus.world.getGameTime() < 94000 && tyrannosaurus.world.getGameTime() >= 118001 && tyrannosaurus.world.getGameTime() < 190000) {
					return true;
				}
				return false;
			}
		}
		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
	}
	
	class HuntThescelosaurusGoal extends NearestAttackableTargetGoal<EntityPrehistoric> {
		private EntityPrehistoric target;
		private int huntingTimer;
		public HuntThescelosaurusGoal(EntityTyrannosaurus tyrannosaurus) {
			super(EntityTyrannosaurus.this, EntityPrehistoric.class, 20, true, true, (Predicate<LivingEntity>)null);
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}
		public boolean shouldExecute() {
			if (EntityTyrannosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.shouldExecute() && target instanceof EntityThescelosaurus && this.huntingTimer == 40) {
					return true;
				} else if (super.shouldExecute() && target instanceof EntityTriceratops && this.huntingTimer == 60 || super.shouldExecute() && target instanceof EntityAnkylosaurus && this.huntingTimer == 60) {
					return true;
				}
				return false;
			}
		}
		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
		public void resetTask() {
			this.huntingTimer = 0;
		}
		public boolean shouldContinueExecuting() {
			return this.huntingTimer > 0;
		}
		public int getHuntingTimer() {
			return this.huntingTimer;
		}
		public void tick() {
			this.huntingTimer = Math.max(0, this.huntingTimer - 1);
		}
		
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(EntityTyrannosaurus.this);
		}
		public void startExecuting() {
			super.startExecuting();
			if (EntityTyrannosaurus.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}
		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof EntityTyrannosaurus && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(EntityTyrannosaurus.this, 1.25D, true);
		}
		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.attackTick <= 0) {
				this.attackTick = 20;
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.attackTick <= 0) {
					this.attackTick = 20;
				}
				if (this.attackTick <= 10) {
				}
			} else {
				this.attackTick = 20;
			}
		}
		public void resetTask() {
			super.resetTask();
		}
		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(EntityTyrannosaurus.this, 2.0D);
		}
		public boolean shouldExecute() {
			return !EntityTyrannosaurus.this.isBaby() && !EntityTyrannosaurus.this.isBurning() ? false : super.shouldExecute();
		}
	}
		   
	static class LayEggGoal extends MoveToBlockGoal {
		private final EntityTyrannosaurus tyrannosaurus;
		LayEggGoal(EntityTyrannosaurus tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn, 16);
			this.tyrannosaurus = tyrannosaurus;
		}
		public boolean shouldExecute() {
			return this.tyrannosaurus.hasEgg() ? super.shouldExecute() : false;
		}
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.tyrannosaurus.hasEgg();
		}
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.tyrannosaurus);
			if (!this.tyrannosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.tyrannosaurus.isDigging < 1) {
					this.tyrannosaurus.setDigging(true);
				} else if (this.tyrannosaurus.isDigging > 200) {
					World world = this.tyrannosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), BlockInit.TYRANNOSAURUS_EGG.getDefaultState().with(TyrannosaurusEggBlock.EGGS, Integer.valueOf(this.tyrannosaurus.rand.nextInt(4) + 1)), 3);
					this.tyrannosaurus.setHasEgg(false);
					this.tyrannosaurus.setDigging(false);
					this.tyrannosaurus.setInLove(600);
				}
				if (this.tyrannosaurus.isDigging()) {
					this.tyrannosaurus.isDigging++;
				}
			}
		}
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.COARSE_DIRT;
			}
		}
	}
	
	static class MateGoal extends PrehistoricBreedGoal {
		private final EntityTyrannosaurus tyrannosaurus;
		MateGoal(EntityTyrannosaurus tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn);
			this.tyrannosaurus = tyrannosaurus;
		}
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.tyrannosaurus.hasEgg() && this.world.getGameTime() >= 94000 && this.world.getGameTime() < 118001;
		}
		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}
			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				PrehistoricCriteriaTriggers.BRED_DINOSAUR.trigger(serverplayerentity, this.animal, this.targetMate, (ThreeStageAgeEntity)null);
			}
			this.tyrannosaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
	}
}