package superlord.prehistoricfauna.util;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Maps;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import superlord.prehistoricfauna.entity.tile.PaleopaintingType;

public abstract class PaintingRegistry<T> extends Registry<T>{

	private static final Map<ResourceLocation, Supplier<?>> LOCATION_TO_SUPPLIER = Maps.newLinkedHashMap();
	public static final MutableRegistry<MutableRegistry<?>> REGISTRY = new SimpleRegistry<>();

	@Deprecated public static final DefaultedRegistry<PaleopaintingType> PALEOPAINTING = forgeDefaulted("paleopainting", PaleopaintingType.class, () -> {
		return PaleopaintingType.DYNASTIC;
	});

	private static <T, R extends MutableRegistry<T>> R register(String p_222939_0_, R p_222939_1_, Supplier<T> p_222939_2_) {
		ResourceLocation resourcelocation = new ResourceLocation(p_222939_0_);
		LOCATION_TO_SUPPLIER.put(resourcelocation, p_222939_2_);
		return (R)(REGISTRY.register(resourcelocation, p_222939_1_));
	}

	private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> DefaultedRegistry<T> forgeDefaulted(String name, Class<? super T> cls, Supplier<T> def) {
		return PaintingRegistry.<T, DefaultedRegistry<T>>register(name, net.minecraftforge.registries.GameData.<T>getWrapperDefaulted(cls), def);
	}

}
