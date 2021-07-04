package superlord.prehistoricfauna.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.tile.PaleontologyTableContainer;
import superlord.prehistoricfauna.common.entities.tile.PaleoscribeContainer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFContainers {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, PrehistoricFauna.MOD_ID);
	
	
	public static final RegistryObject<ContainerType<PaleontologyTableContainer>> PALEONTOLOGY_TABLE = CONTAINER_TYPES.register("paleontology_table_container", () -> IForgeContainerType.create(PaleontologyTableContainer::new));

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static final ContainerType PALEOSCRIBE_CONTAINER = register(new ContainerType(PaleoscribeContainer::new), "paleoscribe_container");
    

    @SuppressWarnings("rawtypes")
	public static ContainerType register(ContainerType type, String name) {
        type.setRegistryName(name);
        return type;
    }

    @SuppressWarnings("rawtypes")
	@SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
        try {
            for (Field f : PFContainers.class.getDeclaredFields()) {
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
