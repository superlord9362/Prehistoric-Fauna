package superlord.prehistoricfauna.common.entity.goal;

import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class BabyPanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
	DinosaurEntity dinosaur;
	
	public BabyPanicGoal(DinosaurEntity dinosaur) {
		super(dinosaur, 2.0D);
		this.dinosaur = dinosaur;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		return !dinosaur.isBaby() && !dinosaur.isOnFire() ? false : super.canUse();
	}
}
