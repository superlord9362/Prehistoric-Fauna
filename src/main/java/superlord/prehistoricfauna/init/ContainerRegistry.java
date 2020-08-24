package superlord.prehistoricfauna.init;

import java.lang.reflect.Field;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.inventory.ContainerPaleoscribe;

@EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerRegistry {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final ContainerType PALEOSCRIBE_CONTAINER = register(new ContainerType(ContainerPaleoscribe::new), "paleoscribe");
	
	@SuppressWarnings("rawtypes")
	public static ContainerType register(ContainerType type, String name) {
		type.setRegistryName(name);
		return type;
	}
	
	@SuppressWarnings("rawtypes")
	@SubscribeEvent
	public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
		try {
			for (Field f : ContainerRegistry.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof ContainerType) {
					event.getRegistry().register((ContainerType) obj);
				} else if (obj instanceof ContainerType[]) {
					for (ContainerType container : (ContainerType[]) obj) {
						event.getRegistry().register(container);
					}
				}
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
