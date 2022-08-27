package superlord.prehistoricfauna.common.entities.goal;

import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;

public class DinosaurRandomLookGoal extends LookRandomlyGoal {
	
	DinosaurEntity dinosaur;

	public DinosaurRandomLookGoal(DinosaurEntity entitylivingIn) {
		super(entitylivingIn);
		dinosaur = entitylivingIn;
	}
	
	public boolean shouldExecute() {
		return super.shouldExecute() && !dinosaur.isAsleep();
	}
	
	public boolean shouldContinueExecuting() {
		if (dinosaur.isAsleep()) {
			return false;
		} else {
			return super.shouldContinueExecuting();
		}
	}


}
