package superlord.prehistoricfauna.world.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import superlord.prehistoricfauna.block.DicroidiumBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.placement.DicroidiumConfig;

import java.util.Random;
import java.util.function.Function;

public class DicroidiumFeature extends Feature<DicroidiumConfig> {
   public DicroidiumFeature(Function<Dynamic<?>, ? extends DicroidiumConfig> func) {
      super(func);
   }

   @Override
   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, DicroidiumConfig config) {
	   int i = 0;
	   for(int j = 0; j < config.count; ++j) {
		   int k = rand.nextInt(8) - rand.nextInt(8);
		   int l = rand.nextInt(8) - rand.nextInt(8);
		   int i1 = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
		   BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
		   if (worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(2)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(3)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(4)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.COARSE_DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(2)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(3)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(4)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.PODZOL || worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(2)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(3)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.up(4)).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.down()).getBlock() == BlockInit.LOAM) {
			   BlockState blockstate = BlockInit.DICROIDIUM.getDefaultState();
			   if (blockstate.isValidPosition(worldIn, blockpos)) {
				   worldIn.setBlockState(blockpos, BlockInit.DICROIDIUM.getDefaultState().with(DicroidiumBlock.LAYER, 0), 2);
				   worldIn.setBlockState(blockpos.up(), BlockInit.DICROIDIUM.getDefaultState().with(DicroidiumBlock.LAYER, 1), 2);
				   worldIn.setBlockState(blockpos.up(2), BlockInit.DICROIDIUM.getDefaultState().with(DicroidiumBlock.LAYER, 2), 2);
				   worldIn.setBlockState(blockpos.up(3), BlockInit.DICROIDIUM.getDefaultState().with(DicroidiumBlock.LAYER, 3), 2);
				   worldIn.setBlockState(blockpos.up(4), BlockInit.DICROIDIUM.getDefaultState().with(DicroidiumBlock.LAYER, 4), 2);
			   }
			   ++i;
		   }
	   }
	   return i > 0;
   }

}