package superlord.prehistoricfauna.common.util;

import java.util.function.Supplier;

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
	
	public <I extends Item> RegistryObject<I> createItem(String name, Supplier<? extends I> supplier) {
		return this.deferredRegister.register(name, supplier);
	}

	
}
