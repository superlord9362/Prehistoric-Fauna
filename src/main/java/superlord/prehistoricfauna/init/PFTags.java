package superlord.prehistoricfauna.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFTags {

	public static final TagKey<Item> FOSSILS = registerItemTag("fossils");
	public static final TagKey<Block> HENOSTONE = registerBlockTag("henostone");
	public static final TagKey<Item> HENOSTONE_ITEM = registerItemTag("henostone");
	public static final TagKey<Block> PLANTS_2_HUNGER = registerBlockTag("two_hunger_plants");
	public static final TagKey<Block> PLANTS_4_HUNGER = registerBlockTag("four_hunger_plants");
	public static final TagKey<Block> PLANTS_6_HUNGER = registerBlockTag("six_hunger_plants");
	public static final TagKey<Block> PLANTS_8_HUNGER = registerBlockTag("eight_hunger_plants");
	public static final TagKey<Block> PLANTS_10_HUNGER = registerBlockTag("ten_hunger_plants");
	public static final TagKey<Block> PLANTS_12_HUNGER = registerBlockTag("twelve_hunger_plants");
	public static final TagKey<Block> PLANTS_15_HUNGER = registerBlockTag("fifteen_hunger_plants");
	public static final TagKey<Block> PLANTS_20_HUNGER = registerBlockTag("twenty_hunger_plants");
	public static final TagKey<Block> PLANTS_25_HUNGER = registerBlockTag("twenty_five_hunger_plants");
	public static final TagKey<Block> PLANTS_30_HUNGER = registerBlockTag("thirty_hunger_plants");
	public static final TagKey<Block> HARDENED_SILT_NESTS = registerBlockTag("hardened_silt_nests");
	public static final TagKey<Block> NESTS = registerBlockTag("nests");
	public static final TagKey<Block> SOFT_SHELL_EGG_BLOCKS = registerBlockTag("soft_shell_eggs");
	public static final TagKey<Block> BURROW_BLOCKS = registerBlockTag("burrows");
	public static final TagKey<Block> SOIL = registerBlockTag("soils");
	public static final TagKey<Item> PLANTS_2_HUNGER_ITEM = registerItemTag("two_hunger_plants");
	public static final TagKey<Item> INSECTS_2_HUNGER_ITEM = registerItemTag("two_hunger_insects");
	public static final TagKey<Item> PLANTS_4_HUNGER_ITEM = registerItemTag("four_hunger_plants");
	public static final TagKey<Item> PLANTS_6_HUNGER_ITEM = registerItemTag("six_hunger_plants");
	public static final TagKey<Item> PLANTS_8_HUNGER_ITEM = registerItemTag("eight_hunger_plants");
	public static final TagKey<Item> PLANTS_10_HUNGER_ITEM = registerItemTag("ten_hunger_plants");
	public static final TagKey<Item> PLANTS_12_HUNGER_ITEM = registerItemTag("twelve_hunger_plants");
	public static final TagKey<Item> PLANTS_15_HUNGER_ITEM = registerItemTag("fifteen_hunger_plants");
	public static final TagKey<Item> PLANTS_20_HUNGER_ITEM = registerItemTag("twenty_hunger_plants");
	public static final TagKey<Item> PLANTS_25_HUNGER_ITEM = registerItemTag("twenty_five_hunger_plants");
	public static final TagKey<Item> PLANTS_30_HUNGER_ITEM = registerItemTag("thirty_hunger_plants");
	public static final TagKey<Item> SOFT_SHELL_EGGS = registerItemTag("soft_shell_eggs");
	public static final TagKey<EntityType<?>> FISH_3_HUNGER = registerEntityTag("three_hunger_fish");
	public static final TagKey<EntityType<?>> ANIMALS_3_HUNGER = registerEntityTag("three_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_4_HUNGER = registerEntityTag("four_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_6_HUNGER = registerEntityTag("six_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_8_HUNGER = registerEntityTag("eight_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_10_HUNGER = registerEntityTag("ten_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_15_HUNGER = registerEntityTag("fifteen_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_20_HUNGER = registerEntityTag("twenty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_30_HUNGER = registerEntityTag("thirty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_40_HUNGER = registerEntityTag("forty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_60_HUNGER = registerEntityTag("sixy_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_80_HUNGER = registerEntityTag("eighty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_100_HUNGER = registerEntityTag("one_hundred_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_200_HUNGER = registerEntityTag("two_hundreed_hunger_animals");
	public static final TagKey<EntityType<?>> INSECTS_2_HUNGER = registerEntityTag("two_hunger_insects");

	public static final TagKey<EntityType<?>> CITIPATI_HUNTING = registerEntityTag("citipati_hunting");
	public static final TagKey<EntityType<?>> CITIPATI_BABY_HUNTING = registerEntityTag("citipati_baby_hunting");
	public static final TagKey<EntityType<?>> TELMASAURUS_HUNTING = registerEntityTag("telmasaurus_hunting");
	public static final TagKey<EntityType<?>> TELMASAURUS_BABY_HUNTING = registerEntityTag("telmasaurus_baby_hunting");
	public static final TagKey<EntityType<?>> VELOCIRAPTOR_HUNTING = registerEntityTag("velociraptor_hunting");
	public static final TagKey<EntityType<?>> VELOCIRAPTOR_BABY_HUNTING = registerEntityTag("velociraptor_baby_hunting");
	public static final TagKey<EntityType<?>> DAKOTARAPTOR_HUNTING = registerEntityTag("dakotaraptor_hunting");
	public static final TagKey<EntityType<?>> DAKOTARAPTOR_BABY_HUNTING = registerEntityTag("dakotaraptor_baby_hunting");
	public static final TagKey<EntityType<?>> DIDELPHODON_HUNTING = registerEntityTag("didelphodon_hunting");
	public static final TagKey<EntityType<?>> DIDELPHODON_BABY_HUNTING = registerEntityTag("didelphodon_baby_hunting");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_HUNTING = registerEntityTag("tyrannosaurus_hunting");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_JUVENILE_HUNTING = registerEntityTag("tyrannosaurus_juvenile_hunting");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_BABY_HUNTING = registerEntityTag("tyrannosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> CALSOYASUCHUS_HUNTING = registerEntityTag("calsoyasuchus_hunting");
	public static final TagKey<EntityType<?>> CALSOYASUCHUS_BABY_HUNTING = registerEntityTag("calsoyasuchus_baby_hunting");
	public static final TagKey<EntityType<?>> DILOPHOSAURUS_HUNTING = registerEntityTag("dilophosaurus_hunting");
	public static final TagKey<EntityType<?>> DILOPHOSAURUS_BABY_HUNTING = registerEntityTag("dilophosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> MEGAPNOSAURUS_HUNTING = registerEntityTag("megapnosaurus_hunting");
	public static final TagKey<EntityType<?>> MEGAPNOSAURUS_BABY_HUNTING = registerEntityTag("megapnosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> ALLOSAURUS_HUNTING = registerEntityTag("allosaurus_hunting");
	public static final TagKey<EntityType<?>> ALLOSAURUS_BABY_HUNTING = registerEntityTag("allosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> CERATOSAURUS_HUNTING = registerEntityTag("ceratosaurus_hunting");
	public static final TagKey<EntityType<?>> CERATOSAURUS_BABY_HUNTING = registerEntityTag("ceratosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> HESPERORNITHOIDES_HUNTING = registerEntityTag("hesperornithoides_hunting");
	public static final TagKey<EntityType<?>> HESPERORNITHOIDES_BABY_HUNTING = registerEntityTag("hesperornithoides_baby_hunting");
	public static final TagKey<EntityType<?>> COELOPHYSIS_HUNTING = registerEntityTag("coelophysis_hunting");
	public static final TagKey<EntityType<?>> COELOPHYSIS_BABY_HUNTING = registerEntityTag("coelophysis_baby_hunting");
	public static final TagKey<EntityType<?>> POPOSAURUS_HUNTING = registerEntityTag("poposaurus_hunting");
	public static final TagKey<EntityType<?>> POPOSAURUS_BABY_HUNTING = registerEntityTag("poposaurus_baby_hunting");
	public static final TagKey<EntityType<?>> POSTOSUCHUS_HUNTING = registerEntityTag("postosuchus_hunting");
	public static final TagKey<EntityType<?>> POSTOSUCHUS_BABY_HUNTING = registerEntityTag("postosuchus_baby_hunting");
	public static final TagKey<EntityType<?>> CHROMOGISAURUS_HUNTING = registerEntityTag("chromogisaurus_hunting");
	public static final TagKey<EntityType<?>> CHROMOGISAURUS_BABY_HUNTING = registerEntityTag("chromogisaurus_baby_hunting");
	public static final TagKey<EntityType<?>> HERRERASAURUS_HUNTING = registerEntityTag("herrerasaurus_hunting");
	public static final TagKey<EntityType<?>> HERRERASAURUS_BABY_HUNTING = registerEntityTag("herrerasaurus_baby_hunting");
	public static final TagKey<EntityType<?>> SAUROSUCHUS_HUNTING = registerEntityTag("saurosuchus_hunting");
	public static final TagKey<EntityType<?>> SAUROSUCHUS_BABY_HUNTING = registerEntityTag("saurosuchus_baby_hunting");
	public static final TagKey<EntityType<?>> THORACOSAURUS_HUNTING = registerEntityTag("thoracosaurus_hunting");
	public static final TagKey<EntityType<?>> THORACOSAURUS_BABY_HUNTING = registerEntityTag("thoracosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> PALAEOSANIWA_HUNTING = registerEntityTag("palaeosaniwa_hunting");
	public static final TagKey<EntityType<?>> PALAEOSANIWA_BABY_HUNTING = registerEntityTag("palaeosaniwa_baby_hunting");
	public static final TagKey<EntityType<?>> OVIRAPTOR_HUNTING = registerEntityTag("oviraptor_hunting");
	public static final TagKey<EntityType<?>> OVIRAPTOR_BABY_HUNTING = registerEntityTag("oviraptor_baby_hunting");
	public static final TagKey<EntityType<?>> HALSZKARAPTOR_HUNTING = registerEntityTag("halszkaraptor_hunting");
	public static final TagKey<EntityType<?>> HALSZKARAPTOR_BABY_HUNTING = registerEntityTag("halszkaraptor_baby_hunting");
	public static final TagKey<EntityType<?>> ORNITHOMIMUS_HUNTING = registerEntityTag("ornithomimus_hunting");
	public static final TagKey<EntityType<?>> ORNITHOMIMUS_BABY_HUNTING = registerEntityTag("ornithomimus_baby_hunting");
	public static final TagKey<EntityType<?>> KOL_HUNTING = registerEntityTag("kol_hunting");
	public static final TagKey<EntityType<?>> KOL_BABY_HUNTING = registerEntityTag("kol_baby_hunting");
	public static final TagKey<EntityType<?>> YUTYRANNUS_HUNTING = registerEntityTag("yutyrannus_hunting");
	public static final TagKey<EntityType<?>> YUTYRANNUS_BABY_HUNTING = registerEntityTag("yutyrannus_baby_hunting");
	public static final TagKey<EntityType<?>> SINOSAUROPTERYX_HUNTING = registerEntityTag("sinosauropteryx_hunting");
	public static final TagKey<EntityType<?>> SINOSAUROPTERYX_BABY_HUNTING = registerEntityTag("sinosauropteryx_baby_hunting");
	public static final TagKey<EntityType<?>> INCISIVOSAURUS_HUNTING = registerEntityTag("incisivosaurus_hunting");
	public static final TagKey<EntityType<?>> INCISIVOSAURUS_BABY_HUNTING = registerEntityTag("incisivosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> CRETARANEUS_HUNTING = registerEntityTag("cretaraneus_hunting");
	public static final TagKey<EntityType<?>> BEIPIAOSAURUS_HUNTING = registerEntityTag("beipiaosaurus_hunting");
	public static final TagKey<EntityType<?>> BEIPIAOSAURUS_BABY_HUNTING = registerEntityTag("beipiaosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> ANZU_HUNTING = registerEntityTag("anzu_hunting");
	public static final TagKey<EntityType<?>> ANZU_BABY_HUNTING = registerEntityTag("anzu_baby_hunting");
	public static final TagKey<EntityType<?>> CHANGYURAPTOR_HUNTING = registerEntityTag("changyuraptor_hunting");
	public static final TagKey<EntityType<?>> CHANGYURAPTOR_BABY_HUNTING = registerEntityTag("changyuraptor_baby_hunting");
	public static final TagKey<EntityType<?>> BYRONOSAURUS_HUNTING = registerEntityTag("byronosaurus_hunting");
	public static final TagKey<EntityType<?>> BYRONOSAURUS_BABY_HUNTING = registerEntityTag("byronosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> REPENOMAMUS_HUNTING = registerEntityTag("repenomamus_hunting");
	public static final TagKey<EntityType<?>> REPENOMAMUS_BABY_HUNTING = registerEntityTag("repenomamus_baby_hunting");
	public static final TagKey<EntityType<?>> DILONG_HUNTING = registerEntityTag("dilong_hunting");
	public static final TagKey<EntityType<?>> ZHENYUANLONG_HUNTING = registerEntityTag("zhenyuanlong_hunting");
	public static final TagKey<EntityType<?>> ZHENYUANLONG_BABY_HUNTING = registerEntityTag("zhenyuanlong_baby_hunting");
	public static final TagKey<EntityType<?>> BRACHYCHAMPSA_HUNTING = registerEntityTag("brachychampsa_hunting");
	public static final TagKey<EntityType<?>> BRACHYCHAMPSA_BABY_HUNTING = registerEntityTag("brachychampsa_baby_hunting");

	public static final TagKey<EntityType<?>> ANKYLOSAURUS_AVOIDING = registerEntityTag("ankylosaurus_avoiding");
	public static final TagKey<EntityType<?>> ANZU_AVOIDING = registerEntityTag("anzu_avoiding");
	public static final TagKey<EntityType<?>> BASILEMYS_AVOIDING = registerEntityTag("basilemys_avoiding");
	public static final TagKey<EntityType<?>> BRACHYCHAMPSA_AVOIDING = registerEntityTag("brachychampsa_avoiding");
	public static final TagKey<EntityType<?>> DAKOTARAPTOR_AVOIDING = registerEntityTag("dakotaraptor_avoiding");
	public static final TagKey<EntityType<?>> DIDELPHODON_AVOIDING = registerEntityTag("didelphodon_avoiding");
	public static final TagKey<EntityType<?>> EDMONTOSAURUS_AVOIDING = registerEntityTag("edmontosaurus_avoiding");
	public static final TagKey<EntityType<?>> ORNITHOMIMUS_AVOIDING = registerEntityTag("ornithomimus_avoiding");
	public static final TagKey<EntityType<?>> PACHYCEPHALOSAURUS_AVOIDING = registerEntityTag("pachycephalosaurus_avoiding");
	public static final TagKey<EntityType<?>> PALAEOSANIWA_AVOIDING = registerEntityTag("palaeosaniwa_avoiding");
	public static final TagKey<EntityType<?>> THESCELOSAURUS_AVOIDING = registerEntityTag("thescelosaurus_avoiding");
	public static final TagKey<EntityType<?>> TRICERATOPS_AVOIDING = registerEntityTag("triceratops_avoiding");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_AVOIDING = registerEntityTag("tyrannosaurus_avoiding");

	public static final TagKey<EntityType<?>> AEPYORNITHOMIMUS_AVOIDING = registerEntityTag("aepyornithom_avoiding");
	public static final TagKey<EntityType<?>> BYRONOSAURUS_AVOIDING = registerEntityTag("byronosaurus_avoiding");
	public static final TagKey<EntityType<?>> CITIPATI_AVOIDING = registerEntityTag("citipati_avoiding");
	public static final TagKey<EntityType<?>> GOYOCEPHALE_AVOIDING = registerEntityTag("goyocephale_avoiding");
	public static final TagKey<EntityType<?>> HALSZKARAPTOR_AVOIDING = registerEntityTag("halszkaraptor_avoiding");
	public static final TagKey<EntityType<?>> KOL_AVOIDING = registerEntityTag("kol_avoiding");
	public static final TagKey<EntityType<?>> OVIRAPTOR_AVOIDING = registerEntityTag("oviraptor_avoiding");
	public static final TagKey<EntityType<?>> PINACOSAURUS_AVOIDING = registerEntityTag("pinacosaurus_avoiding");
	public static final TagKey<EntityType<?>> PLESIOHADROS_AVOIDING = registerEntityTag("plesiohadros_avoiding");
	public static final TagKey<EntityType<?>> PROTOCERATOPS_AVOIDING = registerEntityTag("protoceratops_avoiding");
	public static final TagKey<EntityType<?>> UDANOCERATOPS_AVOIDING = registerEntityTag("udanoceratops_avoiding");
	public static final TagKey<EntityType<?>> TELMASAURUS_AVOIDING = registerEntityTag("telmasaurus_avoiding");
	public static final TagKey<EntityType<?>> VELOCIRAPTOR_AVOIDING = registerEntityTag("velociraptor_avoiding");
	
	public static final TagKey<EntityType<?>> BEIPIAOSAURUS_AVOIDING = registerEntityTag("beipiaosaurus_avoiding");
	public static final TagKey<EntityType<?>> CHANGYURAPTOR_AVOIDING = registerEntityTag("changyuraptor_avoiding");
	public static final TagKey<EntityType<?>> DILONG_AVOIDING = registerEntityTag("dilong_avoiding");
	public static final TagKey<EntityType<?>> DONGBEITITAN_AVOIDING = registerEntityTag("dongbeititan_avoiding");
	public static final TagKey<EntityType<?>> INCISIVOSAURUS_AVOIDING = registerEntityTag("incisivosaurus_avoiding");
	public static final TagKey<EntityType<?>> JINZHOUSAURUS_AVOIDING = registerEntityTag("jinzhousaurus_avoiding");
	public static final TagKey<EntityType<?>> LIAONINGOSAURUS_AVOIDING = registerEntityTag("liaoningosaurus_avoiding");
	public static final TagKey<EntityType<?>> PSITTACOSAURUS_AVOIDING = registerEntityTag("psittacosaurus_avoiding");
	public static final TagKey<EntityType<?>> REPENOMAMUS_AVOIDING = registerEntityTag("repenomamus_avoiding");
	public static final TagKey<EntityType<?>> RUIXINIA_AVOIDING = registerEntityTag("ruixinia_avoiding");
	public static final TagKey<EntityType<?>> SINOSAUROPTERYX_AVOIDING = registerEntityTag("sinosauropteryx_avoiding");
	public static final TagKey<EntityType<?>> YUTYRANNUS_AVOIDING = registerEntityTag("yutyrannus_avoiding");
	public static final TagKey<EntityType<?>> ZHENYUANLONG_AVOIDING = registerEntityTag("zhenyuanlong_avoiding");
	
	public static final TagKey<EntityType<?>> CALSOYASUCHUS_AVOIDING = registerEntityTag("calsoyasuchus_avoiding");
	public static final TagKey<EntityType<?>> DILOPHOSAURUS_AVOIDING = registerEntityTag("dilophosaurus_avoiding");
	public static final TagKey<EntityType<?>> DIPLICHNITES_HUNTING = registerEntityTag("diplichnites_hunting");
	public static final TagKey<EntityType<?>> KAYENTACHELYS_AVOIDING = registerEntityTag("kayentachelys_avoiding");
	public static final TagKey<EntityType<?>> KAYENTASUCHUS_AVOIDING = registerEntityTag("kayentasuchus_avoiding");
	public static final TagKey<EntityType<?>> KAYENTASUCHUS_HUNTING = registerEntityTag("kayentasuchus_hunting");
	public static final TagKey<EntityType<?>> KAYENTASUCHUS_BABY_HUNTING = registerEntityTag("kayentasuchus_baby_hunting");
	public static final TagKey<EntityType<?>> KAYENTATHERIUM_AVOIDING = registerEntityTag("kayentatherium_avoiding");
	public static final TagKey<EntityType<?>> KAYENTAVENATOR_AVOIDING = registerEntityTag("kayentavenator_avoiding");
	public static final TagKey<EntityType<?>> KAYENTAVENATOR_HUNTING = registerEntityTag("kayentavenator_hunting");
	public static final TagKey<EntityType<?>> KAYENTAVENATOR_BABY_HUNTING = registerEntityTag("kayentavenator_baby_hunting");
	public static final TagKey<EntityType<?>> MEGAPNOSAURUS_AVOIDING = registerEntityTag("megapnosaurus_avoiding");
	public static final TagKey<EntityType<?>> OCTOPODICHNUS_HUNTING = registerEntityTag("octopodichnus_hunting");
	public static final TagKey<EntityType<?>> PALEOHELCURA_HUNTING = registerEntityTag("paleohelcura_hunting");
	public static final TagKey<EntityType<?>> SARAHSAURUS_AVOIDING = registerEntityTag("sarahsaurus_avoiding");
	public static final TagKey<EntityType<?>> SCELIDOSAURUS_AVOIDING = registerEntityTag("scelidosaurus_avoiding");
	public static final TagKey<EntityType<?>> SCUTELLOSAURUS_AVOIDING = registerEntityTag("scutellosaurus_avoiding");

	public static final TagKey<EntityType<?>> ALCOVASAURUS_AVOIDING = registerEntityTag("alcovasaurus_avoiding");
	public static final TagKey<EntityType<?>> ALLOSAURUS_AVOIDING = registerEntityTag("allosaurus_avoiding");
	public static final TagKey<EntityType<?>> BRACHIOSAURUS_AVOIDING = registerEntityTag("brachiosaurus_avoiding");
	public static final TagKey<EntityType<?>> BRONTOSAURUS_AVOIDING = registerEntityTag("brontosaurus_avoiding");
	public static final TagKey<EntityType<?>> CAMARASAURUS_AVOIDING = registerEntityTag("camarasaurus_avoiding");
	public static final TagKey<EntityType<?>> CAMPTOSAURUS_AVOIDING = registerEntityTag("camptosaurus_avoiding");
	public static final TagKey<EntityType<?>> CERATOSAURUS_AVOIDING = registerEntityTag("ceratosaurus_avoiding");
	public static final TagKey<EntityType<?>> DIABLOPHIS_AVOIDING = registerEntityTag("diablophis_avoiding");
	public static final TagKey<EntityType<?>> DIABLOPHIS_HUNTING = registerEntityTag("diablophis_hunting");
	public static final TagKey<EntityType<?>> DIABLOPHIS_BABY_HUNTING = registerEntityTag("diablophis_baby_hunting");
	public static final TagKey<EntityType<?>> DIPLODOCUS_AVOIDING = registerEntityTag("diplodocus_avoiding");
	public static final TagKey<EntityType<?>> DRYOSAURUS_AVOIDING = registerEntityTag("dryosaurus_avoiding");
	public static final TagKey<EntityType<?>> EILENODON_AVOIDING = registerEntityTag("eilenodon_avoiding");
	public static final TagKey<EntityType<?>> GARGOYLEOSAURUS_AVOIDING = registerEntityTag("gargoyleosaurus_avoiding");
	public static final TagKey<EntityType<?>> HESPERORNITHOIDES_AVOIDING = registerEntityTag("hesperornithoides_avoiding");
	public static final TagKey<EntityType<?>> MACELOGNATHUS_AVOIDING = registerEntityTag("macelognathus_avoiding");
	public static final TagKey<EntityType<?>> MARAAPUNISAURUS_AVOIDING = registerEntityTag("maraapunisaurus_avoiding");
	public static final TagKey<EntityType<?>> STEGOSAURUS_AVOIDING = registerEntityTag("stegosaurus_avoiding");
	public static final TagKey<EntityType<?>> TANYCOLAGREUS_AVOIDING = registerEntityTag("tanycolagreus_avoiding");
	public static final TagKey<EntityType<?>> TANYCOLAGREUS_HUNTING = registerEntityTag("tanycolagreus_hunting");
	public static final TagKey<EntityType<?>> TANYCOLAGREUS_BABY_HUNTING = registerEntityTag("tanycolagreus_baby_hunting");
	public static final TagKey<EntityType<?>> TORVOSAURUS_AVOIDING = registerEntityTag("torvosaurus_avoiding");
	public static final TagKey<EntityType<?>> TORVOSAURUS_HUNTING = registerEntityTag("torvosaurus_hunting");
	public static final TagKey<EntityType<?>> TORVOSAURUS_BABY_HUNTING = registerEntityTag("torvosaurus_baby_hunting");
	
	public static final TagKey<EntityType<?>> ABROSAURUS_AVOIDING = registerEntityTag("abrosaurus_avoiding");
	public static final TagKey<EntityType<?>> AGILISAURUS_AVOIDING = registerEntityTag("agilisaurus_avoiding");
	public static final TagKey<EntityType<?>> BASHANOSAURUS_AVOIDING = registerEntityTag("bashanosaurus_avoiding");
	public static final TagKey<EntityType<?>> CHUANDONGOCOELURUS_AVOIDING = registerEntityTag("chuandongocoelurus_avoiding");
	public static final TagKey<EntityType<?>> CHUANDONGOCOELURUS_HUNTING = registerEntityTag("chuandongocoelurus_hunting");
	public static final TagKey<EntityType<?>> CHUANDONGOCOELURUS_BABY_HUNTING = registerEntityTag("chuandongocoelurus_baby_hunting");
	public static final TagKey<EntityType<?>> GIGANTSPINOSAURUS_AVOIDING = registerEntityTag("gigantspinosaurus_avoiding");
	public static final TagKey<EntityType<?>> HUAYANGOSAURUS_AVOIDING = registerEntityTag("huayangosaurus_avoiding");
	public static final TagKey<EntityType<?>> MAMENCHISAURUS_AVOIDING = registerEntityTag("mamenchisaurus_avoiding");
	public static final TagKey<EntityType<?>> OMEISAURUS_AVOIDING = registerEntityTag("omeisaurus_avoiding");
	public static final TagKey<EntityType<?>> SINRAPTOR_AVOIDING = registerEntityTag("sinraptor_avoiding");
	public static final TagKey<EntityType<?>> SINRAPTOR_HUNTING = registerEntityTag("sinraptor_hunting");
	public static final TagKey<EntityType<?>> SINRAPTOR_BABY_HUNTING = registerEntityTag("sinraptor_baby_hunting");
	public static final TagKey<EntityType<?>> SHUNOSAURUS_AVOIDING = registerEntityTag("shunosaurus_avoiding");
	public static final TagKey<EntityType<?>> TUOJIANGOSAURUS_AVOIDING = registerEntityTag("tuojiangosaurus_avoiding");
	public static final TagKey<EntityType<?>> YANDUSAURUS_AVOIDING = registerEntityTag("yandusaurus_avoiding");
	public static final TagKey<EntityType<?>> YANGCHUANOSAURUS_AVOIDING = registerEntityTag("yangchuanosaurus_avoiding");
	public static final TagKey<EntityType<?>> YANGCHUANOSAURUS_HUNTING = registerEntityTag("yangchuanosaurus_hunting");
	public static final TagKey<EntityType<?>> YANGCHUANOSAURUS_BABY_HUNTING = registerEntityTag("yangchuanosaurus_baby_hunting");
	
	public static final TagKey<EntityType<?>> COELOPHYSIS_AVOIDING = registerEntityTag("coelophysis_avoiding");
	public static final TagKey<EntityType<?>> DESMATOSUCHUS_AVOIDING = registerEntityTag("desmatosuchus_avoiding");
	public static final TagKey<EntityType<?>> PLACERIAS_AVOIDING = registerEntityTag("placerias_avoiding");
	public static final TagKey<EntityType<?>> POPOSAURUS_AVOIDING = registerEntityTag("poposaurus_avoiding");
	public static final TagKey<EntityType<?>> POSTOSUCHUS_AVOIDING = registerEntityTag("postosuchus_avoiding");
	public static final TagKey<EntityType<?>> TRILOPHOSAURUS_AVOIDING = registerEntityTag("trilophosaurus_avoiding");
	public static final TagKey<EntityType<?>> TYPOTHORAX_AVOIDING = registerEntityTag("typothorax_avoiding");

	public static final TagKey<EntityType<?>> CHROMOGISAURUS_AVOIDING = registerEntityTag("chromogisaurus_avoiding");
	public static final TagKey<EntityType<?>> EXAERETODON_AVOIDING = registerEntityTag("exaeretodon_avoiding");
	public static final TagKey<EntityType<?>> HERRERASAURUS_AVOIDING = registerEntityTag("herrerasaurus_avoiding");
	public static final TagKey<EntityType<?>> HYPERODAPEDON_AVOIDING = registerEntityTag("hyperodapedon_avoiding");
	public static final TagKey<EntityType<?>> ISCHIGUALASTIA_AVOIDING = registerEntityTag("ischigualastia_avoiding");
	public static final TagKey<EntityType<?>> SAUROSUCHUS_AVOIDING = registerEntityTag("saurosuchus_avoiding");
	public static final TagKey<EntityType<?>> SILLOSUCHUS_AVOIDING = registerEntityTag("sillosuchus_avoiding");
	
	public static final TagKey<EntityType<?>> DERMESTID_AVOIDING = registerEntityTag("dermestid_avoiding");
	public static final TagKey<EntityType<?>> GOBIULUS_AVOIDING = registerEntityTag("gobiulus_avoiding");
	public static final TagKey<EntityType<?>> CEPHALOLEICHNITES_AVOIDING = registerEntityTag("cephaloleichnites_avoiding");
	public static final TagKey<EntityType<?>> APOCLION_AVOIDING = registerEntityTag("apoclion_avoiding");
	public static final TagKey<EntityType<?>> CRETARANEUS_AVOIDING = registerEntityTag("cretaraneus_avoiding");
	public static final TagKey<EntityType<?>> LIAONEMOBIUS_AVOIDING = registerEntityTag("liaonemobius_avoiding");
	public static final TagKey<EntityType<?>> PARAPLEURITES_AVOIDING = registerEntityTag("parapleurites_avoiding");
	public static final TagKey<EntityType<?>> EOPOLIS_AVOIDING = registerEntityTag("eopolis_avoiding");
	public static final TagKey<EntityType<?>> CYLINDRICUM_AVOIDING = registerEntityTag("cylindricum_avoiding");
	public static final TagKey<EntityType<?>> RHIPIDOBLATTINA_AVOIDING = registerEntityTag("rhipidoblattina_avoiding");
	public static final TagKey<EntityType<?>> CICADOCORIS_AVOIDING = registerEntityTag("cicadocoris_avoiding");
	public static final TagKey<EntityType<?>> MESOFORFICULA_AVOIDING = registerEntityTag("mesoforficula_avoiding");
	public static final TagKey<EntityType<?>> ABOILUS_AVOIDING = registerEntityTag("aboilus_avoiding");
	public static final TagKey<EntityType<?>> PALEOHELCURA_AVOIDING = registerEntityTag("paleohelcura_avoiding");
	public static final TagKey<EntityType<?>> OCTOPODICHNUS_AVOIDING = registerEntityTag("octopodichnus_avoiding");
	public static final TagKey<EntityType<?>> DIPLICHNITES_AVOIDING = registerEntityTag("diplichnites_avoiding");

	public static final TagKey<EntityType<?>> TRIASSIC_ENTITIES = registerEntityTag("triassic_entities");
	public static final TagKey<EntityType<?>> JURASSIC_ENTITIES = registerEntityTag("jurassic_entities");
	public static final TagKey<EntityType<?>> CRETACEOUS_ENTITIES = registerEntityTag("cretaceous_entities");
	
	public static final TagKey<EntityType<?>> BURROWERS = registerEntityTag("burrowers");
	
	public static final TagKey<EntityType<?>> SENTINEL_IGNORES = registerEntityTag("sentinel_ignores");
	
	public static final TagKey<EntityType<?>> CRETACEOUS_BOSS_CONVERTERS = registerEntityTag("can_become_cretaceous_boss");

	public static final TagKey<Item> MEATS_2_HUNGER = registerItemTag("two_hunger_meats");
	public static final TagKey<Item> MEATS_4_HUNGER = registerItemTag("four_hunger_meats");
	public static final TagKey<Item> MEATS_6_HUNGER = registerItemTag("six_hunger_meats");
	public static final TagKey<Item> MEATS_8_HUNGER = registerItemTag("eight_hunger_meats");
	public static final TagKey<Item> MEATS_10_HUNGER = registerItemTag("ten_hunger_meats");
	public static final TagKey<Item> MEATS_12_HUNGER = registerItemTag("twelve_hunger_meats");
	public static final TagKey<Item> FISH_2_HUNGER = registerItemTag("two_hunger_fish");
	public static final TagKey<Item> FISH_4_HUNGER = registerItemTag("four_hunger_fish");
	public static final TagKey<Item> EGGS_5_HUNGER = registerItemTag("five_hunger_eggs");
	public static final TagKey<Item> EGGS_10_HUNGER = registerItemTag("ten_hunger_eggs");
	public static final TagKey<Item> EGGS_15_HUNGER = registerItemTag("fifteen_hunger_eggs");
	public static final TagKey<Item> SHELLFISH_3_HUNGER = registerItemTag("three_hunger_shellfish");
	public static final TagKey<Block> FEEDERS = registerBlockTag("feeders");

	public static final TagKey<Biome> IS_JURASSIC = registerBiomeTag("is_jurassic");
	public static final TagKey<Biome> IS_CRETACEOUS = registerBiomeTag("is_cretaceous");
	public static final TagKey<Biome> IS_TRIASSIC = registerBiomeTag("is_triassic");

	public static final TagKey<Biome> HAS_CHINLE_HUT = registerBiomeTag("has_structure/chinle_hut");
	public static final TagKey<Biome> HAS_DJADOCHTA_HUT = registerBiomeTag("has_structure/djadochta_hut");
	public static final TagKey<Biome> HAS_GEOLOGIST_CAMP = registerBiomeTag("has_structure/geologist_camp");
	public static final TagKey<Biome> HAS_HELL_CREEK_HUT = registerBiomeTag("has_structure/hell_creek_hut");
	public static final TagKey<Biome> HAS_ISCHIGUALASTO_HUT = registerBiomeTag("has_structure/ischigualasto_hut");
	public static final TagKey<Biome> HAS_KAYENTA_HUT = registerBiomeTag("has_structure/kayenta_hut");
	public static final TagKey<Biome> HAS_MORRISON_HUT = registerBiomeTag("has_structure/morrison_hut");
	public static final TagKey<Biome> HAS_TIME_TEMPLE = registerBiomeTag("has_structure/time_temple");
	public static final TagKey<Biome> HAS_YIXIAN_HUT = registerBiomeTag("has_structure/yixian_hut");

	public static final TagKey<Structure> ON_TIME_TEMPLE_MAPS = registerStructureTag("on_time_temple_maps");

	public static final TagKey<PoiType> BURROWS = registerPoiTag("burrows"); 
	public static final TagKey<PoiType> EOPOLIS_MOUNDS = registerPoiTag("eopolis_mounds");

	private static TagKey<Item> registerItemTag(String name) {
		return TagKey.create(Registries.ITEM, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<EntityType<?>> registerEntityTag(String name) {
		return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<Block> registerBlockTag(String name) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<Biome> registerBiomeTag(String name) {
		return TagKey.create(Registries.BIOME, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<PoiType> registerPoiTag(String name) {
		return TagKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<Structure> registerStructureTag(String name) {
		return TagKey.create(Registries.STRUCTURE, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

}
