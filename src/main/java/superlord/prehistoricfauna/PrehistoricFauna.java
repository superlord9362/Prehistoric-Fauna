package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.serialization.Codec;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.resource.PathPackResources;
import net.minecraftforge.resource.ResourcePackLoader;
import net.minecraftforge.server.ServerLifecycleHooks;
import superlord.prehistoricfauna.client.ClientProxy;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.block.messages.MessageHandler;
import superlord.prehistoricfauna.common.entity.block.messages.MessageUpdatePaleoscribe;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.*;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.*;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.*;
import superlord.prehistoricfauna.common.entity.fish.*;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.*;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.*;
import superlord.prehistoricfauna.common.entity.fossil.triassic.*;
import superlord.prehistoricfauna.common.entity.henos.*;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.*;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.*;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.*;
import superlord.prehistoricfauna.common.entity.triassic.chinle.*;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.*;
import superlord.prehistoricfauna.common.events.GeologicalHammerEvents;
import superlord.prehistoricfauna.common.network.KeyInputMessage;
import superlord.prehistoricfauna.common.recipes.PaleontologyTableRecipeS2C;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.config.PFConfigHolder;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.datagen.PFFeatureAndBiomeGenerator;
import superlord.prehistoricfauna.init.*;
import superlord.prehistoricfauna.init.PFStructures.PFStructurePieceType;
import superlord.prehistoricfauna.init.PFStructures.PFStructureType;

@Mod(PrehistoricFauna.MOD_ID)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class PrehistoricFauna {

	public static final String MOD_ID = "prehistoricfauna";	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);
	public static final List<Runnable> CALLBACKS = new ArrayList<>();
	@SuppressWarnings("deprecation")
	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel NETWORK_WRAPPER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation("prehistoricfauna", "main_channel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();
	private static int packetsRegistered = 0;

	public PrehistoricFauna() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();

		bus.addListener(this::setup);
		bus.addListener(this::onModConfigEvent);
		bus.addListener(this::doClientStuff);

		PFBlocks.REGISTER.register(bus);
		PFItems.REGISTER.register(bus);
		PFItems.BUILDING_REGISTER.register(bus);
		PFItems.DECORATION_REGISTER.register(bus);
		PFItems.SKELETON_REGISTER.register(bus);
		PFItems.SPAWN_EGG_REGISTER.register(bus);
		PFItems.FOOD_REGISTER.register(bus);

		PFEntities.REGISTER.register(bus);
		PFBlockEntities.REGISTER.register(bus);
		PFProfessions.POI_TYPES.register(bus);
		PFProfessions.PROFESSIONS.register(bus);
		REGISTRY_HELPER.getBlockSubHelper().register(bus);
		REGISTRY_HELPER.getItemSubHelper().register(bus);
		REGISTRY_HELPER.getBlockEntitySubHelper().register(bus);
		PFContainers.REGISTER.register(bus);
		PFFeatures.REGISTER.register(bus);
		PFEffects.REGISTER.register(bus);
		PFChunkGenerators.REGISTER.register(bus);
		PFDimensions.POI_TYPES.register(bus);
		PFSounds.REGISTRY.register(bus);
		PFCreativeTabs.REGISTRY.register(bus);
		PFRecipes.REGISTER.register(bus);
		PFBiomeSources.REGISTER.register(bus);
		PFPotDecorations.REGISTER.register(bus);
		PFParticles.REGISTRY.register(bus);
		PFBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(bus);
		PFBannerPatterns.REGISTER.register(bus);
		PFStructurePieceType.REGISTRY.register(bus);
		PFStructureType.REGISTRY.register(bus);
		final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, PrehistoricFauna.MOD_ID);
		biomeModifiers.register(bus);
		biomeModifiers.register("pf_entity_spawns", PFMobSpawnsModifier::makeCodec);
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, PFConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, PFConfigHolder.SERVER_SPEC);

		bus.addListener(this::gatherData);

		bus.addListener(this::registerEntityAttributes);

		PROXY.init();
	}

	@SubscribeEvent
	public void onModConfigEvent(final ModConfigEvent event) {
		final ModConfig config = event.getConfig();
		if (config.getSpec() == PFConfigHolder.SERVER_SPEC) {
			PrehistoricFaunaConfig.bakeServer(config);
		}
		if (config.getSpec() == PFConfigHolder.CLIENT_SPEC) {
			PrehistoricFaunaConfig.bakeClient(config);
		}
	}

	public void gatherData(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		PackOutput packOutput = dataGenerator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		boolean server = event.includeServer();
		dataGenerator.addProvider(server, new PFFeatureAndBiomeGenerator(packOutput, lookupProvider));
	}

	private void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(PFEntities.HERRERASAURUS_SKULL.get(), HerrerasaurusSkull.createAttributes().build());
		event.put(PFEntities.SAUROSUCHUS_SKULL.get(), SaurosuchusSkull.createAttributes().build());
		event.put(PFEntities.ISCHIGUALASTIA_SKULL.get(), IschigualastiaSkull.createAttributes().build());
		event.put(PFEntities.POSTOSUCHUS_SKULL.get(), PostosuchusSkull.createAttributes().build());
		event.put(PFEntities.DESMATOSUCHUS_SKULL.get(), DesmatosuchusSkull.createAttributes().build());
		event.put(PFEntities.COELOPHYSIS_SKULL.get(), CoelophysisSkull.createAttributes().build());
		event.put(PFEntities.ALLOSAURUS_SKULL.get(), AllosaurusSkull.createAttributes().build());
		event.put(PFEntities.STEGOSAURUS_SKULL.get(), StegosaurusSkull.createAttributes().build());
		event.put(PFEntities.CERATOSAURUS_SKULL.get(), CeratosaurusSkull.createAttributes().build());
		event.put(PFEntities.DILOPHOSAURUS_SKULL.get(), DilophosaurusSkull.createAttributes().build());
		event.put(PFEntities.SCELIDOSAURUS_SKULL.get(), ScelidosaurusSkull.createAttributes().build());
		event.put(PFEntities.SARAHSAURUS_SKULL.get(), SarahsaurusSkull.createAttributes().build());
		event.put(PFEntities.TYRANNOSAURUS_SKULL.get(), TyrannosaurusSkull.createAttributes().build());
		event.put(PFEntities.ANKYLOSAURUS_SKULL.get(), AnkylosaurusSkull.createAttributes().build());
		event.put(PFEntities.TRICERATOPS_SKULL.get(), TriceratopsSkull.createAttributes().build());
		event.put(PFEntities.VELOCIRAPTOR_SKULL.get(), VelociraptorSkull.createAttributes().build());
		event.put(PFEntities.PLESIOHADROS_SKULL.get(), PlesiohadrosSkull.createAttributes().build());
		event.put(PFEntities.YUTYRANNUS_SKULL.get(), YutyrannusSkull.createAttributes().build());
		event.put(PFEntities.PROTOCERATOPS_SKULL.get(), ProtoceratopsSkull.createAttributes().build());
		event.put(PFEntities.ANKYLOSAURUS_SKELETON.get(), AnkylosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.TRICERATOPS_SKELETON.get(), TriceratopsSkeleton.createAttributes().build());
		event.put(PFEntities.TYRANNOSAURUS_SKELETON.get(), TyrannosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.PLESIOHADROS_SKELETON.get(), PlesiohadrosSkeleton.createAttributes().build());
		event.put(PFEntities.VELOCIRAPTOR_SKELETON.get(), VelociraptorSkeleton.createAttributes().build());
		event.put(PFEntities.PROTOCERATOPS_SKELETON.get(), ProtoceratopsSkeleton.createAttributes().build());
		event.put(PFEntities.ALLOSAURUS_SKELETON.get(), AllosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.STEGOSAURUS_SKELETON.get(), StegosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.CERATOSAURUS_SKELETON.get(), CeratosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.DILOPHOSAURUS_SKELETON.get(), DilophosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.SARAHSAURUS_SKELETON.get(), SarahsaurusSkeleton.createAttributes().build());
		event.put(PFEntities.SCELIDOSAURUS_SKELETON.get(), ScelidosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.COELOPHYSIS_SKELETON.get(), CoelophysisSkeleton.createAttributes().build());
		event.put(PFEntities.POSTOSUCHUS_SKELETON.get(), PostosuchusSkeleton.createAttributes().build());
		event.put(PFEntities.DESMATOSUCHUS_SKELETON.get(), DesmatosuchusSkeleton.createAttributes().build());
		event.put(PFEntities.SAUROSUCHUS_SKELETON.get(), SaurosuchusSkeleton.createAttributes().build());
		event.put(PFEntities.ISCHIGUALASTIA_SKELETON.get(), IschigualastiaSkeleton.createAttributes().build());
		event.put(PFEntities.HERRERASAURUS_SKELETON.get(), HerrerasaurusSkeleton.createAttributes().build());
		event.put(PFEntities.PSITTACOSAURUS_SKELETON.get(), PsittacosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.YUTYRANNUS_SKELETON.get(), YutyrannusSkeleton.createAttributes().build());
		event.put(PFEntities.PSITTACOSAURUS_SKULL.get(), PsittacosaurusSkull.createAttributes().build());
		event.put(PFEntities.GOYOCEPHALE_SKELETON.get(), GoyocephaleSkeleton.createAttributes().build());
		event.put(PFEntities.GOYOCEPHALE_SKULL.get(), GoyocephaleSkull.createAttributes().build());
		event.put(PFEntities.DONGBEITITAN_SKELETON.get(), DongbeititanSkeleton.createAttributes().build());
		event.put(PFEntities.DONGBEITITAN_SKULL.get(), DongbeititanSkull.createAttributes().build());
		event.put(PFEntities.BRACHIOSAURUS_SKULL.get(), BrachiosaurusSkull.createAttributes().build());
		event.put(PFEntities.HENOS.get(), Henos.createAttributes().build());
		event.put(PFEntities.ARGANODUS.get(), Arganodus.createAttributes().build());
		event.put(PFEntities.CERATODUS.get(), Ceratodus.createAttributes().build());
		event.put(PFEntities.CHINLEA.get(), Chinlea.createAttributes().build());
		event.put(PFEntities.CYCLURUS.get(), Cyclurus.createAttributes().build());
		event.put(PFEntities.GAR.get(), Gar.createAttributes().build());
		event.put(PFEntities.MOOREODONTUS.get(), Mooreodontus.createAttributes().build());
		event.put(PFEntities.MYLEDAPHUS.get(), Myledaphus.createAttributes().build());
		event.put(PFEntities.POTAMOCERATODUS.get(), Potamoceratodus.createAttributes().build());
		event.put(PFEntities.SAURICHTHYS.get(), Saurichthys.createAttributes().build());
		event.put(PFEntities.THESCELOSAURUS.get(), Thescelosaurus.createAttributes().build());
		event.put(PFEntities.ANKYLOSAURUS.get(), Ankylosaurus.createAttributes().build());
		event.put(PFEntities.BASILEMYS.get(), Basilemys.createAttributes().build());
		event.put(PFEntities.DAKOTARAPTOR.get(), Dakotaraptor.createAttributes().build());
		event.put(PFEntities.DIDELPHODON.get(), Didelphodon.createAttributes().build());
		event.put(PFEntities.TRICERATOPS.get(), Triceratops.createAttributes().build());
		event.put(PFEntities.TYRANNOSAURUS.get(), Tyrannosaurus.createAttributes().build());
		event.put(PFEntities.AEPYORNITHOMIMUS.get(), Aepyornithomimus.createAttributes().build());
		event.put(PFEntities.CITIPATI.get(), Citipati.createAttributes().build());
		event.put(PFEntities.PINACOSAURUS.get(), Pinacosaurus.createAttributes().build());
		event.put(PFEntities.PLESIOHADROS.get(), Plesiohadros.createAttributes().build());
		event.put(PFEntities.PROTOCERATOPS.get(), Protoceratops.createAttributes().build());
		event.put(PFEntities.TELMASAURUS.get(), Telmasaurus.createAttributes().build());
		event.put(PFEntities.VELOCIRAPTOR.get(), Velociraptor.createAttributes().build());
		event.put(PFEntities.CALSOYASUCHUS.get(), Calsoyasuchus.createAttributes().build());
		event.put(PFEntities.DILOPHOSAURUS.get(), Dilophosaurus.createAttributes().build());
		event.put(PFEntities.MELVIUS.get(), Melvius.createAttributes().build());
		event.put(PFEntities.KAYENTATHERIUM.get(), Kayentatherium.createAttributes().build());
		event.put(PFEntities.MEGAPNOSAURUS.get(), Megapnosaurus.createAttributes().build());
		event.put(PFEntities.SARAHSAURUS.get(), Sarahsaurus.createAttributes().build());
		event.put(PFEntities.SCELIDOSAURUS.get(), Scelidosaurus.createAttributes().build());
		event.put(PFEntities.SCUTELLOSAURUS.get(), Scutellosaurus.createAttributes().build());
		event.put(PFEntities.ALLOSAURUS.get(), Allosaurus.createAttributes().build());
		event.put(PFEntities.CAMARASAURUS.get(), Camarasaurus.createAttributes().build());
		event.put(PFEntities.CERATOSAURUS.get(), Ceratosaurus.createAttributes().build());
		event.put(PFEntities.DRYOSAURUS.get(), Dryosaurus.createAttributes().build());
		event.put(PFEntities.EILENODON.get(), Eilenodon.createAttributes().build());
		event.put(PFEntities.HESPERORNITHOIDES.get(), Hesperornithoides.createAttributes().build());
		event.put(PFEntities.STEGOSAURUS.get(), Stegosaurus.createAttributes().build());
		event.put(PFEntities.COELOPHYSIS.get(), Coelophysis.createAttributes().build());
		event.put(PFEntities.DESMATOSUCHUS.get(), Desmatosuchus.createAttributes().build());
		event.put(PFEntities.PLACERIAS.get(), Placerias.createAttributes().build());
		event.put(PFEntities.POPOSAURUS.get(), Poposaurus.createAttributes().build());
		event.put(PFEntities.POSTOSUCHUS.get(), Postosuchus.createAttributes().build());
		event.put(PFEntities.TRILOPHOSAURUS.get(), Trilophosaurus.createAttributes().build());
		event.put(PFEntities.TYPOTHORAX.get(), Typothorax.createAttributes().build());
		event.put(PFEntities.CHROMOGISAURUS.get(), Chromogisaurus.createAttributes().build());
		event.put(PFEntities.EXAERETODON.get(), Exaeretodon.createAttributes().build());
		event.put(PFEntities.HERRERASAURUS.get(), Herrerasaurus.createAttributes().build());
		event.put(PFEntities.HYPERODAPEDON.get(), Hyperodapedon.createAttributes().build());
		event.put(PFEntities.ISCHIGUALASTIA.get(), Ischigualastia.createAttributes().build());
		event.put(PFEntities.SAUROSUCHUS.get(), Saurosuchus.createAttributes().build());
		event.put(PFEntities.SILLOSUCHUS.get(), Sillosuchus.createAttributes().build());
		event.put(PFEntities.CAVE_SENTINEL.get(), CaveSentinel.createAttributes().build());
		event.put(PFEntities.LAND_SENTINEL.get(), LandSentinel.createAttributes().build());
		event.put(PFEntities.LONCHIDION.get(), Lonchidion.createAttributes().build());
		event.put(PFEntities.ACIPENSER.get(), Acipenser.createAttributes().build());
		event.put(PFEntities.BRACHYCHAMPSA.get(), Brachychampsa.createAttributes().build());
		event.put(PFEntities.OVIRAPTOR.get(), Oviraptor.createAttributes().build());
		event.put(PFEntities.PALAEOSANIWA.get(), Palaeosaniwa.createAttributes().build());
		event.put(PFEntities.DERMESTID_BEETLE.get(), DermestidBeetle.createAttributes().build());
		event.put(PFEntities.GOBIULUS.get(), Gobiulus.createAttributes().build());
		event.put(PFEntities.HARENAICHTHYS.get(), Harenaichthys.createAttributes().build());
		event.put(PFEntities.HALSZKARAPTOR.get(), Halszkaraptor.createAttributes().build());
		event.put(PFEntities.UDANOCERATOPS.get(), Udanoceratops.createAttributes().build());
		event.put(PFEntities.GOYOCEPHALE.get(), Goyocephale.createAttributes().build());
		event.put(PFEntities.PACHYCEPHALOSAURUS.get(), Pachycephalosaurus.createAttributes().build());
		event.put(PFEntities.ORNITHOMIMUS.get(), Ornithomimus.createAttributes().build());
		event.put(PFEntities.KOL.get(), Kol.createAttributes().build());
		event.put(PFEntities.YUTYRANNUS.get(), Yutyrannus.createAttributes().build());
		event.put(PFEntities.PSITTACOSAURUS.get(), Psittacosaurus.createAttributes().build());
		event.put(PFEntities.SINOSAUROPTERYX.get(), Sinosauropteryx.createAttributes().build());
		event.put(PFEntities.INCISIVOSAURUS.get(), Incisivosaurus.createAttributes().build());
		event.put(PFEntities.CEPHALOLEICHNITES.get(), Cephaloleichnites.createAttributes().build());
		event.put(PFEntities.APOCLION.get(), Apoclion.createAttributes().build());
		event.put(PFEntities.CRETARANEUS.get(), Cretaraneus.createAttributes().build());
		event.put(PFEntities.YANOSTEUS.get(), Yanosteus.createAttributes().build());
		event.put(PFEntities.PROTOPSEPHURUS.get(), Protopsephurus.createAttributes().build());
		event.put(PFEntities.SINAMIA.get(), Sinamia.createAttributes().build());
		event.put(PFEntities.EDMONTOSAURUS.get(), Edmontosaurus.createAttributes().build());
		event.put(PFEntities.BEIPIAOSAURUS.get(), Beipiaosaurus.createAttributes().build());
		event.put(PFEntities.ANZU.get(), Anzu.createAttributes().build());
		event.put(PFEntities.LIAONINGOSAURUS.get(), Liaoningosaurus.createAttributes().build());
		event.put(PFEntities.CHANGYURAPTOR.get(), Changyuraptor.createAttributes().build());
		event.put(PFEntities.PARAPSEPHURUS.get(), Parapsephurus.createAttributes().build());
		event.put(PFEntities.BYRONOSAURUS.get(), Byronosaurus.createAttributes().build());
		event.put(PFEntities.REPENOMAMUS.get(), Repenomamus.createAttributes().build());
		event.put(PFEntities.RUIXINIA.get(), Ruixinia.createAttributes().build());
		event.put(PFEntities.DONGBEITITAN.get(), Dongbeititan.createAttributes().build());
		event.put(PFEntities.DILONG.get(), Dilong.createAttributes().build());
		event.put(PFEntities.LIAONEMOBIUS.get(), Liaonemobius.createAttributes().build());
		event.put(PFEntities.ZHENYUANLONG.get(), Zhenyuanlong.createAttributes().build());
		event.put(PFEntities.JINZHOUSAURUS.get(), Jinzhousaurus.createAttributes().build());
		event.put(PFEntities.CERATODUS_COCOON.get(), CeratodusCocoon.createAttributes().build());
		event.put(PFEntities.POTAMOCERATODUS_COCOON.get(), PotamoceratodusCocoon.createAttributes().build());
		event.put(PFEntities.ARGANODUS_COCOON.get(), ArganodusCocoon.createAttributes().build());
		event.put(PFEntities.CORRUPTED_THEROPOD.get(), CorruptedTheropod.createAttributes().build());
		event.put(PFEntities.ANZU_SKULL.get(), AnzuSkull.createAttributes().build());
		event.put(PFEntities.ANZU_SKELETON.get(), AnzuSkeleton.createAttributes().build());
		event.put(PFEntities.LIAONINGOSAURUS_SKULL.get(), LiaoningosaurusSkull.createAttributes().build());
		event.put(PFEntities.LIAONINGOSAURUS_SKELETON.get(), LiaoningosaurusSkeleton.createAttributes().build());
		event.put(PFEntities.CHUNGKINGICHTHYS.get(), Chungkingichthys.createAttributes().build());
		event.put(PFEntities.LEPIDOTES.get(), Lepidotes.createAttributes().build());
		event.put(PFEntities.BASHANOSAURUS.get(), Bashanosaurus.createAttributes().build());
		event.put(PFEntities.CHUANDONGOCOELURUS.get(), Chuandongocoelurus.createAttributes().build());
		event.put(PFEntities.AGILISAURUS.get(), Agilisaurus.createAttributes().build());
		event.put(PFEntities.GIGANTSPINOSAURUS.get(), Gigantspinosaurus.createAttributes().build());
		event.put(PFEntities.YANDUSAURUS.get(), Yandusaurus.createAttributes().build());
		event.put(PFEntities.YANGCHUANOSAURUS.get(), Yangchuanosaurus.createAttributes().build());
		event.put(PFEntities.DIABLOPHIS.get(), Diablophis.createAttributes().build());
		event.put(PFEntities.MACELOGNATHUS.get(), Macelognathus.createAttributes().build());
		event.put(PFEntities.TANYCOLAGREUS.get(), Tanycolagreus.createAttributes().build());
		event.put(PFEntities.MORROLEPIS.get(), Morrolepis.createAttributes().build());
		event.put(PFEntities.KAYENTACHELYS.get(), Kayentachelys.createAttributes().build());
		event.put(PFEntities.KAYENTASUCHUS.get(), Kayentasuchus.createAttributes().build());
		event.put(PFEntities.KAYENTAVENATOR.get(), Kayentavenator.createAttributes().build());
		event.put(PFEntities.OPHIOPSIS.get(), Ophiopsis.createAttributes().build());
		event.put(PFEntities.DIPLICHNITES.get(), Diplichnites.createAttributes().build());
		event.put(PFEntities.OCTOPODICHNUS.get(), Octopodichnus.createAttributes().build());
		event.put(PFEntities.PALEOHELCURA.get(), Paleohelcura.createAttributes().build());
		event.put(PFEntities.CYLINDRICUM.get(), Cylindricum.createAttributes().build());
		event.put(PFEntities.EOPOLIS.get(), Eopolis.createAttributes().build());
		event.put(PFEntities.PARAPLEURITES.get(), Parapleurites.createAttributes().build());
		event.put(PFEntities.ABOILUS.get(), Aboilus.createAttributes().build());
		event.put(PFEntities.CICADOCORIS.get(), Cicadocoris.createAttributes().build());
		event.put(PFEntities.MESOFORFICULA.get(), Mesoforficula.createAttributes().build());
		event.put(PFEntities.RHIPIDOBLATTINA.get(), Rhipidoblattina.createAttributes().build());
		event.put(PFEntities.ALCOVASAURUS.get(), Alcovasaurus.createAttributes().build());
//		event.put(PFEntities.BRACHIOSAURUS.get(), Brachiosaurus.createAttributes().build());
//		event.put(PFEntities.BRONTOSAURUS.get(), Brontosaurus.createAttributes().build());
		event.put(PFEntities.CAMPTOSAURUS.get(), Camptosaurus.createAttributes().build());
//		event.put(PFEntities.DIPLODOCUS.get(), Diplodocus.createAttributes().build());
		event.put(PFEntities.GARGOYLEOSAURUS.get(), Gargoyleosaurus.createAttributes().build());
//		event.put(PFEntities.MARAAPUNISAURUS.get(), Maraapunisaurus.createAttributes().build());
		event.put(PFEntities.TORVOSAURUS.get(), Torvosaurus.createAttributes().build());
		event.put(PFEntities.ABROSAURUS.get(), Abrosaurus.createAttributes().build());
		event.put(PFEntities.HUAYANGOSAURUS.get(), Huayangosaurus.createAttributes().build());
//		event.put(PFEntities.MAMENCHISAURUS.get(), Mamenchisaurus.createAttributes().build());
//		event.put(PFEntities.OMEISAURUS.get(), Omeisaurus.createAttributes().build());
		event.put(PFEntities.SINRAPTOR.get(), Sinraptor.createAttributes().build());
		event.put(PFEntities.SHUNOSAURUS.get(), Shunosaurus.createAttributes().build());
		event.put(PFEntities.TUOJIANGOSAURUS.get(), Tuojiangosaurus.createAttributes().build());
	}
	
	private void doClientStuff(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
//			if (PrehistoricFaunaConfig.customMenuBackground) trySetRandomPanorama();
			CALLBACKS.forEach(Runnable::run);
			CALLBACKS.clear();
		});
	}

	@SuppressWarnings({ "deprecation" })
	public void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			WoodType.register(PFWoodTypes.AGATHOXYLON);
			WoodType.register(PFWoodTypes.ARAUCARIA);
			WoodType.register(PFWoodTypes.BRACHYPHYLLUM);
			WoodType.register(PFWoodTypes.GINKGO);
			WoodType.register(PFWoodTypes.HEIDIPHYLLUM);
			WoodType.register(PFWoodTypes.LIRIODENDRITES);
			WoodType.register(PFWoodTypes.METASEQUOIA);
			WoodType.register(PFWoodTypes.NEOCALAMITES);
			WoodType.register(PFWoodTypes.PROTOJUNIPEROXYLON);
			WoodType.register(PFWoodTypes.PROTOPICEOXYLON);
			WoodType.register(PFWoodTypes.SCHILDERIA);
			WoodType.register(PFWoodTypes.TROCHODENDROIDES);
			WoodType.register(PFWoodTypes.WOODWORTHIA);
			WoodType.register(PFWoodTypes.MONANTHESIA);
			WoodType.register(PFWoodTypes.DRYOPHYLLUM);
			WoodType.register(PFWoodTypes.TAXODIUM);
			WoodType.register(PFWoodTypes.SABALITES);
			WoodType.register(PFWoodTypes.PLATANITES);
			WoodType.register(PFWoodTypes.TAXUS);
			WoodType.register(PFWoodTypes.CZEKANOWSKIA);
			WoodType.register(PFWoodTypes.SCHIZOLEPIDOPSIS);
			WoodType.register(PFWoodTypes.PODOZAMITES);
			WoodType.register(PFWoodTypes.CUPRESSINOCLADUS);
			WoodType.register(PFWoodTypes.ELATIDES);
			WoodType.register(PFWoodTypes.PHOENICOPSIS);
			WoodType.register(PFWoodTypes.FRENELOPSIS);
		});
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdatePaleoscribe.class, MessageUpdatePaleoscribe::write, MessageUpdatePaleoscribe::read, MessageHandler.handle(MessageUpdatePaleoscribe.Handler::handle));
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, KeyInputMessage.class, KeyInputMessage::encode, KeyInputMessage::decode, KeyInputMessage::handle);
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, PaleontologyTableRecipeS2C.class, PaleontologyTableRecipeS2C::encode, PaleontologyTableRecipeS2C::decode, PaleontologyTableRecipeS2C::onPacketReceived);
		SpawnPlacements.register(PFEntities.ACIPENSER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Acipenser::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.ARGANODUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Arganodus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CERATODUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ceratodus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CHINLEA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Chinlea::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CYCLURUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cyclurus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.HARENAICHTHYS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Harenaichthys::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.GAR.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Gar::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.LONCHIDION.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Lonchidion::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.MOOREODONTUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mooreodontus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.MYLEDAPHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Myledaphus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.POTAMOCERATODUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Potamoceratodus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.SAURICHTHYS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Saurichthys::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.MELVIUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Melvius::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.PARAPSEPHURUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Parapsephurus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.THESCELOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ANKYLOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.BASILEMYS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DAKOTARAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DIDELPHODON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TRICERATOPS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TYRANNOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.AEPYORNITHOMIMUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CITIPATI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PINACOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PLESIOHADROS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PROTOCERATOPS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TELMASAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.VELOCIRAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CALSOYASUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Calsoyasuchus::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DILOPHOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.KAYENTATHERIUM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.MEGAPNOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SARAHSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SCELIDOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SCUTELLOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ALLOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CAMARASAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CERATOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DRYOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.EILENODON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.HESPERORNITHOIDES.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.STEGOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.COELOPHYSIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DESMATOSUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PLACERIAS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.POPOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.POSTOSUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TRILOPHOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TYPOTHORAX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CHROMOGISAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.EXAERETODON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.HERRERASAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.HYPERODAPEDON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ISCHIGUALASTIA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SAUROSUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SILLOSUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.BRACHYCHAMPSA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Brachychampsa::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.OVIRAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PALAEOSANIWA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.HALSZKARAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.UDANOCERATOPS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.GOYOCEPHALE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PACHYCEPHALOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ORNITHOMIMUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.KOL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.YUTYRANNUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.PSITTACOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SINOSAUROPTERYX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.INCISIVOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.EDMONTOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.BEIPIAOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ANZU.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.LIAONINGOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CHANGYURAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.BYRONOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.REPENOMAMUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.RUIXINIA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DONGBEITITAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DILONG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.LAND_SENTINEL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LandSentinel::canSpawn);
		SpawnPlacements.register(PFEntities.CAVE_SENTINEL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CaveSentinel::canSpawn);
		SpawnPlacements.register(PFEntities.PROTOPSEPHURUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Protopsephurus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.SINAMIA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sinamia::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.YANOSTEUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Yanosteus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.GOBIULUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Gobiulus::canBugSpawn);
		SpawnPlacements.register(PFEntities.DERMESTID_BEETLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DermestidBeetle::canBugSpawn);
		SpawnPlacements.register(PFEntities.CRETARANEUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cretaraneus::canBugSpawn);
		SpawnPlacements.register(PFEntities.APOCLION.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Apoclion::canBugSpawn);
		SpawnPlacements.register(PFEntities.CEPHALOLEICHNITES.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cephaloleichnites::canBugSpawn);
		SpawnPlacements.register(PFEntities.LIAONEMOBIUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Liaonemobius::canBugSpawn);
		SpawnPlacements.register(PFEntities.ZHENYUANLONG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.JINZHOUSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.LEPIDOTES.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Lepidotes::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CHUNGKINGICHTHYS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Chungkingichthys::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.BASHANOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CHUANDONGOCOELURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.AGILISAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.GIGANTSPINOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.YANDUSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.YANGCHUANOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.DIABLOPHIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.MACELOGNATHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TANYCOLAGREUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.MORROLEPIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Morrolepis::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.OPHIOPSIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ophiopsis::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.KAYENTACHELYS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.KAYENTASUCHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.KAYENTAVENATOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ABOILUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Aboilus::canBugSpawn);
		SpawnPlacements.register(PFEntities.CICADOCORIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cicadocoris::canBugSpawn);
		SpawnPlacements.register(PFEntities.MESOFORFICULA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Mesoforficula::canBugSpawn);
		SpawnPlacements.register(PFEntities.RHIPIDOBLATTINA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Rhipidoblattina::canBugSpawn);
		SpawnPlacements.register(PFEntities.CYLINDRICUM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Cylindricum::canBugSpawn);
		SpawnPlacements.register(PFEntities.EOPOLIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Eopolis::canBugSpawn);
		SpawnPlacements.register(PFEntities.PARAPLEURITES.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Parapleurites::canBugSpawn);
		SpawnPlacements.register(PFEntities.DIPLICHNITES.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Diplichnites::canBugSpawn);
		SpawnPlacements.register(PFEntities.OCTOPODICHNUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Octopodichnus::canBugSpawn);
		SpawnPlacements.register(PFEntities.PALEOHELCURA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Paleohelcura::canBugSpawn);
		SpawnPlacements.register(PFEntities.ALCOVASAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
//		SpawnPlacements.register(PFEntities.BRACHIOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
//		SpawnPlacements.register(PFEntities.BRONTOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.CAMPTOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
//		SpawnPlacements.register(PFEntities.DIPLODOCUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.GARGOYLEOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
//		SpawnPlacements.register(PFEntities.MARAAPUNISAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TORVOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.ABROSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.HUAYANGOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
//		SpawnPlacements.register(PFEntities.MAMENCHISAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
//		SpawnPlacements.register(PFEntities.OMEISAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SINRAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.SHUNOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		SpawnPlacements.register(PFEntities.TUOJIANGOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
		GeologicalHammerEvents.init();
		event.enqueueWork(() -> {
			PFPotDecorations.expandVanillaDefinitions();
		});
	}

	@OnlyIn(Dist.CLIENT)
	public static void trySetRandomPanorama() {
		Optional<PathPackResources> optionalResourcePack = ResourcePackLoader.getPackFor(MOD_ID);
		if (optionalResourcePack.isPresent()) {
			PathPackResources resourcePack = optionalResourcePack.get();
			Set<String> folders = getSubfoldersFromDirectory(resourcePack.getSource(), "assets/" + MOD_ID + "/panoramas");
			ResourceLocation panoramaLoc = new ResourceLocation(MOD_ID, "panoramas/yixian/panorama");
			if (folders.size() > 0) {
				ResourceLocation[] ResourceLocationsArray = new ResourceLocation[6];
				for (int i = 0; i < 6; ++i) {
					ResourceLocationsArray[i] = new ResourceLocation(panoramaLoc.getNamespace(), panoramaLoc.getPath() + '_' + i + ".png");
				}
				ObfuscationReflectionHelper.setPrivateValue(CubeMap.class, TitleScreen.CUBE_MAP, ResourceLocationsArray, "images");
			}
		}
	}

	public static Set<String> getSubfoldersFromDirectory(Path modFile, String directoryName) {
		try {
			Path root = modFile.toAbsolutePath();
			return Files.walk(root, 1)
					.map(path -> root.relativize(path.toAbsolutePath()))
					.filter(path -> path.getNameCount() > 0)
					.map(p -> p.toString().replaceAll("/$", ""))
					.filter(s -> !s.isEmpty())
					.collect(Collectors.toSet());
		} catch (IOException e) {
			return Collections.emptySet();
		}
	}

	public static <MSG> void sendMSGToServer(MSG message) {
		PrehistoricFauna.NETWORK_WRAPPER.sendToServer(message);
	}

	public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
		PrehistoricFauna.NETWORK_WRAPPER.send(PacketDistributor.PLAYER.with(() -> player), message);
	}

	public static <MSG> void sendMSGToAll(MSG message) {
		for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
			sendNonLocal(message, player);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static <MSG> void sendNonLocal(MSG msg, ServerPlayer player) {
		if (player.server.isDedicatedServer() || !player.getName().equals(player.server.getSingleplayerProfile())) {
			NETWORK_WRAPPER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
		}
	}

}
