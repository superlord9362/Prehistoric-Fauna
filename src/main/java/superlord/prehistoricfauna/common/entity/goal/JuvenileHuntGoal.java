package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@SuppressWarnings("rawtypes")
public class JuvenileHuntGoal extends NearestAttackableTargetGoal {
	Predicate<LivingEntity> targetPredicate;
	DinosaurEntity dinosaur;
	
	@SuppressWarnings("unchecked")
	public JuvenileHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate<LivingEntity> targetPredicate) {
		super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
		this.targetPredicate = targetPredicate;
		this.dinosaur = goalOwnerIn;
	}
	
	public boolean canUse() {
		if (super.canUse() && this.mob.getRandom().nextInt(249) == 0 && this.mob.isBaby() && (dinosaur.getAge() >= -12000 && dinosaur.getAge() < 0) && !PrehistoricFaunaConfig.advancedHunger && !targetPredicate.test(this.mob) && !dinosaur.trusts(target.getUUID())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void stop() {
		super.stop();
	}
	
	public boolean canContinueToUse() {
		if (super.canContinueToUse() && this.mob.getRandom().nextInt(500) != 0 || !dinosaur.isBaby() || this.mob.getTarget() != null && this.mob.getRandom().nextInt(500) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
