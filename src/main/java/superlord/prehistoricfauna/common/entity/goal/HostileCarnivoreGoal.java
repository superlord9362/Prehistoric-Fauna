package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@SuppressWarnings("rawtypes")
public class HostileCarnivoreGoal extends NearestAttackableTargetGoal {

	@SuppressWarnings("unchecked")
	public HostileCarnivoreGoal(Mob p_26060_, Class p_26061_, boolean p_26062_) {
		super(p_26060_, p_26061_, p_26062_);
	}
	
	@Override
	public boolean canUse() {
		DinosaurEntity dinosaur = (DinosaurEntity)this.mob;
		return super.canUse() && PrehistoricFaunaConfig.hostileCarnivores && !dinosaur.trusts(this.target.getUUID());
	}
	
	@Override
	public boolean canContinueToUse() {
		return super.canContinueToUse() && PrehistoricFaunaConfig.hostileCarnivores;
	}

}
