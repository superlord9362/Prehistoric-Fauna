package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderManAngerEvent;
import superlord.prehistoricfauna.init.PFItems;

@Mixin(ForgeHooks.class)
public class EnderMaskMixin {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Inject(method = "Lnet/minecraftforge/common/ForgeHooks;shouldSuppressEnderManAnger(Lnet/minecraft/world/entity/monster/EnderMan;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true, remap = false)
	private static void shouldSuppressEnderManAnger(EnderMan enderMan, Player player, ItemStack stack, CallbackInfoReturnable ci) {
		ci.setReturnValue(stack.isEnderMask(player, enderMan) || stack.is(PFItems.CARVED_TUBER.get()) || MinecraftForge.EVENT_BUS.post(new EnderManAngerEvent(enderMan, player)));
	}

}
