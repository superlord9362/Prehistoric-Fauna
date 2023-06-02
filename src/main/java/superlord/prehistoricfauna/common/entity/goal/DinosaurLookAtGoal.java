package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurLookAtGoal extends LookAtPlayerGoal {

	DinosaurEntity dinosaur;
	
	public DinosaurLookAtGoal(DinosaurEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
		super(entityIn, watchTargetClass, maxDistance);
		dinosaur = entityIn;
	}
	
	public boolean canUse() {
		return super.canUse() && !dinosaur.isAsleep();
	}

}
