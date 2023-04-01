package superlord.prehistoricfauna.common.entities.goal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class NocturnalSleepGoal extends Goal {
	
	public DinosaurEntity entity;
	
	public NocturnalSleepGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean shouldExecute() {
		World world = entity.world;
		if (PrehistoricFaunaConfig.sleeping = true && world.getDayTime() >= 0 && world.getDayTime() <= 12000 && entity.getRevengeTarget() == null && entity.getAttackTarget() == null && !entity.isInWater() && !entity.isInLava()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		World world = entity.world;
		if (world.getDayTime() >= 12000 && world.getDayTime() <= 24000 || entity.getRevengeTarget() != null || super.shouldContinueExecuting() || entity.getAttackTarget() != null || entity.isInWater() || entity.isInLava()) {
			resetTask();
			return false;
		} else return true;
	}
	
	@Override
	public void startExecuting() {
		entity.setAsleep(true);
		entity.moveStrafing = 0.0F;
		entity.moveForward = 0.0F;
		entity.moveVertical = 0.0F;
		entity.getNavigator().clearPath();
	}
	
	public void tick() {
		super.tick();
		World world = entity.world;
		if (world.getDayTime() >= 12000 && world.getDayTime() <= 24000 || entity.getRevengeTarget() != null || entity.getAttackTarget() != null || entity.isInWater() || entity.isInLava()) {
			resetTask();
		}
	}
	
	@Override
	public void resetTask() {
		entity.setAsleep(false);
	}
	
}
