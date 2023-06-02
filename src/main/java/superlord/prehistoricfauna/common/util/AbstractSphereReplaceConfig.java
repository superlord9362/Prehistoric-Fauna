package superlord.prehistoricfauna.common.util;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;

public class AbstractSphereReplaceConfig extends Feature<DiskConfiguration> {
	public AbstractSphereReplaceConfig(Codec<DiskConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		boolean flag = false;
		int i = context.config().radius().sample(rand);

		for(int j = pos.getX() - i; j <= pos.getX() + i; ++j) {
			for(int k = pos.getZ() - i; k <= pos.getZ() + i; ++k) {
				int l = j - pos.getX();
				int i1 = k - pos.getZ();
				if (l * l + i1 * i1 <= i * i) {
					for(int j1 = pos.getY() - context.config().halfHeight(); j1 <= pos.getY() + context.config().halfHeight(); ++j1) {
						BlockPos blockpos = new BlockPos(j, j1, k);
						Block block = world.getBlockState(blockpos).getBlock();

						for(BlockState blockstate : context.config().targets()) {
							if (blockstate.is(block)) {
								world.setBlock(blockpos, context.config().state(), 2);
								flag = true;
								break;
							}
						}
					}
				}
			}
		}

		return flag;
	}
}
