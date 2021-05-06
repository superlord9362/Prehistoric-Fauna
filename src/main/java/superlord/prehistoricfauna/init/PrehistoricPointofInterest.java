package superlord.prehistoricfauna.init;

import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PrehistoricPointofInterest {
	public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, PrehistoricFauna.MODID);

    public static final RegistryObject<PointOfInterestType> TRIASSIC_PORTAL = POI_TYPES.register("triassic_portal", () -> new PointOfInterestType("triassic_portal", PointOfInterestType.getAllStates(BlockInit.TRIASSIC_PORTAL.get()), 0, 1));
    public static final RegistryObject<PointOfInterestType> JURASSIC_PORTAL = POI_TYPES.register("jurassic_portal", () -> new PointOfInterestType("jurassic_portal", PointOfInterestType.getAllStates(BlockInit.JURASSIC_PORTAL.get()), 0, 1));
    public static final RegistryObject<PointOfInterestType> CRETACEOUS_PORTAL = POI_TYPES.register("cretaceous_portal", () -> new PointOfInterestType("cretaceous_portal", PointOfInterestType.getAllStates(BlockInit.CRETACEOUS_PORTAL.get()), 0, 1));

}
