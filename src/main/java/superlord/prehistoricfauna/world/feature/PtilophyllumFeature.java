package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import superlord.prehistoricfauna.common.blocks.PtilophyllumBaseBlock;
import superlord.prehistoricfauna.init.PFBlocks;

public class PtilophyllumFeature extends Feature<NoFeatureConfig> {
	public PtilophyllumFeature(Codec<NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if (worldIn.isAirBlock(pos.up()) && worldIn.getBlockState(pos).getBlock() == PFBlocks.SILT) {
			PtilophyllumBaseBlock.generatePlant(worldIn, pos.up(), rand, 8);
			return true;
		} else {
			return false;
		}
	}
}
