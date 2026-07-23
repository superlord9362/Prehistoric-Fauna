package superlord.prehistoricfauna.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.gui.CamptosaurusMenu;
import superlord.prehistoricfauna.client.gui.SarahsaurusMenu;
import superlord.prehistoricfauna.client.gui.ShunosaurusMenu;
import superlord.prehistoricfauna.common.entity.block.container.PaleontologyTableMenu;
import superlord.prehistoricfauna.common.entity.block.container.PaleoscribeContainer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camptosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Shunosaurus;

public class PFContainers {

	public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<MenuType<PaleoscribeContainer>> PALEOSCRIBE = REGISTER.register("paleoscribe", () -> new MenuType<>(PaleoscribeContainer::new, FeatureFlags.VANILLA_SET));
	public static final RegistryObject<MenuType<PaleontologyTableMenu>> PALEONTOLOGY_TABLE = REGISTER.register("paleontology_table", () -> IForgeMenuType.create(PaleontologyTableMenu::new));
	public static final RegistryObject<MenuType<SarahsaurusMenu>> SARAHSAURUS = REGISTER.register("sarahsaurus", () -> IForgeMenuType.create((windowId, inv, data) -> {
		int entityId = data.readInt();
		Entity entity = inv.player.level().getEntity(entityId);
		if (entity instanceof Sarahsaurus sarahsaurus) {
			return new SarahsaurusMenu(windowId, inv, sarahsaurus.inventory, sarahsaurus);
		}
		return null;
	}));
	public static final RegistryObject<MenuType<CamptosaurusMenu>> CAMPTOSAURUS = REGISTER.register("camptosaurus", () -> IForgeMenuType.create((windowId, inv, data) -> {
		int entityId = data.readInt();
		Entity entity = inv.player.level().getEntity(entityId);
		if (entity instanceof Camptosaurus camptosaurus) {
			return new CamptosaurusMenu(windowId, inv, camptosaurus.inventory, camptosaurus);
		}
		return null;
	}));
	public static final RegistryObject<MenuType<ShunosaurusMenu>> SHUNOSAURUS = REGISTER.register("shunosaurus", () -> IForgeMenuType.create((windowId, inv, data) -> {
		int entityId = data.readInt();
		Entity entity = inv.player.level().getEntity(entityId);
		if (entity instanceof Shunosaurus shunosaurus) {
			return new ShunosaurusMenu(windowId, inv, shunosaurus.inventory, shunosaurus);
		}
		return null;
	}));
}
