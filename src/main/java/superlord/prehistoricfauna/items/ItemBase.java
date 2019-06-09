package superlord.prehistoricfauna.items;

import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.tab.PFTabRegistry;
import superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(PFTabRegistry.NORMAL);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
