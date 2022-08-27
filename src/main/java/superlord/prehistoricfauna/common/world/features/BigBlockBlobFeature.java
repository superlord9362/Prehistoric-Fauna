package superlord.prehistoricfauna.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class BigBlockBlobFeature extends Feature<BlockStateFeatureConfig> {
   public BigBlockBlobFeature(Codec<BlockStateFeatureConfig> p_i231931_1_) {
      super(p_i231931_1_);
   }

   public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
      while(true) {
         label46: {
            if (pos.getY() > 3) {
               if (reader.isAirBlock(pos.down())) {
                  break label46;
               }

               Block block = reader.getBlockState(pos.down()).getBlock();
               if (!isDirt(block) && !isStone(block)) {
                  break label46;
               }
            }

            if (pos.getY() <= 3) {
               return false;
            }

            for(int l = 0; l < 5; ++l) {
               int i = rand.nextInt(4);
               int j = rand.nextInt(4);
               int k = rand.nextInt(4);
               float f = (float)(i + j + k) * 0.333F + 0.5F;

               for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-i, -j, -k), pos.add(i, j, k))) {
                  if (blockpos.distanceSq(pos) <= (double)(f * f)) {
                     reader.setBlockState(blockpos, config.state, 4);
                  }
               }

               pos = pos.add(-1 + rand.nextInt(4), -rand.nextInt(4), -1 + rand.nextInt(4));
            }

            return true;
         }

         pos = pos.down();
      }
   }
}
