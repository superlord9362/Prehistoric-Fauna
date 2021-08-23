package superlord.prehistoricfauna.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import superlord.prehistoricfauna.init.PFCustomDamageSource;

public class BleedingEffect extends Effect {
	
	public BleedingEffect(EffectType type, int liquidColor) {
		super(type, liquidColor);
	}
	
	@Override
	public void performEffect(LivingEntity entityLivingBase, int amplifier) {
		if (entityLivingBase.getMotion().x !=  0 && entityLivingBase.getMotion().y != 0 && entityLivingBase.getMotion().z != 0) {
			entityLivingBase.attackEntityFrom(PFCustomDamageSource.BLEEDING, 1.0F);
		}
	}
	
	public boolean isReady(int duration, int amplifier) {
		int k = 25 >> amplifier;
		if (k > 0) {
			return duration % k == 0;
		} else {
			return true;
		}
	}

}
