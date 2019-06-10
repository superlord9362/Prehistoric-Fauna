package superlord.prehistoricfauna.util.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import superlord.prehistoricfauna.blocks.TileEntityCultureVat;

public class TileEntityRegistry {

	@SuppressWarnings("deprecation")
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityCultureVat.class, "culture_vat");
	}
	
}
