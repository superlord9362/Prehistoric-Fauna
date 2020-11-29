package superlord.prehistoricfauna.world.placement;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class DidelphodonBurrowConfig implements IFeatureConfig {
   public final int count;

   public DidelphodonBurrowConfig(int count) {
      this.count = count;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("count"), ops.createInt(this.count))));
   }

   public static <T> DidelphodonBurrowConfig deserialize(Dynamic<T> p_214659_0_) {
      int i = p_214659_0_.get("count").asInt(0);
      return new DidelphodonBurrowConfig(i);
   }
}