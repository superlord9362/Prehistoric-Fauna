package superlord.prehistoricfauna.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.common.blocks.CrassostreaOysterBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.config.CrassostreaOystersConfig;

import java.util.Random;
import java.util.function.Function;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;

public class CrassostreaOystersFeature extends Feature<CrassostreaOystersConfig> {

	@SuppressWarnings("unchecked")
	public CrassostreaOystersFeature(Function<Dynamic<?>, ? extends CrassostreaOystersConfig> func) {
		super((Codec<CrassostreaOystersConfig>) func);
	}

	@Override
	public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, CrassostreaOystersConfig config) {
		int i = 0;

		for(int j = 0; j < config.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.SAND) {
				BlockState blockstate = PFBlocks.CRASSOSTREA_OYSTER.getDefaultState().with(CrassostreaOysterBlock.AGE, Integer.valueOf(2));
				if (blockstate.isValidPosition(worldIn, blockpos)) {
					worldIn.setBlockState(blockpos, blockstate, 2);
				}
				++i;
			}
		}
		return i > 0;
	}
}