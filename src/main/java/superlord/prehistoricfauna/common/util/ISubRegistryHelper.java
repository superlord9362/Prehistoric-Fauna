package superlord.prehistoricfauna.common.util;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public interface ISubRegistryHelper<T> {

	RegistryHelper getParent();

	DeferredRegister<T> getDeferredRegister();

	void register(IEventBus eventBus);

}
