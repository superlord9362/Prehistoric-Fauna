package superlord.prehistoricfauna.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.init.PFBlocks;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy { 
	
	public void init() {
	}
	
	public static void setupBlockRenders() {
		RenderType cutoutRenderType = RenderType.cutout();
		
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HORSETAIL.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TALL_HORSETAIL.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.OSMUNDA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TALL_OSMUNDA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.CLUBMOSS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.MARCHANTIA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_LEAVES.get(), cutoutRenderType);
	}

}
