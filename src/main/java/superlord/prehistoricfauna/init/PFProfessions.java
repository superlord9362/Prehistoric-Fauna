package superlord.prehistoricfauna.init;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFProfessions {

	public static PoiType PALEONTOLOGY_TABLE_POI;
	public static VillagerProfession GEOLOGIST;

	@SubscribeEvent
	public static void registerPointOfInterests(final RegistryEvent.Register<PoiType> event) {
		event.getRegistry().register(PALEONTOLOGY_TABLE_POI = new PoiType("geologist_poi", ImmutableSet.copyOf(PFBlocks.PALEONTOLOGY_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1).setRegistryName("prehistoricfauna:geologist"));
		PoiType.registerBlockStates(PALEONTOLOGY_TABLE_POI);
	}

	@SubscribeEvent
	public static void registerVillagerProfessions(final RegistryEvent.Register<VillagerProfession> event) {
		event.getRegistry().register(GEOLOGIST = new VillagerProfession("geologist", PALEONTOLOGY_TABLE_POI, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON).setRegistryName("prehistoricfauna:geologist"));
	}

	public static void fillTradeData() {
		VillagerTrades.ItemListing[] geologistLevel1 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.EmeraldForItems(Items.STONE, 24, 25, 2),
				new VillagerTrades.EmeraldForItems(Items.ANDESITE, 24, 25, 2),
				new VillagerTrades.EmeraldForItems(Items.GRANITE, 24, 25, 2),
				new VillagerTrades.EmeraldForItems(Items.DIORITE, 24, 25, 2),
				new VillagerTrades.EmeraldForItems(Items.SANDSTONE, 24, 25, 2),
				new VillagerTrades.EmeraldForItems(Items.RED_SANDSTONE, 24, 25, 2),
				new VillagerTrades.EmeraldForItems(PFItems.SANDSTONE.get(), 24, 25, 2),
				new VillagerTrades.EmeraldForItems(PFItems.SILTSTONE.get(), 24, 25, 2),
				new VillagerTrades.EmeraldForItems(PFItems.CHALK.get(), 24, 25, 2),
				new VillagerTrades.ItemsForEmeralds(PFItems.GEOLOGY_HAMMER.get(), 1, 1, 10, 2)
		};
		VillagerTrades.ItemListing[] geologistLevel2 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(Items.STONE, 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(Items.ANDESITE, 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(Items.GRANITE, 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(Items.DIORITE, 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(Items.SANDSTONE, 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(Items.RED_SANDSTONE, 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(PFItems.SANDSTONE.get(), 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(PFItems.SILTSTONE.get(), 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(PFItems.CHALK.get(), 1, 1, 16, 2),
				new VillagerTrades.ItemsForEmeralds(PFItems.SILTSTONE_FOSSIL.get(), 2, 1, 16, 5),
				new VillagerTrades.ItemsForEmeralds(PFItems.SANDSTONE_FOSSIL.get(), 2, 1, 16, 5),
				new VillagerTrades.ItemsForEmeralds(PFItems.CHALK_FOSSIL.get(), 2, 1, 16, 5)
		};
		VillagerTrades.ItemListing[] geologistLevel3 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(PFItems.PETRIFIED_WOOD.get(), 2, 1, 16, 5),
				new VillagerTrades.ItemsForEmeralds(PFItems.SMALL_AMMONITE_FOSSIL.get(), 3, 1, 16, 5),
				new VillagerTrades.ItemsForEmeralds(PFItems.MEDIUM_AMMONITE_FOSSIL.get(), 3, 1, 16, 5),
				new VillagerTrades.ItemsForEmeralds(PFItems.LARGE_AMMONITE_FOSSIL.get(), 3, 1, 16, 5)
		};
		VillagerTrades.ItemListing[] geologistLevel4 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(PFItems.FOSSILIZED_BONES.get(), 3, 1, 12, 6),
				new VillagerTrades.ItemsForEmeralds(PFItems.GiANT_AMMONITE_FOSSIL_PIECE_BB.get(), 4, 1, 12, 6),
				new VillagerTrades.ItemsForEmeralds(PFItems.GiANT_AMMONITE_FOSSIL_PIECE_BF.get(), 4, 1, 12, 6),
				new VillagerTrades.ItemsForEmeralds(PFItems.GiANT_AMMONITE_FOSSIL_PIECE_TB.get(), 4, 1, 12, 6),
				new VillagerTrades.ItemsForEmeralds(PFItems.GiANT_AMMONITE_FOSSIL_PIECE_TF.get(), 4, 1, 12, 6)
		};
		VillagerTrades.ItemListing[] geologistLevel5 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(PFItems.HENOSTONE.get(), 6, 1, 4, 8),
				new VillagerTrades.ItemsForEmeralds(PFItems.TRICERATOPS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.ANKYLOSAURUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.STEGOSAURUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.CERATOSAURUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.HERRERASAURUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.ISCHIGUALASTIA_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.DESMATOSUCHUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.COELOPHYSIS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.SCELIDOSAURUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.SARAHSAURUS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.PLESIOHADROS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.PROTOCERATOPS_SKULL.get(), 4, 1, 8, 7),
				new VillagerTrades.ItemsForEmeralds(PFItems.TYRANNOSAURUS_SKULL.get(), 5, 1, 4, 8),
				new VillagerTrades.ItemsForEmeralds(PFItems.ALLOSAURUS_SKULL.get(), 5, 1, 4, 8),
				new VillagerTrades.ItemsForEmeralds(PFItems.SAUROSUCHUS_SKULL.get(), 5, 1, 4, 8),
				new VillagerTrades.ItemsForEmeralds(PFItems.VELOCIRAPTOR_SKULL.get(), 5, 1, 4, 8),
				new VillagerTrades.ItemsForEmeralds(PFItems.DILOPHOSAURUS_SKULL.get(), 5, 1, 4, 8),
				new VillagerTrades.ItemsForEmeralds(PFItems.POSTOSUCHUS_SKULL.get(), 5, 1, 4, 8)
		};
		VillagerTrades.TRADES.put(GEOLOGIST, toIntMap(ImmutableMap.of(1, geologistLevel1, 2, geologistLevel2, 3, geologistLevel3, 4, geologistLevel4, 5, geologistLevel5)));
	}

	private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_221238_0_) {
		return new Int2ObjectOpenHashMap<>(p_221238_0_);
	}

}
