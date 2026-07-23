package superlord.prehistoricfauna.common.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFCreativeTabs;
import superlord.prehistoricfauna.init.PFItems;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabEvents {

	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == PFCreativeTabs.DECORATION.getKey()) {
			event.accept(PFItems.BASSITHECA_BERRIES.get());
			event.accept(PFItems.MARMARTHIA_BERRIES.get());
		}
		if (ModList.get().isLoaded("quark") || ModList.get().isLoaded("woodworks")) {
			if (event.getTabKey() == PFCreativeTabs.BUILDING.getKey()) {
				event.accept(PFBlocks.METASEQUOIA_BOOKSHELF.get());
				event.accept(PFBlocks.ARAUCARIA_BOOKSHELF.get());
				event.accept(PFBlocks.LIRIODENDRITES_BOOKSHELF.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_BOOKSHELF.get());
				event.accept(PFBlocks.MONANTHESIA_BOOKSHELF.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_BOOKSHELF.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_BOOKSHELF.get());
				event.accept(PFBlocks.GINKGO_BOOKSHELF.get());
				event.accept(PFBlocks.TROCHODENDROIDES_BOOKSHELF.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_BOOKSHELF.get());
				event.accept(PFBlocks.AGATHOXYLON_BOOKSHELF.get());
				event.accept(PFBlocks.WOODWORTHIA_BOOKSHELF.get());
				event.accept(PFBlocks.SCHILDERIA_BOOKSHELF.get());
				event.accept(PFBlocks.DRYOPHYLLUM_BOOKSHELF.get());
				event.accept(PFBlocks.TAXODIUM_BOOKSHELF.get());
				event.accept(PFBlocks.SABALITES_BOOKSHELF.get());
				event.accept(PFBlocks.PLATANITES_BOOKSHELF.get());
				event.accept(PFBlocks.TAXUS_BOOKSHELF.get());
				event.accept(PFBlocks.CZEKANOWSKIA_BOOKSHELF.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_BOOKSHELF.get());
				event.accept(PFBlocks.PODOZAMITES_BOOKSHELF.get());
				event.accept(PFBlocks.NEOCALAMITES_BOOKSHELF.get());
			}
			if (event.getTabKey() == PFCreativeTabs.DECORATION.getKey()) {
				event.accept(PFBlocks.METASEQUOIA_LADDER.get());
				event.accept(PFBlocks.ARAUCARIA_LADDER.get());
				event.accept(PFBlocks.LIRIODENDRITES_LADDER.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_LADDER.get());
				event.accept(PFBlocks.MONANTHESIA_LADDER.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_LADDER.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_LADDER.get());
				event.accept(PFBlocks.GINKGO_LADDER.get());
				event.accept(PFBlocks.TROCHODENDROIDES_LADDER.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_LADDER.get());
				event.accept(PFBlocks.AGATHOXYLON_LADDER.get());
				event.accept(PFBlocks.WOODWORTHIA_LADDER.get());
				event.accept(PFBlocks.SCHILDERIA_LADDER.get());
				event.accept(PFBlocks.DRYOPHYLLUM_LADDER.get());
				event.accept(PFBlocks.TAXODIUM_LADDER.get());
				event.accept(PFBlocks.SABALITES_LADDER.get());
				event.accept(PFBlocks.PLATANITES_LADDER.get());
				event.accept(PFBlocks.TAXUS_LADDER.get());
				event.accept(PFBlocks.CZEKANOWSKIA_LADDER.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_LADDER.get());
				event.accept(PFBlocks.PODOZAMITES_LADDER.get());
				event.accept(PFBlocks.NEOCALAMITES_LADDER.get());

				event.accept(PFBlocks.METASEQUOIA_CHEST.get());
				event.accept(PFBlocks.ARAUCARIA_CHEST.get());
				event.accept(PFBlocks.LIRIODENDRITES_CHEST.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_CHEST.get());
				event.accept(PFBlocks.MONANTHESIA_CHEST.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_CHEST.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_CHEST.get());
				event.accept(PFBlocks.GINKGO_CHEST.get());
				event.accept(PFBlocks.TROCHODENDROIDES_CHEST.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_CHEST.get());
				event.accept(PFBlocks.AGATHOXYLON_CHEST.get());
				event.accept(PFBlocks.WOODWORTHIA_CHEST.get());
				event.accept(PFBlocks.SCHILDERIA_CHEST.get());
				event.accept(PFBlocks.DRYOPHYLLUM_CHEST.get());
				event.accept(PFBlocks.TAXODIUM_CHEST.get());
				event.accept(PFBlocks.SABALITES_CHEST.get());
				event.accept(PFBlocks.PLATANITES_CHEST.get());
				event.accept(PFBlocks.TAXUS_CHEST.get());
				event.accept(PFBlocks.CZEKANOWSKIA_CHEST.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_CHEST.get());
				event.accept(PFBlocks.PODOZAMITES_CHEST.get());
				event.accept(PFBlocks.NEOCALAMITES_CHEST.get());

				event.accept(PFBlocks.METASEQUOIA_TRAPPED_CHEST.get());
				event.accept(PFBlocks.ARAUCARIA_TRAPPED_CHEST.get());
				event.accept(PFBlocks.LIRIODENDRITES_TRAPPED_CHEST.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_TRAPPED_CHEST.get());
				event.accept(PFBlocks.MONANTHESIA_TRAPPED_CHEST.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_TRAPPED_CHEST.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_TRAPPED_CHEST.get());
				event.accept(PFBlocks.GINKGO_TRAPPED_CHEST.get());
				event.accept(PFBlocks.TROCHODENDROIDES_TRAPPED_CHEST.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_TRAPPED_CHEST.get());
				event.accept(PFBlocks.AGATHOXYLON_TRAPPED_CHEST.get());
				event.accept(PFBlocks.WOODWORTHIA_TRAPPED_CHEST.get());
				event.accept(PFBlocks.SCHILDERIA_TRAPPED_CHEST.get());
				event.accept(PFBlocks.DRYOPHYLLUM_TRAPPED_CHEST.get());
				event.accept(PFBlocks.TAXODIUM_TRAPPED_CHEST.get());
				event.accept(PFBlocks.SABALITES_TRAPPED_CHEST.get());
				event.accept(PFBlocks.PLATANITES_TRAPPED_CHEST.get());
				event.accept(PFBlocks.TAXUS_TRAPPED_CHEST.get());
				event.accept(PFBlocks.CZEKANOWSKIA_TRAPPED_CHEST.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_TRAPPED_CHEST.get());
				event.accept(PFBlocks.PODOZAMITES_TRAPPED_CHEST.get());
				event.accept(PFBlocks.NEOCALAMITES_TRAPPED_CHEST.get());
				
				event.accept(PFBlocks.METASEQUOIA_BEEHIVE.get());
				event.accept(PFBlocks.ARAUCARIA_BEEHIVE.get());
				event.accept(PFBlocks.LIRIODENDRITES_BEEHIVE.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_BEEHIVE.get());
				event.accept(PFBlocks.MONANTHESIA_BEEHIVE.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_BEEHIVE.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_BEEHIVE.get());
				event.accept(PFBlocks.GINKGO_BEEHIVE.get());
				event.accept(PFBlocks.TROCHODENDROIDES_BEEHIVE.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_BEEHIVE.get());
				event.accept(PFBlocks.AGATHOXYLON_BEEHIVE.get());
				event.accept(PFBlocks.WOODWORTHIA_BEEHIVE.get());
				event.accept(PFBlocks.SCHILDERIA_BEEHIVE.get());
				event.accept(PFBlocks.DRYOPHYLLUM_BEEHIVE.get());
				event.accept(PFBlocks.TAXODIUM_BEEHIVE.get());
				event.accept(PFBlocks.SABALITES_BEEHIVE.get());
				event.accept(PFBlocks.PLATANITES_BEEHIVE.get());
				event.accept(PFBlocks.TAXUS_BEEHIVE.get());
				event.accept(PFBlocks.CZEKANOWSKIA_BEEHIVE.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_BEEHIVE.get());
				event.accept(PFBlocks.PODOZAMITES_BEEHIVE.get());
				event.accept(PFBlocks.NEOCALAMITES_BEEHIVE.get());
			}
		}
		if (ModList.get().isLoaded("quark")) {
			if (event.getTabKey() == PFCreativeTabs.BUILDING.getKey()) {
				event.accept(PFBlocks.METASEQUOIA_VERTICAL_SLAB.get());
				event.accept(PFBlocks.ARAUCARIA_VERTICAL_SLAB.get());
				event.accept(PFBlocks.LIRIODENDRITES_VERTICAL_SLAB.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_VERTICAL_SLAB.get());
				event.accept(PFBlocks.MONANTHESIA_VERTICAL_SLAB.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_VERTICAL_SLAB.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_VERTICAL_SLAB.get());
				event.accept(PFBlocks.GINKGO_VERTICAL_SLAB.get());
				event.accept(PFBlocks.TROCHODENDROIDES_VERTICAL_SLAB.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_VERTICAL_SLAB.get());
				event.accept(PFBlocks.AGATHOXYLON_VERTICAL_SLAB.get());
				event.accept(PFBlocks.WOODWORTHIA_VERTICAL_SLAB.get());
				event.accept(PFBlocks.SCHILDERIA_VERTICAL_SLAB.get());
				event.accept(PFBlocks.DRYOPHYLLUM_VERTICAL_SLAB.get());
				event.accept(PFBlocks.TAXODIUM_VERTICAL_SLAB.get());
				event.accept(PFBlocks.SABALITES_VERTICAL_SLAB.get());
				event.accept(PFBlocks.PLATANITES_VERTICAL_SLAB.get());
				event.accept(PFBlocks.TAXUS_VERTICAL_SLAB.get());
				event.accept(PFBlocks.CZEKANOWSKIA_VERTICAL_SLAB.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_VERTICAL_SLAB.get());
				event.accept(PFBlocks.PODOZAMITES_VERTICAL_SLAB.get());
				event.accept(PFBlocks.NEOCALAMITES_VERTICAL_SLAB.get());
				event.accept(PFBlocks.TRIASSIC_SANDSTONE_VERTICAL_SLAB.get());
				event.accept(PFBlocks.POLISHED_TRIASSIC_SANDSTONE_VERTICAL_SLAB.get());
				event.accept(PFBlocks.TRIASSIC_SANDSTONE_BRICK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.JURASSIC_SILTSTONE_VERTICAL_SLAB.get());
				event.accept(PFBlocks.POLISHED_JURASSIC_SILTSTONE_VERTICAL_SLAB.get());
				event.accept(PFBlocks.JURASSIC_SILTSTONE_BRICK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.CRETACEOUS_CHALK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.POLISHED_CRETACEOUS_CHALK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.CRETACEOUS_CHALK_BRICK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.HENOSTONE_VERTICAL_SLAB.get());
				event.accept(PFBlocks.HENOSTONE_BRICK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.HENOSTONE_DARK_BRICK_VERTICAL_SLAB.get());
				event.accept(PFBlocks.THATCH_VERTICAL_SLAB.get());

				event.accept(PFBlocks.METASEQUOIA_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.ARAUCARIA_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.LIRIODENDRITES_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.MONANTHESIA_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.GINKGO_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.TROCHODENDROIDES_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.AGATHOXYLON_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.WOODWORTHIA_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.SCHILDERIA_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.DRYOPHYLLUM_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.TAXODIUM_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.SABALITES_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.PLATANITES_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.TAXUS_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.CZEKANOWSKIA_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.PODOZAMITES_VERTICAL_PLANKS.get());
				event.accept(PFBlocks.NEOCALAMITES_VERTICAL_PLANKS.get());

				event.accept(PFBlocks.CHALK_PILLAR.get());
				event.accept(PFBlocks.SILTSTONE_PILLAR.get());
				event.accept(PFBlocks.SANDSTONE_PILLAR.get());

				event.accept(PFBlocks.METASEQUOIA_POST.get());
				event.accept(PFBlocks.STRIPPED_METASEQUOIA_POST.get());
				event.accept(PFBlocks.ARAUCARIA_POST.get());
				event.accept(PFBlocks.STRIPPED_ARAUCARIA_POST.get());
				event.accept(PFBlocks.LIRIODENDRITES_POST.get());
				event.accept(PFBlocks.STRIPPED_LIRIODENDRITES_POST.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_POST.get());
				event.accept(PFBlocks.STRIPPED_PROTOPICEOXYLON_POST.get());
				event.accept(PFBlocks.MONANTHESIA_POST.get());
				event.accept(PFBlocks.STRIPPED_ZAMITES_POST.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_POST.get());
				event.accept(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_POST.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_POST.get());
				event.accept(PFBlocks.STRIPPED_HEIDIPHYLLUM_POST.get());
				event.accept(PFBlocks.GINKGO_POST.get());
				event.accept(PFBlocks.STRIPPED_GINKGO_POST.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_POST.get());
				event.accept(PFBlocks.STRIPPED_BRACHYPHYLLUM_POST.get());
				event.accept(PFBlocks.AGATHOXYLON_POST.get());
				event.accept(PFBlocks.STRIPPED_AGATHOXYLON_POS.get());
				event.accept(PFBlocks.WOODWORTHIA_POST.get());
				event.accept(PFBlocks.STRIPPED_WOODWORTHIA_POST.get());
				event.accept(PFBlocks.SCHILDERIA_POST.get());
				event.accept(PFBlocks.STRIPPED_SCHILDERIA_POST.get());
				event.accept(PFBlocks.DRYOPHYLLUM_POST.get());
				event.accept(PFBlocks.STRIPPED_DRYOPHYLLUM_POST.get());
				event.accept(PFBlocks.TAXODIUM_POST.get());
				event.accept(PFBlocks.STRIPPED_TAXODIUM_POST.get());
				event.accept(PFBlocks.SABALITES_POST.get());
				event.accept(PFBlocks.STRIPPED_SABALITES_POST.get());
				event.accept(PFBlocks.PLATANITES_POST.get());
				event.accept(PFBlocks.STRIPPED_PLATANITES_POST.get());
				event.accept(PFBlocks.TAXUS_POST.get());
				event.accept(PFBlocks.STRIPPED_TAXUS_POST.get());
				event.accept(PFBlocks.CZEKANOWSKIA_POST.get());
				event.accept(PFBlocks.STRIPPED_CZEKANOWSKIA_POST.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_POST.get());
				event.accept(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_POST.get());
				event.accept(PFBlocks.PODOZAMITES_POST.get());
				event.accept(PFBlocks.STRIPPED_PODOZAMITES_POST.get());

				event.accept(PFBlocks.METASEQUOIA_HEDGE.get());
				event.accept(PFBlocks.ARAUCARIA_HEDGE.get());
				event.accept(PFBlocks.LIRIODENDRITES_HEDGE.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_HEDGE.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_HEDGE.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_HEDGE.get());
				event.accept(PFBlocks.GINKGO_HEDGE.get());
				event.accept(PFBlocks.YELLOW_GINKGO_HEDGE.get());
				event.accept(PFBlocks.TROCHODENDROIDES_HEDGE.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_HEDGE.get());
				event.accept(PFBlocks.AGATHOXYLON_HEDGE.get());
				event.accept(PFBlocks.WOODWORTHIA_HEDGE.get());
				event.accept(PFBlocks.SCHILDERIA_HEDGE.get());
				event.accept(PFBlocks.DRYOPHYLLUM_HEDGE.get());
				event.accept(PFBlocks.TAXODIUM_HEDGE.get());
				event.accept(PFBlocks.PLATANITES_HEDGE.get());
				event.accept(PFBlocks.TAXUS_HEDGE.get());
				event.accept(PFBlocks.CZEKANOWSKIA_HEDGE.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_HEDGE.get());
				event.accept(PFBlocks.PODOZAMITES_HEDGE.get());
				
				event.accept(PFBlocks.HOLLOW_AGATHOXYLON_LOG.get());
				event.accept(PFBlocks.HOLLOW_ARAUCARIA_LOG.get());
				event.accept(PFBlocks.HOLLOW_BRACHYPHYLLUM_LOG.get());
				event.accept(PFBlocks.HOLLOW_CUPRESSINOCLADUS_LOG.get());
				event.accept(PFBlocks.HOLLOW_CZEKANOWSKIA_LOG.get());
				event.accept(PFBlocks.HOLLOW_DRYOPHYLLUM_LOG.get());
				event.accept(PFBlocks.HOLLOW_ELATIDES_LOG.get());
				event.accept(PFBlocks.HOLLOW_FRENELOPSIS_LOG.get());
				event.accept(PFBlocks.HOLLOW_GINKGO_LOG.get());
				event.accept(PFBlocks.HOLLOW_HEIDIPHYLLUM_LOG.get());
				event.accept(PFBlocks.HOLLOW_LIRIODENDRITES_LOG.get());
				event.accept(PFBlocks.HOLLOW_METASEQUOIA_LOG.get());
				event.accept(PFBlocks.HOLLOW_MONANTHESIA_LOG.get());
				event.accept(PFBlocks.HOLLOW_PHOENICOPSIS_LOG.get());
				event.accept(PFBlocks.HOLLOW_PLATANITES_LOG.get());
				event.accept(PFBlocks.HOLLOW_PODOZAMITES_LOG.get());
				event.accept(PFBlocks.HOLLOW_PROTOJUNIPEROXYLON_LOG.get());
				event.accept(PFBlocks.HOLLOW_PROTOPICEOXYLON_LOG.get());
				event.accept(PFBlocks.HOLLOW_SABALITES_LOG.get());
				event.accept(PFBlocks.HOLLOW_SCHILDERIA_LOG.get());
				event.accept(PFBlocks.HOLLOW_SCHIZOLEPIDOPSIS_LOG.get());
				event.accept(PFBlocks.HOLLOW_TAXODIUM_LOG.get());
				event.accept(PFBlocks.HOLLOW_TAXUS_LOG.get());
				event.accept(PFBlocks.HOLLOW_TROCHODENDROIDES_LOG.get());
				event.accept(PFBlocks.HOLLOW_WOODWORTHIA_LOG.get());
			}
			if (event.getTabKey() == PFCreativeTabs.DECORATION.getKey()) {
				event.accept(PFBlocks.METASEQUOIA_LEAF_CARPET.get());
				event.accept(PFBlocks.ARAUCARIA_LEAF_CARPET.get());
				event.accept(PFBlocks.LIRIODENDRITES_LEAF_CARPET.get());
				event.accept(PFBlocks.PROTOPICEOXYLON_LEAF_CARPET.get());
				event.accept(PFBlocks.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
				event.accept(PFBlocks.HEIDIPHYLLUM_LEAF_CARPET.get());
				event.accept(PFBlocks.GINKGO_LEAF_CARPET.get());
				event.accept(PFBlocks.YELLOW_GINKGO_LEAF_CARPET.get());
				event.accept(PFBlocks.TROCHODENDROIDES_LEAF_CARPET.get());
				event.accept(PFBlocks.BRACHYPHYLLUM_LEAF_CARPET.get());
				event.accept(PFBlocks.AGATHOXYLON_LEAF_CARPET.get());
				event.accept(PFBlocks.WOODWORTHIA_LEAF_CARPET.get());
				event.accept(PFBlocks.SCHILDERIA_LEAF_CARPET.get());
				event.accept(PFBlocks.DRYOPHYLLUM_LEAF_CARPET.get());
				event.accept(PFBlocks.TAXODIUM_LEAF_CARPET.get());
				event.accept(PFBlocks.PLATANITES_LEAF_CARPET.get());
				event.accept(PFBlocks.TAXUS_LEAF_CARPET.get());
				event.accept(PFBlocks.CZEKANOWSKIA_LEAF_CARPET.get());
				event.accept(PFBlocks.SCHIZOLEPIDOPSIS_LEAF_CARPET.get());
				event.accept(PFBlocks.PODOZAMITES_LEAF_CARPET.get());
			}
		}
	}

}
