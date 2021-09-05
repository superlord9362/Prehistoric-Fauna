package superlord.prehistoricfauna.world.feature.trees.zamites;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;

public class ZamiteBushFeature extends Feature<BaseTreeFeatureConfig>
{
	public ZamiteBushFeature(Codec<BaseTreeFeatureConfig> codec) {
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
	public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos startPosition, BaseTreeFeatureConfig config) {
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
		int x = pos.getX();
		int z = pos.getZ();
		if (pos.getY() >= 1 && pos.getY() + height + 2 <= 256)
		{
			for (int j = pos.getY(); j <= pos.getY() + height; j++)
			{
				if (isAir(worldIn, new BlockPos(x, j, z))) setBlockState(worldIn, new BlockPos(x, j, z), PFBlocks.ZAMITES_LOG.getDefaultState());
			}
			if (isAir(worldIn, new BlockPos(x, pos.getY() + height + 1, z))) setBlockState(worldIn, new BlockPos(x, startPosition.getY() + height + 1, z), PFBlocks.ZAMITES_LEAVES.getDefaultState());
			return true;
		}
		return false;
	}


}
