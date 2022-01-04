package superlord.prehistoricfauna.common.entities.goal;

import java.util.function.Predicate;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;

@SuppressWarnings("rawtypes")
public class HuntGoal extends NearestAttackableTargetGoal {

	@SuppressWarnings("unchecked")
	public HuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
		super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
	}
	
	public boolean shouldExecute() {
		if (super.shouldExecute() && this.goalOwner.getRNG().nextInt(249) == 0 && !this.goalOwner.isChild()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resetTask() {
		super.resetTask();
	}
	
	public boolean shouldContinueExecuting() {
		if (super.shouldContinueExecuting() && this.goalOwner.getRNG().nextInt(500) != 0 || this.goalOwner.getAttackTarget() != null && this.goalOwner.getRNG().nextInt(500) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
