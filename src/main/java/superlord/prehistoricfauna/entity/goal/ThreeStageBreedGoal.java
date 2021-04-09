package superlord.prehistoricfauna.entity.goal;

import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import superlord.prehistoricfauna.entity.PrehistoricEntity;
import superlord.prehistoricfauna.entity.ThreeStageAgeEntity;
import superlord.prehistoricfauna.util.BabyThreeStageSpawnEvent;

public class ThreeStageBreedGoal extends Goal {
   private static final EntityPredicate field_220689_d = (new EntityPredicate()).setDistance(8.0D).allowInvulnerable().allowFriendlyFire().setLineOfSiteRequired();
   protected final PrehistoricEntity animal;
   private final Class<? extends PrehistoricEntity> mateClass;
   protected final World world;
   protected PrehistoricEntity targetMate;
   private int spawnBabyDelay;
   private final double moveSpeed;

   public ThreeStageBreedGoal(PrehistoricEntity animal, double speedIn) {
      this(animal, speedIn, animal.getClass());
   }

   public ThreeStageBreedGoal(PrehistoricEntity p_i47306_1_, double p_i47306_2_, Class<? extends PrehistoricEntity> p_i47306_4_) {
      this.animal = p_i47306_1_;
      this.world = p_i47306_1_.world;
      this.mateClass = p_i47306_4_;
      this.moveSpeed = p_i47306_2_;
      this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.animal.isInLove()) {
         return false;
      } else {
         this.targetMate = this.getNearbyMate();
         return this.targetMate != null;
      }
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.targetMate.isAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.targetMate = null;
      this.spawnBabyDelay = 0;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      this.animal.getLookController().setLookPositionWithEntity(this.targetMate, 10.0F, (float)this.animal.getVerticalFaceSpeed());
      this.animal.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
      ++this.spawnBabyDelay;
      if (this.spawnBabyDelay >= 60 && this.animal.getDistanceSq(this.targetMate) < 9.0D) {
         this.spawnBaby();
      }

   }

   /**
    * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
    * valid mate found.
    */
   @Nullable
   private PrehistoricEntity getNearbyMate() {
      List<PrehistoricEntity> list = this.world.getTargettableEntitiesWithinAABB(this.mateClass, field_220689_d, this.animal, this.animal.getBoundingBox().grow(8.0D));
      double d0 = Double.MAX_VALUE;
      PrehistoricEntity animalentity = null;

      for(PrehistoricEntity animalentity1 : list) {
         if (this.animal.canMateWith(animalentity1) && this.animal.getDistanceSq(animalentity1) < d0) {
            animalentity = animalentity1;
            d0 = this.animal.getDistanceSq(animalentity1);
         }
      }

      return animalentity;
   }

   /**
    * Spawns a baby animal of the same type.
    */
   protected void spawnBaby() {
      ThreeStageAgeEntity ageableentity = this.animal.createChild(this.targetMate);
      final BabyThreeStageSpawnEvent event = new BabyThreeStageSpawnEvent(animal, targetMate, ageableentity);
      final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
      ageableentity = event.getChild();
      if (cancelled) {
         //Reset the "inLove" state for the animals
         this.animal.setGrowingAge(6000);
         this.targetMate.setGrowingAge(6000);
         this.animal.resetInLove();
         this.targetMate.resetInLove();
         return;
      }
      if (ageableentity != null) {
         ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
         if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
            serverplayerentity = this.targetMate.getLoveCause();
         }

         if (serverplayerentity != null) {
            serverplayerentity.addStat(Stats.ANIMALS_BRED);
         }

         this.animal.setGrowingAge(6000);
         this.targetMate.setGrowingAge(6000);
         this.animal.resetInLove();
         this.targetMate.resetInLove();
         ageableentity.setGrowingAge(-24000);
         ageableentity.setLocationAndAngles(this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), 0.0F, 0.0F);
         this.world.addEntity(ageableentity);
         this.world.setEntityState(this.animal, (byte)18);
         if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
            this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), this.animal.getRNG().nextInt(7) + 1));
         }

      }
   }
}
