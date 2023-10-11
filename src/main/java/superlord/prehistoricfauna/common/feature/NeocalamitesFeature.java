package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.NeocalamitesBlock;
import superlord.prehistoricfauna.common.blocks.NeocalamitesTopBlock;
import superlord.prehistoricfauna.common.feature.trees.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class NeocalamitesFeature extends Feature<JohnstoniaConfig> {

	public NeocalamitesFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}

	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		int i = 0;
		int y = pos.getY();
		if (y < 70) {
			for (int p = 0; p < 4; p++) {
				placeCalamites(context);
				i++;
			}
		}
		if (y >= 70 && y < 75) {
			for (int p = 0; p <= 2; p++) {
				placeCalamites(context);
				i++;
			}
		}
		if (y >= 75 && y < 80) {
			for (int p = 0; p <= 1; p++) {
				placeCalamites(context);
				i++;
			}
		}
		return i > 0;
	}

	public void placeCalamites(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		context.config();
		for (int j = 0; j < JohnstoniaConfig.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if (pos.getY() < 80) {
				if ((world.getBlockState(blockpos).getBlock() == Blocks.AIR) && world.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && world.getBlockState(blockpos.above(2)).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below()).getBlock() == Blocks.PODZOL || world.getBlockState(blockpos.below()).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below()).getBlock() == PFBlocks.HARDENED_SILT.get() || world.getBlockState(blockpos.below()).getBlock() == Blocks.SAND)) {
					int twoOrThree = rand.nextInt(3);
					if (twoOrThree == 0) {
						world.setBlock(blockpos, PFBlocks.NEOCALAMITES.get().defaultBlockState().setValue(NeocalamitesBlock.PROPERTY_STAGE, 1).setValue(NeocalamitesBlock.WATERLOGGED, false).setValue(NeocalamitesBlock.PLAYER_PLACED, false), l);
						world.setBlock(blockpos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(NeocalamitesTopBlock.PROPERTY_STAGE, 1).setValue(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
					} else if (twoOrThree == 1) {
						world.setBlock(blockpos, PFBlocks.NEOCALAMITES.get().defaultBlockState().setValue(NeocalamitesBlock.PROPERTY_STAGE, 0).setValue(NeocalamitesBlock.WATERLOGGED, false).setValue(NeocalamitesBlock.PLAYER_PLACED, false), l);
					} else {
						world.setBlock(blockpos, PFBlocks.NEOCALAMITES.get().defaultBlockState().setValue(NeocalamitesBlock.PROPERTY_STAGE, 2).setValue(NeocalamitesBlock.WATERLOGGED, false).setValue(NeocalamitesBlock.PLAYER_PLACED, false), l);
						world.setBlock(blockpos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(NeocalamitesTopBlock.PROPERTY_STAGE, 2).setValue(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
						world.setBlock(blockpos.above(2), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(NeocalamitesTopBlock.PROPERTY_STAGE, 2).setValue(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 2), l);
					}
				}
				if(world.getBlockState(blockpos.below()).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && world.getBlockState(blockpos.above()).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.below(2)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(blockpos.below(2)).getBlock() == PFBlocks.SILT.get() || world.getBlockState(blockpos.below(2)).getBlock() == Blocks.SAND)) {
					int twoOrThree = rand.nextInt(2);
					if (twoOrThree == 0) {
						world.setBlock(blockpos.below(), PFBlocks.NEOCALAMITES.get().defaultBlockState().setValue(NeocalamitesBlock.PROPERTY_STAGE, 1).setValue(NeocalamitesBlock.WATERLOGGED, true).setValue(NeocalamitesBlock.PLAYER_PLACED, false), l);
						world.setBlock(blockpos, PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(NeocalamitesTopBlock.PROPERTY_STAGE, 1).setValue(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
					} else {
						world.setBlock(blockpos.below(), PFBlocks.NEOCALAMITES.get().defaultBlockState().setValue(NeocalamitesBlock.PROPERTY_STAGE, 2).setValue(NeocalamitesBlock.WATERLOGGED, true).setValue(NeocalamitesBlock.PLAYER_PLACED, false), l);
						world.setBlock(blockpos, PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(NeocalamitesTopBlock.PROPERTY_STAGE, 2).setValue(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
						world.setBlock(blockpos.above(), PFBlocks.NEOCALAMITES_TOP.get().defaultBlockState().setValue(NeocalamitesTopBlock.PROPERTY_STAGE, 2).setValue(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 2), l);
					}
				}
			}
		}
	}

}