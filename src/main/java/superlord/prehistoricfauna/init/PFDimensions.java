package superlord.prehistoricfauna.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFDimensions {
	
	public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, PrehistoricFauna.MOD_ID);
	
	public static final ResourceKey<DimensionType> TRIASSIC_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<DimensionType> JURASSIC_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));
	public static final ResourceKey<Level> TRIASSIC = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<Level> JURASSIC = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));

	public static final RegistryObject<PoiType> TRIASSIC_PORTAL = POI_TYPES.register("triassic_portal", () -> new PoiType("triassic_portal", ImmutableSet.copyOf(PFBlocks.TRIASSIC_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

}
