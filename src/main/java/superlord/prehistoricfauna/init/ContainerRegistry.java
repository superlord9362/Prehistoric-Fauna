package superlord.prehistoricfauna.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.PaleontologyTableContainer;

public class ContainerRegistry {
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, PrehistoricFauna.MODID);
	
	
	public static final RegistryObject<ContainerType<PaleontologyTableContainer>> PALEONTOLOGY_TABLE = CONTAINER_TYPES.register("paleontology_table_container", () -> IForgeContainerType.create(PaleontologyTableContainer::new));

}
