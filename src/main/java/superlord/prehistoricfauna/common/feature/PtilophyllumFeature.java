package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
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
		Random rand = context.random();
		if (worldIn.isEmptyBlock(pos.above()) && worldIn.getBlockState(pos).getBlock() == PFBlocks.SILT.get()) {
			PtilophyllumBaseBlock.generatePlant(worldIn, pos.above(), rand, 8);
			return true;
		} else {
			return false;
		}
	}
}
