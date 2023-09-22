package superlord.prehistoricfauna.common.entity.goal;

import java.util.List;
import java.util.function.Predicate;

import com.mojang.datafixers.DataFixUtils;

import net.minecraft.world.entity.ai.goal.Goal;
import superlord.prehistoricfauna.common.entity.AgedHerdDinosaurEntity;

public class AgedFollowHerdLeaderGoal extends Goal {
	private final AgedHerdDinosaurEntity taskOwner;
	private int navigateTimer;
	private int cooldown;

	public AgedFollowHerdLeaderGoal(AgedHerdDinosaurEntity taskOwnerIn) {
		this.taskOwner = taskOwnerIn;
		this.cooldown = this.getNewCooldown(taskOwnerIn);
	}

	protected int getNewCooldown(AgedHerdDinosaurEntity taskOwnerIn) {
		return reducedTickDelay(200 + taskOwnerIn.getRandom().nextInt(200) % 20);
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		if (this.taskOwner.hasFollowers()) {
			return false;
		} else if (this.taskOwner.isBaby()) {
			return false;
		} else if (this.taskOwner.hasGroupLeader()) {
			return true;
		} else if (this.cooldown > 0) {
			--this.cooldown;
			return false;
		} else {
			this.cooldown = this.getNewCooldown(this.taskOwner);
			Predicate<AgedHerdDinosaurEntity> predicate = (dinosaur) -> {
				return dinosaur.canBeFollowed() || !dinosaur.hasGroupLeader();
			};
			List<? extends AgedHerdDinosaurEntity> list = this.taskOwner.level.getEntitiesOfClass(this.taskOwner.getClass(), this.taskOwner.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
			AgedHerdDinosaurEntity dinosaurEntity = DataFixUtils.orElse(list.stream().filter(AgedHerdDinosaurEntity::canBeFollowed).findAny(), this.taskOwner);
			dinosaurEntity.addFollowers(list.stream().filter((dinosaur) -> {
				return !dinosaur.hasGroupLeader();
			}));
			return this.taskOwner.hasGroupLeader();
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean canContinueToUse() {
		return this.taskOwner.hasGroupLeader() && this.taskOwner.inRangeOfLeader();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void start() {
		this.navigateTimer = 0;
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by another one
	 */
	public void stop() {
		this.taskOwner.stopFollowing();
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick() {
		if (--this.navigateTimer <= 0) {
			this.navigateTimer = this.adjustedTickDelay(10);
			this.taskOwner.pathToLeader();
		}
	}
}
