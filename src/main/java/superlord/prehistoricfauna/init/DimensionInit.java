package superlord.prehistoricfauna.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.dimension.CretaceousModDimension;
import superlord.prehistoricfauna.world.dimension.JurassicModDimension;
import superlord.prehistoricfauna.world.dimension.TriassicModDimension;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public class DimensionInit{
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, PrehistoricFauna.MODID);
	
	public static final RegistryObject<ModDimension> CRETACEOUS_DIMENSION = MOD_DIMENSIONS.register("cretaceous_dimension", () -> new CretaceousModDimension());
	public static final RegistryObject<ModDimension> JURASSIC_DIMENSION = MOD_DIMENSIONS.register("jurassic_dimension", () -> new JurassicModDimension());
	public static final RegistryObject<ModDimension> TRIASSIC_DIMENSION = MOD_DIMENSIONS.register("triassic_dimension", () -> new TriassicModDimension());
	
	public static final ResourceLocation CRETACEOUS_DIM_TYPE = new ResourceLocation(PrehistoricFauna.MODID, "cretaceous");
	public static final ResourceLocation JURASSIC_DIM_TYPE = new ResourceLocation(PrehistoricFauna.MODID, "jurassic");
	public static final ResourceLocation TRIASSIC_DIM_TYPE = new ResourceLocation(PrehistoricFauna.MODID, "triassic");
	
	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if(DimensionType.byName(CRETACEOUS_DIM_TYPE) == null) {
			DimensionManager.registerDimension(CRETACEOUS_DIM_TYPE, CRETACEOUS_DIMENSION.get(), null, true);
		}
		if(DimensionType.byName(JURASSIC_DIM_TYPE) == null) {
			DimensionManager.registerDimension(JURASSIC_DIM_TYPE, JURASSIC_DIMENSION.get(), null, true);
		}
		if(DimensionType.byName(TRIASSIC_DIM_TYPE) == null) {
			DimensionManager.registerDimension(TRIASSIC_DIM_TYPE, TRIASSIC_DIMENSION.get(), null, true);
		}
		PrehistoricFauna.LOGGER.info("Dimensions Registered");
	}
	
}
