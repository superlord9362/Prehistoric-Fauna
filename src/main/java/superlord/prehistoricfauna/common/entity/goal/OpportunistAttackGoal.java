package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class OpportunistAttackGoal extends NearestAttackableTargetGoal<Player> {

	DinosaurEntity dinosaur;
	
	public OpportunistAttackGoal(DinosaurEntity dinosaur, Class<Player> p_26061_, boolean p_26062_) {
		super(dinosaur, p_26061_, p_26062_);
		this.dinosaur = dinosaur;
	}
	
	public boolean canUse() {
		return super.canUse() && (this.target.getHealth() <= this.target.getMaxHealth() / 2) && dinosaur.isOpportunist() && !dinosaur.trusts(this.target.getUUID()) && !dinosaur.isTame();
	}

}
