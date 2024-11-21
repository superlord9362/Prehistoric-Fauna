package superlord.prehistoricfauna.common.events;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFProfessions;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class VillagerTradesEvents {
	
	@SubscribeEvent
	public static void addCustomTrades(VillagerTradesEvent event) {
		if (event.getType() == PFProfessions.GEOLOGIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			
			PFProfessions.addGeologistTrades(trades);
		}
		if (event.getType() == VillagerProfession.CARTOGRAPHER) {
			 int level = 2;
	            List<VillagerTrades.ItemListing> list = event.getTrades().get(level);
	            list.add(new VillagerTimeTempleMapTrade(5, 10, 6));
	            event.getTrades().put(level, list);
		}
	}

}
