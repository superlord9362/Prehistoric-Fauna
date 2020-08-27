package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.ILightReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.packs.ModFileResourcePack;
import net.minecraftforge.fml.packs.ResourcePackLoader;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import superlord.prehistoricfauna.entity.render.AllosaurusRenderer;
import superlord.prehistoricfauna.entity.render.AnkylosaurusRenderer;
import superlord.prehistoricfauna.entity.render.BasilemysRenderer;
import superlord.prehistoricfauna.entity.render.CamarasaurusRenderer;
import superlord.prehistoricfauna.entity.render.CeratosaurusRenderer;
import superlord.prehistoricfauna.entity.render.DakotaraptorRenderer;
import superlord.prehistoricfauna.entity.render.DidelphodonRenderer;
import superlord.prehistoricfauna.entity.render.DryosaurusRenderer;
import superlord.prehistoricfauna.entity.render.EilenodonRenderer;
import superlord.prehistoricfauna.entity.render.HesperornithoidesRenderer;
import superlord.prehistoricfauna.entity.render.PrehistoricBoatRenderer;
import superlord.prehistoricfauna.entity.render.StegosaurusRenderer;
import superlord.prehistoricfauna.entity.render.ThescelosaurusRenderer;
import superlord.prehistoricfauna.entity.render.TriceratopsRenderer;
import superlord.prehistoricfauna.entity.render.TyrannosaurusRenderer;
import superlord.prehistoricfauna.init.BiomeInit;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.ClientProxy;
import superlord.prehistoricfauna.util.CommonEvents;
import superlord.prehistoricfauna.util.CommonProxy;
import superlord.prehistoricfauna.util.PrehistoricColors;

@Mod(PrehistoricFauna.MODID)
public class PrehistoricFauna {

	public final static String MODID = "prehistoricfauna";
	public static final SimpleChannel NETWORK_WRAPPER;
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	public static Logger LOGGER = LogManager.getLogger();
	public static PrehistoricFauna instance;
	
	static {
		NetworkRegistry.ChannelBuilder channel = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("prehistoricfauna", "main_channel"));
		String version = PROTOCOL_VERSION;
		version.getClass();
		channel = channel.clientAcceptedVersions(version::equals);
		version = PROTOCOL_VERSION;
		version.getClass();
		NETWORK_WRAPPER = channel.serverAcceptedVersions(version::equals).networkProtocolVersion(() -> {
			return PROTOCOL_VERSION;
		}).simpleChannel();
	}
	
    @SuppressWarnings("deprecation")
	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public PrehistoricFauna() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);
		BiomeInit.BIOMES.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		PROXY.init();
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}
	private void setup(final FMLCommonSetupEvent event) {
		CommonEvents.setup();
	}
		
	private void doClientStuff(final FMLClientSetupEvent event) {
		trySetRandomPanorama();
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228064_0_, p_228064_1_, p_228064_2_, p_228064_3_) -> {
			return p_228064_1_ != null && p_228064_2_ != null ? BiomeColors.getGrassColor(p_228064_1_, p_228064_2_) : GrassColors.get(0.5D, 1.0D);
		}, BlockInit.CONIOPTERIS, BlockInit.CLADOPHLEBIS, BlockInit.POTTED_CLADOPHLEBIS);
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
	         return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
		}, BlockInit.METASEQUOIA_LEAVES, BlockInit.PROTOPICEOXYLON_LEAVES, BlockInit.PROTOJUNIPER_LEAVES);
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
			return PrehistoricColors.getAraucaria();
		}, BlockInit.ARAUCARIA_LEAVES);
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
	         BlockState blockstate = ((BlockItem)p_210235_1_.getItem()).getBlock().getDefaultState();
	         return blockcolors.getColor(blockstate, (ILightReader)null, (BlockPos)null, p_210235_2_);
	      }, BlockInit.ARAUCARIA_LEAVES, BlockInit.METASEQUOIA_LEAVES, BlockInit.CONIOPTERIS, BlockInit.PROTOPICEOXYLON_LEAVES, BlockInit.PROTOJUNIPER_LEAVES, BlockInit.CLADOPHLEBIS);
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
	}
	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		
	}
	
	public static <MSG> void sendMSGToAll(MSG message) {
		for (ServerPlayerEntity player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
			sendNonLocal(message, player);
		}
	}
	
	public static <MSG> void sendNonLocal(MSG msg, ServerPlayerEntity player) {
		if (player.server.isDedicatedServer() || !player.getName().equals(player.server.getServerOwner())) {
			NETWORK_WRAPPER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
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

}
