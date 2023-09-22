package superlord.prehistoricfauna.common.entity.goal;

import java.util.List;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CathemeralSleepGoal extends Goal {

	public DinosaurEntity entity;
	private int sleepTimer = 0;

	public CathemeralSleepGoal(DinosaurEntity sleeper) {
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
					if (PrehistoricFaunaConfig.sleeping = true && entity.getRandom().nextInt(1000) == 0 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava() && !PrehistoricFaunaConfig.unscheduledSleeping) {
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
			if (PrehistoricFaunaConfig.sleeping = true && entity.getRandom().nextInt(1000) == 0 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava() && !PrehistoricFaunaConfig.unscheduledSleeping) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean canContinueToUse() {
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (player.isShiftKeyDown()) {
				if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || super.canContinueToUse() || entity.isInWater() || entity.isInLava()) {
					entity.setAsleep(false);
					sleepTimer = 0;
					stop();
					return false;
				} else return true;
			} else {
				entity.setAsleep(false);
				sleepTimer = 0;
				stop();
				return false; 
			}
		}
		if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || super.canContinueToUse() || entity.isInWater() || entity.isInLava()) {
			entity.setAsleep(false);
			sleepTimer = 0;
			stop();
			return false;
		} else return true;
	}

	public void tick() {
		super.tick();
		sleepTimer++;
		for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
			if (player.isShiftKeyDown()) {
				if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
					entity.setAsleep(false);
					sleepTimer = 0;
					stop();
				}
			} else {
				entity.setAsleep(false);
				sleepTimer = 0;
				stop();
			}
		}
		if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava()) {
			entity.setAsleep(false);
			sleepTimer = 0;
			stop();
		}
	}

	@Override
	public void start() {
		sleepTimer = 0;
		entity.setAsleep(true);
		entity.xxa = 0.0F;
		entity.yya = 0.0F;
		entity.zza = 0.0F;
		entity.getNavigation().stop();
		entity.lerpMotion(0.0D, 0.0D, 0.0D);
	}

	@Override
	public void stop() {
		sleepTimer = 0;
		entity.setAsleep(false);
	}

}
