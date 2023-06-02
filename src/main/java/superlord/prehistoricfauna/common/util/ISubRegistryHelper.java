package superlord.prehistoricfauna.common.util;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ISubRegistryHelper<T extends IForgeRegistryEntry<T>> {

	RegistryHelper getParent();

	DeferredRegister<T> getDeferredRegister();

	void register(IEventBus eventBus);

}
