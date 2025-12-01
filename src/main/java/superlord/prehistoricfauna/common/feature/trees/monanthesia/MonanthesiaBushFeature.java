package superlord.prehistoricfauna.common.feature.trees.monanthesia;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.MonanthesiaFrondsBlock;
import superlord.prehistoricfauna.common.blocks.WeltrichiaBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class MonanthesiaBushFeature extends Feature<JohnstoniaConfig>
{
	public MonanthesiaBushFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}

	public static boolean isSoil(WorldGenLevel worldgenlevel, BlockPos pos) {
		return (worldgenlevel.getBlockState(pos).is(Blocks.SAND) || worldgenlevel.getBlockState(pos).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(pos).is(Blocks.GRASS_BLOCK) || worldgenlevel.getBlockState(pos).is(Blocks.PODZOL) || worldgenlevel.getBlockState(pos).is(Blocks.MYCELIUM) || worldgenlevel.getBlockState(pos).is(Blocks.DIRT) || worldgenlevel.getBlockState(pos).is(Blocks.COARSE_DIRT) || worldgenlevel.getBlockState(pos).is(PFBlocks.LOAM.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.PACKED_LOAM.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.SILT.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.HARDENED_SILT.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.MOSSY_DIRT.get()));
	}

	public static boolean isAir(LevelSimulatedReader worldgenlevel, BlockPos pos) {
		if (worldgenlevel instanceof BlockGetter) // FORGE: Redirect to state method when possible
			return worldgenlevel.isStateAtPosition(pos, state -> state.isAir());
		return worldgenlevel.isStateAtPosition(pos, BlockState::isAir);
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader worldgenlevel, BlockPos pos) {
		return worldgenlevel.isStateAtPosition(pos, (p_227223_0_) -> {
			return p_227223_0_.isAir() || p_227223_0_.is(BlockTags.LEAVES);
		});
	}


	@SuppressWarnings("unused")
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		Random rand = new Random();
		WorldGenLevel worldgenlevel = context.level();
		int height = rand.nextInt(3) + 2;
		int frondsChance = rand.nextInt(2);
		int frondsOrWeltrichia = rand.nextInt(2);
		int weltrichiaCount = rand.nextInt(2);
		int secondFrondsChance = rand.nextInt(2);
		int secondFrondsOrWeltrichia = rand.nextInt(2);
		int secondWeltrichiaCount = rand.nextInt(2);
		int secondFrondsHeight = rand.nextInt(3) + 1;
		int secondFrondsDirection = rand.nextInt(4);
		int frondsHeight = rand.nextInt(3) + 1;
		int frondsDirection = rand.nextInt(4);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (isSoil(worldgenlevel, pos.below())) {
			for (int i = pos.getY(); i <= pos.getY() + height; i++) {
				if (height == 2 && isAir(worldgenlevel, new BlockPos(x, y, z)) && isAir(worldgenlevel, new BlockPos(x, y + 1, z)) && isAir(worldgenlevel, new BlockPos(x, y + 2, z))) {
					setBlock(worldgenlevel, new BlockPos(x, y, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 1, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 2, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
				}
				if (height == 3 && isAir(worldgenlevel, new BlockPos(x, y, z)) && isAir(worldgenlevel, new BlockPos(x, y + 1, z)) && isAir(worldgenlevel, new BlockPos(x, y + 2, z)) && isAir(worldgenlevel, new BlockPos(x, y + 3, z))) {
					setBlock(worldgenlevel, new BlockPos(x, y, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 1, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 2, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 3, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
				}
				if (height == 4 && isAir(worldgenlevel, new BlockPos(x, y, z)) && isAir(worldgenlevel, new BlockPos(x, y + 1, z)) && isAir(worldgenlevel, new BlockPos(x, y + 2, z)) && isAir(worldgenlevel, new BlockPos(x, y + 3, z)) && isAir(worldgenlevel, new BlockPos(x, y + 4, z))) {
					setBlock(worldgenlevel, new BlockPos(x, y, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 1, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 2, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 3, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 4, z), PFBlocks.MONANTHESIA_LOG.get().defaultBlockState());
				}
				if (frondsChance == 0) {
					if (frondsOrWeltrichia == 0) {
						if (frondsDirection == 0) {
							if (isAir(worldgenlevel, new BlockPos(x + 1, pos.getY() + frondsHeight, z)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 1, pos.getY() + frondsHeight, z), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.WEST));
						}
						if (frondsDirection == 1) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.NORTH));
						}
						if (frondsDirection == 2) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.SOUTH));
						}
						if (frondsDirection == 3) {
							if (isAir(worldgenlevel, new BlockPos(x - 1, pos.getY() + frondsHeight, z)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.EAST));
						}
					} else {
						if (frondsDirection == 0) {
							if (isAir(worldgenlevel, new BlockPos(x + 1, pos.getY() + frondsHeight, z)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 1, pos.getY() + frondsHeight, z), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.WEST).setValue(WeltrichiaBlock.TWO_FLOWERS, weltrichiaCount == 0 ? false : true));
						}
						if (frondsDirection == 1) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.NORTH).setValue(WeltrichiaBlock.TWO_FLOWERS, weltrichiaCount == 0 ? false : true));
						}
						if (frondsDirection == 2) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.SOUTH).setValue(WeltrichiaBlock.TWO_FLOWERS, weltrichiaCount == 0 ? false : true));
						}
						if (frondsDirection == 3) {
							if (isAir(worldgenlevel, new BlockPos(x - 1, pos.getY() + frondsHeight, z)) && !isAir(worldgenlevel, new BlockPos(x, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.EAST).setValue(WeltrichiaBlock.TWO_FLOWERS, weltrichiaCount == 0 ? false : true));
						}
					}
				}
				if (secondFrondsChance == 2) {
					if (frondsOrWeltrichia == 0) {
						if (secondFrondsDirection == 0) {
							if (isAir(worldgenlevel, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.WEST));
						}
						if (secondFrondsDirection == 1) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.NORTH));
						}
						if (secondFrondsDirection == 2) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.SOUTH));
						}
						if (secondFrondsDirection == 3) {
							if (isAir(worldgenlevel, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0))) setBlock(worldgenlevel, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0), PFBlocks.MONANTHESIA_FROND.get().defaultBlockState().setValue(MonanthesiaFrondsBlock.FACING, Direction.EAST));
						}
					} else {
						if (secondFrondsDirection == 0) {
							if (isAir(worldgenlevel, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.WEST).setValue(WeltrichiaBlock.TWO_FLOWERS, secondWeltrichiaCount == 0 ? false : true));
						}
						if (secondFrondsDirection == 1) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.NORTH).setValue(WeltrichiaBlock.TWO_FLOWERS, secondWeltrichiaCount == 0 ? false : true));
						}
						if (secondFrondsDirection == 2) {
							if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.SOUTH).setValue(WeltrichiaBlock.TWO_FLOWERS, secondWeltrichiaCount == 0 ? false : true));
						}
						if (secondFrondsDirection == 3) {
							if (isAir(worldgenlevel, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0))) setBlock(worldgenlevel, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0), PFBlocks.WELTRICHIA.get().defaultBlockState().setValue(WeltrichiaBlock.FACING, Direction.EAST).setValue(WeltrichiaBlock.TWO_FLOWERS, secondWeltrichiaCount == 0 ? false : true));
						}
					}
				}
				if (isAir(worldgenlevel, new BlockPos(x, pos.getY() + height + 1, z)) && worldgenlevel.getBlockState(new BlockPos(x, pos.getY() + height, z)).getBlock() == PFBlocks.MONANTHESIA_LOG.get()) setBlock(worldgenlevel, new BlockPos(x, pos.getY() + height + 1, z), PFBlocks.MONANTHESIA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				return true;
			}
		} else {
			return false;
		}
		return false;
	}


}
