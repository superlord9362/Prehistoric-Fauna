package superlord.prehistoricfauna.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.container.PaleontologyTableMenu;
import superlord.prehistoricfauna.common.entity.block.container.PaleoscribeContainer;

public class PFContainers {

	public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<MenuType<PaleoscribeContainer>> PALEOSCRIBE = REGISTER.register("paleoscribe", () -> new MenuType<>(PaleoscribeContainer::new));
	public static final RegistryObject<MenuType<PaleontologyTableMenu>> PALEONTOLOGY_TABLE = REGISTER.register("paleontology_table", () -> IForgeMenuType.create(PaleontologyTableMenu::new));

}
