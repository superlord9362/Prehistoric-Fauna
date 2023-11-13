package superlord.prehistoricfauna.common.feature;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.GlowLichenConfiguration;
import superlord.prehistoricfauna.common.blocks.HumulusBlock;
import superlord.prehistoricfauna.init.PFBlocks;

public class HumulusFeature extends Feature<GlowLichenConfiguration> {

	public HumulusFeature(Codec<GlowLichenConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<GlowLichenConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		Random random = context.random();
		GlowLichenConfiguration glowlichenconfiguration = context.config();
		if (!isAirOrWater(worldgenlevel.getBlockState(blockpos))) {
			return false;
		} else {
			List<Direction> list = getShuffledDirections(glowlichenconfiguration, random);
			if (placeHumulusIfPossible(worldgenlevel, blockpos, worldgenlevel.getBlockState(blockpos), glowlichenconfiguration, random, list)) {
				return true;
			} else {
				BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();

				for(Direction direction : list) {
					blockpos$mutableblockpos.set(blockpos);
					List<Direction> list1 = getShuffledDirectionsExcept(glowlichenconfiguration, random, direction.getOpposite());

					for(int i = 0; i < glowlichenconfiguration.searchRange; ++i) {
						blockpos$mutableblockpos.setWithOffset(blockpos, direction);
						BlockState blockstate = worldgenlevel.getBlockState(blockpos$mutableblockpos);
						if (!isAirOrWater(blockstate) && !blockstate.is(PFBlocks.HUMULUS.get())) {
							break;
						}

						if (placeHumulusIfPossible(worldgenlevel, blockpos$mutableblockpos, blockstate, glowlichenconfiguration, random, list1)) {
							return true;
						}
					}
				}

				return false;
			}
		}
	}

	public static boolean placeHumulusIfPossible(WorldGenLevel level, BlockPos pos, BlockState state, GlowLichenConfiguration config, Random rand, List<Direction> dir) {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

		for(Direction direction : dir) {
			BlockState blockstate = level.getBlockState(blockpos$mutableblockpos.setWithOffset(pos, direction));
			if (blockstate.is(config.canBePlacedOn)) {
				HumulusBlock humulusblock = (HumulusBlock)PFBlocks.HUMULUS.get();
				BlockState blockstate1 = humulusblock.getStateForPlacement(state, level, pos, direction);
				if (blockstate1 == null) {
					return false;
				}

				level.setBlock(pos, blockstate1, 3);
				level.getChunk(pos).markPosForPostprocessing(pos);
				if (rand.nextFloat() < config.chanceOfSpreading) {
					humulusblock.spreadFromFaceTowardRandomDirection(blockstate1, level, pos, direction, rand, true);
				}

				return true;
			}
		}

		return false;
	}

	public static List<Direction> getShuffledDirections(GlowLichenConfiguration config, Random rand) {
		List<Direction> list = Lists.newArrayList(config.validDirections);
		Collections.shuffle(list, rand);
		return list;
	}

	public static List<Direction> getShuffledDirectionsExcept(GlowLichenConfiguration config, Random rand, Direction dir) {
		List<Direction> list = config.validDirections.stream().filter((direction) -> {
			return direction != dir;
		}).collect(Collectors.toList());
		Collections.shuffle(list, rand);
		return list;
	}

	private static boolean isAirOrWater(BlockState state) {
		return state.isAir() || state.is(Blocks.WATER);
	}

}
