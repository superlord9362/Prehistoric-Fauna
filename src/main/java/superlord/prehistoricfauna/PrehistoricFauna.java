package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.packs.ModFileResourcePack;
import net.minecraftforge.fml.packs.ResourcePackLoader;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import superlord.prehistoricfauna.client.ClientProxy;
import superlord.prehistoricfauna.client.render.tileentity.PFSignTileEntityRenderer;
import superlord.prehistoricfauna.client.util.PFPacketHandler;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.common.entities.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.AllosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.AllosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.AnkylosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.BasilemysEntity;
import superlord.prehistoricfauna.common.entities.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.HerrerasaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.HerrerasaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.HyperodapedonEntity;
import superlord.prehistoricfauna.common.entities.IschigualastiaEntity;
import superlord.prehistoricfauna.common.entities.IschigualastiaSkeletonEntity;
import superlord.prehistoricfauna.common.entities.IschigualastiaSkullEntity;
import superlord.prehistoricfauna.common.entities.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.SillosuchusEntity;
import superlord.prehistoricfauna.common.entities.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.StegosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.StegosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;
import superlord.prehistoricfauna.common.entities.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.TriceratopsSkeletonEntity;
import superlord.prehistoricfauna.common.entities.TriceratopsSkullEntity;
import superlord.prehistoricfauna.common.entities.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.TyrannosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.TyrannosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.tile.MessageUpdatePaleoscribe;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.common.world.PFFeatures;
import superlord.prehistoricfauna.common.world.PFSurfaceBuilders;
import superlord.prehistoricfauna.compat.QuarkFlagRecipeCondition;
import superlord.prehistoricfauna.config.PFConfigHolder;
import superlord.prehistoricfauna.init.PFBiomes;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFContainers;
import superlord.prehistoricfauna.init.PFDecorators;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFOverworldBiomes;
import superlord.prehistoricfauna.init.PFRecipes;
import superlord.prehistoricfauna.init.PFTileEntities;

@Mod(PrehistoricFauna.MOD_ID)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class PrehistoricFauna {

	public static final String MOD_ID = "prehistoricfauna";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel NETWORK_WRAPPER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation("prehistoricfauna", "main_channel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();

	private static int packetsRegistered = 0;

	public static CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public PrehistoricFauna() {
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::registerCommon);
		modEventBus.addListener(this::doClientStuff);
		modEventBus.addListener(this::setup);
		CraftingHelper.register(new QuarkFlagRecipeCondition.Serializer());
		PFRecipes.RECIPES.register(modEventBus);
		REGISTRY_HELPER.getDeferredBlockRegister().register(modEventBus);
		REGISTRY_HELPER.getDeferredItemRegister().register(modEventBus);
		PFBlocks.REGISTER.register(modEventBus);
		PFItems.REGISTER.register(modEventBus);
		PFTileEntities.TILE_ENTITY_TYPES.register(modEventBus);
		PFContainers.CONTAINER_TYPES.register(modEventBus);
		PFEntities.ENTITY_TYPES.register(modEventBus);
		PFPacketHandler.registerPackets();
		PROXY.init();

		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, PFConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, PFConfigHolder.SERVER_SPEC);
	}

	private void registerCommon(FMLCommonSetupEvent event) {
		registerEntityAttributes();
	}

	public void setup(final FMLCommonSetupEvent event) {
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdatePaleoscribe.class, MessageUpdatePaleoscribe::write, MessageUpdatePaleoscribe::read, MessageUpdatePaleoscribe.Handler::handle);
		event.enqueueWork(() -> {
			PFBiomes.addBiomeEntries();
			PFBiomes.fillBiomeDictionary();
			PFOverworldBiomes.addBiomeEntries();
			PFOverworldBiomes.fillBiomeDictionary();
			System.out.println("Added biomes!");
		});
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		trySetRandomPanorama();
	}

	private void registerEntityAttributes() {
		GlobalEntityTypeAttributes.put(PFEntities.ALLOSAURUS_ENTITY, AllosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ALLOSAURUS_SKELETON, AllosaurusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ALLOSAURUS_SKULL, AllosaurusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ANKYLOSAURUS_ENTITY, AnkylosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ANKYLOSAURUS_SKELETON, AnkylosaurusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ANKYLOSAURUS_SKULL, AnkylosaurusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.BASILEMYS_ENTITY, BasilemysEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CAMARASAURUS_ENTITY, CamarasaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CERATOSAURUS_ENTITY, CeratosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CERATOSAURUS_SKELETON, CeratosaurusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CERATOSAURUS_SKULL, CeratosaurusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CHROMOGISAURUS_ENTITY, ChromogisaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DAKOTARAPTOR_ENTITY, DakotaraptorEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DIDELPHODON_ENTITY, DidelphodonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DRYOSAURUS_ENTITY, DryosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.EILENODON_ENTITY, EilenodonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.EXAERETODON_ENTITY, ExaeretodonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.HERRERASAURUS_ENTITY, HerrerasaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.HERRERASAURUS_SKELETON, HerrerasaurusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.HERRERASAURUS_SKULL, HerrerasaurusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.HESPERORNITHOIDES_ENTITY, HesperornithoidesEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.HYPERODAPEDON_ENTITY, HyperodapedonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ISCHIGUALASTIA_ENTITY, IschigualastiaEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ISCHIGUALASTIA_SKELETON, IschigualastiaSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ISCHIGUALASTIA_SKULL, IschigualastiaSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SAUROSUCHUS_ENTITY, SaurosuchusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SAUROSUCHUS_SKELETON, SaurosuchusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SAUROSUCHUS_SKULL, SaurosuchusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SILLOSUCHUS_ENTITY, SillosuchusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.STEGOSAURUS_ENTITY, StegosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.STEGOSAURUS_SKELETON, StegosaurusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.STEGOSAURUS_SKULL, StegosaurusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.THESCELOSAURUS_ENTITY, ThescelosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TIME_GUARDIAN_ENTITY, TimeGuardianEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TRICERATOPS_ENTITY, TriceratopsEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TRICERATOPS_SKELETON, TriceratopsSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TRICERATOPS_SKULL, TriceratopsSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TYRANNOSAURUS_ENTITY, TyrannosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TYRANNOSAURUS_SKELETON, TyrannosaurusSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TYRANNOSAURUS_SKULL, TyrannosaurusSkullEntity.createAttributes().create());
	}

	@OnlyIn(Dist.CLIENT)
	public static void trySetRandomPanorama() {
		Optional<ModFileResourcePack> optionalResourcePack = ResourcePackLoader.getResourcePackFor(MOD_ID);
		if (optionalResourcePack.isPresent()) {
			ModFileResourcePack resourcePack = optionalResourcePack.get();
			Set<String> folders = getSubfoldersFromDirectory(resourcePack.getModFile(), "assets/" + MOD_ID + "/panoramas");
			if (folders.size() > 0) {
				String chosenPanorama = (String) folders.toArray()[new Random().nextInt(folders.size())];
				ResourceLocation panoramaLoc = new ResourceLocation(MOD_ID, "panoramas/" + chosenPanorama + "/panorama");
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

	public static class PFMisc extends ItemGroup {
		public static final PFMisc instance = new PFMisc(ItemGroup.GROUPS.length, "prehistoric_misc_tab");

		private PFMisc(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.PALEOPEDIA.get());
		}

	}

	public static class PFBuilding extends ItemGroup {
		public static final PFBuilding instance = new PFBuilding(ItemGroup.GROUPS.length, "prehistoric_building_tab");

		private PFBuilding(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFBlocks.ARAUCARIA_LOG);
		}
	}

	public static class PFFood extends ItemGroup {
		public static final PFFood instance = new PFFood(ItemGroup.GROUPS.length, "prehistoric_food_tab");

		private PFFood(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.RAW_THESCELOSAURUS_MEAT.get());
		}
	}

	public static class PFEggs extends ItemGroup {
		public static final PFEggs instance = new PFEggs(ItemGroup.GROUPS.length, "prehistoric_eggs_tab");

		private PFEggs(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.ALLOSAURUS_SPAWN_EGG.get());
		}
	}

	public static class PFDecoration extends ItemGroup {
		public static final PFDecoration instance = new PFDecoration(ItemGroup.GROUPS.length, "prehistoric_decoration_tab");

		private PFDecoration(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFBlocks.LARGE_AMMONITE_FOSSIL.asItem());
		}

	}

	public static class PFSkeleton extends ItemGroup {
		public static final PFSkeleton instance = new PFSkeleton(ItemGroup.GROUPS.length, "prehistoric_skeleton_tab");

		private PFSkeleton(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.TYRANNOSAURUS_SKULL.get());
		}

	}

	public static <MSG> void sendMSGToServer(MSG message) {
		PrehistoricFauna.NETWORK_WRAPPER.sendToServer(message);
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
	public static void registerModels(ModelRegistryEvent event) {
		ClientRegistry.bindTileEntityRenderer(PFTileEntities.PF_SIGNS.get(), PFSignTileEntityRenderer::new);
	}

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class PFWorldGenRegistries {
		@SubscribeEvent
		public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
			PFFeatures.init();
			PFFeatures.features.forEach(feature -> event.getRegistry().register(feature));
			System.out.println("Registered features!");
		}

		@SubscribeEvent
		public static void registerBiomes(RegistryEvent.Register<Biome> event) {
			LOGGER.debug("PF: Registering biomes...");
			PFBiomes.init();
			PFOverworldBiomes.init();
			PFBiomes.biomeList.sort(Comparator.comparingInt(PFBiomes.PreserveBiomeOrder::getOrderPosition));
			PFBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
			PFOverworldBiomes.biomeList.sort(Comparator.comparingInt(PFBiomes.PreserveBiomeOrder::getOrderPosition));
			PFOverworldBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
			PFOverworldBiomes.PETRIFIED_FOREST_KEY = PFOverworldBiomes.PETRIFIED_FOREST.getKey();
			LOGGER.info("PF: Biomes registered!");
		}

		@SubscribeEvent
		public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
			LOGGER.debug("PF: Registering surface builders...");
			PFSurfaceBuilders.init();
			PFSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
			LOGGER.info("PF: Surface builders registered!");
		}
		
		@SubscribeEvent
        public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
    		PFDecorators.init();
    		PFDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
    		System.out.println("Registered decorators!");
    	}

	}

}
