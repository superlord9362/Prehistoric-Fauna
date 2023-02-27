package superlord.prehistoricfauna.client;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFWoodTypes;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	
	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		BlockEntityRenderers.register(PFBlockEntities.SIGN.get(), SignRenderer::new);
        event.enqueueWork(() -> {
        	Sheets.addWoodType(PFWoodTypes.METASEQUOIA);
        	Sheets.addWoodType(PFWoodTypes.ARAUCARIA);
        	Sheets.addWoodType(PFWoodTypes.PROTOPICEOXYLON);
        	Sheets.addWoodType(PFWoodTypes.LIRIODENDRITES);
        	Sheets.addWoodType(PFWoodTypes.ZAMITES);
        	Sheets.addWoodType(PFWoodTypes.PROTOJUNIPEROXYLON);
        	Sheets.addWoodType(PFWoodTypes.AGATHOXYLON);
        	Sheets.addWoodType(PFWoodTypes.HEIDIPHYLLUM);
        });
		ClientProxy.setupBlockRenders();
	}

}
