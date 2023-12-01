package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class AzollaFeature extends Feature<JohnstoniaConfig> {

	public AzollaFeature(Codec<JohnstoniaConfig> func) {
		super(func);
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
			if (isAirBlock(world, blockpos) && isWaterBlock(world, blockpos.below())) {
				world.setBlock(blockpos, PFBlocks.AZOLLA.get().defaultBlockState(), 1);
			}
			++i;
		}
		return i > 0;
	}
	
}
