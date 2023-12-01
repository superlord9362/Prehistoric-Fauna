package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.TallHorsetailBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class WaterloggedHorsetailsFeature extends Feature<JohnstoniaConfig> {

	public WaterloggedHorsetailsFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
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
			if(world.getBlockState(blockpos.below()).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && world.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below(2)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below(2)).getBlock() == Blocks.SAND)) {
				world.setBlock(blockpos.below(), PFBlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER).setValue(TallHorsetailBlock.WATERLOGGED, true), l);
				world.setBlock(blockpos, PFBlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), l);
			}
			++i;
		}
		return i > 0;
	}

}
