package superlord.prehistoricfauna.common.entity.goal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CathemeralSleepGoal extends Goal {
    public DinosaurEntity entity;
    private int sleepTimer = 0;

    public CathemeralSleepGoal(DinosaurEntity sleeper) {
        super();
        this.entity = sleeper;
    }

    @SuppressWarnings("resource")
    @Override
    public boolean canUse() {
        for (Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
            if (!player.isShiftKeyDown()) return false;
        }
        return (PrehistoricFaunaConfig.sleeping && entity.getRandom().nextInt(6000) == 0 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava() && !PrehistoricFaunaConfig.unscheduledSleeping && entity.warryTicks <= 0);
    }

    @SuppressWarnings("resource")
    @Override
    public boolean canContinueToUse() {
        for (Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
            if (!player.isShiftKeyDown()) return false;
        }
        if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("resource")
	@Override
    public void tick() {
        sleepTimer++;
        entity.getNavigation().stop();
        for (Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
            if (!player.isShiftKeyDown()) {
                entity.setAsleep(false);
                sleepTimer = 0;
                stop();
                return;
            }
        }
        if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
            entity.setAsleep(false);
            sleepTimer = 0;
            stop();
        }
    }

    @Override
    public void start() {
        sleepTimer = 0;
        entity.setAsleep(true);
        entity.setFallingAsleep();
        entity.xxa = 0.0F;
        entity.yya = 0.0F;
        entity.zza = 0.0F;
        entity.getNavigation().stop();
        entity.lerpMotion(0.0D, 0.0D, 0.0D);
    }

    @Override
    public void stop() {
        sleepTimer = 0;
        entity.setAsleep(false);
        entity.setAwakeTicks(100);
        entity.setFallingAsleep();
   }
}