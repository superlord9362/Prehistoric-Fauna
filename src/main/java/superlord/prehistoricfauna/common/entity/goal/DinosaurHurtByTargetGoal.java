package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurHurtByTargetGoal extends HurtByTargetGoal {
	DinosaurEntity dinosaur;

	public DinosaurHurtByTargetGoal(DinosaurEntity dinosaur) {
		super(dinosaur);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		if (dinosaur.getLastHurtByMob() != null)  {
			return !this.isHerdMate(dinosaur.getLastHurtByMob()) && super.canUse() && (!dinosaur.isPassive() || !dinosaur.isSkittish()) && (dinosaur.getLastHurtByMob().getHealth() <= (dinosaur.getMaxHealth() * 2));
		} else return false;
	}

	public void start() {
		super.start();
		if (dinosaur.trusts(this.targetMob.getUUID())) {
			dinosaur.removeTrustedUUID(this.targetMob.getUUID());
		}
		if (dinosaur.isBaby()) {
			this.alertOthers();
			this.stop();
		}
	}

	protected void alertOther(Mob mobIn, DinosaurEntity targetIn) {
		if (!mobIn.isBaby()) {
			super.alertOther(mobIn, targetIn);
		}

	}

	private boolean isHerdMate(LivingEntity other) {
		for (WrappedGoal wrapped : dinosaur.goalSelector.getAvailableGoals()) {
			if (wrapped.getGoal() instanceof DinosaurHerdGoal herdGoal) {
				return herdGoal.getHerd().contains(other);
			}
		}
		return false;
	}

}