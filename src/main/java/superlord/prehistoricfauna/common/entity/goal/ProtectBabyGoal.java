package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;

public class ProtectBabyGoal extends NearestAttackableTargetGoal<Player> {
	DinosaurEntity dinosaur;
	
	public ProtectBabyGoal(DinosaurEntity dinosaur) {
		super(dinosaur, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		this.dinosaur = dinosaur;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		if (dinosaur.isBaby() || dinosaur.isTame()) {
			return false;
		} else {
			if (super.canUse()) {
				for(Pinacosaurus pinacosaurus : dinosaur.level.getEntitiesOfClass(Pinacosaurus.class, dinosaur.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
					if (pinacosaurus.isBaby()) {
						return true;
					}
				}
			}

			return false;
		}
	}

	protected double getFollowDistance() {
		return super.getFollowDistance() * 0.5D;
	}
}
