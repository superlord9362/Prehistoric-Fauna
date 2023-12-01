package superlord.prehistoricfauna.common.feature.trees.fallenlog;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class DryophyllumFallenLogFeature extends Feature<JohnstoniaConfig> {

	public DryophyllumFallenLogFeature(Codec<JohnstoniaConfig> p_65786_) {
		super(p_65786_);
	}

	public boolean isAirBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.AIR;
	}

	public boolean isWaterBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.WATER;
	}

	public boolean isSoilBlock(WorldGenLevel world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get());
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		int i = 0;
		for (int j = 0; j < context.config().count; ++j) {
			int placeChance = rand.nextInt(100);
			int length = rand.nextInt(5) + 3;
			int direction = rand.nextInt(2);
			if (placeChance == 0) {
				if (length == 3) {
					if (direction == 0) {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().east()) && isWaterBlock(world, pos.below().east(2))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().west()) && isWaterBlock(world, pos.below().west(2))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().east()) && isSoilBlock(world, pos.below().east(2))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().west()) && isSoilBlock(world, pos.below().west(2))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						}
					} else {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().north()) && isWaterBlock(world, pos.below().north(2))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().south()) && isWaterBlock(world, pos.below().south(2))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().north()) && isSoilBlock(world, pos.below().north(2))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().south()) && isSoilBlock(world, pos.below().south(2))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						}
					}
				} else if (length == 4) {
					if (direction == 0) {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().east()) && isWaterBlock(world, pos.below().east(2)) && isWaterBlock(world, pos.below().east(3))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().west()) && isWaterBlock(world, pos.below().west(2)) && isWaterBlock(world, pos.below().west(3))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().east()) && isSoilBlock(world, pos.below().east(2)) && isSoilBlock(world, pos.below().east(3))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().west()) && isSoilBlock(world, pos.below().west(2)) && isSoilBlock(world, pos.below().west(3))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						}
					} else {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().north()) && isWaterBlock(world, pos.below().north(2)) && isWaterBlock(world, pos.below().north(3))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().south()) && isWaterBlock(world, pos.below().south(2)) && isWaterBlock(world, pos.below().south(3))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().north()) && isSoilBlock(world, pos.below().north(2)) && isSoilBlock(world, pos.below().north(3))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().south()) && isSoilBlock(world, pos.below().south(2)) && isSoilBlock(world, pos.below().south(3))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						}
					}
				} else if (length == 5) {
					if (direction == 0) {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isAirBlock(world, pos.east(4)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().east()) && isWaterBlock(world, pos.below().east(2)) && isWaterBlock(world, pos.below().east(3)) && isWaterBlock(world, pos.below().east(4))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isAirBlock(world, pos.west(4)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().west()) && isWaterBlock(world, pos.below().west(2)) && isWaterBlock(world, pos.below().west(3)) && isWaterBlock(world, pos.below().west(4))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isAirBlock(world, pos.east(4)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().east()) && isSoilBlock(world, pos.below().east(2)) && isSoilBlock(world, pos.below().east(3)) && isSoilBlock(world, pos.below().east(4))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isAirBlock(world, pos.west(4)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().west()) && isSoilBlock(world, pos.below().west(2)) && isSoilBlock(world, pos.below().west(3)) && isSoilBlock(world, pos.below().west(4))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						}
					} else {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isAirBlock(world, pos.north(4)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().north()) && isWaterBlock(world, pos.below().north(2)) && isWaterBlock(world, pos.below().north(3)) && isWaterBlock(world, pos.below().north(4))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isAirBlock(world, pos.south(4)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().south()) && isWaterBlock(world, pos.below().south(2)) && isWaterBlock(world, pos.below().south(3)) && isWaterBlock(world, pos.below().south(4))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isAirBlock(world, pos.north(4)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().north()) && isSoilBlock(world, pos.below().north(2)) && isSoilBlock(world, pos.below().north(3)) && isSoilBlock(world, pos.below().north(4))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isAirBlock(world, pos.south(4)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().south()) && isSoilBlock(world, pos.below().south(2)) && isSoilBlock(world, pos.below().south(3)) && isSoilBlock(world, pos.below().south(4))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						}
					}
				} else if (length == 6) {
					if (direction == 0) {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isAirBlock(world, pos.east(4)) && isAirBlock(world, pos.east(5)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().east()) && isWaterBlock(world, pos.below().east(2)) && isWaterBlock(world, pos.below().east(3)) && isWaterBlock(world, pos.below().east(4)) && isWaterBlock(world, pos.below().east(5))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isAirBlock(world, pos.west(4)) && isAirBlock(world, pos.west(5)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().west()) && isWaterBlock(world, pos.below().west(2)) && isWaterBlock(world, pos.below().west(3)) && isWaterBlock(world, pos.below().west(4)) && isWaterBlock(world, pos.below().west(5))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isAirBlock(world, pos.east(4)) && isAirBlock(world, pos.east(5)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().east()) && isSoilBlock(world, pos.below().east(2)) && isSoilBlock(world, pos.below().east(3)) && isSoilBlock(world, pos.below().east(4)) && isSoilBlock(world, pos.below().east(5))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isAirBlock(world, pos.west(4)) && isAirBlock(world, pos.west(5)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().west()) && isSoilBlock(world, pos.below().west(2)) && isSoilBlock(world, pos.below().west(3)) && isSoilBlock(world, pos.below().west(4)) && isSoilBlock(world, pos.below().west(5))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						}
					} else {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isAirBlock(world, pos.north(4)) && isAirBlock(world, pos.north(5)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().north()) && isWaterBlock(world, pos.below().north(2)) && isWaterBlock(world, pos.below().north(3)) && isWaterBlock(world, pos.below().north(4)) && isWaterBlock(world, pos.below().north(5))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isAirBlock(world, pos.south(4)) && isAirBlock(world, pos.south(5)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().south()) && isWaterBlock(world, pos.below().south(2)) && isWaterBlock(world, pos.below().south(3)) && isWaterBlock(world, pos.below().south(4)) && isWaterBlock(world, pos.below().south(5))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isAirBlock(world, pos.north(4)) && isAirBlock(world, pos.north(5)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().north()) && isSoilBlock(world, pos.below().north(2)) && isSoilBlock(world, pos.below().north(3)) && isSoilBlock(world, pos.below().north(4)) && isSoilBlock(world, pos.below().north(5))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isAirBlock(world, pos.south(4)) && isAirBlock(world, pos.south(5)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().south()) && isSoilBlock(world, pos.below().south(2)) && isSoilBlock(world, pos.below().south(3)) && isSoilBlock(world, pos.below().south(4)) && isSoilBlock(world, pos.below().south(5))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						}
					}
				} else if (length == 7) {
					if (direction == 0) {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isAirBlock(world, pos.east(4)) && isAirBlock(world, pos.east(5)) && isAirBlock(world, pos.east(6)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().east()) && isWaterBlock(world, pos.below().east(2)) && isWaterBlock(world, pos.below().east(3)) && isWaterBlock(world, pos.below().east(4)) && isWaterBlock(world, pos.below().east(5)) && isWaterBlock(world, pos.below().east(6))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().east(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isAirBlock(world, pos.west(4)) && isAirBlock(world, pos.west(5)) && isAirBlock(world, pos.east(6)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().west()) && isWaterBlock(world, pos.below().west(2)) && isWaterBlock(world, pos.below().west(3)) && isWaterBlock(world, pos.below().west(4)) && isWaterBlock(world, pos.below().west(5)) && isWaterBlock(world, pos.below().west(6))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.below().west(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.east()) && isAirBlock(world, pos.east(2)) && isAirBlock(world, pos.east(3)) && isAirBlock(world, pos.east(4)) && isAirBlock(world, pos.east(5)) && isAirBlock(world, pos.east(6)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().east()) && isSoilBlock(world, pos.below().east(2)) && isSoilBlock(world, pos.below().east(3)) && isSoilBlock(world, pos.below().east(4)) && isSoilBlock(world, pos.below().east(5)) && isSoilBlock(world, pos.below().east(6))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.east(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.west()) && isAirBlock(world, pos.west(2)) && isAirBlock(world, pos.west(3)) && isAirBlock(world, pos.west(4)) && isAirBlock(world, pos.west(5)) && isAirBlock(world, pos.west(6)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().west()) && isSoilBlock(world, pos.below().west(2)) && isSoilBlock(world, pos.below().west(3)) && isSoilBlock(world, pos.below().west(4)) && isSoilBlock(world, pos.below().west(5)) && isSoilBlock(world, pos.below().west(6))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
							world.setBlock(pos.west(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 0);
						}
					} else {
						if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isAirBlock(world, pos.north(4)) && isAirBlock(world, pos.north(5)) && isAirBlock(world, pos.north(6)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().north()) && isWaterBlock(world, pos.below().north(2)) && isWaterBlock(world, pos.below().north(3)) && isWaterBlock(world, pos.below().north(4)) && isWaterBlock(world, pos.below().north(5)) && isWaterBlock(world, pos.below().north(6))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().north(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isAirBlock(world, pos.south(4)) && isAirBlock(world, pos.south(5)) && isAirBlock(world, pos.south(6)) && isWaterBlock(world, pos.below()) && isWaterBlock(world, pos.below().south()) && isWaterBlock(world, pos.below().south(2)) && isWaterBlock(world, pos.below().south(3)) && isWaterBlock(world, pos.below().south(4)) && isWaterBlock(world, pos.below().south(5)) && isWaterBlock(world, pos.below().south(6))) {
							world.setBlock(pos.below(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.below().south(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.north()) && isAirBlock(world, pos.north(2)) && isAirBlock(world, pos.north(3)) && isAirBlock(world, pos.north(4)) && isAirBlock(world, pos.north(5)) && isAirBlock(world, pos.north(6)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().north()) && isSoilBlock(world, pos.below().north(2)) && isSoilBlock(world, pos.below().north(3)) && isSoilBlock(world, pos.below().north(4)) && isSoilBlock(world, pos.below().north(5)) && isSoilBlock(world, pos.below().north(6))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.north(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						} else if (isAirBlock(world, pos) && isAirBlock(world, pos.south()) && isAirBlock(world, pos.south(2)) && isAirBlock(world, pos.south(3)) && isAirBlock(world, pos.south(4)) && isAirBlock(world, pos.south(5)) && isAirBlock(world, pos.south(6)) && isSoilBlock(world, pos.below()) && isSoilBlock(world, pos.below().south()) && isSoilBlock(world, pos.below().south(2)) && isSoilBlock(world, pos.below().south(3)) && isSoilBlock(world, pos.below().south(4)) && isSoilBlock(world, pos.below().south(5)) && isSoilBlock(world, pos.below().south(6))) {
							world.setBlock(pos, PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(2), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(3), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(4), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(5), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
							world.setBlock(pos.south(6), PFBlocks.DRYOPHYLLUM_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 0);
						}
					}
				}
				++i;
			}
		}
		return i > 0;
	}

}
