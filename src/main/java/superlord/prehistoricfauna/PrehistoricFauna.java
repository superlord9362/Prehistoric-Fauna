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

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.ILightReader;
import net.minecraft.world.World;
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
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BlockEvent;
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
import superlord.prehistoricfauna.entity.TimeGuardianEntity;
import superlord.prehistoricfauna.entity.render.*;
import superlord.prehistoricfauna.entity.tile.MessageUpdatePaleoscribe;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ContainerRegistry;
import superlord.prehistoricfauna.init.DimensionInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.init.ParticleInit;
import superlord.prehistoricfauna.init.PrehistoricPointofInterest;
import superlord.prehistoricfauna.init.PrehistoricProfessionInit;
import superlord.prehistoricfauna.init.TileEntityRegistry;
import superlord.prehistoricfauna.recipes.RecipeRegistry;
import superlord.prehistoricfauna.server.command.PHFCommand;
import superlord.prehistoricfauna.util.ClientProxy;
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
		}, BlockInit.CONIOPTERIS.get(), BlockInit.CLADOPHLEBIS.get(), BlockInit.POTTED_CLADOPHLEBIS.get());
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
			return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
		}, BlockInit.METASEQUOIA_LEAVES.get(), BlockInit.PROTOPICEOXYLON_LEAVES.get(), BlockInit.PROTOJUNIPEROXYLON_LEAVES.get(), BlockInit.METASEQUOIA_LEAF_CARPET.get(), BlockInit.PROTOPICEOXYLON_LEAF_CARPET.get(), BlockInit.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
			return PrehistoricColors.getAraucaria();
		}, BlockInit.ARAUCARIA_LEAVES.get(), BlockInit.ARAUCARIA_LEAF_CARPET.get());
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().getDefaultState();
			return blockcolors.getColor(blockstate, (ILightReader) null, (BlockPos) null, p_210235_2_);
		}, BlockInit.ARAUCARIA_LEAVES.get(), BlockInit.METASEQUOIA_LEAVES.get(), BlockInit.CONIOPTERIS.get(), BlockInit.PROTOPICEOXYLON_LEAVES.get(), BlockInit.PROTOJUNIPEROXYLON_LEAVES.get(), BlockInit.CLADOPHLEBIS.get(), BlockInit.ARAUCARIA_LEAF_CARPET.get(), BlockInit.METASEQUOIA_LEAF_CARPET.get(), BlockInit.PROTOPICEOXYLON_LEAF_CARPET.get(), BlockInit.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
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
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEGOSAURUS_SKELETON, manager -> new StegosaurusSkeletonRenderer());
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
			return new ItemStack(BlockInit.ARAUCARIA_LOG.get());
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
			return new ItemStack(BlockInit.LARGE_AMMONITE_SHELL.get().asItem());
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
	
	static class CommonEvents {

		public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();
		public static Map<Block, Block> ROCK_SMASHING_MAP = new HashMap<>();

		static {
			BLOCK_STRIPPING_MAP.put(BlockInit.METASEQUOIA_LOG.get(), BlockInit.STRIPPED_METASEQUOIA_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.METASEQUOIA_WOOD.get(), BlockInit.STRIPPED_METASEQUOIA_WOOD.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.ARAUCARIA_LOG.get(), BlockInit.STRIPPED_ARAUCARIA_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.ARAUCARIA_WOOD.get(), BlockInit.STRIPPED_ARAUCARIA_WOOD.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.PROTOPICEOXYLON_LOG.get(), BlockInit.STRIPPED_PROTOPICEOXYLON_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.PROTOPICEOXYLON_WOOD.get(), BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.ZAMITES_LOG.get(), BlockInit.STRIPPED_ZAMITES_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.ZAMITES_WOOD.get(), BlockInit.STRIPPED_ZAMITES_WOOD.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.PROTOJUNIPEROXYLON_LOG.get(), BlockInit.STRIPPED_PROTOJUNIPEROXYLON_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.PROTOJUNIPEROXYLON_WOOD.get(), BlockInit.STRIPPED_PROTOJUNIPEROXYLON_WOOD.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.HEIDIPHYLLUM_LOG.get(), BlockInit.STRIPPED_HEIDIPHYLLUM_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.HEIDIPHYLLUM_WOOD.get(), BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.LIRIODENDRITES_LOG.get(), BlockInit.STRIPPED_LIRIODENDRITES_LOG.get());
			BLOCK_STRIPPING_MAP.put(BlockInit.LIRIODENDRITES_WOOD.get(), BlockInit.STRIPPED_LIRIODENDRITES_WOOD.get());
			ROCK_SMASHING_MAP.put(Blocks.STONE, Blocks.COBBLESTONE);
			ROCK_SMASHING_MAP.put(Blocks.COBBLESTONE, Blocks.GRAVEL);
			ROCK_SMASHING_MAP.put(Blocks.SANDSTONE, Blocks.SAND);
			ROCK_SMASHING_MAP.put(Blocks.RED_SANDSTONE, Blocks.RED_SAND);
			ROCK_SMASHING_MAP.put(Blocks.SMOOTH_RED_SANDSTONE, Blocks.RED_SANDSTONE);
			ROCK_SMASHING_MAP.put(BlockInit.SMOOTH_CHALK.get(), BlockInit.CHALK.get());
			ROCK_SMASHING_MAP.put(BlockInit.SMOOTH_SILTSTONE.get(), BlockInit.SILTSTONE.get());
			ROCK_SMASHING_MAP.put(BlockInit.SMOOTH_SANDSTONE.get(), BlockInit.SANDSTONE.get());
			ROCK_SMASHING_MAP.put(Blocks.SMOOTH_SANDSTONE, Blocks.SANDSTONE);
			ROCK_SMASHING_MAP.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
			ROCK_SMASHING_MAP.put(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE);
			ROCK_SMASHING_MAP.put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE);
			ROCK_SMASHING_MAP.put(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE);
			ROCK_SMASHING_MAP.put(BlockInit.POLISHED_CHALK.get(), BlockInit.CHALK.get());
			ROCK_SMASHING_MAP.put(BlockInit.POLISHED_SILTSTONE.get(), BlockInit.SILTSTONE.get());
			ROCK_SMASHING_MAP.put(BlockInit.POLISHED_SANDSTONE.get(), BlockInit.SANDSTONE.get());
			ROCK_SMASHING_MAP.put(Blocks.BLACK_CONCRETE, Blocks.BLACK_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.BLUE_CONCRETE, Blocks.BLUE_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.BROWN_CONCRETE, Blocks.BROWN_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.CYAN_CONCRETE, Blocks.CYAN_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.GRAY_CONCRETE, Blocks.GRAY_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.GREEN_CONCRETE, Blocks.GREEN_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.LIME_CONCRETE, Blocks.LIME_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.PINK_CONCRETE, Blocks.PINK_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.RED_CONCRETE, Blocks.RED_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.WHITE_CONCRETE, Blocks.WHITE_CONCRETE_POWDER);
			ROCK_SMASHING_MAP.put(Blocks.YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE_POWDER);
			//BLOCK_STRIPPING_MAP.put(BlockInit.CYPRESS_LOG, BlockInit.STRIPPED_CYPRESS_LOG);
			//BLOCK_STRIPPING_MAP.put(BlockInit.CYPRESS_WOOD, BlockInit.STRIPPED_CYPRESS_WOOD);
		}

		public static void setup() {
			registerFlammable(BlockInit.ARAUCARIA_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.METASEQUOIA_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.ARAUCARIA_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.METASEQUOIA_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.ARAUCARIA_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.METASEQUOIA_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.ARAUCARIA_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.METASEQUOIA_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.ARAUCARIA_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.METASEQUOIA_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.PROTOPICEOXYLON_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.PROTOPICEOXYLON_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.PROTOPICEOXYLON_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.PROTOPICEOXYLON_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.PROTOPICEOXYLON_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.ZAMITES_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.ZAMITES_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.ZAMITES_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.ZAMITES_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.ZAMITES_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.HEIDIPHYLLUM_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.HEIDIPHYLLUM_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.HEIDIPHYLLUM_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.HEIDIPHYLLUM_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.HEIDIPHYLLUM_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.LIRIODENDRITES_PLANKS.get(), 5, 20);
			registerFlammable(BlockInit.LIRIODENDRITES_SLAB.get(), 5, 20);
			registerFlammable(BlockInit.LIRIODENDRITES_FENCE.get(), 5, 20);
			registerFlammable(BlockInit.LIRIODENDRITES_FENCE_GATE.get(), 5, 20);
			registerFlammable(BlockInit.LIRIODENDRITES_STAIRS.get(), 5, 20);
			registerFlammable(BlockInit.ARAUCARIA_LOG.get(), 5, 5);
			registerFlammable(BlockInit.METASEQUOIA_LOG.get(), 5, 5);
			registerFlammable(BlockInit.METASEQUOIA_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_ARAUCARIA_LOG.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_METASEQUOIA_LOG.get(), 5, 5);
			registerFlammable(BlockInit.ARAUCARIA_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.METASEQUOIA_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_ARAUCARIA_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_METASEQUOIA_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.PROTOPICEOXYLON_LOG.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_PROTOPICEOXYLON_LOG.get(), 5, 5);
			registerFlammable(BlockInit.PROTOPICEOXYLON_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.ZAMITES_LOG.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_ZAMITES_LOG.get(), 5, 5);
			registerFlammable(BlockInit.ZAMITES_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_ZAMITES_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_LOG.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_PROTOJUNIPEROXYLON_LOG.get(), 5, 5);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_PROTOJUNIPEROXYLON_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.HEIDIPHYLLUM_LOG.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_HEIDIPHYLLUM_LOG.get(), 5, 5);
			registerFlammable(BlockInit.HEIDIPHYLLUM_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.LIRIODENDRITES_LOG.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_LIRIODENDRITES_LOG.get(), 5, 5);
			registerFlammable(BlockInit.LIRIODENDRITES_WOOD.get(), 5, 5);
			registerFlammable(BlockInit.STRIPPED_LIRIODENDRITES_WOOD.get(), 5, 5);
			//registerFlammable(BlockInit.CYPRESS_LOG, 5, 5);
			//registerFlammable(BlockInit.STRIPPED_CYPRESS_LOG, 5, 5);
			//registerFlammable(BlockInit.CYPRESS_WOOD, 5, 5);
			//registerFlammable(BlockInit.STRIPPED_CYPRESS_WOOD, 5, 5);
			registerFlammable(BlockInit.ARAUCARIA_LEAVES.get(), 30, 60);
			registerFlammable(BlockInit.METASEQUOIA_LEAVES.get(), 30, 60);
			registerFlammable(BlockInit.PROTOPICEOXYLON_LEAVES.get(), 30, 60);
			registerFlammable(BlockInit.ZAMITES_LEAVES.get(), 30, 60);
			registerFlammable(BlockInit.PROTOJUNIPEROXYLON_LEAVES.get(), 30, 60);
			registerFlammable(BlockInit.HEIDIPHYLLUM_LEAVES.get(), 30, 60);
			registerFlammable(BlockInit.LIRIODENDRITES_LEAVES.get(), 30, 60);;
			//registerFlammable(BlockInit.CYPRESS_LEAVES, 30, 60);
			registerFlammable(BlockInit.CLUBMOSS.get(), 60, 100);
			registerFlammable(BlockInit.HORSETAIL.get(), 60, 100);
			registerFlammable(BlockInit.OSMUNDA.get(), 60, 100);
			registerFlammable(BlockInit.OSMUNDACAULIS.get(), 60, 100);
			registerFlammable(BlockInit.DEAD_OSMUNDACAULIS.get(), 60, 100);
			registerFlammable(BlockInit.MARCHANTIA.get(), 60, 100);
			registerFlammable(BlockInit.TALL_HORSETAIL.get(), 60, 100);
			registerFlammable(BlockInit.TALL_OSMUNDA.get(), 60, 100);
			registerFlammable(BlockInit.CONIOPTERIS.get(), 60, 100);
			registerFlammable(BlockInit.TALL_OSMUNDACAULIS.get(), 60, 100);
			registerFlammable(BlockInit.MOSS_CARPET.get(), 60, 20);
			registerFlammable(BlockInit.MOSS_BLOCK.get(), 60, 20);
			registerCompostable(0.3F, BlockInit.ARAUCARIA_LEAVES.get());
			registerCompostable(0.3F, BlockInit.METASEQUOIA_LEAVES.get());
			registerCompostable(0.3F, BlockInit.PROTOPICEOXYLON_LEAVES.get());
			registerCompostable(0.3F, BlockInit.ZAMITES_LEAVES.get());
			registerCompostable(0.3F, BlockInit.PROTOJUNIPEROXYLON_LEAVES.get());
			registerCompostable(0.3F, BlockInit.HEIDIPHYLLUM_LEAVES.get());
			registerCompostable(0.3F, BlockInit.LIRIODENDRITES_LEAVES.get());
			//registerCompostable(0.3F, BlockInit.CYPRESS_LEAVES);
			registerCompostable(0.3F, BlockInit.ARAUCARIA_SAPLING.get());
			registerCompostable(0.3F, BlockInit.METASEQUOIA_SAPLING.get());
			registerCompostable(0.3F, BlockInit.PROTOPICEOXYLON_SAPLING.get());
			registerCompostable(0.3F, BlockInit.ZAMITES_SAPLING.get());
			registerCompostable(0.3F, BlockInit.PROTOJUNIPEROXYLON_SAPLING.get());
			registerCompostable(0.3F, BlockInit.HEIDIPHYLLUM_SAPLING.get());
			registerCompostable(0.3F, BlockInit.LIRIODENDRITES_SAPLING.get());
			//registerCompostable(0.3F, BlockInit.CYPRESS_SAPLING);
			registerCompostable(0.3F, BlockInit.HORSETAIL.get());
			registerCompostable(0.3F, BlockInit.OSMUNDA.get());
			registerCompostable(0.3F, BlockInit.CONIOPTERIS.get());
			registerCompostable(0.3F, BlockInit.OSMUNDACAULIS.get());
			registerCompostable(0.5F, BlockInit.TALL_HORSETAIL.get());
			registerCompostable(0.5F, BlockInit.TALL_OSMUNDA.get());
			registerCompostable(0.5F, BlockInit.TALL_OSMUNDACAULIS.get());
			registerCompostable(0.65F, BlockInit.CLUBMOSS.get());
			registerCompostable(0.65F, BlockInit.MARCHANTIA.get());
		}

		public static void registerFlammable(Block block, int encouragement, int flammability) {
			FireBlock fireblock = (FireBlock)Blocks.FIRE;
			fireblock.setFireInfo(block, encouragement, flammability);
		}

		public static void registerCompostable(float chance, IItemProvider item) {
			ComposterBlock.CHANCES.put(item.asItem(), chance);
		}

		@SubscribeEvent
		public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
			if(event.getItemStack().getItem() instanceof AxeItem) {
				World world = event.getWorld();
				BlockPos pos = event.getPos();
				BlockState state = world.getBlockState(pos);
				Block block = BLOCK_STRIPPING_MAP.get(state.getBlock());
				if(block != null) {
					PlayerEntity entity = event.getPlayer();
					world.playSound(entity, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
					if(!world.isRemote) {
						world.setBlockState(pos, block.getDefaultState().with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);
						if(entity != null) {
							event.getItemStack().damageItem(1, entity, (p_220040_1_) -> {
								p_220040_1_.sendBreakAnimation(event.getHand());
							});
						}
					}
				}
			}
			if(event.getItemStack().getItem() == ItemInit.GEOLOGY_HAMMER.get() && PrehistoricFaunaConfig.geologyHammerMining == true) {
				World world = event.getWorld();
				BlockPos pos = event.getPos();
				BlockState state = world.getBlockState(pos);
				Block block = ROCK_SMASHING_MAP.get(state.getBlock());
				if(block != null) {
					PlayerEntity entity = event.getPlayer();
					world.playSound(entity, pos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 0.7D;
					double d2 = (double)pos.getZ() + 0.5D;
					world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					if(!world.isRemote) {
						world.setBlockState(pos, block.getDefaultState(), 11);
						if(entity != null) {
							event.getItemStack().damageItem(1, entity, (p_220040_1_) -> {
								p_220040_1_.sendBreakAnimation(event.getHand());
							});
						}
					}
				}
			}
		}

		public static void init() {
			if (PrehistoricFaunaConfig.geologyHammerMining == true) {
				DispenserBlock.registerDispenseBehavior(ItemInit.GEOLOGY_HAMMER.get().asItem(), new OptionalDispenseBehavior() {
					protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
						World world = source.getWorld();
						if (!world.isRemote()) {
							this.successful = false;
							BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
							if (!this.successful) {
								BlockState blockstate = world.getBlockState(blockpos);
								if (blockstate.getBlock() == Blocks.STONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.COBBLESTONE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.COBBLESTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.GRAVEL.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.SANDSTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.SAND.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.RED_SANDSTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.RED_SAND.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.SMOOTH_RED_SANDSTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.RED_SANDSTONE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.SMOOTH_SANDSTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.SANDSTONE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.STONE_BRICKS) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.CRACKED_STONE_BRICKS.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.CRACKED_STONE_BRICKS) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.COBBLESTONE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.CUT_RED_SANDSTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.RED_SANDSTONE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.CUT_SANDSTONE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.SANDSTONE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.BLACK_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.BLUE_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.BLUE_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.BROWN_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.BROWN_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.CYAN_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.CYAN_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.GRAY_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.GRAY_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.GREEN_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.GREEN_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.LIGHT_BLUE_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.LIGHT_GRAY_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.LIGHT_GRAY_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.LIME_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.LIME_CONCRETE.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.MAGENTA_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.ORANGE_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.ORANGE_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.PINK_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.PINK_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.PURPLE_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.PURPLE_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.RED_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.RED_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.WHITE_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.WHITE_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == Blocks.BLACK_CONCRETE) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == BlockInit.POLISHED_CHALK.get()) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, BlockInit.CHALK.get().getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == BlockInit.POLISHED_SILTSTONE.get()) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, BlockInit.SILTSTONE.get().getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == BlockInit.POLISHED_SANDSTONE.get()) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, BlockInit.SANDSTONE.get().getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == BlockInit.SMOOTH_CHALK.get()) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, BlockInit.CHALK.get().getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == BlockInit.SMOOTH_SILTSTONE.get()) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, BlockInit.SILTSTONE.get().getDefaultState());
									this.successful = true;
								}
								if (blockstate.getBlock() == BlockInit.SMOOTH_SANDSTONE.get()) {
									if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
										stack.setCount(0);
									}
									world.setBlockState(blockpos, BlockInit.SANDSTONE.get().getDefaultState());
									this.successful = true;
								}
							}
						}

						return stack;
					}
				});
			}
		}

		@SubscribeEvent
		public void onVillagerTrades(VillagerTradesEvent event) {
			if (event.getType() == PrehistoricProfessionInit.GEOLOGIST) {
				PrehistoricProfessionInit.addGeologistTrades(event.getTrades());
			}
		}

		public static boolean trySpawnGolem(final World world, final BlockPos headPos) {
			if (world.isRemote) {
				return false;
			}
			final BlockState stateBelow1 = world.getBlockState(headPos.down(1));
			final BlockState stateBelow2 = world.getBlockState(headPos.down(2));
			final BlockState stateArmNorth = world.getBlockState(headPos.down(1).north(1));
			final BlockState stateArmSouth = world.getBlockState(headPos.down(1).south(1));
			final BlockState stateArmEast = world.getBlockState(headPos.down(1).east(1));
			final BlockState stateArmWest = world.getBlockState(headPos.down(1).west(1));

			final double spawnX = headPos.getX() + 0.5D;
			final double spawnY = headPos.getY() - 1.95D;
			final double spawnZ = headPos.getZ() + 0.5D;


			if(stateBelow1 == Blocks.EMERALD_BLOCK.getDefaultState() && stateBelow2 == BlockInit.HENOSTONE.get().getDefaultState() && stateArmNorth == BlockInit.HENOSTONE.get().getDefaultState() && stateArmSouth == BlockInit.HENOSTONE.get().getDefaultState()) {
				final TimeGuardianEntity timeGuardianEntity = ModEntityTypes.TIME_GUARDIAN_ENTITY.create(world);
				timeGuardianEntity.setSummoned(true);
				timeGuardianEntity.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
				world.addEntity(timeGuardianEntity);
				world.setBlockState(headPos.down(1), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos.down(2), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos.down(1).north(1), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos.down(1).south(1), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos, Blocks.AIR.getDefaultState());
				return true;
			}
			if(stateBelow1 == Blocks.EMERALD_BLOCK.getDefaultState() && stateBelow2 == BlockInit.HENOSTONE.get().getDefaultState() && stateArmEast == BlockInit.HENOSTONE.get().getDefaultState() && stateArmWest == BlockInit.HENOSTONE.get().getDefaultState()) {
				final TimeGuardianEntity timeGuardianEntity = ModEntityTypes.TIME_GUARDIAN_ENTITY.create(world);
				timeGuardianEntity.setSummoned(true);
				timeGuardianEntity.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
				world.addEntity(timeGuardianEntity);
				world.setBlockState(headPos.down(1), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos.down(2), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos.down(1).east(1), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos.down(1).west(1), Blocks.AIR.getDefaultState());
				world.setBlockState(headPos, Blocks.AIR.getDefaultState());
				return true;
			}
			return false;
		}

		@SubscribeEvent
		public void summonHenosEvent(BlockEvent.EntityPlaceEvent event) {
			if (!event.isCanceled() && event.getPlacedBlock().getBlock() == BlockInit.LARGE_AMMONITE_SHELL.get() && event.getWorld() instanceof World) {
				trySpawnGolem((World) event.getWorld(), event.getPos());
			}
		}

	}

}
