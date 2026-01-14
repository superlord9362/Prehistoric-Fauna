package superlord.prehistoricfauna.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFBannerPatterns {
	public static final DeferredRegister<BannerPattern> REGISTER = DeferredRegister.create(Registries.BANNER_PATTERN, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<BannerPattern> CLAW = REGISTER.register("claw", () -> new BannerPattern("claw"));
	public static final RegistryObject<BannerPattern> AETOSAUR = REGISTER.register("aetosaur", () -> new BannerPattern("aetosaur"));
	public static final RegistryObject<BannerPattern> HENOS = REGISTER.register("henos", () -> new BannerPattern("henos"));
	public static final RegistryObject<BannerPattern> OYSTER = REGISTER.register("oyster", () -> new BannerPattern("oyster"));
	public static final RegistryObject<BannerPattern> SPIRAL = REGISTER.register("spiral", () -> new BannerPattern("spiral"));
	public static final RegistryObject<BannerPattern> THAGOMIZER = REGISTER.register("thagomizer", () -> new BannerPattern("thagomizer"));
	public static final RegistryObject<BannerPattern> TRICERATOPS = REGISTER.register("triceratops", () -> new BannerPattern("triceratops"));
	
}
