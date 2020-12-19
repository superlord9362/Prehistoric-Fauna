package superlord.prehistoricfauna.util;

import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpaceTimeContinuumWarping {
	
	private boolean setIsKilled(boolean isKilled) {
		return isKilled;
	}
	
	@SubscribeEvent
	public void spaceTimeContinuumWarping(LivingDeathEvent event) {
		if (PrehistoricFaunaConfig.spaceTimeContinuumWarping) {
			if (event.getEntity() instanceof HesperornithoidesEntity) {
				if (event.getSource().getTrueSource() instanceof PlayerEntity) {
					this.setIsKilled(true);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void chickenExtinction(CheckSpawn event) {
		if (this.setIsKilled(true)) {
			if (event.getEntity() instanceof ChickenEntity) {
				event.getEntity().remove();
				event.setResult(Result.DENY);
			}
		}
	}

}
