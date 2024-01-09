package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Animal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class AvoidHealthyAdultGoal<T extends Animal> extends AvoidEntityGoal<T> {

	DinosaurEntity dinosaur;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AvoidHealthyAdultGoal(DinosaurEntity dinosaur, Class p_25028_, float p_25029_, double p_25030_, double p_25031_) {
		super(dinosaur, p_25028_, p_25029_, p_25030_, p_25031_);
		this.dinosaur = dinosaur;
	}
	
	public boolean canUse() {
		return super.canUse() && (this.toAvoid.getHealth() <= dinosaur.getHealth() || this.toAvoid.getAge() < 0) && !dinosaur.trusts(this.toAvoid.getUUID()) && !dinosaur.isTame();
	}

}
