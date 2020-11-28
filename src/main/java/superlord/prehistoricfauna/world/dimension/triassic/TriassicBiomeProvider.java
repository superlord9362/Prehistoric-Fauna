

package superlord.prehistoricfauna.world.dimension.triassic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.core.world.PHFBiomes;
import superlord.prehistoricfauna.util.fastnoise.FastNoise;

import javax.imageio.ImageIO;

public class TriassicBiomeProvider extends BiomeProvider {

	private final Registry<Biome> biomeRegistry;
	private final Layer layers;
	private final FastNoise noiseGen;
	private final long seed;

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
	}

	public static final List<ResourceLocation> BIOMES = new ArrayList<>();

	static double min = 100;
	static double max = 0;

	private void getMinAndMaxNoise(double noise) {
		if (noise < min) {
			min = noise;
			PrehistoricFauna.LOGGER.info("Min noise: " + min);
		}

		if (noise > max) {
			max = noise;
			PrehistoricFauna.LOGGER.info("Max noise: " + max);
		}
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		double noise = noiseGen.GetNoise(x, z) * 10;

		getMinAndMaxNoise(noise);

		if (noise > 5.691 && noise < 5.7)
			return Biomes.RIVER;
		else
			return layers.func_215738_a(x, z);
	}


	public static Layer triassicBiomeLayer(Registry<Biome> biomeRegistry, long seed) {
		LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

		IAreaFactory<LazyArea> layer = new TriassicMasterLayer(biomeRegistry, seed).apply(randomProvider.apply(485868686L));

		for (int biomeSize = 0; biomeSize <= 4; biomeSize++) {
			layer = ZoomLayer.NORMAL.apply(randomProvider.apply(28585L + biomeSize), layer);
		}
		layer = ZoomLayer.FUZZY.apply(randomProvider.apply(958687L), layer);
		layer = ZoomLayer.NORMAL.apply(randomProvider.apply(19375756L), layer);

		return new Layer(layer);
	}

	static {
		BIOMES.add(Registry.BIOME.getKey(PHFBiomes.HELL_CREEK));
	}
}

