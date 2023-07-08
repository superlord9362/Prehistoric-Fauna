package superlord.prehistoricfauna.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFDimensions {
	
	public static final ResourceKey<DimensionType> TRIASSIC_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<DimensionType> JURASSIC_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));
	public static final ResourceKey<Level> TRIASSIC = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<Level> JURASSIC = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));

}
