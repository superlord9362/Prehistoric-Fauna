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

public class LowerHorsetailsFeature extends Feature<JohnstoniaConfig> {

	public LowerHorsetailsFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}

	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		int i = 0;
		int y = pos.getY();
		if (y < 67) {
			for (int p = 0; p <= 8; p++) {
				placeHorsetails(context);
				i++;
			}
		}
		if (y >= 67 && y < 72) {
			for (int p = 0; p <= 4; p++) {
				placeHorsetails(context);
				i++;
			}
		}
		if (y >= 72 && y < 77) {
			for (int p = 0; p <= 2; p++) {
				placeHorsetails(context);
				i++;
			}
		}
		if (y >= 77 && y < 85) {
			for (int p = 0; p <= 1; p++) {
				placeHorsetails(context);
				i++;
			}
		}
		return i > 0;
	}

	public void placeHorsetails(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		context.config();
		for (int j = 0; j < JohnstoniaConfig.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (pos.getY() < 85) {
				if ((world.getBlockState(blockpos).getBlock() == Blocks.AIR) && world.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below()).getBlock() == Blocks.PODZOL || world.getBlockState(blockpos.below()).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.HARDENED_SILT.get() || world.getBlockState(blockpos.below()).getBlock() == Blocks.SAND)) {
					int twoOrThree = rand.nextInt(5);
					if (twoOrThree == 0) {
						world.setBlock(blockpos, PFBlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER), l);
						world.setBlock(blockpos.above(), PFBlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), l);
					} else {
						world.setBlock(blockpos, PFBlocks.HORSETAIL.get().defaultBlockState(), l);
					}
				}
				if(world.getBlockState(blockpos.below()).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && world.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below(2)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below(2)).getBlock() == Blocks.CLAY || world.getBlockState(blockpos.below(2)).getBlock() == Blocks.GRAVEL || world.getBlockState(blockpos.below(2)).getBlock() == Blocks.SAND)) {
					world.setBlock(blockpos.below(), PFBlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER).setValue(TallHorsetailBlock.WATERLOGGED, true), l);
					world.setBlock(blockpos, PFBlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), l);
				}
			}
		}
	}

}
