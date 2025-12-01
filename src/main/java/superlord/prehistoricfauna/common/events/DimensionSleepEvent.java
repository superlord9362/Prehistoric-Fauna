package superlord.prehistoricfauna.common.events;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.level.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFDimensions;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DimensionSleepEvent {

    private static final Map<UUID, Long> playerSleepTimes = new ConcurrentHashMap<>();
    private static final long SLEEP_TIME_THRESHOLD = 100;

    @SubscribeEvent
    public static void onPlayerSleep(PlayerSleepInBedEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!level.isClientSide && level instanceof ServerLevel) {
            playerSleepTimes.put(player.getUUID(), level.getGameTime());
        }
    }

    @SubscribeEvent
    public static void onPlayerWake(PlayerWakeUpEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!level.isClientSide && level instanceof ServerLevel) {
            playerSleepTimes.remove(player.getUUID());
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        MinecraftServer server = event.getServer();
        if (server == null) return;

        int totalPlayers = 0;
        int sleepingPlayers = 0;

        for (ServerLevel serverLevel : server.getAllLevels()) {
            for (Player player : serverLevel.players()) {

                totalPlayers++;

                if (player.isSleeping()) {
                    Long sleepStartTime = playerSleepTimes.get(player.getUUID());
                    if (sleepStartTime != null &&
                        serverLevel.getGameTime() - sleepStartTime >= SLEEP_TIME_THRESHOLD) {

                        sleepingPlayers++;
                    }
                }
            }
        }

        if (totalPlayers == 0) return;

        int requiredPercent = server.overworld()
                .getGameRules()
                .getInt(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE);

        float currentPercent = (sleepingPlayers / (float) totalPlayers) * 100f;

        if (currentPercent < requiredPercent) return;
        long dayTime = server.overworld().getDayTime();
        long skip = 24000L - (dayTime % 24000L);
        long targetTime = dayTime + skip;
        
        for (ServerLevel world : server.getAllLevels()) {
            world.setDayTime(targetTime);

            if (world.dimension() == Level.OVERWORLD ||
                world.dimension() == PFDimensions.CRETACEOUS ||
                world.dimension() == PFDimensions.JURASSIC ||
                world.dimension() == PFDimensions.TRIASSIC) {

                world.setWeatherParameters(0, 0, false, false);
            }
        }

        // Reset stored sleep timers
        playerSleepTimes.clear();
    }
    
    @SubscribeEvent
    public static void onSleepingTimeCheck(SleepFinishedTimeEvent event) {
        // Prevent vanilla from ever skipping time
        event.setResult(Result.DENY);
    }
}
