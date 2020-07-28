package superlord.prehistoricfauna.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.block.BasilemysEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;

public class BasilemysEntity extends PrehistoricEntity {
   private static final DataParameter<BlockPos> HOME_POS = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BLOCK_POS);
   private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BLOCK_POS);
   private static final DataParameter<Boolean> GOING_HOME = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Byte> BASILEMYS_FLAGS = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BYTE);
   private int isDigging;
   public BasilemysEntity.PanicGoal panic;

   public BasilemysEntity(EntityType<? extends BasilemysEntity> type, World worldIn) {
      super(type, worldIn);
      this.stepHeight = 1.0F;
   }

   public void setHome(BlockPos position) {
      this.dataManager.set(HOME_POS, position);
   }

   private BlockPos getHome() {
      return this.dataManager.get(HOME_POS);
   }

   private void setTravelPos(BlockPos position) {
      this.dataManager.set(TRAVEL_POS, position);
   }

   private BlockPos getTravelPos() {
      return this.dataManager.get(TRAVEL_POS);
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

   private boolean isGoingHome() {
      return this.dataManager.get(GOING_HOME);
   }

   private void setGoingHome(boolean isGoingHome) {
      this.dataManager.set(GOING_HOME, isGoingHome);
   }

   private void setTravelling(boolean isTravelling) {
      this.dataManager.set(TRAVELLING, isTravelling);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(HOME_POS, BlockPos.ZERO);
      this.dataManager.register(HAS_EGG, false);
      this.dataManager.register(TRAVEL_POS, BlockPos.ZERO);
      this.dataManager.register(GOING_HOME, false);
      this.dataManager.register(TRAVELLING, false);
      this.dataManager.register(IS_DIGGING, false);
      this.dataManager.register(BASILEMYS_FLAGS, (byte)0);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("HomePosX", this.getHome().getX());
      compound.putInt("HomePosY", this.getHome().getY());
      compound.putInt("HomePosZ", this.getHome().getZ());
      compound.putBoolean("HasEgg", this.hasEgg());
      compound.putInt("TravelPosX", this.getTravelPos().getX());
      compound.putInt("TravelPosY", this.getTravelPos().getY());
      compound.putInt("TravelPosZ", this.getTravelPos().getZ());
   }

   public void readAdditional(CompoundNBT compound) {
      int i = compound.getInt("HomePosX");
      int j = compound.getInt("HomePosY");
      int k = compound.getInt("HomePosZ");
      this.setHome(new BlockPos(i, j, k));
      super.readAdditional(compound);
      this.setHasEgg(compound.getBoolean("HasEgg"));
      int l = compound.getInt("TravelPosX");
      int i1 = compound.getInt("TravelPosY");
      int j1 = compound.getInt("TravelPosZ");
      this.setTravelPos(new BlockPos(l, i1, j1));
   }
   

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      this.setHome(new BlockPos(this));
      this.setTravelPos(BlockPos.ZERO);
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   public static boolean func_223322_c(EntityType<BasilemysEntity> p_223322_0_, IWorld p_223322_1_, SpawnReason reason, BlockPos p_223322_3_, Random p_223322_4_) {
      return p_223322_3_.getY() < p_223322_1_.getSeaLevel() + 4 && p_223322_1_.getBlockState(p_223322_3_.down()).getBlock() == Blocks.SAND && p_223322_1_.getLightSubtracted(p_223322_3_, 0) > 8;
   }

   protected void registerGoals() {
	  this.panic = new BasilemysEntity.PanicGoal(this, 1.2D);
      this.goalSelector.addGoal(0, this.panic);
      this.goalSelector.addGoal(1, new BasilemysEntity.MateGoal(this, 1.0D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(1, new BasilemysEntity.LayEggGoal(this, 1.0D));
      this.goalSelector.addGoal(4, new BasilemysEntity.GoHomeGoal(this, 1.0D));
      this.goalSelector.addGoal(7, new BasilemysEntity.TravelGoal(this, 1.0D));
      this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
   }

   public int getTalkInterval() {
      return 200;
   }

   @Nullable
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_TURTLE_AMBIENT_LAND;
   }

   protected void playSwimSound(float volume) {
      super.playSwimSound(volume * 1.5F);
   }

   @Nullable
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return this.isChild() ? SoundEvents.ENTITY_TURTLE_HURT_BABY : SoundEvents.ENTITY_TURTLE_HURT;
   }

   @Nullable
   protected SoundEvent getDeathSound() {
      return this.isChild() ? SoundEvents.ENTITY_TURTLE_DEATH_BABY : SoundEvents.ENTITY_TURTLE_DEATH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      SoundEvent soundevent = this.isChild() ? SoundEvents.ENTITY_TURTLE_SHAMBLE_BABY : SoundEvents.ENTITY_TURTLE_SHAMBLE;
      this.playSound(soundevent, 0.15F, 1.0F);
   }

   public boolean canBreed() {
      return super.canBreed() && !this.hasEgg();
   }

   protected float determineNextStepDistance() {	
      return this.distanceWalkedOnStepModified + 0.15F;
   }

   public float getRenderScale() {
      return this.isChild() ? 0.3F : 1.0F;
   }

   @Nullable
   public AgeableEntity createChild(AgeableEntity ageable) {
	   BasilemysEntity entity = new BasilemysEntity(ModEntityTypes.BASILEMYS_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
	}
   
   public boolean isBasilemysPanicing() {
	   return this.getBasilemysFlag(128);
   }

   private void setBasilemysPanicing(boolean p_213482_1_) {
	   this.setBasilemysFlag(128, p_213482_1_);
   }
   
   private void setBasilemysFlag(int p_213505_1_, boolean p_213505_2_) {
	   if (p_213505_2_) {
		   this.dataManager.set(BASILEMYS_FLAGS, (byte)(this.dataManager.get(BASILEMYS_FLAGS) | p_213505_1_));
	   } else {
		   this.dataManager.set(BASILEMYS_FLAGS, (byte)(this.dataManager.get(BASILEMYS_FLAGS) & ~p_213505_1_));
	   }
   }

   private boolean getBasilemysFlag(int p_213507_1_) {
	   return (this.dataManager.get(BASILEMYS_FLAGS) & p_213507_1_) != 0;
   }


   public boolean isBreedingItem(ItemStack stack) {
      return stack.getItem() == BlockInit.HORSETAIL.asItem();
   }

   @SuppressWarnings("deprecation")
   public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
      if (!this.isGoingHome() && worldIn.getFluidState(pos).isTagged(FluidTags.WATER)) {
         return 10.0F;
      } else {
         return worldIn.getBlockState(pos.down()).getBlock() == Blocks.SAND ? 10.0F : worldIn.getBrightness(pos) - 0.5F;
      }
   }

   public void livingTick() {
      super.livingTick();
      if (this.isAlive() && this.isDigging() && this.isDigging >= 1 && this.isDigging % 5 == 0) {
         BlockPos blockpos = new BlockPos(this);
         if (this.world.getBlockState(blockpos.down()).getBlock() == Blocks.SAND) {
            this.world.playEvent(2001, blockpos, Block.getStateId(Blocks.SAND.getDefaultState()));
         }
      }
      if (this.isBasilemysPanicing() || this.isMovementBlocked()) {
          this.isJumping = false;
          this.moveStrafing = 0.0F;
          this.moveForward = 0.0F;
      }
   }

   protected void onGrowingAdult() {
      super.onGrowingAdult();
      if (!this.isChild() && this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
         this.entityDropItem(Items.SCUTE, 1);
      }

   }

   public void travel(Vec3d p_213352_1_) {
      if (this.isServerWorld() && this.isInWater()) {
         this.moveRelative(0.1F, p_213352_1_);
         this.move(MoverType.SELF, this.getMotion());
         this.setMotion(this.getMotion().scale(0.9D));
         if (this.getAttackTarget() == null && (!this.isGoingHome() || !this.getHome().withinDistance(this.getPositionVec(), 20.0D))) {
            this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
         }
      } else {
         super.travel(p_213352_1_);
      }

   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return false;
   }

   public void onStruckByLightning(LightningBoltEntity lightningBolt) {
      this.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Float.MAX_VALUE);
   }

   static class GoHomeGoal extends Goal {
      private final BasilemysEntity turtle;
      private final double speed;
      private boolean field_203129_c;
      private int field_203130_d;

      GoHomeGoal(BasilemysEntity turtle, double speedIn) {
         this.turtle = turtle;
         this.speed = speedIn;
      }

      public boolean shouldExecute() {
         if (this.turtle.isChild()) {
            return false;
         } else if (this.turtle.hasEgg()) {
            return true;
         } else if (this.turtle.getRNG().nextInt(700) != 0) {
            return false;
         } else {
            return !this.turtle.getHome().withinDistance(this.turtle.getPositionVec(), 64.0D);
         }
      }

      public void startExecuting() {
         this.turtle.setGoingHome(true);
         this.field_203129_c = false;
         this.field_203130_d = 0;
      }

      public void resetTask() {
         this.turtle.setGoingHome(false);
      }

      public boolean shouldContinueExecuting() {
         return !this.turtle.getHome().withinDistance(this.turtle.getPositionVec(), 7.0D) && !this.field_203129_c && this.field_203130_d <= 600;
      }

      public void tick() {
         BlockPos blockpos = this.turtle.getHome();
         boolean flag = blockpos.withinDistance(this.turtle.getPositionVec(), 16.0D);
         if (flag) {
            ++this.field_203130_d;
         }

         if (this.turtle.getNavigator().noPath()) {
            Vec3d vec3d = new Vec3d(blockpos);
            Vec3d vec3d1 = RandomPositionGenerator.findRandomTargetTowardsScaled(this.turtle, 16, 3, vec3d, (double)((float)Math.PI / 10F));
            if (vec3d1 == null) {
               vec3d1 = RandomPositionGenerator.findRandomTargetBlockTowards(this.turtle, 8, 7, vec3d);
            }

            if (vec3d1 != null && !flag && this.turtle.world.getBlockState(new BlockPos(vec3d1)).getBlock() != Blocks.WATER) {
               vec3d1 = RandomPositionGenerator.findRandomTargetBlockTowards(this.turtle, 16, 5, vec3d);
            }

            if (vec3d1 == null) {
               this.field_203129_c = true;
               return;
            }

            this.turtle.getNavigator().tryMoveToXYZ(vec3d1.x, vec3d1.y, vec3d1.z, this.speed);
         }

      }
   }

   static class GoToWaterGoal extends MoveToBlockGoal {
      private final BasilemysEntity turtle;

      private GoToWaterGoal(BasilemysEntity turtle, double speedIn) {
         super(turtle, turtle.isChild() ? 2.0D : speedIn, 24);
         this.turtle = turtle;
         this.field_203112_e = -1;
      }

      public boolean shouldContinueExecuting() {
         return !this.turtle.isInWater() && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.turtle.world, this.destinationBlock);
      }

      public boolean shouldExecute() {
         if (this.turtle.isChild() && !this.turtle.isInWater()) {
            return super.shouldExecute();
         } else {
            return !this.turtle.isGoingHome() && !this.turtle.isInWater() && !this.turtle.hasEgg() ? super.shouldExecute() : false;
         }
      }

      public boolean shouldMove() {
         return this.timeoutCounter % 160 == 0;
      }

      protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
         Block block = worldIn.getBlockState(pos).getBlock();
         return block == Blocks.WATER;
      }
   }

   static class LayEggGoal extends MoveToBlockGoal {
      private final BasilemysEntity turtle;

      LayEggGoal(BasilemysEntity turtle, double speedIn) {
         super(turtle, speedIn, 16);
         this.turtle = turtle;
      }

      public boolean shouldExecute() {
         return this.turtle.hasEgg() && this.turtle.getHome().withinDistance(this.turtle.getPositionVec(), 9.0D) ? super.shouldExecute() : false;
      }

      public boolean shouldContinueExecuting() {
         return super.shouldContinueExecuting() && this.turtle.hasEgg() && this.turtle.getHome().withinDistance(this.turtle.getPositionVec(), 9.0D);
      }

      public void tick() {
         super.tick();
         BlockPos blockpos = new BlockPos(this.turtle);
         if (!this.turtle.isInWater() && this.getIsAboveDestination()) {
            if (this.turtle.isDigging < 1) {
               this.turtle.setDigging(true);
            } else if (this.turtle.isDigging > 200) {
               World world = this.turtle.world;
               world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
               world.setBlockState(this.destinationBlock.up(), BlockInit.BASILEMYS_EGG.getDefaultState().with(BasilemysEggBlock.EGGS, Integer.valueOf(this.turtle.rand.nextInt(4) + 1)), 3);
               this.turtle.setHasEgg(false);
               this.turtle.setDigging(false);
               this.turtle.setInLove(600);
            }

            if (this.turtle.isDigging()) {
               this.turtle.isDigging++;
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

   static class MateGoal extends BreedGoal {
      private final BasilemysEntity turtle;

      MateGoal(BasilemysEntity turtle, double speedIn) {
         super(turtle, speedIn);
         this.turtle = turtle;
      }

      public boolean shouldExecute() {
         return super.shouldExecute() && !this.turtle.hasEgg();
      }

      protected void spawnBaby() {
         ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
         if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
            serverplayerentity = this.targetMate.getLoveCause();
         }

         if (serverplayerentity != null) {
            serverplayerentity.addStat(Stats.ANIMALS_BRED);
            CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
         }

         this.turtle.setHasEgg(true);
         this.animal.resetInLove();
         this.targetMate.resetInLove();
         Random random = this.animal.getRNG();
         if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
            this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
         }

      }
   }

   static class MoveHelperController extends MovementController {
      private final BasilemysEntity turtle;

      MoveHelperController(BasilemysEntity turtleIn) {
         super(turtleIn);
         this.turtle = turtleIn;
      }

      private void updateSpeed() {
         if (this.turtle.isInWater()) {
            this.turtle.setMotion(this.turtle.getMotion().add(0.0D, 0.005D, 0.0D));
            if (!this.turtle.getHome().withinDistance(this.turtle.getPositionVec(), 16.0D)) {
               this.turtle.setAIMoveSpeed(Math.max(this.turtle.getAIMoveSpeed() / 2.0F, 0.08F));
            }

            if (this.turtle.isChild()) {
               this.turtle.setAIMoveSpeed(Math.max(this.turtle.getAIMoveSpeed() / 3.0F, 0.06F));
            }
         } else if (this.turtle.onGround) {
            this.turtle.setAIMoveSpeed(Math.max(this.turtle.getAIMoveSpeed() / 2.0F, 0.06F));
         }

      }

      public void tick() {
         this.updateSpeed();
         if (this.action == MovementController.Action.MOVE_TO && !this.turtle.getNavigator().noPath()) {
            double d0 = this.posX - this.turtle.getPosX();
            double d1 = this.posY - this.turtle.getPosY();
            double d2 = this.posZ - this.turtle.getPosZ();
            double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            d1 = d1 / d3;
            float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.turtle.rotationYaw = this.limitAngle(this.turtle.rotationYaw, f, 90.0F);
            this.turtle.renderYawOffset = this.turtle.rotationYaw;
            float f1 = (float)(this.speed * this.turtle.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
            this.turtle.setAIMoveSpeed(MathHelper.lerp(0.125F, this.turtle.getAIMoveSpeed(), f1));
            this.turtle.setMotion(this.turtle.getMotion().add(0.0D, (double)this.turtle.getAIMoveSpeed() * d1 * 0.1D, 0.0D));
         } else {
            this.turtle.setAIMoveSpeed(0.0F);
         }
      }
   }

   class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
      PanicGoal(BasilemysEntity turtle, double speedIn) {
         super(turtle, speedIn);
      }


      public boolean shouldExecute() {
         if (this.creature.getRevengeTarget() == null && !this.creature.isBurning()) {
            return false;
         } else {
             return true;
         }
      }
      
      public void startExecuting() {
		   BasilemysEntity.this.setBasilemysPanicing(true);
		   BasilemysEntity.this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(100.0D);
		   BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(100.0D);
		   BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(100.0D);
      }
      
      public void resetTask() {
    	  BasilemysEntity.this.setBasilemysPanicing(false);
    	  BasilemysEntity.this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0D);
    	  BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.0D);
    	  BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(0.0D);
      }
   }

   static class TravelGoal extends Goal {
      private final BasilemysEntity turtle;
      private final double speed;
      private boolean field_203139_c;

      TravelGoal(BasilemysEntity turtle, double speedIn) {
         this.turtle = turtle;
         this.speed = speedIn;
      }
      
      public boolean shouldExecute() {
         return !this.turtle.isGoingHome() && !this.turtle.hasEgg() && this.turtle.isInWater();
      }
      
      public void startExecuting() {
         Random random = this.turtle.rand;
         int k = random.nextInt(1025) - 512;
         int l = random.nextInt(9) - 4;
         int i1 = random.nextInt(1025) - 512;
         if ((double)l + this.turtle.getPosY() > (double)(this.turtle.world.getSeaLevel() - 1)) {
            l = 0;
         }

         BlockPos blockpos = new BlockPos((double)k + this.turtle.getPosX(), (double)l + this.turtle.getPosY(), (double)i1 + this.turtle.getPosZ());
         this.turtle.setTravelPos(blockpos);
         this.turtle.setTravelling(true);
         this.field_203139_c = false;
      }
      
      @SuppressWarnings("deprecation")
	public void tick() {
         if (this.turtle.getNavigator().noPath()) {
            Vec3d vec3d = new Vec3d(this.turtle.getTravelPos());
            Vec3d vec3d1 = RandomPositionGenerator.findRandomTargetTowardsScaled(this.turtle, 16, 3, vec3d, (double)((float)Math.PI / 10F));
            if (vec3d1 == null) {
               vec3d1 = RandomPositionGenerator.findRandomTargetBlockTowards(this.turtle, 8, 7, vec3d);
            }

            if (vec3d1 != null) {
               int i = MathHelper.floor(vec3d1.x);
               int j = MathHelper.floor(vec3d1.z);
               if (!this.turtle.world.isAreaLoaded(i - 34, 0, j - 34, i + 34, 0, j + 34)) {
                  vec3d1 = null;
               }
            }

            if (vec3d1 == null) {
               this.field_203139_c = true;
               return;
            }

            this.turtle.getNavigator().tryMoveToXYZ(vec3d1.x, vec3d1.y, vec3d1.z, this.speed);
         }

      }

      public boolean shouldContinueExecuting() {
         return !this.turtle.getNavigator().noPath() && !this.field_203139_c && !this.turtle.isGoingHome() && !this.turtle.isInLove() && !this.turtle.hasEgg();
      }

      public void resetTask() {
         this.turtle.setTravelling(false);
         super.resetTask();
      }
   }

   static class WanderGoal extends RandomWalkingGoal {
      private final BasilemysEntity turtle;

      private WanderGoal(BasilemysEntity turtle, double speedIn, int chance) {
         super(turtle, speedIn, chance);
         this.turtle = turtle;
      }

      public boolean shouldExecute() {
         return !this.creature.isInWater() && !this.turtle.isGoingHome() && !this.turtle.hasEgg() ? super.shouldExecute() : false;
      }
   }
}