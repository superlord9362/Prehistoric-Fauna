package superlord.prehistoricfauna.init;

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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFBiomeModifiers {
	public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_FOSSILS = register("add_overworld_fossils");
	public static final ResourceKey<BiomeModifier> ADD_CRETACEOUS_FOSSILS = register("add_cretaceous_fossils");
	public static final ResourceKey<BiomeModifier> ADD_JURASSIC_FOSSILS = register("add_jurassic_fossils");

	public static void bootstrap(BootstapContext<BiomeModifier> bootstapContext) {
		bootstapContext.register(ADD_OVERWORLD_FOSSILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, BiomeTags.IS_OVERWORLD), getPlacedFeature(bootstapContext, PFPlacedFeatures.FOSSILIZED_CHALK, PFPlacedFeatures.FOSSILIZED_SANDSTONE, PFPlacedFeatures.FOSSILIZED_SILTSTONE), GenerationStep.Decoration.UNDERGROUND_ORES));
		bootstapContext.register(ADD_CRETACEOUS_FOSSILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, PFTags.IS_CRETACEOUS), getPlacedFeature(bootstapContext, PFPlacedFeatures.CRETACEOUS_FOSSILIZED_SANDSTONE, PFPlacedFeatures.CRETACEOUS_FOSSILIZED_SILTSTONE), GenerationStep.Decoration.UNDERGROUND_ORES));
		bootstapContext.register(ADD_JURASSIC_FOSSILS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(getBiome(bootstapContext, PFTags.IS_JURASSIC), getPlacedFeature(bootstapContext, PFPlacedFeatures.JURASSIC_FOSSILIZED_SANDSTONE), GenerationStep.Decoration.UNDERGROUND_ORES));
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
