package superlord.prehistoricfauna.util.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import superlord.prehistoricfauna.blocks.TileEntityDNAExtractor;

public class TileEntityRegistry {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDNAExtractor.class, "dna_decoder");
	}
	
}
