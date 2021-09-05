package superlord.prehistoricfauna.client.util;

import net.minecraft.world.storage.ServerWorldInfo;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerWorldInfo.class)
public class WarningDispersal {
	/*
	@Inject(method = "getLifecycle", at = @At("HEAD"), cancellable = true)
    private void forceStableLifeCycle(CallbackInfoReturnable<Lifecycle> cir) {
        cir.setReturnValue(Lifecycle.stable());
    }
*/
}
