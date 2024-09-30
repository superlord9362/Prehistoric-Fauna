package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import superlord.prehistoricfauna.init.PFItems;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Inject(method = "Lnet/minecraft/world/entity/LivingEntity;getEquipmentSlotForItem(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/entity/EquipmentSlot;", at = @At("HEAD"), cancellable = true)
	private static void getEquipmentSlotForItem(ItemStack stack, CallbackInfoReturnable ci) {
		if (stack.is(PFItems.CARVED_TUBER.get())) {
			ci.setReturnValue(EquipmentSlot.HEAD);
		}
	}
}
