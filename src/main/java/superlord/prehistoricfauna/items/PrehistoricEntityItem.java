package superlord.prehistoricfauna.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.util.IHasModel;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.entity.*;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.tab.PFTabRegistry;

public class PrehistoricEntityItem extends Item implements IHasModel {

	public final String resourceName;

	protected EntityType type;



	public PrehistoricEntityItem(String name, EntityType type) {

		super();

		this.type = type;

		this.resourceName = type.resourceName + "_" + name;
		setRegistryName(name);
		setTranslationKey(name);
		this.setCreativeTab(PFTabRegistry.EGG);
		ModItems.ITEMS.add(this);

	}



    public String getResource(ResourceLocation registryName) {

        return resourceName;

    }



	@Override
	public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}