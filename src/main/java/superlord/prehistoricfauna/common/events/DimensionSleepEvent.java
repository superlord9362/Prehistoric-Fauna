package superlord.prehistoricfauna.common.events;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DimensionSleepEvent {

	private static final Map<Player, Long> playerSleepTimes = new ConcurrentHashMap<>();
    private static final long SLEEP_TIME_THRESHOLD = 100;

    @SubscribeEvent
    public static void onPlayerSleep(PlayerSleepInBedEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!level.isClientSide && level instanceof ServerLevel) {
            playerSleepTimes.put(player, level.getGameTime());
        }
    }

    @SubscribeEvent
    public static void onPlayerWake(PlayerWakeUpEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!level.isClientSide && level instanceof ServerLevel) {
            playerSleepTimes.remove(player);
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            MinecraftServer server = event.getServer();
            if (server != null) {
                for (ServerLevel serverLevel : server.getAllLevels()) {
                	long currentDaysTime = serverLevel.getDayTime() % 24000;
                	float newTime = 24000 - currentDaysTime;
                	int sleepingPlayers = 0;
                    int totalPlayers = 0;
                    boolean allPlayersSleptLongEnough = true;

                    for (Player player : serverLevel.players()) {
                    	
                        totalPlayers++;
                        if (player.isSleeping()) {
                            Long sleepStartTime = playerSleepTimes.get(player);
                            if (sleepStartTime != null && serverLevel.getGameTime() - sleepStartTime >= SLEEP_TIME_THRESHOLD) {
                                sleepingPlayers++;
                            } else {
                                allPlayersSleptLongEnough = false;
                            }
                        } else {
                            allPlayersSleptLongEnough = false;
                        }
                    }
                    if (allPlayersSleptLongEnough && totalPlayers > 0) {
                        float sleepPercentage = serverLevel.getGameRules().getInt(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE);
                        float sleepingPercentage = (sleepingPlayers / (float) totalPlayers) * 100;
                        if (sleepingPercentage >= sleepPercentage) {
                            for (ServerLevel world : server.getAllLevels()) {
                                world.setDayTime(world.dayTime() + (long) newTime - 24000);
                                world.setWeatherParameters(0, 0, false, false);
                            }
                            playerSleepTimes.clear();
                        }
                    }
                }
            }
        }
    }
}