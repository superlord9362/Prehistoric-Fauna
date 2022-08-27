package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.config.CrassostreaOystersConfig;

public class AlgaeFeature extends Feature<CrassostreaOystersConfig> {
	
	public AlgaeFeature(Codec<CrassostreaOystersConfig> func) {
		super(func);
	}

	@SuppressWarnings("static-access")
	public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, CrassostreaOystersConfig config) {
		int i = 0;

		for(int j = 0; j < config.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.SAND || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.COARSE_DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == PFBlocks.PACKED_LOAM || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == PFBlocks.SILT) {
				BlockState blockstate = PFBlocks.ALGAE_CARPET.getDefaultState();
				if (blockstate.isValidPosition(worldIn, blockpos)) {
					worldIn.setBlockState(blockpos, blockstate, 2);
				}
				++i;
			}
		}
		return i > 0;
	}
}