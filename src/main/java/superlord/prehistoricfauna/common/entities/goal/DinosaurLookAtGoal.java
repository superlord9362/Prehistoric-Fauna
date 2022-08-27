package superlord.prehistoricfauna.common.entities.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;

public class DinosaurLookAtGoal extends LookAtGoal {

	DinosaurEntity dinosaur;
	
	public DinosaurLookAtGoal(DinosaurEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
		super(entityIn, watchTargetClass, maxDistance);
		dinosaur = entityIn;
	}
	
	public boolean shouldExecute() {
		return super.shouldExecute() && !dinosaur.isAsleep();
	}

}
