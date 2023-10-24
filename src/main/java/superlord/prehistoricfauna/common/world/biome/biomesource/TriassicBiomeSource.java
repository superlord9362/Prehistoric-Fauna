package superlord.prehistoricfauna.common.world.biome.biomesource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate.Sampler;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.common.world.chunkgen.TriassicChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class TriassicBiomeSource extends BiomeSource {	
	public final List<Holder<Biome>> TRIASSIC_BIOMES;

	public static final Codec<TriassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
	      return p_48644_.group(
	    		  Codec.list(Biome.CODEC).fieldOf("biomes").forGetter(TriassicBiomeSource::getTriassicBiomes)
	    		  ).apply(p_48644_, p_48644_.stable(TriassicBiomeSource::new));
	   });
	
	public List<Holder<Biome>> getTriassicBiomes() {
        return TRIASSIC_BIOMES;
    }
	
	protected TriassicBiomeSource(List<Holder<Biome>> p_47894_) {
		super(p_47894_);
		TRIASSIC_BIOMES = p_47894_;
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
		List<Holder<Biome>> chinleFormation = Arrays.asList(PFBiomes.CHINLE_RIVER.getHolder().orElseThrow(), PFBiomes.CHINLE_FLATS.getHolder().orElseThrow(), PFBiomes.CHINLE_SWAMP.getHolder().orElseThrow(), PFBiomes.CHINLE_WOODED_MOUNTAINS.getHolder().orElseThrow());
		List<Holder<Biome>> ischigualastoFormation = Arrays.asList(PFBiomes.ISCHIGUALASTO_RIVER.getHolder().orElseThrow(), PFBiomes.ISCHIGUALASTO_HILLS.getHolder().orElseThrow(), PFBiomes.ISCHIGUALASTO_FOREST.getHolder().orElseThrow(), PFBiomes.ISCHIGUALASTO_CLEARING.getHolder().orElseThrow());
		List<Holder<Biome>> specialBiomesChinle = Arrays.asList(PFBiomes.CHINLE_RIVER.getHolder().orElseThrow(), PFBiomes.CHINLE_WOODED_MOUNTAINS.getHolder().orElseThrow());
		List<Holder<Biome>> specialBiomesIschigualasto = Arrays.asList(PFBiomes.ISCHIGUALASTO_RIVER.getHolder().orElseThrow(), PFBiomes.ISCHIGUALASTO_CLEARING.getHolder().orElseThrow());

		double noiseValue = calculateNoiseValue(x, z, TriassicChunkGenerator.noise);

		List<Holder<Biome>> activeGroup;
		List<Holder<Biome>> specialBiomes;

		if (noiseValue < 0.25) {
			activeGroup = chinleFormation;
			specialBiomes = specialBiomesChinle;
		} else if (noiseValue < 0.5) {
			activeGroup = chinleFormation;
			specialBiomes = specialBiomesChinle;
		} else if (noiseValue < 0.75) {
			activeGroup = ischigualastoFormation;
			specialBiomes = specialBiomesIschigualasto;
		} else {
			activeGroup = ischigualastoFormation;
			specialBiomes = specialBiomesIschigualasto;
		}

		Random random = new Random();

		// Choose a random biome from the active group
		if (specialBiomes.contains(activeGroup.get(0)) || random.nextDouble() < 0.1) {
			// Use the river biome with a 10% chance or if the active group includes the river biome
			return activeGroup.get(0);
		} else {
			// Return a random non-river biome from the active group
			List<Holder<Biome>> nonRiverBiomes = activeGroup.stream()
					.filter(biome -> !specialBiomes.contains(biome))
					.collect(Collectors.toList());
			return nonRiverBiomes.get(random.nextInt(nonRiverBiomes.size()));
		}
	}

	private double calculateNoiseValue(int x, int z, FastNoise noise) {
		float frequency = 0.1F;
		float amplitude = 1.0F;

		double noiseX = noise.GetNoise(x * frequency, z * frequency);
		double noiseZ = noise.GetNoise(x * frequency, z * frequency);

		double combinedNoise = amplitude * (noiseX + noiseZ);

		return combinedNoise;
	}

}
