package superlord.prehistoricfauna.common.util;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class AbstractSubRegistryHelper<T extends IForgeRegistryEntry<T>> implements ISubRegistryHelper<T> {
	protected final RegistryHelper parent;
	protected final DeferredRegister<T> deferredRegister;

	public AbstractSubRegistryHelper(RegistryHelper parent, DeferredRegister<T> deferredRegister) {
		this.parent = parent;
		this.deferredRegister = deferredRegister;
	}

	@Override
	public RegistryHelper getParent() {
		return this.parent;
	}

	@Override
	public DeferredRegister<T> getDeferredRegister() {
		return this.deferredRegister;
	}

	@Override
	public void register(IEventBus eventBus) {
		this.getDeferredRegister().register(eventBus);
	}
	
	public static boolean areModsLoaded(String... modIds) {
		if ("true".equals(System.getProperty("prehistoricfauna.indev")))
			return true;
		ModList modList = ModList.get();
		for (String mod : modIds)
			if (!modList.isLoaded(mod))
				return false;
		return true;
	}
}