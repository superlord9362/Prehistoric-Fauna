package superlord.prehistoricfauna.common.entities.goal;

import net.minecraft.entity.ai.goal.Goal;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CathemeralSleepGoal extends Goal {

	public DinosaurEntity entity;
	private int sleepTimer = 0;

	public CathemeralSleepGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean shouldExecute() {
		if (PrehistoricFaunaConfig.sleeping = true && entity.getRNG().nextInt(1000) == 0 && entity.getRevengeTarget() == null && entity.getAttackTarget() == null && !entity.isInWater() && !entity.isInLava()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean shouldContinueExecuting() {
		if (sleepTimer >= 6000 || entity.getRevengeTarget() != null || super.shouldContinueExecuting()) {
			resetTask();
			return false;
		} else return true;
	}
	
	public void tick() {
		super.tick();
		sleepTimer++;
		if (sleepTimer >= 6000 || entity.getRevengeTarget() != null) {
			resetTask();
		}
	}

	@Override
	public void startExecuting() {
		sleepTimer = 0;
		entity.setAsleep(true);
		entity.moveStrafing = 0.0F;
		entity.moveForward = 0.0F;
		entity.moveVertical = 0.0F;
		entity.getNavigator().clearPath();
		entity.setMotion(0.0D, 0.0D, 0.0D);
	}

	@Override
	public void resetTask() {
		sleepTimer = 0;
		entity.setAsleep(false);
	}

}
