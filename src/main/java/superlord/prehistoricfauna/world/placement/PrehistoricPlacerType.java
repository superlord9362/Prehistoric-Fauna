package superlord.prehistoricfauna.world.placement;

import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public class PrehistoricPlacerType {
	
	public static final BlockPlacerType<DicroidiumBlockPlacer> DICROIDIUM_BLOCK = register("dicroidium_block_placer", DicroidiumBlockPlacer::new);
	public static final BlockPlacerType<JohnstoniaBlockPlacer> JOHNSTONIA_BLOCK = register("johnstonia_block_placer", JohnstoniaBlockPlacer::new);
	
	@SuppressWarnings("deprecation")
	private static <P extends BlockPlacer> BlockPlacerType<P> register(String p_227264_0_, Function<Dynamic<?>, P> p_227264_1_) {
		return Registry.register(Registry.BLOCK_PLACER_TYPE, p_227264_0_, new BlockPlacerType<>(p_227264_1_));
	}
	
}
