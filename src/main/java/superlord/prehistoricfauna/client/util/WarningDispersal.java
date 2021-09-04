package superlord.prehistoricfauna.client.util;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import com.mojang.serialization.Lifecycle;

import net.minecraft.world.storage.ServerWorldInfo;

@Mixin(ServerWorldInfo.class)
public class WarningDispersal {
	
	@Inject(method = "getLifecycle", at = @At("HEAD"), cancellable = true)
    private void forceStableLifeCycle(CallbackInfoReturnable<Lifecycle> cir) {
        cir.setReturnValue(Lifecycle.stable());
    }

}
