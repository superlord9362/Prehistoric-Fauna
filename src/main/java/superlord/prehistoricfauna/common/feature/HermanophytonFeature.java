package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.HermanophytonBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class HermanophytonFeature extends Feature<JohnstoniaConfig> {

	public HermanophytonFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		MutableBlockPos pos = new MutableBlockPos(context.origin().getX(), context.origin().getY(), context.origin().getZ());
		int y = pos.getY();
		WorldGenLevel world = context.level();
		int i = 0;
		Random random = new Random();
		int height = random.nextInt(9) + 10;
		boolean isAir = false;
		for (int j = y; j < y + height; j++) {
			if (world.getBlockState(pos.above()).isAir()) {
				if (j == y + height - 1) isAir = true;
			} else {
				isAir = false;
				break;
			}
		}
		if (isAir) {
			for (int j = pos.getY(); j < y + height; j++) {
				if (j <= y + height - 3) {
					world.setBlock(pos, PFBlocks.HERMANOPHYTON.get().defaultBlockState(), 2);
				} else if (j == y + height - 2) world.setBlock(pos, PFBlocks.HERMANOPHYTON.get().defaultBlockState().setValue(HermanophytonBlock.HAS_LEAVES, true), 2);
				else world.setBlock(pos, PFBlocks.HERMANOPHYTON_TOP.get().defaultBlockState(), 2);
				pos.move(Direction.UP);
			}
			i++;
		}
		return i > 0;
	}
	
}
