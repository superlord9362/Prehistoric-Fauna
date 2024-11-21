package superlord.prehistoricfauna.common.entity.goal;

import java.util.function.Predicate;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;

public class AvoidHealthyAdultGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {

	LivingEntity dinosaurs;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AvoidHealthyAdultGoal(PathfinderMob dinosaur, Class p_25028_, float p_25029_, double p_25030_, double p_25031_) {
		super(dinosaur, p_25028_, p_25029_, p_25030_, p_25031_);
		this.dinosaurs = dinosaur;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AvoidHealthyAdultGoal(PathfinderMob dinosaur, Class p_25028_, float p_25029_, double p_25030_, double p_25031_, Predicate<LivingEntity> p_25038_) {
		super(dinosaur, p_25028_, p_25029_, p_25030_, p_25031_, p_25038_);
		this.dinosaurs = dinosaur;
	}

	public boolean canUse() {
		if (dinosaurs instanceof DinosaurEntity dinosaur) {
			return super.canUse() && !(this.toAvoid.getHealth() <= dinosaur.getHealth() || dinosaur.getAge() < 0) && !dinosaur.trusts(this.toAvoid.getUUID()) && !dinosaur.isTame();
		} else return false;
	}

}
