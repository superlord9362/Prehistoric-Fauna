package superlord.prehistoricfauna.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.util.IHasModel;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.entity.*;
import superlord.prehistoricfauna.init.ModItems;

public class PrehistoricEntityItem extends Item implements IHasModel {

	public final String resourceName;

	protected EntityType type;



	public PrehistoricEntityItem(String name, EntityType type) {

		super();

		this.type = type;
		setUnlocalizedName(name);

		this.resourceName = type.resourceName + "_" + name;
		setRegistryName(name);
		
		this.setCreativeTab(Main.tabEgg);
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