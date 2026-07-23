package superlord.prehistoricfauna.common;

import com.google.common.collect.ImmutableMap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.compat.HollowLogBlock;
import superlord.prehistoricfauna.common.entity.goal.ZombieDestroyDinosaurEggGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {	
	
	@SubscribeEvent
	public static void init(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			compostibleBlocks();
			AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
					.put(PFBlocks.AGATHOXYLON_LOG.get(), PFBlocks.STRIPPED_AGATHOXYLON_LOG.get())
					.put(PFBlocks.AGATHOXYLON_WOOD.get(), PFBlocks.STRIPPED_AGATHOXYLON_WOOD.get())
					.put(PFBlocks.METASEQUOIA_LOG.get(), PFBlocks.STRIPPED_METASEQUOIA_LOG.get())
					.put(PFBlocks.METASEQUOIA_WOOD.get(), PFBlocks.STRIPPED_METASEQUOIA_WOOD.get())
					.put(PFBlocks.ARAUCARIA_LOG.get(), PFBlocks.STRIPPED_ARAUCARIA_LOG.get())
					.put(PFBlocks.ARAUCARIA_WOOD.get(), PFBlocks.STRIPPED_ARAUCARIA_WOOD.get())
					.put(PFBlocks.PROTOPICEOXYLON_LOG.get(), PFBlocks.STRIPPED_PROTOPICEOXYLON_LOG.get())
					.put(PFBlocks.PROTOPICEOXYLON_WOOD.get(), PFBlocks.STRIPPED_PROTOPICEOXYLON_WOOD.get())
					.put(PFBlocks.MONANTHESIA_LOG.get(), PFBlocks.STRIPPED_MONANTHESIA_LOG.get())
					.put(PFBlocks.MONANTHESIA_WOOD.get(), PFBlocks.STRIPPED_MONANTHESIA_WOOD.get())
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
					.put(PFBlocks.TAXUS_WOOD.get(), PFBlocks.STRIPPED_TAXUS_WOOD.get())
					.put(PFBlocks.CZEKANOWSKIA_LOG.get(), PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get())
					.put(PFBlocks.CZEKANOWSKIA_WOOD.get(), PFBlocks.STRIPPED_CZEKANOWSKIA_WOOD.get())
					.put(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get(), PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get())
					.put(PFBlocks.SCHIZOLEPIDOPSIS_WOOD.get(), PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_WOOD.get())
					.put(PFBlocks.PODOZAMITES_LOG.get(), PFBlocks.STRIPPED_PODOZAMITES_LOG.get())
					.put(PFBlocks.PODOZAMITES_WOOD.get(), PFBlocks.STRIPPED_PODOZAMITES_WOOD.get())
					.put(PFBlocks.GINKGO_LOG.get(), PFBlocks.STRIPPED_GINKGO_LOG.get())
					.put(PFBlocks.GINKGO_WOOD.get(), PFBlocks.STRIPPED_GINKGO_WOOD.get())
					.put(PFBlocks.TROCHODENDROIDES_LOG.get(), PFBlocks.STRIPPED_TROCHODENDROIDES_LOG.get())
					.put(PFBlocks.TROCHODENDROIDES_WOOD.get(), PFBlocks.STRIPPED_TROCHODENDROIDES_WOOD.get())
					.put(PFBlocks.BRACHYPHYLLUM_LOG.get(), PFBlocks.STRIPPED_BRACHYPHYLLUM_LOG.get())
					.put(PFBlocks.BRACHYPHYLLUM_WOOD.get(), PFBlocks.STRIPPED_BRACHYPHYLLUM_WOOD.get())
					.put(PFBlocks.WOODWORTHIA_LOG.get(), PFBlocks.STRIPPED_WOODWORTHIA_LOG.get())
					.put(PFBlocks.WOODWORTHIA_WOOD.get(), PFBlocks.STRIPPED_WOODWORTHIA_WOOD.get())
					.put(PFBlocks.SCHILDERIA_LOG.get(), PFBlocks.STRIPPED_SCHILDERIA_LOG.get())
					.put(PFBlocks.SCHILDERIA_WOOD.get(), PFBlocks.STRIPPED_SCHILDERIA_WOOD.get())
					.put(PFBlocks.CUPRESSINOCLADUS_LOG.get(), PFBlocks.STRIPPED_CUPRESSINOCLADUS_LOG.get())
					.put(PFBlocks.CUPRESSINOCLADUS_WOOD.get(), PFBlocks.STRIPPED_CUPRESSINOCLADUS_WOOD.get())
					.put(PFBlocks.ELATIDES_LOG.get(), PFBlocks.STRIPPED_ELATIDES_LOG.get())
					.put(PFBlocks.ELATIDES_WOOD.get(), PFBlocks.STRIPPED_ELATIDES_WOOD.get())
					.put(PFBlocks.PHOENICOPSIS_LOG.get(), PFBlocks.STRIPPED_PHOENICOPSIS_LOG.get())
					.put(PFBlocks.PHOENICOPSIS_WOOD.get(), PFBlocks.STRIPPED_PHOENICOPSIS_WOOD.get())
					.put(PFBlocks.FRENELOPSIS_LOG.get(), PFBlocks.STRIPPED_FRENELOPSIS_LOG.get())
					.put(PFBlocks.FRENELOPSIS_WOOD.get(), PFBlocks.STRIPPED_FRENELOPSIS_WOOD.get())
					.put(PFBlocks.BAIERA_LOG.get(), PFBlocks.STRIPPED_BAIERA_LOG.get()).build();
			registerFlammables();
		});
	}

	private static void compostibleBlocks() {
		compostibleBlocks(0.3F, PFBlocks.AGATHOXYLON_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.METASEQUOIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.ARAUCARIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOPICEOXYLON_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.MONANTHESIA_LEAVES.get());
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
		compostibleBlocks(0.3F, PFBlocks.CZEKANOWSKIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.TROCHODENDROIDES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.BRACHYPHYLLUM_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.WOODWORTHIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.SCHILDERIA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.MONANTHESIA_FROND.get());
		compostibleBlocks(0.3F, PFBlocks.BRACHYPHYLLUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.WOODWORTHIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.SCHILDERIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PODOZAMITES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.AGATHOXYLON_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.METASEQUOIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.ARAUCARIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOPICEOXYLON_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.MONANTHESIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PROTOJUNIPEROXYLON_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.LIRIODENDRITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.HEIDIPHYLLUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.DRYOPHYLLUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.TAXODIUM_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.GINKGO_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.SABALITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PLATANITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.TAXUS_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.CZEKANOWSKIA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.SCHIZOLEPIDOPSIS_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PODOZAMITES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.TROCHODENDROIDES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.CUPRESSINOCLADUS_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.CUPRESSINOCLADUS_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.ELATIDES_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.ELATIDES_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.PHOENICOPSIS_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.PHOENICOPSIS_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.FRENELOPSIS_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.FRENELOPSIS_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.BAIERA_LEAVES.get());
		compostibleBlocks(0.3F, PFBlocks.BAIERA_SAPLING.get());
		compostibleBlocks(0.3F, PFBlocks.HORSETAIL.get());
		compostibleBlocks(0.3F, PFItems.TUBER.get());
		compostibleBlocks(0.3F, PFItems.GINKGO_BERRY.get());
		compostibleBlocks(0.3F, PFItems.TAXUS_BERRIES.get());
		compostibleBlocks(0.3F, PFItems.EPHEDRA_BERRIES.get());
		compostibleBlocks(0.3F, PFItems.PLANT_FIBER.get());
		compostibleBlocks(0.3F, PFBlocks.OSMUNDA.get());
		compostibleBlocks(0.3F, PFBlocks.BISONIA.get());
		compostibleBlocks(0.3F, PFBlocks.OSMUNDA.get());
		compostibleBlocks(0.3F, PFBlocks.COBBANIA.get());
		compostibleBlocks(0.3F, PFBlocks.CLADOPHLEBIS.get());
		compostibleBlocks(0.3F, PFBlocks.MICHELILLOA.get());
		compostibleBlocks(0.3F, PFBlocks.ALGAE_CARPET.get());
		compostibleBlocks(0.3F, PFBlocks.MOSS_CARPET.get());
		compostibleBlocks(0.3F, PFBlocks.CONIOPTERIS.get());
		compostibleBlocks(0.3F, PFBlocks.OSMUNDACAULIS.get());
		compostibleBlocks(0.3F, PFBlocks.PHLEBOPTERIS.get());
		compostibleBlocks(0.3F, PFBlocks.CLATHROPTERIS.get());
		compostibleBlocks(0.3F, PFItems.MOSS_BALL.get());
		compostibleBlocks(0.3F, PFItems.PTILOPHYLLUM_FRONDS.get());
		compostibleBlocks(0.3F, PFBlocks.LAUROZAMITES.get());
		compostibleBlocks(0.3F, PFBlocks.OTOZAMITES.get());
		compostibleBlocks(0.3F, PFBlocks.ARCHAEFRUCTUS.get());
		compostibleBlocks(0.3F, PFBlocks.LEEFRUCTUS.get());
		compostibleBlocks(0.3F, PFBlocks.RUFFORDIA.get());
		compostibleBlocks(0.3F, PFBlocks.EPHEDRA.get());
		compostibleBlocks(0.3F, PFBlocks.HUMULUS.get());
		compostibleBlocks(0.3F, PFBlocks.AZOLLA.get());
		compostibleBlocks(0.3F, PFItems.NELUMBO.get());
		compostibleBlocks(0.3F, PFBlocks.ARCHAEFRUCTUS.get());
		compostibleBlocks(0.3F, PFBlocks.CALLIANTHUS.get());
		compostibleBlocks(0.3F, PFBlocks.PTEROPHYLLUM.get());
		compostibleBlocks(0.3F, PFBlocks.ANOMOZAMITES.get());
		compostibleBlocks(0.3F, PFItems.QUEREUXIA.get());
		compostibleBlocks(0.3F, PFItems.NEOCALAMITES.get());
		compostibleBlocks(0.3F, PFBlocks.STONEWORTS.get());
		compostibleBlocks(0.3F, PFBlocks.SMALL_TUBER_BLOCK.get());
		compostibleBlocks(0.3F, PFBlocks.SMALL_CARVED_TUBER.get());
		compostibleBlocks(0.5F, PFBlocks.TUBER_BLOCK.get());
		compostibleBlocks(0.5F, PFBlocks.CARVED_TUBER.get());
		compostibleBlocks(0.3F, PFBlocks.TAENIOPTERIS.get());
		compostibleBlocks(0.3F, PFBlocks.ONYCHIOPSIS.get());
		compostibleBlocks(0.3F, PFBlocks.SPHENOPTERIS.get());
		compostibleBlocks(0.3F, PFBlocks.ZAMIOPHYLLUM.get());
		compostibleBlocks(0.3F, PFBlocks.NILSSONIA.get());
		compostibleBlocks(0.3F, PFItems.FIDDLEHEAD_SPORES.get());
		compostibleBlocks(0.3F, PFItems.FIDDLEHEAD.get());
		compostibleBlocks(0.3F, PFBlocks.FIDDLEHEAD_FERN.get());
		compostibleBlocks(0.3F, PFItems.MARMARTHIA_BERRIES.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_HORSETAIL.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_ARCHAEFRUCTUS.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_TAENIOPTERIS.get());
		compostibleBlocks(0.5F, PFBlocks.ZINGIBEROPSIS.get());
		compostibleBlocks(0.5F, PFBlocks.PURPLE_ZINGIBEROPSIS.get());
		compostibleBlocks(0.5F, PFBlocks.NOTHODICHOCARPUM.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_OSMUNDA.get());
		compostibleBlocks(0.5F, PFBlocks.SCYTOPHYLLUM.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_ARCHAEFRUCTUS.get());
		compostibleBlocks(0.5F, PFBlocks.MOSS_BLOCK.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_OSMUNDACAULIS.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_OTOZAMITES.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_ANOMOZAMITES.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_PTEROPHYLLUM.get());
		compostibleBlocks(0.5F, PFBlocks.TALL_FIDDLEHEAD_FERN.get());
		compostibleBlocks(0.5F, PFBlocks.ZAMITES.get());
		compostibleBlocks(0.65F, PFBlocks.JOHNSTONIA.get());
		compostibleBlocks(0.65F, PFBlocks.CLUBMOSS.get());
		compostibleBlocks(0.65F, PFBlocks.LIVERWORT.get());
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
		registerFlammable(PFBlocks.MONANTHESIA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.MONANTHESIA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.MONANTHESIA_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.MONANTHESIA_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.MONANTHESIA_STAIRS.get(), 5, 20);
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
		registerFlammable(PFBlocks.CZEKANOWSKIA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.CZEKANOWSKIA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.CZEKANOWSKIA_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.CZEKANOWSKIA_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.CZEKANOWSKIA_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.PODOZAMITES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.PODOZAMITES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.PODOZAMITES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.PODOZAMITES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.ELATIDES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.ELATIDES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.ELATIDES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.ELATIDES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.ELATIDES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.PHOENICOPSIS_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.PHOENICOPSIS_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.PHOENICOPSIS_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.PHOENICOPSIS_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.PHOENICOPSIS_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.FRENELOPSIS_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.FRENELOPSIS_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.FRENELOPSIS_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.FRENELOPSIS_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.FRENELOPSIS_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.BAIERA_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.BAIERA_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.BAIERA_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.BAIERA_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.BAIERA_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_FENCE.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_FENCE_GATE.get(), 5, 20);
		registerFlammable(PFBlocks.PODOZAMITES_STAIRS.get(), 5, 20);
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
		registerFlammable(PFBlocks.NEOCALAMITES_PLANKS.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_SLAB.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_MOSAIC.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_MOSAIC_STAIRS.get(), 5, 20);
		registerFlammable(PFBlocks.NEOCALAMITES_MOSAIC_SLAB.get(), 5, 20);
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
		registerFlammable(PFBlocks.MONANTHESIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_MONANTHESIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.MONANTHESIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_MONANTHESIA_WOOD.get(), 5, 5);
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
		registerFlammable(PFBlocks.CZEKANOWSKIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.CZEKANOWSKIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_CZEKANOWSKIA_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.PODOZAMITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.PODOZAMITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PODOZAMITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PODOZAMITES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_CUPRESSINOCLADUS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_CUPRESSINOCLADUS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.ELATIDES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.ELATIDES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ELATIDES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ELATIDES_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.PHOENICOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.PHOENICOPSIS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PHOENICOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PHOENICOPSIS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.FRENELOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.FRENELOPSIS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_FRENELOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_FRENELOPSIS_WOOD.get(), 5, 5);
		registerFlammable(PFBlocks.BAIERA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.STRIPPED_BAIERA_LOG.get(), 5, 5);
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
		registerFlammable(PFBlocks.MONANTHESIA_LEAVES.get(), 30, 60);
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
		registerFlammable(PFBlocks.CZEKANOWSKIA_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.PODOZAMITES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.CUPRESSINOCLADUS_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.ELATIDES_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.PHOENICOPSIS_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.FRENELOPSIS_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.BAIERA_LEAVES.get(), 30, 60);
		registerFlammable(PFBlocks.CLUBMOSS.get(), 60, 100);
		registerFlammable(PFBlocks.HORSETAIL.get(), 60, 100);
		registerFlammable(PFBlocks.OSMUNDA.get(), 60, 100);
		registerFlammable(PFBlocks.OSMUNDACAULIS.get(), 60, 100);
		registerFlammable(PFBlocks.DEAD_OSMUNDACAULIS.get(), 60, 100);
		registerFlammable(PFBlocks.LIVERWORT.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_HORSETAIL.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_OSMUNDA.get(), 60, 100);
		registerFlammable(PFBlocks.CONIOPTERIS.get(), 60, 100);
		registerFlammable(PFBlocks.LEEFRUCTUS.get(), 60, 100);
		registerFlammable(PFBlocks.EPHEDRA.get(), 60, 100);
		registerFlammable(PFBlocks.RUFFORDIA.get(), 60, 100);
		registerFlammable(PFBlocks.ANOMOZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.PTEROPHYLLUM.get(), 60, 100);
		registerFlammable(PFBlocks.SPHENOPTERIS.get(), 60, 100);
		registerFlammable(PFBlocks.TAENIOPTERIS.get(), 60, 100);
		registerFlammable(PFBlocks.ONYCHIOPSIS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_TAENIOPTERIS.get(), 60, 100);
		registerFlammable(PFBlocks.ARCHAEFRUCTUS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_ARCHAEFRUCTUS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_OSMUNDACAULIS.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_OTOZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.ZINGIBEROPSIS.get(), 60, 100);
		registerFlammable(PFBlocks.PURPLE_ZINGIBEROPSIS.get(), 60, 100);
		registerFlammable(PFBlocks.NOTHODICHOCARPUM.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_ANOMOZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_PTEROPHYLLUM.get(), 60, 100);
		registerFlammable(PFBlocks.NILSSONIA.get(), 60, 100);
		registerFlammable(PFBlocks.OTOZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.BISONIA.get(), 60, 100);
		registerFlammable(PFBlocks.LAUROZAMITES.get(), 60, 100);
		registerFlammable(PFBlocks.FIDDLEHEAD_FERN.get(), 60, 100);
		registerFlammable(PFBlocks.TALL_FIDDLEHEAD_FERN.get(), 60, 100);
		registerFlammable(PFBlocks.MOSS_CARPET.get(), 60, 20);
		registerFlammable(PFBlocks.HUMULUS.get(), 60, 20);
		registerFlammable(PFBlocks.MOSS_BLOCK.get(), 60, 20);
		registerFlammable(PFBlocks.WELTRICHIA.get(), 60, 20);
		registerFlammable(PFBlocks.ZAMIOPHYLLUM.get(), 5, 5);
		registerFlammable(PFBlocks.ZAMITES.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_AGATHOXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_ARAUCARIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_BRACHYPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_CUPRESSINOCLADUS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_CZEKANOWSKIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_DRYOPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_ELATIDES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_FRENELOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_GINKGO_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_HEIDIPHYLLUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_LIRIODENDRITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_METASEQUOIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_MONANTHESIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_PHOENICOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_PLATANITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_PODOZAMITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_PROTOJUNIPEROXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_PROTOPICEOXYLON_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_SABALITES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_SCHILDERIA_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_SCHIZOLEPIDOPSIS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_TAXODIUM_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_TAXUS_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_TROCHODENDROIDES_LOG.get(), 5, 5);
		registerFlammable(PFBlocks.HOLLOW_WOODWORTHIA_LOG.get(), 5, 5);
	}
	
	private static final String TAG_TRYING_TO_CRAWL = "quark:trying_crawl";

	
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		Player player = event.player;
		BlockPos playerPos = player.blockPosition();
		boolean isTrying = player.isVisuallyCrawling() ||
				(player.isCrouching() && !player.isColliding(playerPos, player.level().getBlockState(playerPos)));
		boolean wasTrying = player.getPersistentData().getBoolean(TAG_TRYING_TO_CRAWL);

		if(!player.isVisuallyCrawling()) {
			if(isTrying && !wasTrying) {
				Direction dir = player.getDirection();
				Direction opp = dir.getOpposite();
				if(dir.getAxis() != Axis.Y) {
					BlockPos pos = playerPos.relative(dir);

					if(!tryClimb(player, opp, playerPos)) // Crawl out
						if(!tryClimb(player, opp, playerPos.above())) // Crawl out
							if(!tryClimb(player, dir, pos)) // Crawl into
								tryClimb(player, dir, pos.above()); // Crawl into
				}
			}
		}

		if(isTrying != wasTrying)
			player.getPersistentData().putBoolean(TAG_TRYING_TO_CRAWL, isTrying);
	}

	private boolean tryClimb(Player player, Direction dir, BlockPos pos) {
		BlockState state = player.level().getBlockState(pos);
		Block block = state.getBlock();

		if(block instanceof HollowLogBlock crawlSpace) {
			if(crawlSpace.canCrawl(player.level(), state, pos, dir)) {
				player.setPose(Pose.SWIMMING);
				player.setSwimming(true);

				double x = pos.getX() + 0.5 - (dir.getStepX() * 0.3);
				double y = pos.getY() + 0.13F;
				double z = pos.getZ() + 0.5 - (dir.getStepZ() * 0.3);

				player.setPos(x, y, z);

				return true;
			}
		}

		return false;
	}

	public static void registerFlammable(Block block, int flameOdds, int burnOdds) {
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFlammable(block, flameOdds, burnOdds);
	}

	@SubscribeEvent
	public void onEntityJoinWorld(MobSpawnEvent.FinalizeSpawn  event) {
		try {
			if (event.getEntity() instanceof Zombie) {
				Zombie zombie = (Zombie) event.getEntity();
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.AEPYORNITHOMIMUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BYRONOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CITIPATI_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.GOYOCEPHALE_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.HALSZKARAPTOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.KOL_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.OVIRAPTOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PINACOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PLESIOHADROS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PROTOCERATOPS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TELMASAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.UDANOCERATOPS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.VELOCIRAPTOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ANKYLOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ANZU_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BASILEMYS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BRACHYCHAMPSA_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DAKOTARAPTOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.EDMONTOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ORNITHOMIMUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PACHYCEPHALOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PALAEOSANIWA_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.THESCELOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TRICERATOPS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TYRANNOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BEIPIAOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CHANGYURAPTOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DILONG_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DONGBEITITAN_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.INCISIVOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.JINZHOUSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.LIAONINGOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PSITTACOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.RUIXINIA_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SINOSAUROPTERYX_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.YUTYRANNUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ZHENYUANLONG_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CALSOYASUCHUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DILOPHOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.KAYENTACHELYS_EGG.get(), zombie, 1.0D, 3));
//				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.KAYENTASUCHUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.KAYENTATHERIUM_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.KAYENTAVENATOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.MEGAPNOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SARAHSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SCELIDOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SCUTELLOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ALCOVASAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ALLOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BRACHIOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BRONTOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CAMARASAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CAMPTOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CERATOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DIABLOPHIS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DIPLODOCUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DRYOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.EILENODON_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.GARGOYLEOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.HESPERORNITHOIDES_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.MACELOGNATHUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SUUWASSEA_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.STEGOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TANYCOLAGREUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TORVOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ABROSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.AGILISAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.BASHANOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CHUANDONGOCOELURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.GIGANTSPINOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.HUAYANGOSAURUS_EGG.get(), zombie, 1.0D, 3));
//				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.MAMENCHISAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.OMEISAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.POLISTODON_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SINRAPTOR_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SHUNOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TUOJIANGOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.YANDUSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.YANGCHUANOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.COELOPHYSIS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.DESMATOSUCHUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.PLACERIAS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.POPOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.POSTOSUCHUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TRILOPHOSAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.TYPOTHORAX_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.CHROMOGISAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.EXAERETODON_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.HERRERASAURUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.HYPERODAPEDON_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.ISCHIGUALASTIA_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SAUROSUCHUS_EGG.get(), zombie, 1.0D, 3));
				zombie.goalSelector.addGoal(4,  new ZombieDestroyDinosaurEggGoal(PFBlocks.SILLOSUCHUS_EGG.get(), zombie, 1.0D, 3));

			}
		} catch (Exception e) {
			PrehistoricFauna.LOGGER.warn("Could not allow Zombies to smash dinosaur eggs!");
		}
	}
	

	//	@SubscribeEvent
	//	public static void limnicEruptionEvent(WorldTickEvent event) {
	//		Level world = event.world;
	//		world.getBiomeManager().getBiome(world.block)
	//	}

}
