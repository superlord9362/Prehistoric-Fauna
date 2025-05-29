package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurOwnerHurtTargetGoal extends OwnerHurtTargetGoal {

	DinosaurEntity dinosaur;

	public DinosaurOwnerHurtTargetGoal(DinosaurEntity dinosaur) {
		super(dinosaur);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		if (dinosaur.isTame()) {
			if (dinosaur.getOwner().getLastHurtMob() != null) return super.canUse() && dinosaur.getOwner().getLastHurtMob().getMaxHealth() < dinosaur.getMaxHealth() * 2;
			else return false;
		}
		else return false;
	}

}
