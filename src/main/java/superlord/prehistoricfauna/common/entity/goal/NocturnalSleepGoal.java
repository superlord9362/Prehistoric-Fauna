package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class NocturnalSleepGoal extends Goal {

	public DinosaurEntity entity;

	public NocturnalSleepGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean canUse() {
		Level world = entity.level;
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (!player.isShiftKeyDown()) return false;
		}
		return (PrehistoricFaunaConfig.sleeping = true && world.getDayTime() % 24000 >= 0 && world.getDayTime() % 24000 <= 12000 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava() && !PrehistoricFaunaConfig.unscheduledSleeping && entity.warryTicks == 0);
	}

	@Override
	public boolean canContinueToUse() {
		Level world = entity.level;
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (player.isShiftKeyDown()) {
				if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || !super.canContinueToUse() || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
					stop();
					return false;
				} else return true;
			} else {
				stop();
				return false;
			}
		}
		if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || !super.canContinueToUse() || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
			stop();
			return false;
		} else return true;
	}

	@Override
	public void start() {
		entity.setAsleep(true);
		entity.xxa = 0.0F;
		entity.yya = 0.0F;
		entity.zza = 0.0F;
		entity.getNavigation().stop();;
	}

	public void tick() {
		super.tick();
		Level world = entity.level;
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (!player.isShiftKeyDown()) {
				stop();
			}
		}
		if (world.getDayTime() % 24000 >= 12000 && world.getDayTime() % 24000 <= 24000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
			stop();
		}
	}

	@Override
	public void stop() {
		entity.setAwakeTicks(100);
		entity.setAsleep(false);
	}

}
