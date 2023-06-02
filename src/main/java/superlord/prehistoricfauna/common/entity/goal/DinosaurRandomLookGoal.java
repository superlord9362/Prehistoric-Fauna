package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurRandomLookGoal extends RandomLookAroundGoal {
	
	DinosaurEntity dinosaur;

	public DinosaurRandomLookGoal(DinosaurEntity entitylivingIn) {
		super(entitylivingIn);
		dinosaur = entitylivingIn;
	}
	
	public boolean canUse() {
		return super.canUse() && !dinosaur.isAsleep();
	}
	
	public boolean canContinueToUse() {
		if (dinosaur.isAsleep()) {
			return false;
		} else {
			return super.canContinueToUse();
		}
	}


}
