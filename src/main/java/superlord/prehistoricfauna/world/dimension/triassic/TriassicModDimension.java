package superlord.prehistoricfauna.world.dimension.triassic;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.BiFunction;

public class TriassicModDimension extends ModDimension{
	
	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
		return TriassicDimension::new;
	}

}
