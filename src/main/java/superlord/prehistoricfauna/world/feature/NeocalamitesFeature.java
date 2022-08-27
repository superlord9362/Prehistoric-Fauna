package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.common.blocks.NeocalamitesBlock;
import superlord.prehistoricfauna.common.blocks.NeocalamitesTopBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;

public class NeocalamitesFeature extends Feature<JohnstoniaConfig> {

	public NeocalamitesFeature(Codec<JohnstoniaConfig> func) {
		super(func);
	}

	@SuppressWarnings({ "static-access" })
	@Override
	public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, JohnstoniaConfig config) {
		int i = 0;
		for (int j = 0; j < config.count; ++j) {
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int i1 = world.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
			BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
			if ((world.getBlockState(blockpos).getBlock() == Blocks.AIR) && world.getBlockState(blockpos.up()).getBlock() == Blocks.AIR && world.getBlockState(blockpos.up(2)).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.down()).getBlock() == Blocks.PODZOL || world.getBlockState(blockpos.down()).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.down()).getBlock() == PFBlocks.MOSSY_DIRT || world.getBlockState(blockpos.down()).getBlock() == PFBlocks.LOAM || world.getBlockState(blockpos.down()).getBlock() == PFBlocks.PACKED_LOAM || world.getBlockState(blockpos.down()).getBlock() == PFBlocks.SILT || world.getBlockState(blockpos.down()).getBlock() == PFBlocks.HARDENED_SILT || world.getBlockState(blockpos.down()).getBlock() == Blocks.SAND)) {
				int twoOrThree = rand.nextInt(3);
				if (twoOrThree == 0) {
					world.setBlockState(blockpos, PFBlocks.NEOCALAMITES.getDefaultState().with(NeocalamitesBlock.PROPERTY_STAGE, 1).with(NeocalamitesBlock.WATERLOGGED, false).with(NeocalamitesBlock.PLAYER_PLACED, false), l);
					world.setBlockState(blockpos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(NeocalamitesTopBlock.PROPERTY_STAGE, 1).with(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
				} else if (twoOrThree == 1) {
					world.setBlockState(blockpos, PFBlocks.NEOCALAMITES.getDefaultState().with(NeocalamitesBlock.PROPERTY_STAGE, 0).with(NeocalamitesBlock.WATERLOGGED, false).with(NeocalamitesBlock.PLAYER_PLACED, false), l);
				} else {
					world.setBlockState(blockpos, PFBlocks.NEOCALAMITES.getDefaultState().with(NeocalamitesBlock.PROPERTY_STAGE, 2).with(NeocalamitesBlock.WATERLOGGED, false).with(NeocalamitesBlock.PLAYER_PLACED, false), l);
					world.setBlockState(blockpos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(NeocalamitesTopBlock.PROPERTY_STAGE, 2).with(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
					world.setBlockState(blockpos.up(2), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(NeocalamitesTopBlock.PROPERTY_STAGE, 2).with(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 2), l);
				}
				++i;
			}
			if(world.getBlockState(blockpos.down()).getBlock() == Blocks.WATER && world.getBlockState(blockpos).getBlock() == Blocks.AIR && world.getBlockState(blockpos.up()).getBlock() == Blocks.AIR && (world.getBlockState(blockpos.down(2)).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(blockpos.down(2)).getBlock() == PFBlocks.PACKED_LOAM || world.getBlockState(blockpos.down(2)).getBlock() == PFBlocks.SILT || world.getBlockState(blockpos.down(2)).getBlock() == Blocks.SAND)) {
				int twoOrThree = rand.nextInt(2);
				if (twoOrThree == 0) {
					world.setBlockState(blockpos.down(), PFBlocks.NEOCALAMITES.getDefaultState().with(NeocalamitesBlock.PROPERTY_STAGE, 1).with(NeocalamitesBlock.WATERLOGGED, true).with(NeocalamitesBlock.PLAYER_PLACED, false), l);
					world.setBlockState(blockpos, PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(NeocalamitesTopBlock.PROPERTY_STAGE, 1).with(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
				} else {
					world.setBlockState(blockpos.down(), PFBlocks.NEOCALAMITES.getDefaultState().with(NeocalamitesBlock.PROPERTY_STAGE, 2).with(NeocalamitesBlock.WATERLOGGED, true).with(NeocalamitesBlock.PLAYER_PLACED, false), l);
					world.setBlockState(blockpos, PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(NeocalamitesTopBlock.PROPERTY_STAGE, 2).with(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 1), l);
					world.setBlockState(blockpos.up(), PFBlocks.NEOCALAMITES_TOP.getDefaultState().with(NeocalamitesTopBlock.PROPERTY_STAGE, 2).with(NeocalamitesTopBlock.PROPERTY_NEOCALAMITES_LEAVES, 2), l);
				}
				++i;
			}
		}
		return i > 0;
	}

}