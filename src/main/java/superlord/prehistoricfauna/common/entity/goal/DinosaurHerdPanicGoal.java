package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;

public class DinosaurHerdPanicGoal extends PanicGoal {
	private final DinosaurHerdGoal herdGoal;

	public DinosaurHerdPanicGoal(PathfinderMob mob, DinosaurHerdGoal herdGoal, double speed) {
		super(mob, speed);
		this.herdGoal = herdGoal;
	}

	private static DinosaurHerdPanicGoal getPanicGoal(Mob other) {
		for (WrappedGoal wrapped : other.goalSelector.getAvailableGoals()) {
			if (wrapped.getGoal() instanceof DinosaurHerdPanicGoal panicGoal) {
				return panicGoal;
			}
		}
		return null;
	}

	private boolean isSelfPanicking() {
		return super.shouldPanic();
	}

	@Override
	protected boolean shouldPanic() {
		if (this.isSelfPanicking()) {
			return true;
		}
		for (Mob member : this.herdGoal.getHerd()) {
			if (member != this.mob) {
				DinosaurHerdPanicGoal memberGoal = getPanicGoal(member);
				if (memberGoal != null && memberGoal.isSelfPanicking()) {
					return true;
				}
			}
		}
		return false;
	}

	private LivingEntity findThreat() {
		for (Mob member : this.herdGoal.getHerd()) {
			LivingEntity attacker = member.getLastHurtByMob();
			if (attacker != null && attacker.isAlive()) {
				return attacker;
			}
		}
		return null;
	}

	@Override
	protected boolean findRandomPosition() {
		Vec3 pos = null;
		LivingEntity threat = this.findThreat();
		if (threat != null) {
			pos = DefaultRandomPos.getPosAway(this.mob, 16, 7, threat.position());
		}
		if (pos == null) {
			pos = DefaultRandomPos.getPos(this.mob, 5, 4);
		}
		if (pos == null) {
			return false;
		}
		this.posX = pos.x;
		this.posY = pos.y;
		this.posZ = pos.z;
		return true;
	}
}