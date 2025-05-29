package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurOwnerHurtByTargetGoal extends OwnerHurtByTargetGoal {

	DinosaurEntity dinosaur;

	public DinosaurOwnerHurtByTargetGoal(DinosaurEntity dinosaur) {
		super(dinosaur);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		if (dinosaur.isTame()) {
			if (dinosaur.getOwner().getLastHurtByMob() != null) return super.canUse() && dinosaur.getOwner().getLastHurtByMob().getMaxHealth() < dinosaur.getMaxHealth() * 2;
			else return false;
		}
		else return false;
	}

}
