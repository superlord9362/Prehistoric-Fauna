package superlord.prehistoricfauna.common.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.ArchaefructusBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class ArchaefructusFeature extends Feature<JohnstoniaConfig> {

	public ArchaefructusFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		RandomSource rand = context.random();
		int i = 0;
		for (int j = 0; j < 15; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (world.getBlockState(blockpos.below()).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below(2)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below(2)).getBlock() == Blocks.SAND)) {
				world.setBlock(blockpos.below(), PFBlocks.ARCHAEFRUCTUS.get().defaultBlockState().setValue(ArchaefructusBlock.WATERLOGGED, true), l);
			}
			if (world.getBlockState(blockpos.below()).getBlock() == Blocks.WATER && world.getBlockState(blockpos.below(2)).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below(3)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below(3)).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below(3)).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below(3)).getBlock() == Blocks.SAND)) {
				world.setBlock(blockpos.below(2), PFBlocks.ARCHAEFRUCTUS.get().defaultBlockState().setValue(ArchaefructusBlock.WATERLOGGED, true), l);
			}
			++i;
		}
		return i > 0;
	}

}
