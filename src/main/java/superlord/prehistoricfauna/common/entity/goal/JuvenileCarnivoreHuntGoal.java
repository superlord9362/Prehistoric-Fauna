package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFTags;

@SuppressWarnings("rawtypes")
public class JuvenileCarnivoreHuntGoal extends NearestAttackableTargetGoal {
	double huntSpeed;
	Predicate<LivingEntity> targetPredicate;
	DinosaurEntity dinosaur;

	@SuppressWarnings("unchecked")
	public JuvenileCarnivoreHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
		super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		this.huntSpeed = huntSpeed;
		this.targetPredicate = targetPredicate;
		this.dinosaur = goalOwnerIn;
	}

	public boolean canUse() {
		return super.canUse() && dinosaur.getCurrentHunger() <= dinosaur.getHalfHunger() && (dinosaur.getAge() >= -12000 && dinosaur.getAge() < 0) && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(dinosaur);
	}

	public boolean canContinueToUse() {
		return dinosaur.getCurrentHunger() > dinosaur.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || dinosaur.getAge() >= 0 && PrehistoricFaunaConfig.advancedHunger == true;
	}

	public void tick() {
		dinosaur.getNavigation().setSpeedModifier(huntSpeed);
		LivingEntity target = dinosaur.getTarget();
		if (!target.is(null)) {
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 3 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 4 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 6 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 8 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 8);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 10 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 10);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 15 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 15);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 20 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 20);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_30_HUNGER)) {
				if (target.getHealth() == 0) {
					if (dinosaur.getCurrentHunger() + 30 >= dinosaur.maxHunger) {
						dinosaur.setHunger(dinosaur.maxHunger);
					} else {
						dinosaur.setHunger(dinosaur.currentHunger + 30);
					}
				}
			}
		} else stop();
		super.tick();
	}

}
