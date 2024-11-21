package superlord.prehistoricfauna.init;

import java.util.List;

import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFProfessions {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, PrehistoricFauna.MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, PrehistoricFauna.MOD_ID);
    
    public static final RegistryObject<PoiType> GEOLOGIST_POI = POI_TYPES.register("geologist_poi", () -> new PoiType(ImmutableSet.copyOf(PFBlocks.PALEONTOLOGY_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1));
    
    public static final RegistryObject<VillagerProfession> GEOLOGIST = PROFESSIONS.register("geologist", () -> new VillagerProfession("geologist", holder -> holder.get() == GEOLOGIST_POI.get(), holder -> holder.get() == GEOLOGIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));
    
    public static void addGeologistTrades(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades) {
    	 final float emeraldForItemsMultiplier = 0.05F; 
         final float itemForEmeraldMultiplier = 0.05F;
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.STONE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.ANDESITE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.GRANITE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.DIORITE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.SANDSTONE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.RED_SANDSTONE, 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(PFItems.SANDSTONE.get(), 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(PFItems.SILTSTONE.get(), 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(PFItems.CHALK.get(), 24), new ItemStack(Items.EMERALD, 1), 25, 2, itemForEmeraldMultiplier));
         trades.get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFItems.GEOLOGY_HAMMER.get(), 1), 10, 2, emeraldForItemsMultiplier));

         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.STONE, 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.ANDESITE, 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.GRANITE, 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.DIORITE, 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.SANDSTONE, 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.RED_SANDSTONE, 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFItems.SANDSTONE.get(), 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFItems.SILTSTONE.get(), 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(PFItems.CHALK.get(), 1), 16, 2, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.SANDSTONE_FOSSIL.get(), 1), 16, 5, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.SILTSTONE_FOSSIL.get(), 1), 16, 5, emeraldForItemsMultiplier));
         trades.get(2).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.CHALK_FOSSIL.get(), 1), 16, 5, emeraldForItemsMultiplier));

         trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(PFItems.PETRIFIED_WOOD.get(), 1), 16, 5, emeraldForItemsMultiplier));
         trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFItems.SMALL_AMMONITE_FOSSIL.get(), 1), 16, 5, emeraldForItemsMultiplier));
         trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFItems.MEDIUM_AMMONITE_FOSSIL.get(), 1), 16, 5, emeraldForItemsMultiplier));
         trades.get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFItems.LARGE_AMMONITE_FOSSIL.get(), 1), 16, 5, emeraldForItemsMultiplier));

         trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(PFItems.FOSSILIZED_BONES.get(), 1), 12, 6, emeraldForItemsMultiplier));
         trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.GIANT_AMMONITE_FOSSIL_PIECE_BB.get(), 1), 12, 6, emeraldForItemsMultiplier));
         trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.GIANT_AMMONITE_FOSSIL_PIECE_BF.get(), 1), 12, 6, emeraldForItemsMultiplier));
         trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.GIANT_AMMONITE_FOSSIL_PIECE_TB.get(), 1), 12, 6, emeraldForItemsMultiplier));
         trades.get(4).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.GIANT_AMMONITE_FOSSIL_PIECE_TF.get(), 1), 12, 6, emeraldForItemsMultiplier));

         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 6), new ItemStack(PFItems.HENOSTONE.get(), 1), 4, 8, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.TRICERATOPS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.ANKYLOSAURUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.STEGOSAURUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.CERATOSAURUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.HERRERASAURUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.ISCHIGUALASTIA_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.DESMATOSUCHUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.COELOPHYSIS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.SCELIDOSAURUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.SARAHSAURUS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.PLESIOHADROS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(PFItems.PROTOCERATOPS_SKULL.get(), 1), 8, 7, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.TYRANNOSAURUS_SKULL.get(), 1), 4, 8, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.ALLOSAURUS_SKULL.get(), 1), 4, 8, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.SAUROSUCHUS_SKULL.get(), 1), 4, 8, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.VELOCIRAPTOR_SKULL.get(), 1), 4, 8, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.DILOPHOSAURUS_SKULL.get(), 1), 4, 8, emeraldForItemsMultiplier));
         trades.get(5).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(PFItems.POSTOSUCHUS_SKULL.get(), 1), 4, 8, emeraldForItemsMultiplier));
    }

}
