package superlord.prehistoricfauna.entity;

import java.util.Random;
import java.util.function.Predicate;

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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.block.TriceratopsEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

public class TriceratopsEntity extends AbstractChestedHorseEntity  {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private int warningSoundTicks;
	private int isDigging;
    public float ridingXZ;
    public float ridingY = 1;
    private boolean allowStandSliding;
    
    public TriceratopsEntity(EntityType<? extends TriceratopsEntity> type, World worldIn) {
		super(type, worldIn);
	}
   
	public AgeableEntity createChild(AgeableEntity ageable) {
		TriceratopsEntity entity = new TriceratopsEntity(ModEntityTypes.TRICERATOPS_ENTITY, this.world);
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

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == BlockInit.CLUBMOSS.asItem();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new TriceratopsEntity.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		if(!this.isTame()) {
			this.targetSelector.addGoal(1, new TriceratopsEntity.HurtByTargetGoal());
			this.targetSelector.addGoal(2, new TriceratopsEntity.AttackPlayerGoal());
			this.goalSelector.addGoal(1, new TriceratopsEntity.MeleeAttackGoal());
		}
		this.goalSelector.addGoal(8, new TriceratopsEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TriceratopsEntity.MateGoal(this, 1.0D));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}
   
	protected SoundEvent getAmbientSound() {
		return SoundHandler.TRICERATOPS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.TRICERATOPS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundHandler.TRICERATOPS_DEATH;
	}
	
	protected SoundEvent getAngrySound() {
		return SoundHandler.TRICERATOPS_WARN;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

   protected void playWarningSound() {
	   if (this.warningSoundTicks <= 0) {
		   this.playSound(SoundHandler.TRICERATOPS_WARN, 1.0F, this.getSoundPitch());
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
   
   public PlayerEntity getRidingPlayer() {
	   if (this.getControllingPassenger() instanceof PlayerEntity) {
		   return (PlayerEntity) getControllingPassenger();
	   } else {
		   return null;
	   }
   }
   
   @Override
   public void updatePassenger(Entity passenger) {
       super.updatePassenger(passenger);
       if (this.isPassenger(passenger)) {
           renderYawOffset = rotationYaw;
           this.rotationYaw = passenger.rotationYaw;
       }
       if (this.getRidingPlayer() != null && this.getRidingPlayer() instanceof PlayerEntity && this.getAttackTarget() != this.getRidingPlayer()) {
           rotationYaw = renderYawOffset;
           rotationYaw = this.getRidingPlayer().rotationYaw;
           rotationYawHead = this.getRidingPlayer().rotationYaw;
           float radius = ridingXZ * 0.7F * -3;
           float angle = (0.01745329251F * this.renderYawOffset);
           double extraX = radius * MathHelper.sin((float) (Math.PI + angle));
           double extraZ = radius * MathHelper.cos(angle);
           double extraY = ridingY * 4;
           this.getRidingPlayer().setPosition(this.getPosX() + extraX, this.getPosY() + extraY - 1.75F, this.getPosZ() + extraZ);
       }
   }
   
   public void travel(Vec3d positionIn) {
	      if (this.isAlive()) {
	         if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled()) {
	            LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
	            this.rotationYaw = livingentity.rotationYaw;
	            this.prevRotationYaw = this.rotationYaw;
	            this.rotationPitch = livingentity.rotationPitch * 0.5F;
	            this.setRotation(this.rotationYaw, this.rotationPitch);
	            this.renderYawOffset = this.rotationYaw;
	            this.rotationYawHead = this.renderYawOffset;
	            float f = livingentity.moveStrafing * 0.5F;
	            float f1 = livingentity.moveForward;
	            if (f1 <= 0.0F) {
	               f1 *= 0.25F;
	               this.gallopTime = 0;
	            }

	            if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.allowStandSliding) {
	               f = 0.0F;
	               f1 = 0.0F;
	            }

	            if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
	               double d0 = this.getHorseJumpStrength() * (double)this.jumpPower * (double)this.getJumpFactor();
	               double d1;
	               if (this.isPotionActive(Effects.JUMP_BOOST)) {
	                  d1 = d0 + (double)((float)(this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
	               } else {
	                  d1 = d0;
	               }

	               Vec3d vec3d = this.getMotion();
	               this.setMotion(vec3d.x, d1, vec3d.z);
	               this.setHorseJumping(true);
	               this.isAirBorne = true;
	               net.minecraftforge.common.ForgeHooks.onLivingJump(this);
	               if (f1 > 0.0F) {
	                  float f2 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F));
	                  float f3 = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F));
	                  this.setMotion(this.getMotion().add((double)(-0.4F * f2 * this.jumpPower), 0.0D, (double)(0.4F * f3 * this.jumpPower)));
	                  this.playJumpSound();
	               }

	               this.jumpPower = 0.0F;
	            }

	            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
	            if (this.canPassengerSteer()) {
	               this.setAIMoveSpeed((float)this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
	               super.travel(new Vec3d((double)f, positionIn.y, (double)f1));
	            } else if (livingentity instanceof PlayerEntity) {
	               this.setMotion(Vec3d.ZERO);
	            }

	            if (this.onGround) {
	               this.jumpPower = 0.0F;
	               this.setHorseJumping(false);
	            }
	         } else {
	            this.jumpMovementFactor = 0.02F;
	            super.travel(positionIn);
	         }
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
         super(TriceratopsEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (TriceratopsEntity.this.isChild()) {
            return false;
         } else {
            if (super.shouldExecute()) {
               for(TriceratopsEntity triceratops : TriceratopsEntity.this.world.getEntitiesWithinAABB(TriceratopsEntity.class, TriceratopsEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
                  if (triceratops.isChild()) {
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

   class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
      public HurtByTargetGoal() {
         super(TriceratopsEntity.this);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         super.startExecuting();
         if (TriceratopsEntity.this.isChild()) {
            this.alertOthers();
            this.resetTask();
         }

      }

      protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
         if (mobIn instanceof TriceratopsEntity && !mobIn.isChild()) {
            super.setAttackTarget(mobIn, targetIn);
         }

      }
   }

   class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
      public MeleeAttackGoal() {
         super(TriceratopsEntity.this, 1.25D, true);
      }

      protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
         double d0 = this.getAttackReachSqr(enemy);
         if (distToEnemySqr <= d0 && this.attackTick <= 0 && !TriceratopsEntity.this.isTame()) {
            this.attackTick = 20;
            this.attacker.attackEntityAsMob(enemy);
         } else if (distToEnemySqr <= d0 * 2.0D && !TriceratopsEntity.this.isTame()) {
            if (this.attackTick <= 0) {
               this.attackTick = 20;
            }

            if (this.attackTick <= 10) {
            	TriceratopsEntity.this.playWarningSound();
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
         super(TriceratopsEntity.this, 2.0D);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return !TriceratopsEntity.this.isChild() && !TriceratopsEntity.this.isBurning() ? false : super.shouldExecute();
      }
   }
   
   static class LayEggGoal extends MoveToBlockGoal {
	      private final TriceratopsEntity triceratops;

	      LayEggGoal(TriceratopsEntity triceratops, double speedIn) {
	         super(triceratops, speedIn, 16);
	         this.triceratops = triceratops;
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return this.triceratops.hasEgg() ? super.shouldExecute() : false;
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         return super.shouldContinueExecuting() && this.triceratops.hasEgg();
	      }

	      /**
	       * Keep ticking a continuous task that has already been started
	       */
	      public void tick() {
	         super.tick();
	         BlockPos blockpos = new BlockPos(this.triceratops);
	         if (!this.triceratops.isInWater() && this.getIsAboveDestination()) {
	            if (this.triceratops.isDigging < 1) {
	               this.triceratops.setDigging(true);
	            } else if (this.triceratops.isDigging > 200) {
	               World world = this.triceratops.world;
	               world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
	               world.setBlockState(this.destinationBlock.up(), BlockInit.TRICERATOPS_EGG.getDefaultState().with(TriceratopsEggBlock.EGGS, Integer.valueOf(this.triceratops.rand.nextInt(4) + 1)), 3);
	               this.triceratops.setHasEgg(false);
	               this.triceratops.setDigging(false);
	               this.triceratops.setInLove(600);
	            }

	            if (this.triceratops.isDigging()) {
	               this.triceratops.isDigging++;
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
	      private final TriceratopsEntity triceratops;

	      MateGoal(TriceratopsEntity triceratops, double speedIn) {
	         super(triceratops, speedIn);
	         this.triceratops = triceratops;
	      }

	      /**
	       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	       * method as well.
	       */
	      public boolean shouldExecute() {
	         return super.shouldExecute() && !this.triceratops.hasEgg();
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

	         this.triceratops.setHasEgg(true);
	         this.animal.resetInLove();
	         this.targetMate.resetInLove();
	         Random random = this.animal.getRNG();
	         if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
	            this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
	         }

	      }
	   }
	
	@Override
	protected boolean handleEating(PlayerEntity player, ItemStack stack) {
	      boolean flag = false;
	      float f = 0.0F;
	      int i = 0;
	      Item item = stack.getItem();
	      if (item == BlockInit.HORSETAIL.asItem()) {
	         f = 2.0F;
	         i = 20;
	      } else if (item == BlockInit.DOUBLE_HORSETAIL.asItem()) {
	         f = 1.0F;
	         i = 30;
	      } else if (item == BlockInit.OSMUNDA.asItem()) {
	         f = 20.0F;
	         i = 180;
	      } else if (item == BlockInit.DOUBLE_OSMUNDA.asItem()) {
	         f = 3.0F;
	         i = 60;
	      } else if (item == BlockInit.CLUBMOSS.asItem()) {
	         f = 4.0F;
	         i = 60;
	         if (this.getGrowingAge() == 0 && !this.isInLove()) {
	            flag = true;
	            this.setInLove(player);
	         }
	      } else if (item == BlockInit.MARCHANTIA.asItem()) {
	    	  f = 3.0F;
	    	  i = 80;
	      }

	      if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
	         this.heal(f);
	         flag = true;
	      }

	      if (this.isChild() && i > 0) {
	         this.world.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), 0.0D, 0.0D, 0.0D);
	         if (!this.world.isRemote) {
	            this.addGrowth(i);
	         }

	         flag = true;
	      }

	      return flag;
	   }
	
}