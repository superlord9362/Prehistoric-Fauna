package superlord.prehistoricfauna.common.events;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.items.ItemHandlerHelper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFItems;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Bus.FORGE)
public class PlayerJoinWorldEvents {
	
	@SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (PrehistoricFaunaConfig.giveAncientJournalOnStartup) {
            CompoundTag playerData = event.getEntity().getPersistentData();
            CompoundTag data = playerData.getCompound(Player.PERSISTED_NBT_TAG);
            if (data != null && !data.getBoolean("prehistoricfauna_has_ancient_journal")) {
                ItemHandlerHelper.giveItemToPlayer(event.getEntity(), new ItemStack(PFItems.PALEOPEDIA.get()));
                data.putBoolean("prehistoricfauna_has_ancient_journal", true);
                playerData.put(Player.PERSISTED_NBT_TAG, data);
            }
        }
    }
	
}
