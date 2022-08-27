package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.common.blocks.TallHorsetailsBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;

public class WaterloggedHorsetailsFeature extends Feature<JohnstoniaConfig> {

	public WaterloggedHorsetailsFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, JohnstoniaConfig config) {
		int i = 0;
		for (int j = 0; j < config.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if(world.getBlockState(blockpos.down()).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && world.getBlockState(blockpos.up()).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.down(2)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.down(2)).getBlock() == PFBlocks.PACKED_LOAM || world.getBlockState(blockpos.down(2)).getBlock() == PFBlocks.SILT || world.getBlockState(blockpos.down(2)).getBlock() == Blocks.SAND)) {
				world.setBlockState(blockpos.down(), PFBlocks.TALL_HORSETAIL.getDefaultState().with(TallHorsetailsBlock.HALF, DoubleBlockHalf.LOWER).with(TallHorsetailsBlock.WATERLOGGED, true), l);
				world.setBlockState(blockpos, PFBlocks.TALL_HORSETAIL.getDefaultState().with(TallHorsetailsBlock.HALF, DoubleBlockHalf.UPPER), l);
			}
			++i;
		}
		return i > 0;
	}

}
