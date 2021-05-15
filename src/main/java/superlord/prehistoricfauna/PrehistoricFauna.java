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

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.ILightReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
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
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.packs.ModFileResourcePack;
import net.minecraftforge.fml.packs.ResourcePackLoader;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import superlord.prehistoricfauna.config.PrehistoricConfigHolder;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.core.world.*;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;
import superlord.prehistoricfauna.entity.render.*;
import superlord.prehistoricfauna.entity.tile.MessageUpdatePaleoscribe;
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
import superlord.prehistoricfauna.util.PFWoodTypes;
import superlord.prehistoricfauna.util.PrehistoricColors;
import superlord.prehistoricfauna.util.QuarkFlagRecipeCondition;
import superlord.prehistoricfauna.util.RegistryHelper;
import superlord.prehistoricfauna.world.PrehistoricFeature;

@SuppressWarnings("deprecation")
@Mod(PrehistoricFauna.MODID)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.MOD)
public class PrehistoricFauna {

	public final static String MODID = "prehistoricfauna";
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel NETWORK_WRAPPER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation("prehistoricfauna", "main_channel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();
	public static Logger LOGGER = LogManager.getLogger();
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);


	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	private static int packetsRegistered = 0;

	public PrehistoricFauna() {
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);
		modEventBus.addListener(this::spaceTimeContinuumWarping);
		modEventBus.addListener(this::chickenExtinction);
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, PrehistoricConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, PrehistoricConfigHolder.SERVER_SPEC);
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
		List<Structure<?>> tempList = new ArrayList<>(Feature.ILLAGER_STRUCTURES);
		tempList.add(PrehistoricFeature.TIME_TEMPLE);
		Feature.ILLAGER_STRUCTURES = ImmutableList.copyOf(tempList);
		MinecraftForge.EVENT_BUS.register(new CommonEvents());
		PFFeatureRegistration.addFeatures();
		PROXY.setup();
		addBiomeFeatures();
		PHFOverworldBiomeRegistry.addBiomesToWeightSystem();
		Collections.sort(PHFOverworldBiomeRegistry.biomeList);
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdatePaleoscribe.class, MessageUpdatePaleoscribe::write, MessageUpdatePaleoscribe::read, MessageUpdatePaleoscribe.Handler::handle);
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

	@SuppressWarnings("unchecked")
	private void doClientStuff(final FMLClientSetupEvent event) {
		trySetRandomPanorama();
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228064_0_, p_228064_1_, p_228064_2_, p_228064_3_) -> {
			return p_228064_1_ != null && p_228064_2_ != null ? BiomeColors.getGrassColor(p_228064_1_, p_228064_2_) : GrassColors.get(0.5D, 1.0D);
		}, BlockInit.CONIOPTERIS, BlockInit.CLADOPHLEBIS, BlockInit.POTTED_CLADOPHLEBIS);
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
			return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
		}, BlockInit.METASEQUOIA_LEAVES, BlockInit.PROTOPICEOXYLON_LEAVES, BlockInit.PROTOJUNIPER_LEAVES, BlockInit.METASEQUOIA_LEAF_CARPET.get(), BlockInit.PROTOPICEOXYLON_LEAF_CARPET.get(), BlockInit.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
			return PrehistoricColors.getAraucaria();
		}, BlockInit.ARAUCARIA_LEAVES, BlockInit.ARAUCARIA_LEAF_CARPET.get());
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().getDefaultState();
			return blockcolors.getColor(blockstate, (ILightReader) null, (BlockPos) null, p_210235_2_);
		}, BlockInit.ARAUCARIA_LEAVES, BlockInit.METASEQUOIA_LEAVES, BlockInit.CONIOPTERIS, BlockInit.PROTOPICEOXYLON_LEAVES, BlockInit.PROTOJUNIPER_LEAVES, BlockInit.CLADOPHLEBIS, BlockInit.ARAUCARIA_LEAF_CARPET.get(), BlockInit.METASEQUOIA_LEAF_CARPET.get(), BlockInit.PROTOPICEOXYLON_LEAF_CARPET.get(), BlockInit.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.THESCELOSAURUS_ENTITY, ThescelosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TRICERATOPS_ENTITY, manager -> new TriceratopsRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANKYLOSAURUS_ENTITY, AnkylosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANNOSAURUS_ENTITY, manager -> new TyrannosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BASILEMYS_ENTITY, manager -> new BasilemysRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DAKOTARAPTOR_ENTITY, manager -> new DakotaraptorRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALLOSAURUS_ENTITY, manager -> new AllosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEGOSAURUS_ENTITY, StegosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CERATOSAURUS_ENTITY, manager -> new CeratosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DRYOSAURUS_ENTITY, DryosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HESPERORNITHOIDES_ENTITY, manager -> new HesperornithoidesRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EILENODON_ENTITY, manager -> new EilenodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CAMARASAURUS_ENTITY, manager -> new CamarasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DIDELPHODON_ENTITY, manager -> new DidelphodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BOAT, PrehistoricBoatRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EXAERETODON_ENTITY, manager -> new ExaeretodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHROMOGISAURUS_ENTITY, manager -> new ChromogisaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HERRERASAURUS_ENTITY, manager -> new HerrerasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HYPERODAPEDON_ENTITY, manager -> new HyperodapedonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SILLOSUCHUS_ENTITY, manager -> new SillosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TIME_GUARDIAN_ENTITY, BossRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SAUROSUCHUS_ENTITY, manager -> new SaurosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISCHIGUALASTIA_ENTITY, manager -> new IschigualastiaRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALL_FOSSIL, WallFossilRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANNOSAURUS_SKULL, TyrannosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANKYLOSAURUS_SKULL, AnkylosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TRICERATOPS_SKULL, TriceratopsSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HERRERASAURUS_SKULL, HerrerasaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SAUROSUCHUS_SKULL, SaurosuchusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEGOSAURUS_SKULL, StegosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CERATOSAURUS_SKULL, CeratosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANNOSAURUS_SKELETON, manager -> new TyrannosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TRICERATOPS_SKELETON, manager -> new TriceratopsSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANKYLOSAURUS_SKELETON, manager -> new AnkylosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CERATOSAURUS_SKELETON, manager -> new CeratosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALLOSAURUS_SKELETON, manager -> new AllosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HERRERASAURUS_SKELETON, manager -> new HerrerasaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISCHIGUALASTIA_SKELETON, manager -> new IschigualastiaSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SAUROSUCHUS_SKELETON, manager -> new SaurosuchusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALLOSAURUS_SKULL, AllosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISCHIGUALASTIA_SKULL, IschigualastiaSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PALEOPAINTING, PaleopaintingRenderer::new);
		ScreenManager.registerFactory(ContainerRegistry.PALEONTOLOGY_TABLE.get(), PaleontologyTableScreen::new);
		ScreenManager.registerFactory(ContainerRegistry.PALEOSCRIBE_CONTAINER, PaleoscribeScreen::new);
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	public static <MSG> void sendMSGToServer(MSG message) {
		NETWORK_WRAPPER.sendToServer(message);
	}

	public static <MSG> void sendMSGToAll(MSG message) {
		for (ServerPlayerEntity player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
			sendNonLocal(message, player);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static <MSG> void sendNonLocal(MSG msg, ServerPlayerEntity player) {
		if (player.server.isDedicatedServer() || !player.getName().equals(player.server.getServerOwner())) {
			NETWORK_WRAPPER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		//		PrehistoricOreGen.generateOre();
	}

	public static class PFPlants extends ItemGroup {
		public static final PFPlants instance = new PFPlants(ItemGroup.GROUPS.length, "prehistoric_plants_tab");

		private PFPlants(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.HORSETAIL);
		}
	}

	public static class PFBook extends ItemGroup {
		public static final PFBook instance = new PFBook(ItemGroup.GROUPS.length, "prehistoric_book_tab");

		private PFBook(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.PALEOPEDIA.get());
		}

	}

	public static class PFWood extends ItemGroup {
		public static final PFWood instance = new PFWood(ItemGroup.GROUPS.length, "prehistoric_wood_tab");

		private PFWood(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.ARAUCARIA_LOG);
		}
	}

	public static class PFEntities extends ItemGroup {
		public static final PFEntities instance = new PFEntities(ItemGroup.GROUPS.length, "prehistoric_entities_tab");

		private PFEntities(int index, String label) {
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

	public static class PFStone extends ItemGroup {
		public static final PFStone instance = new PFStone(ItemGroup.GROUPS.length, "prehistoric_stone_tab");

		private PFStone(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.CHISELED_POLISHED_TRIASSIC_SANDSTONE);
		}

	}

	public static class PFFossil extends ItemGroup {
		public static final PFFossil instance = new PFFossil(ItemGroup.GROUPS.length, "prehistoric_fossil_tab");

		private PFFossil(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.LARGE_AMMONITE_SHELL);
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

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		ClientRegistry.bindTileEntityRenderer(TileEntityRegistry.PF_SIGNS.get(), PFSignTileEntityRenderer::new);
	}

	@SubscribeEvent
	public static void onStitchEvent(TextureStitchEvent.Pre event) {
		ResourceLocation stitching = event.getMap().getTextureLocation();
		if (!stitching.equals(Atlases.SIGN_ATLAS))
			return;

		PFWoodTypes.getValues().forEach(woodType -> event.addSprite(new ResourceLocation(PrehistoricFauna.MODID, "entities/signs/" + woodType.getName())));
	}

}
