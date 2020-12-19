package superlord.prehistoricfauna.world;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.placement.PtilophyllumPlacement;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public abstract class PrehistoricPlacement {

   public static final Placement<NoPlacementConfig> PTILOPHYLLUM_TREE = register("ptilophyllum_tree", new PtilophyllumPlacement(NoPlacementConfig::deserialize));

   @SuppressWarnings({ "unchecked", "deprecation" })
   private static <T extends IPlacementConfig, G extends Placement<T>> G register(String key, G p_214999_1_) {
      return (G)(Registry.<Placement<?>>register(Registry.DECORATOR, key, p_214999_1_));
   }

}