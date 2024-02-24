package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.PanicGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class PassivePanicGoal extends PanicGoal {
	
	DinosaurEntity dinosaur;

	public PassivePanicGoal(DinosaurEntity p_25691_, double p_25692_) {
		super(p_25691_, p_25692_);
		this.dinosaur = p_25691_;
	}
	
	public boolean canUse() {
		return super.canUse() && dinosaur.isPassive();
	}

}
