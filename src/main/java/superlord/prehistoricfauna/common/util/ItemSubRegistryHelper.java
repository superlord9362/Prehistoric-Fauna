package superlord.prehistoricfauna.common.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemSubRegistryHelper extends AbstractSubRegistryHelper<Item> {
	
	public ItemSubRegistryHelper(RegistryHelper parent, DeferredRegister<Item> deferredRegister) {
		super(parent, deferredRegister);
	}

	public ItemSubRegistryHelper(RegistryHelper parent) {
		super(parent, DeferredRegister.create(ForgeRegistries.ITEMS, parent.getModId()));
	}
	
	public RegistryObject<Item> createCompatItem(String modId, String name, Item.Properties properties, CreativeModeTab group) {
		return this.deferredRegister.register(name, () -> new Item(properties.tab(areModsLoaded(modId) ? group : null)));
	}
	
	public RegistryObject<Item> createCompatItem(String name, Item.Properties properties, CreativeModeTab group, String... modIds) {
		return this.deferredRegister.register(name, () -> new Item(properties.tab(areModsLoaded(modIds) ? group : null)));
	}

	
}
