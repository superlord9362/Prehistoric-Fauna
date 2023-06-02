package superlord.prehistoricfauna.common;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CommonProxy {

	public void init() {
	}

	public void openPaleopediaGui(ItemStack book) {

	}
	
	public boolean shouldSeePaleopediaContents() {
		return true;
	}
	
	public BlockEntity getReferencedBE() {
		return null;
	}
	
	public void setReferencedBE(BlockEntity tileentity) {
		
	}
	
	public Player getClientSidePlayer() {
		return null;
	}
	
	public Object getArmorRenderProperties() {
        return null;
    }

}
