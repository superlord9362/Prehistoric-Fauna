package superlord.prehistoricfauna.common.entity.goal;

import java.util.Random;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.level.GameRules;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class DinosaurMateGoal extends BreedGoal {
	private final DinosaurEntity dinosaur;

	public DinosaurMateGoal(DinosaurEntity dinosaur, double speed) {
		super(dinosaur, speed);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		return super.canUse() && !this.dinosaur.hasBaby() && !this.dinosaur.isInLoveNaturally();
	}

	protected void breed() {
		ServerPlayer serverplayerentity = this.animal.getLoveCause();
		if (serverplayerentity == null && this.partner.getLoveCause() != null) {
			serverplayerentity = this.partner.getLoveCause();
		}
		if (serverplayerentity != null) {
			serverplayerentity.awardStat(Stats.ANIMALS_BRED);
			CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
		}
		this.dinosaur.setHasBaby(true);
		this.animal.resetLove();
		this.partner.resetLove();
		Random randomom = this.animal.getRandom();
		if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
			this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), randomom.nextInt(7) + 1));
		}
	}

}
