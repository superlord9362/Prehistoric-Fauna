package superlord.prehistoricfauna.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import superlord.prehistoricfauna.PrehistoricFauna;

public class DimensionTypeInit {

	public static final DimensionType CRETACEOUS_DIMENSION_TYPE = DimensionManager.registerOrGetDimension(new ResourceLocation(PrehistoricFauna.MODID, "cretaceous"), DimensionInit.CRETACEOUS_DIMENSION.get(), null, true);
	public static final DimensionType JURASSIC_DIMENSION_TYPE = DimensionManager.registerOrGetDimension(new ResourceLocation(PrehistoricFauna.MODID, "jurassic"), DimensionInit.JURASSIC_DIMENSION.get(), null, true);
	public static final DimensionType TRIASSIC_DIMENSION_TYPE = DimensionManager.registerOrGetDimension(new ResourceLocation(PrehistoricFauna.MODID, "triassic"), DimensionInit.TRIASSIC_DIMENSION.get(), null, true);
	
}
