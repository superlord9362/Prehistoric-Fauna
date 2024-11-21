package superlord.prehistoricfauna.init;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PFBiomeModifiers {
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_FOSSILS = register("add_overworld_fossils");
	public static final ResourceKey<BiomeModifier> ADD_CRETACEOUS_FOSSILS = register("add_cretaceous_fossils");
	public static final ResourceKey<BiomeModifier> ADD_JURASSIC_FOSSILS = register("add_jurassic_fossils");
	
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_METASEQUOIA = register("add_overworld_metasequoia");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_ARAUCARIA = register("add_overworld_araucaria");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_EPHEDRA = register("add_overworld_ephedra");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_GINKGO = register("add_overworld_ginkgo");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_MIXED_GINKGO = register("add_overworld_mixed_ginkgo");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_RARE_YELLOW_GINKGO = register("add_overworld_rare_yellow_ginkgo");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_TAXUS = register("add_overworld_taxus");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_CLUBMOSS = register("add_overworld_clubmoss");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_NELUMBO = register("add_overworld_nelumbo");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_AZOLLA = register("add_overworld_azolla");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_LIVERWORT = register("add_overworld_liverwort");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_ALGAE = register("add_overworld_algae");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_HORSETAILS = register("add_overworld_horsetails");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_TAXODIUM = register("add_overworld_taxodium");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_OSMUNDA = register("add_overworld_osmunda");
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_CRASSOSTREA = register("add_overworld_crassostrea");
	
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_GAR = register("add_overworld_gar");

	public static void bootstrap(BootstapContext<BiomeModifier> bootstapContext) {
		bootstapContext.register(ADD_OVERWORLD_FOSSILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, BiomeTags.IS_OVERWORLD), getPlacedFeature(bootstapContext, PFPlacedFeatures.FOSSILIZED_CHALK, PFPlacedFeatures.FOSSILIZED_SANDSTONE, PFPlacedFeatures.FOSSILIZED_SILTSTONE), GenerationStep.Decoration.UNDERGROUND_ORES));
		bootstapContext.register(ADD_CRETACEOUS_FOSSILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, PFTags.IS_CRETACEOUS), getPlacedFeature(bootstapContext, PFPlacedFeatures.CRETACEOUS_FOSSILIZED_SANDSTONE, PFPlacedFeatures.CRETACEOUS_FOSSILIZED_SILTSTONE), GenerationStep.Decoration.UNDERGROUND_ORES));
		bootstapContext.register(ADD_JURASSIC_FOSSILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, PFTags.IS_JURASSIC), getPlacedFeature(bootstapContext, PFPlacedFeatures.JURASSIC_FOSSILIZED_SANDSTONE), GenerationStep.Decoration.UNDERGROUND_ORES));
		if (PrehistoricFaunaConfig.extantWorldGeneration) {
			bootstapContext.register(ADD_OVERWORLD_METASEQUOIA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.OLD_GROWTH_SPRUCE_TAIGA), getPlacedFeature(bootstapContext, PFPlacedFeatures.LARGE_METASEQUOIA_TREES, PFPlacedFeatures.RARE_SMALL_METASEQUOIA_TREES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_ARAUCARIA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SAVANNA_PLATEAU), getPlacedFeature(bootstapContext, PFPlacedFeatures.SMALL_ARAUCARIA_TREES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_EPHEDRA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.DESERT, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.ERODED_BADLANDS), getPlacedFeature(bootstapContext, PFPlacedFeatures.RARE_EPHEDRA), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_GINKGO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.STONY_PEAKS), getPlacedFeature(bootstapContext, PFPlacedFeatures.SMALL_GINKGO_TREES, PFPlacedFeatures.RARE_LARGE_GINKGO_TREES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_MIXED_GINKGO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.MEADOW), getPlacedFeature(bootstapContext, PFPlacedFeatures.SMALL_MIXED_GINKGO_TREES, PFPlacedFeatures.RARE_MIXED_LARGE_GINKGO_TREES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_RARE_YELLOW_GINKGO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.WINDSWEPT_FOREST, Biomes.SUNFLOWER_PLAINS, Biomes.CHERRY_GROVE), getPlacedFeature(bootstapContext, PFPlacedFeatures.RARE_SMALL_YELLOW_GINKGO_TREES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_TAXUS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.WINDSWEPT_FOREST, Biomes.TAIGA, Biomes.GROVE), getPlacedFeature(bootstapContext, PFPlacedFeatures.TAXUS_TREES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_CLUBMOSS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.MEADOW, Biomes.SWAMP), getPlacedFeature(bootstapContext, PFPlacedFeatures.CLUBMOSS), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_NELUMBO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.RIVER), getPlacedFeature(bootstapContext, PFPlacedFeatures.RARE_NELUMBO), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_AZOLLA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.PLAINS), getPlacedFeature(bootstapContext, PFPlacedFeatures.AZOLLA), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_LIVERWORT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SWAMP, Biomes.MANGROVE_SWAMP), getPlacedFeature(bootstapContext, PFPlacedFeatures.MARCHANTIA), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_ALGAE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SWAMP, Biomes.MANGROVE_SWAMP), getPlacedFeature(bootstapContext, PFPlacedFeatures.ALGAE), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_HORSETAILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.RIVER, Biomes.SWAMP), getPlacedFeature(bootstapContext, PFPlacedFeatures.WATERLOGGED_HORSETAILS, PFPlacedFeatures.HORSETAILS), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_TAXODIUM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SWAMP), getPlacedFeature(bootstapContext, PFPlacedFeatures.RARE_TAXODIUM_TREES, PFPlacedFeatures.TAXODIUM_KNEES), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_OSMUNDA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.SWAMP), getPlacedFeature(bootstapContext, PFPlacedFeatures.OSMUNDA, PFPlacedFeatures.TALL_OSMUNDA), GenerationStep.Decoration.VEGETAL_DECORATION));
			bootstapContext.register(ADD_OVERWORLD_CRASSOSTREA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, Biomes.MANGROVE_SWAMP, Biomes.STONY_SHORE), getPlacedFeature(bootstapContext, PFPlacedFeatures.CRASSOSTREA_OYSTERS), GenerationStep.Decoration.VEGETAL_DECORATION));
		}
		if (PrehistoricFaunaConfig.extantEntitySpawns) {
			bootstapContext.register(ADD_OVERWORLD_GAR, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(getBiome(bootstapContext, Biomes.RIVER), List.of(new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), 70, 1, 1))));
		}
	}
	
	@NotNull
	private static HolderSet.Direct<Biome> getBiome(BootstapContext<BiomeModifier> bootstapContext, ResourceKey<Biome> biome) {
		return HolderSet.direct(bootstapContext.lookup(Registries.BIOME).getOrThrow(biome));
	}
	
	@SafeVarargs
	@NotNull
	private static HolderSet.Direct<Biome> getBiome(BootstapContext<BiomeModifier> bootstapContext, ResourceKey<Biome>... biome) {
		return HolderSet.direct(Stream.of(biome).map(resourceKey -> bootstapContext.lookup(Registries.BIOME).getOrThrow(resourceKey)).collect(Collectors.toList()));
	}
	
	private static HolderSet.Named<Biome> getBiome(BootstapContext<BiomeModifier> bootstapContex, TagKey<Biome> biome) {
		return bootstapContex.lookup(Registries.BIOME).getOrThrow(biome);
	}
	
	@SafeVarargs
	@NotNull
	private static HolderSet.Direct<PlacedFeature> getPlacedFeature(BootstapContext<BiomeModifier> context, ResourceKey<PlacedFeature>... placedFeature) {
		return HolderSet.direct(Stream.of(placedFeature).map(resourceKey -> context.lookup(Registries.PLACED_FEATURE).getOrThrow(resourceKey)).collect(Collectors.toList()));
	}
	
	@NotNull
	private static HolderSet.Direct<PlacedFeature> getPlacedFeature(BootstapContext<BiomeModifier> context, ResourceKey<PlacedFeature> placedFeature) {
		return HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeature));
	}
	
	@NotNull
	private static ResourceKey<BiomeModifier> register(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

}
