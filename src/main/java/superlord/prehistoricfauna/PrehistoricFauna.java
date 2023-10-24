package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
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
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.resource.PathResourcePack;
import net.minecraftforge.resource.ResourcePackLoader;
import net.minecraftforge.server.ServerLifecycleHooks;
import superlord.prehistoricfauna.client.ClientProxy;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.common.GeologicalHammerEvents;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.block.messages.MessageUpdatePaleoscribe;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.*;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.*;
import superlord.prehistoricfauna.common.entity.fish.*;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.*;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.*;
import superlord.prehistoricfauna.common.entity.fossil.triassic.*;
import superlord.prehistoricfauna.common.entity.henos.CaveSentinel;
import superlord.prehistoricfauna.common.entity.henos.Henos;
import superlord.prehistoricfauna.common.entity.henos.LandSentinel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.*;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.*;
import superlord.prehistoricfauna.common.entity.triassic.chinle.*;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.*;
import superlord.prehistoricfauna.common.util.QuarkFlagRecipeCondition;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.config.PFConfigHolder;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.*;

@Mod(PrehistoricFauna.MOD_ID)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class PrehistoricFauna {

	public static final String MOD_ID = "prehistoricfauna";	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);
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
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();

		bus.addListener(this::doClientStuff);
		bus.addListener(this::setup);
		bus.addListener(this::onModConfigEvent);

		PFBlocks.REGISTER.register(bus);
		PFItems.REGISTER.register(bus);
		PFRecipes.REGISTER.register(bus);
		PFEntities.REGISTER.register(bus);
		PFBlockEntities.REGISTER.register(bus);
		REGISTRY_HELPER.getBlockSubHelper().register(bus);
		REGISTRY_HELPER.getItemSubHelper().register(bus);
		REGISTRY_HELPER.getBlockEntitySubHelper().register(bus);
		PFContainers.REGISTER.register(bus);
		PFFeatures.REGISTER.register(bus);
		PFConfiguredFeatures.REGISTER.register(bus);
		PFPlacedFeatures.REGISTER.register(bus);
		PFEffects.REGISTER.register(bus);
		PFBiomes.REGISTER.register(bus);
		PFBiomeSources.REGISTER.register(bus);
		PFChunkGenerators.REGISTER.register(bus);
		PFDimensions.POI_TYPES.register(bus);
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, PFConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, PFConfigHolder.SERVER_SPEC);
		CraftingHelper.register(new QuarkFlagRecipeCondition.Serializer());

		bus.addListener(this::registerEntityAttributes);
		forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
	}

	public void biomeModification(final BiomeLoadingEvent event) {
		String name = event.getName().getPath();
		if (name.equals("badlands")) event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION).add(PFPlacedFeatures.PLACED_PETRIFIED_TREE.getHolder().orElseThrow());
		if (!name.equals("chinle_flats") && !name.equals("chinle_swamp") && !name.equals("chinle_wooded_mountains") && !name.equals("ischigualasto_forest") && !name.equals("ischigualasto_clearing") && !name.equals("ischigualasto_hills")) {
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(PFPlacedFeatures.FOSSILIZED_CHALK);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(PFPlacedFeatures.FOSSILIZED_SILTSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(PFPlacedFeatures.FOSSILIZED_SANDSTONE);
		}
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
	}

	public final static CreativeModeTab PF_BUILDING = new CreativeModeTab("prehistoric_building_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFBlocks.ARAUCARIA_LOG.get());
		}
	};

	public final static CreativeModeTab PF_DECORATION = new CreativeModeTab("prehistoric_decoration_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFBlocks.LARGE_AMMONITE_FOSSIL.get());
		}
	};

	public final static CreativeModeTab PF_SPAWN_EGGS = new CreativeModeTab("prehistoric_eggs_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFItems.TYRANNOSAURUS_SPAWN_EGG.get());
		}
	};

	public final static CreativeModeTab PF_SKELETON = new CreativeModeTab("prehistoric_skeleton_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFItems.TYRANNOSAURUS_SKULL.get());
		}
	};

	public final static CreativeModeTab PF_MISC = new CreativeModeTab("prehistoric_misc_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFItems.PALEOPEDIA.get());
		}
	};

	public final static CreativeModeTab PF_FOOD = new CreativeModeTab("prehistoric_food_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFItems.RAW_LARGE_THEROPOD_MEAT.get());
		}
	};

	private void doClientStuff(final FMLClientSetupEvent event) {
		trySetRandomPanorama();
	}

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
			WoodType.register(PFWoodTypes.ZAMITES);
			WoodType.register(PFWoodTypes.DRYOPHYLLUM);
			WoodType.register(PFWoodTypes.TAXODIUM);
			WoodType.register(PFWoodTypes.SABALITES);
			WoodType.register(PFWoodTypes.PLATANITES);
			PFStructures.init();
			PFProfessions.fillTradeData();
		});
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdatePaleoscribe.class, MessageUpdatePaleoscribe::write, MessageUpdatePaleoscribe::read, MessageUpdatePaleoscribe.Handler::handle);
		SpawnPlacements.register(PFEntities.ARGANODUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Arganodus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CERATODUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ceratodus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CHINLEA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Chinlea::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.CYCLURUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cyclurus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.GAR.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Gar::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.MOOREODONTUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mooreodontus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.MYLEDAPHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Myledaphus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.POTAMOCERATODUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Potamoceratodus::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.SAURICHTHYS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Saurichthys::checkAncientFishSpawnRules);
		SpawnPlacements.register(PFEntities.MELVIUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Melvius::checkAncientFishSpawnRules);
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
		SpawnPlacements.register(PFEntities.LAND_SENTINEL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LandSentinel::canSpawn);
		SpawnPlacements.register(PFEntities.CAVE_SENTINEL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CaveSentinel::canSpawn);
		GeologicalHammerEvents.init();
	}

	@OnlyIn(Dist.CLIENT)
	public static void trySetRandomPanorama() {
		Optional<PathResourcePack> optionalResourcePack = ResourcePackLoader.getPackFor(MOD_ID);
		if (optionalResourcePack.isPresent()) {
			PathResourcePack resourcePack = optionalResourcePack.get();
			Set<String> folders = getSubfoldersFromDirectory(resourcePack.getSource(), "assets/" + MOD_ID + "/panoramas");
			ResourceLocation panoramaLoc = new ResourceLocation(MOD_ID, "panoramas/djadochta/panorama");
			if (folders.size() > 0) {
				ResourceLocation[] ResourceLocationsArray = new ResourceLocation[6];
				for (int i = 0; i < 6; ++i) {
					ResourceLocationsArray[i] = new ResourceLocation(panoramaLoc.getNamespace(), panoramaLoc.getPath() + '_' + i + ".png");
				}
				ObfuscationReflectionHelper.setPrivateValue(CubeMap.class, TitleScreen.CUBE_MAP, ResourceLocationsArray, "images");
			}
		}
	}

	private static Set<String> getSubfoldersFromDirectory(Path modFile, String directoryName) {
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

	public static <MSG> void sendMSGToAll(MSG message) {
		for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
			sendNonLocal(message, player);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static <MSG> void sendNonLocal(MSG msg, ServerPlayer player) {
		if (player.server.isDedicatedServer() || !player.getName().equals(player.server.getSingleplayerName())) {
			NETWORK_WRAPPER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
		}
	}

}
