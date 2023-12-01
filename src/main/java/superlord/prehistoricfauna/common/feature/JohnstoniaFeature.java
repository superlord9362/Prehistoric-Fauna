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
import superlord.prehistoricfauna.common.blocks.JohnstoniaBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class JohnstoniaFeature extends Feature<JohnstoniaConfig> {
	public JohnstoniaFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel worldIn = context.level();
		Random rand = context.random();
		int i = 0;
		for(int j = 0; j < context.config().count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = worldIn.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.above(2)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.below()).getBlock() == Blocks.COARSE_DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.above(2)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.below()).getBlock() == Blocks.PODZOL || worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.above(2)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.below()).getBlock() == PFBlocks.LOAM.get()) {
				BlockState blockstate = PFBlocks.JOHNSTONIA.get().defaultBlockState();
				if (blockstate.canSurvive(worldIn, blockpos)) {
					worldIn.setBlock(blockpos, PFBlocks.JOHNSTONIA.get().defaultBlockState().setValue(JohnstoniaBlock.LAYER, 0), 2);
					worldIn.setBlock(blockpos.above(), PFBlocks.JOHNSTONIA.get().defaultBlockState().setValue(JohnstoniaBlock.LAYER, 1), 2);
					worldIn.setBlock(blockpos.above(2), PFBlocks.JOHNSTONIA.get().defaultBlockState().setValue(JohnstoniaBlock.LAYER, 2), 2);
				}
				++i;
			}
		}
		return i > 0;
	}

}
