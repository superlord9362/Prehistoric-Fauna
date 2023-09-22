package superlord.prehistoricfauna.common.entity.goal;

import java.util.List;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DiurnalSleepingGoal extends Goal {

	public DinosaurEntity entity;

	public DiurnalSleepingGoal(DinosaurEntity sleeper) {
		super();
		this.entity = sleeper;
	}

	@Override
	public boolean canUse() {
		Level level = entity.level;
		List<? extends Player> list = level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D));
		if (!list.isEmpty()) {
			for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
				if (player.isShiftKeyDown()) {
					if (PrehistoricFaunaConfig.sleeping = true && level.getDayTime() % 24000 >= 12000 && level.getDayTime() % 24000 <= 24000 && entity.getTarget() == null && !entity.isTame() && !entity.isInWater() && !entity.isInLava() && entity.getLastHurtByMob() == null && !PrehistoricFaunaConfig.unscheduledSleeping) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			return false;
		} else {
			if (PrehistoricFaunaConfig.sleeping = true && level.getDayTime() % 24000 >= 12000 && level.getDayTime() % 24000 <= 24000 && entity.getTarget() == null && !entity.isTame() && !entity.isInWater() && !entity.isInLava() && entity.getLastHurtByMob() == null && !PrehistoricFaunaConfig.unscheduledSleeping) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean canContinueToUse() {
		Level level = entity.level;
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (player.isShiftKeyDown()) {
				if (level.getDayTime() % 24000 >= 0 && level.getDayTime() % 24000 < 12000 || entity.getTarget() != null || super.canContinueToUse() || entity.isTame() || entity.isInWater() || entity.isInLava() || entity.getLastHurtByMob() != null) {
					stop();
					return false;
				} else return true;
			} else {
				stop();
				return false;
			}
		}
		if (level.getDayTime() % 24000 >= 0 && level.getDayTime() % 24000 < 12000 || entity.getTarget() != null || super.canContinueToUse() || entity.isTame() || entity.isInWater() || entity.isInLava() || entity.getLastHurtByMob() != null) {
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
		entity.getNavigation().stop();
	}

	public void tick() {
		super.tick();
		Level level = entity.level;
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (player.isShiftKeyDown()) {
				if (level.getDayTime() % 24000 >= 0 && level.getDayTime() % 24000 < 12000 || entity.getTarget() != null || super.canContinueToUse() || entity.isTame() || entity.isInWater() || entity.isInLava() || entity.getLastHurtByMob() != null) {
					stop();
					entity.setAsleep(false);
				}
			} else {
				entity.setAsleep(false);
				stop();
				}
		}
		if (level.getDayTime() % 24000 >= 0 && level.getDayTime() % 24000 < 12000 || entity.getTarget() != null || entity.isTame() || entity.isInWater() || entity.isInLava() || entity.getLastHurtByMob() != null) {
			entity.setAsleep(false);
			stop();
		}
	}

	@Override
	public void stop() {
		entity.setAsleep(false);
	}

}
