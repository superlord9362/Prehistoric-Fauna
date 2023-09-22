package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFTags;

@SuppressWarnings("rawtypes")
public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
	double huntSpeed;
	Predicate<LivingEntity> targetPredicate;
	DinosaurEntity dinosaur;

	@SuppressWarnings("unchecked")
	public CarnivoreHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
		super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		this.huntSpeed = huntSpeed;
		this.targetPredicate = targetPredicate;
		this.dinosaur = goalOwnerIn;
	}

	public boolean canUse() {
		return super.canUse() && dinosaur.getCurrentHunger() <= dinosaur.getHalfHunger() && !dinosaur.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(dinosaur) && !dinosaur.trusts(target.getUUID()) && !dinosaur.isOpportunist();
	}

	public boolean canContinueToUse() {
		return dinosaur.getCurrentHunger() < dinosaur.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
	}

	public void tick() {
		dinosaur.getNavigation().setSpeedModifier(huntSpeed);
		LivingEntity target = dinosaur.getTarget();
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
		if (target.getType().is(PFTags.ANIMALS_40_HUNGER)) {
			if (target.getHealth() == 0) {
				if (dinosaur.getCurrentHunger() + 40 >= dinosaur.maxHunger) {
					dinosaur.setHunger(dinosaur.maxHunger);
				} else {
					dinosaur.setHunger(dinosaur.currentHunger + 40);
				}
			}
		}
		if (target.getType().is(PFTags.ANIMALS_60_HUNGER)) {
			if (target.getHealth() == 0) {
				if (dinosaur.getCurrentHunger() + 60 >= dinosaur.maxHunger) {
					dinosaur.setHunger(dinosaur.maxHunger);
				} else {
					dinosaur.setHunger(dinosaur.currentHunger + 60);
				}
			}
		}
		if (target.getType().is(PFTags.ANIMALS_80_HUNGER)) {
			if (target.getHealth() == 0) {
				if (dinosaur.getCurrentHunger() + 80 >= dinosaur.maxHunger) {
					dinosaur.setHunger(dinosaur.maxHunger);
				} else {
					dinosaur.setHunger(dinosaur.currentHunger + 80);
				}
			}
		}
		if (target.getType().is(PFTags.ANIMALS_100_HUNGER)) {
			if (target.getHealth() == 0) {
				if (dinosaur.getCurrentHunger() + 100 >= dinosaur.maxHunger) {
					dinosaur.setHunger(dinosaur.maxHunger);
				} else {
					dinosaur.setHunger(dinosaur.currentHunger + 100);
				}
			}
		}
		if (target.getType().is(PFTags.ANIMALS_200_HUNGER)) {
			if (target.getHealth() == 0) {
				if (dinosaur.getCurrentHunger() + 200 >= dinosaur.maxHunger) {
					dinosaur.setHunger(dinosaur.maxHunger);
				} else {
					dinosaur.setHunger(dinosaur.currentHunger + 200);
				}
			}
		}
		super.tick();
	}

}
