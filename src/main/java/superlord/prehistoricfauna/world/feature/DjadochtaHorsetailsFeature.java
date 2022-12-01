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
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;

public class DjadochtaHorsetailsFeature extends Feature<JohnstoniaConfig> {

	public DjadochtaHorsetailsFeature(Codec<JohnstoniaConfig> func) {
		super(func);
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
			if((world.getBlockState(blockpos.down()).getBlock() != Blocks.SAND || world.getBlockState(blockpos.down()).getBlock() != Blocks.RED_SAND) && world.getBlockState(blockpos).getBlock() == Blocks.AIR && world.getBlockState(blockpos.up()).getBlock() == Blocks.AIR) {
				BlockState blockstate = PFBlocks.HORSETAIL.getDefaultState();
				if (blockstate.isValidPosition(world, blockpos)) {
					world.setBlockState(blockpos, PFBlocks.HORSETAIL.getDefaultState(), l);
				}
			}
			++i;
		}
		return i > 0;
	}

}
