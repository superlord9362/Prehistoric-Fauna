package superlord.prehistoricfauna.world.feature.trees.zamites;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.common.blocks.ZamitesFrondsBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;

public class ZamiteBushFeature extends Feature<JohnstoniaConfig>
{
	public ZamiteBushFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}

	protected static boolean isSoil(ISeedReader reader, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
		if (!(reader instanceof net.minecraft.world.IBlockReader) || sapling == null)
			return isDirtOrGrassBlock(reader, pos);
		return reader.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader)reader, pos, Direction.UP, sapling));
	}

	@Deprecated //Forge: moved to isSoil
	public static boolean isDirtOrGrassBlock(ISeedReader worldIn, BlockPos pos) {
		return worldIn.hasBlockState(pos, (p_227221_0_) -> {
			return isDirt(p_227221_0_.getBlock());
		});
	}

	@SuppressWarnings("deprecation")
	public static boolean isAir(ISeedReader worldIn, BlockPos pos) {
		if (worldIn instanceof net.minecraft.world.IBlockReader) // FORGE: Redirect to state method when possible
			return worldIn.hasBlockState(pos, state -> state.isAir((net.minecraft.world.IBlockReader)worldIn, pos));
		return worldIn.hasBlockState(pos, BlockState::isAir);
	}

	@SuppressWarnings("deprecation")
	public static boolean isAirOrLeaves(ISeedReader worldIn, BlockPos pos) {
		if (worldIn instanceof net.minecraft.world.IWorldReader) // FORGE: Redirect to state method when possible
			return worldIn.hasBlockState(pos, state -> state.canBeReplacedByLeaves((net.minecraft.world.IWorldReader)worldIn, pos));
		return worldIn.hasBlockState(pos, (p_227223_0_) -> {
			return p_227223_0_.isAir() || p_227223_0_.isIn(BlockTags.LEAVES);
		});
	}

	@Override
	public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos startPosition, JohnstoniaConfig config) {
		BlockPos pos = startPosition;
		// Moving down until it is on the ground
		while (pos.getY() > 1 && isAirOrLeaves(worldIn, pos)) pos = pos.down();

		if (!isSoil(worldIn, pos, null))
		{
			return false; // this tree is only allowed to grow on soil, but not on water or plant or other thing
		}
		pos = pos.up();
		// Make main trunk
		// Randomize the height
		int height = rand.nextInt(3) + 2;
		int frondsChance = rand.nextInt(2);
		int secondFrondsChance = rand.nextInt(2);
		int secondFrondsHeight = rand.nextInt(3) + 1;
		int secondFrondsDirection = rand.nextInt(4);
		int frondsHeight = rand.nextInt(3) + 1;
		int frondsDirection = rand.nextInt(4);
		int x = pos.getX();
		int z = pos.getZ();
		if (pos.getY() >= 1 && pos.getY() + height + 2 <= 256)
		{
			for (int j = pos.getY(); j <= pos.getY() + height; j++)
			{
				if (isAir(worldIn, new BlockPos(x, j, z))) setBlockState(worldIn, new BlockPos(x, j, z), PFBlocks.ZAMITES_LOG.getDefaultState());
				if (frondsChance == 0) {
					if (frondsDirection == 0) {
						if (isAir(worldIn, new BlockPos(x + 1, pos.getY() + frondsHeight, z))) setBlockState(worldIn, new BlockPos(x + 1, pos.getY() + frondsHeight, z), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.WEST));
					}
					if (frondsDirection == 1) {
						if (isAir(worldIn, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1))) setBlockState(worldIn, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.NORTH));
					}
					if (frondsDirection == 2) {
						if (isAir(worldIn, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1))) setBlockState(worldIn, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.SOUTH));
					}
					if (frondsDirection == 3) {
						if (isAir(worldIn, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0))) setBlockState(worldIn, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.EAST));
					}
				}
				if (secondFrondsChance == 2) {
					if (secondFrondsDirection == 0) {
						if (isAir(worldIn, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z))) setBlockState(worldIn, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.WEST));
					}
					if (secondFrondsDirection == 1) {
						if (isAir(worldIn, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1))) setBlockState(worldIn, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.NORTH));
					}
					if (secondFrondsDirection == 2) {
						if (isAir(worldIn, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1))) setBlockState(worldIn, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.SOUTH));
					}
					if (secondFrondsDirection == 3) {
						if (isAir(worldIn, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0))) setBlockState(worldIn, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0), PFBlocks.ZAMITES_FROND.getDefaultState().with(ZamitesFrondsBlock.HORIZONTAL_FACING, Direction.EAST));
					}
				}
			}
			if (isAir(worldIn, new BlockPos(x, pos.getY() + height + 1, z))) setBlockState(worldIn, new BlockPos(x, pos.getY() + height + 1, z), PFBlocks.ZAMITES_LEAVES.getDefaultState());
			return true;
		}
		return false;
	}


}
