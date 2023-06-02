package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class NocturnalSleepGoal extends Goal {
	
	public DinosaurEntity entity;
	
	public NocturnalSleepGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean canUse() {
		Level world = entity.level;
		if (PrehistoricFaunaConfig.sleeping = true && world.getDayTime() % 24000 >= 0 && world.getDayTime() % 24000 <= 12000 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean canContinueToUse() {
		Level world = entity.level;
		if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || super.canContinueToUse() || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
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
		entity.getNavigation().stop();;
	}
	
	public void tick() {
		super.tick();
		Level world = entity.level;
		if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
			stop();
		}
	}
	
	@Override
	public void stop() {
		entity.setAsleep(false);
	}
	
}
