package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.saveddata.maps.MapDecoration;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFMapTypes;

@Mixin(MapDecoration.class)
public abstract class MapDecorationMixin {

	@Shadow public abstract MapDecoration.Type getType();
	
	@Inject(method= {"Lnet/minecraft/world/level/saveddata/maps/MapDecoration;render(I)Z"},remap=false,cancellable=true,at=@At(value="HEAD"))
	private void pf_render(int index, CallbackInfoReturnable<Boolean> cir) {
		if(this.getType() == PFMapTypes.TIME_TEMPLE) {
			PrehistoricFauna.PROXY.renderVanillaMapDecoration((MapDecoration)(Object)this, index);
			cir.setReturnValue(true);
		}
	}
	
}
