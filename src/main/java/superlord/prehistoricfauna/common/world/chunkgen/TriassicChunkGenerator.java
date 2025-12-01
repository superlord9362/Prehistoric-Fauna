package superlord.prehistoricfauna.common.world.chunkgen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.RandomSupport;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.blending.Blender;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.common.world.biome.biomesource.TriassicBiomeSource;
import superlord.prehistoricfauna.common.world.biome.surfacedecorators.SurfaceDecorators;
import superlord.prehistoricfauna.init.PFBiomes;
import superlord.prehistoricfauna.init.PFBlocks;

public class TriassicChunkGenerator extends ChunkGenerator {
	public static final Codec<TriassicChunkGenerator> CODEC = RecordCodecBuilder.create((codec) -> codec.group(
			TriassicBiomeSource.CODEC.fieldOf("biome_source").forGetter((generator) -> generator.biomeSource),
			NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter((generator) -> generator.settings))
			.apply(codec, codec.stable(TriassicChunkGenerator::new)));

	protected final Holder<NoiseGeneratorSettings> settings;
	public FastNoise noise;
	private float[][][] terrainShapeSamplePoints;
	public final TriassicBiomeSource biomeSource;


	public TriassicChunkGenerator(TriassicBiomeSource pBiomeSource, Holder<NoiseGeneratorSettings> settings) {
		super(pBiomeSource);
		this.settings = settings;
		this.biomeSource = pBiomeSource;
	}

	public void initializeNoise(long seed) {
		if (noise == null) {
			noise = new FastNoise((int) (seed & 0xFFFFFFFFL));
			noise.SetNoiseType(FastNoise.NoiseType.Simplex);
			SurfaceDecorators.setFastNoise(noise);
		}
	}

	private FastNoise getNoise(long seed) {
		if (noise == null) {
			initializeNoise(seed);
		}
		return noise;
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	@Override
	public void applyCarvers(WorldGenRegion region, long seed, RandomState p_223045_, BiomeManager manager, StructureManager structureFeatureManager, ChunkAccess chunk, Carving genStep) {
		//im not touching this
		//..for now :)
	}

	@Override
	public void buildSurface(WorldGenRegion region, StructureManager structureFeatureManager, RandomState p_223052_, ChunkAccess chunk) {
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				//when it encounters a new surface, check the biome and generate the corresponding surface.
				int startHeight = chunk.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
				pos.set(x + chunk.getPos().getMinBlockX(), startHeight, z + chunk.getPos().getMinBlockZ());

				boolean isInSolid = false;
				boolean visibleToSun = true;
				while (pos.getY() > this.getMinY() + 5) {
					///PrehistoricFauna.LOGGER.info("b");
					ResourceLocation biome = region.getBiome(pos).unwrap().map((resourceKey) -> resourceKey.location(), (noKey) -> null);
					if (chunk.getBlockState(pos) == this.settings.value().defaultBlock()) {
						if (!isInSolid) {
							SurfaceDecorators.getSurfaceDecorator(biome).buildSurface(pos, this.getSeaLevel(), visibleToSun, chunk, settings.value());
							isInSolid = true;
							visibleToSun = false;
							break;
						}
					} else {
						isInSolid = false;
					}
					pos.move(Direction.DOWN);
				}
			}
		}
	}

	@Override
	//stolen from NoiseBasedChunkGenerator
	public void spawnOriginalMobs(WorldGenRegion region) {
		ChunkPos chunkpos = region.getCenter();
		Holder<Biome> holder = region.getBiome(chunkpos.getWorldPosition().atY(region.getMaxBuildHeight() - 1));
		WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(RandomSupport.generateUniqueSeed()));
		worldgenRandom.setDecorationSeed(region.getSeed(), chunkpos.getMinBlockX(), chunkpos.getMinBlockZ());
		NaturalSpawner.spawnMobsForChunkGeneration(region, holder, chunkpos, worldgenRandom);
	}



	@Override
	//where the magic happens
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState randomState, StructureManager manager, ChunkAccess chunk) {
		PositionalRandomFactory chunkRandom = randomState.getOrCreateRandomFactory(new ResourceLocation(PrehistoricFauna.MOD_ID, "chunk"));
		RandomSource random = chunkRandom.at(chunk.getPos().x, 0, chunk.getPos().z);
		long seed = extractSeedFromRandomState(randomState);
		initializeNoise(seed);
		
		fillNoiseSampleArrays(chunk, randomState);
		Heightmap[] heightmaps = {chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG), chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG)};
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = this.getMaxY(); y >= this.getMinY(); y--) {
					pos.set(x, y, z);
					float sample = sampleDensityFromArray(terrainShapeSamplePoints, x, y, z);

					BlockState state;					
					if (sample > 0) {
						BiomeManager biomeManager = new BiomeManager(biomeSource, seed);
						Holder<Biome> biome = biomeManager.getBiome(new BlockPos(x + chunk.getPos().getMinBlockX(), pos.getY(), z + chunk.getPos().getMinBlockZ()));
						if (biome.is(PFBiomes.TRIASSIC_HENOSTONE_CAVE)) {
							state = PFBlocks.HENOSTONE.get().defaultBlockState();
						} else {
							if (y < 0 +- random.nextInt(5)) {
								state = Blocks.DEEPSLATE.defaultBlockState();
							} else state = settings.value().defaultBlock();
						}
						if (y <= this.getMinY() + random.nextInt(4)) {
							state = Blocks.BEDROCK.defaultBlockState();
						}
					} else {
						if (y <= this.getMinY() + random.nextInt(4)) {
							state = Blocks.BEDROCK.defaultBlockState();
						} else if (y < this.getSeaLevel()) {
							state = getAirAtPos(chunk, x + chunk.getPos().getMinBlockX(), y, z + chunk.getPos().getMinBlockZ(), randomState);
						} else state =  Blocks.AIR.defaultBlockState();
					}
					for (Heightmap heightmap : heightmaps) {
						heightmap.update(x, y, z, state);
					}
					chunk.setBlockState(pos, state, false);
				}
			}
		}

		return CompletableFuture.completedFuture(chunk);
	}
	
	private long extractSeedFromRandomState(RandomState randomState) {
        PositionalRandomFactory testRandom = randomState.getOrCreateRandomFactory(new ResourceLocation("seed_extractor"));
        RandomSource test = testRandom.at(0, 0, 0);
        return test.nextLong();
    }

	private boolean shouldHaveFluid(BlockPos pos, RandomState randomState) {
        long seed = extractSeedFromRandomState(randomState);
        BiomeManager biomeManager = new BiomeManager(biomeSource, seed);
		Holder<Biome> biome = biomeManager.getBiome(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
		if (pos.getY() <= this.getSeaLevel())
			return (biome.is(PFBiomes.ISCHIGUALASTO_RIVER) || biome.is(PFBiomes.CHINLE_RIVER) || biome.is(PFBiomes.CHINLE_SWAMP) || noise.GetNoise(pos.getX() * 0.8F, pos.getY(), pos.getZ() * 0.8F) > 0.7);
		return false;
	}

	private BlockState getAirAtPos(ChunkAccess chunk, int x, int y, int z, RandomState randomState) {
		BlockPos pos = new BlockPos(x, y, z);
		if (shouldHaveFluid(pos, randomState)) {
			if (!shouldHaveFluid(new BlockPos(x + 1, y + 0, z + 0), randomState) ||
					!shouldHaveFluid(new BlockPos(x + 0, y + 0, z + 1), randomState) ||
					!shouldHaveFluid(new BlockPos(x - 1, y + 0, z + 0), randomState) ||
					!shouldHaveFluid(new BlockPos(x + 0, y + 0, z - 1), randomState) ||
					!shouldHaveFluid(new BlockPos(x + 0, y - 1, z  + 0), randomState)) 
				return Blocks.STONE.defaultBlockState();
			return Blocks.WATER.defaultBlockState();
		}
		return Blocks.AIR.defaultBlockState();
	}

	private float sampleDensity(float x, float y, float z, long seed) {
		int seaLevel = this.settings.value().seaLevel();
		FastNoise currentNoise = getNoise(seed);
		if (y > seaLevel) y = y + 3;
		BiomeManager biomeManager = new BiomeManager(biomeSource, seed);
		Holder<Biome> biome = biomeManager.getBiome(new BlockPos((int) x, (int) y, (int) z));
		float baseDensity = calculateBaseDensity(x, y, z, biome);
		int blendRadius = 16;
		int blendStep = 4;
		float blendedDensity = baseDensity;
		int blendCount = 1;
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		int size = Math.floorDiv(blendRadius, blendStep);

		for (BlockPos.MutableBlockPos blockPos : BlockPos.spiralAround(BlockPos.ZERO, size, Direction.EAST, Direction.SOUTH)) {
			int nx = (int) (x + blockPos.getX() * blendStep);
			int nz = (int) (z + blockPos.getZ() * blendStep);
			mutableBlockPos.set(nx, (int) y, nz);
			Holder<Biome> nearbyBiome = biomeManager.getBiome(mutableBlockPos);

			if (nearbyBiome != biome) {
				if (nearbyBiome.is(PFBiomes.CHINLE_RIVER) || nearbyBiome.is(PFBiomes.ISCHIGUALASTO_RIVER)) {
					double distToLowCornerSqr = mutableBlockPos.distToLowCornerSqr(x, y, z);

					if (distToLowCornerSqr < Mth.square(blendRadius)) {
						double delta = distToLowCornerSqr / Mth.square(blendRadius);
						blendedDensity += blendSmoothstep((float) delta, flatsSample(x, y, z), baseDensity);
						blendCount++;
					}
				} else {
					double distToLowCornerSqr = mutableBlockPos.distToLowCornerSqr(x, y, z);

					if (distToLowCornerSqr < Mth.square(blendRadius)) {
						float nearbyDensity = calculateBaseDensity(nx, y, nz, nearbyBiome);

						double delta = distToLowCornerSqr / Mth.square(blendRadius);
						blendedDensity += blendSmoothstep((float) delta, nearbyDensity, baseDensity);
						blendCount++;
					}
				}
			}
		}

		float finalDensity = blendedDensity / blendCount;

		float smoothingNoise = currentNoise.GetNoise(x * 0.1f, y * 0.1f, z * 0.1f);
		finalDensity = Mth.lerp(0.2f, finalDensity, finalDensity + smoothingNoise * 0.1f);

		return finalDensity;
	}

	private float blendSmoothstep(float delta, float value1, float value2) {
		float smoothDelta = delta * delta * (3 - 2 * delta); // Smoothstep function
		return Mth.lerp(smoothDelta, value1, value2);
	}

	public float flatsSample(float x, float y, float z) {
		int seaLevel = this.settings.value().seaLevel();
		if (y > seaLevel) y = y + 3;
		float frequency1 = 0.3F;
		float sample = noise.GetNoise(x * frequency1, y * frequency1 * 0.8F, z * frequency1);
		float floor = -0.2F;
		float smoothness = 0.001F;
		float h = Mth.clamp(0.5F + 0.5F * (sample - floor) / smoothness, 0.0F, 1.0F);
		sample = Mth.lerp(sample, floor, h) - smoothness * h * (1.0F - h);
		float flatsFrequency = 3F;
		float flatsNoise = noise.GetNoise((float) x * flatsFrequency, 0, (float) z * flatsFrequency);
		flatsNoise = (1.0F - flatsNoise * flatsNoise);
		flatsNoise *= (y - seaLevel);
		float frequency2 = 2.5F;
		sample += Mth.abs(noise.GetNoise(x * frequency2, y * frequency2, z * frequency2) * 0.2F);
		float frequency3 = 3.5F;
		sample += Mth.abs(noise.GetNoise(x * frequency3, y * frequency3, z * frequency3) * 0.05F);
		sample -= 0.15F;
		sample -= flatsNoise;
		sample -= 2;
		return sample;
	}

	public float calculateBaseDensity(float x, float y, float z, Holder<Biome> biome) {
		int seaLevel = this.settings.value().seaLevel();
		if (y > seaLevel) y = y + 3;

		float frequency1 = 0.3F;
		float sample = noise.GetNoise(x * frequency1, y * frequency1 * 0.8F, z * frequency1);

		float floor = -0.2F;
		float smoothness = 0.001F;
		float h = Mth.clamp(0.5F + 0.5F * (sample - floor) / smoothness, 0.0F, 1.0F);
		sample = Mth.lerp(sample, floor, h) - smoothness * h * (1.0F - h);
		float bigRockFrequency = 0.4F;
		float rockNoise = noise.GetNoise(x * bigRockFrequency, (y * frequency1) + 512, z * bigRockFrequency);
		float bigRockNoise = Mth.sqrt(sample * sample + rockNoise * rockNoise);
		bigRockNoise = (sample < 0 || rockNoise < 0) ? 1 : bigRockNoise;
		float bigRockStrength = 0.2F;
		bigRockNoise *= bigRockStrength;
		bigRockNoise += (1F - bigRockStrength);

		float hugeCliffFrequency = 0.1F;
		float hugeCliffNoise = noise.GetNoise(x * hugeCliffFrequency, 2834, z * hugeCliffFrequency);
		hugeCliffNoise = (float) Mth.clamp(Math.pow(1.3 * hugeCliffNoise, 12), 0, 1) * 5;
		float hugeCliffWobble = -0.5F * Mth.cos(2F * Mth.PI * hugeCliffNoise) + 0.5F;
		hugeCliffWobble *= 1.5F;

		float lumpFrequency = 4.3F;
		float cliffLumpiness = noise.GetNoise(x * lumpFrequency, y * lumpFrequency * 0.8F, z * lumpFrequency);
		cliffLumpiness *= hugeCliffWobble * 0.1F;

		float riverFrequency = 0.1F;
		float riverNoise = noise.GetNoise((float) x * riverFrequency, 0, (float) z * riverFrequency);
		riverNoise = (1.0F - riverNoise * riverNoise);
		riverNoise *= (y - seaLevel);
		float flatsFrequency = 3F;
		float flatsNoise = noise.GetNoise((float) x * flatsFrequency, 0, (float) z * flatsFrequency);
		flatsNoise = (1.0F - flatsNoise * flatsNoise);
		flatsNoise *= (y - seaLevel);

		float bigHillRockFrequency = 0.4F;
		float hillRockNoise = noise.GetNoise(x * bigHillRockFrequency, (y * frequency1) + 512, z * bigHillRockFrequency);
		float bigHillRockNoise = Mth.sqrt(sample * sample + hillRockNoise * hillRockNoise);
		bigHillRockNoise = (sample < 0 || hillRockNoise < 0) ? 1 : bigHillRockNoise;
		float bigHillRockStrength = 0.2F;
		bigHillRockNoise *= bigHillRockStrength;
		bigHillRockNoise += (1F - bigHillRockStrength);

		float hillFrequency = 0.1F;
		float hillNoise = noise.GetNoise(x * hillFrequency, 2834, z * hillFrequency);
		hillNoise = (float) Mth.clamp(Math.pow(1.3 * hillNoise, 12), 0, 1) * 0.4F;
		float hillWobble = -0.5F * Mth.cos(2F * Mth.PI * hillNoise) + 0.5F;
		hillWobble *= 1.5F;

		float hillLumpFrequency = 4.3F;
		float hillLumpiness = noise.GetNoise(x * hillLumpFrequency, y * hillLumpFrequency * 1.8F, z * hillLumpFrequency);
		hillLumpiness *= hillWobble * 0.1F;

		float swampFrequency = 1.5F;
		float swampNoise = noise.GetNoise((float) x * swampFrequency, 0, (float) z * swampFrequency);
		swampNoise = (1.5F - swampNoise * swampNoise);
		swampNoise *= (y - seaLevel + 0.55) * 1.1;

		if (biome.is(PFBiomes.ISCHIGUALASTO_HILLS)) {
			sample += hillLumpiness;
		}
		if (biome.is(PFBiomes.CHINLE_WOODED_MOUNTAINS)) {
			sample += cliffLumpiness;
		}
		float frequency2 = 2.5F;
		sample += Mth.abs(noise.GetNoise(x * frequency2, y * frequency2, z * frequency2) * 0.2F);
		float frequency3 = 3.5F;
		sample += Mth.abs(noise.GetNoise(x * frequency3, y * frequency3, z * frequency3) * 0.05F);
		sample -= 0.15F;

		if (biome.is(PFBiomes.CHINLE_RIVER) || biome.is(PFBiomes.ISCHIGUALASTO_RIVER)) {
			sample -= riverNoise;
			sample *= 8;
			sample -= 22;
		}
		if (biome.is(PFBiomes.ISCHIGUALASTO_CLEARING) || biome.is(PFBiomes.ISCHIGUALASTO_FOREST) || biome.is(PFBiomes.CHINLE_FLATS)) {
			sample -= flatsNoise;
		}
		if (biome.is(PFBiomes.ISCHIGUALASTO_HILLS)) {
			sample *= 1.6F;
			sample += 0.4;
			sample -= (y - this.settings.value().seaLevel() - hillNoise * 64) / (16.0F / bigHillRockNoise * (hillWobble + 1));
			sample *= 1.8F;
		}
		if (biome.is(PFBiomes.CHINLE_WOODED_MOUNTAINS)) {
			sample *= 2.4F;
			sample += 1.25;
			sample -= (y - this.settings.value().seaLevel() - hugeCliffNoise * 64) / (16.0F / bigRockNoise * (hugeCliffWobble + 1));
		}
		if (biome.is(PFBiomes.CHINLE_SWAMP)) {
			sample -= swampNoise;
			sample *= 3.3F;
			sample -= 4.75F;
		}
		if (y < 60) {
			sample *= 1;
			sample += 0.4;
			sample -= (y - this.settings.value().seaLevel() - hillNoise * 64) / (16.0F / bigHillRockNoise * (hillWobble + 1));
			sample *= 6.6F;
		}
		if (y > -60) {
			float caveSample;
			float sample1 = noise.GetNoise(x,  y, z);
			float sample2 = noise.GetNoise(x, y + 10381903, z);
			caveSample = sample1 * sample1 + sample2 * sample2;
			caveSample /= 2;
			caveSample *= 1.5;
			caveSample -= 0.02;
			sample = Math.min(sample, caveSample);
		}
		return sample;
	}


	public void fillNoiseSampleArrays(ChunkAccess chunk, RandomState randomState) {
        long seed = extractSeedFromRandomState(randomState);
        int hSamplePoints = (int) Math.ceil(16 * 0.3F);
		int vSamplePoints = (int) Math.ceil(this.getGenDepth() * 0.15F);
		float hOffset = (16.0F / (float) hSamplePoints);
		float vOffset = ((float)this.getGenDepth() / (float) vSamplePoints);

		this.terrainShapeSamplePoints = new float[hSamplePoints + 1][vSamplePoints][hSamplePoints + 1];
		for (int sX = 0; sX < hSamplePoints + 1; sX++) {
			for (int sZ = 0; sZ < hSamplePoints + 1; sZ++) {
				for (int sY = 0; sY < vSamplePoints; sY++) {

					float cX = sX * hOffset;
					float cY = sY * vOffset;
					float cZ = sZ * hOffset;

					float x = cX + chunk.getPos().getMinBlockX();
					float z = cZ + chunk.getPos().getMinBlockZ();
					float y = cY + chunk.getMinBuildHeight();

					terrainShapeSamplePoints[sX][sY][sZ] = sampleDensity(x, y, z, seed);
				}
			}
		}
	}

	public float sampleDensityFromArray(float[][][] densityArray, int localX, int localY, int localZ) {
		int maxXZ = 16;
		int maxY = this.getGenDepth();
		float xzSampleRes = (float)(densityArray.length-1) / (float)maxXZ;
		float ySampleRes =  (float)(densityArray[0].length-1) / (float)maxY;

		float sampleX = localX * xzSampleRes;
		float sxFrac = Mth.frac(sampleX);
		int sxF = Mth.floor(sampleX);
		int sxC = Mth.ceil(sampleX);
		float sampleY = (localY - this.getMinY()) * ySampleRes;
		float syFrac = Mth.frac(sampleY);
		int syF = Mth.floor(sampleY);
		int syC = Mth.ceil(sampleY);
		float sampleZ = localZ * xzSampleRes;
		float szFrac = Mth.frac(sampleZ);
		int szF = Mth.floor(sampleZ);
		int szC = Mth.ceil(sampleZ);

		float xLerp1 = Mth.lerp(sxFrac, densityArray[sxF][syF][szF], densityArray[sxC][syF][szF]);
		float xLerp2 = Mth.lerp(sxFrac, densityArray[sxF][syF][szC], densityArray[sxC][syF][szC]);
		float zLerp1 = Mth.lerp(szFrac, xLerp1, xLerp2);

		float xLerp3 = Mth.lerp(sxFrac, densityArray[sxF][syC][szF], densityArray[sxC][syC][szF]);
		float xLerp4 = Mth.lerp(sxFrac, densityArray[sxF][syC][szC], densityArray[sxC][syC][szC]);
		float zLerp2 = Mth.lerp(szFrac, xLerp3, xLerp4);

		float yLerp = Mth.lerp(Mth.lerp(Mth.clamp((float)(localY - this.getSeaLevel()) / 64F, 0F, 1F), syFrac * syFrac * syFrac, syFrac), zLerp1, zLerp2);

		return yLerp;
	}

	@Override
	public int getSeaLevel() {
		return settings.value().seaLevel();
	}

	@Override
	public int getGenDepth() {
		return this.getMaxY() - this.getMinY();
	}

	@Override
	public int getMinY() {
		return -64;
	}
	public int getMaxY() {
		return 256;
	}

	@Override
	public int getBaseHeight(int p_156153_, int p_156154_, Types type, LevelHeightAccessor accessor, RandomState p_223036_) {
		return this.getSeaLevel();
	}

	@Override
	//todo: this
	public NoiseColumn getBaseColumn(int p_156150_, int p_156151_, LevelHeightAccessor chunk, RandomState p_223031_) {
		BlockState[] states = new BlockState[chunk.getHeight()];
		int iY = 0;
		for (int y = chunk.getMinBuildHeight(); y < chunk.getMaxBuildHeight(); y++) {
			states[iY] = Blocks.AIR.defaultBlockState();
			iY++;
		}

		return new NoiseColumn(chunk.getMinBuildHeight(), states);
	}

	@Override
	public void addDebugScreenInfo(List<String> string, RandomState state, BlockPos pos) {
	}
}