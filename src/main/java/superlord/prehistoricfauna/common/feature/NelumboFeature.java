package superlord.prehistoricfauna.common.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.feature.util.CrassostreaOystersConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class NelumboFeature extends Feature<CrassostreaOystersConfig> {

	public NelumboFeature(Codec<CrassostreaOystersConfig> func) {
		super(func);
	}

	public boolean place(FeaturePlaceContext<CrassostreaOystersConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel worldIn = context.level();
//		RandomSource rand = context.random();
		int i = 0;

		for(int j = 0; j < 24; ++j) {
//			int k = rand.nextInt(8) - rand.nextInt(8);
//			int l = rand.nextInt(8) - rand.nextInt(8);
//			int i1 = worldIn.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
//			BlockPos pos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (worldIn.getBlockState(pos).getBlock() == Blocks.WATER && worldIn.getBlockState(pos.below()).getBlock() == Blocks.SAND || worldIn.getBlockState(pos).getBlock() == Blocks.WATER && worldIn.getBlockState(pos.below()).getBlock() == Blocks.DIRT || worldIn.getBlockState(pos).getBlock() == Blocks.WATER && worldIn.getBlockState(pos.below()).getBlock() == Blocks.COARSE_DIRT || worldIn.getBlockState(pos).getBlock() == Blocks.WATER && worldIn.getBlockState(pos.below()).getBlock() == PFBlocks.PACKED_LOAM.get() || worldIn.getBlockState(pos).getBlock() == Blocks.WATER && worldIn.getBlockState(pos.below()).getBlock() == PFBlocks.SILT.get()) {
				worldIn.setBlock(pos, PFBlocks.NELUMBO_ROOTS.get().defaultBlockState(), 2);
				for (int j1 = 1; j1 < 8; j1++) {
					if (worldIn.getBlockState(pos.above(j1)).getBlock() == Blocks.WATER) {
						worldIn.setBlock(pos.above(j1), PFBlocks.NELUMBO_STEM.get().defaultBlockState(), 2);
					} else {
						worldIn.setBlock(pos.above(j1), PFBlocks.NELUMBO_PAD.get().defaultBlockState(), 2);
						break;
					}
					
				}
				++i;
			}
		}
		return i > 0;
	}
}