package superlord.prehistoricfauna.entity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
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
import superlord.prehistoricfauna.block.StegosaurusEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

import java.util.Random;
import java.util.function.Predicate;

public class StegosaurusEntity extends PrehistoricEntity {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(StegosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(StegosaurusEntity.class, DataSerializers.BOOLEAN);
   private int warningSoundTicks;
   private int isDigging;

   public StegosaurusEntity(EntityType<? extends StegosaurusEntity> type, World worldIn) {
      super(type, worldIn);
   }

   public AgeableEntity createChild(AgeableEntity ageable) {
	   StegosaurusEntity entity = new StegosaurusEntity(ModEntityTypes.STEGOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
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
	   return stack.getItem() == BlockInit.ZAMITES_LEAVES.asItem();
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new StegosaurusEntity.MeleeAttackGoal());
      this.goalSelector.addGoal(1, new StegosaurusEntity.PanicGoal());
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new StegosaurusEntity.HurtByTargetGoal());
      this.targetSelector.addGoal(2, new StegosaurusEntity.AttackPlayerGoal());
      this.targetSelector.addGoal(3, new StegosaurusEntity.ProtectBabyGoal());
      this.goalSelector.addGoal(8, new StegosaurusEntity.LayEggGoal(this, 1.0D));
      this.goalSelector.addGoal(2, new StegosaurusEntity.MateGoal(this, 1.0D));
   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
      this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
      this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
      this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(0.0F);
      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
   }
   
   protected SoundEvent getAmbientSound() {
	   return SoundHandler.STEGOSAURUS_IDLE;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	   return SoundHandler.STEGOSAURUS_HURT;
   }

   protected SoundEvent getDeathSound() {
	   return SoundHandler.STEGOSAURUS_DEATH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
	   this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
   }

   protected void playWarningSound() {
	   if (this.warningSoundTicks <= 0) {
		   this.playSound(SoundHandler.STEGOSAURUS_WARN, 1.0F, this.getSoundPitch());
		   this.warningSoundTicks = 40;
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

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.warningSoundTicks > 0) {
         --this.warningSoundTicks;
      }
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
         super(StegosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (StegosaurusEntity.this.isChild()) {
            return false;
         } else {
            if (super.shouldExecute()) {
               for(@SuppressWarnings("unused") StegosaurusEntity stegosaurus : StegosaurusEntity.this.world.getEntitiesWithinAABB(StegosaurusEntity.class, StegosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
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

   class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
      public HurtByTargetGoal() {
         super(StegosaurusEntity.this);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         super.startExecuting();
         if (StegosaurusEntity.this.isChild()) {
            this.alertOthers();
            this.resetTask();
         }

      }

      protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
         if (mobIn instanceof StegosaurusEntity && !mobIn.isChild()) {
            super.setAttackTarget(mobIn, targetIn);
         }

      }
   }

   class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
      public MeleeAttackGoal() {
         super(StegosaurusEntity.this, 1.25D, true);
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

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         super.resetTask();
      }

      protected double getAttackReachSqr(LivingEntity attackTarget) {
         return (double)(4.0F + attackTarget.getWidth());
      }
   }

   class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
      public PanicGoal() {
         super(StegosaurusEntity.this, 2.0D);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return !StegosaurusEntity.this.isChild() && !StegosaurusEntity.this.isBurning() ? false : super.shouldExecute();
      }
   }
   
   class ProtectBabyGoal extends NearestAttackableTargetGoal<PlayerEntity> {
	      public ProtectBabyGoal() {
	         super(StegosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         if (StegosaurusEntity.this.isChild()) {
	            return false;
	         } else {
	            if (super.shouldExecute()) {
	               for(StegosaurusEntity stegosaurus : StegosaurusEntity.this.world.getEntitiesWithinAABB(StegosaurusEntity.class, StegosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
	                  if (stegosaurus.isChild()) {
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
	      private final StegosaurusEntity stegosaurus;

	      LayEggGoal(StegosaurusEntity stegosaurus, double speedIn) {
	         super(stegosaurus, speedIn, 16);
	         this.stegosaurus = stegosaurus;
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return this.stegosaurus.hasEgg() ? super.shouldExecute() : false;
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         return super.shouldContinueExecuting() && this.stegosaurus.hasEgg();
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         super.tick();
	         BlockPos blockpos = new BlockPos(this.stegosaurus);
	         if (!this.stegosaurus.isInWater() && this.getIsAboveDestination()) {
	            if (this.stegosaurus.isDigging < 1) {
	               this.stegosaurus.setDigging(true);
	            } else if (this.stegosaurus.isDigging > 200) {
	               World world = this.stegosaurus.world;
	               world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
	               world.setBlockState(this.destinationBlock.up(), BlockInit.STEGOSAURUS_EGG.getDefaultState().with(StegosaurusEggBlock.EGGS, Integer.valueOf(this.stegosaurus.rand.nextInt(4) + 1)), 3);
	               this.stegosaurus.setHasEgg(false);
	               this.stegosaurus.setDigging(false);
	               this.stegosaurus.setInLove(600);
	            }

	            if (this.stegosaurus.isDigging()) {
	               this.stegosaurus.isDigging++;
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
	            return block == Blocks.COARSE_DIRT;
	         }
	      }
	   }

	static class MateGoal extends BreedGoal {
	      private final StegosaurusEntity stegosaurus;

	      MateGoal(StegosaurusEntity stegosaurus, double speedIn) {
	         super(stegosaurus, speedIn);
	         this.stegosaurus = stegosaurus;
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return super.shouldExecute() && !this.stegosaurus.hasEgg();
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

	         this.stegosaurus.setHasEgg(true);
	         this.animal.resetInLove();
	         this.targetMate.resetInLove();
	         Random random = this.animal.getRNG();
	         if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
	            this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
	         }

	      }
	   }
	
}