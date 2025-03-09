package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CrepuscularSleepGoal extends Goal {

	public DinosaurEntity entity;

	public CrepuscularSleepGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	@SuppressWarnings("resource")
	public boolean canUse() {
		Level level = entity.level();
		for(Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(2D, 2D, 2D))) {
			if (!player.isShiftKeyDown()) return false;
		}
		return PrehistoricFaunaConfig.sleeping = true && (level.getDayTime() % 24000 >= 2000 && level.getDayTime() % 24000 <= 9000 || level.getDayTime() % 24000 >= 14000 && level.getDayTime() % 24000 <= 21000) && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isTame() && !entity.isInWater() && !entity.isInLava() && !entity.getBlockStateOn().is(Blocks.AIR) && !PrehistoricFaunaConfig.unscheduledSleeping && entity.warryTicks == 0;
	}

	@Override
	@SuppressWarnings("resource")
	public boolean canContinueToUse() {
		Level level = entity.level();
		for(Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(2D, 2D, 2D))) {
			if (player.isShiftKeyDown()) {
				return true;
			} else {
				stop();
				entity.setAsleep(false);
				return false;
			}
		}
		if (level.getDayTime() % 24000 <= 2000 || level.getDayTime() % 24000 >= 9000 && level.getDayTime() % 24000 <= 14000 || level.getDayTime() % 24000 >= 21000 && level.getDayTime() % 24000 <= 24000) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.getTarget() != null) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.getLastHurtByMob() != null) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.isTame()) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.isInWater()) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (entity.isInLava()) {
			stop();
			entity.setAsleep(false);
			return false;
		} else if (!entity.getBlockStateOn().is(Blocks.AIR)) {
			stop();
			entity.setAsleep(false);
			return false;
		} else return true;
	}

	public void tick() {
		super.tick();
		entity.getNavigation().stop();;
		Level level = entity.level();
		for(Player player : entity.level().getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(2D, 2D, 2D))) {
			if (!player.isShiftKeyDown()) {
				stop();
				entity.setAsleep(false);
			}
		}
		if (level.getDayTime() % 24000 <= 2000 || level.getDayTime() % 24000 >= 9000 && level.getDayTime() % 24000 <= 14000 || level.getDayTime() % 24000 >= 21000 && level.getDayTime() % 24000 <= 24000) {
			stop();
			entity.setAsleep(false);
		} else if (entity.getTarget() != null) {
			stop();
			entity.setAsleep(false);
		} else if (entity.getLastHurtByMob() != null) {
			stop();
			entity.setAsleep(false);
		} else if (entity.isTame()) {
			stop();
			entity.setAsleep(false);
		} else if (entity.isInWater()) {
			stop();
			entity.setAsleep(false);
		} else if (entity.isInLava()) {
			stop();
			entity.setAsleep(false);
		} else {
			entity.setAsleep(true);
		}
	}

	@Override
	public void start() {
		entity.setAsleep(true);
		entity.xxa = 0.0F;
		entity.yya = 0.0F;
		entity.zza = 0.0F;
		entity.getNavigation().stop();
		entity.setFallingAsleep();
	}

	@Override
	public void stop() {
		entity.setAsleep(false);
		entity.setFallingAsleep();
		entity.setAwakeTicks(100);
	}

}
