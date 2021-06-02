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
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;
import java.util.function.Function;

public class AlgaeFeature extends Feature<AlgaeFeatureConfig> {
   public AlgaeFeature(Function<Dynamic<?>, ? extends AlgaeFeatureConfig> func) {
      super(func);
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, AlgaeFeatureConfig config) {
      int i = 0;

      for(int j = 0; j < config.count; ++j) {
         int k = rand.nextInt(8) - rand.nextInt(8);
         int l = rand.nextInt(8) - rand.nextInt(8);
         int i1 = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
         BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
         if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.SAND || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.COARSE_DIRT) {
            BlockState blockstate = BlockInit.ALGAE_CARPET.get().getDefaultState();
            if (blockstate.isValidPosition(worldIn, blockpos)) {
            	worldIn.setBlockState(blockpos, blockstate, 2);
            }
            ++i;
         }
      }
      return i > 0;
   }
}