package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
	DinosaurEntity dinosaur;

	public DinosaurWaterAvoidingRandomStrollGoal(DinosaurEntity p_25987_, double p_25988_) {
		super(p_25987_, p_25988_);
		this.dinosaur = p_25987_;
	}
	
	public boolean canUse() {
		return super.canUse() && !dinosaur.isAsleep();
	}
	
	public boolean canContinueToUse() {
		return super.canContinueToUse() && !dinosaur.isAsleep();
	}
	
	public void tick() {
		super.tick();
		if (dinosaur.isAsleep()) stop();
	}

}
