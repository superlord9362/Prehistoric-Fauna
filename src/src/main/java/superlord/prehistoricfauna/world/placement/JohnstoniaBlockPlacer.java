package superlord.prehistoricfauna.world.placement;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import superlord.prehistoricfauna.block.JohnstoniaBlock;

import java.util.Random;

public class JohnstoniaBlockPlacer extends BlockPlacer {
	
	public JohnstoniaBlockPlacer() {
		super(PrehistoricPlacerType.JOHNSTONIA_BLOCK);
	}

	public <T> JohnstoniaBlockPlacer(Dynamic<T> dynamic) {
		this();
	}
	
	//generate function
	public void func_225567_a_(IWorld worldIn, BlockPos pos, BlockState state, Random rand) {
		((JohnstoniaBlock)state.getBlock()).placeAt(worldIn, pos, 2);;
	}

	@SuppressWarnings("deprecation")
	public <T> T serialize(DynamicOps<T> dynamicOps) {
		return (new Dynamic<>(dynamicOps, dynamicOps.createMap(ImmutableMap.of(dynamicOps.createString("type"), dynamicOps.createString(Registry.BLOCK_PLACER_TYPE.getKey(this.field_227258_a_).toString()))))).getValue();
	}

}
