package superlord.prehistoricfauna.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.effect.BleedingEffect;

public class PFEffects {

	public static final DeferredRegister<MobEffect> REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<MobEffect> BLEEDING = REGISTER.register("bleeding", () -> new BleedingEffect(MobEffectCategory.HARMFUL, 0x8B0D0E));

}
