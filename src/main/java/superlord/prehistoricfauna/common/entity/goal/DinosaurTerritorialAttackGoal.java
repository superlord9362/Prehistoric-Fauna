package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurTerritorialAttackGoal extends NearestAttackableTargetGoal<Player> {
	DinosaurEntity dinosaur;

	public DinosaurTerritorialAttackGoal(DinosaurEntity dinosaur) {
		super(dinosaur, Player.class, true, true);
		this.dinosaur = dinosaur;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	@SuppressWarnings("resource")
	public boolean canUse() {
		if (dinosaur.isBaby()) {
			return false;
		} else {
			if (super.canUse()) {
				for(DinosaurEntity dinosaur : dinosaur.level().getEntitiesOfClass(DinosaurEntity.class, dinosaur.getBoundingBox().inflate(24.0D, 4.0D, 24.0D))) {
					if (!dinosaur.trusts(this.target.getUUID()) && dinosaur.isTerritorial() && (dinosaur.isFood(this.target.getItemInHand(InteractionHand.MAIN_HAND)) || dinosaur.isFood(this.target.getItemInHand(InteractionHand.OFF_HAND))) && !dinosaur.isTame() && !dinosaur.isVehicle()) {
						return true;
					}
				}
			}
			return false;
		}
	}

	public boolean canContinueToUse() {
		return super.canContinueToUse() && !dinosaur.isVehicle();
	}

	protected double getFollowDistance() {
		return super.getFollowDistance() * 0.5D;
	}
}
