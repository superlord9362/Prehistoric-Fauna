package superlord.prehistoricfauna.common.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.prehistoricfauna.common.blocks.PtilophyllumBaseBlock;
import superlord.prehistoricfauna.init.PFBlocks;

public class PtilophyllumFeature extends Feature<NoneFeatureConfiguration> {
	public PtilophyllumFeature(Codec<NoneFeatureConfiguration> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos pos = context.origin();
		WorldGenLevel worldIn = context.level();
		RandomSource rand = context.random();
		if (worldIn.isEmptyBlock(pos) && (worldIn.getBlockState(pos.below()).getBlock() == PFBlocks.SILT.get() || worldIn.getBlockState(pos.below()).getBlock() == PFBlocks.HARDENED_SILT.get() || worldIn.getBlockState(pos.below()).getBlock() == Blocks.SAND)) {
			PtilophyllumBaseBlock.generatePlant(worldIn, pos, rand, 8);
			return true;
		} else {
			return false;
		}
	}
}
