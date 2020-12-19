package superlord.prehistoricfauna.world.structures;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.placement.TimeTemplePieces;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class TimeTempleStructure  extends Structure<NoFeatureConfig>{

	public TimeTempleStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	private static final List<Biome.SpawnListEntry> SPAWN_LIST = Lists.newArrayList(new Biome.SpawnListEntry(ModEntityTypes.TIME_GUARDIAN_ENTITY, 1, 1, 1));

	@Override
	public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> chunkGen, Random rand, int chunkPosX, int chunkPosZ, Biome biome) {
		ChunkPos chunkpos = this.getStartPositionForPosition(chunkGen, rand, chunkPosX, chunkPosZ, 0, 0);
		if (chunkPosX == chunkpos.x && chunkPosZ == chunkpos.z) {
			if (chunkGen.hasStructure(biome, this)) {
				return true;
			}
		}

		return false;
	}
	
	public List<Biome.SpawnListEntry> getSpawnList() {
		return SPAWN_LIST;
	}

	@Override
	public IStartFactory getStartFactory() {
		return TimeTempleStructure.Start::new;
	}

	@Override
	public String getStructureName() {
		return PrehistoricFauna.MODID + ":time_temple";
	}

	@Override
	public int getSize() {
		return 0;
	}
	
	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
		int maxDistance = 100;
		int minDistance = 70;

		int xTemp = x + maxDistance * spacingOffsetsX;
		int ztemp = z + maxDistance * spacingOffsetsZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;

		((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);

		return new ChunkPos(validChunkX, validChunkZ);
	}
	
	protected int getSeedModifier() {
		return 1923735;
	}
	
	public static class Start extends StructureStart {
		public Start(Structure<?> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
			super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
		}


		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
			Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;
			int surfaceY = generator.getNoiseHeightMinusOne(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos blockpos = new BlockPos(x, surfaceY, z);
			TimeTemplePieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);
			this.recalculateStructureSize();
		}

	}

}
