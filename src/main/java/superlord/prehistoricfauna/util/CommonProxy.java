package superlord.prehistoricfauna.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
	
}
