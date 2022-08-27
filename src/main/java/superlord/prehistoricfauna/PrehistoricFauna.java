package superlord.prehistoricfauna;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
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
import superlord.prehistoricfauna.common.CommonEvents;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.common.entities.AbstractBottomDwellerFishEntity;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PinacosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.BasilemysEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.fish.ArganodusEntity;
import superlord.prehistoricfauna.common.entities.fish.CeratodusEntity;
import superlord.prehistoricfauna.common.entities.fish.ChinleaEntity;
import superlord.prehistoricfauna.common.entities.fish.CyclurusEntity;
import superlord.prehistoricfauna.common.entities.fish.GarEntity;
import superlord.prehistoricfauna.common.entities.fish.MooreodontusEntity;
import superlord.prehistoricfauna.common.entities.fish.MyledaphusEntity;
import superlord.prehistoricfauna.common.entities.fish.PotamoceratodusEntity;
import superlord.prehistoricfauna.common.entities.fish.SaurichthysEntity;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.CeratosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.CeratosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.HerrerasaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.HerrerasaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.IschigualastiaSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.IschigualastiaSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.SaurosuchusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.SaurosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.StegosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.StegosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.TyrannosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.TyrannosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkullEntity;
import superlord.prehistoricfauna.common.entities.henos.LandSentinelEntity;
import superlord.prehistoricfauna.common.entities.henos.TimeGuardianEntity;
import superlord.prehistoricfauna.common.entities.henos.TrilobiteSentinelEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.CalsoyasuchusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.tile.MessageUpdatePaleoscribe;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.common.world.PFConfiguredFeatures;
import superlord.prehistoricfauna.common.world.PFFeatures;
import superlord.prehistoricfauna.common.world.PFSurfaceBuilders;
import superlord.prehistoricfauna.compat.QuarkFlagRecipeCondition;
import superlord.prehistoricfauna.config.PFConfigHolder;
import superlord.prehistoricfauna.init.PFBiomes;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFConfiguredStructures;
import superlord.prehistoricfauna.init.PFContainers;
import superlord.prehistoricfauna.init.PFDecorators;
import superlord.prehistoricfauna.init.PFDimensions;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFOverworldBiomes;
import superlord.prehistoricfauna.init.PFRecipes;
import superlord.prehistoricfauna.init.PFStructures;
import superlord.prehistoricfauna.init.PFTileEntities;
import superlord.prehistoricfauna.network.message.InputMessage;
import superlord.prehistoricfauna.world.worldtype.PFWorldType;

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
		modEventBus.addListener(this::setupBiomesAndDimensions);
		PFStructures.setupStructures();
		PFConfiguredFeatures.registerConfiguredFeatures();
		CraftingHelper.register(new QuarkFlagRecipeCondition.Serializer());
		PFRecipes.RECIPES.register(modEventBus);
		REGISTRY_HELPER.getDeferredBlockRegister().register(modEventBus);
		REGISTRY_HELPER.getDeferredItemRegister().register(modEventBus);
		REGISTRY_HELPER.getDeferredTileEntityRegister().register(modEventBus);
		PFBlocks.REGISTER.register(modEventBus);
		PFItems.REGISTER.register(modEventBus);
		PFTileEntities.TILE_ENTITY_TYPES.register(modEventBus);
		PFContainers.CONTAINER_TYPES.register(modEventBus);
		PFEntities.ENTITY_TYPES.register(modEventBus);
		PFDimensions.POI_TYPES.register(modEventBus);
		PFPacketHandler.registerPackets();
		PFEffects.EFFECTS.register(modEventBus);
		PROXY.init();
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, PFConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, PFConfigHolder.SERVER_SPEC);
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
		forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
	}

	private void registerCommon(FMLCommonSetupEvent event) {
		registerEntityAttributes();
	}

	public void setup(final FMLCommonSetupEvent event) {
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, MessageUpdatePaleoscribe.class, MessageUpdatePaleoscribe::write, MessageUpdatePaleoscribe::read, MessageUpdatePaleoscribe.Handler::handle);
		NETWORK_WRAPPER.registerMessage(packetsRegistered++, InputMessage.class, InputMessage::encode, InputMessage::decode, InputMessage::handle);
		event.enqueueWork(() -> {
			PFConfiguredStructures.registerConfiguredStructures();
			WorldGenRegistries.NOISE_SETTINGS.getEntries().forEach(settings -> {
				Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().getStructures().func_236195_a_();
				if (structureMap instanceof ImmutableMap){
					Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
					tempMap.put(PFStructures.TIME_TEMPLE, DimensionStructuresSettings.field_236191_b_.get(PFStructures.TIME_TEMPLE));
					tempMap.put(PFStructures.GEOLOGIST_CAMP, DimensionStructuresSettings.field_236191_b_.get(PFStructures.GEOLOGIST_CAMP));
					tempMap.put(PFStructures.PORTAL_CHAMBER, DimensionStructuresSettings.field_236191_b_.get(PFStructures.PORTAL_CHAMBER));
					tempMap.put(PFStructures.HELL_CREEK_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.HELL_CREEK_HUT));
					tempMap.put(PFStructures.MORRISON_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.MORRISON_HUT));
					tempMap.put(PFStructures.ISCHIGUALASTO_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.ISCHIGUALASTO_HUT));
					tempMap.put(PFStructures.DJADOCHTA_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.DJADOCHTA_HUT));
					tempMap.put(PFStructures.KAYENTA_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.KAYENTA_HUT));
					settings.getValue().getStructures().field_236193_d_ = tempMap;
				} else {
					structureMap.put(PFStructures.TIME_TEMPLE, DimensionStructuresSettings.field_236191_b_.get(PFStructures.TIME_TEMPLE));
					structureMap.put(PFStructures.GEOLOGIST_CAMP, DimensionStructuresSettings.field_236191_b_.get(PFStructures.GEOLOGIST_CAMP));
					structureMap.put(PFStructures.PORTAL_CHAMBER, DimensionStructuresSettings.field_236191_b_.get(PFStructures.PORTAL_CHAMBER));
					structureMap.put(PFStructures.HELL_CREEK_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.HELL_CREEK_HUT));
					structureMap.put(PFStructures.MORRISON_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.MORRISON_HUT));
					structureMap.put(PFStructures.ISCHIGUALASTO_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.ISCHIGUALASTO_HUT));
					structureMap.put(PFStructures.DJADOCHTA_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.DJADOCHTA_HUT));
					structureMap.put(PFStructures.KAYENTA_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.KAYENTA_HUT));
				}
			});
			MinecraftForge.EVENT_BUS.register(new CommonEvents());
		});
        EntitySpawnPlacementRegistry.register(PFEntities.ALLOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.ANKYLOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.BASILEMYS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.CAMARASAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.CERATOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.DILOPHOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.CHROMOGISAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.DAKOTARAPTOR_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.DIDELPHODON_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.DRYOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.VELOCIRAPTOR_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.CITIPATI_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.AEPYORNITHOMIMUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.EILENODON_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.EXAERETODON_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.HERRERASAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.HESPERORNITHOIDES_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.HYPERODAPEDON_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.ISCHIGUALASTIA_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.SAUROSUCHUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.SILLOSUCHUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.STEGOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.THESCELOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.TRICERATOPS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.TYRANNOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.PROTOCERATOPS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.TRILOBITE_SENTINEL_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TrilobiteSentinelEntity::canSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.LAND_SENTINEL_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LandSentinelEntity::canSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.MYLEDAPHUS, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.OCEAN_FLOOR, AbstractBottomDwellerFishEntity::canSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.GAR, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.CYCLURUS, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.POTAMOCERATODUS, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PotamoceratodusEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.CERATODUS, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CeratodusEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.TELMASAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.PLESIOHADROS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.PINACOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.SARAHSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.SCELIDOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.SCUTELLOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.MEGAPNOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.KAYENTATHERIUM_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.TRILOPHOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.CALSOYASUCHUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CalsoyasuchusEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.CHINLEA_ENTITY, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ChinleaEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.SAURICHTHYS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SaurichthysEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.ARGANODUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ArganodusEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.MOOREODONTUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MooreodontusEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(PFEntities.DESMATOSUCHUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.POSTOSUCHUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.PLACERIAS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.COELOPHYSIS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.POPOSAURUS_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        EntitySpawnPlacementRegistry.register(PFEntities.TYPOTHORAX_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DinosaurEntity::canDinosaurSpawn);
        CommonEvents.init();
        CommonEvents.setup();
	}

	public void setupBiomesAndDimensions(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			PFBiomes.addBiomeEntries();
			PFBiomes.fillBiomeDictionary();
			PFOverworldBiomes.addBiomeEntries();
			PFDimensions.initDimension();
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
		GlobalEntityTypeAttributes.put(PFEntities.PROTOCERATOPS_ENTITY, ProtoceratopsEntity.createAttributes().create());
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
		GlobalEntityTypeAttributes.put(PFEntities.TRILOBITE_SENTINEL_ENTITY, TrilobiteSentinelEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.LAND_SENTINEL_ENTITY, LandSentinelEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.MYLEDAPHUS, MyledaphusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.GAR, GarEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CYCLURUS, CyclurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CERATODUS, CeratodusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.POTAMOCERATODUS, PotamoceratodusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.VELOCIRAPTOR_ENTITY, VelociraptorEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CITIPATI_ENTITY, CitipatiEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.AEPYORNITHOMIMUS_ENTITY, AepyornithomimusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TELMASAURUS_ENTITY, TelmasaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.PINACOSAURUS_ENTITY, PinacosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.PLESIOHADROS_ENTITY, PlesiohadrosEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.VELOCIRAPTOR_SKELETON, VelociraptorSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.VELOCIRAPTOR_SKULL, VelociraptorSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.PROTOCERATOPS_SKELETON, ProtoceratopsSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.PROTOCERATOPS_SKULL, ProtoceratopsSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DILOPHOSAURUS_ENTITY, DilophosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SARAHSAURUS_ENTITY, SarahsaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SCELIDOSAURUS_ENTITY, ScelidosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SCUTELLOSAURUS_ENTITY, ScutellosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.MEGAPNOSAURUS_ENTITY, MegapnosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.KAYENTATHERIUM_ENTITY, KayentatheriumEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.POSTOSUCHUS_SKULL, PostosuchusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.PLESIOHADROS_SKULL, PlesiohadrosSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SCELIDOSAURUS_SKULL, PlesiohadrosSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TRILOPHOSAURUS_ENTITY, TrilophosaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.SAURICHTHYS_ENTITY, SaurichthysEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CHINLEA_ENTITY, ChinleaEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.MOOREODONTUS_ENTITY, MooreodontusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.ARGANODUS_ENTITY, ArganodusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.COELOPHYSIS_SKULL, CoelophysisSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.COELOPHYSIS_SKELETON, CoelophysisSkeletonEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.CALSOYASUCHUS_ENTITY, CalsoyasuchusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DESMATOSUCHUS_ENTITY, DesmatosuchusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.POSTOSUCHUS_ENTITY, PostosuchusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.PLACERIAS_ENTITY, PlaceriasEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.COELOPHYSIS_ENTITY, CoelophysisEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.POPOSAURUS_ENTITY, PoposaurusEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DILOPHOSAURUS_SKULL, DilophosaurusSkullEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.TYPOTHORAX_ENTITY, TypothoraxEntity.createAttributes().create());
		GlobalEntityTypeAttributes.put(PFEntities.DESMATOSUCHUS_SKULL, DesmatosuchusSkullEntity.createAttributes().create());
	}

	@SuppressWarnings("unlikely-arg-type")
	public void biomeModification(final BiomeLoadingEvent event) {
		String name = event.getName().getPath();
		if (event.getCategory() == Biome.Category.BEACH || event.getCategory() == Biome.Category.DESERT || event.getCategory() == Biome.Category.EXTREME_HILLS || event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.ICY || event.getCategory() == Biome.Category.JUNGLE || event.getCategory() == Biome.Category.MESA || event.getCategory() == Biome.Category.MUSHROOM || event.getCategory() == Biome.Category.NONE || event.getCategory() == Biome.Category.OCEAN || event.getCategory() == Biome.Category.PLAINS || event.getCategory() == Biome.Category.RIVER || event.getCategory() == Biome.Category.SAVANNA || event.getCategory() == Biome.Category.SWAMP || event.getCategory() == Biome.Category.TAIGA) {
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_PORTAL_CHAMBER);
		}
		if ((event.getCategory() == Biome.Category.PLAINS || event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.DESERT || event.getCategory() == Biome.Category.EXTREME_HILLS || event.getCategory() == Biome.Category.JUNGLE || event.getCategory() == Biome.Category.MESA || event.getCategory() == Biome.Category.MESA || event.getCategory() == Biome.Category.SAVANNA || event.getCategory() == Biome.Category.SWAMP || event.getCategory() == Biome.Category.TAIGA) && (!name.equals("hell_creek") || !name.equals("hell_creek_clearing") || !name.equals("hell_creek_hills") || !name.equals("hell_creek_river"))) {
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_TIME_TEMPLE);
		}
		if ((event.getCategory() == Biome.Category.PLAINS || event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.SAVANNA || event.getCategory() == Biome.Category.TAIGA || event.getCategory() == Biome.Category.EXTREME_HILLS || name.equals("petrified_forest")) && (!name.equals("hell_creek") || !name.equals("hell_creek_clearing") || !name.equals("hell_creek_hills") || !name.equals(PFBiomes.HELL_CREEK_RIVER.getRegistryName()))) {
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_GEOLOGIST_CAMP);
		}
		if (!name.equals("hell_creek") && !name.equals("hell_creek_clearing") && !name.equals("hell_creek_hills") && !name.equals("hell_creek_river") && !name.equals("morrison_savannah") && !name.equals("morrison_hills") && !name.equals("ischigualasto_forest") && !name.equals("ischigualasto_clearing") && !name.equals("ischigualasto_hills") && !name.equals("ischigualasto_river") && !name.equals("djadochta_dunes") && !name.equals("djadochta_arroyo") && !name.equals("kayenta_dry_forest") && !name.equals("kayenta_canyon") && !name.equals("kayenta_desert") && !name.equals("chinle_swamp") && !name.equals("chinle_flats") && !name.equals("chinle_wooded_mountains")) {
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> PFConfiguredFeatures.FOSSILIZED_CHALK);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> PFConfiguredFeatures.FOSSILIZED_SILTSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> PFConfiguredFeatures.FOSSILIZED_SANDSTONE);	
		}
		if (name.equals("hell_creek") || name.equals("hell_creek_clearing") || name.equals("hell_creek_hills")) {
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_HELL_CREEK_HUT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_COAL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_IRON);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_REDSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIAMOND);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_LAPIS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIRT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRAVEL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_ANDESITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRANITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIORITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_SAND_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_GRAVEL_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_CLAY_DISKS);
		}
		if (name.equals("ischigualasto_forest") || name.equals("ischigualasto_clearing") || name.equals("ischigualasto_hills")) {
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_ISCHIGUALASTO_HUT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_COAL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_IRON);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_REDSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIAMOND);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_LAPIS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIRT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRAVEL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_ANDESITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRANITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIORITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_SAND_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_GRAVEL_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_CLAY_DISKS);
		}
		if (name.equals("morrison_savannah") || name.equals("morrison_hills")) {
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_MORRISON_HUT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_COAL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_IRON);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_REDSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIAMOND);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_LAPIS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIRT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRAVEL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_ANDESITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRANITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIORITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_SAND_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_GRAVEL_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_CLAY_DISKS);
		}
		if (name.equals("petrified_forest")) {
			event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION).add(() -> PFConfiguredFeatures.PETRIFIED_TREE);
		}
		if (name.equals("djadochta_dunes") || name.equals("djadochta_arroyo")) {
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_COAL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_IRON);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_REDSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIAMOND);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_LAPIS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIRT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRAVEL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_ANDESITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRANITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIORITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_SAND_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_GRAVEL_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_CLAY_DISKS);
			event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION).add(() ->  Features.PATCH_DEAD_BUSH);
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_DJADOCHTA_HUT);
		}
		if (name.equals("kayenta_dry_forest") || name.equals("kayenta_canyon") || name.equals("kayenta_desert")) {
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_COAL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_IRON);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_REDSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIAMOND);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_LAPIS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIRT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRAVEL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_ANDESITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRANITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIORITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_SAND_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_GRAVEL_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_CLAY_DISKS);
			event.getGeneration().getStructures().add(() -> PFConfiguredStructures.CONFIGURED_KAYENTA_HUT);
		}
		if (name.equals("chinle_swamp") || name.equals("chinle_flats") || name.equals("chinle_wooded_mountains")) {
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_COAL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_IRON);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GOLD);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_REDSTONE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIAMOND);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_LAPIS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIRT);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRAVEL);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_ANDESITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_GRANITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> Features.ORE_DIORITE);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_SAND_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_GRAVEL_DISKS);
			event.getGeneration().getFeatures(Decoration.UNDERGROUND_DECORATION).add(() -> PFConfiguredFeatures.PREHISTORIC_CLAY_DISKS);
		}
	}

	private static Method GETCODEC_METHOD;

	@SuppressWarnings({ "unchecked", "resource" })
	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld)event.getWorld();
			try {
				if (GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "getCodec");
				ResourceLocation cgRL = Registry.CHUNK_GENERATOR_CODEC.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkProvider().generator));
				if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
			} catch (Exception e) {
				PrehistoricFauna.LOGGER.error("Was unable to check if " + serverWorld.getDimensionKey().getLocation() + " is using Terraforged's ChunkGenerator");
			}
			if (serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator && serverWorld.getDimensionKey().equals(World.OVERWORLD)) {
				return;
			}
			Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
			tempMap.putIfAbsent(PFStructures.TIME_TEMPLE, DimensionStructuresSettings.field_236191_b_.get(PFStructures.TIME_TEMPLE));
			tempMap.putIfAbsent(PFStructures.GEOLOGIST_CAMP, DimensionStructuresSettings.field_236191_b_.get(PFStructures.GEOLOGIST_CAMP));
			tempMap.putIfAbsent(PFStructures.HELL_CREEK_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.HELL_CREEK_HUT));
			tempMap.putIfAbsent(PFStructures.MORRISON_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.MORRISON_HUT));
			tempMap.putIfAbsent(PFStructures.ISCHIGUALASTO_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.ISCHIGUALASTO_HUT));
			tempMap.putIfAbsent(PFStructures.DJADOCHTA_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.DJADOCHTA_HUT));
			tempMap.putIfAbsent(PFStructures.KAYENTA_HUT, DimensionStructuresSettings.field_236191_b_.get(PFStructures.KAYENTA_HUT));
			serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
		}
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
			return new ItemStack(PFItems.RAW_LARGE_THEROPOD_MEAT.get());
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

		@SubscribeEvent(priority=EventPriority.LOW)
		public static void registerBiomes(RegistryEvent.Register<Biome> event) {
			LOGGER.debug("PF: Registering biomes...");
			PFOverworldBiomes.init();
			PFBiomes.biomeList.sort(Comparator.comparingInt(PFBiomes.PreserveBiomeOrder::getOrderPosition));
			PFBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
			PFOverworldBiomes.biomeList.sort(Comparator.comparingInt(PFBiomes.PreserveBiomeOrder::getOrderPosition));
			PFOverworldBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
			PFOverworldBiomes.PETRIFIED_FOREST_KEY = PFOverworldBiomes.PETRIFIED_FOREST.getKey();
			PFBiomes.init();
			LOGGER.info("PF: Biomes registered!");
		}

		@SubscribeEvent
		public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
			LOGGER.debug("PF: Registering surface builders...");
			PFSurfaceBuilders.init();
			PFSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
			LOGGER.info("PF: Surface builders registered!");
		}

		@SubscribeEvent()
		public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
			PFDecorators.init();
			PFDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
			System.out.println("Registered decorators!");
		}

		@SubscribeEvent
		public static void registerWorldtype(RegistryEvent.Register<ForgeWorldType> event) {
			event.getRegistry().register(new PFWorldType().setRegistryName(new ResourceLocation(MOD_ID, "prehistoric_world")));
		}

	}

}
