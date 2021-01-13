package superlord.prehistoricfauna.world.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class AlgaeFeatureConfig implements IFeatureConfig {
   public final int count;

   public AlgaeFeatureConfig(int count) {
      this.count = count;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("count"), ops.createInt(this.count))));
   }

   public static <T> AlgaeFeatureConfig deserialize(Dynamic<T> p_214659_0_) {
      int i = p_214659_0_.get("count").asInt(0);
      return new AlgaeFeatureConfig(i);
   }
}