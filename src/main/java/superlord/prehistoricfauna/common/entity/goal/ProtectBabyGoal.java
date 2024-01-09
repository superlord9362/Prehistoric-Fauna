package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class ProtectBabyGoal extends NearestAttackableTargetGoal<LivingEntity> {
	DinosaurEntity dinosaur;

	public ProtectBabyGoal(DinosaurEntity dinosaur) {
		super(dinosaur, LivingEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
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
				for(DinosaurEntity pinacosaurus : dinosaur.level.getEntitiesOfClass(DinosaurEntity.class, dinosaur.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
					if (!dinosaur.trusts(this.target.getUUID()) && (dinosaur.isProtective() || dinosaur.isTerritorial() || dinosaur.isOpportunist() || dinosaur.isAggressive()) && !dinosaur.isTame()) {
						if (this.target instanceof DinosaurEntity meanDinosaur) {
							if (meanDinosaur.getBoundingBox().getSize() < pinacosaurus.getBoundingBox().getSize() * 2 && meanDinosaur.isCarnivorous() && meanDinosaur != dinosaur) {
								if (pinacosaurus.isBaby()) {
									return true;
								}	
							}
						} else if (this.target instanceof Player) {
							if (pinacosaurus.isBaby()) {
								return true;
							}	
						}
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
