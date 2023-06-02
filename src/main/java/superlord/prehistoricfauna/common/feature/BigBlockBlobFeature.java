package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class BigBlockBlobFeature extends Feature<BlockStateConfiguration> {
	public BigBlockBlobFeature(Codec<BlockStateConfiguration> p_i231931_1_) {
		super(p_i231931_1_);
	}

	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos pos = context.origin();
		Random rand = new Random();
		WorldGenLevel reader = context.level();
		while(true) {
			label46: {
				if (pos.getY() > 3) {
					if (reader.isEmptyBlock(pos.below())) {
						break label46;
					}

					Block block = reader.getBlockState(pos.below()).getBlock();
					if (!isDirt(block.defaultBlockState()) && !isStone(block.defaultBlockState())) {
						break label46;
					}
				}

				if (pos.getY() <= 3) {
					return false;
				}

				for(int l = 0; l < 5; ++l) {
					int i = rand.nextInt(4);
					int j = rand.nextInt(4);
					int k = rand.nextInt(4);
					float f = (float)(i + j + k) * 0.333F + 0.5F;

					for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
						if (blockpos.distSqr(pos) <= (double)(f * f)) {
							reader.setBlock(blockpos, context.config().state, 4);
						}
					}

					pos = pos.offset(-1 + rand.nextInt(4), -rand.nextInt(4), -1 + rand.nextInt(4));
				}

				return true;
			}

			pos = pos.below();
		}
	}
}
