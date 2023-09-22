package superlord.prehistoricfauna.common.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import superlord.prehistoricfauna.init.PFEffects;

public class TyrannosaurToothSwordItem extends SwordItem {

	public TyrannosaurToothSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}

	public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
		p_43278_.hurtAndBreak(1, p_43280_, (p_43296_) -> {
			p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		p_43279_.addEffect(new MobEffectInstance(PFEffects.BLEEDING.get(), 100));
		return true;
	}

}
