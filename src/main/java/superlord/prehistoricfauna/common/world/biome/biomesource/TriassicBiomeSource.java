package superlord.prehistoricfauna.common.world.biome.biomesource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate.Sampler;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.common.world.chunkgen.TriassicChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class TriassicBiomeSource extends BiomeSource {	
	
	public static final Codec<TriassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(TriassicBiomeSource::new));
	});
	
	private final Holder<Biome> chinleRiver, chinleFlats, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoForest, ischigualastoClearing, ischigualastoHills;

	public TriassicBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.CHINLE_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.CHINLE_FLATS.getKey()), biome.getOrCreateHolder(PFBiomes.CHINLE_SWAMP.getKey()), biome.getOrCreateHolder(PFBiomes.CHINLE_WOODED_MOUNTAINS.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_CLEARING.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_HILLS.getKey()));
	}
	
	public double noiseValue;
	
	public TriassicBiomeSource(Holder<Biome> chinleRiver, Holder<Biome> chinleFlats, Holder<Biome> chinleSwamp, Holder<Biome> chinleWoodedMountains, Holder<Biome> ischigualastoRiver, Holder<Biome> ischigualastoForest, Holder<Biome> ischigualastoClearing, Holder<Biome> ischigualastoHills) {
		super(ImmutableList.of(chinleRiver, chinleFlats, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoForest, ischigualastoClearing, ischigualastoHills));
		this.chinleRiver = chinleRiver;
		this.chinleFlats = chinleFlats;
		this.chinleSwamp = chinleSwamp;
		this.chinleWoodedMountains = chinleWoodedMountains;
		this.ischigualastoRiver = ischigualastoRiver;
		this.ischigualastoForest = ischigualastoForest;
		this.ischigualastoHills = ischigualastoHills;
		this.ischigualastoClearing = ischigualastoClearing;
	}
	
	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public BiomeSource withSeed(long p_47916_) {
		return this;
	}
	

	

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler p_204241_) {
	    noiseValue = calculateNoiseValue(x, z, TriassicChunkGenerator.noise);
		
	    if (noiseValue <= -5.9 && noiseValue > -6.1 || noiseValue >= -0.2 && noiseValue < 0) {
	    	return chinleRiver;
	    } else if (noiseValue <= -5 && noiseValue > -4) {
	    	return chinleFlats;
	    } else if (noiseValue >= -3.5 && noiseValue < -5 || noiseValue >= -2.5 && noiseValue < -0.2) {
	    	return chinleSwamp;
	    } else if (noiseValue > -3.5 && noiseValue < -2.5) {
	    	return chinleWoodedMountains;
	    } else if (noiseValue >= 0 && noiseValue < 0.2 || noiseValue >= 5.9 && noiseValue < 6.1) {
	    	return ischigualastoRiver;
	    } else if (noiseValue > 0.2 && noiseValue <= 2.5 || noiseValue >= 4 && noiseValue < 5.9) {
	    	return ischigualastoForest;
	    } else if (noiseValue > 2.5 && noiseValue <= 3) {
	    	return ischigualastoClearing;
	    } else {
	    	return ischigualastoHills;
	    }
	}

	public double calculateNoiseValue(int x, int z, FastNoise noise) {
		float frequency = 0.5F;
		float amplitude = 4.0F;

		double noiseX = noise.GetNoise(x * frequency, z * frequency);
		double noiseZ = noise.GetNoise(x * frequency, z * frequency);

		double combinedNoise = amplitude * (noiseX + noiseZ);

		return combinedNoise;
	}

}
