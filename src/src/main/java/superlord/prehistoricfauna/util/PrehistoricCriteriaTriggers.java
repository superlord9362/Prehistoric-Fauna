package superlord.prehistoricfauna.util;

import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Map;

public class PrehistoricCriteriaTriggers {
   private static final Map<ResourceLocation, ICriterionTrigger<?>> REGISTRY = Maps.newHashMap();
   public static final BredDinosaurTrigger BRED_DINOSAUR = register(new BredDinosaurTrigger());

   public static <T extends ICriterionTrigger<?>> T register(T criterion) {
      if (REGISTRY.containsKey(criterion.getId())) {
         throw new IllegalArgumentException("Duplicate criterion id " + criterion.getId());
      } else {
         REGISTRY.put(criterion.getId(), criterion);
         return criterion;
      }
   }

   @SuppressWarnings("unchecked")
   @Nullable
   public static <T extends ICriterionInstance> ICriterionTrigger<T> get(ResourceLocation id) {
      return (ICriterionTrigger<T>)REGISTRY.get(id);
   }

   public static Iterable<? extends ICriterionTrigger<?>> getAll() {
      return REGISTRY.values();
   }
}