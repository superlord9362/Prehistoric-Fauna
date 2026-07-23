package superlord.prehistoricfauna.common.entity.goal;

import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class BabyPanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
	DinosaurEntity dinosaur;
	
	public BabyPanicGoal(DinosaurEntity dinosaur) {
		super(dinosaur, 2.0D);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		return !dinosaur.isBaby() && !dinosaur.isOnFire() ? false : super.canUse();
	}
}
