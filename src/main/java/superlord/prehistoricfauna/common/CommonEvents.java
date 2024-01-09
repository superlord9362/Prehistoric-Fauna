package superlord.prehistoricfauna.common;

import com.google.common.collect.ImmutableMap;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

	@SubscribeEvent
	public static void init(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			compostibleBlockss();
			AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
					.put(PFBlocks.AGATHOXYLON_LOG.get(), PFBlocks.STRIPPED_AGATHOXYLON_LOG.get())
					.put(PFBlocks.AGATHOXYLON_WOOD.get(), PFBlocks.STRIPPED_AGATHOXYLON_WOOD.get())
					.put(PFBlocks.METASEQUOIA_LOG.get(), PFBlocks.STRIPPED_METASEQUOIA_LOG.get())
					.put(PFBlocks.METASEQUOIA_WOOD.get(), PFBlocks.STRIPPED_METASEQUOIA_WOOD.get())
					.put(PFBlocks.ARAUCARIA_LOG.get(), PFBlocks.STRIPPED_ARAUCARIA_LOG.get())
					.put(PFBlocks.ARAUCARIA_WOOD.get(), PFBlocks.STRIPPED_ARAUCARIA_WOOD.get())
					.put(PFBlocks.PROTOPICEOXYLON_LOG.get(), PFBlocks.STRIPPED_PROTOPICEOXYLON_LOG.get())
					.put(PFBlocks.PROTOPICEOXYLON_WOOD.get(), PFBlocks.STRIPPED_PROTOPICEOXYLON_WOOD.get())
					.put(PFBlocks.ZAMITES_LOG.get(), PFBlocks.STRIPPED_ZAMITES_LOG.get())
					.put(PFBlocks.ZAMITES_WOOD.get(), PFBlocks.STRIPPED_ZAMITES_WOOD.get())
					.put(PFBlocks.PROTOJUNIPEROXYLON_LOG.get(), PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_LOG.get())
					.put(PFBlocks.PROTOJUNIPEROXYLON_WOOD.get(), PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_WOOD.get())
					.put(PFBlocks.HEIDIPHYLLUM_LOG.get(), PFBlocks.STRIPPED_HEIDIPHYLLUM_LOG.get())
					.put(PFBlocks.HEIDIPHYLLUM_WOOD.get(), PFBlocks.STRIPPED_HEIDIPHYLLUM_WOOD.get())
					.put(PFBlocks.LIRIODENDRITES_LOG.get(), PFBlocks.STRIPPED_LIRIODENDRITES_LOG.get())
					.put(PFBlocks.LIRIODENDRITES_WOOD.get(), PFBlocks.STRIPPED_LIRIODENDRITES_WOOD.get())
					.put(PFBlocks.DRYOPHYLLUM_LOG.get(), PFBlocks.STRIPPED_DRYOPHYLLUM_LOG.get())
					.put(PFBlocks.DRYOPHYLLUM_WOOD.get(), PFBlocks.STRIPPED_DRYOPHYLLUM_WOOD.get())
					.put(PFBlocks.TAXODIUM_LOG.get(), PFBlocks.STRIPPED_TAXODIUM_LOG.get())
					.put(PFBlocks.TAXODIUM_WOOD.get(), PFBlocks.STRIPPED_TAXODIUM_WOOD.get())
					.put(PFBlocks.SABALITES_LOG.get(), PFBlocks.STRIPPED_SABALITES_LOG.get())
					.put(PFBlocks.SABALITES_GRASSY_LOG.get(), PFBlocks.STRIPPED_SABALITES_LOG.get())
					.put(PFBlocks.SABALITES_WOOD.get(), PFBlocks.STRIPPED_SABALITES_WOOD.get())
					.put(PFBlocks.PLATANITES_LOG.get(), PFBlocks.STRIPPED_PLATANITES_LOG.get())
					.put(PFBlocks.PLATANITES_WOOD.get(), PFBlocks.STRIPPED_PLATANITES_WOOD.get())
					.put(PFBlocks.TAXUS_LOG.get(), PFBlocks.STRIPPED_TAXUS_LOG.get())
					.put(PFBlocks.TAXUS_WOOD.get(), PFBlocks.STRIPPED_TAXUS_WOOD.get()).build();
			registerFlammables();
		});
	}

	private static void compostibleBlockss() {
		compostibleBlocks(0.3F, PFBlocks.AGATHOXYLON_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.METASEQUOIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.ARAUCARIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOPICEOXYLON_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.ZAMITES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.GINKGO_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.YELLOW_GINKGO_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.HEIDIPHYLLUM_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.LIRIODENDRITES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.DRYOPHYLLUM_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.PLATANITES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.TAXODIUM_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.SABALITES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.TAXUS_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.AGATHOXYLON_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.METASEQUOIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.ARAUCARIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOPICEOXYLON_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.ZAMITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOJUNIPEROXYLON_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.LIRIODENDRITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.HEIDIPHYLLUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.DRYOPHYLLUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.TAXODIUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.GINKGO_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.SABALITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PLATANITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.TAXUS_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.HORSETAIL.get());
		compostibleBlocks(0.3F, PFBlocks.OSMUNDA.get());
		compostibleBlocks(0.3F, PFBlocks.CLADOPHLEBIS.get());
		compostibleBlocks(0.3F, PFBlocks.MICHELILLOA.get());
		compostibleBlocks(0.3F, PFBlocks.ALGAE_CARPET.get());
		compostibleBlocks(0.3F, PFBlocks.MOSS_CARPET.get());
		compostibleBlocks(0.3F, PFBlocks.CONIOPTERIS.get());
		compostibleBlocks(0.3F, PFBlocks.OSMUNDACAULIS.get());
		compostibleBlocks(0.3F, PFItems.MOSS_BALL.get());
		compostibleBlocks(0.3F, PFItems.PTILOPHYLLUM_FRONDS.get());
		compostibleBlocks(0.3F, PFBlocks.LAUROZAMITES.get());
		compostibleBlocks(0.3F, PFBlocks.OTOZAMITES.get());
		compostibleBlocks(0.3F, PFBlocks.ARCHAEFRUCTUS.get());
		compostibleBlocks(0.3F, PFBlocks.ARCHAEAMPHORA.get());
		compostibleBlocks(0.3F, PFBlocks.BISONIA.get());
		compostibleBlocks(0.3F, PFItems.MARMARTHIA_BERRIES.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_HORSETAIL.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_OSMUNDA.get());
		compostibleBlocks(0.5F, PFBlocks.SCYTOPHYLLUM.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_ARCHAEFRUCTUS.get());
		compostibleBlocks(0.5F, PFBlocks.MOSS_BLOCK.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_OSMUNDACAULIS.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_OTOZAMITES.get());
		compostibleBlocks(0.65F, PFBlocks.JOHNSTONIA.get());
		compostibleBlocks(0.65F, PFBlocks.CLUBMOSS.get());
		compostibleBlocks(0.65F, PFBlocks.MARCHANTIA.get());
		compostibleBlocks(0.75F, PFBlocks.DICROIDIUM.get());
	}

	private static void compostibleBlocks(float chance, ItemLike item) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}

	public static void registerFlammables() {
		registerFlammable(PFBlocks.ARAUCARIA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.GINKGO_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.GINKGO_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.TROCHODENDROIDES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.TROCHODENDROIDES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.PLATANITES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.PLATANITES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.PLATANITES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.PLATANITES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.PLATANITES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.SABALITES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.SABALITES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.SABALITES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.SABALITES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.SABALITES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.ZAMITES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.ZAMITES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.ZAMITES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.ZAMITES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.ZAMITES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.DRYOPHYLLUM_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.DRYOPHYLLUM_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.TAXUS_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.TAXUS_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.TAXUS_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.TAXUS_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.TAXUS_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.TAXODIUM_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.TAXODIUM_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.TAXODIUM_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.TAXODIUM_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.TAXODIUM_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.GINKGO_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.GINKGO_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.GINKGO_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.TROCHODENDROIDES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.TROCHODENDROIDES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.TROCHODENDROIDES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.BRACHYPHYLLUM_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.BRACHYPHYLLUM_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.BRACHYPHYLLUM_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.AGATHOXYLON_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.AGATHOXYLON_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.AGATHOXYLON_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.DRYOPHYLLUM_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.DRYOPHYLLUM_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.DRYOPHYLLUM_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.WOODWORTHIA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.WOODWORTHIA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.WOODWORTHIA_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.SCHILDERIA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.SCHILDERIA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.SCHILDERIA_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.METASEQUOIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.METASEQUOIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ARAUCARIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_METASEQUOIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.ARAUCARIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.METASEQUOIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ARAUCARIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_METASEQUOIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOPICEOXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOPICEOXYLON_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.PLATANITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PLATANITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.PLATANITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PLATANITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.ZAMITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ZAMITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.ZAMITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ZAMITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.TAXODIUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_TAXODIUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.TAXODIUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_TAXODIUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.SABALITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.SABALITES_GRASSY_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_SABALITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.SABALITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_SABALITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_HEIDIPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_HEIDIPHYLLUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.LIRIODENDRITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_LIRIODENDRITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.LIRIODENDRITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_LIRIODENDRITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.GINKGO_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_GINKGO_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.GINKGO_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_GINKGO_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.TROCHODENDROIDES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_TROCHODENDROIDES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.TROCHODENDROIDES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_TROCHODENDROIDES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.BRACHYPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_BRACHYPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.BRACHYPHYLLUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_BRACHYPHYLLUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.AGATHOXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.AGATHOXYLON_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_AGATHOXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_AGATHOXYLON_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.TAXUS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.TAXUS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_TAXUS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_TAXUS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.DRYOPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.DRYOPHYLLUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_DRYOPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_DRYOPHYLLUM_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.WOODWORTHIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.WOODWORTHIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_WOODWORTHIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_WOODWORTHIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.SCHILDERIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.SCHILDERIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_SCHILDERIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_SCHILDERIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.ARAUCARIA_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.METASEQUOIA_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.ZAMITES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.LIRIODENDRITES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.GINKGO_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.YELLOW_GINKGO_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.DRYOPHYLLUM_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.TROCHODENDROIDES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.BRACHYPHYLLUM_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.AGATHOXYLON_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.WOODWORTHIA_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.SCHILDERIA_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.SABALITES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.PLATANITES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.TAXODIUM_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.TAXUS_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.CLUBMOSS.get(), 60, 100);
		registerFlammable(PFBlocks.HORSETAIL.get(), 60, 100);
		registerFlammable(PFBlocks.OSMUNDA.get(), 60, 100);
		registerFlammable(PFBlocks.OSMUNDACAULIS.get(), 60, 100);
		registerFlammable(PFBlocks.DEAD_OSMUNDACAULIS.get(), 60, 100);
		registerFlammable(PFBlocks.MARCHANTIA.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_HORSETAIL.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_OSMUNDA.get(), 60, 100);
		registerFlammable(PFBlocks.CONIOPTERIS.get(), 60, 100);
		registerFlammable(PFBlocks.ARCHAEAMPHORA.get(), 60, 100);
		registerFlammable(PFBlocks.ARCHAEFRUCTUS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_ARCHAEFRUCTUS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_OSMUNDACAULIS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_OTOZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.OTOZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.BISONIA.get(), 60, 100);
		registerFlammable(PFBlocks.LAUROZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.MOSS_CARPET.get(), 60, 20);
		registerFlammable(PFBlocks.HUMULUS.get(), 60, 20);
		registerFlammable(PFBlocks.MOSS_BLOCK.get(), 60, 20);
	}

	public static void registerFlammable(Block block, int flameOdds, int burnOdds) {
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFlammable(block, flameOdds, burnOdds);
	}
	
//	@SubscribeEvent
//	public static void limnicEruptionEvent(WorldTickEvent event) {
//		Level world = event.world;
//		world.getBiomeManager().getBiome(world.block)
//	}

}
