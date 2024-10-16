package superlord.prehistoricfauna.common;

import java.util.List;
import java.util.Map;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.recipes.ItemWeightedPairCodec;
import superlord.prehistoricfauna.common.recipes.PaleontologyTableRecipeJsonManager;
import superlord.prehistoricfauna.common.recipes.PaleontologyTableRecipeS2C;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PFForgeCommonEvents {
	
	@SubscribeEvent
	public static void onRegisterReloadListeners(ServerStartedEvent event) {
		try {
			PaleontologyTableRecipeJsonManager.populateRecipeMap(event.getServer().getLevel(Level.OVERWORLD));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@SubscribeEvent
	public static void synchDataPack(OnDatapackSyncEvent event) {
		ServerPlayer player = event.getPlayer();
		List<ServerPlayer> playerList = event.getPlayerList().getPlayers();
		Map<Item, List<ItemWeightedPairCodec>> paleontologyTableRecipes = PaleontologyTableRecipeJsonManager.getRecipes();
		if (player != null) {
			PrehistoricFauna.sendToPlayer(new PaleontologyTableRecipeS2C(paleontologyTableRecipes), player);
		}
		if (playerList != null && !playerList.isEmpty()) {
			for (ServerPlayer player1 : playerList) {
				ServerLevel serverLevel = (ServerLevel) player1.level();
				if (PaleontologyTableRecipeJsonManager.getRecipes().isEmpty()) {
					PaleontologyTableRecipeJsonManager.populateRecipeMap(serverLevel);
				}
				Map<Item, List<ItemWeightedPairCodec>> paleontologyTableRecipesReload = PaleontologyTableRecipeJsonManager.getRecipes();
				PrehistoricFauna.sendToPlayer(new PaleontologyTableRecipeS2C(paleontologyTableRecipesReload), player1);
			}
		}
	}
	
	@SubscribeEvent
	public static void onRegisterReloadListeners(AddReloadListenerEvent event) {
		event.addListener(new PaleontologyTableRecipeJsonManager());
	}

}
