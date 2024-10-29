package superlord.prehistoricfauna.common.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.CallianthusBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class CallianthusFeature extends Feature<JohnstoniaConfig> {

	public CallianthusFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}
	
	public boolean isAirBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.AIR;
	}
	
	public boolean isWaterBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.WATER;
	}
	
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		RandomSource rand = context.random();
		int i = 0;
		for (int j = 0; j < 3; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (isAirBlock(world, blockpos) && isWaterBlock(world, blockpos.below())) {
				world.setBlock(blockpos, PFBlocks.CALLIANTHUS.get().defaultBlockState().setValue(CallianthusBlock.HALF, DoubleBlockHalf.UPPER), 1);
				world.setBlock(blockpos.below(), PFBlocks.CALLIANTHUS.get().defaultBlockState().setValue(CallianthusBlock.HALF, DoubleBlockHalf.LOWER).setValue(CallianthusBlock.WATERLOGGED, true), 1);
			}
			++i;
		}
		return i > 0;
	}
	
}
