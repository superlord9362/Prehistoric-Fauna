package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurHurtByTargetGoal extends HurtByTargetGoal {
	DinosaurEntity dinosaur;

	public DinosaurHurtByTargetGoal(DinosaurEntity dinosaur) {
		super(dinosaur);
		this.dinosaur = dinosaur;
	}
	
	public boolean canUse() {
		return super.canUse() && (!dinosaur.isPassive() || !dinosaur.isSkittish());
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
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
}