package superlord.prehistoricfauna.common.feature.trees.zamites;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.ZamitesFrondsBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class ZamitesBushFeature extends Feature<JohnstoniaConfig>
{
	public ZamitesBushFeature(Codec<JohnstoniaConfig> codec) {
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


	@SuppressWarnings("unused")
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		Random rand = new Random();
		WorldGenLevel worldgenlevel = context.level();
		int height = rand.nextInt(3) + 2;
		int frondsChance = rand.nextInt(2);
		int secondFrondsChance = rand.nextInt(2);
		int secondFrondsHeight = rand.nextInt(3) + 1;
		int secondFrondsDirection = rand.nextInt(4);
		int frondsHeight = rand.nextInt(3) + 1;
		int frondsDirection = rand.nextInt(4);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (worldgenlevel.getBlockState(pos.below()).isSolidRender(worldgenlevel, pos.below())) {
			for (int i = pos.getY(); i <= pos.getY() + height; i++) {
				if (height == 2 && isAir(worldgenlevel, new BlockPos(x, y, z)) && isAir(worldgenlevel, new BlockPos(x, y + 1, z)) && isAir(worldgenlevel, new BlockPos(x, y + 2, z))) {
					setBlock(worldgenlevel, new BlockPos(x, y, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 1, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 2, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
				}
				if (height == 3 && isAir(worldgenlevel, new BlockPos(x, y, z)) && isAir(worldgenlevel, new BlockPos(x, y + 1, z)) && isAir(worldgenlevel, new BlockPos(x, y + 2, z)) && isAir(worldgenlevel, new BlockPos(x, y + 3, z))) {
					setBlock(worldgenlevel, new BlockPos(x, y, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 1, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 2, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 3, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
				}
				if (height == 4 && isAir(worldgenlevel, new BlockPos(x, y, z)) && isAir(worldgenlevel, new BlockPos(x, y + 1, z)) && isAir(worldgenlevel, new BlockPos(x, y + 2, z)) && isAir(worldgenlevel, new BlockPos(x, y + 3, z)) && isAir(worldgenlevel, new BlockPos(x, y + 4, z))) {
					setBlock(worldgenlevel, new BlockPos(x, y, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 1, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 2, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 3, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
					setBlock(worldgenlevel, new BlockPos(x, y + 4, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState());
				}
				if (frondsChance == 0) {
					if (frondsDirection == 0) {
						if (isAir(worldgenlevel, new BlockPos(x + 1, pos.getY() + frondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 1, pos.getY() + frondsHeight, z), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.WEST));
					}
					if (frondsDirection == 1) {
						if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.NORTH));
					}
					if (frondsDirection == 2) {
						if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.SOUTH));
					}
					if (frondsDirection == 3) {
						if (isAir(worldgenlevel, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0))) setBlock(worldgenlevel, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.EAST));
					}
				}
				if (secondFrondsChance == 2) {
					if (secondFrondsDirection == 0) {
						if (isAir(worldgenlevel, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z))) setBlock(worldgenlevel, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.WEST));
					}
					if (secondFrondsDirection == 1) {
						if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.NORTH));
					}
					if (secondFrondsDirection == 2) {
						if (isAir(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1))) setBlock(worldgenlevel, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.SOUTH));
					}
					if (secondFrondsDirection == 3) {
						if (isAir(worldgenlevel, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0))) setBlock(worldgenlevel, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.EAST));
					}
				}
				if (isAir(worldgenlevel, new BlockPos(x, pos.getY() + height + 1, z))) setBlock(worldgenlevel, new BlockPos(x, pos.getY() + height + 1, z), PFBlocks.ZAMITES_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				return true;
			}
		} else {
			return false;
		}
		return false;
	}


}
