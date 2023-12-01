package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.TaxodiumKneeBlock;
import superlord.prehistoricfauna.common.blocks.TaxodiumKneeBlock.KneeThickness;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class TaxodiumKneeFeature extends Feature<JohnstoniaConfig> {

	public TaxodiumKneeFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}
	
	public boolean isSoilBlock(WorldGenLevel world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get());
	}
	
	public boolean isAirBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.AIR;
	}
	
	public boolean isWaterBlock(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.WATER;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		int i = 0;
		for (int j = 0; j < context.config().count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			int k1 = rand.nextInt(10);
			if (isAirBlock(world, blockpos) && isSoilBlock(world, blockpos.below()) && k1 < 3) {
				world.setBlock(blockpos, PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.TOP), 1);
			}
			if (isWaterBlock(world, blockpos.below()) && isAirBlock(world, blockpos) && isAirBlock(world, blockpos.above()) && isSoilBlock(world, blockpos.below(2))) {
				int j1 = rand.nextInt(10);
				if (j1 % 2 == 0) {
					world.setBlock(blockpos.below(), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.TOP).setValue(TaxodiumKneeBlock.WATERLOGGED, true), 1);
				} else {
					world.setBlock(blockpos.below(), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.MIDDLE).setValue(TaxodiumKneeBlock.WATERLOGGED, true), 1);
					world.setBlock(blockpos, PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.TOP).setValue(TaxodiumKneeBlock.WATERLOGGED, false), 1);
				}
			}
			if (isWaterBlock(world, blockpos.below()) && isWaterBlock(world, blockpos.below(2)) && isAirBlock(world, blockpos) && isSoilBlock(world, blockpos.below(3))) {
				int j1 = rand.nextInt(10);
				if (j1 % 2 == 0) {
					world.setBlock(blockpos.below(2), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.MIDDLE).setValue(TaxodiumKneeBlock.WATERLOGGED, true), 1);
					world.setBlock(blockpos.below(), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.TOP).setValue(TaxodiumKneeBlock.WATERLOGGED, true), 1);
				} else {
					world.setBlock(blockpos.below(2), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.BASE).setValue(TaxodiumKneeBlock.WATERLOGGED, true), 1);
					world.setBlock(blockpos.below(), PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.MIDDLE).setValue(TaxodiumKneeBlock.WATERLOGGED, true), 1);
					world.setBlock(blockpos, PFBlocks.TAXODIUM_KNEE.get().defaultBlockState().setValue(TaxodiumKneeBlock.THICKNESS, KneeThickness.TOP).setValue(TaxodiumKneeBlock.WATERLOGGED, false), 1);
				}
			}
			++i;
		}
		return i > 0;
	}

}
