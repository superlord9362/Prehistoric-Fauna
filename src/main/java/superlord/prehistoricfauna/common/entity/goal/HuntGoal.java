package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@SuppressWarnings("rawtypes")
public class HuntGoal extends NearestAttackableTargetGoal {

	@SuppressWarnings("unchecked")
	public HuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
		super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
	}
	
	public boolean canUse() {
		if (super.canUse() && this.mob.getRandom().nextInt(249) == 0 && !this.mob.isBaby() && !PrehistoricFaunaConfig.advancedHunger) {
			return true;
		} else {
			return false;
		}
	}
	
	public void stop() {
		super.stop();
	}
	
	public boolean canContinueToUse() {
		if (super.canContinueToUse() && this.mob.getRandom().nextInt(500) != 0 || this.mob.getTarget() != null && this.mob.getRandom().nextInt(500) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
