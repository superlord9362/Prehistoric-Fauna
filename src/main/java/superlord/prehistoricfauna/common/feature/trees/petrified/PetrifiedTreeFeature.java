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


	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		Random rand = new Random();
		WorldGenLevel world = context.level();
		int height = rand.nextInt(2) + 2;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (world.getBlockState(pos.below()).getBlock() != Blocks.WATER && world.getBlockState(pos.below()).isCollisionShapeFullBlock(world, pos.below()) && world.getBlockState(pos.below()).is(PFTags.HENOSTONE)) {
			if (height == 3) {
				if (isAir(world, new BlockPos(x, y, z))) setBlock(world, new BlockPos(x, y, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
				if (isAir(world, new BlockPos(x, y + 1, z))) setBlock(world, new BlockPos(x, y + 1, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
				if (isAir(world, new BlockPos(x, y + 2, z))) setBlock(world, new BlockPos(x, y + 2, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
			}
			if (height == 2) {
				if (isAir(world, new BlockPos(x, y, z))) setBlock(world, new BlockPos(x, y, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
				if (isAir(world, new BlockPos(x, y + 1, z))) setBlock(world, new BlockPos(x, y + 1, z), PFBlocks.PETRIFIED_WOOD.get().defaultBlockState());
			}
		}
		return false;
	}


}
