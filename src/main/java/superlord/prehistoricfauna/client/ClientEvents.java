package superlord.prehistoricfauna.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.gui.GuiPaleo;
import superlord.prehistoricfauna.client.gui.GuiPaleontologyTable;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkullModel;
import superlord.prehistoricfauna.client.render.fossil.triassic.HerrerasaurusSkullRenderer;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFContainers;
import superlord.prehistoricfauna.init.PFEntities;
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
        MenuScreens.register(PFContainers.PALEOSCRIBE.get(), GuiPaleo::new);
        MenuScreens.register(PFContainers.PALEONTOLOGY_TABLE.get(), GuiPaleontologyTable::new);
		ClientProxy.setupBlockRenders();
	}
	
	public static ModelLayerLocation HERRERASAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skull"), "herrerasaurus_skull");

	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PFEntities.HERRERASAURUS_SKULL.get(), HerrerasaurusSkullRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(HERRERASAURUS_SKULL, HerrerasaurusSkullModel::createBodyLayer);
	}
	
}
