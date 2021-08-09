package superlord.prehistoricfauna.world.feature.trees.zamites;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.init.PFBlocks;

public class ZamiteBushFeature extends Feature<BaseTreeFeatureConfig>
{
    public ZamiteBushFeature(Codec<BaseTreeFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos startPosition, BaseTreeFeatureConfig config) {
		BlockPos pos = startPosition;
		if (!isDirtAt(reader, pos.down())) {
			return false;
		}
		if (reader.getBlockState(pos.down()) ==  Tags.Blocks.DIRT) {
	        int height = rand.nextInt(3) + 2;
	        int x = pos.getX();
	        int z = pos.getZ();
	        if (pos.getY() >= 1 && pos.getY() + height + 2 <= generator.getMaxBuildHeight()) {
	        	for (int j = pos.getY(); j <= pos.getY() + height; j++) {
	        		if (isAirAt(reader, new BlockPos(x, j, z))) setBlockState(reader, new BlockPos(x, j, z), PFBlocks.ZAMITES_LOG.getDefaultState());
	        	}
	        	if (isAirAt(reader, new BlockPos(x, pos.getY() + height + 1, z))) setBlockState(reader, new BlockPos(x, startPosition.getY() + height + 1, z), PFBlocks.ZAMITES_LEAVES.getDefaultState());
	        	return true;
	        }
	        return false;
		} else {
			pos = pos.down();
		}
		return false;
	}
}
