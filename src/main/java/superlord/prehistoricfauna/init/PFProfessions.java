package superlord.prehistoricfauna.init;

import java.util.List;

import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import net.minecraft.item.Items;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFProfessions {
	
	public static PointOfInterestType PALEONTOLOGY_TABLE_POI;
	public static VillagerProfession GEOLOGIST;
	
	@SubscribeEvent
	public static void registerPointOfInterests(final RegistryEvent.Register<PointOfInterestType> event) {
		event.getRegistry().register(PALEONTOLOGY_TABLE_POI = new PointOfInterestType("geologist", ImmutableSet.copyOf(PFBlocks.PALEONTOLOGY_TABLE.getStateContainer().getValidStates()), 1, 1).setRegistryName("prehistoricfauna:geologist"));
		PointOfInterestType.registerBlockStates(PALEONTOLOGY_TABLE_POI);
	}
	
	@SubscribeEvent
	public static void registerVillagerProfessions(final RegistryEvent.Register<VillagerProfession> event) {
		event.getRegistry().register(GEOLOGIST = new VillagerProfession("geologist", PALEONTOLOGY_TABLE_POI, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_MASON).setRegistryName("prehistoricfauna:geologist"));
	}
	
	public static void addGeologistTrades(Int2ObjectMap<List<VillagerTrades.ITrade>> trades) {
		final float emeraldForItemsMultiplier = 0.05F;
		final float itemForEmeraldsMultiplier = 0.05F;
		final float rareItemForEmeraldsMultiplier = 0.2F;
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.STONE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.ANDESITE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.GRANITE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.DIORITE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.SANDSTONE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.RED_SANDSTONE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(PFBlocks.SANDSTONE.asItem(), 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(PFBlocks.SILTSTONE.asItem(), 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(PFBlocks.CHALK.asItem(), 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldsMultiplier));
		trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.GEOLOGY_HAMMER.get()), 10, 2, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.STONE), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.ANDESITE), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.GRANITE), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.DIORITE), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.SANDSTONE), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.RED_SANDSTONE), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFBlocks.SANDSTONE.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFBlocks.SILTSTONE.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFBlocks.CHALK.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.CRETACEOUS_FOSSIL.get()), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.JURASSIC_FOSSIL.get()), 16, 5, emeraldForItemsMultiplier));
		trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.TRIASSIC_FOSSIL.get()), 16, 5, emeraldForItemsMultiplier));
		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFBlocks.PETRIFIED_WOOD.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFBlocks.SMALL_AMMONITE_FOSSIL.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFBlocks.MEDIUM_AMMONITE_FOSSIL.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFBlocks.LARGE_AMMONITE_FOSSIL.asItem()), 16, 5, emeraldForItemsMultiplier));
		trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFBlocks.GIANT_AMMONITE_SHELL_BB.asItem()), 12, 6, rareItemForEmeraldsMultiplier));
		trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFBlocks.GIANT_AMMONITE_SHELL_BF.asItem()), 12, 6, rareItemForEmeraldsMultiplier));
		trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFBlocks.GIANT_AMMONITE_SHELL_TB.asItem()), 12, 6, rareItemForEmeraldsMultiplier));
		trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFBlocks.GIANT_AMMONITE_SHELL_TF.asItem()), 12, 6, rareItemForEmeraldsMultiplier));
		trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFItems.FOSSILIZED_BONES.get()), 12, 6, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 6), new ItemStack(PFBlocks.HENOSTONE.asItem()), 4, 8, rareItemForEmeraldsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.TRICERATOPS_SKULL.get()), 8, 7, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.ANKYLOSAURUS_SKULL.get()), 8, 7, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.STEGOSAURUS_SKULL.get()), 8, 7, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.CERATOSAURUS_SKULL.get()), 8, 7, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.HERRERASAURUS_SKULL.get()), 8, 7, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.ISCHIGUALASTIA_SKULL.get()), 8, 7, emeraldForItemsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.TYRANNOSAURUS_SKULL.get()), 4, 8, rareItemForEmeraldsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.ALLOSAURUS_SKULL.get()), 4, 8, rareItemForEmeraldsMultiplier));
		trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.SAUROSUCHUS_SKULL.get()), 4, 8, rareItemForEmeraldsMultiplier));
	}
}