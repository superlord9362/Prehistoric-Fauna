package superlord.prehistoricfauna.common;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.ServerEvents;
import superlord.prehistoricfauna.init.PFStructures;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

	public void init() {
		
	}
	
	public void openPaleopediaGui(ItemStack book) {
		
	}
	
	public boolean shouldSeePaleopediaContents() {
		return true;
	}
	
	public Object getFontRenderer() {
		return null;
	}
	
	public TileEntity getReferencedTE() {
		return null;
	}
	
	public void setReferencedTE(TileEntity tileentity) {
		
	}
	
	public PlayerEntity getClientSidePlayer() {
		return null;
	}
	
    public void setup() {
        MinecraftForge.EVENT_BUS.register(new ServerEvents());
    }

	@SubscribeEvent
	public static void registerStructures(final RegistryEvent.Register<Structure<?>> event) {
		for (Structure<?> feature : PFStructures.structureFeatureList) {
			event.getRegistry().register(feature);
		}
	}
}
