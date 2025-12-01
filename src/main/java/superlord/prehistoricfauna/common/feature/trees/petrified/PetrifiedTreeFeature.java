package superlord.prehistoricfauna.common.feature.trees.petrified;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFTags;

public class PetrifiedTreeFeature extends Feature<JohnstoniaConfig>
{
	public PetrifiedTreeFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}


	public static boolean isAir(LevelSimulatedReader worldgenlevel, BlockPos pos) {
		if (worldgenlevel instanceof BlockGetter) // FORGE: Redirect to state method when possible
			return worldgenlevel.isStateAtPosition(pos, state -> state.isAir());
		return worldgenlevel.isStateAtPosition(pos, BlockState::isAir);
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader worldgenlevel, BlockPos pos) {
		return worldgenlevel.isStateAtPosition(pos, (p_227223_0_) -> {
			return p_227223_0_.isAir() || p_227223_0_.is(BlockTags.LEAVES);
		});
	}
	


	public static boolean isSoil(WorldGenLevel worldgenlevel, BlockPos pos) {
		return (worldgenlevel.getBlockState(pos).is(Blocks.SAND) || worldgenlevel.getBlockState(pos).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(pos).is(Blocks.GRASS_BLOCK) || worldgenlevel.getBlockState(pos).is(Blocks.PODZOL) || worldgenlevel.getBlockState(pos).is(Blocks.MYCELIUM) || worldgenlevel.getBlockState(pos).is(Blocks.DIRT) || worldgenlevel.getBlockState(pos).is(Blocks.COARSE_DIRT) || worldgenlevel.getBlockState(pos).is(PFBlocks.LOAM.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.PACKED_LOAM.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.SILT.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.HARDENED_SILT.get()) || worldgenlevel.getBlockState(pos).is(PFBlocks.MOSSY_DIRT.get()));
	}


	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		Random rand = new Random();
		WorldGenLevel world = context.level();
		int height = rand.nextInt(2) + 2;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (world.getBlockState(pos.below()).getBlock() != Blocks.WATER && isSoil(world, pos.below()) && !world.getBlockState(pos.below()).is(PFTags.HENOSTONE)) {
			if (height == 3) {
				if (isAir(world, new BlockPos(x, y, z)) && isAir(world, new BlockPos(x, y + 1, z)) && isAir(world, new BlockPos(x, y + 2, z))) {
					setBlock(world, new BlockPos(x, y, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
					setBlock(world, new BlockPos(x, y + 1, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
					setBlock(world, new BlockPos(x, y + 2, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
					return true;
				}
			}
			if (height == 2) {
				if (isAir(world, new BlockPos(x, y, z)) && isAir(world, new BlockPos(x, y + 1, z))) {
					setBlock(world, new BlockPos(x, y, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
					setBlock(world, new BlockPos(x, y + 1, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
					return true;
				}
			}
		}
		return false;
	}


}
