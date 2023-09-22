package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class SkittishFleeGoal extends AvoidEntityGoal<Player> {

	DinosaurEntity dinosaur;
	
	public SkittishFleeGoal(DinosaurEntity dinosaur, Class<Player> p_25034_, float p_25035_, double p_25036_, double p_25037_) {
		super(dinosaur, p_25034_, p_25035_, p_25036_, p_25037_);
		this.dinosaur = dinosaur;
	}
	
	@SuppressWarnings("static-access")
	public boolean canUse() {
		return super.canUse() && dinosaur.isSkittish() && !dinosaur.trusts(this.toAvoid.getUUID()) && dinosaur.AVOID_PLAYERS.test(this.toAvoid);
	}

}
