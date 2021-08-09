package superlord.prehistoricfauna.world.decorator;

import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class PtilophyllumPlacement extends Placement<NoPlacementConfig> {
	public PtilophyllumPlacement(Codec<NoPlacementConfig> p_i51391_1_) {
		super(p_i51391_1_);
	}

	@Override
	public Stream<BlockPos> getPositions(WorldDecoratingHelper helper, Random random, NoPlacementConfig config, BlockPos pos) {
		int i = random.nextInt(2);
		return IntStream.range(0, i).mapToObj((p_227435_3_) -> {
			int j = random.nextInt(2) + pos.getX();
			int k = random.nextInt(2) + pos.getZ();
			int l = helper.func_242893_a(Heightmap.Type.MOTION_BLOCKING, j, k);
			if (l > 0) {
				int i1 = l - 1;
				return new BlockPos(j, i1, k);
			} else {
				return null;
			}
		}).filter(Objects::nonNull);
	}
}
