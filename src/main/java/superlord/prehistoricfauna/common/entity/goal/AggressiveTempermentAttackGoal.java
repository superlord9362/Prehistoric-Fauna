package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class AggressiveTempermentAttackGoal extends NearestAttackableTargetGoal<Player> {
	DinosaurEntity dinosaur;

	public AggressiveTempermentAttackGoal(DinosaurEntity dinosaur) {
		super(dinosaur, Player.class, true, true);
		this.dinosaur = dinosaur;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		if (dinosaur.isBaby()) {
			return false;
		} else {
			if (super.canUse()) {
				if (!dinosaur.trusts(this.target.getUUID()) && dinosaur.isAggressive() && !dinosaur.isTame()) {
					return true;
				}
			}
			return false;
		}
	}

	protected double getFollowDistance() {
		return super.getFollowDistance() * 0.5D;
	}
}
