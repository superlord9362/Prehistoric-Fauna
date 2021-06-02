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
import superlord.prehistoricfauna.block.CrassostreaOysterBlock;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;
import java.util.function.Function;

public class CrassostreaOystersFeature extends Feature<CrassostreaOystersConfig> {
   public CrassostreaOystersFeature(Function<Dynamic<?>, ? extends CrassostreaOystersConfig> func) {
      super(func);
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CrassostreaOystersConfig config) {
      int i = 0;

      for(int j = 0; j < config.count; ++j) {
         int k = rand.nextInt(8) - rand.nextInt(8);
         int l = rand.nextInt(8) - rand.nextInt(8);
         int i1 = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
         BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
         if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.SAND) {
            BlockState blockstate = BlockInit.CRASSOSTREA_OYSTER.get().getDefaultState().with(CrassostreaOysterBlock.AGE, Integer.valueOf(2));
            if (blockstate.isValidPosition(worldIn, blockpos)) {
            	worldIn.setBlockState(blockpos, blockstate, 2);
            }
            ++i;
         }
      }
      return i > 0;
   }
}