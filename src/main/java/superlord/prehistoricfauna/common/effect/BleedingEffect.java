package superlord.prehistoricfauna.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import superlord.prehistoricfauna.init.PFDamageSources;

public class BleedingEffect extends MobEffect {
	
	public BleedingEffect(MobEffectCategory type, int liquidColor) {
		super(type, liquidColor);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entityLivingBase, int amplifier) {
		if (entityLivingBase.getDeltaMovement().x !=  0 && entityLivingBase.getDeltaMovement().y != 0 && entityLivingBase.getDeltaMovement().z != 0) {
			entityLivingBase.hurt(PFDamageSources.BLEEDING, 1.0F);
		}
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
		int k = 25 >> amplifier;
		if (k > 0) {
			return duration % k == 0;
		} else {
			return true;
		}
	}
}
