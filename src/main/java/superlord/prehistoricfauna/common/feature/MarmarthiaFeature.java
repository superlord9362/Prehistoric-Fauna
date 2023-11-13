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
import superlord.prehistoricfauna.common.blocks.MarmarthiaBlock;
import superlord.prehistoricfauna.common.feature.trees.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class MarmarthiaFeature extends Feature<JohnstoniaConfig> {
	public MarmarthiaFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}
	
	public boolean isSoilBlock(WorldGenLevel world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT);
	}
	
	public boolean isAirBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.AIR;
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
			if (isAirBlock(worldIn, blockpos) && isAirBlock(worldIn, blockpos.above()) && isAirBlock(worldIn, blockpos.above(2)) && isAirBlock(worldIn, blockpos.above(3)) && isSoilBlock(worldIn, blockpos.below())) {
				BlockState blockState = PFBlocks.MARMARTHIA.get().defaultBlockState();
				int berries = rand.nextInt(3);
				if (blockState.canSurvive(worldIn, blockpos)) {
					worldIn.setBlock(blockpos, PFBlocks.MARMARTHIA.get().defaultBlockState().setValue(MarmarthiaBlock.LAYER, 0).setValue(MarmarthiaBlock.BERRIES, berries).setValue(MarmarthiaBlock.GROWTH, 2), 2);
					worldIn.setBlock(blockpos.above(), PFBlocks.MARMARTHIA.get().defaultBlockState().setValue(MarmarthiaBlock.LAYER, 1).setValue(MarmarthiaBlock.BERRIES, berries).setValue(MarmarthiaBlock.GROWTH, 2), 2);
					worldIn.setBlock(blockpos.above(2), PFBlocks.MARMARTHIA.get().defaultBlockState().setValue(MarmarthiaBlock.LAYER, 2).setValue(MarmarthiaBlock.BERRIES, berries).setValue(MarmarthiaBlock.GROWTH, 2), 2);
					worldIn.setBlock(blockpos.above(3), PFBlocks.MARMARTHIA.get().defaultBlockState().setValue(MarmarthiaBlock.LAYER, 3).setValue(MarmarthiaBlock.BERRIES, berries).setValue(MarmarthiaBlock.GROWTH, 2), 2);
				}
				++i;
			}
		}
		return i > 0;
	}

}