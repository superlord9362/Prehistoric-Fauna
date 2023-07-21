package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class NaturalMateGoal  extends BreedGoal {
	private final DinosaurEntity dinosaur;

	public NaturalMateGoal(DinosaurEntity dinosaur, double speed) {
		super(dinosaur, speed);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		return super.canUse() && !this.dinosaur.hasBaby() && this.dinosaur.getCurrentHunger() >= this.dinosaur.getThreeQuartersHunger() && this.dinosaur.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.dinosaur.isInLoveNaturally();
	}

	protected void breed() {
		if (PrehistoricFaunaConfig.naturalEggItemLaying) {
			this.dinosaur.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.dinosaur.random.nextFloat() - this.dinosaur.random.nextFloat()) * 0.2F + 1.0F);
			int eggAmount = this.dinosaur.random.nextInt(4);
			for (int i = 0; i <= eggAmount; i++) {
				this.dinosaur.spawnAtLocation(dinosaur.getEggItem());
			}
		} else {
			this.dinosaur.setHasBaby(true);
		}
		this.animal.resetLove();
		this.partner.resetLove();
	}
}
