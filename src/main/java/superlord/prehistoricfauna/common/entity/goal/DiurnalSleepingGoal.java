package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DiurnalSleepingGoal extends Goal {
	
	public DinosaurEntity entity;
	
	public DiurnalSleepingGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean canUse() {
		Level level = entity.level;
		if (PrehistoricFaunaConfig.sleeping = true && level.getDayTime() % 24000 >= 12000 && level.getDayTime() % 24000 <= 24000 && entity.getTarget() == null && !entity.isTame() && !entity.isInWater() && !entity.isInLava() && entity.getLastHurtByMob() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean canContinueToUse() {
		Level level = entity.level;
		if (level.getDayTime() % 24000 >= 0 && level.getDayTime() % 24000 < 12000 || entity.getTarget() != null || super.canContinueToUse() || entity.isTame() || entity.isInWater() || entity.isInLava() || entity.getLastHurtByMob() != null) {
			stop();
			return false;
		} else return true;
	}
	
	@Override
	public void start() {
		entity.setAsleep(true);
		entity.xxa = 0.0F;
		entity.yya = 0.0F;
		entity.zza = 0.0F;
		entity.getNavigation().stop();
	}
	
	public void tick() {
		super.tick();
		Level level = entity.level;
		if (level.getDayTime() % 24000 >= 0 && level.getDayTime() % 24000 < 12000 || entity.getTarget() != null || entity.isTame() || entity.isInWater() || entity.isInLava() || entity.getLastHurtByMob() != null) {
			stop();
		}
	}
	
	@Override
	public void stop() {
		entity.setAsleep(false);
	}
	
}
