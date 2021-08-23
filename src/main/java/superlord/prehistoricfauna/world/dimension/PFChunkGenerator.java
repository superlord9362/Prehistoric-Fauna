package superlord.prehistoricfauna.world.dimension;

import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class PFChunkGenerator extends NoiseChunkGenerator {
	
	public static final Codec<PFChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> 
			instance.group(
					BiomeProvider.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator::getBiomeProvider),
					Codec.LONG.fieldOf("seed").orElseGet(() -> PFChunkGenerator.hackSeed).forGetter((obj) -> obj.seed),
					DimensionSettings.field_236098_b_.fieldOf("settings").forGetter(PFChunkGenerator::getDimensionSettings)
					).apply(instance, instance.stable(PFChunkGenerator::new)));
	
	private long seed;
	public static long hackSeed;
	
	public PFChunkGenerator(BiomeProvider provider, long seed, Supplier<DimensionSettings> settings) {
		super(provider, seed, settings);
		this.seed = seed;
	}
	
	@Override
	protected Codec<? extends ChunkGenerator> func_230347_a_() {
		return CODEC;
	}
	
	@Override
	public ChunkGenerator func_230349_a_(long seed) {
		return new PFChunkGenerator(biomeProvider.getBiomeProvider(seed), seed, getDimensionSettings());
	}
	
	private Supplier<DimensionSettings> getDimensionSettings() {
		return field_236080_h_;
	}

}

