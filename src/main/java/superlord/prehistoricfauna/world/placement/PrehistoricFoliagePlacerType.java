package superlord.prehistoricfauna.world.placement;

import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.feature.generator.ZamitesFoliageGenerator;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public class PrehistoricFoliagePlacerType {
	   
	public static final FoliagePlacerType<ZamitesFoliageGenerator> ZAMITES = register("zamites_foliage_generator", ZamitesFoliageGenerator::new);
	
	@SuppressWarnings("deprecation")
	private static <P extends FoliagePlacer> FoliagePlacerType<P> register(String p_227392_0_, Function<Dynamic<?>, P> p_227392_1_) {
		return Registry.register(Registry.FOLIAGE_PLACER_TYPE, p_227392_0_, new FoliagePlacerType<>(p_227392_1_));
	}

}
