package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractSphereReplaceConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;

public class LandSphereReplaceFeature extends AbstractSphereReplaceConfig {
   public LandSphereReplaceFeature(Codec<SphereReplaceConfig> p_i231949_1_) {
      super(p_i231949_1_);
   }

   public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, SphereReplaceConfig config) {
      return super.generate(reader, generator, rand, pos, config);
   }
}
