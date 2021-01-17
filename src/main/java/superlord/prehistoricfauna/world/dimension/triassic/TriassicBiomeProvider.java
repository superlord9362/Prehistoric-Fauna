package superlord.prehistoricfauna.world.dimension.triassic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import superlord.prehistoricfauna.core.world.PHFBiomes;
import superlord.prehistoricfauna.util.fastnoise.FastNoise;
import superlord.prehistoricfauna.world.feature.cretaceous.PHFHillsLayer;

public class TriassicBiomeProvider extends BiomeProvider {

	private final Registry<Biome> biomeRegistry;
	private final Layer layers;
	private final FastNoise noiseGen;
	private final FastNoise noiseGen2;
	private final long seed;

	private final Int2ObjectMap<WeightedList<ResourceLocation>> HILLS = new Int2ObjectArrayMap<>();

	public TriassicBiomeProvider(Registry<Biome> biomeRegistry, long seed) {
		super(BIOMES.stream().map(Registry.BIOME::getOrDefault).collect(Collectors.toSet()));
		this.biomeRegistry = biomeRegistry;
		layers = triassicBiomeLayer(biomeRegistry, seed);
		this.seed = seed;

		noiseGen = new FastNoise((int) seed);
		noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
		noiseGen.SetNoiseType(FastNoise.NoiseType.CubicFractal);
		noiseGen.SetGradientPerturbAmp(1);
		noiseGen.SetFractalOctaves(5);
		noiseGen.SetFractalGain(0.3f);
		noiseGen.SetFrequency(0.0002F);

		noiseGen2 = new FastNoise((int) seed);
		noiseGen2.SetFractalType(FastNoise.FractalType.Billow);
		noiseGen2.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
		noiseGen2.SetGradientPerturbAmp(1);
		noiseGen2.SetFractalOctaves(5);
		noiseGen2.SetFractalGain(0.3f);
		noiseGen2.SetFrequency(0.002F);

		fillHillsList();
	}

	public static final List<ResourceLocation> BIOMES = new ArrayList<>();

	static double min = 100;
	static double max = 0;

//	private void getMinAndMaxNoise(double noise) {
//		if (noise < min) {
//			min = noise;
//			PrehistoricFauna.LOGGER.info("Min noise: " + min);
//		}
//
//		if (noise > max) {
//			max = noise;
//			PrehistoricFauna.LOGGER.info("Max noise: " + max);
//		}
//	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		double noise = noiseGen.GetNoise(x, z) * 10;

//		getMinAndMaxNoise(noise);

		if (noise > 5.691 + Math.sin(noise * 100) && noise < 5.7 + Math.sin(noise * 100))
			return PHFBiomes.ISCHIGUALASTO_RIVER;
		else
			return layers.func_215738_a(x, z);
	}


	public Layer triassicBiomeLayer(Registry<Biome> biomeRegistry, long seed) {
		LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

		IAreaFactory<LazyArea> layer = new TriassicMasterLayer(biomeRegistry, seed).apply(randomProvider.apply(485868686L));

		int size = 2;
		for (int biomeSize = 0; biomeSize <= size; biomeSize++) {
			layer = ZoomLayer.NORMAL.apply(randomProvider.apply(28585L + biomeSize), layer);
		}

		layer = new PHFHillsLayer(biomeRegistry, HILLS).apply(randomProvider.apply(19394585865L), layer, layer);
		layer = ZoomLayer.NORMAL.apply(randomProvider.apply(285368899L), layer);
		layer = ZoomLayer.NORMAL.apply(randomProvider.apply(285368899L), layer);
		layer = ZoomLayer.NORMAL.apply(randomProvider.apply(596969L), layer);
		layer = ZoomLayer.NORMAL.apply(randomProvider.apply(183765656L), layer);
		layer = ZoomLayer.FUZZY.apply(randomProvider.apply(958687L), layer);
		layer = ZoomLayer.FUZZY.apply(randomProvider.apply(19375756L), layer);

		return new Layer(layer);
	}


	public void fillHillsList() {
		WeightedList<ResourceLocation> ischigualasto_sub_biomes = new WeightedList<>();
		ischigualasto_sub_biomes.func_226313_a_(biomeRegistry.getKey(PHFBiomes.ISCHIGUALASTO_CLEARING), 5);
		ischigualasto_sub_biomes.func_226313_a_(biomeRegistry.getKey(PHFBiomes.ISCHIGUALASTO_HILLS), 5);

		HILLS.put(getRawIdFromKey(biomeRegistry, biomeRegistry.getKey(PHFBiomes.ISCHIGUALASTO_FOREST)), ischigualasto_sub_biomes);
	}

	public static int getRawIdFromKey(Registry<Biome> biomeRegistry, ResourceLocation location) {
		return biomeRegistry.getId(biomeRegistry.getOrDefault(location));
	}

	static {
		BIOMES.add(Registry.BIOME.getKey(PHFBiomes.ISCHIGUALASTO_FOREST));
	}
}

