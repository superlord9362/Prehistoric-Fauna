package superlord.prehistoricfauna.common.feature;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import superlord.prehistoricfauna.common.feature.util.AbstractSphereReplaceConfig;

public class LandSphereReplaceFeature extends AbstractSphereReplaceConfig {
   public LandSphereReplaceFeature(Codec<DiskConfiguration> p_i231949_1_) {
      super(p_i231949_1_);
   }

	public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
      return super.place(context);
   }
}
