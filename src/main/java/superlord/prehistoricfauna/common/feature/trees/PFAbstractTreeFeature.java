package superlord.prehistoricfauna.common.feature.trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.common.util.FeatureGenUtil;
import superlord.prehistoricfauna.common.util.trees.PFTreeConfig;

public abstract class PFAbstractTreeFeature<TC extends PFTreeConfig> extends Feature<TC> {

	protected static FastNoise fastNoise;
	protected long seed;

	public static final Map<Block, Block> SPREADABLE_TO_NON_SPREADABLE = new HashMap<>();

	public PFAbstractTreeFeature(Codec<TC> configCodec) {
		super(configCodec);
	}

	public static boolean canLogPlaceHere(LevelSimulatedReader worldReader, BlockPos pos) {
		return worldReader.isStateAtPosition(pos, (state) -> state.getMaterial() == Material.AIR || state.getMaterial() == Material.WATER) || FeatureGenUtil.isPlant(worldReader, pos);
	}

	public boolean isAnotherTreeHere(LevelSimulatedReader worldReader, BlockPos pos) {
		return worldReader.isStateAtPosition(pos, (state) -> {
			return state.is(BlockTags.LOGS) || state.is(BlockTags.LEAVES);
		});
	}

	public boolean isAnotherTreeLikeThisHere(LevelSimulatedReader worldReader, BlockPos pos, Block logBlock, Block leafBlock) {
		return worldReader.isStateAtPosition(pos, (state) -> {
			Block block = state.getBlock();
			return block == logBlock || block == leafBlock;
		});
	}

	public void buildTrunkBase(BlockPos centerPos, Set<BlockPos> treeBlocksSet, WorldGenLevel reader, PFTreeConfig config, Random rand, BoundingBox boundingBox, BlockPos... trunkPositions) {
		if (config.isPlacementForced())
			return;
		BlockState ground = reader.getBlockState(centerPos.relative(Direction.DOWN));

		if (SPREADABLE_TO_NON_SPREADABLE.containsKey(ground.getBlock()))
			ground = SPREADABLE_TO_NON_SPREADABLE.get(ground.getBlock()).defaultBlockState();


		if (trunkPositions.length > 0) {
			BlockPos.MutableBlockPos mutableTrunk = new BlockPos.MutableBlockPos();
			for (BlockPos trunkPos : trunkPositions) {
				mutableTrunk.set(trunkPos);
				for (int fill = 1; fill <= 25; fill++) {
					if (canLogPlaceHere(reader, mutableTrunk)) {
						if (fill <= 15)
							setFinalBlockState(treeBlocksSet, reader, mutableTrunk, config.getTrunkProvider().getState(rand, mutableTrunk), boundingBox);
						else
							setFinalBlockState(treeBlocksSet, reader, mutableTrunk, ground, boundingBox);
					} else {
						fill = 25;
					}
					mutableTrunk.move(Direction.DOWN);
				}
			}
		}
	}

	public void placeTrunk(BlockPos startPos, PFTreeConfig config, Random random, Set<BlockPos> blockSet, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
		pos = getTransformedPos(config, startPos, pos);
		if (canLogPlaceHere(reader, pos)) {
			this.setFinalBlockState(blockSet, reader, pos, config.getTrunkProvider().getState(random, pos), boundingBox);
		}
	}

	public void placeBranch(BlockPos startPos, PFTreeConfig config, Random random, Set<BlockPos> blockSet, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
		pos = getTransformedPos(config, startPos, pos);
		if (canLogPlaceHere(reader, pos)) {
			this.setFinalBlockState(blockSet, reader, pos, config.getTrunkProvider().getState(random, pos), boundingBox);
		}
	}

	public void placeLeaves(BlockPos startPos, PFTreeConfig config, Random random, Set<BlockPos> blockSet, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
		pos = getTransformedPos(config, startPos, pos);
		if (isAir(reader, pos)) {
			this.setFinalBlockState(blockSet, reader, pos, config.getLeavesProvider().getState(random, pos), boundingBox);
		}
	}

	public void placeLeaves(BlockPos startPos, PFTreeConfig config, Random random, WorldGenLevel reader, int x, int y, int z, BoundingBox boundingBox, Set<BlockPos> pos) {
		BlockPos blockPos = new BlockPos(x, y, z);
		blockPos = getTransformedPos(config, startPos, blockPos);
		if (isAir(reader, blockPos)) {
			this.setFinalBlockState(pos, reader, blockPos, config.getLeavesProvider().getState(random, blockPos), boundingBox);
		}
	}

	public static BlockPos getTransformedPos(PFTreeConfig config, BlockPos startPos, BlockPos pos) {
		Rotation rotation = config.getRotation();
		Mirror mirror = config.getMirror();
		BlockPos blockPos = FeatureGenUtil.extractOffset(startPos, pos);
		if (blockPos instanceof MutableBlockPos) {
			FeatureGenUtil.transformMutable((MutableBlockPos) blockPos, mirror, rotation);
			((MutableBlockPos)blockPos).move(startPos.getX(), 0, startPos.getZ());
			return blockPos;
		}
		return FeatureGenUtil.transform(blockPos, mirror, rotation).offset(startPos.getX(), 0, startPos.getZ());
	}

	public boolean canSaplingGrowHere(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, (state) -> {
			return state.is(BlockTags.LOGS) || state.is(BlockTags.LEAVES) || state.isAir() || state.getMaterial() == Material.PLANT || state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.WATER_PLANT || state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.DIRT;
		});
	}

	public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, BlockState::isAir);
	}

	public boolean isAirOrWater(LevelSimulatedReader world, BlockPos pos) {
		return world.isStateAtPosition(pos, (state) -> state.isAir() || state.getBlock() == Blocks.WATER);
	}

	public boolean doesSaplingHaveSpaceToGrow(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xDistance, int zDistance, boolean isSapling, BlockPos... trunkPositions) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		MutableBlockPos mutable = new MutableBlockPos();
		//Skip if this is not a sapling.
		if (isSapling) {
			for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
				if (!canSaplingGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
					return false;
				}
				if (trunkPositions.length > 0) {
					for (BlockPos trunkPos : trunkPositions) {
						if (!canSaplingGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
							return false;
						}
					}
				}
			}
			for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
				for (int xOffset = -xDistance; xOffset <= xDistance; ++xOffset) {
					for (int zOffset = -zDistance; zOffset <= zDistance; ++zOffset) {
						if (!canSaplingGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean doesSaplingHaveSpaceToGrow(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int canopyStartHeight, int xNegativeDistance, int zNegativeDistance, int xPositiveDistance, int zPositiveDistance, boolean isSapling, BlockPos... trunkPositions) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		MutableBlockPos mutable = new MutableBlockPos();
		if (isSapling) {
			for (int yOffSet = 0; yOffSet <= treeHeight; yOffSet++) {
				if (!canSaplingGrowHere(reader, mutable.set(x, y + yOffSet, z))) {
					return false;
				}
				if (trunkPositions.length > 0) {
					for (BlockPos trunkPos : trunkPositions) {
						if (!canSaplingGrowHere(reader, mutable.set(trunkPos.getX(), trunkPos.getY() + yOffSet, trunkPos.getZ()))) {
							return false;
						}
					}
				}
			}
			for (int yOffset = canopyStartHeight; yOffset <= treeHeight + 1; ++yOffset) {
				for (int xOffset = -xNegativeDistance; xOffset <= xPositiveDistance; ++xOffset) {
					for (int zOffset = -zNegativeDistance; zOffset <= zPositiveDistance; ++zOffset) {
						if (!canSaplingGrowHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isAnotherTreeNearby(LevelSimulatedReader reader, BlockPos pos, int treeHeight, int distance, boolean isSapling) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		MutableBlockPos mutable = new MutableBlockPos();

		//Skip if tree is being spawned with a sapling.
		if (!isSapling) {
			for (int yOffset = 0; yOffset <= treeHeight + 1; ++yOffset) {
				for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
					for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
						if (isAnotherTreeHere(reader, mutable.set(x + xOffset, y + yOffset, z + zOffset))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isCliff(LevelSimulatedReader reader, BlockPos... trunkPositions) {
		return isCliff(reader, 5, trunkPositions);
	}


	public boolean isCliff(LevelSimulatedReader reader, int checkDownRange, BlockPos... trunkPositions) {
		if (trunkPositions.length > 0) {
			MutableBlockPos mutable = new MutableBlockPos();

			for (BlockPos trunkPos : trunkPositions) {
				mutable.set(trunkPos);
				for (int moveDown = 0; moveDown <= checkDownRange; moveDown++) {
					if (!isAirOrWater(reader, mutable) && !FeatureGenUtil.isPlant(reader, mutable)) {
						break;
					}
					if (moveDown == checkDownRange)
						return true;
					mutable.move(Direction.DOWN);
				}
			}
		}
		return false;
	}

	public void buildTrunk(WorldGenLevel reader, PFTreeConfig config, Random random, BlockPos operatingPos, int downRange) {
		MutableBlockPos mutable = new MutableBlockPos().set(operatingPos);

		for (int moveDown = 0; moveDown < downRange; moveDown++) {
			BlockState movingState = reader.getBlockState(mutable);
			if (SPREADABLE_TO_NON_SPREADABLE.containsKey(movingState.getBlock())) {
				reader.setBlock(mutable, SPREADABLE_TO_NON_SPREADABLE.get(movingState.getBlock()).defaultBlockState(), 2);
				break;
			} else {
				if (!FeatureGenUtil.isTerrainOrRock(reader, mutable)) {
					reader.setBlock(mutable, config.getTrunkProvider().getState(random, mutable), 2);
				} else {
					break;
				}
			}
			mutable.move(Direction.DOWN);
		}
	}

	public void setSeed(long seed) {
		if (this.seed != seed || fastNoise == null) {
			fastNoise = new FastNoise((int) seed);
			fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
			this.seed = seed;
		}
	}


	@SuppressWarnings("deprecation")
	public final void setFinalBlockState(Set<BlockPos> changedBlocks, LevelWriter worldIn, BlockPos pos, BlockState blockState, BoundingBox boundingBox) {
		this.setBlockStateWithoutUpdates(worldIn, pos, blockState);
		boundingBox.encapsulate(new BoundingBox(pos));
		if (blockState.is(BlockTags.LOGS)) {
			changedBlocks.add(pos.immutable());
		}
	}

	public void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
		worldWriter.setBlock(blockPos, blockState, 18);
	}

	public void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState, int flags) {
		worldWriter.setBlock(blockPos, blockState, flags);
	}

	@Override
	public boolean place(FeaturePlaceContext<TC> featurePlaceContext) {
		return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
	}

	public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, TC config) {

		Rotation rotation = Rotation.values()[rand.nextInt(Rotation.values().length)];
		Mirror mirror = Mirror.values()[rand.nextInt(Mirror.values().length)];
		config.setRotationAndMirror(rotation, mirror);

		return placeTree(worldIn, rand, pos, config);
	}

	public boolean placeTree(WorldGenLevel worldIn, Random rand, BlockPos pos, TC config) {
		Set<BlockPos> set = Sets.newHashSet();
		BoundingBox mutableboundingbox = new BoundingBox(pos);
		boolean flag = this.generate(set, worldIn, rand, pos, mutableboundingbox, false, config);
		if (mutableboundingbox.minX() > mutableboundingbox.maxX()) {
			return false;
		} else {
			List<Set<BlockPos>> list = Lists.newArrayList();

			for (int j = 0; j < 6; ++j) {
				list.add(Sets.newHashSet());
			}

			for (BlockPos blockPos : set) {
				if (blockPos.getY() == pos.getY()) {
					boolean cliff = isCliff(worldIn, 9, blockPos);
					if (!cliff && !FeatureGenUtil.isTerrainOrRock(worldIn, blockPos.below())) {
						this.buildTrunk(worldIn, config, rand, blockPos, 10);
					}
				}
			}

			DiscreteVoxelShape voxelshapepart = new BitSetDiscreteVoxelShape(mutableboundingbox.getXSpan(), mutableboundingbox.getYSpan(), mutableboundingbox.getZSpan());

			try (PooledMutable posInPool = PooledMutable.get()) {
				if (flag && !set.isEmpty()) {
					for (BlockPos blockpos : Lists.newArrayList(set)) {
						if (mutableboundingbox.isInside(blockpos)) {
							voxelshapepart.fill(blockpos.getX() - mutableboundingbox.minX(), blockpos.getY() - mutableboundingbox.minY(), blockpos.getZ() - mutableboundingbox.minZ());
						}

						for (Direction direction : Direction.values()) {
							posInPool.set(blockpos).move(direction);
							if (!set.contains(posInPool)) {
								BlockState blockstate = worldIn.getBlockState(posInPool);
								if (blockstate.hasProperty(BlockStateProperties.DISTANCE)) {
									list.get(0).add(posInPool.immutable());
									this.setBlockStateWithoutUpdates(worldIn, posInPool, blockstate.setValue(BlockStateProperties.DISTANCE, 1));
									if (mutableboundingbox.isInside(posInPool)) {
										voxelshapepart.fill(posInPool.getX() - mutableboundingbox.minX(), posInPool.getY() - mutableboundingbox.minY(), posInPool.getZ() - mutableboundingbox.minZ());
									}
								}
							}
						}
					}
				}

				for (int l = 1; l < 6; ++l) {
					Set<BlockPos> set1 = list.get(l - 1);
					Set<BlockPos> set2 = list.get(l);

					for (BlockPos blockpos1 : set1) {
						if (mutableboundingbox.isInside(blockpos1)) {
							voxelshapepart.fill(blockpos1.getX() - mutableboundingbox.minX(), blockpos1.getY() - mutableboundingbox.minY(), blockpos1.getZ() - mutableboundingbox.minZ());
						}

						for (Direction direction1 : Direction.values()) {
							posInPool.set(blockpos1).move(direction1);
							if (!set1.contains(posInPool) && !set2.contains(posInPool)) {
								BlockState blockstate1 = worldIn.getBlockState(posInPool);
								if (blockstate1.hasProperty(BlockStateProperties.DISTANCE)) {
									int currentDistance = blockstate1.getValue(BlockStateProperties.DISTANCE);
									int newDistance = l + 1;
									if (currentDistance > newDistance) {
										BlockState blockstate2 = blockstate1.setValue(BlockStateProperties.DISTANCE, newDistance);

										if (newDistance >= 7)
											this.setBlockStateWithoutUpdates(worldIn, posInPool, Blocks.AIR.defaultBlockState(), 2); //If leaves distance is or exceeds 7, set air
											else
												this.setBlockStateWithoutUpdates(worldIn, posInPool, blockstate2);

										if (mutableboundingbox.isInside(posInPool)) {
											voxelshapepart.fill(posInPool.getX() - mutableboundingbox.minX(), posInPool.getY() - mutableboundingbox.minY(), posInPool.getZ() - mutableboundingbox.minZ());
										}

										set2.add(posInPool.immutable());
									}
								}
							}
						}
					}
				}
			}

			StructureTemplate.updateShapeAtEdge(worldIn, 3, voxelshapepart, mutableboundingbox.minX(), mutableboundingbox.minY(), mutableboundingbox.minZ());
			return flag;
		}
	}

	protected abstract boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, TC config);

	static {
		SPREADABLE_TO_NON_SPREADABLE.put(Blocks.GRASS_BLOCK, Blocks.DIRT);
		SPREADABLE_TO_NON_SPREADABLE.put(Blocks.MYCELIUM, Blocks.DIRT);
		SPREADABLE_TO_NON_SPREADABLE.put(Blocks.DIRT_PATH, Blocks.DIRT);
		SPREADABLE_TO_NON_SPREADABLE.put(Blocks.PODZOL, Blocks.DIRT);
	}

	public static final class PooledMutable extends MutableBlockPos implements AutoCloseable {
		private boolean free;
		private static final List<PooledMutable> POOL = Lists.newArrayList();

		private PooledMutable(int x, int y, int z) {
			super(x, y, z);
		}

		public static PooledMutable get() {
			return get(0, 0, 0);
		}

		public static PooledMutable get(double x, double y, double z) {
			return get(Mth.floor(x), Mth.floor(y), Mth.floor(z));
		}

		public static PooledMutable get(int x, int y, int z) {
			synchronized (POOL) {
				if (!POOL.isEmpty()) {
					PooledMutable pooledMutable = POOL.remove(POOL.size() - 1);
					if (pooledMutable != null && pooledMutable.free) {
						pooledMutable.free = false;
						pooledMutable.set(x, y, z);
						return pooledMutable;
					}
				}
			}

			return new PooledMutable(x, y, z);
		}

		public PooledMutable set(int i, int j, int k) {
			return (PooledMutable) super.set(i, j, k);
		}

		public PooledMutable set(double d, double e, double f) {
			return (PooledMutable) super.set(d, e, f);
		}

		public PooledMutable set(Vec3i vec3i) {
			return (PooledMutable) super.set(vec3i);
		}

		public void close() {
			synchronized (POOL) {
				if (POOL.size() < 100) {
					POOL.add(this);
				}

				this.free = true;
			}
		}
	}

}
