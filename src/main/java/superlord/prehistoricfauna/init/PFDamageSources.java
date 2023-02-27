package superlord.prehistoricfauna.init;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class PFDamageSources {
	
	public static final DamageSource HENOSTONE_TRAP = new DamageCustomDeathMessage("trap");

	static class DamageCustomDeathMessage extends DamageSource {
		
		public DamageCustomDeathMessage(String damageTypeIn) {
			super(damageTypeIn);
		}
		
		public Component getDeathMessage(LivingEntity entityLivingBaseIn) {
			LivingEntity livingEntity = entityLivingBaseIn.getKillCredit();
			String s = "death.attack." + this.msgId;
			int index = entityLivingBaseIn.getRandom().nextInt(3);
			String s1 = s + "." + index;
			String s2 = s + ".attack_" + index;
			return livingEntity != null ? new TranslatableComponent(s2, entityLivingBaseIn.getDisplayName(), livingEntity.getDisplayName()) : new TranslatableComponent(s1, entityLivingBaseIn.getDisplayName());
		}
		
	}
	
}
