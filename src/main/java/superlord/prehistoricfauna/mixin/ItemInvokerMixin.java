package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

@Mixin(Item.class)
public interface ItemInvokerMixin {
	@Invoker
	boolean callAllowdedIn(CreativeModeTab group);
}

