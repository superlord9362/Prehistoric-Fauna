package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {

	@Shadow @Final private PanoramaRenderer panorama;

	@Inject(method = "Lnet/minecraft/client/gui/screens/TitleScreen;init()V", at = @At("RETURN"))
	private void onInit(CallbackInfo ci) {
		if (PrehistoricFaunaConfig.customMenuBackground) {
			CubeMap CUBE_MAP = new CubeMap(new ResourceLocation(PrehistoricFauna.MOD_ID, "panoramas/yixian/panorama"));
			this.panorama = new PanoramaRenderer(CUBE_MAP);
		}
	}

}
