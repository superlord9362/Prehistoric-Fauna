package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.CrassostreaOysterBlock;
import superlord.prehistoricfauna.common.util.CrassostreaOystersConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class CrassostreaOystersFeature extends Feature<CrassostreaOystersConfig> {

	public CrassostreaOystersFeature(Codec<CrassostreaOystersConfig> func) {
		super(func);
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean place(FeaturePlaceContext<CrassostreaOystersConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel worldIn = context.level();
		Random rand = context.random();
		int i = 0;
		for(int j = 0; j < context.config().count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = worldIn.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.below()).getBlock() == Blocks.SAND || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.below()).getBlock() == Blocks.DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.below()).getBlock() == Blocks.COARSE_DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.below()).getBlock() == PFBlocks.PACKED_LOAM.get()) {
				BlockState blockstate = PFBlocks.CRASSOSTREA_OYSTER.get().defaultBlockState().setValue(CrassostreaOysterBlock.AGE, 2);
				if (blockstate.canSurvive(worldIn, blockpos)) {
					worldIn.setBlock(blockpos, blockstate, 2);
				}
				++i;
			}
		}
		return i > 0;
	}
}