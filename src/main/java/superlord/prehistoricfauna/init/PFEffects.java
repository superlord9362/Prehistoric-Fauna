package superlord.prehistoricfauna.init;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.effects.BleedingEffect;

public class PFEffects {
	
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding", () -> new BleedingEffect(EffectType.HARMFUL, 0x8B0D0E));

}
