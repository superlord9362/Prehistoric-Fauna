package superlord.prehistoricfauna.items;

import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.tab.PFTabRegistry;

public class ItemFossil extends ItemBase {

	public ItemFossil(String name) {
		super(name);
        setCreativeTab(PFTabRegistry.NORMAL);
	}

}
