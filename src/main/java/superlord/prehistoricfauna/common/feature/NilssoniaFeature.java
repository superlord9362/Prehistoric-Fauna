package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.NilssoniaBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class NilssoniaFeature extends Feature<JohnstoniaConfig> {

	public NilssoniaFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}
	
	public boolean isSoilBlock(LevelReader world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.HARDENED_SILT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(pos).getBlock() == Blocks.RED_SAND || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK);
	}

	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		MutableBlockPos pos = new MutableBlockPos(context.origin().getX(), context.origin().getY(), context.origin().getZ());
		int y = pos.getY();
		WorldGenLevel world = context.level();
		int i = 0;
		Random random = new Random();
		int height = random.nextInt(3) + 1;
		boolean isAir = false;
		for (int j = y; j < y + height; j++) {
			if (world.getBlockState(pos.above()).isAir()) {
				if (j == y + height - 1) isAir = true;
			} else {
				isAir = false;
				break;
			}
		}
		if (isAir && isSoilBlock(world, pos.below())) {
			for (int j = pos.getY(); j < y + height; j++) {
				if (height == 1) {
					world.setBlock(pos, PFBlocks.NILSSONIA.get().defaultBlockState().setValue(NilssoniaBlock.CAN_GROW, false), 2);
				} else {
					if (j <= y + height - 2) world.setBlock(pos, PFBlocks.NILSSONIA.get().defaultBlockState().setValue(NilssoniaBlock.CAN_GROW, false).setValue(NilssoniaBlock.TOP, false), 2);
					else world.setBlock(pos, PFBlocks.NILSSONIA.get().defaultBlockState().setValue(NilssoniaBlock.CAN_GROW, false), 2);
					pos.move(Direction.UP);
				}
				
			}
			i++;	
		}
		return i > 0;
	}

}
