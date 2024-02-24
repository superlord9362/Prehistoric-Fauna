package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.TallHorsetailBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class ZingiberopsisFeature extends Feature<JohnstoniaConfig> {

	public ZingiberopsisFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}

	public boolean isSoilBlock(WorldGenLevel world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get());
	}

	public boolean isAirBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.AIR;
	}

	public boolean isWaterBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.WATER;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		int i = 0;
		for (int j = 0; j < context.config().count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			int color = rand.nextInt(2);
			if (color == 1) {
				if (isAirBlock(world, blockpos) && isAirBlock(world, blockpos.above()) && isSoilBlock(world, blockpos.below())) {
					world.setBlock(blockpos, PFBlocks.ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER), 2);
					world.setBlock(blockpos.above(), PFBlocks.ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), 2);
				}
				if (isAirBlock(world, blockpos) && isWaterBlock(world, blockpos.below()) && isSoilBlock(world, blockpos.below(2))) {
					world.setBlock(blockpos.below(), PFBlocks.ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER).setValue(TallHorsetailBlock.WATERLOGGED, true), 2);
					world.setBlock(blockpos, PFBlocks.ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), 2);
				}
			} else {
				if (isAirBlock(world, blockpos) && isAirBlock(world, blockpos.above()) && isSoilBlock(world, blockpos.below())) {
					world.setBlock(blockpos, PFBlocks.PURPLE_ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER), 2);
					world.setBlock(blockpos.above(), PFBlocks.PURPLE_ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), 2);
				}
				if (isAirBlock(world, blockpos) && isWaterBlock(world, blockpos.below()) && isSoilBlock(world, blockpos.below(2))) {
					world.setBlock(blockpos.below(), PFBlocks.PURPLE_ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER).setValue(TallHorsetailBlock.WATERLOGGED, true), 2);
					world.setBlock(blockpos, PFBlocks.PURPLE_ZINGIBEROPSIS.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), 2);
				}
			}
			++i;
		}
		return i > 0;
	}

}
