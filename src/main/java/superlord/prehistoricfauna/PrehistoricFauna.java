package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.structure.Structure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.fml.packs.ModFileResourcePack;
import net.minecraftforge.fml.packs.ResourcePackLoader;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import superlord.prehistoricfauna.config.PrehistoricConfigHolder;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.core.world.*;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ContainerRegistry;
import superlord.prehistoricfauna.init.DimensionInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.init.ParticleInit;
import superlord.prehistoricfauna.init.PrehistoricPointofInterest;
import superlord.prehistoricfauna.init.TileEntityRegistry;
import superlord.prehistoricfauna.recipes.RecipeRegistry;
import superlord.prehistoricfauna.server.command.PHFCommand;
import superlord.prehistoricfauna.util.ClientProxy;
import superlord.prehistoricfauna.util.CommonEvents;
import superlord.prehistoricfauna.util.CommonProxy;
import superlord.prehistoricfauna.util.PFPacketHandler;
import superlord.prehistoricfauna.util.QuarkFlagRecipeCondition;
import superlord.prehistoricfauna.util.RegistryHelper;
import superlord.prehistoricfauna.world.PrehistoricFeature;

@SuppressWarnings("deprecation")
@Mod(PrehistoricFauna.MODID)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.MOD)
public class PrehistoricFauna {

	public final static String MODID = "prehistoricfauna";
	public static Logger LOGGER = LogManager.getLogger();
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);


	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public PrehistoricFauna() {
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		CraftingHelper.register(new QuarkFlagRecipeCondition.Serializer());
		BlockInit.BLOCKS.register(modEventBus);
		PrehistoricPointofInterest.POI_TYPES.register(modEventBus);
		DimensionInit.MOD_DIMENSIONS.register(modEventBus);
		REGISTRY_HELPER.getDeferredBlockRegister().register(modEventBus);
		REGISTRY_HELPER.getDeferredItemRegister().register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		PrehistoricFeature.FEATURES.register(modEventBus);
		TileEntityRegistry.TILE_ENTITY_TYPES.register(modEventBus);
		ContainerRegistry.CONTAINER_TYPES.register(modEventBus);
		RecipeRegistry.RECIPES.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ParticleInit.PARTICLE_TYPES.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new ServerEvents());
		PFPacketHandler.registerPackets();
		PROXY.init();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);
		modEventBus.addListener(this::spaceTimeContinuumWarping);
		modEventBus.addListener(this::chickenExtinction);
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, PrehistoricConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, PrehistoricConfigHolder.SERVER_SPEC);
	}

	private boolean setIsKilled(boolean isKilled) {
		return isKilled;
	}

	public void spaceTimeContinuumWarping(LivingDeathEvent event) {
		if (PrehistoricFaunaConfig.spaceTimeContinuumWarping) {
			if (event.getEntity() instanceof HesperornithoidesEntity) {
				if (event.getSource().getTrueSource() instanceof PlayerEntity) {
					this.setIsKilled(true);
				}
			}
		}
		this.setIsKilled(false);
	}

	public void chickenExtinction(CheckSpawn event) {
		if (this.setIsKilled(true)) {
			if (event.getEntity() instanceof ChickenEntity) {
				event.getEntity().remove();
				event.setResult(Result.DENY);
			}
		}
	}

	private void setup(final FMLCommonSetupEvent event) {
		CommonEvents.setup();
		List<Structure<?>> tempList = new ArrayList<>(Feature.ILLAGER_STRUCTURES);
		tempList.add(PrehistoricFeature.TIME_TEMPLE);
		Feature.ILLAGER_STRUCTURES = ImmutableList.copyOf(tempList);
		MinecraftForge.EVENT_BUS.register(new CommonEvents());
		PFFeatureRegistration.addFeatures();
		PROXY.setup();
		addBiomeFeatures();
		PHFOverworldBiomeRegistry.addBiomesToWeightSystem();
		Collections.sort(PHFOverworldBiomeRegistry.biomeList);
	}

	private void addBiomeFeatures() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome != PHFBiomes.HELL_CREEK_HILLS && biome != PHFBiomes.HELL_CREEK_RIVER && biome != PHFBiomes.ISCHIGUALASTO_CLEARING && biome != PHFBiomes.ISCHIGUALASTO_HILLS && biome != PHFBiomes.ISCHIGUALASTO_RIVER && biome != PHFBiomes.MORRISON_HILLS && biome != PHFBiomes.HELL_CREEK_CLEARING && biome != PHFBiomes.HELL_CREEK && biome != PHFBiomes.ISCHIGUALASTO_FOREST && biome != PHFBiomes.MORRISON_SAVANNAH && biome != Biomes.COLD_OCEAN && biome != Biomes.DEEP_COLD_OCEAN && biome != Biomes.DEEP_FROZEN_OCEAN && biome != Biomes.DEEP_LUKEWARM_OCEAN && biome != Biomes.DEEP_OCEAN && biome != Biomes.DEEP_WARM_OCEAN && biome != Biomes.FROZEN_OCEAN && biome != Biomes.LUKEWARM_OCEAN && biome != Biomes.OCEAN && biome != Biomes.WARM_OCEAN && biome != Biomes.FROZEN_RIVER && biome != Biomes.RIVER && biome != Biomes.BEACH && biome != Biomes.SNOWY_BEACH && biome != Biomes.END_BARRENS && biome != Biomes.END_HIGHLANDS && biome != Biomes.END_MIDLANDS && biome != Biomes.SMALL_END_ISLANDS && biome != Biomes.THE_END && biome != Biomes.NETHER && biome != Biomes.STONE_SHORE && biome != Biomes.THE_VOID) {
				biome.addStructure(PrehistoricFeature.TIME_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome != PHFBiomes.DUMMY) {
				biome.addFeature(Decoration.SURFACE_STRUCTURES, PrehistoricFeature.TIME_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				biome.addFeature(Decoration.SURFACE_STRUCTURES, PrehistoricFeature.PORTAL_CHAMBER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				biome.addFeature(Decoration.UNDERGROUND_ORES, PHFConfiguredFeatures.FOSSILIZED_CRETACEOUS_CHALK);
				biome.addFeature(Decoration.UNDERGROUND_ORES, PHFConfiguredFeatures.FOSSILIZED_TRIASSIC_SANDSTONE);
				biome.addFeature(Decoration.UNDERGROUND_ORES, PHFConfiguredFeatures.FOSSILIZED_JURASSIC_SILTSTONE);
				biome.addStructure(PrehistoricFeature.PORTAL_CHAMBER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome == Biomes.PLAINS || biome == Biomes.SUNFLOWER_PLAINS || biome == Biomes.FOREST || biome == Biomes.BIRCH_FOREST || biome == Biomes.BIRCH_FOREST_HILLS || biome == Biomes.FLOWER_FOREST || biome == Biomes.TALL_BIRCH_FOREST || biome == Biomes.GIANT_SPRUCE_TAIGA || biome == Biomes.TAIGA || biome == Biomes.TAIGA_HILLS || biome == Biomes.TAIGA_MOUNTAINS || biome == Biomes.GIANT_SPRUCE_TAIGA_HILLS || biome == Biomes.GIANT_TREE_TAIGA || biome == Biomes.GIANT_TREE_TAIGA_HILLS || biome == Biomes.SNOWY_TAIGA || biome == Biomes.SNOWY_TAIGA_HILLS || biome == Biomes.SNOWY_TAIGA_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MOUNTAINS || biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.SAVANNA || biome == Biomes.SAVANNA_PLATEAU || biome == Biomes.SNOWY_TUNDRA || biome == Biomes.WOODED_HILLS || biome == Biomes.WOODED_MOUNTAINS || biome == PHFOverworldBiomeRegistry.PETRIFIED_FOREST) {
                biome.addFeature(Decoration.SURFACE_STRUCTURES, PrehistoricFeature.GEOLOGIST_CAMP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				biome.addStructure(PrehistoricFeature.GEOLOGIST_CAMP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event) {
			PrehistoricFeature.registerFeatures(event);
			LOGGER.log(Level.INFO, "features/structures registered.");
		}
	}

	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
		entry.setRegistryName(new ResourceLocation(PrehistoricFauna.MODID, registryKey));
		registry.register(entry);
		return entry;
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		trySetRandomPanorama();
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		//		PrehistoricOreGen.generateOre();
	}

	public static class PFMisc extends ItemGroup {
		public static final PFMisc instance = new PFMisc(ItemGroup.GROUPS.length, "prehistoric_misc_tab");

		private PFMisc(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.PALEOPEDIA.get());
		}

	}

	public static class PFBuilding extends ItemGroup {
		public static final PFBuilding instance = new PFBuilding(ItemGroup.GROUPS.length, "prehistoric_building_tab");

		private PFBuilding(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.ARAUCARIA_LOG);
		}
	}

	public static class PFFood extends ItemGroup {
		public static final PFFood instance = new PFFood(ItemGroup.GROUPS.length, "prehistoric_food_tab");

		private PFFood(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.RAW_THESCELOSAURUS_MEAT.get());
		}
	}

	public static class PFEggs extends ItemGroup {
		public static final PFEggs instance = new PFEggs(ItemGroup.GROUPS.length, "prehistoric_eggs_tab");

		private PFEggs(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.ALLOSAURUS_SPAWN_EGG.get());
		}
	}

	public static class PFDecoration extends ItemGroup {
		public static final PFDecoration instance = new PFDecoration(ItemGroup.GROUPS.length, "prehistoric_decoration_tab");

		private PFDecoration(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.LARGE_AMMONITE_FOSSIL.asItem());
		}

	}

	public static class PFSkeleton extends ItemGroup {
		public static final PFSkeleton instance = new PFSkeleton(ItemGroup.GROUPS.length, "prehistoric_skeleton_tab");

		private PFSkeleton(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.TYRANNOSAURUS_SKULL.get());
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static void trySetRandomPanorama() {
		Optional<ModFileResourcePack> optionalResourcePack = ResourcePackLoader.getResourcePackFor(MODID);
		if (optionalResourcePack.isPresent()) {
			ModFileResourcePack resourcePack = optionalResourcePack.get();
			Set<String> folders = getSubfoldersFromDirectory(resourcePack.getModFile(), "assets/" + MODID + "/panoramas");
			if (folders.size() > 0) {
				String chosenPanorama = (String) folders.toArray()[new Random().nextInt(folders.size())];
				ResourceLocation panoramaLoc = new ResourceLocation(MODID, "panoramas/" + chosenPanorama + "/panorama");
				ResourceLocation[] ResourceLocationsArray = new ResourceLocation[6];
				for (int i = 0; i < 6; ++i) {
					ResourceLocationsArray[i] = new ResourceLocation(panoramaLoc.getNamespace(), panoramaLoc.getPath() + '_' + i + ".png");
				}
				ObfuscationReflectionHelper.setPrivateValue(RenderSkyboxCube.class, MainMenuScreen.PANORAMA_RESOURCES, ResourceLocationsArray, "field_209143_a");
			}
		}
	}

	private static Set<String> getSubfoldersFromDirectory(ModFile modFile, String directoryName) {
		try {
			Path root = modFile.getLocator().findPath(modFile, directoryName).toAbsolutePath();
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


	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class PHFWorldGenRegistries {

		@SubscribeEvent
		public static void registerBiomes(RegistryEvent.Register<Biome> event) {
			LOGGER.debug("PHF: Registering biomes...");
			PHFBiomes.init();
			PHFBiomes.biomes.sort(Comparator.comparingInt(PHFBiomes.PreserveBiomeOrder::getOrderPosition));
			PHFBiomes.biomes.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
			LOGGER.info("PHF: Biomes registered!");
		}

		@SubscribeEvent
		public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
			LOGGER.debug("PHF: Registering decorators...");
			PHFDecorators.init();
			PHFDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
			LOGGER.info("PHF: Decorators registered!");
		}

		@SubscribeEvent
		public static void registerStructures(RegistryEvent.Register<Feature<?>> event) {
			LOGGER.debug("PHF: Registering structures...");
			PHFStructures.init();
			//            PHFStructures.structures.forEach(structure -> event.getRegistry().register(structure));
			//            Structure.STRUCTURE_DECORATION_STAGE_MAP.forEach(((structure, decoration) -> System.out.println(Registry.STRUCTURE_FEATURE.getKey(structure).toString())));
			LOGGER.info("PHF: Structures registered!");
		}

		@SubscribeEvent
		public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
			LOGGER.debug("PHF: Registering features...");
			PHFFeatures.init();
			PHFFeatures.features.forEach(feature -> event.getRegistry().register(feature));
			LOGGER.info("PHF: Features registered!");
		}

		@SubscribeEvent
		public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
			LOGGER.debug("PHF: Registering surface builders...");
			PHFSurfaceBuilders.init();
			PHFSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
			LOGGER.info("PHF: Surface builders Registered!");
		}
	}

	public static class ServerEvents {
		@SubscribeEvent
		public void commandRegisterEvent(FMLServerStartingEvent event) {
			LOGGER.debug("Prehistoric Fauna: \"Server Starting\" Event Starting...");
			PHFCommand.register(event.getCommandDispatcher());
			LOGGER.info("Prehistoric Fauna: \"Server Starting\" Event Complete!");
		}
	}
	
}
