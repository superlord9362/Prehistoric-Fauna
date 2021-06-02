package superlord.prehistoricfauna.entity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
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
import superlord.prehistoricfauna.block.AnkylosaurusEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

import java.util.Random;
import java.util.function.Predicate;

public class AnkylosaurusEntity extends AnimalEntity {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(AnkylosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(AnkylosaurusEntity.class, DataSerializers.BOOLEAN);
   private int warningSoundTicks;
   private int isDigging;

   public AnkylosaurusEntity(EntityType<? extends AnkylosaurusEntity> type, World worldIn) {
      super(type, worldIn);
   }

   public AgeableEntity createChild(AgeableEntity ageable) {
	   AnkylosaurusEntity entity = new AnkylosaurusEntity(ModEntityTypes.ANKYLOSAURUS_ENTITY, this.world);
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
	   return stack.getItem() == BlockInit.CLUBMOSS.get().asItem();
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new AnkylosaurusEntity.MeleeAttackGoal());
      this.goalSelector.addGoal(1, new AnkylosaurusEntity.PanicGoal());
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new AnkylosaurusEntity.HurtByTargetGoal());
      this.targetSelector.addGoal(2, new AnkylosaurusEntity.AttackPlayerGoal());
      this.targetSelector.addGoal(3, new AnkylosaurusEntity.ProtectBabyGoal());
      this.goalSelector.addGoal(8, new AnkylosaurusEntity.LayEggGoal(this, 1.0D));
      this.goalSelector.addGoal(2, new AnkylosaurusEntity.MateGoal(this, 1.0D));
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
	   return SoundHandler.ANKYLOSAURUS_IDLE;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	   return SoundHandler.ANKYLOSAURUS_HURT;
   }

   protected SoundEvent getDeathSound() {
	   return SoundHandler.ANKYLOSAURUS_DEATH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
	   this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
   }

   protected void playWarningSound() {
	   if (this.warningSoundTicks <= 0) {
		   this.playSound(SoundHandler.ANKYLOSAURUS_WARN, 1.0F, this.getSoundPitch());
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
         super(AnkylosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (AnkylosaurusEntity.this.isChild()) {
            return false;
         } else {
            if (super.shouldExecute()) {
               for(@SuppressWarnings("unused") AnkylosaurusEntity ankylosaurus : AnkylosaurusEntity.this.world.getEntitiesWithinAABB(AnkylosaurusEntity.class, AnkylosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
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
         super(AnkylosaurusEntity.this);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         super.startExecuting();
         if (AnkylosaurusEntity.this.isChild()) {
            this.alertOthers();
            this.resetTask();
         }

      }

      protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
         if (mobIn instanceof AnkylosaurusEntity && !mobIn.isChild()) {
            super.setAttackTarget(mobIn, targetIn);
         }

      }
   }

   class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
	      public MeleeAttackGoal() {
	          super(AnkylosaurusEntity.this, 1.25D, true);
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
	             	AnkylosaurusEntity.this.playWarningSound();
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
         super(AnkylosaurusEntity.this, 2.0D);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return !AnkylosaurusEntity.this.isChild() && !AnkylosaurusEntity.this.isBurning() ? false : super.shouldExecute();
      }
   }
   
   class ProtectBabyGoal extends NearestAttackableTargetGoal<PlayerEntity> {
	      public ProtectBabyGoal() {
	         super(AnkylosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         if (AnkylosaurusEntity.this.isChild()) {
	            return false;
	         } else {
	            if (super.shouldExecute()) {
	               for(AnkylosaurusEntity ankylosaurus : AnkylosaurusEntity.this.world.getEntitiesWithinAABB(AnkylosaurusEntity.class, AnkylosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
	                  if (ankylosaurus.isChild()) {
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
	      private final AnkylosaurusEntity ankylosaurus;

	      LayEggGoal(AnkylosaurusEntity ankylosaurus, double speedIn) {
	         super(ankylosaurus, speedIn, 16);
	         this.ankylosaurus = ankylosaurus;
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return this.ankylosaurus.hasEgg() ? super.shouldExecute() : false;
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         return super.shouldContinueExecuting() && this.ankylosaurus.hasEgg();
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         super.tick();
	         BlockPos blockpos = new BlockPos(this.ankylosaurus);
	         if (!this.ankylosaurus.isInWater() && this.getIsAboveDestination()) {
	            if (this.ankylosaurus.isDigging < 1) {
	               this.ankylosaurus.setDigging(true);
	            } else if (this.ankylosaurus.isDigging > 200) {
	               World world = this.ankylosaurus.world;
	               world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
	               world.setBlockState(this.destinationBlock.up(), BlockInit.ANKYLOSAURUS_EGG.get().getDefaultState().with(AnkylosaurusEggBlock.EGGS, Integer.valueOf(this.ankylosaurus.rand.nextInt(4) + 1)), 3);
	               this.ankylosaurus.setHasEgg(false);
	               this.ankylosaurus.setDigging(false);
	               this.ankylosaurus.setInLove(600);
	            }

	            if (this.ankylosaurus.isDigging()) {
	               this.ankylosaurus.isDigging++;
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
				return block == BlockInit.LOAM.get() || block == BlockInit.MOSSY_DIRT.get() || block == Blocks.PODZOL;
	         }
	      }
	   }

	static class MateGoal extends BreedGoal {
	      private final AnkylosaurusEntity ankylosaurus;

	      MateGoal(AnkylosaurusEntity ankylosaurus, double speedIn) {
	         super(ankylosaurus, speedIn);
	         this.ankylosaurus = ankylosaurus;
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return super.shouldExecute() && !this.ankylosaurus.hasEgg();
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

	         this.ankylosaurus.setHasEgg(true);
	         this.animal.resetInLove();
	         this.targetMate.resetInLove();
	         Random random = this.animal.getRNG();
	         if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
	            this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
	         }

	      }
	   }
	
}