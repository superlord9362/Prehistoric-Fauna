package superlord.prehistoricfauna.common.entities.goal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CrepuscularSleepGoal extends Goal {
	
	public DinosaurEntity entity;
	
	public CrepuscularSleepGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean shouldExecute() {
		World world = entity.world;
		if (PrehistoricFaunaConfig.sleeping = true && (world.getDayTime() >= 2000 && world.getDayTime() <= 9000 || world.getDayTime() >= 14000 && world.getDayTime() <= 21000) && entity.getRevengeTarget() == null && entity.getAttackTarget() == null && !entity.isTamed()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		World world = entity.world;
		if (world.getDayTime() <= 2000 || world.getDayTime() >= 9000 && world.getDayTime() <= 14000 || world.getDayTime() >= 21000 && world.getDayTime() <= 24000) {
			resetTask();
			entity.setAsleep(false);
			return false;
		} else if (entity.getAttackTarget() != null) {
			resetTask();
			entity.setAsleep(false);
			return false;
		} else if (entity.getRevengeTarget() != null) {
			resetTask();
			entity.setAsleep(false);
			return false;
		} else if (entity.isTamed()) {
			return false;
		} else return true;
	}
	
	public void tick() {
		super.tick();
		World world = entity.world;
		if (world.getDayTime() <= 2000 || world.getDayTime() >= 9000 && world.getDayTime() <= 14000 || world.getDayTime() >= 21000 && world.getDayTime() <= 24000) {
			resetTask();
			entity.setAsleep(false);
		} else if (entity.getAttackTarget() != null) {
			resetTask();
			entity.setAsleep(false);
		} else if (entity.getRevengeTarget() != null) {
			resetTask();
			entity.setAsleep(false);
		} else if (entity.isTamed()) {
			entity.setAsleep(false);
		}else {
			entity.setAsleep(true);
		}
	}
	
	@Override
	public void startExecuting() {
		entity.setAsleep(true);
		entity.moveStrafing = 0.0F;
		entity.moveForward = 0.0F;
		entity.moveVertical = 0.0F;
		entity.getNavigator().clearPath();
	}
	
	@Override
	public void resetTask() {
		entity.setAsleep(false);
	}
	
}
